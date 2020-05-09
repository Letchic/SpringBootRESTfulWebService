package com.letchic.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public void setId(int id) {
        this.id = id;
    }
}