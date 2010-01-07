/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norex.generator.random;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author selkhateeb
 */
public class Util {

    public static ArrayList<String> LoadListFromFile(InputStream is) {

        ArrayList<String> list = new ArrayList<String>();
        //load from file
        try {
            DataInputStream in = new DataInputStream(is);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                if (!strLine.trim().isEmpty()) {
                    list.add(strLine);
                }
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return list;
    }
}
