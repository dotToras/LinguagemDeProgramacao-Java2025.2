/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Nota;
import model.ProdutosNota;

/**
 * classe criada para...

 * @author Matheus Ferreira Gonçalves
*  @since classe criada em Oct 12, 2025
 */
public class ItensNotaDAO {

    Conexao conexao;
    Connection conn;
    
    public ItensNotaDAO(){
        this.conexao  = new Conexao();
        conn = conexao.getConexao();
    }
    
    // Metodo comum para inserir PrdoutosNota
    public void inserirItensNota(ProdutosNota item) {

        // Query para inserir primeiro em nota
        String query = "INSERT INTO ProdutosNota(prn_valorUnidade, prn_Quantidade, pro_Codigo, nof_Codigo) "
                + "     Values(?, ?, ?, ?)";

        try{
            
                PreparedStatement  ps = this.conn.prepareStatement(query);
                
                // Dados de Nota
                ps.setFloat(1, item.getValorUnidade());
                ps.setInt(2, item.getQuantidade());
                ps.setInt(3, item.getCodProduto());
                ps.setInt(4, item.getCodNotaFiscal());
                
 
                ps.execute();
                        
        } catch(SQLException e){
            System.out.println("Erro ao inserir item na nota: " + e.getMessage());
        }

    }    
        
    
} // fim da classe
