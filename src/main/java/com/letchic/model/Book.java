package com.letchic.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "books")

public class Book extends Common{
    private String title;
    private Double price;
    private String warehouse;
    private int quantity;
}
