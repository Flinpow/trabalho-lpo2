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
    
    public static List<Cliente> getClientes() throws SQLException {
        List<Cliente> customers = new ArrayList();
        Connection con = null;
        
        try {
            con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM Cliente";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(); 
            
             while(rs.next()) {
                Cliente c = new Cliente(rs.getString("nome"), rs.getString("sobrenome"),rs.getString("cpf"), rs.getString("rg"), rs.getString("endereco"), Double.valueOf(rs.getString("salario")));
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
           if(ContaDao.getContaCorrenteByCpf(cpf)!=null || ContaDao.getContaInvestimentoByCpf(cpf) != null){
               ContaDao.excluirContasDoCliente(cpf);
           }
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
                cliente = new Cliente(rs.getString("nome"), rs.getString("sobrenome"),rs.getString("cpf"),rs.getString("rg"), rs.getString("endereco"),Double.valueOf(rs.getString("salario")));
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
    
    public static void updateCustomer(Cliente newCliente) throws SQLException {
        Connection con = null;
       
       try {
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE Cliente SET nome = ?, sobreNome = ?, rg = ?, endereco = ?, salario = ? WHERE cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, newCliente.getNome());
            stmt.setString(2, newCliente.getSobreNome());
            stmt.setString(3, newCliente.getRg());
            stmt.setString(4, newCliente.getEndereco());
            stmt.setString(5, String.valueOf(newCliente.getSalario()));
            stmt.setString(6, newCliente.getCPF());
            
            stmt.executeUpdate();
       }catch(SQLException ex) {
           System.out.println("Problemas ao atualizar Cliente");
           ex.printStackTrace();
       }finally{
           con.close();
       }
    }
    
}
