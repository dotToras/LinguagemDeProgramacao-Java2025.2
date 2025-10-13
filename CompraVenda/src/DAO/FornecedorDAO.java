
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Endereco;
import model.Fornecedor;

/**
 * classe criada para...

 * @author Matheus Ferreira Gonçalves
*  @since classe criada em Oct 10, 2025
 */
public class FornecedorDAO {

    private Conexao conexao;
    private Connection conn;

    public FornecedorDAO() {
        this.conexao = new Conexao();
        conn = conexao.getConexao();
    }
    
    // Metodo comum para inserir Fornecedor
    public void inserirFornecedor(Fornecedor fornecedor) {

        // Query para inserir primeiro em endereço
        String query = "call inserirFornecedor(?, ?, ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
        
        try{
            
                // Aqui preparo a procedure
                CallableStatement  ctal = this.conn.prepareCall(query);
                
                // Dados de Endereço
                ctal.setString(1, fornecedor.getEndereco().getEnderecoEstado());
                ctal.setString(2, fornecedor.getEndereco().getEnderecoCidade());
                ctal.setString(3, fornecedor.getEndereco().getEnderecoBairro());
                ctal.setString(4, fornecedor.getEndereco().getEnderecoRua());
                ctal.setString(5, fornecedor.getEndereco().getEnderecoUF());
                ctal.setString(6, fornecedor.getEndereco().getEnderecoComplemento());
                ctal.setInt(7, fornecedor.getEndereco().getEnderecoNumero());
                ctal.setString(8, fornecedor.getEndereco().getEnderecoCEP());
               
                // Dados de Fornecedor
                ctal.setString(9, fornecedor.getNome());
                ctal.setString(10, fornecedor.getNomeFantasia());
                ctal.setString(11, fornecedor.getCNPJ());
                ctal.setString(12, fornecedor.getEmail());
                ctal.setString(13, fornecedor.getTelefone());
                
                ctal.executeQuery();
                JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso");
            
        } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor: " + e.getMessage());
        }
        
    }
    
    // Método comum para consultar Fornecedores
    public List<Fornecedor> consultarFornecedores() {
        
        String comando = "SELECT * FROM Fornecedor";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                           ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery(); // armazendo o retorno da Consulta
            List<Fornecedor> listaFornecedores = new ArrayList(); // criando uma lista de fornecedores para armazenar todos os resultados
            
            // Percorre rs e salva os objetos dentro do objeto Fornecedor e depois adiciona na lista
            while(rs.next()){
                
                Fornecedor forn = new Fornecedor();
                
                forn.setCodigo(rs.getInt("for_Codigo"));
                forn.setNome(rs.getString("for_Nome"));
                forn.setNomeFantasia(rs.getString("for_nomeFantasia"));
                forn.setEmail(rs.getString("for_email"));
                forn.setTelefone(rs.getString("for_Telefone"));
                forn.setCNPJ(rs.getString("for_CNPJ"));
                
                listaFornecedores.add(forn);
            }
            
            return listaFornecedores; // retorna a lista já preenchida
            
        } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Não foi possível consultar Fornecedores " + e.getMessage());
            return null;
        }
        
    }      
    
    // Método comum para consultar Fornecedores com Endereço
    public List<Fornecedor> consultarFornecedoressEndereco() {
        
        String comando = "Select  for_Codigo, for_Nome, for_NomeFantasia, for_CNPJ, " + 
                         "for_Email, for_Telefone, end_Estado, end_Cidade," + 
                         "end_Bairro, end_Rua, end_UF, end_Complemento, end_Numero, end_CEP"  +
                         "\nfrom Fornecedor" +
                         "\nInner join Endereco Using(end_codigo);";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                           ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery(); // armazendo o retorno da Consulta
            List<Fornecedor> listaFornecedores = new ArrayList(); // criando uma lista de fornecedores para armazenar todos os resultados
            
            // Percorre rs e salva os objetos dentro do objeto Fornecedor e depois adiciona na lista
            while(rs.next()){
                Fornecedor forn = new Fornecedor();
                Endereco end = new Endereco();
                
                // Dados de fornecedor
                forn.setCodigo(rs.getInt("for_Codigo"));
                forn.setNome(rs.getString("for_Nome"));
                forn.setNomeFantasia(rs.getString("for_NomeFantasia"));
                forn.setEmail(rs.getString("for_email"));
                forn.setTelefone(rs.getString("for_Telefone"));
                forn.setCNPJ(rs.getString("for_CNPJ")); 
 
                // Dados de Endereço
                end.setEnderecoEstado(rs.getString("end_Estado")); 
                end.setEnderecoCidade(rs.getString("end_Cidade")); 
                end.setEnderecoBairro(rs.getString("end_Bairro")); 
                end.setEnderecoRua(rs.getString("end_Rua")); 
                end.setEnderecoUF(rs.getString("end_UF")); 
                end.setEnderecoComplemento(rs.getString("end_Complemento"));
                end.setEnderecoNumero(rs.getInt("end_Numero")); 
                end.setEnderecoCEP(rs.getString("end_CEP"));
                
                forn.setEndereco(end);
                listaFornecedores.add(forn);
            }
            
            return listaFornecedores; // retorna a lista já preenchida
            
        } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Não foi possível consultar Fornecedores com endereço " + e.getMessage());
                return null;
        }
        
    }  
        
    
} // fim da classe
