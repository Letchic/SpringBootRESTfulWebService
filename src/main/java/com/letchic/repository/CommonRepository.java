package com.letchic.repository;

import com.letchic.model.Common;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<E extends Common> extends JpaRepository<E, Integer> {
}