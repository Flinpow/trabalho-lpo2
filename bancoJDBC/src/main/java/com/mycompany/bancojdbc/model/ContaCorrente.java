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
public class ContaCorrente  extends Conta{
    
     private double limite;    
     
     private static List<ContaCorrente> contasCorrente = new ArrayList();
// --------------------Metodos:------------------ //   
    @Override
    public boolean saca(double valor) {
        if((super.saldo - valor) > (0 - limite)){     // maximo negativo permitido ao cliente é o negativo do limite  
            super.saca(valor);
            return true;
        }
        return false;   // se for false, temos que mostrar um informativo do erro ao cliente 
    }
    @Override
    public void remunera(){
        super.saldo += (super.saldo * 0.01);    // remuneracao de 1%
    }  
    public static void excluir(ContaCorrente contaC){
        contasCorrente.remove(contaC);
    }
// ------------------Constructor:---------------- //
    public ContaCorrente(Cliente dono, double depositoInicial, double limite, int id){
        super(dono, depositoInicial, id);
        this.limite = limite;
    }
    
    public ContaCorrente(Cliente dono, double depositoInicial, double limite){
        super(dono, depositoInicial);
        this.limite = limite;
    }
    public static void addContaCorrente(ContaCorrente conta) {
        contasCorrente.add(conta);
    }
    
    public static ContaCorrente getContaByCpf(String cpf) {
        for (ContaCorrente conta : contasCorrente) {
            if(conta.getDono().getCPF().equals(cpf)){
                return conta;
            }
        }
        return null;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public static List<ContaCorrente> getContasCorrente() {
        return contasCorrente;
    }

    public static void setContasCorrente(List<ContaCorrente> contasCorrente) {
        contasCorrente = contasCorrente;
    }
    
}
