package Input;

import java.util.Scanner;

public class Validate {
   static Scanner input = new Scanner(System.in);
    public static int inputNumber(){
        int intoNumber;
        do {
            try{
                intoNumber = Integer.parseInt(input.nextLine());
                return intoNumber;
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số!");
            }
        }while (true);
    }
    public static String inputString(){
        do {
            try {
                String intoString = input.nextLine();
                for (char checkString : intoString.toCharArray()) {
                    if (Character.isDigit(checkString)) {
                        throw new NumberFormatException();
                    }
                }
                return intoString;
            } catch (NumberFormatException e) {
                System.out.println("---------- Bạn đã nhập số, vui lòng nhập lại chữ! ----------");
            }
        } while (true);
    }
}
