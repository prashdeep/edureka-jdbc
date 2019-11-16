package com.edureka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchProcessingDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db", "root", "welcome");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employees (id, name, age, dep_name) values (? ,?, ?, ?)");

            connection.setAutoCommit(false);

            preparedStatement.setInt(1, 123);
            preparedStatement.setString(2, "Harisha");
            preparedStatement.setInt(3, 23);
            preparedStatement.setString(4, "Commute");
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 124);
            preparedStatement.setString(2, "Ram");
            preparedStatement.setInt(3, 23);
            preparedStatement.setString(4, "Payroll");
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 125);
            preparedStatement.setString(2, "Vishnupriya");
            preparedStatement.setInt(3, 23);
            preparedStatement.setString(4, "FInance");
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 126);
            preparedStatement.setString(2, "Shashank");
            preparedStatement.setInt(3, 26);
            preparedStatement.setString(4, "DFS");
            preparedStatement.addBatch();

            preparedStatement.executeBatch();
            connection.commit();

        } catch (Exception e) {
            System.out.println("Rolling back the conenction....");
            e.printStackTrace();
            connection.rollback();
        }
    }
}

class Employee {

    private int id;
    private String name;
    private int age;
    private String depName;


    public Employee(int id, String name, int age, String depName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.depName = depName;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}