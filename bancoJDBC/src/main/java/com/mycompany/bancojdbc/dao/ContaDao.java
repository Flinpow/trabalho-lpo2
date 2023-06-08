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
    ContaInvestimento contaInvestimento;
    ContaCorrente contaCorrente;
    
    public static void addContaCorrente (ContaCorrente contaCorrente, double depositoInicial) throws SQLException {
        Connection con = null;
       
       try {
           con = ConnectionFactory.getConnection();            
           
            String sql = "INSERT INTO ContaCorrente(saldo,clienteFk,limite) VALUES (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(depositoInicial));
            stmt.setString(2, contaCorrente.getDono().getCPF());
            stmt.setString(3, String.valueOf(contaCorrente.getLimite()));
            
            stmt.executeUpdate();
       }catch(SQLException ex) {
           System.out.println("Problemas ao salvar Conta Corrente");
           ex.printStackTrace();
       }finally{
           con.close();
       }
    }
    
     public static void addContaInvestimento (ContaInvestimento contaInvestimento, double depositoInicial) throws SQLException {
        Connection con = null;
       
       try {
           con = ConnectionFactory.getConnection();            
           
            String sql = "INSERT INTO ContaInvestimento(saldo,clienteFk, montanteMinimo,depositoMinimo) VALUES (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(depositoInicial));
            stmt.setString(2, contaInvestimento.getDono().getCPF());
            stmt.setString(3, String.valueOf(contaInvestimento.getMontanteMinimo()));
            stmt.setString(4, String.valueOf(contaInvestimento.getDepositoMinimo()));
            
            stmt.executeUpdate();
       }catch(SQLException ex) {
           System.out.println("Problemas ao salvar Conta Investimento");
           ex.printStackTrace();
       }finally{
           con.close();
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
