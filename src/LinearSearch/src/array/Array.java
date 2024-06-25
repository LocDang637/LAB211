/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

import java.util.ArrayList;
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
     * Displays the indices of the specified key in the array.
     *
     * @param key             The value to search for.
     * @param messInfor       The message to display for notifying users about
     * the key being searched.
     * @param messageNotFound The message to display when the key is not found.
     */
    
    //array.displayIndex(key,"Found " +key+ " at index: ","Not found key!");
    public void displayIndex(int key, String messInfor,String messageNotFound) {
            ArrayList result = linearSearch(key);
            if(result.isEmpty()){
                System.out.println(messageNotFound);
            }else{
                System.out.println(messInfor);
                for (int i = 0; i < result.size(); i++) {
                    System.out.print(result.get(i));
                    if(i<result.size()-1){
                        System.out.print(";");
                    }
                }
            }
    }

    /**
     * Performs a linear search to find the position(s) of the specified
     * key in the array.
     *
     * @param key The value to search for.
     * @return A list of indices where the key is found, or an empty list if 
     * the key is not found.
     */
    public ArrayList linearSearch(int key) {
        int size = array.length;
        ArrayList<Integer> listIndexKey= new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (array[i] == key) {
                listIndexKey.add(i);
            }
        }
        return listIndexKey;
    }
}
