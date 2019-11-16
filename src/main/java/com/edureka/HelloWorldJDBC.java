package com.edureka;

import java.sql.*;
import java.util.Scanner;

public class HelloWorldJDBC {

    public static void main(String[] args) {
        try {
            //Step - 1
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db", "root", "welcome");

            //Step - 2
            Statement statement = connection.createStatement();

            //printEmployees(statement);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your name ");
            String name = scanner.next();
            System.out.println("Please enter the department");
            String dept = scanner.next();

            System.out.println("Please enter the age");
            int age = scanner.nextInt();

            insertEmployee(statement, name, age, dept);
            scanner.close();

            //updateEmployee(statement);

            //deleteEmployee(statement);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteEmployee(Statement statement) throws SQLException {
        statement.executeUpdate("delete from employees where id = 28");
    }

    private static void updateEmployee(Statement statement) throws SQLException {
        statement.executeUpdate("update employees set name='ravi kumar ' where id=28");
    }

    private static void insertEmployee(Statement statement, String name, int age, String dept) throws SQLException {
        boolean execute = statement.execute("insert into employees (id,name, dep_name ) values (39,'"+name+"', '"+dept+"' )" );
    }

    private static void printEmployees (Statement statement) throws SQLException {
        //Step - 3
        ResultSet resultSet = null;

        resultSet = statement.executeQuery("select * from employees");
        //step - 4
        while(resultSet.next()){
            System.out.print("Id "+resultSet.getInt("id")+" \t");
            System.out.print("Name: "+resultSet.getString("name")+" \t");
            System.out.print("Age: "+resultSet.getInt("age")+" \t");
            System.out.print("Dept_Name: " +resultSet.getString("dep_name")+" \n");
        }
    }
}