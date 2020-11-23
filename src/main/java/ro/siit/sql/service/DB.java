package ro.siit.sql.service;

import ro.siit.sql.entity.Customer;
import ro.siit.sql.entity.Product;

public interface DB {
    void addCustomer(Customer customer);
    void addProduct(Product product);
}
