package Exam.re;

import java.util.Scanner;

public class Book {
    private String id;
    private String title;
    private float price;
    private String author;
    private boolean status;

    public Book() {
    }

    public Book(String id, String title, float price, String author, boolean status) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        System.out.println("ID: ");
        this.id = scanner.nextLine();
        System.out.println("Title: ");
        this.title = scanner.nextLine();
        System.out.println("Price: ");
        this.price = Float.parseFloat(scanner.nextLine());
        System.out.println("Author: ");
        this.author = scanner.nextLine();
        System.out.println("Status: ");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData(){
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (status?"Active":"Inactive"));
    }
}
