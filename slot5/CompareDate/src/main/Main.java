/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Date;
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
        Date firstDate = Validator.getDate("Please enter the first date: ",
                "Please enter Date (dd-MM-yyyy) ", "dd-MM-yyyy");
        Date secondDate = Validator.getDate("Please enter the second date: ",
                "Please enter Date (dd-MM-yyyy) ", "dd-MM-yyyy");
        if (firstDate.compareTo(secondDate) < 0) {
            System.out.print("Date1 is before Date2: ");
            calculateDateDifference(firstDate, secondDate);
        } else if (firstDate.compareTo(secondDate) > 0) {
            System.out.print("Date1 is after Date2: ");
            calculateDateDifference(firstDate, secondDate);
        } else {
            System.out.println("Date1 equal Date2");
        }
    }

    private static void calculateDateDifference(Date date1, Date date2) {
        long differenceInMilliseconds = Math.abs(date1.getTime() - date2.getTime());
        long differenceInSeconds = differenceInMilliseconds / 1000;
        long days = differenceInSeconds / (24 * 3600); // Calculate days
        if (days > 30) {
            long months = days / 30;
            days = days % 30;
            System.out.println(months + " Month," + days + " Day");
        } else {
            System.out.println(days + " Day");

        }
    }
}
