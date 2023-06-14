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
        if(depositoInicial < 0){
            JOptionPane.showMessageDialog(null,"Insira um valor válido!", "Erro",JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                ContaDao.addContaCorrente(conta, depositoInicial);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao Criar Conta", "Erro",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static boolean sacarContaCorrente(ContaCorrente conta, double valor) {
        try {
            if(valor < 0){
                JOptionPane.showMessageDialog(null,"Insira um valor válido!", "Erro",JOptionPane.ERROR_MESSAGE);
            } else if (conta.saca(valor)) {
                JOptionPane.showMessageDialog(null,"Saque Realizado com sucesso", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null,"Saldo Insuficiente!", "Sem Saldo",JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean depositarContaCorrente(ContaCorrente conta, double valor) {
        try {
            if(valor < 0){
                JOptionPane.showMessageDialog(null,"Insira um valor válido!", "Erro",JOptionPane.ERROR_MESSAGE);
            } else if (conta.deposita(valor) && valor > 0) {
                JOptionPane.showMessageDialog(null,"Deposito Realizado com sucesso", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null,"Insira um valor válido!", "Erro",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void remunerarContaCorrente(ContaCorrente conta) {
        try {
            conta.remunera();
        }catch(SQLException ex){
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
