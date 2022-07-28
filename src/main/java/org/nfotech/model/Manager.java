package org.nfotech.model;

import org.nfotech.model.enums.Qualification;
import org.nfotech.model.enums.Role;

public class Manager extends Staff {
    private Role role;
    private String name;
    private String id;

    public Manager(String name, int id, Role role) {
        super(name, id);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    //Manager can hire a cashier
    public String hireACashier(Manager manager, int age, Qualification qualification) {
        if (!manager.getRole().equals(Role.MANAGER)) {
            if (age >= 30 && qualification == Qualification.ACCOUNTANT) {
                System.out.println("You are employed");
                return "You are employed";
            } else {
                System.out.println("Sorry, you are not qualified");
                return "Sorry, you are not qualified";
            }
        } else {
            System.out.println("Only Manager can hire");
            return "Only Manager Can Hire";
        }
    }
}
