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
import model.Cliente;
import model.Endereco;
import model.Produto;

/**
 * classe criada para...

 * @author Matheus Ferreira Gonçalves
*  @since classe criada em Oct 11, 2025
 */
public class ClienteDAO {

    private Conexao conexao;
    private Connection conn;

    public ClienteDAO() {
        this.conexao = new Conexao();
        conn = conexao.getConexao();
    }
    
    // Metodo comum para inserir Cliente
    public void inserirCliente(Cliente cliente) {

        // Chamada de procedure, os primeiros parametros são de endereçoo
        String query = "call inserirCliente(?, ?, ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
        
        try{
            
                CallableStatement  cs = this.conn.prepareCall(query);
                
                // Dados de Endereço
                cs.setString(1, cliente.getEndereco().getEnderecoEstado());
                cs.setString(2, cliente.getEndereco().getEnderecoCidade());
                cs.setString(3, cliente.getEndereco().getEnderecoBairro());
                cs.setString(4, cliente.getEndereco().getEnderecoRua());
                cs.setString(5, cliente.getEndereco().getEnderecoUF());
                cs.setString(6, cliente.getEndereco().getEnderecoComplemento());
                cs.setInt(7, cliente.getEndereco().getEnderecoNumero());
                cs.setString(8, cliente.getEndereco().getEnderecoCEP());
               
                // Dados de Cliente
                cs.setString(9, cliente.getNome());
                cs.setString(10, cliente.getDocIdentificador());
                cs.setBoolean(11, cliente.isTipo());
                cs.setString(12, cliente.getEmail());
                cs.setString(13, cliente.getTelefone());
                
                cs.executeQuery();
   
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                
        } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
        
    }    
    
    // Método comum para consultar Clientes
    public List<Cliente> consultarClientes() {
        
        String comando = "SELECT * FROM Cliente";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                           ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery(); // armazendo o retorno da Consulta
            List<Cliente> listaCliente = new ArrayList(); // criando uma lista de cliutos para armazenar todos os resultados
            
            // Percorre rs e salva os objetos dentro do objeto Cliente e depois adiciona na lista
            while(rs.next()){
                Cliente cli = new Cliente();
                
                cli.setCodigo(rs.getInt("cli_Codigo"));
                cli.setNome(rs.getString("cli_Nome"));
                cli.setDocIdentificador(rs.getString("cli_DocumentoIdentificador"));
                cli.setEmail(rs.getString("cli_email"));
                cli.setTelefone(rs.getString("cli_Telefone"));
                cli.setTipo(rs.getBoolean("cli_Tipo"));
                listaCliente.add(cli);
            }
            
            return listaCliente; // retorna a lista já preenchida
            
        } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Não foi possível consultar Clientes " + e.getMessage());
                return null;
        }
        
    }    
   
    // Método comum para consultar Clientes com Endereço
    public List<Cliente> consultarClientesEndereco() {
        
        String comando = "Select  cli_Codigo, cli_Nome, cli_DocumentoIdentificador, cli_Telefone, cli_Email, cli_Tipo, " +
                         "end_Estado, end_Cidade, end_Bairro, end_Rua, end_UF, end_Complemento, end_Numero, end_CEP " +
                         "\nfrom Cliente" +
                         "\nInner join Endereco Using(end_codigo);";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                           ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery(); // armazendo o retorno da Consulta
            List<Cliente> listaCliente = new ArrayList(); // criando uma lista de cliutos para armazenar todos os resultados
            
            // Percorre rs e salva os objetos dentro do objeto Cliente e depois adiciona na lista
            while(rs.next()){
                Cliente cli = new Cliente();
                Endereco end = new Endereco();
                
                // Dados de cliente
                cli.setCodigo(rs.getInt("cli_Codigo"));
                cli.setNome(rs.getString("cli_Nome"));
                cli.setDocIdentificador(rs.getString("cli_DocumentoIdentificador"));
                cli.setEmail(rs.getString("cli_email"));
                cli.setTelefone(rs.getString("cli_Telefone"));
                cli.setTipo(rs.getBoolean("cli_Tipo"));
                
                // Dados de Endereço
                end.setEnderecoEstado(rs.getString("end_Estado")); 
                end.setEnderecoCidade(rs.getString("end_Cidade")); 
                end.setEnderecoBairro(rs.getString("end_Bairro")); 
                end.setEnderecoRua(rs.getString("end_Rua")); 
                end.setEnderecoUF(rs.getString("end_UF")); 
                end.setEnderecoComplemento(rs.getString("end_Complemento"));
                end.setEnderecoNumero(rs.getInt("end_Numero")); 
                end.setEnderecoCEP(rs.getString("end_CEP"));
                
                cli.setEndereco(end);
                listaCliente.add(cli);
            }
            
            return listaCliente; // retorna a lista já preenchida
            
        } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Não foi possível consultar Clientes com endereço " + e.getMessage());
                return null;
        }
        
    }  
    

} // fim da classe
