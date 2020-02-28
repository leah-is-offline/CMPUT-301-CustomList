package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /****assert True tests if the parameter passed returns true
     * hasCity returns boolean***/
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
    }



    /*****delete the Mock city from Mock City list****/
    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();
        cityList.delete(mockCity());

        assertFalse(cityList.hasCity(mockCity()));
        assertTrue(cityList.countCities() == 0);

    }

    /****see if delete exception will be thrown****/
    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        cityList.delete(mockCity());

        /**create a city and don't add it to the mockCityList**/
        City throwsCity = new City("x","y");

        /**citation: https://howtodoinjava.com/junit5/expected-exception-example/**/

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(throwsCity);
        });
    }

    /****new***/
    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        /**create a cityList containing one City**/
        assertEquals(1, cityList.countCities());
    }




}