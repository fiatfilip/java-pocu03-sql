package ro.siit.sql;

import ro.siit.sql.entity.Customer;
import ro.siit.sql.entity.Product;
import ro.siit.sql.service.DBImplementor;

import java.util.Scanner;
import java.util.UUID;

public class MainApp {
    public static void main(String[] args) {
        DBImplementor dbImplementor = DBImplementor.getInstance();

        Scanner keyboard = new Scanner(System.in);
        String command;
        do{
            printMainMenu();
            command = keyboard.nextLine();
            switch (command){
                case "C":
                    System.out.println("Enter customer name");
                    String customerName = keyboard.nextLine();
                    dbImplementor.addCustomer(new Customer(UUID.randomUUID(), customerName));
                    break;
                case "P":
                    System.out.println("Enter product name");
                    String productName = keyboard.nextLine();
                    dbImplementor.addProduct(new Product(UUID.randomUUID(), productName));
            }
        }while(!"X".equalsIgnoreCase(command));

    }

    static void printMainMenu(){
        System.out.println("C - add new customer");
        System.out.println("P - add new product");
        System.out.println("X - exit");
        System.out.println("Enter command");
    }
}
