package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManagement {
    public static ArrayList<Catalog>catalogs=new ArrayList<>();
    public static ArrayList<Product>products=new ArrayList<>();
    public  static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {

        while (true){
            System.out.println("""
                    ****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************
                    1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục
                    2. Nhập số sản phẩm và nhập thông tin các sản phẩm
                    3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần
                    4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm
                    5. Thoát
                    """);
            int choice= Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addNewCatalog();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    SortProduct();
                    break;
                case 4:
                    SeachCatalog();
                    break;
                case 5:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Nhập không đúng vui lòng lựa chọn lại.");

            }
        }
    }

    private static void SeachCatalog() {
        if (catalogs.isEmpty()){
            System.out.println("Sản phẩm đang trống");
        }else {
            System.out.println("Nhập danh muc bạn muốn tìm kiếm");
            String seachCatalog=scanner.nextLine();
            for (Product product:products) {
            product.getCatalog().equals(seachCatalog);
            System.out.println("Sản phẩm bạn tìm kiếm là:");
            product.displayData();
            return;
        }
            System.out.println("Không tìm thấy danh mục " +seachCatalog);
        }
    }

    private static void SortProduct() {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getExportPrice()-o2.getExportPrice());
            }
        });
        System.out.println("Danh sách sản phẩm sau khi sắp xếp :");
        for (Product product : products) {
         product.displayData();
        }
    }
    private static void addNewProduct() {
        System.out.println("Nhập số lượng sản phẩm cần thêm");
        int n= Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            Product product=new Product();
            product.inputData();
            products.add(product);
        }
        System.out.println("Thêm mới sản phẩm thành công");
    }

    private static void addNewCatalog() {
        System.out.println("Nhập số lượng danh mục sản phẩm cần thêm : ");
        int n= Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Catalog catalog=new Catalog();
            catalog.inputData();
            catalogs.add(catalog);
        }
        System.out.println("Thêm mới danh mục thành công.");
    }
}
