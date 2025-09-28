/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package faculdade;

/**
 * classe criada para representar os dados de professores
 * @author Matheus Ferreira Gonçalves
 *  @since classe criada em Sep 28, 2025
 */
public class Professor {

    public int codigoFuncionario;
    public String nome;
    public String disciplina;
    public float salario;
    
    public Professor(int codigoFuncionario, String nome, String disciplina, float salario){
        this.codigoFuncionario = codigoFuncionario;
    }
    
    public Professor() {
        
    }
} // fim da classe
