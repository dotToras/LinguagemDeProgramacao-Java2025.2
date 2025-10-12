
package model;

/**
 * classe criada para...

 * @author Matheus Ferreira Gonçalves
*  @since classe criada em Oct 10, 2025
 */
public class Fornecedor {

    private int codigo;
    private String nome;
    private String nomeFantasia;
    private String CNPJ;
    private String email;
    private String telefone;
    Endereco endereco;

    @Override
    public String toString() {
        return this.getCodigo() + " - " + this.getNome() + " CNPJ: " + this.getCNPJ();
                
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

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    
    
} // fim da classe
