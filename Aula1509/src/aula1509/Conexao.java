
package aula1509;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe criada para conectar com o banco de dados
 * @author Matheus Ferreira Gonçalves
 * @since Classe criada em 15/09/2025
 */
public class Conexao {

    public Connection getConexao(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabd01?useTimezone=true&serverTimezone=UTC",
                                                           "root", 
                                                           "root"); /*url, usuario senha */
            
            System.out.println("Conexão realizada com sucesso!!");
            return conn;
        }
        catch(Exception e){
            System.out.println("Erro ao conectar no BD" + e.getMessage());
            return null;
        }
    }
    
} // fim da classe
