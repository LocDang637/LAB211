/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import constant.Constant;
import controller.Validator;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author win
 */
public class Schedule implements Serializable {

    private ArrayList<Staff> pilots = new ArrayList<>();
    private ArrayList<Staff> flightAttendants = new ArrayList<>();
    private ArrayList<Staff> groundStaffs = new ArrayList<>();
    private Flight forFlight;
    SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.FORMAT_DATE);

    public Schedule(Flight forFlight) {
        this.forFlight = forFlight;
    }

    public ArrayList<Staff> getPilots() {
        return pilots;
    }

    public void setPilots(ArrayList<Staff> pilots) {
        this.pilots = pilots;
    }

    public ArrayList<Staff> getFlightAttendants() {
        return flightAttendants;
    }

    public void setFlightAttendants(ArrayList<Staff> flightAttendants) {
        this.flightAttendants = flightAttendants;
    }

    public ArrayList<Staff> getGroundStaffs() {
        return groundStaffs;
    }

    public void setGroundStaffs(ArrayList<Staff> groundStaffs) {
        this.groundStaffs = groundStaffs;
    }

    public Flight getForFlight() {
        return forFlight;
    }

    public void setForFlight(Flight forFlight) {
        this.forFlight = forFlight;
    }

    public Staff getSchedule(String code) {
        for (int i = 0; i < pilots.size(); i++) {
            if (pilots.get(i).getId().equalsIgnoreCase(code)) {
                return pilots.get(i);
            }
        }
        for (int i = 0; i < flightAttendants.size(); i++) {
            if (flightAttendants.get(i).getId().equalsIgnoreCase(code)) {
                return flightAttendants.get(i);
            }
        }
        for (int i = 0; i < groundStaffs.size(); i++) {
            if (groundStaffs.get(i).getId().equalsIgnoreCase(code)) {
                return groundStaffs.get(i);
            }
        }
        return null;
    }

    public void input(ArrayList<Schedule> listSchedule, ArrayList<Staff> listStaff, Flight flight) {
        int choice;
        String id;
        while (true) {
            System.out.println("-----------Add Schedule----------");
            for (int i = 0; i < listStaff.size(); i++) {
                System.out.println(listStaff.get(i).toString());
            }
            while (true) {
                id = Validator.getString("Enter ID Staff:", " ID can not be blank",
                        "^(?!\\s*$).+");
                for (int i = 0; i < listSchedule.size(); i++) {
                    if (!listSchedule.get(i).forFlight.getNumber().equals(flight.getNumber())) {
                        if (dateFormat.format(listSchedule.get(i).getForFlight().getDepartureTime()).
                                equals(dateFormat.format(flight.getDepartureTime()))) {
                            if (listSchedule.get(i).getSchedule(id) != null) {
                                System.out.println("This ID Staff is existed in  Flight " + listSchedule.get(i).forFlight.getNumber() + " in same Departure Time ");
                                System.out.println("Add fail!");
                                return;
                            }
                        }
                    }

                }
                if (getSchedule(id) == null) {
                    boolean existed=false;
                    for (int i = 0; i < listStaff.size(); i++) {
                        if (listStaff.get(i).getId().equalsIgnoreCase(id)) {
                            existed=true;
                            break;
                        }
                    }
                    if(existed){
                        break;
                    }else{
                        System.out.println("Not found ID Staff");
                    }
                } else {
                    System.err.println("This ID Staff is existed in this Flight");
                }
            }
            for (int i = 0; i < listStaff.size(); i++) {
                if (listStaff.get(i).getId().equals(id)&&listStaff.get(i).getRole().equals(Constant.PILOT)) {
                    pilots.add(listStaff.get(i));
                }
                if (listStaff.get(i).getId().equals(id)&&listStaff.get(i).getRole().equals(Constant.FLIGHT_ATTENDANT)) {
                    flightAttendants.add(listStaff.get(i));
                }
                if (listStaff.get(i).getId().equals(id)&&listStaff.get(i).getRole().equals(Constant.GROUND_STAFF)) {
                    groundStaffs.add(listStaff.get(i));
                }
            }
            String choose = Validator.getString("Do you continue?", "Just y or n", "[ynYN]");
            if (choose.equalsIgnoreCase("N")) {
                return;
            }
        }
    }

    public void delete() {
        String choice;
        String code = Validator.getString("Enter ID Staff:", " ID can not be blank",
                "^(?!\\s*$).+");
        for (int i = 0; i < pilots.size(); i++) {
            if (pilots.get(i).getId().equalsIgnoreCase(code)) {
                choice = Validator.getString("Do you want delete?(Y OR N)", "Just y or n", "[ynYN]");
                if (choice.equalsIgnoreCase("Y")) {
                    pilots.remove(i);
                    System.err.println("Delete sucess!");
                } else {
                    System.err.println("Delete fail!");
                }
                return;
            }
        }
        for (int i = 0; i < flightAttendants.size(); i++) {
            if (flightAttendants.get(i).getId().equalsIgnoreCase(code)) {
                choice = Validator.getString("Do you want delete?", "Just y or n", "[ynYN]");
                if (choice.equalsIgnoreCase("Y")) {
                    flightAttendants.remove(i);
                    System.err.println("Delete sucess!");
                } else {
                    System.err.println("Delete fail!");
                }
                return;
            }
        }
        for (int i = 0; i < groundStaffs.size(); i++) {
            if (groundStaffs.get(i).getId().equalsIgnoreCase(code)) {
                choice = Validator.getString("Do you want delete?(Y or N)", "Just y or n", "[ynYN]");
                if (choice.equalsIgnoreCase("Y")) {
                    groundStaffs.remove(i);
                    System.err.println("Delete sucess!");
                } else {
                    System.err.println("Delete fail!");
                }
                return;
            }
        }
        System.err.println("Not found ID Staff");
    }
}
