/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import fibonacii.Fibonacci;

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
        long maxNumber = 45;
        fibonacii.displayFibonacci(maxNumber, "The " + maxNumber + " sequence fibonacci:");
    }
}
