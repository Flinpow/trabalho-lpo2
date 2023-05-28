/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancojdbc.model;

import java.util.List;

/**
 *
 * @author AlphaPlayerOne
 */
public abstract class Conta implements ContaI{

    // -------------------Atributos:------------------- //
    private Cliente dono;
    protected double saldo;
    private int numero;
// --------------------Metodos:------------------ //   
    @Override
    public boolean deposita(double valor){
        if(valor > 0){ 
            this.saldo += valor;
            return true;
        }
        return false;
    }
    @Override
    public boolean saca(double valor) {
        if(valor > 0){ 
            this.saldo -= valor;
            return true;
        }
        return false;   // se for false, temos que mostrar um informativo do erro ao cliente 
    }
   @Override
    public Cliente getDono(){
        return dono;
    }
    @Override
    public int getNumero(){
        return numero;
    }
    @Override
    public double getSaldo(){
        return saldo;
    }
    @Override
    public abstract void remunera();    // abstrato pois sera implementado nas classes filhas
    
    
    public static boolean clienteTemConta(Cliente cliente) {
        List<ContaInvestimento> contasInvestimento = ContaInvestimento.getContasInvestimento();
        List<ContaCorrente> contasCorrente = ContaCorrente.getContasCorrente();
        
        for(ContaInvestimento contaI : contasInvestimento){
            if(contaI.getDono().getCPF().equals(cliente.getCPF())){
                return true;
            }
        }
        for(ContaCorrente contaC : contasCorrente){
            if(contaC.getDono().getCPF().equals(cliente.getCPF())){
                return true;
            }
        }
        return false;
    }
// ------------------Constructor:---------------- //
    Conta(Cliente dono, double depositoInicial, int listSize){
        this.dono = dono;
        this.saldo = depositoInicial;
        numero = listSize == 0 ? 0 : listSize +1 ;  
    }
    
}
