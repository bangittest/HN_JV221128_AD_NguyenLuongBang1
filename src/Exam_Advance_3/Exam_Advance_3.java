package Exam_Advance_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam_Advance_3 {
    static Queue<String> parentList = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {


            int choice;
            do {
                System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
                System.out.println("1. Nhập tên phụ huynh nộp hồ sơ");
                System.out.println("2. Phụ huynh tiếp theo");
                System.out.println("3. Thoát");
                System.out.print("Chọn: ");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                      addParent();
                        break;
                    case 2:
                        nextParents();
                        break;
                    case 3:
                        System.out.println("thoát khỏi chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại.");
                }
            } while (choice != 3);

            scanner.close();
        }

    private static void nextParents() {
        if (!parentList.isEmpty()) {
            String next = parentList.poll();
            System.out.println("Phụ huynh tiếp theo: " + next);
        } else {
            System.out.println("Không còn phụ huynh trong danh sách.");
        }
    }

    private static void addParent() {
        System.out.print("Nhập tên phụ huynh: ");
        String parentName = scanner.nextLine();
        parentList.offer(parentName);
    }
}

