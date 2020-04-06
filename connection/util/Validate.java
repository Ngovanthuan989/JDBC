
 package util;

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;

public class Validate {

    public String checkEmpty() {

        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("khong duoc de trong.Moi nhap lai!");
                continue;
            }
            return input;
        }
    }

    /**
     * co 2 cach dung 1 la try catch hai dung regex
     */
    //diem thi chi la tu 0 - 10
    // 100
    //truong hop nhap diem truyen min : 0 truyen max la 10
    //truong hop validate so thoi : -100 den 100 
    public float checkFloat(float min, float max) {
        Scanner sc = new Scanner(System.in);
        float number = 0;
        while (true) {
            String stringNumber = new Validate().checkEmpty();

            if (stringNumber.matches("[0-9]+")) {
                number = Float.valueOf(stringNumber);
                if (number < min || number > max) {
                    System.out.println("Diem thi toi da tu 0-10 va khong duoc nhap chu.Moi ban nhap lai!");
                    continue;
                }
                return number;
            } else {
                System.out.println("Diem thi toi da tu 0-10 va khong duoc nhap chu.Moi ban nhap lai!");
            }
        }

    }

    public String checkString() {

        Scanner sc = new Scanner(System.in);
        while (true) {
            // name nafy chi bien tam thoi de kiem tra
            String name = new Validate().checkEmpty();
            if (name.matches("[a-z A-Z]+")) {

                return name;
            } else {
                System.out.println(" Day la ten khong duoc nhap so hay ki tu dac biet.Moi nhap lai");
            }

        }

    }
    

    public String checkNgaySinh() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String ngaySinh = new Validate().checkEmpty();
            if (ngaySinh.matches("^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$")) {

                return ngaySinh;
            } else {
                System.out.println(" Day la ngay sinh xin hay nhap nhu huong dan.Moi nhap lai");
            }

        }

    }

    public static void main(String[] args) {
        float a = new Validate().checkFloat(0, 10);
    }
}
