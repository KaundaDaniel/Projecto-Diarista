/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author kaunda-daniel
 */
public class Diarista extends Pessoa{
   public Diarista(Long id, String nome, String telefone, String bI, String endereco){
       super(id, nome, telefone, bI, endereco);
   }
   public Diarista(String nome, String telefone, String bI, String endereco){
       super(null, nome, telefone, bI, endereco);
   }
   
    
}
