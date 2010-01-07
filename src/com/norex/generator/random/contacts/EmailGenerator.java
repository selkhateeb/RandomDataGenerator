/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.norex.generator.random.contacts;

import com.norex.generator.random.Util;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author selkhateeb
 */
public class EmailGenerator {

    private final ArrayList<String> domains;
    private NameGenerator nameGenerator;
    private Random random;

    public EmailGenerator() {
        this.domains = Util.LoadListFromFile(EmailGenerator.class.getResourceAsStream("DomainNames"));
        this.random = new Random();

    }

    public String nextEmail(){
        if(this.nameGenerator == null){
            this.nameGenerator = new NameGenerator();
        }
        String name = this.nameGenerator.getNextFullName().toLowerCase().replace(" ", ".");
        return name + "@" + this.domains.get(this.random.nextInt(this.domains.size()));
    }



}
