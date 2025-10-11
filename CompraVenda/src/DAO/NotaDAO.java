/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;

/**
 * classe criada para...

 * @author Matheus Ferreira Gonçalves
*  @since classe criada em Oct 11, 2025
 */
public class NotaDAO {

    Conexao conexao;
    Connection conn;
    
    public NotaDAO(){
        this.conexao  = new Conexao();
        conn = conexao.getConexao();
    }
    
    
    
    
} // fim da classe
