package main;

import baseconversion.Base;
import baseconversion.BaseConversion;
import constant.Constant;
import validate.Validator;

public class Main {

    public static void main(String[] args) {
        Base inputNumber = new Base();
        inputNumber.input();
        BaseConversion convert = new BaseConversion(inputNumber);
        int outChoice = Validator.getInt(
                "Enter 1 for binary, 2 for decimal, 3 for hexadecimal: ",
                "Invalid choice. Please enter 1, 2, or 3.",
                "Invalid choice. Please enter a number between 1 and 3.",
                1, 3);
        switch (outChoice) {
            case 1:
                convert.convertToDec();
                    try {
                        convert.convertDecToOutBase(Constant.BIN);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Error!");
                        return;
                    }
                break;
            case 2:
                convert.convertToDec();
                break;
            case 3:
                convert.convertToDec();
                    try {
                        convert.convertDecToOutBase(Constant.HEX);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Error!");
                        return;
                    }
                break;
        }
        System.out.println("Number after convert: " + convert.getBase().getNumber());
    }
}
