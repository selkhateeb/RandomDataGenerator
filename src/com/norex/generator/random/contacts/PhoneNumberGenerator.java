/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.norex.generator.random.contacts;

import java.util.Random;

/**
 *
 * @author selkhateeb
 */
public class PhoneNumberGenerator {
    private int areacode;
    private int first3Digits;
    private int last4Digits;

    private final Random random;

    public PhoneNumberGenerator() {
        this.random = new Random();
    }

    public String nextPhoneNumber(){
        
        
        return "(" + nextAreaCode() + ") " + nextFirst3Digits() + "-" + nextLast4Digits();
    }

    private int nextAreaCode(){
        int hundreds = (random.nextInt(8) + 2) * 100;
        int tens = random.nextInt(10) * 10;
        this.areacode = hundreds + tens + random.nextInt(10);
        return this.areacode;
    }

    private String nextFirst3Digits(){
        String str = "";
        for (int i = 0; i < 3; i++) {
            str += nextDigit() + "";
        }
        return str;
    }

    private String nextLast4Digits(){
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += nextDigit() + "";
        }
        return str;
    }

    private int nextDigit(){
       return random.nextInt(10);
    }
    

}
