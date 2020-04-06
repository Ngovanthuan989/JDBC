/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelw;

import application.Menu;
import com.mysql.cj.jdbc.PreparedStatement;
import connection.JDBCConnection;
import entity.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.Validate;

/**
 *
 * @author ngova
 */
public class StudentModel {

    static List<Student> DSSV = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() throws SQLException {
        while (true) {
            StudentModel sm = new StudentModel();
            Student std = new Student();
            String n;
            int t2 = 0;
            do {
                boolean kt = true;
                System.out.print("Nhap msv:");
                while (kt) {

                    n = new Validate().checkEmpty();

                    Pattern pattern = Pattern.compile("\\d*");
                    Matcher matcher = pattern.matcher(n);
                    if (matcher.matches()) {
                        std.id = Integer.parseInt(n);
                        System.out.println("Đã là số bạn vui lòng nhập lại để check!");
                        kt = false;
                    } else {
                        System.out.println("Bạn vừa nhập vào không phải số, vui lòng nhập lại !");
                        kt = true;
                    }

                }

                int b = sc.nextInt();

                DSSV = new StudentModel().selecRecord();

                int check = 0;
                for (int i = 0; i < DSSV.size(); i++) {

                    if (DSSV.get(i).getId() == b) {

                        check = 1;
                    }

                }

                if (check == 1) {
                    System.out.println("Mã sinh viên đã tồn tại .Vui lòng nhập mới");

                } else {
                    System.out.print("");
                    t2 = 1;
                }
            } while (t2 != 1);
            System.out.print("Nhap ten sinh vien:");
            String fullName = new Validate().checkString();
            std.setFullName(fullName);
            System.out.print("Nhap dia chỉ:");
            String address = new Validate().checkEmpty();
            std.setAddress(address);
            System.out.print("Nhap ngay sinh:");
            String dob = new Validate().checkNgaySinh();
            std.setDob(dob);
            System.out.print("Nhap gioi tinh:");
            String sex = new Validate().checkEmpty();
            std.setSex(sex);
            DSSV.add(std);
            sm.insertRecord(std);
            boolean is_type_wrong = true;
            while (is_type_wrong) {
                System.out.println("Bạn có muốn tiếp tục không(y/n)?");
                String yn = sc.nextLine();
                switch (yn) {
                    case "y":
                        is_type_wrong = false;
                        break;
                    case "n":
                        Menu.Student_list_manager();
                        break;
                    default:
                        System.out.println("Nhập sai mời nhập lại:");
                        is_type_wrong = true;
                        break;
                }
            }
        }

    }

    public static void updateStudent() throws SQLException {
        while (true) {
            StudentModel sm = new StudentModel();
            Student std = new Student();
            String n;
            int t2 = 0;
            do {
                boolean kt = true;
                System.out.println("Nhập mã sinh viên cần sửa:");
                while (kt) {

                    n = new Validate().checkEmpty();

                    Pattern pattern = Pattern.compile("\\d*");
                    Matcher matcher = pattern.matcher(n);
                    if (matcher.matches()) {
                        std.id = Integer.parseInt(n);
                        System.out.println("Đã là số bạn vui lòng nhập lại để check!");
                        kt = false;
                    } else {
                        System.out.println("Bạn vừa nhập vào không phải số, vui lòng nhập lại !");
                        kt = true;
                    }

                }
                int b = sc.nextInt();

                DSSV = new StudentModel().selecRecord();

                int check = 0;
                for (int i = 0; i < DSSV.size(); i++) {

                    if (DSSV.get(i).getId() == b) {
                        check = 1;
                    }

                }

                if (check == 1) {
                    System.out.println("Mã sinh viên đã tồn tại!");
                    t2 = 1;
                } else {
                    System.out.println("Mã sinh viên không tồn tại.Nhập lại!");

                }
            } while (t2 != 1);
            System.out.print("Sua ten sinh vien:");
            String fullName = sc.nextLine();
            std.setFullName(fullName);
            System.out.print("Sua dia chỉ:");
            String address = sc.nextLine();
            std.setAddress(address);
            System.out.print("Sua ngay sinh:");
            String dob = sc.nextLine();
            std.setDob(dob);
            System.out.print("Sua gioi tinh:");
            String sex = sc.nextLine();
            std.setSex(sex);
            DSSV.add(std);
            sm.updateRecord(std);
            boolean is_type_wrong = true;
            while (is_type_wrong) {
                System.out.println("Bạn có muốn tiếp tục không(y/n)?");
                String yn = sc.nextLine();
                switch (yn) {
                    case "y":
                        is_type_wrong = false;
                        break;
                    case "n":
                        Menu.Student_list_manager();
                        break;
                    default:
                        System.out.println("Nhập sai mời nhập lại:");
                        is_type_wrong = true;
                        break;
                }
            }

        }
    }

    public static void deleteStudent() throws SQLException {
        while (true) {
            StudentModel sm = new StudentModel();
            Student std = new Student();
            String n;
            int t2 = 0;
            do {
                boolean kt = true;
                System.out.println("Nhập mã sinh viên cần xóa:");
                while (kt) {
                 

                    n = new Validate().checkEmpty();

                    Pattern pattern = Pattern.compile("\\d*");
                    Matcher matcher = pattern.matcher(n);
                    if (matcher.matches()) {
                        std.id = Integer.parseInt(n);
                        System.out.println("Đã là số bạn vui lòng nhập lại để check!");
                        kt = false;
                    } else {
                        System.out.println("Bạn vừa nhập vào không phải số, vui lòng nhập lại !");
                        kt = true;
                    }

                }
                int b = sc.nextInt();

                DSSV = new StudentModel().selecRecord();

                int check = 0;
                for (int i = 0; i < DSSV.size(); i++) {

                    if (DSSV.get(i).getId() == b) {
                        check = 1;
                    }

                }

                if (check == 1) {
                    System.out.println("Mã sinh viên đã tồn tại!");
                    t2 = 1;
                } else {
                    System.out.println("Mã sinh viên không tồn tại.Nhập lại!");

                }
            } while (t2 != 1);
            DSSV.add(std);
            sm.deleteRecord(std);
            boolean is_type_wrong = true;
            while (is_type_wrong) {
                System.out.println("Bạn có muốn tiếp tục không(y/n)?");
                String yn = sc.nextLine();
                switch (yn) {
                    case "y":
                        is_type_wrong = false;
                        break;
                    case "n":
                        Menu.Student_list_manager();
                        break;
                    default:
                        System.out.println("Nhập sai mời nhập lại:");
                        is_type_wrong = true;
                        break;
                }
            }
        }

    }

    public void insertRecord(Student std) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            String sql_insert = "insert into student values('?',?','?','?','?')";
            preparedStatement = (PreparedStatement) connection.prepareStatement("INSERT INTO student VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, std.id);
            preparedStatement.setString(2, std.fullName);
            preparedStatement.setString(3, std.address);
            preparedStatement.setString(4, std.dob);
            preparedStatement.setString(5, std.sex);
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
            }

        }
    }

    public void updateRecord(Student std) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            String sql = "UPDATE student SET fullName=?, address=?, dob=?,sex=? WHERE id=?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            preparedStatement.setString(1, std.fullName);
            preparedStatement.setString(2, std.address);
            preparedStatement.setString(3, std.dob);
            preparedStatement.setString(4, std.sex);
            preparedStatement.setInt(5, std.id);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
            }

        }
    }

    public void deleteRecord(Student std) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            String delete_sql = "Delete from student where id=?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(delete_sql);

            preparedStatement.setInt(1, std.id);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
            }
            

        }
    }

    public static Student CheckDulicate(int idCheck) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();
        Statement stmt = connection.createStatement();
        try {

            String sql = "select * from student where id = " + idCheck;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int a = rs.getInt(1);

                String b = rs.getString(2);
                String c = rs.getString(3);
                String d = rs.getString(4);
                String e = rs.getString(5);

                return new Student(a, b, c, d, e);
            }

        } catch (SQLException ex) {
            return null;
        } finally {
            try {

                connection.close();
            } catch (SQLException ex) {
            }
        }
        return null;
    }

    public static ArrayList<Student> selecRecord() throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();
        Statement stmt = connection.createStatement();
        ArrayList<Student> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM student;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                int a = rs.getInt(1);

                String b = rs.getString(2);
                String c = rs.getString(3);
                String d = rs.getString(4);
                String e = rs.getString(5);

                list.add(new Student(a, b, c, d, e));
            }
            return list;

        } catch (SQLException ex) {
        } finally {
            try {

                connection.close();
            } catch (SQLException ex) {
            }
        }

        return null;
    }

    public static void display() throws SQLException {
        DSSV = new StudentModel().selecRecord();

        System.out.println("=====================================================================================");
        System.out.println(" Danh sach sinh vien");
        System.out.printf("| %-10s | %-15s | %-15s | %-15s | %-10s |\n", "MSSV", "Ten SV", "Dia chi", "Ngay sinh",
                "Giới tính");
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < DSSV.size(); i++) {

            System.out.printf("| %-10s | %-15s | %-15s | %-15s | %-10s |\n", DSSV.get(i).getId(),
                    DSSV.get(i).getFullName(), DSSV.get(i).getAddress(), DSSV.get(i).getDob(),
                    DSSV.get(i).getSex());

        }
        System.out.println("=====================================================================================");
    }

//        new StudentModel().display();
//
//        System.out.println("Nhap Id cach 2:");
//        int b = ab.nextInt();
//        //B1 : laly cai hét cái lít student
//
//        DSSV = new StudentModel().selecRecord();
//
//        int check = 0;
//        for (int i = 0; i < DSSV.size(); i++) {
//
//            // cai nay kiem tra thoi
//            if (DSSV.get(i).getId() == b) {
//                check = 1;
//            }
//
//        }
//
//        if (check == 1) {
//            System.out.println("ton tai r");
//        } else {
//            System.out.println("chua");
//        }
//
//    }
}
