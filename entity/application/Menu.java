/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.SQLException;
import java.util.Scanner;
import modelw.ClassModel;
import modelw.ScoreModel;
import modelw.StudentModel;

/**
 *
 * @author ngova
 */
public class Menu {

    static Scanner sc = new Scanner(System.in);

    public static void ShowMenu() throws SQLException {
        String choice;
        while (true) {
            System.out.println("~~~~Chao Mung Den Voi Hoc Vien VTCAcademy~~~~");
            System.out.println("==============================================");
            System.out.println(" 1.Quan li danh sach sinh vien");
            System.out.println(" 2.Quan li danh sach lop");
            System.out.println(" 3.Quan li diem thi");
            System.out.println(" 0.Thoat");
            System.out.println("==============================================");
            System.out.println("Moi nhap:");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    Student_list_manager();
                    break;
                case "2":
                    Class_List_Manager();
                    break;
                case "3":
                    Manage_Test_Scores();
                    break;
                case "0":
                    System.out.println("Exit the program!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhap sai moi nhap lai!");
                    break;

            }
        }

    }

    public static void Student_list_manager() throws SQLException {
        String choice;
        while (true) {
            System.out.println("-----Quan li danh sach sinh vien-----");
            System.out.println("1.Xem danh sach sinh vien");
            System.out.println("2.Cap nhap thong tin sinh vien");
            System.out.println("3.Them moi sinh vien");
            System.out.println("4.Xoa thong tin sinh vien");
            System.out.println("0.Tro ve menu chinh");
            System.out.println("-------------------------------------");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    StudentModel.display();
                    break;
                case "2":
                    StudentModel.updateStudent();
                    break;
                case "3":
                    StudentModel.addStudent();
                    break;
                case "4":
                    StudentModel.deleteStudent();
                    break;
                case "0":
                    ShowMenu();
                    break;
                default:
                    System.out.println("Nhap sai moi nhap lai");
                    break;
            }
        }

    }

    public static void Class_List_Manager() throws SQLException {
        String choice;
        while (true) {
            System.out.println("-----Quản lí danh sách lớp-----");
            System.out.println("1.Xem danh sách lớp");
            System.out.println("2.Cập nhập thông tin lớp");
            System.out.println("3.Thêm lớp mới");
            System.out.println("4.Xóa thông tin lớp");
            System.out.println("0.Trở về menu chính");
            System.out.println("--------------------------------");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    ClassModel.select();
                    break;
                case "2":
                    ClassModel.updateClass();
                    break;
                case "3":
                    ClassModel.addClass();
                    break;
                case "4":
                    ClassModel.deleteClass();
                    break;
                case "0":
                    ShowMenu();
                    break;
                default:
                    System.out.println("Nhập sai mời nhập lại!");
            }
        }

    }

    public static void Manage_Test_Scores() throws SQLException {
        String choice;
        while (true) {
            System.out.println("-----Quản lí điểm thi-----");
            System.out.println("1.Nhập vào điểm thi");
            System.out.println("2.Sửa điểm thi");
            System.out.println("3.Xóa điểm thi");
            System.out.println("4.Xem danh sách điểm thi");
            System.out.println("0.Trở về menu chính");
            System.out.println("--------------------------");
            choice=sc.nextLine();
            switch(choice){
                case "1":
                    ScoreModel.addScore();
                    break;
                case "2":
                    ScoreModel.updateScore();
                    break;
                case "3":
                    ScoreModel.deleteScore();
                    break;
                case "4":
                    ScoreModel.selectScore();
                    break;
                default:
                    break;
                
            }

        }

    }

}
