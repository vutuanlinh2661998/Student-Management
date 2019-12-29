/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import model.Student;

/**
 *
 * @author BVCN 88
 */
public class IODatabase {
      static Connection conn;
      static PreparedStatement pr;
      static ResultSet rs;
    public  static Connection getInstance(){
        String url = "jdbc:mysql://localhost:3306/studentmanagement?useUnicode=yes&characterEncoding=UTF-8";
        String driver ="com.mysql.jdbc.Driver";
        try{
            Class.forName(driver);
            conn= DriverManager.getConnection(url,"root" , "");
            
        }catch(Exception e){
            e.printStackTrace();
       
        }
        return conn;
    }
   
    public static void selectData (ArrayList<Student> ob) throws SQLException{
         ob.clear();
        try {
            String sql = "select * from student";
            pr = getInstance().prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()){
              Student st = new Student(rs.getInt(1), rs.getString(2), rs.getDate(3));
               ob.add(st);
               //System.out.println(st.getName());
            }
            
        } catch (Exception e) {
        }
        finally{
            getInstance().close();
        }
    }
    
    public static void addDatabase (Student st) throws SQLException{
        try {
            String sql = "INSERT INTO student (id,name,dob) VALUES (?,?,?)";
            pr = getInstance().prepareStatement(sql);
           // System.out.println(ob.size());
           
          
               
                pr.setInt(1, st.getId());
                pr.setString(2, st.getName());
                pr.setDate(3, new java.sql.Date(st.getDob().getTime()));
                pr.executeUpdate();
                System.out.println("success");
            
        } catch (Exception e) {
        }
        finally{
            getInstance().close();
        }
    }
    public static void removeDatabase (Student st) throws SQLException{
        try {
            String sql = "DELETE FROM student WHERE id = ?";
            pr = getInstance().prepareStatement(sql);
            pr.setInt(1, st.getId());
            pr.executeUpdate();
        } catch (Exception e) {
        }
        finally{
            getInstance().close();
        }
    }
    public static void editDatabase (Student st) throws SQLException{
        try {
            String sql = "UPDATE student SET name = ?, dob =? WHERE id = ?";
            pr = getInstance().prepareStatement(sql);
            pr.setString(1, st.getName());
            pr.setDate(2, new java.sql.Date(st.getDob().getTime()));
            pr.setInt(3, st.getId());
            pr.executeUpdate();
        } catch (Exception e) {
        }
        finally{
            getInstance().close();
        }
    }
    public static void main(String[] args) throws SQLException {
        ArrayList<Student> student = new ArrayList<>();
        Student st1 = new Student(5,"Hà Thị Lý", new Date());
        Student st2 = new Student(6,"Lê Lan", new Date());
        Student st3 = new Student(7,"Ngô Kinh", new Date());
        student.add(st1);
        student.add(st2);
        student.add(st3);
        //IODatabase.writeDatabase(student);
        //IODatabase.selectData(student);
    }
}
