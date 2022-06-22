package DAO.DAO_postgreSQL;

import DAO.intefaces.IPersonagemDAO;
import java.util.ArrayList;
import model.Personagem;

/**
 * @author Patrick
 */


public class PersonagemDAO implements IPersonagemDAO{

    @Override
    public Personagem criar_personagem ( String nome, int nivel, int pontos_magia, int pontos_pontos_vida, int velocidade, int ataque_especial, int defesa_especial, int ataque, int defesa, int evasao, String sprite) {
                
            Connection con  = connection.ConexaoBD_Setup.abrirConexao(sprite, nome, 0, nome, sprite)
        
            
    }

    @Override
    public void atualiza_personagemPorID (int ID) {
       
    }

    @Override
    public void excluir_personagemPorID(int ID) {
      
    }

    @Override
    public ArrayList<Personagem> obter_personagens() {
      
    }

    @Override
    public Personagem obter_Personagem_por_ID(int ID) {
       
    }

    @Override
    public Personagem obter_Personagem_por_nome(String nome) {
      
    }
    
        
    
}
