/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancojdbc.model;

/**
 *
 * @author AlphaPlayerOne
 */
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author AlphaPlayerOne
 */
public class Cliente {
    private String nome;
    private String sobreNome;
    private String rg;
    private String CPF;
    private String endereco;
    private double salario;
    
     public Cliente() {
       
    }
    

    public Cliente(String nome, String sobreNome,String CPF, String rg,  String endereco, double salario) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.CPF = CPF;
        this.rg = rg;
        this.endereco = endereco;
        this.salario = salario;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF.replaceAll("[.-]", "");
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", sobreNome=" + sobreNome + ", rg=" + rg + ", CPF=" + CPF + ", endereco=" + endereco + ", salario=" + salario + '}';
    }
    
    
}

