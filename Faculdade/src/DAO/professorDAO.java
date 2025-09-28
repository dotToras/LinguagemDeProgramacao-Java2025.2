/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import faculdade.Conexao;
import faculdade.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * classe criada para gerenciar as operações de Professores (CRUD)
 * @author Matheus Ferreira Gonçalves
 * @since classe criada em Sep 28, 2025
 */
public class professorDAO {

    private Conexao conexao;
    private Connection conn;
    
    public professorDAO(){
        this.conexao = new Conexao();
        this.conn = conexao.getConexao();
    }
 
    // Metodo comum para inserir Professor
    public void inserirAluno(Professor professor){
        String query = "INSERT INTO Professor(proCodigo, proNome, proDisciplina, proSalario)"
                     + " VALUES(?, ? , ? , ?); ";
        
        try{
            
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setInt(1, professor.codigoFuncionario);
            stmt.setString(2, professor.nome);
            stmt.setString(3, professor.disciplina);
            stmt.setFloat(4, professor.salario);
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso");
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Professor " + e.getMessage());
        }
                
    } // fim de inserir Professor
    
    // Metodo comum  para buscar professor por código
    public Professor buscarProfessorCod(int codigoFunc){
        
        String query = "Select * from Professor Where proCodigo = ?";
        try{
        
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);     
            stmt.setLong(1, codigoFunc);
            
            Professor prof = new Professor();
            
            ResultSet rs = stmt.executeQuery(); 
            rs.first();
            
            prof.codigoFuncionario = codigoFunc;
            prof.nome = (rs.getString("proNome"));
            prof.disciplina = (rs.getString("proDisciplina"));
            prof.salario = (rs.getFloat("proSalario"));

            JOptionPane.showMessageDialog(null, "Professor encontrado!!");
            
            return prof;
            
        } catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"Erro ao buscar Professor " + e.getMessage() );
            return null;
            
            }
        } // fim de buscar Professor
    
    // Metodo comum para editar Professor
    public void editarProfessor(Professor prof){
        
        String query = "UPDATE Professor SET proNome = ?, proDisciplina = ?, proSalario = ? WHERE proCodigo = ?";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setString(1, prof.nome);
            stmt.setString(2, prof.disciplina);
            stmt.setFloat(3, prof.salario);
            stmt.setLong(4, prof.codigoFuncionario);
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados de Professor atualizados com sucesso!!");
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados de Professor " + e.getMessage());
        }
        
    } // fim de editar Professor
    
    // Metodo comum para excluir Professor
    public void excluirProfessor(int codFunc){
        String query = "Delete from Professor Where proCodigo = ?";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setInt(1, codFunc);
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Professor excluído com sucesso !!");
        } catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"Erro ao excluir Professor " + e.getMessage());
            }
    } // fim de excluir Professor
        
    
} // fim da classe
