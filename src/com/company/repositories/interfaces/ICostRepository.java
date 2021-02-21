package com.company.repositories.interfaces;

//import the path to the class
import com.company.entities.Cost;

import java.util.List;

/**
 * ICostRepository interface class that has getAllCosts method
 */
public interface ICostRepository {
    boolean createCost(Cost cost);
    Cost getCost(int total);
    List<Cost> getAllCosts();
}
