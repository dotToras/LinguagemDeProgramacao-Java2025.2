/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula01;

/**
 *
 * @author 2830482411033
 */
public class Aula01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    /*    
        System.out.println("Hallo Worudo");
        
        Carro c1 = new Carro();
        c1.anoFabricacao = 2025;
        c1.modelo = "BYD Dahrudji";
        
        System.out.println(c1.modelo);
        
        c1.ligar();
        
        System.out.println(c1.getEstado());
        
        if(c1.getEstado() == true)
        {
            System.out.println("O carro está ligado");
        }
        else
        {
            System.out.println("O carro está desligado");
        }
        
        Pessoa psa1 = new Pessoa();
        psa1.nome = "Judscrilson";
        
        Pessoa psa2 = new Pessoa();
        psa2.nome = "Marika";
        
        System.out.println("O nome da primeira pessoa eh:" + psa1.nome);
        System.out.println("O nome da segunda pessoa eh:" + psa2.nome);
        
     */  
        // Exercicio 1
        Livro livro1 = new Livro();
        
        livro1.titulo = "Moby Dick";
        livro1.autor = "Herman Melville";
        livro1.anoPublicacao = 1851;
        
        System.out.println("Titulo: " + livro1.titulo + "\nAutor: " + livro1.autor + "\nAno de Publicação: " + livro1.anoPublicacao);
        
    }
    
}
