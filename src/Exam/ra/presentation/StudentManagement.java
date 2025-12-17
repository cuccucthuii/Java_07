package Exam.ra.presentation;

import Exam.ra.entity.Student;

import java.util.Scanner;

public class StudentManagement {
    Student[] arrStudent = new Student[100];
    int currentIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();
        do {
            System.out.println("*********************QUẢN LÝ SINH VIÊN********************");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật thông tin sinh viên theo mã sinh viên");
            System.out.println("4. Xóa sinh viên theo mã sinh viên");
            System.out.println("5. Tìm sinh viên theo tên sinh viên");
            System.out.println("6. Thoát");
            System.out.println("***********************************************************");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Danh sách sinh viên");
                    studentManagement.displayStudent();
                    break;
                case 2:
                    studentManagement.insertStudent(sc);
                    break;
                case 3:
                    studentManagement.updateStudent(sc);
                    break;
                case 4:
                    studentManagement.deleteStudent(sc);
                    break;
                case 5:
                    studentManagement.searchStudentByName(sc);
                    break;
                case 6:
                    System.out.println("Kết thúc!");
                    System.exit(0);
                    break;
                default:
            }

        } while (true);
    }

    // Hien thi danh sách sinh viên
    public void displayStudent() {
        if (currentIndex == 0) {
            System.out.println("Chưa có sinh viên nào!");
            return;
        }
        for (int i = 0; i < currentIndex; i++) {
            arrStudent[i].displayData();
        }
    }

    // Them sinh vien
    public void insertStudent(Scanner scanner) {
        System.out.println("Nhập số lượng sinh viên cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập vào sinh viên thứ: %d", i + 1);
            System.out.println();
            arrStudent[i] = new Student();
            arrStudent[i].inputData(scanner);
            currentIndex++;
        }
    }

    // Sua sinh vien
    public void updateStudent(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Chưa có sinh viên nào!");
            return;
        }
        System.out.println("Nhập id cần sửa: ");
        String id = scanner.nextLine();

        int updateIndex = findStudentById(id);
        if (updateIndex == -1) {
            System.out.println("Không tìm thấy sinh viên");
            return;
        }
        // Sua thong tin
        boolean isExist = true;
        do {
            System.out.println("*********************CẬP NHẬT SINH VIÊN********************");
            System.out.println("1. Sửa tên");
            System.out.println("2. Sửa tuổi");
            System.out.println("3. Sửa chuyên ngành");
            System.out.println("4. Thoát");
            System.out.println("************************************************************");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    arrStudent[updateIndex].setName(scanner.nextLine());
                    break;
                case 2:
                    arrStudent[updateIndex].setAge(Integer.parseInt(scanner.nextLine()));
                    break;
                case 3:
                    arrStudent[updateIndex].setMajor(scanner.nextLine());
                    break;
                case 4:
                    isExist = false;
                    break;
                default:
                    System.out.println("404 NOT FOUND");
            }
        } while (isExist);
    }

    // xoa sinh vien
    public void deleteStudent(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Chưa có dữ liệu sinh viên!");
            return;
        }
        System.out.println("Nhập vào id cần xoá: ");
        String id = scanner.nextLine();
        int deleteIndex = findStudentById(id);
        if (deleteIndex == -1) {
            System.out.println("Không tìm thấy ID sinh viên");
        }
        for (int i = deleteIndex; i < currentIndex; i++) {
            arrStudent[i] = arrStudent[i + 1];
        }
        currentIndex--;
    }

    // Tìm kiếm theo tên sv
    public void searchStudentByName(Scanner scanner) {
        int countStudent = 0;
        if (currentIndex == 0) {
            System.out.println("Dữ liệu sinh viên chưa tồn tại!");
        }
        System.out.println("Nhập tên sinh viên cần tìm: ");
        String nameSearch = scanner.nextLine();

        for (int i = 0; i < currentIndex; i++) {
            if (arrStudent[i].getName().toLowerCase().contains(nameSearch.toLowerCase())) {
                arrStudent[i].displayData();
                countStudent++;
            }
        }
        System.out.print("Tìm thấy %d sinh viên"+ countStudent);

    }

    public int findStudentById(String id) {
        for (int i = 0; i < currentIndex; i++) {
            if (arrStudent[i].getId().toLowerCase().contains(id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }


}
