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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategorieService categorieService;

    @RequestMapping("/createProduct")
    public String createProduct() {
        return "CreateProduct";
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, @RequestParam("idcat") Long id) {

        Categorie cat=categorieService.getCategorie(id);
        product.setCategorie(cat);
        Product memo = productService.saveProduct(product);

        return "CreateProduct";

    }

    @RequestMapping("/productsList")
    public String productList(ModelMap modelMap) {

        List<Product> productsController = productService.getAllProducts();
        modelMap.addAttribute("productsJsp", productsController);
        return "ProductsList";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Long id, ModelMap modelMap) {
        productService.deleteProductById(id);
        List<Product> productsController = productService.getAllProducts();
        modelMap.addAttribute("productsJsp", productsController);
        return "ProductsList";
    }

    @RequestMapping("/showProduct")
    public String showProduct(@RequestParam("id") Long id, ModelMap modelMap) {
        Product productController = productService.getProduct(id);
        modelMap.addAttribute("productJsp", productController);
        return "EditProduct";
    }


    @RequestMapping("/updateProduct")
    public String updateProduct(
            @ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "CreateProduct";
    }


}
