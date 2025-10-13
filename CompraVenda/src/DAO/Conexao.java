/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * classe criada para...

 * @author Matheus Ferreira Gonçalves
*  @since classe criada em Oct 5, 2025
 */
public class Conexao {

    public Connection getConexao(){
        try{
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbVendas?useTimezone=true&serverTimezone=UTC",
                                                           "root", 
                                                           "root"); /*url, usuario, senha */
            System.out.println("Conexão realizada com sucesso");
             return conn;
        } catch (SQLException e){
            System.out.println("Erro ao conectar ao BD" + e.getMessage());
            return null;
        }
    }
        
    
} // fim da classe
