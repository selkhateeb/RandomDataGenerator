/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.norex.generator.random;

import com.norex.generator.random.contacts.NameGenerator;
import com.norex.generator.random.contacts.PhoneNumberGenerator;

/**
 * Middle name
 * Address
 * City
 * Province
 * Postal Code
 * Country
 * Phone
 * Email
 * 
 * @author selkhateeb
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NameGenerator ng = new NameGenerator();
//        for (int i = 0; i < 500; i++) {
//            System.out.println(ng.getNextFullName());
//        }

//        EmailGenerator eg = new EmailGenerator();
//        for (int i = 0; i < 500; i++) {
//            System.out.println(eg.nextEmail());
//        }

        PhoneNumberGenerator png = new PhoneNumberGenerator();
          for (int i = 0; i < 500; i++) {
            System.out.println(png.nextPhoneNumber());
        }


    }

}
