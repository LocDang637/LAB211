/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import java.util.Scanner;

/**
 *
 * @author Tuandz
 */
public class Validator {

    private Validator() {
    }

    /**
     *Return the valid integer value scanned from the input
     * 
     * @param messageInfo               the message to be printed instructing 
     * the user to input
     * @param messageErrorOutOfRange    the message to be printed if the String 
     * parse value is out of range
     * @param messageErrorInvalidNumber the message to be printed if the String
     * does not contain a parable integer
     * @param min                       minimum Limit value
     * @param max                       maximum Limit value
     * @return the valid integer value scanned from the input
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(scanner.nextLine());//let user to enter number and convert it to interger, saving to number value
                if (number >= min && number <= max) {
                    return number;
                }else{
                System.out.println(messageErrorOutOfRange);
                }
            } catch (NumberFormatException e/*catch the invalid input at number line*/) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
}
