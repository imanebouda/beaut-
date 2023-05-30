package com.management.controllers;

import com.management.entities.Categorie;
import com.management.entities.Parfum;
import com.management.services.CategorieService;
import com.management.services.ParfumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ParfumController {
    @Autowired
    CategorieService categorieService;
    @Autowired
    ParfumService parfumService;

    @RequestMapping("/createParfum")
    public String CreateParfum(){
        return "CreateParfum";
    }
    @RequestMapping("/saveParfum")
    public String saveParfum(
            @ModelAttribute Parfum parfum, BindingResult bindingResult, @RequestParam("idcat") Long id) {

        Categorie cat=categorieService.getCategorie(id);
        parfum.setCategorie(cat);
        Parfum memo =parfumService.saveParfum(parfum);

        return "CreateParfum";

    }
    @RequestMapping("/parfumsList")
    public String ParfumList(ModelMap modelMap){

        List<Parfum> parfumsController=parfumService.getAllParfums();
        modelMap.addAttribute("parfums",parfumsController);
        return "ParfumList";
    }

    @RequestMapping("/deleteParfum")
    public String DeleteParfum(@RequestParam("id") Long id){
        parfumService.deleteParfumById(id);
        return "redirect:/parfumsList";
    }

    @RequestMapping("/showParfum")
    public String showParfum(@RequestParam("id") Long id,ModelMap modelMap){
        Parfum parfumController = parfumService.getParfum(id);
        modelMap.addAttribute("parfum",parfumController);
        return "EditParfum";
    }


    @RequestMapping("/updateParfum")
    public String updateParfum(
            @ModelAttribute("parfum") Parfum parfum){
        parfumService.saveParfum(parfum);
        return "CreateParfum";
    }}
