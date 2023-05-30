package com.management.services;


import com.management.entities.Categorie;
import com.management.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategorieService {

    Categorie saveCategorie(Categorie categorie);
    Categorie UpdateCategorie(Categorie categorie);
    Categorie getCategorie(Long id);
    List<Categorie> getAllCategories();
    void deleteCategorieById(Long id);
    void deleteAllCategorie();
}

