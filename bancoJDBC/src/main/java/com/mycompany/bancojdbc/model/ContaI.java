/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancojdbc.model;

import java.sql.SQLException;

/**
 *
 * @author AlphaPlayerOne
 */
public interface ContaI {
    
    public boolean deposita(double valor) throws SQLException;
    public boolean saca(double valor) throws SQLException;
    public Cliente getDono();
    public int getNumero();
    public double getSaldo();
    public void remunera() throws SQLException;
    
}
