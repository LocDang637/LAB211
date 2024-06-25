/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Hotels;
import validator.Validator;

/**
 *
 * @author DANG LOC
 */
public class HotelsManagements {
    List<Hotels> hotelsList = new ArrayList<>(); 
    
    /**
     * Retrieves the list of all hotels.
     *
     * @return A list of Hotels objects.
     */
    public List<Hotels> getListHotels() {
        return hotelsList;
    }

    /**
     * Retrieves a hotel based on its ID.
     *
     * @param id The unique identifier of the hotel to be retrieved.
     * @return The Hotels object if found, otherwise null.
     */
    public Hotels getHotel(String id) {
        for (int i = 0; i < hotelsList.size(); i++) {
            if (hotelsList.get(i).getHotel_id().equalsIgnoreCase(id)) {
                return hotelsList.get(i);
            }
        }
        return null;
    }
    
    public void addNewHotel(){
        String choose;
        while (true) {
            String Hotel_id = Validator.getString("Enter hotel Id:",
                    "Please enter id hotel with format : H...(Example H01)", "^H\\d+$");
            if (getHotel(Hotel_id) != null) {
                System.err.println("ID Hotel is areadly input !");
                continue;
            }
            String Hotel_Name = Validator.getString("Enter hotel name:",
                    "Invalid!", "^(?!\\s*$).+");
            int Hotel_Room_Available = Validator.getInt("Enter room available: ",
                    "Please enter 1->500 room", "Please enter integer number!", 1, 500);
            String Hotel_Address = Validator.getString("Enter hotel address:",
                    "Invalid!", "^(?!\\s*$).+");
            String Hotel_Phone = Validator.getString("Enter hotel phone:",
                    "Please enter phone format : 0xxxxxxxxx(10 digits)", "^0\\d{9}$");
            int Hotel_Rating = Validator.getInt("Enter Hotel_Rating(number stars): ",
                    "Please enter 1->8 stars", "Please enter integer number!", 1, 8);
            Hotels newHotel = new Hotels(Hotel_id, Hotel_Name,
                    Hotel_Room_Available, Hotel_Address, Hotel_Phone, Hotel_Rating);
            hotelsList.add(newHotel);
            System.out.println("Add success ! Continue input Hotels");
            System.out.println("----------CONTINUE ADD-----------");
            choose = Validator.getString("You want to continue (Y/N): ",
                    "Just Y or N", "[YNyn]");
            if (choose.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
    
    /**
     * Reads hotel data from a file and populates the list of hotels.
     *
     * @param file The name of the file from which to read the hotel data.
     */
    public void readFile(String file) {
        try {
            FileInputStream fos = new FileInputStream(file);
            ObjectInputStream oos = new ObjectInputStream(fos);
            while (true) {
                try {
                    // Đọc một đối tượng và ép kiểu thành Hotels
                    Hotels hotel = (Hotels) oos.readObject();
                    hotelsList.add(hotel);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception i) {
            System.out.println("Error to read File:" + file);
        }
    }
    
    /**
     * Saves the current list of hotels to a file.
     *
     * @param file The name of the file to which the hotel data will be saved.
     */
    public void saveFile(String file) {
        // Save product data
        if (hotelsList.isEmpty()) {
            System.err.println("Empty product list");
            return;
        } else {
            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                for (int i = 0; i < hotelsList.size(); i++) {
                    oos.writeObject(hotelsList.get(i));
                }
                oos.close();
                fos.close();
            } catch (IOException e) {
                System.err.println("Error saving product data to file: " + file);
            }//51:24
        }
    }
}
