package DAO.intefaces;

import java.util.ArrayList;
import model.Personagem;

/**
 * @author Patrick
 * 
 */

public interface IPersonagemDAO {
            
          public Personagem criar_personagem(  String nome, int nivel, int pontos_magia, int pontos_pontos_vida, int velocidade, int ataque_especial, int defesa_especial, int ataque, int defesa, int evasao, String sprite );
           
          public void atualiza_personagemPorID( int ID );
          
          public void excluir_personagemPorID( int ID);
    
          public ArrayList<Personagem> obter_personagens ();
          
          public Personagem obter_Personagem_por_ID ( int ID);
          
          public Personagem obter_Personagem_por_nome (String nome);
}








/*
enum Valores{

        VALOR1 ( "test"), VALOR2, VALOR3; 
    
        String txt;
        
        Valores( String tes){
                this.txt = tes;
        }
}

*/