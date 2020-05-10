package com.letchic.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.letchic.exception.NoFoundException;
import com.letchic.model.Common;
import com.letchic.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public abstract class AbstractService<E extends Common, R extends CommonRepository<E>> implements CommonService<E> {

    @Autowired
    R repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override

    public E findById(int id) throws NoFoundException {
        return repository.findById(id).orElseThrow(NoFoundException::new);
    }
        @Override
    public void deleteById(int id) {
            repository.deleteById(id);
    }

    @Override
    public void create(E entity) {
        repository.save(entity);
    }

    @Override
    public E updateById(int id, E entity) {
            entity.setId(id);
            repository.save(entity);
            return entity;
    }

    @Override
    public E patch(int id, JsonPatch patch) throws NoFoundException, JsonPatchException, JsonProcessingException {
        E entity = repository.findById(id).orElseThrow(NoFoundException::new);
        E entityPatched = applyPatchToEntity(patch, entity);
        updateById(id, entityPatched);
        return entityPatched;
    }

    @SuppressWarnings("unchecked")
    private E applyPatchToEntity(
            JsonPatch patch, E targetEntity) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetEntity, JsonNode.class));

        return objectMapper.treeToValue(patched, (Class<E>) targetEntity.getClass());
    }
}