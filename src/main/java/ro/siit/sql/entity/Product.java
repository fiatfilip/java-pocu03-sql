package ro.siit.sql.entity;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;

    public Product(UUID id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
