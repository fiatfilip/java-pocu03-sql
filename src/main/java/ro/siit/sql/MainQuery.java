package ro.siit.sql;

import java.sql.*;
import java.util.UUID;

public class MainQuery {
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

            Statement queryStatement = connection.createStatement();
            ResultSet resultSet = queryStatement.executeQuery("SELECT name nume, id from customers");

            while(resultSet.next()){
                UUID id = UUID.fromString(resultSet.getObject("id").toString());
                System.out.println(id + ", " + resultSet.getString("nume"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
