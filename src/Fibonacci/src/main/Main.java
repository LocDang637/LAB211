/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import fibonacii.Fibonacci;
import valiator.Valiator;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fibonacci fibonacii = new Fibonacci();
        System.out.println("------Menu------");
        System.out.println("1. Print out the sequence fibonacci");
        System.out.println("2. Check if the number is fibonacci or not");
        System.out.println("3. Exit");
        int choice=0;
        do{
            choice = Valiator.getInt("Enter choice: ","Error. Enter choice (1-3)","Choice must be an integer",3);
        switch(choice){
            case 1:
                int maxNumber = Valiator.getSequence("Enter sequence number: ","Sequence must greater than 1","Sequence must be an integer",Integer.MAX_VALUE);
                fibonacii.displayFibonacci(maxNumber, "The " + maxNumber + " sequence fibonacci:");
                break;
            case 2:
                int number=Valiator.getInt("Enter number: ", "Number must greater than 1", "Number must be an integer", Integer.MAX_VALUE);
                fibonacii.isFibonacci(number, "This number is a fibonacci", "This number is not a fibonacci");
                break;
            case 3:
                System.out.println("Exit program");
        }
        }while(choice<3);
        
       
    }
}
