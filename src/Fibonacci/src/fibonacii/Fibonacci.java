/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacii;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author win
 */
public class Fibonacci {
    private final  List<BigInteger> fibonacci;

    public Fibonacci() {
        this.fibonacci = new ArrayList();
    }
    
    /**
     * This method used to display Fibonacci number on the screen
     *
     * @param maxNumber the number max of Fibonacci number
     * @param message   the message to be printed instructing the user to input
     */
    public void displayFibonacci(long maxNumber, String message) {
        System.out.println(message);
       generateFibonacci(maxNumber);
        for (int i = 0; i < fibonacci.size(); i++) {
            if(i==fibonacci.size()-1){
                System.out.print(fibonacci.get(i)+".");
                break;
            }
            System.out.print(fibonacci.get(i)+", ");
        }
        System.out.println("");
    }

     /**
     * This method generates Fibonacci numbers using recursion.
     *
     * @param number the number of Fibonacci will be generated
     */
    public void generateFibonacci(long number) {
        // Clear the previous results
        fibonacci.clear();

        // Generate Fibonacci sequence recursively
        generateFibonacciRecursive(number, BigInteger.ZERO, BigInteger.ONE);
    }
    
    /**
     * This method is a helper method to generate Fibonacci number 
     * using recursion.
     *
     * @param number    the number of Fibonacci will be generated
     * @param current   the current number in Fibonacci sequence
     * @param previous  the previous number in Fibonacci sequence
     */
    //generateFibonacciRecursive(number, BigInteger.ZERO, BigInteger.ONE)
    private void generateFibonacciRecursive(long number, BigInteger previous,
            BigInteger current) {
        if (number > 0) {
            fibonacci.add(previous);
            BigInteger next = current.add(previous); //           
            generateFibonacciRecursive(number - 1, current, next);
        }
    }
    /**
     * this method is to check if the input number is fibonacci or not
     * 
     * @param number
     * @param validMessage
     * @param invalidMessage 
     */
    public void isFibonacci(int number, String validMessage, String invalidMessage){
        int previous=0;
        int current=1;
        boolean temp=false;
        while(previous<=number){
            if(previous==number){
                temp=true;
                break;
            }
            int next=previous+current;
            previous=current;
            current=next;
        }
        if(temp){
            System.out.println(validMessage);
        }else{
            System.out.println(invalidMessage);
        }
    }
}
