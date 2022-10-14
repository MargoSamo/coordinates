package com.mariia.coordinates.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "factvalues")
public class FactValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double latitude;
    private double longitude;

}
