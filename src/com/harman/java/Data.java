package com.harman.java;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Data {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option;
        while (true) {
            System.out.println("select an option");
            System.out.println("1.Add the employees");
            System.out.println("2.view all employees");
            System.out.println("3.exit");
            option = in.nextInt();
            switch (option) {
                case 1:
                    System.out.println("1.Add the employees");


                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?autoReconnect=true&useSSL=false", "root", "");

                        Scanner input = new Scanner(System.in);
                        String empcode, name, phone, email, designation, salary, companyname, address;
                        System.out.println("enter empcode");
                        empcode = input.next();
                        System.out.println("enter name");
                        name = input.next();
                        System.out.println("enter phone");
                        phone = input.next();
                        System.out.println("enter email");
                        email = input.next();
                        System.out.println("enter designation");
                        designation = input.next();
                        System.out.println("enter salary");
                        salary = input.next();
                        System.out.println("enter companyname");
                        companyname = input.next();
                        System.out.println("enter address");
                        address = input.next();
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `employees`(`empcode`, `name`, `phone`, `email`, `designation`, `salary`, `companyname`, `address`) " +
                                "VALUES(" + empcode + ",'" + name + "'," + phone + ",'" + email + "','" + designation + "'," + salary + ",'" + companyname + "','" + address + "')");
                        System.out.println("Inserted successfully1");

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                case 2:
                    System.out.println("view all employees");
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `id`, `empcode`, `name`, `phone`, `email`, `designation`, `salary`, `companyname`, `address` FROM `employees` WHERE 1");
                        while (rs.next()){
                            System.out.println("empcode ="+rs.getInt("empcode"));
                            System.out.println("name ="+rs.getString("name"));
                            System.out.println("phone="+rs.getInt("phone"));
                            System.out.println("email="+rs.getString("email"));
                            System.out.println("designation="+rs.getString("designation"));
                            System.out.println("salary="+rs.getInt("salary"));
                            System.out.println("companyname="+rs.getString("companyname"));
                            System.out.println("address="+rs.getString("address"));

                    }
            }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 3 :
                    System.exit(0);
                default:
                    System.out.println("Invalid option");


            }

        }
    }
}

