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
    
    // Metodo comum para inserir Fornecedor
    public void inserirFornecedor(Cliente cliente) {

        // Query para inserir primeiro em endereço
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
            
        } catch(SQLException e){
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
        
    }    
    
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
   
    
public List<Cliente> consultarClientesCPF() {
        
        String comando = "SELECT * FROM Cliente WHERE cli_tipo = 0";
        
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

public List<Cliente> consultarClientesCNPJ() {
        
        String comando = "SELECT * FROM Cliente WHERE cli_tipo = 1";
        
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

} // fim da classe
