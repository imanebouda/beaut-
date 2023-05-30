package com.management.controllers;

import com.management.entities.Categorie;
import com.management.entities.Product;
import com.management.services.CategorieService;
import com.management.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller

public class CategorieController {

    @Autowired
    CategorieService categorieService;

    @RequestMapping("/createCategorie")
    public String createCategorie(){
        return "CreateCategorie";
    }
    @RequestMapping("/saveCategorie")
    public String saveCategorie(
            @Valid Categorie categorie, BindingResult bindingResult)

    {
        if (bindingResult.hasErrors()) return "CreateCategorie";
        Categorie memo =categorieService.saveCategorie(categorie);

        return "CreateCategorie";

    }


    @RequestMapping("/categoriesList")
    public String categorieList(ModelMap modelMap){

        List<Categorie> categoriesController=categorieService.getAllCategories();
        modelMap.addAttribute("categories",categoriesController);
        return "CategoriesList";
    }


/*
    @RequestMapping("/deleteProduct")
        public String deleteCategorie(@RequestParam("id") Long id, ModelMap modelMap){
        categorieService.deleteCategorieById(id);
        List<Product> categoriesController=categorieService.getAllCategories();
        modelMap.addAttribute("categoriesJsp",categoriesController);
        return "CategoriesList";
    }

    @RequestMapping("/showProduct")
    public String showProduct(@RequestParam("id") Long id,ModelMap modelMap){
        Product productController = productService.getProduct(id);
        modelMap.addAttribute("productJsp",productController);
        return "EditProduct";
    }


    @RequestMapping("/updateProduct")
    public String updateProduct(
            @ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "CreateProduct";
    }




*/





}
