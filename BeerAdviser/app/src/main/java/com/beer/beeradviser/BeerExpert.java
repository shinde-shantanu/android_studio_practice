package com.beer.beeradviser;

/**
 * Created by Shantanu Shinde on 13-06-2018.
 */
import java.util.*;

public class BeerExpert {
    List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();
        if (color.equals("Amber")) {
            brands.add("Jack Amber");
            brands.add("Red Moose");
        } else{
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        return brands;
    }
}
