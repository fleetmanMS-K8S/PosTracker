package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "POS_TABLE")
public class PosEnt implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String vehiclename;

    @Column(name="lat", columnDefinition="Decimal(19,7)")
    private BigDecimal lat;

    @Column(name="longitude", columnDefinition="Decimal(19,7)")
    private BigDecimal longitude;


}
