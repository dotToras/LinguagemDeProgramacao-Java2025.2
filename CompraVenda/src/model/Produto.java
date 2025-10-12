
package model;

/**
 * classe criada para representar os dados do Produto

 * @author Matheus Ferreira Gonçalves
*  @since classe criada em Oct 5, 2025
 */
public class Produto {

    private int produtoCodigo;
    private String produtoNome;
    private Float produtoValor;
    private int produtoQuantidadeEstoque;
    private int produtoQuantidadelimite;
    private String produtoDescricao;

    public Produto() {
        
    }
    
    @Override
    public String toString(){
        
       
        return this.produtoCodigo + " - " + this.produtoNome + " - " + this.produtoValor + " - " + this.produtoQuantidadeEstoque;
    }
    
    public int getProdutoCodigo() {
        return produtoCodigo;
    }

    public void setProdutoCodigo(int produtoCodigo) {
        this.produtoCodigo = produtoCodigo;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public Float getProdutoValor() {
        return produtoValor;
    }

    public void setProdutoValor(Float produtoValor) {
        this.produtoValor = produtoValor;
    }

    public int getProdutoQuantidadeEstoque() {
        return produtoQuantidadeEstoque;
    }

    public void setProdutoQuantidadeEstoque(int produtoQuantidadeEstoque) {
        this.produtoQuantidadeEstoque = produtoQuantidadeEstoque;
    }

    public int getProdutoQuantidadelimite() {
        return produtoQuantidadelimite;
    }

    public void setProdutoQuantidadelimite(int produtoQuantidadelimite) {
        this.produtoQuantidadelimite = produtoQuantidadelimite;
    }

    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }
    
    
    
    
} // fim da classe
