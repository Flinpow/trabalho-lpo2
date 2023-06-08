/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mycompany.bancojdbc.dao.ClienteDao;
import com.mycompany.bancojdbc.model.Cliente;
import com.mycompany.bancojdbc.view.ClienteView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlphaPlayerOne
 */
public class ClienteController {
    
    private ClienteView view;
    private ClienteDao dao;
    
    public ClienteController(ClienteView view, ClienteDao dao) {
        this.view = view;
        this.dao = dao;
        initController();
    }
    
    private void initController(){
        this.view.setController(this);
        this.view.initView();
    }
    
    
    public static void salvarCliente(Cliente c) {
        try {
            if(ClienteDao.getClienteByCpf(c.getCPF()) != null) {
                ClienteDao.updateCustomer(c);
            }else {
                ClienteDao.addCustomer(c);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void excluirCliente(String cpf) throws SQLException {
        ClienteDao.deleteCustomer(cpf);
    }
}
