package com.letchic.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="shop")
public class Shop extends Common {

    private String name;
    private String district;
    private Double commission;

}
