/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade;

/**
 *
 * @author akiamara
 */
public class Aluno {
    
    public long codigo;
    public String nome;
    public String curso;
    public int semestre;
    
    public Aluno(long codigo, String nome, String curso, int semestre){
        this.codigo = codigo;
        this.nome = nome;
        this.curso = curso;
        this.semestre = semestre;
    }
    
    public Aluno(){
   
    }
    
    
}
