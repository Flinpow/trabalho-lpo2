/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancojdbc.model;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlphaPlayerOne
 */
public class ContaCorrente  extends Conta{
    
     private double limite;    
    
     public ContaCorrente(Cliente dono, double limite, int id, double saldo){
        super(dono,id,saldo);
        this.limite = limite;
    }
     
    public ContaCorrente(Cliente dono, double limite){
        super(dono);
        this.limite = limite;
    }

    @Override
    public boolean saca(double valor) throws SQLException{
        if((super.saldo - valor) > (0 - limite)){
             Connection con = null;
             double newSaldo = this.saldo - valor;
       
            try {
                con = ConnectionFactory.getConnection();            

                 String sql = "UPDATE ContaCorrente SET saldo = ? WHERE id = ?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, String.valueOf(newSaldo));
                 stmt.setString(2, String.valueOf(this.getNumero()));
                 
                 stmt.executeUpdate();
            }catch(SQLException ex) {
                System.out.println("Problemas ao Sacar");
                ex.printStackTrace();
            }finally{
                con.close();
            }
                 return true;
        }
        return false;
    }
    
    @Override
    public boolean deposita(double valor) throws SQLException {
           Connection con = null;
           double newSaldo = this.saldo + valor;
       
            try {
                con = ConnectionFactory.getConnection();            

                 String sql = "UPDATE ContaCorrente SET saldo = ? WHERE id = ?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, String.valueOf(newSaldo));
                 stmt.setString(2, String.valueOf(this.getNumero()));
                 
                 stmt.executeUpdate();
                 return true;
            }catch(SQLException ex) {
                System.out.println("Problemas ao Depositar");
                ex.printStackTrace();
                return false;
            }finally{
                con.close();
            }
                 
    }
    
    @Override
    public void remunera() throws SQLException{
        Connection con = null;
        double newSaldo = super.saldo += (super.saldo * 0.01);
        
         try {
                con = ConnectionFactory.getConnection();            

                 String sql = "UPDATE ContaCorrente SET saldo = ? WHERE id = ?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, String.valueOf(newSaldo));
                 stmt.setString(2, String.valueOf(this.getNumero()));
                 
                 stmt.executeUpdate();
                 
            }catch(SQLException ex) {
                System.out.println("Problemas ao Remunerar");
                ex.printStackTrace();
            }finally{
                con.close();
            }
    }  
 
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldo() {
        return super.saldo;
    }

    public void setSaldo(double saldo) {
        super.saldo = saldo;
    }

    
    
    
}
