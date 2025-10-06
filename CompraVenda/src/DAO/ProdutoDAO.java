
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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


    
} // fim da classe
