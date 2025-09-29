
package Models;

/**
 * Classe criada para representar as informações de um Cliente
 * @author Matheus Ferreira Gonçalves
 * @since Classe criada em 29/09/2025
 */
public class Cliente {

    private int codigoCliente;
    private String nomeCliente;
    private String emailCliente;
    private String telefoneCliente;
    
    public Cliente(int codigoCliente, String nomeCliente, String emailCliente, String telefoneCliente){
        this.codigoCliente = codigoCliente;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
    }
    
    
} // fim da classe
