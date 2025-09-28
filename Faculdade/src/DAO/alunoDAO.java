
package DAO;

import com.mysql.cj.xdevapi.PreparableStatement;
import faculdade.Aluno;
import faculdade.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * classe criada para gerenciar as operações de Aluno (CRUD)
 * @author Matheus Ferreira Gonçalves
 *  @since classe criada em Sep 28, 2025
 */
public class alunoDAO {

    private Conexao conexao;
    private Connection conn;
    
    public alunoDAO(){
        this.conexao = new Conexao();
        this.conn = conexao.getConexao();
        
    }
    
    // Metodo comum para inserir Aluno
    public void inserirAluno(Aluno aluno){
        String query = "INSERT INTO Aluno(aluRA, aluNome, aluCurso, aluSemestre)"
                     + " VALUES(?, ? , ? , ?); ";
        
        try{
            
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setLong(1, aluno.codigo);
            stmt.setString(2, aluno.nome);
            stmt.setString(3, aluno.curso);
            stmt.setInt(4, aluno.semestre);
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Aluno " + e.getMessage());
        }
                
    } // fim de inserirAluno
    
    // Metodo comum  para buscarAlunoRA
    public Aluno buscarAlunoRA(long RA){
        
        String query = "Select * from Aluno Where aluRA = ?";
        try{
        
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);     
            stmt.setLong(1, RA);
            
            Aluno aluno = new Aluno();
            
            ResultSet rs = stmt.executeQuery(); 
            rs.first();
            
            aluno.codigo = RA;
            aluno.nome = (rs.getString("aluNome"));
            aluno.curso = (rs.getString("aluCurso"));
            aluno.semestre = (rs.getInt("aluSemestre"));

            JOptionPane.showMessageDialog(null, "Aluno encontrado!!");
            
            return aluno;
            
        } catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"Erro ao buscar Aluno " + e.getMessage() );
            return null;
            
            }
        } // fim de buscar Aluno
    
    // Metodo comum para editar Aluno
    public void editarAluno(Aluno aluno){
        
        String query = "UPDATE Aluno SET aluNome = ?, aluCurso = ?, aluSemestre = ? WHERE aluRA = ?";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setString(1, aluno.nome);
            stmt.setString(2, aluno.curso);
            stmt.setInt(3, aluno.semestre);
            stmt.setLong(4, aluno.codigo);
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados de Aluno atualizados com sucesso!!");
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados de Aluno " + e.getMessage());
        }
        
    } // fim de editar Aluno
    
    // Metodo comum para excluir Aluno
    public void excluirAluno(long RA){
        String query = "Delete from Aluno Where aluRA = ?";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setLong(1, RA);
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso !!");
        } catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"Erro ao excluir Aluno " + e.getMessage());
            }
    } // fim de excluir Aluno
    
    
    
} // fim da classe
