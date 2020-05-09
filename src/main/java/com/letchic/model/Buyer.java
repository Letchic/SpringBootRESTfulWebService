package com.letchic.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "buyers")

public class Buyer extends Common {
    private String lastname;
    private String district;
    private double discount;
}
