/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacii;

import java.math.BigInteger;

/**
 *
 * @author win
 */
public class Fibonacci {

    /**
     * This method used to display Fibonacci number on the screen
     *
     * @param maxNumber the number max of Fibonacci number
     * @param mess the message to be printed instructing the user to input
     */
    public void displayFibonacci(long maxNumber, String mess) {
        System.out.println(mess);
        fibonacciRecursion(maxNumber, BigInteger.ONE, BigInteger.ZERO);
        System.out.println("");
    }

    /**
     * This method used to generate Fibonacci number
     *
     * @param number the number of Fibonacci will be generate
     * @param low the low number
     * @param high the high number
     * @return Fibonacci number
     */
    public BigInteger fibonacciRecursion(long number, BigInteger low,
            BigInteger high) {
        if (number < 1) {
            return high;
        } else if (number > 1) {
            System.out.print(high + ", ");
        } else {
            System.out.print(high);
        }
        return fibonacciRecursion(number - 1, high, low.add(high));
    }
}
