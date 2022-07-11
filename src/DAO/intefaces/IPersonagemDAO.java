package DAO.intefaces;

import java.sql.SQLException;
import java.util.List;
import model.Personagem;

/**
 * @author Patrick
 * 
 */

public interface IPersonagemDAO {
            
          public int adicionar_personagem( 
                  String nome, int nivel, 
                     int pontos_vida, int pontos_magia,
                        int velocidade, int XP, int evasao,
                          int ataque, int defesa, 
                            int ataque_especial, int defesa_especial,
                               int classe_id, String sprite,
                                 int destreza, int forca,
                                   int HP_atual, int MP_atual );
           
          
          public void atualiza_personagem_por_ID( int ID, Personagem person ) throws SQLException;
          
          public void excluir_personagem_por_ID( int ID) throws SQLException;
    
          public List<Personagem> obter_personagens () throws SQLException;
          
          public Personagem obter_personagem_por_ID ( int ID) throws SQLException;
          
          public Personagem obter_personagem_por_nome (String nome);
          
          public List<Personagem> obter_personagens_por_classe( String nomeClasse );
          
          public boolean deletar_personagem_por_ID ( int idSelecionado );
          
          public boolean deletar_personagem_por_nome ( String nomePersonagem );
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