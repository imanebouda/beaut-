package com.management.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMagasin;
    private String nameMagasin;


}