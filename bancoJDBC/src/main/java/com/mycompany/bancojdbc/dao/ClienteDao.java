/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancojdbc.dao;

import com.mycompany.bancojdbc.model.Cliente;
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
    
    public static void addCliente(Cliente c) throws SQLException {
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
        List<Cliente> clientes = new ArrayList();
        Connection con = null;
        
        try {
            con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM Cliente";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(); 
            
             while(rs.next()) {
                Cliente c = new Cliente(rs.getString("nome"), rs.getString("sobrenome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("endereco"), Double.valueOf(rs.getString("salario")));
                clientes.add(c);
            }
        }catch(SQLException ex) {
            System.out.println("Problemas ao consultar clientes do banco");
            ex.printStackTrace();
        }finally{
            con.close();
        }   
        return clientes;
    }
}
