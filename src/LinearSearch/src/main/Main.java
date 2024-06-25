/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import array.Array;
import validate.Validator;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number = Validator.getInt("Enter number of array:",
                "Error range(number>0)", "Invalid",
                1, Integer.MAX_VALUE);
        Array array = new Array(number);
        int key = Validator.getInt("Enter search value:",
                "Error range", "Invalid",
                Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.print("The array: ");
        System.out.println(array.toString());
        array.displayIndex(key,"Found " +key+ " at index: ","Not found key!");
    }
}
