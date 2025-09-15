
package Dao;

import aula1509.Conexao;
import aula1509.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe criada para...
 * @author Matheus Ferreira Gonçalves
 * @since Classe criada em 15/09/2025
 */
public class PessoaDAO {

    private Conexao conexao;
    private Connection conn;
    
    public PessoaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserirPessoa(Pessoa pessoa){
        String sql = "INSERT INTO Pessoa(nome, sexo, idioma) VALUES(?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            

            stmt.execute();
        }
        catch(SQLException ex){
            System.out.println("Erro ao inserir pessoa:" + ex.getMessage());
            
        }
    }
    
} // fim da classe
