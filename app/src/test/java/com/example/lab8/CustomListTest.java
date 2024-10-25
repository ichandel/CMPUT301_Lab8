package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.countCities();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.countCities(),listSize + 1);
    }

    /**
     * create a city
     * add city to list
     * check if the city exists in the list
     * check if a new unadded city exists in the list
     */
    @Test
    void testHasCity() {
        list = MockCityList();

        City mockCity = new City("Estevan", "SK");
        // This line checks if the first city is in the cityList
        list.addCity(mockCity);

        assertTrue(list.hasCity(mockCity));

        // Asserts that the newly created city object is not in the list
        assertFalse(list.hasCity(new City("Toronto", "Ontario")));

    }

    /**
     * create a city
     * add city to list
     * check if the city exists in the list
     * delete city from list
     * check if the city exists in the list
     */
    @Test
    void testDeleteCity() {
        list = MockCityList();
        City mockCity = new City("Estevan", "SK");
        list.addCity(mockCity);
        assertTrue(list.hasCity(mockCity));
        list.deleteCity(mockCity);
        assertFalse(list.hasCity(mockCity));
    }

    /**
     * create multiple cities
     * add cities to list and check list size after each addition
     * remove cities and check list size after each removal
     */
    @Test
    void testCountCities() {
        list = MockCityList();
        assertEquals(list.countCities(), 0);
        City city1 = new City("Estevan", "SK");
        City city2 = new City("Toronto", "Ontario");
        City city3 = new City("Montreal", "Quebec");
        list.addCity(city1);
        assertEquals(list.countCities(), 1);
        list.addCity(city2);
        assertEquals(list.countCities(), 2);
        list.addCity(city3);
        assertEquals(list.countCities(), 3);
        list.deleteCity(city2);
        assertEquals(list.countCities(), 2);
        list.deleteCity(city1);
        assertEquals(list.countCities(), 1);
        list.deleteCity(city3);
        assertEquals(list.countCities(), 0);

    }
}
