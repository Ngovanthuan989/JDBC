/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import static application.Menu.ShowMenu;
import java.sql.Connection;
import static connection.JDBCConnection.getJDBCConnection;
import java.sql.SQLException;

/**
 *
 * @author ngova
 */
public class DuAn3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        Connection connection = getJDBCConnection();
        if (connection!=null) {
            System.out.println("Ket noi thanh cong!");
        }else{
            System.out.println("Loi ket noi!");
        }
        ShowMenu();
    }

  


   
    
    
}
