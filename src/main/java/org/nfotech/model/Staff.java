package org.nfotech.model;

public class Staff {
    private String name;
    private int id;

    public Staff(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public Staff() {

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
