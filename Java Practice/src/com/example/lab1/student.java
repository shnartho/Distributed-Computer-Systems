package com.example.lab1;

public class student {
    String name;
    int age;
    String address;

    public student (String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getAddress(){
        return address;
    }

    @Override
    public String toString() {
        return ("Student Name is " + this.getName() + ", Age is "+ this.getAge() + " & address is "+ this.getAddress());
    }

    public static void main(String[] args) {
        student Nayem = new student("Nayem", 25, "Poland Road");
        System.out.println(Nayem.toString());

        System.out.println(Nayem.getName());
        System.out.println(Nayem.getAge());
        System.out.println(Nayem.getAddress());

        Nayem.setName("Nayembhai");
        System.out.println(Nayem.toString());
    }

}
