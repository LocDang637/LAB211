/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author DANG LOC
 */
public class Hotels implements Serializable {
    //Hotel_id, Hotel_Name, Hotel_Room_Available, Hotel_Address, Hotel_Phone, Hotel_Rating. 
    private String Hotel_id;
    private String Hotel_Name;
    private int Hotel_Room_Available;
    private String Hotel_Address;
    private String Hotel_Phone;
    private int Hotel_Rating;

    public Hotels() {
    }

    public Hotels(String Hotel_id, String Hotel_Name, int Hotel_Room_Available, 
                  String Hotel_Address, String Hotel_Phone, int Hotel_Rating) {
        this.Hotel_id = Hotel_id;
        this.Hotel_Name = Hotel_Name;
        this.Hotel_Room_Available = Hotel_Room_Available;
        this.Hotel_Address = Hotel_Address;
        this.Hotel_Phone = Hotel_Phone;
        this.Hotel_Rating = Hotel_Rating;
    }

    public String getHotel_id() {
        return Hotel_id;
    }

    public void setHotel_id(String Hotel_id) {
        this.Hotel_id = Hotel_id;
    }

    public String getHotel_Name() {
        return Hotel_Name;
    }

    public void setHotel_Name(String Hotel_Name) {
        this.Hotel_Name = Hotel_Name;
    }

    public int getHotel_Room_Available() {
        return Hotel_Room_Available;
    }

    public void setHotel_Room_Available(int Hotel_Room_Available) {
        this.Hotel_Room_Available = Hotel_Room_Available;
    }

    public String getHotel_Address() {
        return Hotel_Address;
    }

    public void setHotel_Address(String Hotel_Address) {
        this.Hotel_Address = Hotel_Address;
    }

    public String getHotel_Phone() {
        return Hotel_Phone;
    }

    public void setHotel_Phone(String Hotel_Phone) {
        this.Hotel_Phone = Hotel_Phone;
    }

    public int getHotel_Rating() {
        return Hotel_Rating;
    }

    public void setHotel_Rating(int Hotel_Rating) {
        this.Hotel_Rating = Hotel_Rating;
    }
    
    
    

}
