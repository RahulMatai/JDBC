/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahul
 */
public class Jdbc_one {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String pass = "";
        String sql;
        Connection con;
        String name = null;
        int roll = 0;
        Statement st = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the name to proceed :");
        name = sc.next();
        System.out.println("enter the roll number  to proceed :");
        roll = sc.nextInt();

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            System.out.println(" " + " " + ex.getMessage());
        }
        try {

            con = DriverManager.getConnection(url, user, pass);

            st = con.createStatement();

        } catch (SQLException ex) {
            System.out.println(" " + " " + ex.getMessage());
        }
        try {
            sql = "insert into student values ('" + name + "'," + roll + ")";
            int x = st.executeUpdate(sql);
            if (x == 0) {
                System.out.println("Data insertion failed try again !!!");
            } else {
                System.out.println("Data inserted successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc_one.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
