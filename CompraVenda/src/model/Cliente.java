
package model;

/**
 * Classe criada para representar as informações de um Cliente
 * @author Matheus Ferreira Gonçalves
 * @since Classe criada em 29/09/2025
 */
public class Cliente {

    private int codigo;
    private String nome;
    private String docIdentificador;
    private String telefone;
    private String email;
    private boolean tipo;
    Endereco endereco;

    @Override
    public String toString() {
        return this.getCodigo() + " - " + this.getNome() + " Documento: " + this.getDocIdentificador(); 
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocIdentificador() {
        return docIdentificador;
    }

    public void setDocIdentificador(String docIdentificador) {
        this.docIdentificador = docIdentificador;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
    
} // fim da classe
