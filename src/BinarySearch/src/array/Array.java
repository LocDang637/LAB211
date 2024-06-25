/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

import constant.Constant;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Tuandz
 */
public class Array {

    private int array[]=null;

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
     * This method return array format
     *
     * @return array format
     */
    @Override
    public String toString() {
        String str = " [";
        for (int i = 0; i < array.length; i++) {
            str = str + array[i];
            if (i < array.length - 1) {
                str = str + ", ";
            } else {
                str = str + "]";
            }
        }
        return str;
    }

    /**
     * This method display the first index of key on the screen
     *
     * @param key             the value to be searched for
     * @param messInfor       the message used to Notify users 
     * which value of key they are looking for
     * @param messNOTFOUNDKEY the message used to display when not found the key
     */
    public void displayIndex(int key, String messInfor, String messNOTFOUNDKEY){
        int index = binarySearch(key);
        if (index == Constant.NOTFOUNDKEY) {
            System.out.println(messNOTFOUNDKEY);
        } else {
            System.out.println(messInfor + index);
        }
    }

    /**
     * This method is used to sort array
     */
    public void sortArray() {
        Arrays.sort(array);
    }

    /**
     * Performs a binary search on a sorted integer array to find the index of
     * the target value.
     *
     * @param target the value to search for
     * @return the index of the target value if found, 
     * or NOTFOUNDKEY value if not found
     */
    //binary search chi tim duoc phan tu dau tien co trong mang
    public int binarySearch(int target /*KEY*/) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left+right) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Constant.NOTFOUNDKEY;
    }
}
