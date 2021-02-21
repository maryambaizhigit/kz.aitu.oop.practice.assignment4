package com.company.controllers;

//import the paths to the classes
import com.company.entities.Cost;
import com.company.repositories.interfaces.ICostRepository;

import java.util.List;

public class CostController {
    private final ICostRepository repo;
    /**
     * Parametrized constructor
     */
    public CostController(ICostRepository repo) {
        this.repo = repo;
    }
    /**
     * Method, which returns the total cost of the company
     */
    public List<Cost> getAllCosts() {
        List<Cost> costs = repo.getAllCosts();
        return costs;
    }
}
