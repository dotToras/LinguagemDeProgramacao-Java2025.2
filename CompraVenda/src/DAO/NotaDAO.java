/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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

        // Query para inserir uma Nota
        String query = "call inserirNota(?, ?, ? ,? ,?, ?, ?)";
        int idNotaGerada = - 1; // para caso tenha dado errado
        try{
            
                CallableStatement  ctal = this.conn.prepareCall(query);
                
                // Dados de Nota
                ctal.setFloat(1, nota.getValorTotal());
                ctal.setString(2, nota.getDataEmissao());
                ctal.setString(3, nota.getFormaPagamento());
                ctal.setBoolean(4, nota.isTipoNota());
                
                // Verificação para ver se o cliente ou o fornecedor estão nulos
                if(nota.getCliente() != null) {
                    ctal.setInt(5, nota.getCliente().getCodigo());
                    ctal.setNull(6, java.sql.Types.INTEGER);

                } else if(nota.getFornecedor() != null){
                    ctal.setNull(5, java.sql.Types.INTEGER);
                    ctal.setInt(6, nota.getFornecedor().getCodigo());
                }

                ctal.registerOutParameter(7, java.sql.Types.INTEGER); 

                ctal.executeQuery();
                JOptionPane.showMessageDialog(null, "Nota cadastrada com sucesso");
                // nota gerada pelo parametro out na procedure
                idNotaGerada = ctal.getInt(7);
            
        } catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro ao inserir nota: " + e.getMessage());
        }
        
        return idNotaGerada; 
    }    
    
    // Metodo comum para listar as Notas
    public List<Nota> consultarNotas() {
        
        String comando = "SELECT * FROM notaFiscal";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                           ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery(); // armazendo o retorno da Consulta
            List<Nota> listaNotas = new ArrayList(); // criando uma lista de notas para armazenar todos os resultados
            
            // Percorre rs e salva os objetos dentro do objeto Nota e depois adiciona na lista
            while(rs.next()){
                Nota nota = new Nota();
                
                nota.setCodigo(rs.getInt("nof_Codigo"));
                nota.setDataEmissao(rs.getString("nof_DataEmissao"));
                nota.setFormaPagamento(rs.getString("nof_FormaPagamento"));
                nota.setValorTotal(rs.getFloat("nof_valorTotal"));
                nota.setTipoNota(rs.getBoolean("nof_TipoNota"));
                
                
                listaNotas.add(nota);
            }
            
            return listaNotas; // retorna a lista já preenchida
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível consultar Notas " + e.getMessage());
            return null;
        }
        
    } 
    
} // fim da classe
