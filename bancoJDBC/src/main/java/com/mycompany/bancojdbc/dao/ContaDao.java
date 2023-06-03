/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancojdbc.dao;

import com.mycompany.bancojdbc.model.Cliente;
import com.mycompany.bancojdbc.model.Conta;
import com.mycompany.bancojdbc.model.ContaCorrente;
import com.mycompany.bancojdbc.model.ContaInvestimento;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlphaPlayerOne
 */
public class ContaDao {
    Conta conta;
    ContaInvestimento contaInvestimento;
    ContaCorrente contaCorrente;
    
    public static void addContaCorrente (ContaCorrente contaCorrente, double saldo, Cliente cliente) throws SQLException {
        Connection con = null;
       
       try {
           con = ConnectionFactory.getConnection();
            addConta(saldo, cliente);
           
            String sql = "INSERT INTO ContaCorrente(contaFk,limite) VALUES (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, getContaIdByCpf(cliente.getCPF()));
            stmt.setString(2, String.valueOf(contaCorrente.getLimite()));
            
            stmt.executeUpdate();
       }catch(SQLException ex) {
           System.out.println("Problemas ao salvar Cliente");
           ex.printStackTrace();
       }finally{
           con.close();
       }
    }
    
   private static void addConta(double saldo, Cliente cliente) throws SQLException {
       Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "INSERT INTO Conta(saldo,clienteFk) VALUES (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(saldo));
            stmt.setString(2, cliente.getCPF());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
   } 
   
   private static String getContaIdByCpf(String cpf) throws SQLException {
        Connection con = null;
        String contaId = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "SELECT Conta.id FROM Conta WHERE Conta.clienteFk = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,cpf);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                contaId = rs.getString("id");
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            return contaId;
        }
   }
   
// private static ContaCorrente getContaCorrenteByCpf(String cpf) throws SQLException {
//        Connection con = null;
//        try {
//            con = ConnectionFactory.getConnection();
//            String sql = "SELECT * FROM Conta WHERE Conta.clienteFk = ?";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1,cpf);
//            ResultSet rs = stmt.executeQuery();
//            return rs.getString("id");
//        } catch (SQLException ex) {
//            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            con.close();
//            return null;
//        }
//   }
}
