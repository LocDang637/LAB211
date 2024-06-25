/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

import java.util.Random;

/**
 *
 * @author Tuandz
 */
public class Array {

    private int array[] = null;

    /**
     * This construct a random array.
     *
     * @param number -length of array
     */
    public Array(int number) {
        Random rand = new Random();
        array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = rand.nextInt(number);
        }
    }

    /**
     * This method is used to display Arrays on the screen.
     */
    public void printArray() {
        System.out.print(" [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("]");
            }
        }
        System.out.println("");
    }

    /**
     * This method is used to sort array by insertion sort
     *
     * @param increase if true array will sort increase other wise decrease
     */
    public void insertionSort(boolean increase) {
        int j, key;

        // Loop through the array starting from the second element
        for (int i = 1; i < array.length; i++) {
            key = array[i]; // The current element to be sorted
            j = i - 1; // Start comparing with the element before the current element

            // If sorting in increasing order
            if (increase) {
                // Shift elements greater than key to one position ahead of their current position
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j--;
                }
            } // If sorting in decreasing order
            else {
                // Shift elements less than key to one position ahead of their current position
                while (j >= 0 && array[j] < key) {
                    array[j + 1] = array[j];
                    j--;
                }
            }

            // Place the key in its correct position
            array[j + 1] = key;
        }
    }

}
