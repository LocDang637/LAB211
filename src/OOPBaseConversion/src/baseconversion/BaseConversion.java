/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconversion;

import constant.Constant;

/**
 *
 * @author win
 */
public class BaseConversion {

    private Base base;

    /**
     * Initializes a BaseConversion object with the given Base object.
     *
     * @param base The Base object containing the number to be converted
     */
    public BaseConversion(Base base) {
        this.base = base;
    }

    /**
     * Sets the Base object for processing.
     *
     * @param base The Base object containing the number to be converted
     */
    public void setBase(Base base) {
        this.base = base;
    }

    /**
     * Gets the Base object for processing.
     *
     * @return The Base object containing the number to be converted
     */
    public Base getBase() {
        return base;
    }

    /**
     * Converts the number from the current base to decimal base.
     */
    public void convertToDec() {
        int decNum = 0;
        int decBase = 0;
        for (int i = base.getNumber().length() - 1; i >= 0; i--) {
            switch (base.getNumber().charAt(i)) {
                case 'A':
                    decNum += 10 * Math.pow(base.getBase(), decBase);
                    break;
                case 'B':
                    decNum += 11 * Math.pow(base.getBase(), decBase);
                    break;
                case 'C':
                    decNum += 12 * Math.pow(base.getBase(), decBase);
                    break;
                case 'D':
                    decNum += 13 * Math.pow(base.getBase(), decBase);
                    break;
                case 'E':
                    decNum += 14 * Math.pow(base.getBase(), decBase);
                    break;
                case 'F':
                    decNum += 15 * Math.pow(base.getBase(), decBase);
                    break;
                default:
                    decNum += Integer.parseInt(base.getNumber().charAt(i) + "") //chuyen doi tu ky tu 9 (char) sang so 9 (int)
                            * Math.pow(base.getBase(), decBase);
            }
            decBase++;
        }
        setBase(new Base(Constant.DEC, decNum + ""));
    }

    /**
     * Converts the number from decimal base to the specified output base.
     *
     * @param OUTBASE The target base to convert to
     */
    public void convertDecToOutBase(final int OUTBASE) {
        if (base.getBase() != Constant.DEC) {
            throw new IllegalArgumentException();
        }
        String reverseResult = "";
        int remainNum;
        int decNum = Integer.parseInt(base.getNumber());
        while (decNum != 0) {
            remainNum = decNum % OUTBASE;
            int quotient = decNum / OUTBASE;
            switch (remainNum) {
                case 10:
                    reverseResult += "A";
                    break;
                case 11:
                    reverseResult += "B";
                    break;
                case 12:
                    reverseResult += "C";
                    break;
                case 13:
                    reverseResult += "D";
                    break;
                case 14:
                    reverseResult += "E";
                    break;
                case 15:
                    reverseResult += "F";
                    break;
                default:
                    reverseResult += String.valueOf(remainNum);
            }
            decNum = quotient;
        }
        String result = new StringBuilder(reverseResult).reverse().toString();
        setBase(new Base(OUTBASE, result));
    }
}
