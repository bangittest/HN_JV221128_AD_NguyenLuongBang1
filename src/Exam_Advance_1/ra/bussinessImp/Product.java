package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;
import Exam_Advance_1.ra.run.ProductManagement;

import java.util.Scanner;

public class Product implements IShop {
    private static int nextId=1;
    private int productId;
    private String productName;
    private String title;
    private String description;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
        this.productId = nextId++;
    }

    public Product(String productName, String title, String description, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productName = productName;
        this.title = title;
        this.description = description;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }


    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm : ");
        this.productName=scanner.nextLine();
        System.out.println("Nhập tiêu đề sản phẩm : ");
        this.title=scanner.nextLine();
        System.out.println("Nhập mô tả sản phẩm : ");
        this.description=scanner.nextLine();

        System.out.println("Danh sách các danh mục:");
        for (int i = 0; i < ProductManagement.catalogs.size(); i++) {
            System.out.println(i + 1 + ". " + ProductManagement.catalogs.get(i).getCatalogName());
        }

        while (this.catalog == null) {
            System.out.println("Mời bạn nhập số của danh mục hoặc nhập 0 để tạo danh mục mới: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice >= 1 && choice <= ProductManagement.catalogs.size()) {
                this.catalog = ProductManagement.catalogs.get(choice - 1);
            } else if (choice == 0) {
                System.out.println("Tạo danh mục mới:");
                Catalog newCatalog = new Catalog();
                newCatalog.inputData();
                ProductManagement.catalogs.add(newCatalog);
                this.catalog = newCatalog;
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn một danh mục hợp lệ hoặc nhập 0 để tạo danh mục mới.");
            }
        }


        System.out.println("Nhập giá sản phẩm ");
        this.importPrice= Float.parseFloat(scanner.nextLine());
        this.exportPrice= this.importPrice * RATE;
        System.out.println("Nhập trạng thái sản phẩm ");
        this.productStatus= Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm :" +productId);
        System.out.println("Tên sản phẩm :" +productName);
        System.out.println("Tiêu đề sản phẩm :" +title);
        System.out.println("Mô tả sản phẩm :" + description);
        System.out.println("Danh mục :" +catalog.getCatalogName());
        System.out.println("Giá nhập :" +importPrice);
        System.out.println("Giá xuất :" +exportPrice);
        System.out.println("Trạng thái : "+productStatus);
    }

}
