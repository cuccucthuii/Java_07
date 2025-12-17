package Exam.re;

import java.util.Scanner;

public class Student {
    /**
     * Xay dung sv co cac thanh phan sau
     * 1. Cac thuoc tinh: MaSV, ten, tuoi, sex, diemtb, trangthai
     * 2. Gom 3 contructor: 0 tham so, 2 tham so ( ma, ten ), full tham so
     * 3. Cac phuong thuc get set cho phep truy cap vao cac thuoc tinh
     * 4. Cac phuong thuc the hien hanh vi:
     * - Chao giang vien
     * - tính tổng 2 số nguyên
     * - Cho phép nhập thông tin đối tượng sinh viên
     * - cho phép hiển thị thông tin đối tượng sinh viên
     */

    // các thuộc tính
    private String id;
    private String name;
    private int age;
    private boolean sex;
    private float averageScore;
    private boolean status;

    // constructor default khoong tham so
    public Student() {
    }

    // (String id, String name) các tham số
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String id, String name, int age, Boolean sex, float averageScore, boolean status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.averageScore = averageScore;
        this.status = status;
    }

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // lấy thông tin thuộc tính
    public String getId() {
        return id; // giá trị hiện tại của thuộc tính
    }

    // gán giá trị cho thuộc tính
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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Chào giảng viên
    public void helloTeacher(){
        System.out.println("hello teacher");
    }

    public int addNumber(int a, int b){
        int sum = a+b;
        return sum;
    }

    public void inputData(Scanner scanner){
        System.out.println("Id: ");
        this.id = scanner.next();
        System.out.println("Name: ");
        this.name = scanner.next();
        System.out.println("Age: ");
        this.age = Integer.parseInt(scanner.next());
        System.out.println("Sex: ");
        this.sex = Boolean.parseBoolean(scanner.next());
        System.out.println("Average: ");
        this.averageScore = Float.parseFloat(scanner.next());
        System.out.println("Status: ");
        this.status = Boolean.parseBoolean(scanner.next());
    }

    public void displayData(){
        System.out.println("Id: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Sex: " + (this.sex ?"Nam":"Nu"));
        System.out.println("Average: " + this.averageScore);
        System.out.println("Status: " + (this.status?"Dang hoc":"Tot Nghiep"));
    }
}
