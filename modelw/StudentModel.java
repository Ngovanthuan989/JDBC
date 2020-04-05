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
            
            String n2;
            int t2 = 0;
            do {
                System.out.print("Nhập mã sinh viên:");
                n2 = new Validate().checkEmpty();

                Pattern pattern = Pattern.compile("\\d*");
                Matcher matcher = pattern.matcher(n2);
                if (matcher.matches()) {
                    std.id = Integer.parseInt(n2);
                    t2 = 1;
                } else {
                    System.out.println("Bạn vừa nhập vào không phải số, vui lòng nhập lại !");
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
            
            String n2;
            int t2 = 0;
            do {
                System.out.print("Nhập mã sinh viên:");
                n2 = new Validate().checkEmpty();

                Pattern pattern = Pattern.compile("\\d*");
                Matcher matcher = pattern.matcher(n2);
                if (matcher.matches()) {
                    std.id = Integer.parseInt(n2);
                    t2 = 1;
                } else {
                    System.out.println("Bạn vừa nhập vào không phải số, vui lòng nhập lại !");
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
            System.out.println("Nhập ID sinh viên cần xóa:");
            String id = sc.nextLine();
            std.id = Integer.parseInt(id);
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

    public static void selecRecord() throws SQLException {
//        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        Statement stmt = connection.createStatement();
        try {
            String sql = "SELECT * FROM student;";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("=====================================================================================");
            System.out.println(" Danh sach sinh vien");
            System.out.printf("| %-10s | %-15s | %-15s | %-15s | %-10s |\n", "MSSV", "Ten SV", "Dia chi", "Ngay sinh",
                    "GioiTinh");
            System.out.println("-------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("| %-10s | %-15s | %-15s | %-15s | %-10s |\n", rs.getInt(1) + "  ", rs.getString(2) + "  ", rs.getString(3) + "  ", rs.getString(4) + "  ", rs.getString(5));

            }
            System.out.println("-------------------------------------------------------------------------------------");
        } catch (SQLException ex) {
        } finally {
            try {

                connection.close();
            } catch (SQLException ex) {
            }
        }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } 
//
//        }
    }
}
