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


public class ContaInvestimento extends Conta{

    private double montanteMinimo;
    private double depositoMinimo;
    
     public ContaInvestimento(Cliente cliente, double montanteMinimo, double depositoMinimo, int id, double saldo){
        super(cliente,id,saldo);
        this.montanteMinimo = montanteMinimo;
        this.depositoMinimo = depositoMinimo;
    }
    
      public ContaInvestimento(Cliente cliente, double montanteMinimo, double depositoMinimo){
        super(cliente);
        this.montanteMinimo = montanteMinimo;
        this.depositoMinimo = depositoMinimo;
    }
    
    @Override
    public boolean deposita(double valor) throws SQLException{
        Connection con = null;
        if(valor >= depositoMinimo){ 
            double newSaldo = this.saldo + valor;
             try {
                con = ConnectionFactory.getConnection();            

                 String sql = "UPDATE ContaInvestimento SET saldo = ? WHERE id = ?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, String.valueOf(newSaldo));
                 stmt.setString(2, String.valueOf(this.getNumero()));
                 
                 stmt.executeUpdate();
            }catch(SQLException ex) {
                System.out.println("Problemas ao Depositar");
                ex.printStackTrace();
            }finally{
                con.close();
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean saca(double valor) throws SQLException {
        if((super.saldo - valor) >= montanteMinimo){ 
             Connection con = null;
             double newSaldo = this.saldo - valor;
       
            try {
                con = ConnectionFactory.getConnection();            

                 String sql = "UPDATE ContaInvestimento SET saldo = ? WHERE id = ?";
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
    public void remunera() throws SQLException{
         Connection con = null;
        double newSaldo = super.saldo += (super.saldo * 0.02);
        
         try {
                con = ConnectionFactory.getConnection();            

                 String sql = "UPDATE ContaInvestimento SET saldo = ? WHERE id = ?";
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

    public double getMontanteMinimo() {
        return montanteMinimo;
    }

    public void setMontanteMinimo(double montanteMinimo) {
        this.montanteMinimo = montanteMinimo;
    }

    public double getDepositoMinimo() {
        return depositoMinimo;
    }

    public void setDepositoMinimo(double depositoMinimo) {
        this.depositoMinimo = depositoMinimo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
   
    
}
