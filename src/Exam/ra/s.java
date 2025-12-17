package Exam.ra;

import java.util.Scanner;

public class s {
    private String id;
    private String name;
    private int age;
    private String major;

    public s(){}

    public s(String id, String name, int age, String major) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void inputData(Scanner scanner){
        System.out.print("Enter Student ID: ");
        this.id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Student Major: ");
        this.major = scanner.nextLine();
    }

    public void displayData(){
        System.out.println("___________________");
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Major: " + major);
        System.out.println("___________________");
    }
}
