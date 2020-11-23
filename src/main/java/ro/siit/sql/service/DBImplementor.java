package ro.siit.sql.service;

import ro.siit.sql.entity.Customer;
import ro.siit.sql.entity.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBImplementor implements DB{
    private static DBImplementor instance;
    private Connection connection;
    private DBImplementor(){
        try {
            Class.forName("org.postgresql.Driver");
            String connectionURL = "jdbc:postgresql://localhost:5432/java-pocu03";
            connection = DriverManager.getConnection(connectionURL, "postgres", "postgres");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static DBImplementor getInstance() {
        if(instance == null) {
            instance = new DBImplementor();
        }
        return instance;
    }

    @Override
    public void addCustomer(Customer customer) {
        try (PreparedStatement insertStatement = connection
                .prepareStatement("INSERT INTO customers VALUES (? , ?)")) {
            insertStatement.setObject(1, customer.getId());
            insertStatement.setString(2, customer.getName());
            insertStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void addProduct(Product product) {
        try (PreparedStatement insertStatement = connection
                .prepareStatement("INSERT INTO products VALUES (? , ?)")) {
            insertStatement.setObject(1, product.getId());
            insertStatement.setString(2, product.getName());
            insertStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
