package com.edureka;

import java.sql.*;
import java.util.Scanner;

public class CallableStatementDemo {
    public static void main(String[] args) {
        try {
            //Step - 1
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db", "root", "welcome");

            //Step - 2
            CallableStatement callableStatement = connection.prepareCall("{call insert_into_employee(?,?,?,?)}");


            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your name ");
            String name = scanner.next();
            System.out.println("Please enter the department");
            String dept = scanner.next();

            System.out.println("Please enter the age");
            int age = scanner.nextInt();

            insertEmployee(callableStatement, name, age, dept);
            scanner.close();




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertEmployee(CallableStatement callableStatement, String name, int age, String dept) throws SQLException {
        callableStatement.setInt(1, 59);
        callableStatement.setString(2, name);
        callableStatement.setInt(3, age);
        callableStatement.setString(4, dept);
        callableStatement.execute();
    }
}