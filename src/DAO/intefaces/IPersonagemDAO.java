package DAO.intefaces;

import java.sql.SQLException;
import java.util.List;
import model.Personagem;

/**
 * @author Patrick
 * 
 */

public interface IPersonagemDAO {
            
          public boolean criar_personagem( String nome, int nivel, int pontos_magia, int pontos_vida, int velocidade, int ataque_especial, int defesa_especial, int ataque, int defesa, int XP,  int evasao, String sprite, int classe_id );
           
          public void atualiza_personagemPorID( int ID, Personagem person ) throws SQLException;
          
          public void excluir_personagemPorID( int ID) throws SQLException;
    
          public List<Personagem> obter_personagens () throws SQLException;
          
          public Personagem obter_Personagem_por_ID ( int ID) throws SQLException;
          
          public Personagem obter_Personagem_por_nome (String nome) throws SQLException;
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