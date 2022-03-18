package com.example.lab1;

public class WorkingStudent extends student {
    public String companyName;

    public WorkingStudent(String name, int age, String address, String companyName){
        super(name, age, address);
        this.companyName = companyName;
    }

    public static void main(String[] args) {
        WorkingStudent Rasel = new WorkingStudent("Rasel Ferdous", 39, "Dhaka", "MES");
        System.out.println("Hello "+ Rasel.name);
        System.out.println("Hello "+ Rasel.toString());
    }
}
