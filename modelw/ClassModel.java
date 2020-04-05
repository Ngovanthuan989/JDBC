/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelw;

import application.Menu;
import com.mysql.cj.jdbc.PreparedStatement;
import connection.JDBCConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.ClassMe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.Validate;

/**
 *
 * @author ngova
 */
public class ClassModel {

    static List<ClassMe> CL = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addClass() throws SQLException {
        while (true) {
            ClassModel sm = new ClassModel();
            ClassMe cl = new ClassMe();

            String n;
            int t = 0;
            do {
                System.out.println("Nhập mã lớp:");
                n = new Validate().checkEmpty();

                Pattern pattern = Pattern.compile("\\d*");
                Matcher matcher = pattern.matcher(n);
                if (matcher.matches()) {
                    cl.IDClass = Integer.parseInt(n);
                    t = 1;
                } else {
                    System.out.println("Bạn vừa nhập vào không phải số, vui lòng nhập lại !");
                }
            } while (t != 1);

            System.out.println("Nhập giảng viên:");
            String teacher = new Validate().checkString();
            cl.setLecturers(teacher);
            System.out.println("Nhập mô tả lớp:");
            String mtl = new Validate().checkEmpty();
            cl.setClassDescription(mtl);
            System.out.println("Nhập ngày học:");
            String day = new Validate().checkEmpty();
            cl.setSchoolDay(day);
            System.out.println("Nhập thời gian học:");
            String time = new Validate().checkEmpty();
            cl.setClassTime(time);
            CL.add(cl);
            sm.Insert(cl);
            boolean kt = true;
            while (kt) {
                System.out.println("Bạn có muốn tiếp tục không(y/n)");
                String yn = sc.nextLine();
                switch (yn) {
                    case "y":
                        kt = false;
                        break;
                    case "n":
                        Menu.Class_List_Manager();
                        kt = false;
                        break;
                    default:
                        System.out.println("Nhập sai mời nhập lại!");
                        kt = true;

                }
            }
        }

    }

    public static void updateClass() throws SQLException {
        while (true) {
            ClassModel sm = new ClassModel();
            ClassMe cl = new ClassMe();
              String n;
            int t = 0;
            do {
                System.out.println("Nhập mã lớp:");
                n = new Validate().checkEmpty();

                Pattern pattern = Pattern.compile("\\d*");
                Matcher matcher = pattern.matcher(n);
                if (matcher.matches()) {
                    cl.IDClass = Integer.parseInt(n);
                    t = 1;
                } else {
                    System.out.println("Bạn vừa nhập vào không phải số, vui lòng nhập lại !");
                }
            } while (t != 1);
            System.out.println("Sửa giảng viên:");
            String gv = new Validate().checkString();
            cl.setLecturers(gv);
            System.out.println("Sửa mô tả lớp:");
            String mtl = new Validate().checkEmpty();
            cl.setClassDescription(mtl);
            System.out.println("Sửa ngày học");
            String ngh = new Validate().checkEmpty();
            cl.setSchoolDay(ngh);
            System.out.println("Sửa thời gian học:");
            String time = new Validate().checkEmpty();
            cl.setClassTime(time);
            CL.add(cl);
            sm.update(cl);
            boolean is_type_wrong = true;
            while (is_type_wrong) {
                System.out.println("Ban có muốn tiếp tục không(y/n)");
                String yn = sc.nextLine();
                switch (yn) {
                    case "y":
                        is_type_wrong = false;
                        break;
                    case "n":
                        Menu.Class_List_Manager();
                        is_type_wrong = false;
                        break;
                    default:
                        System.out.println("Nhập sai mời nhập lại!");
                        is_type_wrong = true;
                }
            }
        }

    }

    public static void deleteClass() throws SQLException {
        while (true) {
            ClassModel sm = new ClassModel();
            ClassMe cl = new ClassMe();
            System.out.println("Nhập mã lớp cần xóa:");
            String id = sc.nextLine();
            cl.IDClass = Integer.parseInt(id);
            CL.add(cl);
            sm.delete(cl);
            boolean kt = true;
            while (kt) {
                System.out.println("Bạn có muốn tiếp tục không!");
                String yn = sc.nextLine();
                switch (yn) {
                    case "y":
                        kt = false;
                        break;
                    case "n":
                        Menu.Class_List_Manager();
                        kt = false;
                        break;
                    default:
                        kt = true;
                        break;
                }
            }
        }

    }

    public void Insert(ClassMe cl) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            String sql_insert = "insert into class values('?',?','?','?','?')";
            preparedStatement = (PreparedStatement) connection.prepareStatement("INSERT INTO class VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, cl.IDClass);
            preparedStatement.setString(2, cl.Lecturers);
            preparedStatement.setString(3, cl.ClassDescription);
            preparedStatement.setString(4, cl.SchoolDay);
            preparedStatement.setString(5, cl.ClassTime);
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

    public void update(ClassMe cl) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            String sql = "UPDATE class SET Lecturers=?, ClassDescription=?, SchoolDay=?,ClassTime=? WHERE IDClass=?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            preparedStatement.setString(1, cl.Lecturers);
            preparedStatement.setString(2, cl.ClassDescription);
            preparedStatement.setString(3, cl.SchoolDay);
            preparedStatement.setString(4, cl.ClassTime);
            preparedStatement.setInt(5, cl.IDClass);

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

    public static void select() throws SQLException {
        Connection connection = JDBCConnection.getJDBCConnection();
        Statement stmt = connection.createStatement();
        try {
            String sql = "SELECT * FROM class;";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("=====================================================================================");
            System.out.println(" Danh sach lop");
            System.out.printf("| %-10s | %-15s | %-15s | %-15s | %-10s |\n", "Mã lớp", "Giảng viên", "Mô tả lớp", "Ngày hoc",
                    "Gio hoc");
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
    }

    public void delete(ClassMe cl) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            String delete_sql = "Delete from class where IDClass=?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(delete_sql);

            preparedStatement.setInt(1, cl.IDClass);

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

}
