/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelw;

import application.Menu;
import connection.JDBCConnection;
import entity.Score;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static modelw.StudentModel.DSSV;
import static modelw.StudentModel.sc;
import util.Validate;

/**
 *
 * @author ngova
 */
public class ScoreModel {

    static List<Score> SCR = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addScore() throws SQLException {
        while (true) {
            ScoreModel sm = new ScoreModel();
            Score s = new Score();
            String n;
            int t = 0;
            do {
                System.out.print("Nhập id:");
                n = new Validate().checkEmpty();

                Pattern pattern = Pattern.compile("\\d*");
                Matcher matcher = pattern.matcher(n);
                if (matcher.matches()) {
                    s.id = Integer.parseInt(n);
                    t = 1;
                } else {
                    System.out.println("Bạn vừa nhập vào không phải số, vui lòng nhập lại !");
                }
            } while (t != 1);

            String n2;
            int t2 = 0;
            do {
                System.out.print("Nhập mã sinh viên:");
                n2 = new Validate().checkEmpty();

                Pattern pattern = Pattern.compile("\\d*");
                Matcher matcher = pattern.matcher(n2);
                if (matcher.matches()) {
                    s.studentID = Integer.parseInt(n2);
                    t2 = 1;
                } else {
                    System.out.println("Bạn vừa nhập vào không phải số, vui lòng nhập lại !");
                }
            } while (t2 != 1);
            System.out.print("Nhập điểm thi:");
            String d = sc.nextLine();
            s.ExamScore = Integer.parseInt(d);
            System.out.print("Nhập môn thi:");
            String mt = new Validate().checkEmpty();
            s.setExamSubject(mt);
            SCR.add(s);
            sm.insertScore(s);
            boolean ch = true;
            while (ch) {
                System.out.println("Bạn có muốn tiếp tục không(y/n)?");
                String yn =sc.nextLine();
                switch (yn) {
                    case "y":
                        ch = false;
                        break;
                    case "n":
                        Menu.Manage_Test_Scores();
                        ch = false;
                        break;
                    default:
                        System.out.println("Nhập sai mời nhập lại!");
                        ch = true;
                        break;
                }
            }
        }

    }
        
    public static void updateScore() throws SQLException {
        while (true) {
            ScoreModel sm = new ScoreModel();
            Score s = new Score();
            String n2;
            int t2 = 0;
            do {
                System.out.print("Nhập mã sinh viên:");
                n2 = new Validate().checkEmpty();

                Pattern pattern = Pattern.compile("\\d*");
                Matcher matcher = pattern.matcher(n2);
                if (matcher.matches()) {
                    s.studentID = Integer.parseInt(n2);
                    t2 = 1;
                } else {
                    System.out.println("Bạn vừa nhập vào không phải số, vui lòng nhập lại !");
                }
            } while (t2 != 1);
            System.out.print("Sửa điểm thi:");
            String d = sc.nextLine();
            s.ExamScore = Integer.parseInt(d);
            System.out.print("Sửa môn thi:");
            String mt = new Validate().checkEmpty();
            s.setExamSubject(mt);
            SCR.add(s);
            sm.updateScore(s);
            boolean ch = true;
            while (ch) {
                System.out.println("Bạn có muốn tiếp tục không(y/n)?");
                String yn = sc.nextLine();
                switch (yn) {
                    case "y":
                        ch = false;
                        break;
                    case "n":
                        Menu.Manage_Test_Scores();
                        ch = false;
                        break;
                    default:
                        System.out.println("Nhập sai mời nhập lại!");
                        ch = true;
                        break;
                }
            }
        }

    }

    public static void deleteScore() throws SQLException {
        while (true) {
            Score s = new Score();
            ScoreModel sm = new ScoreModel();
            System.out.println("Nhập mã sinh viên cần xóa:");
            String id = sc.nextLine();
            s.studentID = Integer.parseInt(id);
            SCR.add(s);
            sm.deleteScore(s);
            boolean ch = true;
            while (ch) {
                System.out.println("Bạn có muốn tiếp tục không(y/n)?");
                String yn = sc.nextLine();
                switch (yn) {
                    case "y":
                        ch = false;
                        break;
                    case "n":
                        Menu.Manage_Test_Scores();
                        ch = false;
                        break;
                    default:
                        System.out.println("Nhập sai mời nhập lại:");
                        ch = true;
                        break;
                }
            }
        }

    }

    public void insertScore(Score sr) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            String sql_insert = "insert into score values(?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql_insert);
            preparedStatement.setInt(1, sr.id);
            preparedStatement.setInt(2, sr.studentID);
            preparedStatement.setInt(3, sr.ExamScore);
            preparedStatement.setString(4, sr.ExamSubject);
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

    public void updateScore(Score sr) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            String sql_update = "update score set ExamScore=?,ExamSubject=? where studentID=?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql_update);
            preparedStatement.setInt(1, sr.ExamScore);
            preparedStatement.setString(2, sr.ExamSubject);
            preparedStatement.setInt(3, sr.studentID);
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

    public static void selectScore() throws SQLException {
        Connection connection = JDBCConnection.getJDBCConnection();
        Statement stm = connection.createStatement();
        try {
            String select_sql = "select student.id,student.fullName,score.examSubject,score.examScore from score"
                    + " inner join student on student.id=score.studentID";
            ResultSet rs = stm.executeQuery(select_sql);
            System.out.println("=====================================================================================");
            System.out.println(" Danh sach sinh vien");
            System.out.printf("| %-10s | %-15s | %-15s | %-15s |\n", "MSSV", "Tên SV", "Môn thi", "Điểm thi"
            );
            System.out.println("-------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("| %-10s | %-15s | %-15s | %-15s |\n", rs.getInt(1) + "  ", rs.getString(2) + "  ",
                        rs.getString(3) + "  ", rs.getInt(4));

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
    public void deleteScore(Score sr) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            String delete_sql = "Delete from score where studentID=?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(delete_sql);
            preparedStatement.setInt(1, sr.studentID);
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
