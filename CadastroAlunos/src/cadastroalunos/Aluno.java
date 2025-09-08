/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadastroalunos;

/**
 * Classe criada para...
 * @author Matheus Ferreira Gonçalves
 * @since Classe criada em 08/09/2025
 */
public class Aluno {

    public String nome;
    public String curso;
    public int idade;
    
    
    public Aluno(String nome, int idade, String curso){
        this.nome = nome;
        this.curso = curso;
        this.idade = idade;
    }
    
    public Object[] obterDados(){    
        return new Object[] {nome, idade, curso};
    }
    
    
} // fim da classe
