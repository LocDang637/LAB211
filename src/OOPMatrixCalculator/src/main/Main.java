/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import matrix.Matrix;
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
        Matrix firstMatrix = new Matrix();
        Matrix secondMatrix = new Matrix();
        while (true) {
            System.out.println("======Calculator program======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = Validator.getInt("Your choice: ", "Error. Enter (1-4)",
                    "Invalid", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("--------Addition--------");
                    firstMatrix.inputMatrix("Enter Row Matrix 1: ",
                            "Enter Columm Matrix 1: ", "Enter Matrix1");
                    secondMatrix.inputMatrix("Enter Row Matrix 2: ",
                            "Enter Columm Matrix 2: ", "Enter Matrix2");
                    System.out.println("-----------Result-------------");
                    firstMatrix.displayMatrix();
                    System.out.println("+");
                    secondMatrix.displayMatrix();
                    System.out.println("=");
                    try {
                        firstMatrix.add(secondMatrix);
                        firstMatrix.displayMatrix();
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("--------Subtraction--------");
                    firstMatrix.inputMatrix("Enter Row Matrix 1: ",
                            "Enter Columm Matrix 1: ", "Enter Matrix1");
                    secondMatrix.inputMatrix("Enter Row Matrix 2: ",
                            "Enter Columm Matrix 2: ", "Enter Matrix2");
                    System.out.println("-----------Result-------------");
                    firstMatrix.displayMatrix();
                    System.out.println("-");
                    secondMatrix.displayMatrix();
                    System.out.println("=");
                    try {
                        firstMatrix.subtract(secondMatrix);
                        firstMatrix.displayMatrix();
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("--------Multiplication--------");
                    firstMatrix.inputMatrix("Enter Row Matrix 1: ",
                            "Enter Columm Matrix 1: ", "Enter Matrix1");
                    secondMatrix.inputMatrix("Enter Row Matrix 2: ",
                            "Enter Columm Matrix 2: ", "Enter Matrix2");
                    System.out.println("-----------Result-------------");
                    firstMatrix.displayMatrix();
                    System.out.println("*");
                    secondMatrix.displayMatrix();
                    System.out.println("=");
                    try {
                        firstMatrix.multiply(secondMatrix);
                        firstMatrix.displayMatrix();
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                case 4:
                    return;
            }
        }
    }
}
