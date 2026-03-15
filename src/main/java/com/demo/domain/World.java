package com.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class World {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNumber;

    private String email;
    private String address;
    // @ManyToOne
    // private Hello hello;

    @Transient
    private String keyword;

}
