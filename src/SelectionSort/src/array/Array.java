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
     * This method is used to sort array by selection sort
     *
     * @param increase if true array will sort increase otherwise decrease
     */
    public void selectionSort(boolean increase) {
        // If sorting in decreasing order
        if (!increase) {
            int temp, iMax;
            // Iterate over the array
            for (int i = 0; i < array.length - 1; i++) {
                iMax = i; // Initialize the index of the maximum element
                // Find the maximum element in the remaining unsorted array
                for (int j = i + 1; j < array.length; j++) {
                    if (array[iMax] < array[j]) {
                        iMax = j;
                    }
                }
                // Swap the found maximum element with the first element
                if (iMax != i) {
                    temp = array[iMax];
                    array[iMax] = array[i];
                    array[i] = temp;
                }
            }
        } // If sorting in increasing order
        else {
            int temp, iMin;
            // Iterate over the array
            for (int i = 0; i < array.length - 1; i++) {
                iMin = i; // Initialize the index of the minimum element
                // Find the minimum element in the remaining unsorted array
                for (int j = i + 1; j < array.length; j++) {
                    if (array[iMin] > array[j]) {
                        iMin = j;
                    }
                }
                // Swap the found minimum element with the first element
                if (iMin != i) {
                    temp = array[iMin];
                    array[iMin] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

}
