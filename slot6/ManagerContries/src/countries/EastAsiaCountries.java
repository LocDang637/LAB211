/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countries;

/**
 *
 * @author win
 */
public class EastAsiaCountries {

    protected String countryCode;
    protected String countryName;
    protected double totalArea;

    /**
     * Constructs an instance of the EastAsiaCountries class with default
     * values.
     */
    public EastAsiaCountries() {
    }

    /**
     * Constructs an instance of the EastAsiaCountries class with specified
     * values.
     *
     * @param countryCode The country code of the East Asian country.
     * @param countryName The name of the East Asian country.
     * @param totalArea   The total area of the East Asian country.
     */
    public EastAsiaCountries(String countryCode, String countryName,
            double totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    /**
     * Retrieves the country code of the East Asian country.
     *
     * @return The country code.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code of the East Asian country.
     *
     * @param countryCode The country code to set.
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Retrieves the name of the East Asian country.
     *
     * @return The country name.
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Retrieves the total area of the East Asian country.
     *
     * @return The total area.
     */
    public double getTotalArea() {
        return totalArea;
    }
    
     /**
     * Displays information about the country, including its code,
     * name, total area.
     */
    public void display() {
        System.out.printf("%-10s%-25s%-20.1f\n", getCountryCode(),
                getCountryName(),totalArea);
    }
}
