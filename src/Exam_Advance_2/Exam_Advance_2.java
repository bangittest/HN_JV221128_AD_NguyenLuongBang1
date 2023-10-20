package Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Exam_Advance_2 {
    static Stack<String> stack = new Stack<>();
    static Scanner scanner = new Scanner(System.in);
    static String sentence = "";
        public static void main(String[] args) {


            while (true) {
                System.out.println("""
                        ****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************
                        1. Nhập câu
                        2. Đảo ngược câu
                        3. Thoát
                        """);
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                       addExam();
                        break;
                    case 2:
                        reverseExam();
                        break;
                    case 3:
                        System.out.println("Kết thúc chương trình.");
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        break;
                }
            }
        }

    private static void addExam() {
        System.out.print("Nhập câu: ");
        sentence = scanner.nextLine();
    }

    private static void reverseExam() {
        if (!sentence.isEmpty()) {
            stack.clear();
            String[] words = sentence.split(" ");
            for (String word : words) {
                stack.push(word);
            }

            System.out.print("Câu đảo ngược: ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        } else {
            System.out.println("Bạn cần nhập câu trước.");
        }
    }
}

