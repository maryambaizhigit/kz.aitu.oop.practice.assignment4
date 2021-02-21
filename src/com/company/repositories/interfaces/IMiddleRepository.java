package com.company.repositories.interfaces;

//import the path to the class
import com.company.entities.Middle;

import java.util.List;

/**
 * IMiddleRepository interface class that has createMiddle, getMiddle, getAllMiddles methods
 */
public interface IMiddleRepository {
    boolean createMiddle(Middle mid);
    Middle getMiddle(int id);
    List<Middle> getAllMiddles();
}