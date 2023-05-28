/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author AlphaPlayerOne
 */
public class ConnectionFactory {
    
    public static Connection getConnection()throws SQLException {
        String dataBase = "trabalholpo2";
        String userDb = "root";
        String senhaDb = "root";
        
        Connection conection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return conection = DriverManager.getConnection("jdbc:mysql://localhost/" + dataBase, userDb, senhaDb);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado");
        } catch (SQLException ex) {
            System.out.println("Erro ao acessar o banco: " + ex.getMessage());
        }
        return null;
    }
    
}

