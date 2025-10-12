/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import model.Nota;

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
    
    // Metodo comum para inserir Nota
    public int inserirNota(Nota nota) {

        // Query para inserir primeiro em nota
        String query = "call inserirNota(?, ?, ? ,? ,?, ?, ?)";
        int idNotaGerada = - 1; // para caso tenha dado errado
        try{
            
                CallableStatement  ctal = this.conn.prepareCall(query);
                
                // Dados de Nota
                ctal.setFloat(1, nota.getValorTotal());
                ctal.setString(2, nota.getDataEmissao());
                ctal.setString(3, nota.getFormaPagamento());
                ctal.setBoolean(4, nota.isTipoNota());
                
                if(nota.getCliente() != null) {
                    ctal.setInt(5, nota.getCliente().getCodigo());
                    ctal.setNull(6, java.sql.Types.INTEGER);

                } else if(nota.getFornecedor() != null){
                    ctal.setNull(5, java.sql.Types.INTEGER);
                    ctal.setInt(6, nota.getFornecedor().getCodigo());
                }

                ctal.registerOutParameter(7, java.sql.Types.INTEGER);

                ctal.executeQuery();
                
                // nota gerada pelo parametro out na procedure
                idNotaGerada = ctal.getInt(7);
            
        } catch(SQLException e){
            System.out.println("Erro ao inserir nota: " + e.getMessage());
        }
        return idNotaGerada;
    }    
    
    
} // fim da classe
