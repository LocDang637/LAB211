/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.HotelsManagements;
import validator.Validator;





/**
 *
 * @author DANG LOC
 */
public class HotelsManagementApp {
    public static void main(String[] args) {            
    HotelsManagements manager=new HotelsManagements();
    do{
        System.out.println("======HOTEL MANAGEMENT MENU======");
        System.out.println("1) Adding new Hotel. \n"
                    + "2) Checking exits Hotel. \n"
                    + "3) Updating Hotel information. \n"
                    + "4) Deleting Hotel. \n"
                    + "5) Searching Hotel. \n"
                    + "6) Displaying a hotel list (descending by Hotel_Name). \n"
                    + "7) Others Quit.");
        int choice = Validator.getInt("Enter your choice: ", "Please enter 1->7",
                    "Please enter integer number", 1, 7);
        switch(choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                int choice2;
                do{
                System.out.println("1. Search by Hotel ID");
                System.out.println("2. Search by Hotel Name");
                System.out.println("3. Exit");
                choice2 = Validator.getInt("What type of data you want to search?", "Please enter 1 or 2",
                    "Please enter integer number", 1, 3);                
                switch(choice2){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
                }while(choice2<3);
                break;
            case 6:
                break;
            case 7:
                return;
        }
    }while(true);
}
}
