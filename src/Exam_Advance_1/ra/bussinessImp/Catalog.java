package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.Scanner;

public class Catalog implements IShop {
    private static int nextId=1;
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private boolean catalogStatus;

    public Catalog() {
        this.catalogId = nextId++;
    }

    public Catalog(String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập tên danh mục sản phẩm : ");
        this.catalogName=scanner.nextLine();
        System.out.println("Nhập độ ưu tiên : ");
        this.priority= Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả danh muc : ");
        this.descriptions=scanner.nextLine();
        System.out.println("Nhập trạng thái danh mục(true/false) : ");
        this.catalogStatus= Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Mã danh mục sản phẩm :" +catalogId);
        System.out.println("Tên danh mục sản phẩm :" +catalogName) ;
        System.out.println("Độ ưu tiên " +priority);
        System.out.println("Mô tả danh mục :" +descriptions);
        System.out.println("Trạng thái danh muc " +catalogStatus);
    }
}
