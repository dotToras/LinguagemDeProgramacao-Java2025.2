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

//Classe
public class Carro {

    // Atributos
   public String modelo;
   public int anoFabricacao;
   private String cor;
   private boolean estado;
   
   // Metodos
   public void ligar()
   {
       estado = true;
   }
   
   public void desligar()
   {
       estado = false;
   }
   
   public boolean getEstado()
   {
       return estado;
   }
}
