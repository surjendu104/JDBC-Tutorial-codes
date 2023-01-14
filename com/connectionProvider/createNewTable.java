package com.connectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class createNewTable {
    public static void createTable(Connection con,String tableName) {
        
        try {

            String Query = "create table " + tableName
                    + "(tId int(20) primary key auto_increment, tName varchar(200) not null , tCity varchar(400))";
            Statement smt = con.createStatement();
            smt.executeUpdate(Query);
        } catch (Exception e) {
            System.out.println("Error in table creation");
        }
    }

    public static void insertDataIntoTable(Connection con, String tableName,String col1,String col2) {
        Scanner sc = new Scanner(System.in);
        String query = String.format(
            "insert into %s(%s,%s) values(?,?)",tableName,col1,col2
        );
        try {
            
            PreparedStatement pstmt = con.prepareStatement(query);
    
            System.out.println("Enter the number of user to enter : ");
                int n = sc.nextInt();
                ArrayList<String> userName = new ArrayList<>();
                ArrayList<String> userCity = new ArrayList<>();
    
                System.out.println(String.format("Enter the %d names...", n));
                for (int i = 0; i < n; i++) {
                    String name = sc.next();
                    userName.add(i, name);
                }
    
                System.out.println(String.format("Enter the %d cities...", n));
                for (int i = 0; i < n; i++) {
                    String city = sc.next();
                    userCity.add(i, city);
                }
    
                for (int i = 0; i < n; i++) {
                    pstmt.setString(1, userName.get(i));
                    pstmt.setString(2, userCity.get(i));
                    // execute query
                    pstmt.executeUpdate();
                }
        } catch (Exception e) {
            System.out.println("Error in insert data nto table");
        }
        sc.close();
    }
}
