/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import countries.Country;
import countries.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author win
 */
public class ManageEastAsiaCountries {

    ArrayList<EastAsiaCountries> list = new ArrayList<>();

    /**
     * Adds country information to the list.
     *
     * @param country The EastAsiaCountries object to add.
     * @throws Exception If the country code is not unique.
     */
    public void addCountryInfor(EastAsiaCountries country) throws Exception {
        ((Country) country).inputInfor(list);
        list.add(country);
    }

    /**
     * Retrieves the recently entered country information.
     *
     * @return The most recently entered EastAsiaCountries object.
     * @throws Exception If the list is empty.
     */
    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        if (list.isEmpty()) {
            throw new Exception();
        }
        return list.get(list.size() - 1);
    }

    /**
     * Displays a list of countries information.
     *
     * @param listDisplay The list of EastAsiaCountries objects to display.
     */
    public void displayListCountries(ArrayList<EastAsiaCountries> listDisplay) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name",
                "Total Area", "Terrain");
        for (int i = 0; i < listDisplay.size(); i++) {
            ((Country) listDisplay.get(i)).display();
        }
    }

    /**
     * Displays information about a single country.
     *
     * @param country The EastAsiaCountries object to display.
     */
    public void displayCountry(EastAsiaCountries country) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        ((Country) country).display();
    }

    /**
     * Searches for countries by name and returns a list of matching countries.
     *
     * @param name The name to search for.
     * @return A list of EastAsiaCountries objects that match the name.
     * @throws Exception If no matching countries are found.
     */
    public ArrayList<EastAsiaCountries> searchCountriesByName(String name)
            throws Exception {
        ArrayList<EastAsiaCountries> listSearch = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCountryName().toLowerCase().
                    contains(name.toLowerCase())) {
                listSearch.add(list.get(i));
            }
        }
        if (listSearch.isEmpty()) {
            throw new Exception();
        }
        return listSearch;
    }

    /**
     * Sorts the list of countries by name in alphabetical order.
     *
     * @return The sorted list of EastAsiaCountries objects.
     * @throws Exception If the list is empty.
     */
    public ArrayList<EastAsiaCountries> sortByNameCountry() throws Exception {
        if (list.isEmpty()) {
            throw new Exception();
        }
        ArrayList<EastAsiaCountries> listSorted = list;
        Comparator<EastAsiaCountries> e = (EastAsiaCountries t,
                EastAsiaCountries t1) ->
                t.getCountryName().compareTo(t1.getCountryName());
        Collections.sort(listSorted, e);
        return listSorted;
    }
}
