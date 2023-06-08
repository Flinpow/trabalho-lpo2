/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancojdbc.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlphaPlayerOne
 */
public class ContaInvestimento extends Conta{
    // -------------------Atributos:------------------- //
    private double montanteMinimo;
    private double depositoMinimo;
    
    private static List<ContaInvestimento> contasInvestimento = new ArrayList();
// --------------------Metodos:------------------ //   
    @Override
    public boolean deposita(double valor){
        if(valor >= depositoMinimo){ 
            super.deposita(valor);
            return true;
        }
        return false;   // mostrar mensagem do erro para o usuario
    }
    @Override
    public boolean saca(double valor) {
        if((super.saldo - valor) >= montanteMinimo){ 
            super.saca(valor);
            return true;
        }
        return false;   // se for false, temos que mostrar um informativo do erro ao cliente 
    }
    @Override
    public void remunera(){
        super.saldo += (super.saldo * 0.02);    // remuneracao de 2%
    } 
// ------------------Constructor:---------------- //
   public ContaInvestimento(Cliente dono, double depositoInicial, double montanteMinimo, double depositoMinimo){
        super(dono, depositoInicial);
        this.montanteMinimo = montanteMinimo;
        this.depositoMinimo = depositoMinimo;
    }
   
    
    public static void addContaInvestimento(ContaInvestimento conta) {
        contasInvestimento.add(conta);
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

    public static List<ContaInvestimento> getContasInvestimento() {
        return contasInvestimento;
    }

    public static void setContasInvestimento(List<ContaInvestimento> contasInvestimento) {
        ContaInvestimento.contasInvestimento = contasInvestimento;
    }
    
    
}
