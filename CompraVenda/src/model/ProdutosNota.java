/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 * classe criada para...

 * @author Matheus Ferreira Gonçalves
*  @since classe criada em Oct 11, 2025
 */
public class ProdutosNota {

    int codigo;
    float valorUnidade;
    int quantidade;
    int codProduto;
    int codNotaFiscal;

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

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodNotaFiscal() {
        return codNotaFiscal;
    }

    public void setCodNotaFiscal(int codNotaFiscal) {
        this.codNotaFiscal = codNotaFiscal;
    }

    
    
    
} // fim da classe
