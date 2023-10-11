package View;

import Input.Validate;
import Manager.ProductManager;
import Model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
//        productManager.add(new Model.Product(1,"cà phê", 50, 25000, "Tốt"));
//        productManager.add(new Model.Product(2,"trà đá", 100, 5000, "Tốt"));
//        productManager.add(new Model.Product(3,"trà đào", 90, 20000, "Tốt"));
//        productManager.add(new Model.Product(4,"bạc sỉu", 70, 20000, "Tốt"));
//        productManager.add(new Model.Product(5,"trà tắc", 100, 10000, "Tốt"));
//        productManager.showAll();
        int choice;
        do {
            System.out.println("========== MENU QUẢN LÍ SẢN PHẨM ==========");
            System.out.println("1.Xem danh sách.");
            System.out.println("2.Thêm mới.");
            System.out.println("3.Cập nhật.");
            System.out.println("4.Xóa.");
            System.out.println("5.Sắp xếp.");
            System.out.println("6.Tìm sản phẩm có giá đắt nhất");
            System.out.println("9.Thoát.");
            choice = Validate.inputNumber();
            switch (choice) {
                case 1:
                    productManager.showAll(input);
                    break;
                case 2:
                    menuAdd(productManager);
                    break;
                case 3:
                    menuEdit(productManager);
                    break;
                case 4:
                    menuDelete(input, productManager);
                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Thông tin của sản phẩm có giá cao nhất là:");
                    for (Product product : productManager.findMaxPriceOfProduct()) {
                        System.out.println(product);
                    }
                    break;
                case 9:
                    break;
                default:
                    System.out.println("---------- Nhập sai lựa chọn, hãy nhập lại ----------");
            }
        } while (choice != 9);
    }

    private static void menuDelete(Scanner input, ProductManager productManager) {
        System.out.println("Nhập mã sản phẩm của sản phẩm bạn muốn xóa:");
        int idDelete = input.nextInt();
        if (productManager.checkId(idDelete) != -1) {
            String choiceDelete;
            System.out.println("Bạn có chắc chắn muốn xóa không?:");
            System.out.println("1. Ấn Y để xóa.");
            System.out.println("2. Ấn một kí tự bất kì khác  để không xóa. ");
            input.nextLine();
            choiceDelete = input.nextLine();
            if (choiceDelete.equals("Y")) {
                productManager.delete(idDelete);
                System.out.println("--------- Xóa thành công! ----------");
            } else {
                return;
            }
        } else {
            System.out.println("---------- Không có sản phẩm đó! ----------");
        }
    }

    private static void menuEdit(ProductManager productManager) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm của sản phẩm bạn muốn sửa:");
        int id = Validate.inputNumber();
        if (productManager.checkId(id) != -1) {
            System.out.println("Nhập mã sản phẩm bạn muốn sửa :");
            int editId = Validate.inputNumber();
            System.out.println("Nhập tên bạn muốn sửa:");
            String editName = Validate.inputString();
            System.out.println("Nhập số lượng bạn muốn sửa:");
            int editQuantity = Validate.inputNumber();
            System.out.println("Nhập giá cả bạn muốn sửa:");
            int editPrice = Validate.inputNumber();
            System.out.println("Nhập loại bạn muốn sửa:");
            String editDescribe = input.nextLine();
            productManager.edit(id, new Product(editId, editName, editQuantity, editPrice, editDescribe));


            System.out.println("---------- Sửa thành công! ----------");
        } else {
            System.out.println("---------- Không tìm được sản phẩm với mã sản phẩm trên! ----------");
        }
    }

    private static void menuAdd(ProductManager productManager) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm của sản phẩm:");
        int newId = Validate.inputNumber();
        if (productManager.checkId(newId) == newId) {
            System.out.println("---------- Bạn không được đặt trùng mã sản phẩm trước đó, hãy nhập lại!! ----------");
        } else {
            System.out.println("Nhập tên sản phẩm mới:");
            String newName = Validate.inputString();
            System.out.println("Nhập số lượng của sản phẩm mới:");
            int newQuantity = Validate.inputNumber();
            System.out.println("Nhập giá của sản phẩm mới:");
            int newPrice = Validate.inputNumber();
            System.out.println("Nhập loại của sản phẩm mới:");
            String newDescribe = input.nextLine();
            Product newProduct = new Product(newId, newName, newQuantity, newPrice, newDescribe);
            productManager.add(newProduct);
            System.out.println("---------- Thêm thành công! ----------");
        }
    }
}