package com.example.simpleparadox.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     *
     * @param city This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     *
     * @return Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /****check if the cityList contains a certain city***/
    public boolean hasCity(City city) {

        for (City currCity : cities) {
            /**check if both city name and province name matches**/
            if (currCity.getCityName().compareTo(city.getCityName()) == 0 && currCity.getProvinceName().compareTo(city.getProvinceName()) == 0) {
                return true;
            }else{
                break;
            }
        }
        return false;
    }

    /***check if a city is in the list, and if it is, remove it **/
    public void delete(City city){
        /**check first to see if the city is in the list**/
        if(hasCity(city) == false){
            throw new IllegalArgumentException();
        }

        /**loop over cities**/
        /**don't use == to compare objects**/
        for(City currCity : cities){
            if(currCity.compareTo(city) == 0){
                cities.remove(currCity);
                break;
            }
        }
    }

    /**return city list size**/
    public int countCities(){
        int cityListLen = cities.size();
        return cityListLen;
    }
}




