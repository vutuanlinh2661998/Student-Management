/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author BVCN 88
 */
public class Account implements Serializable{
     final long serialVersionUID = 2L;
     String username;
     String password;
     static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
     static Pattern pattern;
     static  Matcher matcher;
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public static boolean validate (String pass){
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(pass);
        boolean check= matcher.matches();
        return check;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
      public Object [] toObject (){
        return new Object[]{username,password};
    }
    
}
