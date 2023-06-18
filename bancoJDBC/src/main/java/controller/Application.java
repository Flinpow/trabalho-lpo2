package controller;


import com.mycompany.bancojdbc.dao.ClienteDao;
import com.mycompany.bancojdbc.dao.ContaDao;
import com.mycompany.bancojdbc.model.Cliente;
import com.mycompany.bancojdbc.model.ContaCorrente;
import com.mycompany.bancojdbc.model.ContaInvestimento;
import com.mycompany.bancojdbc.view.InicioView;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AlphaPlayerOne
 */
public class Application {
    public static void main(String[] args) throws SQLException {
           new InicioView().setVisible(true);
    }

}
