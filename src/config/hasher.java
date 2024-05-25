/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author entac
 */
public class hasher {
    
    public static String passHash(String pass){
         try{
             MessageDigest md = MessageDigest.getInstance("SHA");
             md.update(pass.getBytes());
             byte[] rb = md.digest();
             StringBuilder sb = new StringBuilder();
             
             for(byte b: rb){
                 sb.append(String.format("%02x", b));
             }
             
             return sb.toString();
             
         }catch(NoSuchAlgorithmException ex){
         
         }
         return null;
     }
}
