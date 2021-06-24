package com.nadim.springbootconcepts.dbmanager;

import com.nadim.springbootconcepts.Request.CreateRequest;
import com.nadim.springbootconcepts.daos.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBoperations {

    // we are using volatile because let say a thread T1 opens a db connection
    // then no other thread will be able to open the connection again.
    // connection variable in main memory
    public static volatile Connection connection;

    // Singleton Pattern
    public static Connection getConnection() throws SQLException {

        // DOUBLE-LOCK

        if (connection == null) {
            // in synchronized block only one thread can enter at a time it also called critical section.

            synchronized (DBoperations.class) {
                if (connection == null) {
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/person", "root", "programmer@007");
//                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/person", "root", "programmer@007"]]]]]]]]]);
                }

            }
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {

        // DOUBLE-LOCK
        if (connection != null) {
            // in synchronized block only one thread can enter at a time it is also called critical section.
            synchronized (DBoperations.class) {
                if (connection != null) {
                    connection = null;  // note do not close the connection i.e  connection.close()  instead do
                                        // connection = null
                }
            }
        }
    }

    // creating table in backend
    public static void createTable(String name) throws SQLException {
        getConnection();
        Statement statement = connection.createStatement();
        boolean isCreated = statement.execute("CREATE TABLE " + name + "(id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20),age INT,address VARCHAR(50) )");
        if (isCreated)
            System.out.println("TABLE " + name + " IS CREATED SUCCESSFULLY");
        closeConnection();
    }

    public static void insertPerson(CreateRequest request) throws SQLException {

        getConnection();

        // PreparedStatement is other way to write sql queries

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO persons VALUES (null,?,?,?)");
        preparedStatement.setString(1, request.getName());
        preparedStatement.setInt(2, request.getAge());
        preparedStatement.setString(3, request.getAddress());

        int row_affected = preparedStatement.executeUpdate();

        if(row_affected>0)
            System.out.println("record inserted successfully");
        else
            System.out.println("unable to insert record");

        closeConnection();

//        Person person = new Person(request.getName(), request.getAge(), request.getAddress());
//        Statement statement = connection.createStatement();
//        statement.executeQuery("");

    }



    public static List<Person> getAllPerson() throws SQLException {

        getConnection();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM persons");
        List<Person> persons = new ArrayList<Person>();

        while(rs.next())
        {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            String address = rs.getString(4);

            Person person = new Person(id,name,age,address);
            persons.add(person);

        }

        return persons;
    }

    public static void getPersonById(Integer id) throws SQLException {
    }

    public static void updatePerson(Person person) {
    }


    public static void deletePerson(Person person) {
    }
}
