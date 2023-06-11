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

    public ContaCorrente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean saca(double valor) throws SQLException{
        if((super.saldo - valor) > (0 - limite)){     // maximo negativo permitido ao cliente é o negativo do limite  
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
    public void remunera(){
        super.saldo += (super.saldo * 0.01);    // remuneracao de 1%
    }  
// ------------------Constructor:---------------- //
    

    public ContaCorrente(Cliente dono, double limite, int id, double saldo){
        super(dono,id,saldo);
        this.limite = limite;
    }
    public ContaCorrente(Cliente dono, double limite){
        super(dono);
        this.limite = limite;
    }
    
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean deposita(double valor) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double getSaldo() {
        return super.saldo;
    }

    public void setSaldo(double saldo) {
        super.saldo = saldo;
    }
    
    
}
