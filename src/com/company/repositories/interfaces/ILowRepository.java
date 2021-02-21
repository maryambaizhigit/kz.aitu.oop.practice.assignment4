package com.company.repositories.interfaces;

//import the path to the class
import com.company.entities.Low;
import java.util.List;
/**
 * ILowRepository interface class that has createLow, getLow, getAllLows methods
 */
public interface ILowRepository {
    boolean createLow(Low low);
    Low getLow(int id);
    List<Low> getAllLows();
}