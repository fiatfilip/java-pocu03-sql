package ro.siit.sql;

import java.sql.*;
import java.util.Scanner;
import java.util.UUID;

public class MainAddProduct {
    public static void main(String[] args) {
        // load driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // create connection
        String connectionURL = "jdbc:postgresql://localhost:5432/java-pocu03";
        try (Connection connection = DriverManager.getConnection(connectionURL, "postgres", "postgres")){

            Scanner keyboard = new Scanner(System.in);
            System.out.println("Dati numele produsului");
            String productName  = keyboard.nextLine();
            UUID id = UUID.randomUUID();
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT INTO products VALUES (? , ?)");
            insertStatement.setObject(1, id);
            insertStatement.setString(2, productName);


            // "INSERT INTO products VALUES (" + id + " , " + productName + " )";
            // productName = "'aaa'); drop table users; "
            insertStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
