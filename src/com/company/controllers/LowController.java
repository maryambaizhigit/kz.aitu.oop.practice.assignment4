package com.company.controllers;

//import the paths to the classes
import com.company.entities.Low;
import com.company.repositories.interfaces.ILowRepository;

import java.util.List;

public class LowController {
    private final ILowRepository repo;
    /**
     * Constructor with default parameter value
     */
    public LowController(ILowRepository repo) {
        this.repo = repo;
    }

    /**
     * Method with default parameter values
     * @return String value
     */
    public String createLow(String name, String surname, String gender, String position) {
        boolean male = (gender.toLowerCase().equals("male"));
        Low low = new Low(name, surname, male, position);
        boolean created = repo.createLow(low);
        return (created ? "Low level employee creation was failed!" : "Low level employee was created!");
    }

    /**
     * Method, which returns low level value
     * @return String value
     */
    public String getLow(int id) {
        Low low = repo.getLow(id);
        return (low == null ? "Low level employee was not found!" : low.toString());
    }

    /**
     * Method, which returns all low level executives
     * @return String value
     */
    public String getAllLows() {
        List<Low> lows = repo.getAllLows();
        return lows.toString();
    }
}