package model;

/**
 * classe criada para representar os Dados de uma Nota
 * @author Matheus Ferreira Gonçalves
 * @since classe criada em Oct 11, 2025
 */
public class Nota {

    int codigo;
    float valorTotal;
    String dataEmissao;
    String formaPagamento;
    boolean tipoNota;
    Cliente cliente;
    Fornecedor fornecedor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean isTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(boolean tipoNota) {
        this.tipoNota = tipoNota;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
} // fim da classe
