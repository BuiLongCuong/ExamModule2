package Manager;

import Model.Product;
import Util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> list;
    private ReadAndWriteFile readAndWriteFile;

    public ProductManager() {
        readAndWriteFile = new ReadAndWriteFile();
        this.list = readAndWriteFile.readFile();
    }

    public void add(Product newProduct){
        list.add(newProduct);
        readAndWriteFile.writeFile(list);
    }
    public void showAll(Scanner input){
        int count =0;
        if(list.isEmpty()){
            System.out.println("---------- Chưa có sản phẩm nào cả!! ----------");
        }else {
            for (Product product : list) {
                System.out.println(product);
                count++;
                if(count ==5 ){
                    System.out.println("Ấn thêm 1 lần Enter nếu bạn muốn xem thêm sản phẩm!!");
                    count = 0;
                    input.nextLine();
                }
            }
        }
    }
    public int checkId(int id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id){
                return i;
            }
        }
        return -1;

    }
//    public void edit(int id, String name, int quantity, int price, String describe){
//            for (Model.Product product : list) {
//                if(product.getId() == id){
//                    product.setId(id);
//                    product.setName(name);
//                    product.setQuantity(quantity);
//                    product.setPrice(price);
//                    product.setDescribe(describe);
//                    break;
//                }
//            }
//        readAndWriteFile.writeFile(list);
//    }
    public void delete(int id){
        list.remove(id-1);
        readAndWriteFile.writeFile(list);
    }
   public ArrayList<Product> findMaxPriceOfProduct(){
        ArrayList<Product> listReturn = new ArrayList<>();
        Product maxPriceOfProduct = list.get(0);
       for (Product product1 : list) {
           for (Product product2: list) {
               if(product2.getPrice() > maxPriceOfProduct.getPrice()){
                   maxPriceOfProduct = product2;
                   listReturn.add(maxPriceOfProduct);
               }
           }
           if(product1.getPrice() == maxPriceOfProduct.getPrice()){
               listReturn.add(product1);
           }
       }
       return listReturn;
   }

    public void edit(int id, Product updateProduct) {
        list.set(checkId(id), updateProduct);
        readAndWriteFile.writeFile(list);
    }
}
