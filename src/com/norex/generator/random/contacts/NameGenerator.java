/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norex.generator.random.contacts;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author selkhateeb
 */
public class NameGenerator {

    private final ArrayList<String> males;
    private final ArrayList<String> females;
    private final ArrayList<String> lastnames;

    private Random random;

    public NameGenerator() {

        this.males = new ArrayList<String>();
        this.females = new ArrayList<String>();
        this.lastnames = new ArrayList<String>();
        this.random = new Random();

        //load from file
        try {
            DataInputStream in = new DataInputStream(NameGenerator.class.getResourceAsStream("FirstNameMales"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                this.males.add(strLine);
            }

            in = new DataInputStream(NameGenerator.class.getResourceAsStream("FirstNameFemales"));
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                this.females.add(strLine);
            }

            in = new DataInputStream(NameGenerator.class.getResourceAsStream("LastNames"));
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                this.lastnames.add(strLine);
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    
    public String getNextFullName(){
        return random.nextBoolean()? getNextFullNameFemale(): getNextFullNameMale();
    }
    public String getNextFullNameMale(){
        return getNextFirstNameMale() + " " + getNextLastName();
    }
    public String getNextFullNameFemale(){
        return getNextFirstNameFemale() + " " + getNextLastName();
    }

    public String getNextFirstName(){
        return random.nextBoolean()? getNextFirstNameMale(): getNextFirstNameFemale();
    }
    public String getNextFirstNameMale(){
        return this.males.get(random.nextInt(this.males.size()));
    }
    public String getNextFirstNameFemale(){
        return this.females.get(random.nextInt(this.females.size()));
    }
    public String getNextLastName(){
        return this.lastnames.get(random.nextInt(this.lastnames.size()));
    }
}
