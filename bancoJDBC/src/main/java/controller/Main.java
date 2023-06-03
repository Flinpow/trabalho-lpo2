package controller;


import com.mycompany.bancojdbc.dao.ClienteDao;
import com.mycompany.bancojdbc.dao.ContaDao;
import com.mycompany.bancojdbc.model.Cliente;
import com.mycompany.bancojdbc.model.ContaCorrente;
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
public class Main {
    public static void main(String[] args) throws SQLException {
    
        
//        Cliente c = new Cliente("joao", "silva", "1515155", "12121212121", "Rua dos Alfaneiros 501", 5000);
//        ClienteDao.addCliente(c);
//        List<Cliente> list = ClienteDao.getClientes();
//        
//        for(Cliente c1 : list){
//            System.out.println(c1.toString());
//        }

//       ClienteDao.updateCustomerSalary(50.0, "12121212121");

        Cliente cliente = ClienteDao.getClienteByCpf("12121212121");
        ContaCorrente cc = new ContaCorrente(cliente,500.0, 2000);
       ContaDao.addContaCorrente(cc,500.0, cliente);
    }
}
