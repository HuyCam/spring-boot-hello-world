package com.example.springhelloworld.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    // one to one mapping means,
    // one employee stays at one address only
    @OneToOne
    private Address address;
}
