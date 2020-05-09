package com.letchic.service;

import com.letchic.model.Common;
import com.letchic.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E extends Common, R extends CommonRepository<E>> implements CommonService<E> {

    @Autowired
    R repository;

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<E> findById(int id) {
        return repository.findById(id);
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
}