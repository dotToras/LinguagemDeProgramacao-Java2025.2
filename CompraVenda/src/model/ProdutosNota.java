
package model;

/**
 * classe criada para representar os Dados dos Itens da Nota
 * @author Matheus Ferreira Gonçalves
 * @since classe criada em Oct 11, 2025
 */
public class ProdutosNota {

    int codigo;
    float valorUnidade;
    int quantidade;
    Produto produto;
    Nota NotaFiscal; 

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(float valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Nota getNotaFiscal() {
        return NotaFiscal;
    }

    public void setNotaFiscal(Nota NotaFiscal) {
        this.NotaFiscal = NotaFiscal;
    }

  
} // fim da classe
