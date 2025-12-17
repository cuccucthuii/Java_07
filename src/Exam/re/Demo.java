package Exam.re;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // 1. Khoi tao doi tuong sinh vien ma khong khoi tao bat cu thong tin gi cua sinh vien
        // 2. Mã, tên
        // 3. Tất cả thông tin sinh viên
        // 4. Khởi tạo đối tượng sinh viên vs: Tên, mã tuổi
        // 5. Nhập thông tin cho sinh viên 1
        // 6. Nhập thông tin gồm tuổi, gt, dtb, trangthai
        // 7. tính tuổi trung bình của sinh viên
        // In thông tin sinh viên

        Scanner scanner = new Scanner(System.in);

        Student st1 = new Student(); // New cấp phát bộ nhớ cho đối tượng
        Student st2 = new Student("SV002", "Nguyen Van B");
        Student st3 = new Student("SV003", "Nguyen Van C", 20, true, 8.8f, true);
        Student st4 = new Student("SV004", "Nguyen Van B", 23);

        // 5
//        st1.inputData(scanner);

        // 6
        System.out.println("Nhập thông tin sinh viên 2:");
        System.out.println("Nhập vào tuổi sv: ");
        st2.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhập vào giới tính: ");
        st2.setSex(Boolean.parseBoolean(scanner.nextLine()));
        System.out.println("Nhập vào điểm trung bình sinh viên: ");
        st2.setAverageScore(Float.parseFloat(scanner.nextLine()));
        System.out.println("Nhập vào trạng thái: ");
        st2.setStatus(Boolean.parseBoolean(scanner.nextLine()));

        // 7
        int tuoitb = (st1.getAge() + st2.getAge() + st3.getAge() + st4.getAge()) / 4;
        System.out.println("Tuổi trung bình: "+tuoitb);

        System.out.println("*** Sinh viên 1 ***");
        st1.displayData();

        System.out.println("*** Sinh Vien 2 ***");
        st2.displayData();

        System.out.println("*** Sinh Vien 3 ***");
        st3.displayData();

        System.out.println("*** Sinh Vien 4 ***");
        st4.displayData();

    }
}
