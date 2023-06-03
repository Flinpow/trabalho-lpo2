/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancojdbc.dao;

import com.mycompany.bancojdbc.model.Cliente;
import org.apache.commons.lang3.StringUtils;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlphaPlayerOne
 */
public class ClienteDao {
    
    public static void addCustomer(Cliente c) throws SQLException {
       Connection con = null;
       
       try {
            con = ConnectionFactory.getConnection();
            String sql = "INSERT INTO Cliente(nome, sobrenome, cpf, rg, endereco, salario) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getSobreNome());
            stmt.setString(3, c.getCPF());
            stmt.setString(4, c.getRg());
            stmt.setString(5, c.getEndereco());
            stmt.setString(6, String.valueOf(c.getSalario()));
            
            stmt.executeUpdate();
       }catch(SQLException ex) {
           System.out.println("Problemas ao salvar Cliente");
           ex.printStackTrace();
       }finally{
           con.close();
       }
        
    }
    
    public static List<Cliente> getCustomers() throws SQLException {
        List<Cliente> customers = new ArrayList();
        Connection con = null;
        
        try {
            con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM Cliente";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(); 
            
             while(rs.next()) {
                Cliente c = new Cliente(rs.getString("nome"), rs.getString("sobrenome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("endereco"), Double.valueOf(rs.getString("salario")));
                customers.add(c);
            }
        }catch(SQLException ex) {
            System.out.println("Problemas ao consultar clientes do banco");
            ex.printStackTrace();
        }finally{
            con.close();
        }   
        return customers;
    }
    
    public static void deleteCustomer(String cpf) throws SQLException {
        Connection con = null;
       
       try {
            con = ConnectionFactory.getConnection();
            String sql = "DELETE FROM Cliente WHERE Cliente.cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            
            stmt.executeUpdate();
       }catch(SQLException ex) {
           System.out.println("Problemas ao excluir Cliente");
           ex.printStackTrace();
       }finally{
           con.close();
       }
    }
    
    public static Cliente getClienteByCpf(String cpf) throws SQLException {
        Connection con = null;
        Cliente cliente = null;
       
       try {
            con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM Cliente WHERE Cliente.cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
             while(rs.next()) {
                cliente = new Cliente(rs.getString("nome"), rs.getString("sobrenome"),rs.getString("rg"), rs.getString("cpf"), rs.getString("endereco"),Double.valueOf(rs.getString("salario")));
                return cliente;
             }
       }catch(SQLException ex) {
           System.out.println("Problemas ao buscar Cliente");
           ex.printStackTrace();
       }finally{
           con.close();
       }
       return cliente;
    }
    
    // Lógica de atualização do cliente sujeita a mudanças
    public static void updateCustomerName(String name, String cpf) throws SQLException {
        Connection con = null;
       
       try {
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE Cliente SET nome = ? WHERE cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, cpf);
            
            stmt.executeUpdate();
       }catch(SQLException ex) {
           System.out.println("Problemas ao atualizar Cliente");
           ex.printStackTrace();
       }finally{
           con.close();
       }
    }
    
    public static void updateCustomerLastName(String lastName, String cpf) throws SQLException {
        Connection con = null;
       
       try {
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE Cliente SET sobrenome = ? WHERE cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, lastName);
            stmt.setString(2, cpf);
            
            stmt.executeUpdate();
       }catch(SQLException ex) {
           System.out.println("Problemas ao atualizar Cliente");
           ex.printStackTrace();
       }finally{
           con.close();
       }
    }
    
    public static void updateCustomerRg(String rg, String cpf) throws SQLException {
        Connection con = null;
       
       try {
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE Cliente SET rg = ? WHERE cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, rg);
            stmt.setString(2, cpf);
            
            stmt.executeUpdate();
       }catch(SQLException ex) {
           System.out.println("Problemas ao atualizar Cliente");
           ex.printStackTrace();
       }finally{
           con.close();
       }
    }
    
    public static void updateCustomerAdress(String adress, String cpf) throws SQLException {
        Connection con = null;
       
       try {
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE Cliente SET endereco = ? WHERE cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, adress);
            stmt.setString(2, cpf);
            
            stmt.executeUpdate();
       }catch(SQLException ex) {
           System.out.println("Problemas ao atualizar Cliente");
           ex.printStackTrace();
       }finally{
           con.close();
       }
    }
    
    public static void updateCustomerSalary(Double salary, String cpf) throws SQLException {
        Connection con = null;
       
       try {
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE Cliente SET salario = ? WHERE cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, String.valueOf(salary));
            stmt.setString(2, cpf);
            
            stmt.executeUpdate();
       }catch(SQLException ex) {
           System.out.println("Problemas ao atualizar Cliente");
           ex.printStackTrace();
       }finally{
           con.close();
       }
    }
    
    private static String buildSqlUpdate(Cliente c) {
        String sql = "UPDATE Cliente SET ";
        if (StringUtils.isNotBlank(c.getNome())) {
            sql += "nome = ? ";
        } else if(StringUtils.isNotBlank(c.getSobreNome())) {
            sql += "sobrenome = ? ";
        } else if(StringUtils.isNotBlank(c.getRg())) {
            sql += "rg = ? ";
        } else if(StringUtils.isNotBlank(c.getEndereco())) {
            sql += "endereco = ? ";
        } else if(c.getSalario() > 0) {
            sql += "salario = ? ";
        }
        sql += "WHERE cpf = " + c.getCPF();
        return sql;
    }
}
