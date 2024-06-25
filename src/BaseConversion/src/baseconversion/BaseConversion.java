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
public class BaseConversion {

    /**
     * Convert input number to decimal base
     *
     * @param inputNumber input number
     * @param inBase      input base
     * @return number in decimal base
     */
    public int convertToDec(String inputNumber, int inBase) {
        int decNum = 0;
        int decBase = 0;
        for (int i = inputNumber.length() - 1; i >= 0; i--) {
            switch (inputNumber.charAt(i)) {
                case 'A':
                    decNum += 10 * Math.pow(inBase, decBase);
                    break;
                case 'B':
                    decNum += 11 * Math.pow(inBase, decBase);
                    break;
                case 'C':
                    decNum += 12 * Math.pow(inBase, decBase);
                    break;
                case 'D':
                    decNum += 13 * Math.pow(inBase, decBase);
                    break;
                case 'E':
                    decNum += 14 * Math.pow(inBase, decBase);
                    break;
                case 'F':
                    decNum += 15 * Math.pow(inBase, decBase);
                    break;
                default:
                    decNum += Integer.parseInt(inputNumber.charAt(i) + "")
                            * Math.pow(inBase, decBase);
            }
             decBase++;
        }
        return decNum;
    }

    /**
     * Convert decimal base to output base
     *
     * @param decNum  number in decimal base
     * @param outBase output number
     * @return String output number
     */
    public String convertDecToOutBase(int decNum, int outBase) {
        String reverseResult = "";
        int remainNum;
        while (decNum != 0) {
            remainNum = decNum % outBase;
            int quotient = decNum / outBase;
            switch (remainNum) {
                case 10:
                    reverseResult = "A" + reverseResult;
                    break;
                case 11:
                    reverseResult = "B" + reverseResult;
                    break;
                case 12:
                    reverseResult = "C" + reverseResult;
                    break;
                case 13:
                    reverseResult = "D" + reverseResult;
                    break;
                case 14:
                    reverseResult = "E" + reverseResult;
                    break;
                case 15:
                    reverseResult = "F" + reverseResult;
                    break;
                default:
                    reverseResult += String.valueOf(remainNum);
            }
            decNum = quotient;
        }
        String result = new StringBuilder(reverseResult).reverse().toString();
        return result;
    }

    /**
     * Return base 2 if choice 1, base 10 if choice 2, and base 16 if choice 3
     *
     * @param choice selection base
     * @return base 2 or 10 or 16 , but if not found case will return
     * Constant.NOTFOUNDBASE
     */
    public int getBase(int choice) {
        int base;
        switch (choice) {
            case 1:
                base = 2;
                break;
            case 2:
                base = 10;
                break;
            case 3:
                base = 16;
                break;
            default:
                return Constant.NOTFOUNDBASE;
        }
        return base;
    }

    /**
     * Return string of input number (binary or Decimal or Hexadecimal)
     *
     * @param inBase input base (2 or 10 or 16)
     * @return String input number (binary or Decimal or Hexadecimal) ,but not
     * found case will return Constant.NOTFOUNDBASE+""
     */
    public String getInputNumber(int inBase) {
        String inputNumber;
        switch (inBase) {
            case 2:
                inputNumber = Validator.getString(
                        "Enter a binary number: ",
                        "Not a valid number",
                        Constant.REGEX_BINARY);
                break;
            case 10:
                inputNumber = Validator.getString(
                        "Enter a decimal number: ",
                        "Not a valid number",
                        Constant.REGEX_DECIMAL);
                break;
            case 16:
                inputNumber = Validator.getString(
                        "Enter a hexadecimal number: ",
                        "Not a valid number",
                        Constant.REGEX_HEXADECIMAL);
                break;
            default:
                return Constant.NOTFOUNDBASE + "";
        }
        return inputNumber.toUpperCase();
    }
}
