package com.management.services;

import com.management.entities.Categorie;
import com.management.entities.Product;
import com.management.repositories.CategorieRepository;
import com.management.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;





@Service
public class CategorieServiceImpl implements CategorieService{
    @Autowired
    CategorieRepository categorieRepository;
    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie UpdateCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public void deleteCategorieById(Long id) {
        categorieRepository.deleteById(id);

    }

    @Override
    public void deleteAllCategorie() {
        categorieRepository.deleteAll();
    }
}
