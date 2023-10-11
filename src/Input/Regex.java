package Input;

import java.util.Scanner;

public class Regex {
 static Scanner input = new Scanner(System.in);
//    validate dữ liệu: id phải là 3 chữ số trở lên, name: 6-8 ký tự, giá là số và nhỏ hơn 1000, số lượng nhỏ hơn 100
    public static String inputName(){
        String regex = "^[a-zA-ZÀ-ỹ\\s]{1,8}$";
        String inputName;
        do {
            inputName = input.nextLine();
            if(inputName.matches(regex)) {
                break;
            }
            System.out.println("Vui lòng nhập đúng số lượng kí tự!");
        }while (true);
        return inputName;
        }

        public static int inputPrice(){
        String regex = "^[0-9]{1,2}$";
        String inputPrice;
        do {
            inputPrice = input.nextLine();
            if(inputPrice.matches(regex)){
                break;
            }
            System.out.println("Vui lòng nhập số lại!");
        }while (true);
        return Integer.parseInt(inputPrice);
        }

    public static int inputQuantity(){
        String regex = "^[0-9]{1,2}$";
        String inputQuantity;
        do {
            inputQuantity = input.nextLine();
            if(inputQuantity.matches(regex)){
                break;
            }
            System.out.println("Vui lòng nhập số lại!");
        }while (true);
        return Integer.parseInt(inputQuantity);
    }
    public static int inputMenu() {
        String regex = "^[0-6]{1}$";
        String input1;
        do {
            System.out.println("Nhập đúng số để lựa chọn!");
            input1 = input.nextLine();
            if (input1.matches(regex)) {
                break;
            }
        } while (true);
        return Integer.parseInt(input1);
    }
    }
