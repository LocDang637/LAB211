/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countries;

import java.util.ArrayList;
import validate.Validator;

/**
 *
 * @author win
 */
public class Country extends EastAsiaCountries {

    /** The terrain of the country. */
    private String countryTerrain;

    /**
     * Constructs an instance of the Country class with default values.
     */
    public Country() {
    }

    /**
     * Constructs an instance of the Country class with specified values.
     *
     * @param countryTerrain The terrain of the country.
     * @param countryCode    The country code of the East Asian country.
     * @param countryName    The name of the East Asian country.
     * @param totalArea      The total area of the East Asian country.
     */
    public Country(String countryTerrain, String countryCode,
            String countryName, double totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    /**
     * Retrieves the terrain of the country.
     *
     * @return The country terrain.
     */
    public String getCountryTerrain() {
        return countryTerrain;
    }

    /**
     * Displays information about the country, including its code,
     * name, total area, and terrain.
     */
    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.1f%-25s\n", super.getCountryCode(),
                super.getCountryName(),super.totalArea, getCountryTerrain());
    }

    /**
     * Allows input of information about the country, including code,
     * name, total area, and terrain.
     *
     * @param list The list of EastAsiaCountries objects to validate
     * the uniqueness of the country code.
     * @throws Exception If the country code is not unique.
     */
    public void inputInfor(ArrayList<EastAsiaCountries> list) throws Exception {
        super.countryCode = Validator.getString("Enter code of country:",
                "Invalid", "[A-Za-z0-9]+");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCountryCode().
                    equalsIgnoreCase(super.getCountryCode())) {
                throw new Exception();
            }
        }
        super.countryName = Validator.getString("Enter name of country:",
                "Invalid", "([A-Za-z]+\\s?)+");
        super.totalArea = Validator.getDouble("Enter total Area:",
                "Error range!", "Invalid", Double.MIN_VALUE, Double.MAX_VALUE);
        countryTerrain = Validator.getString("Enter terrain of country:",
                "Invalid", "([A-Za-z]+\\s?)+");
    }
}
