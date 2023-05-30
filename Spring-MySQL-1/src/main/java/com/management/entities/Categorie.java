package com.management.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;
    private String nameCategorie;



    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idCat +
                ", nameProduct='" + nameCategorie + '\''
               ;
    }




    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }

    public void setNameCategorie(String nameCategorie) {
        this.nameCategorie = nameCategorie;
    }



    public Long getIdCat() {
        return idCat;
    }

    public String getNameCategorie() {
        return nameCategorie;
    }


}
