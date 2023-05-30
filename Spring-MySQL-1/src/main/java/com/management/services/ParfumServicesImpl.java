package com.management.services;

import com.management.entities.Parfum;
import com.management.repositories.ParfumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParfumServicesImpl implements ParfumService {
    @Autowired
    ParfumRepository parfumRepository;
    @Override
    public Parfum saveParfum(Parfum parfum) {
        return parfumRepository.save(parfum);
    }

    @Override
    public Parfum updateParfum(Parfum parfum) {
        return parfumRepository.save(parfum);
    }

    @Override
    public Parfum getParfum(Long id) {
        return parfumRepository.findById(id).get();
    }

    @Override
    public List<Parfum> getAllParfums() {
        return parfumRepository.findAll();
    }

    @Override
    public void deleteParfumById(Long id) {
        parfumRepository.deleteById(id);
    }

    @Override
    public void deleteAllParfums() {
        parfumRepository.deleteAll();
    }
}
