/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valiator;

import java.util.Scanner;

/**
 *
 * @author DANG LOC
 */
public class Valiator {

    public Valiator() {
    }
    /**
     * this method is to check if the input sequence is valid or not
     * 
     * @param inputMessage to get the input message
     * @param errorRangeMessage to print out the message if the input number is out of range
     * @param errorFormatMessage to print out the message if the input number is not at the right format
     * @param max to get the max input number
     * @return 
     */
    public static int getSequence(String inputMessage,String errorRangeMessage, String errorFormatMessage, int max){
        Scanner sc=new Scanner(System.in);
        do{
        try{
            System.out.println(inputMessage);
            
            int number = Integer.parseInt(sc.nextLine());
            if(number>1 && number<max){
                return number;
            }else{
                System.out.println(errorRangeMessage);
            }
        }catch(NumberFormatException e){
            System.out.println(errorFormatMessage);          
        }
        }while(true);
    }
    /**
     * this method is to check if the input number is valid or not
     * 
     * @param inputMessage is to get the input message
     * @param errorRangeMessage is to print out if the input number is not in range
     * @param errorFormatMessage is to print out if the input number if not at the right format
     * @param max to get the max input number
     * @return 
     */
    public static int getInt(String inputMessage,String errorRangeMessage, String errorFormatMessage,int max){
        Scanner sc=new Scanner(System.in);
        do{
        try{
            System.out.println(inputMessage);
            
            int number = Integer.parseInt(sc.nextLine());
            if(number>=1 && number<=max){
                return number;
            }else{
                System.out.println(errorRangeMessage);
            }
        }catch(NumberFormatException e){
            System.out.println(errorFormatMessage);          
        }
        }while(true);
    }
}
