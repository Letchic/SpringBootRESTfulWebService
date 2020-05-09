package com.letchic.model;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name="purchases")
public class Purchase extends Common{
    private Date saledate;
    @ManyToOne
    private Shop seller;
    @ManyToOne
    private Buyer buyer;
    @ManyToOne
    private Book book;
    private int quantity;
    @Column(name = "sale_cost", insertable = false, updatable = false)
    private double saleCost;
}