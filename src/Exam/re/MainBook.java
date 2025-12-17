package Exam.re;

import java.util.Scanner;

public class MainBook {
    /**
     * Xây dựng lớp book có các thành phần sau:
     * 1. Các thuộc tính: Mã, tên, giá, tác giả, trạng thái
     * 2. 2 cons: 0, full
     * 3. Các pthuc:
     * get/set
     * inputData
     * displayData
     * II. Xây dựng lớp main BookManagement hiển thị menu và thực hiện các chức năng
     * 1. danh sách sách
     * 2. thêm mới sách
     * 3. cập nhật sách
     * 4. xoá sách
     * 5. tìm kiếm sách theo tên( tương đối )
     * 6. sắp xếp sách theo giá tăng dần
     * 7. thoát
     * Lựa chọn của bạn:
     */

    Book[] books = new Book[100];
    int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainBook mainBook = new MainBook();

        do {
            System.out.println("_______________ MENU BOOK _______________");
            System.out.println("1. Danh sách sách");
            System.out.println("2. thêm mới sách");
            System.out.println("3. cập nhật sách");
            System.out.println("4. xoá sách");
            System.out.println("5. tìm kiếm sách theo tên( tương đối )");
            System.out.println("6. sắp xếp sách theo giá tăng dần");
            System.out.println("7. thoát");
            System.out.println("_________________________________________");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    mainBook.displayBook();
                    break;
                case 2:
                    mainBook.addBook(scanner);
                    break;
                case 3:
                    mainBook.updateBook(scanner);
                    break;
                case 4:
                    mainBook.deleteBook(scanner);
                    break;
                case 5:
                    mainBook.searchBook(scanner);
                    break;
                case 6:
                    mainBook.sortBook();
                    break;
                case 7:
                    break;
                default:
            }
        } while (true);
    }

    public void displayBook() {
        if (currentIndex == 0) {
            System.out.println("chua co du lieu");
            return;
        }
        for (int i = 0; i < currentIndex; i++) {
            books[i].displayData();
        }
    }

    public void addBook(Scanner scanner) {
        System.out.println("Nhập vào số sách cần thêm:");
        int countBook = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countBook; i++) {
            System.out.printf("Nhập thông tin sách thứ: %d", i + 1);
            // Khởi tạo phần tử thứ currentIndex là 1 đối tượng sách
            books[currentIndex] = new Book();
            // Gọi phương thức inputData
            books[currentIndex].inputData(scanner);
            // Count++
            currentIndex++;
        }
    }

    public void updateBook(Scanner scanner) {
        System.out.println("Nhập vào mã sách cần cập nhật: ");
        String idBook = scanner.nextLine();
        int indexUpdate = findIndexByIdBook(idBook);
        if (indexUpdate == -1) {
            System.out.println("Mã sách không tồn tại");
            return;
        }
        // Thực hiện cập nhật.
        boolean isExist = true;
        do {
            System.out.println("1. Ten");
            System.out.println("2. Gia");
            System.out.println("3. Tac gia");
            System.out.println("4. Trang Thai");
            System.out.println("5. Thoat");
            System.out.println("Lua chon cua ban");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhap vao ten moi cua sach");
                    books[indexUpdate].setTitle(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Nhap vao gia moi cua sach");
                    books[indexUpdate].setPrice(Float.parseFloat(scanner.nextLine()));
                    break;
                case 3:
                    System.out.println("Nhap vao tac gia moi cua sach");
                    books[indexUpdate].setAuthor(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Nhap vao trang thai moi cua sach");
                    books[indexUpdate].setStatus(Boolean.parseBoolean(scanner.nextLine()));
                    break;
                case 5:
                    isExist = false;
                    break;
                default:
                    System.out.println("404");
            }
        } while (isExist);

    }

    public void deleteBook(Scanner scanner) {
        System.out.println("nhập vào id sách cần xoá:");
        String idBook = scanner.nextLine();
        int indexDelete = findIndexByIdBook(idBook);
        if (indexDelete == -1) {
            System.out.println("Mã sách không tồn tại");
            return;
        }
        // Xoá sách
        for (int i = indexDelete; i < currentIndex; i++) {
            books[i] = books[i + 1];
        }
        currentIndex--;
    }

    public void searchBook(Scanner scanner) {
        int cntBook = 0;
        System.out.println("Nhập tên sách cần tìm: ");
        String titleName = scanner.nextLine();
        for (int i = 0; i < currentIndex ; i++) {
            if (books[i].getTitle().toLowerCase().contains((titleName.toLowerCase()))) {}
            books[i].displayData();
            cntBook++;
        }
        System.out.printf("Tìm thấy %d sách ", cntBook);
    }

    public void sortBook() {
        for (int i = 0; i < currentIndex; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (books[i].getPrice() > books[j].getPrice()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }


    public int findIndexByIdBook(String idBook) {
        for (int i = 0; i < currentIndex; i++) {
            if (books[i].getId().equals(idBook)) {
                return i;
            }
        }
        return -1;
    }
}
