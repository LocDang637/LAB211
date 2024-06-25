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
                "Error range(number>0)", "Invalid!",
                1, Integer.MAX_VALUE);
        Array array = new Array(number);
        System.out.print("Unsorted array:");
        array.printArray();
        array.insertionSort(false); //TRUE=TANG, FALSE=GIAM
        System.out.print("Sorted array:");
        array.printArray();
    }
}
