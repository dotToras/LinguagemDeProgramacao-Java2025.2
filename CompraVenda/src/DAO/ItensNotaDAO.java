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
import model.Produto;
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
   
        String querySaida = "call InserirItemSaida(?, ?, ?, ?) ";
        String queryEntrada = "call InserirItemEntrada(?, ?, ?, ?) ";
        String queryFinal = item.getNotaFiscal().isTipoNota() ? querySaida : queryEntrada;
        
        try{
               
                
                CallableStatement  ps = this.conn.prepareCall(queryFinal);
                
                // Dados de Nota
                ps.setFloat(1, item.getValorUnidade());
                ps.setInt(2, item.getQuantidade());
                ps.setInt(3, item.getProduto().getProdutoCodigo());
                ps.setInt(4, item.getNotaFiscal().getCodigo());
                ps.execute();
                 
                
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar item na nota: " + e.getMessage());
        }

    }    
 
   // Metodo comum para consultar Produtos presentes na Nota
   public List<ProdutosNota> consultarProdutosNota(int codNota) {
        
        String comando =  "Select pro_Codigo, pro_Nome, prn_valorUnidade, prn_Quantidade   from Produto\n" +
                          "Inner join ProdutosNota USING(pro_Codigo)\n" +
                          "Inner join notaFiscal Using(nof_Codigo)\n" +
                          "Where nof_Codigo = ?";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                           ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, codNota);
            ResultSet rs = stmt.executeQuery(); // armazendo o retorno da Consulta
            List<ProdutosNota> listaItens = new ArrayList(); // criando uma lista de produtos na nota para armazenar todos os resultados
            
            // Percorre rs e salva os objetos dentro do objeto ProdutosNota e depois adiciona na lista
            while(rs.next()){
                ProdutosNota item = new ProdutosNota();
                Produto prod = new Produto();
                
                // Dados do Produto
                prod.setProdutoCodigo(rs.getInt("pro_Codigo"));
                prod.setProdutoNome(rs.getString("pro_Nome"));
                
                // Dados dos itens (Quantidade e Valor no Dia)
                item.setValorUnidade(rs.getFloat("prn_valorUnidade"));
                item.setQuantidade(rs.getInt("prn_Quantidade"));

                item.setProduto(prod);
                listaItens.add(item);
            }
            
            return listaItens; // retorna a lista já preenchida
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível consultar Produtos " + e.getMessage());
            return null;
        }
        
    }  
   
   
} // fim da classe
