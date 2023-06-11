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
    
    
    public static void criaContaCorrente(ContaCorrente conta, double depositoInicial) {
        try {
            ContaDao.addContaCorrente(conta, depositoInicial);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Criar Conta", "Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static boolean sacarContaCorrente(ContaCorrente conta, double valor) {
        try {
            if (conta.saca(valor)) {
                JOptionPane.showMessageDialog(null,"Saque Realizado com sucesso", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null,"Saldo Insuficiente!", "Erro",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static ContaCorrente getContaCorrenteByCpf(String cpf) {
        try {
            return  ContaDao.getContaCorrenteByCpf(cpf);
        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
