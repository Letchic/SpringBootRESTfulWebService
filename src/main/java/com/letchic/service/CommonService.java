package com.letchic.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.letchic.exception.NoFoundException;
import com.letchic.model.Common;
import org.springframework.dao.EmptyResultDataAccessException;
import java.util.List;


public interface CommonService<E extends Common> {

    List<E> findAll();

    E findById(int id) throws NoFoundException;

    void deleteById(int id) throws EmptyResultDataAccessException;

    void create(E entity);

    E updateById(int id,E entity);

    E patch(int id, JsonPatch patch) throws NoFoundException, JsonPatchException, JsonProcessingException;
}