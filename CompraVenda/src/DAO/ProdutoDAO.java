
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;

/**
 * classe criada para...
 * @author Matheus Ferreira Gonçalves
 * @since classe criada em Oct 5, 2025
 */

public class ProdutoDAO {

    private Conexao conexao;
    private Connection conn;
    
    public ProdutoDAO() {
        this.conexao = new Conexao();
        this.conn = conexao.getConexao();
    }
    
    // Metodo comum para inserir Produto
    public void inserirProduto(Produto produto){
        String comando = "INSERT INTO Produto(pro_Nome, pro_Valor, pro_QuantidadeEstoque, pro_Quantidadelimite, pro_Descricao )" +
                                      "Values(?, ?, ?, ?, ?)";
        
        try{
            
            PreparedStatement stmt = this.conn.prepareStatement(comando);
            
            stmt.setString(1, produto.getProdutoNome());
            stmt.setFloat(2, produto.getProdutoValor());
            stmt.setInt(3, produto.getProdutoQuantidadeEstoque());
            stmt.setInt(4, produto.getProdutoQuantidadelimite());
            stmt.setString(5, produto.getProdutoDescricao());
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso ");
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Produto: " + e.getMessage());
          
        }
    }


    public List<Produto> consultarProdutos() {
        
        String comando = "SELECT * FROM Produto";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                           ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery(); // armazendo o retorno da Consulta
            List<Produto> listaProdutos = new ArrayList(); // criando uma lista de produtos para armazenar todos os resultados
            
            // Percorre rs e salva os objetos dentro do objeto Produto e depois adiciona na lista
            while(rs.next()){
                Produto prod = new Produto();
                
                prod.setProdutoCodigo(rs.getInt("pro_Codigo"));
                prod.setProdutoNome(rs.getString("pro_Nome"));
                prod.setProdutoValor(rs.getFloat("pro_Valor"));
                prod.setProdutoQuantidadeEstoque(rs.getInt("pro_QuantidadeEstoque"));
                prod.setProdutoQuantidadelimite(rs.getInt("pro_Quantidadelimite"));
                prod.setProdutoDescricao(rs.getString("pro_Descricao"));
                listaProdutos.add(prod);
            }
            
            return listaProdutos; // retorna a lista já preenchida
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível consultar Produtos " + e.getMessage());
            return null;
        }
        
    }
    
    // TODO adicionar metodo para buscar somente produtos com estoque
    
} // fim da classe
