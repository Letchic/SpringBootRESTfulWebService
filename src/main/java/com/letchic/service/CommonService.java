package com.letchic.service;

import com.letchic.exception.NoFoundException;
import com.letchic.model.Common;
import java.util.List;
import java.util.Optional;

public interface CommonService<E extends Common> {

    List<E> findAll();

    Optional<E> findById(int id);

    void deleteById(int id) ;

    void create(E entity);

    E updateById(int id,E entity);
}