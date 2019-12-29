/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author BVCN 88
 */
public class IOFiletxt {
    public static void readFile (List ob, String str){
        ob.clear();
        ObjectInputStream oin;
        try {
            oin = new ObjectInputStream(new FileInputStream(str));
            Object obj= null;
            try {
              while ((obj=oin.readObject())!=null){
                 Object o1 = (Object)obj;
                 ob.add(o1);
              }
              for (Object o2 : ob)
                    System.out.println(o2);
            } catch (Exception e) {
            }
            oin.close();
        } catch (Exception e) {
        }
    }
    
    public static void writeFile (List ob, String str){
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new FileOutputStream(str));
            for (Object o1 : ob)
                out.writeObject(o1);
            out.close();
        } catch (Exception e) {
        }
    }
    
}
