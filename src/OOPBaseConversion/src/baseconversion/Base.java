/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconversion;

import constant.Constant;
import validate.Validator;

/**
 *
 * @author win
 */
public class Base {

    private int base;      // The base of the number (e.g., 2 for binary, 10 for decimal)
    private String number; // The number represented as a string

    /**
     * Constructs a Base object with the specified base and number.
     *
     * @param base   The base of the number (binary, decimal, or hexadecimal)
     * @param number The number as a string
     */
    public Base(int base, String number) {
        this.number = number;
        this.base = base;
    }

    /**
     * Constructs an empty Base object. The base and number will be initialized
     * to default values.
     */
    public Base() {
    }

    /**
     * Gets the number represented as a string.
     *
     * @return The number as a string
     */
    public String getNumber() {
        return number;
    }

    /**
     * Gets the base of the number.
     *
     * @return The base of the number
     */
    public int getBase() {
        return base;
    }

    /**
     * Sets the number to the specified value.
     *
     * @param number The new number as a string
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Allows the user to input the base and number based on their choice. The
     * base and number are set according to the chosen input (binary, decimal,
     * or hexadecimal).
     */
    public void input() {
        int choice = Validator.getInt(
                "Enter 1 for binary, 2 for decimal, 3 for hexadecimal: ",
                "Invalid choice. Please enter 1, 2, or 3.",
                "Invalid choice. Please enter a number between 1 and 3.",
                1, 3);
        switch (choice) {
            case 1:
                base = Constant.BIN;
                number = Validator.getString("Enter a number: ",
                        "Not a valid number", Constant.REGEX_BINARY);
                break;
            case 2:
                base = Constant.DEC;
                number = Validator.getString("Enter a number: ",
                        "Not a valid number", Constant.REGEX_DECIMAL);
                break;
            case 3:
                base = Constant.HEX;
                number = Validator.getString("Enter a number: ",
                        "Not a valid number", Constant.REGEX_HEXADECIMAL);
                break;
        }
    }
}
