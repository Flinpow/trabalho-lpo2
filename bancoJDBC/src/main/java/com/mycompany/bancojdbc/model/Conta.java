/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancojdbc.model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AlphaPlayerOne
 */
public abstract class Conta implements ContaI{

    private Cliente dono;
    protected double saldo;
    private int numero;
   
    @Override
    public abstract boolean deposita(double valor) throws SQLException; 
    @Override
    public abstract boolean saca(double valor) throws SQLException;
    @Override
    public abstract void remunera() throws SQLException;    // abstrato pois sera implementado nas classes filhas
    @Override
    public Cliente getDono(){ return dono; }
    @Override
    public int getNumero(){return numero;}
    @Override
    public double getSaldo(){return saldo;}
    
    Conta(Cliente dono, int id, double saldo){
        this.numero = id;
        this.dono = dono;
        this.saldo = saldo;
    }
    
    Conta(Cliente dono){
        this.dono = dono;
    }
    
}
