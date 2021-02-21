package com.company.controllers;

//import the paths to the classes
import com.company.entities.Top;
import com.company.repositories.interfaces.ITopRepository;

import java.util.List;

public class TopController {
    private final ITopRepository repo;

    /**
     * Overloaded constructor with default parameter value
     */
    public TopController(ITopRepository repo) {
        this.repo = repo;
    }

    /**
     * Overloaded method with 4 default parameter values
     * @return String value
     */
    public String createTop(String name, String surname, String gender, String position) {
        boolean male = (gender.toLowerCase().equals("male"));
        Top top = new Top(name, surname, male, position);
        boolean created = repo.createTop(top);
        return (created ? "Top level employee creation was failed!" : "Top level employee was created!");
    }

    /**
     * Overloaded method with default parameter values
     * @return String value
     */
    public String getTop(int id) {
        Top top = repo.getTop(id);
        return (top == null ? "Top level employee was not found!" : top.toString());
    }

    /**
     * Method, which returns all top level executives
     * @return String value
     */
    public String getAllTops() {
        List<Top> tops = repo.getAllTops();
        return tops.toString();
    }
}