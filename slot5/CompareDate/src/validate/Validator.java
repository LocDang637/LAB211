/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Tuandz
 */
public class Validator {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Validator() {
    }

    /**
     * Returns the valid Date scanned from the input.
     * 
     * @param messageInfo the message to be printed instructing
     * the user to input
     * @param messageError the message will be printed if the input 
     * does not match the date format
     * @param dateFormat the format of Date
     * @return the valid Date scanned from the input
     */
    public static Date getDate(String messageInfo, String messageError,
            String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        format.setLenient(false);
        do {
            System.out.print(messageInfo);
            String str = SCANNER.nextLine();
            try {
                Date date = format.parse(str);
                return date;
            } catch (ParseException e) {
                System.out.println(messageError);
            }
        } while (true);
    }
}
