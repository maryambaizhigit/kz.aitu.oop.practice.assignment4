package com.company.repositories.interfaces;

//import the path to the class
import com.company.entities.Top;

import java.util.List;

/**
 * ITopRepository interface class that has createTop, getTop, getAllTops methods
 */
public interface ITopRepository {
    boolean createTop(Top top);
    Top getTop(int id);
    List<Top> getAllTops();
}