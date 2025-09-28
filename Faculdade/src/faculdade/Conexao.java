
package faculdade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author akiamara
 */
public class Conexao {
    
    public Connection getConexao(){
        try{
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdFaculdade?useTimezone=true&serverTimezone=UTC",
                                                           "root", 
                                                           "uma45A!çap"); /*url, usuario senha */
             System.out.println("Conexão realizada com sucesso");
             return conn;
        } catch (SQLException e){
            System.out.println("Erro ao conectar ao BD" + e.getMessage());
            return null;
        }
    }
    
}
