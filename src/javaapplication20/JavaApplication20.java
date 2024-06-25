/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

import config.hasher;
import config.smsSender;
import java.util.Scanner;


/**
 *
 * @author entac
 */
public class JavaApplication20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       smsSender sms = new smsSender();
       
       sms.initialize();
       sms.sendSMS("+639687530915","Student Log Out");
       
     
    }
    
}
