/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import baseconversion.BaseConversion;
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
        // TODO code application logic here
        BaseConversion baseConversion= new BaseConversion();
        System.out.println("----------Enter input base and output base------");
        System.out.println("1.Binary\n2.Decimal\n3.Hexadecimal");
        int choiceInBase = Validator.getInt("Enter your choice of the input base:",
                "Number is out of range", "Not a valid number", 1, 3);
        int choiceOutBase = Validator.getInt("Enter your choice of the output base:",
                "Number is out of range", "Not a valid number", 1, 3);
        int inBase = baseConversion.getBase(choiceInBase);
        int outBase = baseConversion.getBase(choiceOutBase);
        System.out.println("----------------Enter Input Number-----------");
        String input= baseConversion.getInputNumber(inBase);
        System.out.println("----------------Output Number-----------");
        int decNumber= baseConversion.convertToDec(input, inBase);
        System.out.println(baseConversion.convertDecToOutBase(decNumber, outBase));
    }
    
}
