package com.company.controllers;

//import the paths to the classes
import com.company.entities.Middle;
import com.company.repositories.interfaces.IMiddleRepository;

import java.util.List;

public class MiddleController {
    private final IMiddleRepository repo;

    /**
     * Parameterized constructor
     */
    public MiddleController(IMiddleRepository repo) {
        this.repo = repo;
    }

    /**
     * Overloaded method with default parameter values
     * @return String value
     */
    public String createMiddle(String name, String surname, String gender, String position) {
        boolean male = (gender.toLowerCase().equals("male"));
        Middle middle = new Middle(name, surname, male, position);
        boolean created = repo.createMiddle(middle);
        return (created ? "Middle level employee creation was failed!" : "Middle level employee was created!");
    }

    /**
     * Overloaded method with default parameter values
     * @return String value
     */
    public String getMiddle(int id) {
        Middle middle = repo.getMiddle(id);
        return (middle == null ? "Top level employee was not found!" : middle.toString());
    }

    /**
     * Method, which returns all middle level executives
     * @return String value
     */
    public String getAllMiddles() {
        List<Middle> middles = repo.getAllMiddles();
        return middles.toString();
    }
}