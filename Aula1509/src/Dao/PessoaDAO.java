
package Dao;

import aula1509.Conexao;
import aula1509.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe criada para...
 * @author Matheus Ferreira Gonçalves
 * @since Classe criada em 15/09/2025
 */
public class PessoaDAO {

    // DAO - Data Acess Object
    
    private Conexao conexao;
    private Connection conn;
    
    public PessoaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    // Metodo comum para inserir pessoa
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
    } // fim do metodo de inserir Pessoa
    
    // Metodo comum consultar Pessoa
    public Pessoa getPessoa(int id){
        String sql = "SELECT * FROM Pessoa WHERE id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // 1 Parametro - a Query
            // 2 '  ' - É o tipo do resultSet, no caso scroll, o cursor se move para frente ou para trás
            // este tipo de ResultSeT é sensível às alterações feitas no banco de dados, ou seja, as
            // modificações feitas no banco de dados são refletidas no ResultSet.
            // 3 Parametro é sobre os paramêtros de concorrência - pode ser "read only' ou atualizável
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery(); // armazena o retorno da query
            Pessoa p = new Pessoa(); // objeto para armazenar a consulta
            
            rs.first(); // posicionar o retorno da consulta na primeira posiçao
            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setSexo(rs.getString("sexo"));
            p.setIdioma(rs.getString("idioma"));
            return p;
            
        } catch(SQLException ex){
            System.out.println("Erro ao consultar pessoa: " + ex.getMessage());
            return null;
        }
    } // fim do metodo de Consultar pessoa
    
    // Metodo comum para editar Pessoa
    public void editar(Pessoa pessoa){
        try{
            String sql = "UPDATE pessoa set nome=?, sexo=?, idioma=? WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            stmt.setInt(4, pessoa.getId());
            stmt.execute();
            
        } catch(SQLException ex){
            System.out.println("Erro ao atualizar pessoa: " + ex.getMessage());
        }
    } // Fim do metodo de editar Pessoa
    
    // Metodo comum para excluir Pessoa
    public void excluir(int id){
        try{
            String sql = "DELETE from pessoa WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch(SQLException ex) {
            System.out.println("Erro ao excluir pessoa: " + ex.getMessage());
            
        }
    } // fim do metodo de excluir Pessoa
    
} // fim da classe
