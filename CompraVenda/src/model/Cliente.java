
package model;

/**
 * Classe criada para representar as informações de um Cliente
 * @author Matheus Ferreira Gonçalves
 * @since Classe criada em 29/09/2025
 */
public class Cliente {

    private int codigoCliente;
    private String nomeCliente;
    private String docIdentificador;
    private String telefoneCliente;
    private String emailCliente;
    private boolean tipoCliente;
    private int enderecoCodigo;
    
    public Cliente(int codigoCliente, String nomeCliente, String docIdentificador, String telefoneCliente,String emailCliente, boolean tipoCliente, int enderecoCodigo){
        
        this.codigoCliente = codigoCliente;
        this.nomeCliente = nomeCliente;
        this.docIdentificador = docIdentificador;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
        this.tipoCliente = tipoCliente;
        this.enderecoCodigo = enderecoCodigo;
        
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDocIdentificador() {
        return docIdentificador;
    }

    public void setDocIdentificador(String docIdentificador) {
        this.docIdentificador = docIdentificador;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public boolean isTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(boolean tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getEnderecoCodigo() {
        return enderecoCodigo;
    }

    public void setEnderecoCodigo(int enderecoCodigo) {
        this.enderecoCodigo = enderecoCodigo;
    }
          
    
    
} // fim da classe
