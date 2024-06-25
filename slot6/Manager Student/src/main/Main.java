/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import management.Management;
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
        Management manager= new Management();
        manager.generateStudent();
        while (true) {
            System.out.println("\tWELCOME TO STUDENT MANAGEMENT");
            System.out.println(" 1.Create");
            System.out.println(" 2.Find and Sort");
            System.out.println(" 3.Update/Delete");
            System.out.println(" 4.Report");
            System.out.println(" 5.Exit");
            int choice = Validator.getInt("Enter choice:","Enter 1->5",
                    "Invalid!", 1, 5);
            switch (choice) {
                case 1:
                    manager.createStudent();
                    break;
                case 2:
                    manager.findAndSort();
                    break;
                case 3:
                    manager.updateOrDelete();
                    break;
                case 4:
                    manager.report();
                    break;
                case 5:
                    return;
            }
        }
    }
}
