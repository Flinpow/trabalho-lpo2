/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancojdbc.view;

/**
 *
 * @author AlphaPlayerOne
 */
import com.mycompany.bancojdbc.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel{

    private List<Cliente> dados = new ArrayList<>();
    private String[] colunas = {"Nome", "Sobrenome", "RG", "CPF", "Endereco", "Salario (R$)"};

    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }
     
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
       switch (coluna){
           case 0: 
               return dados.get(linha).getNome();
           case 1:
               return dados.get(linha).getSobreNome();
           case 2:
               return dados.get(linha).getRg();
           case 3:
               return dados.get(linha).getCPF();
           case 4:
               return dados.get(linha).getEndereco();
           case 5:
               return dados.get(linha).getSalario();
       }
       return null;
    }
    
    

    public void addRow(Cliente cliente){
        this.dados.add(cliente);
        this.fireTableDataChanged();
    }

    public List<Cliente> getDados() {
        return dados;
    }

    public void setDados(List<Cliente> dados) {
        this.dados = dados;
        this.fireTableDataChanged();
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    
}
