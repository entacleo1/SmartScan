/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Blob;

/**
 *
 * @author entac
 */
public class session {
    
    private static session instance;

   
    private int id;
    private String name;
    private String tag; 
    private String last;
    private String user;
    private String pass;
    private String email;
    private String num;
    private String pic;
    private String mid;
    private String gender;
    private String add;
    private String bday;
    private String pos;

    private session(){
         
    }
    
    
  
    public static synchronized session getInstance() {
        if(instance == null){
            instance = new session();
           
        }
        return instance;
    }

    public static boolean isInstanceEmpty() {
        return instance == null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLast() {
        return last;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }
    

    public void setLast(String last) {
        this.last = last;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
    
    
    
    
    
    
}
