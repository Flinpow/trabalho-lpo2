/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mycompany.bancojdbc.dao.ContaDao;
import com.mycompany.bancojdbc.model.ContaCorrente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AlphaPlayerOne
 */
public class ContaController {
    
    
    public static void criaContaCorrente(ContaCorrente conta) {
        try {
            ContaDao.addContaCorrente(conta, conta.getSaldo());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Criar Conta", "Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
}
