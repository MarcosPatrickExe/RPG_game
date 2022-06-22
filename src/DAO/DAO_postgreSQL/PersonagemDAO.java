package DAO.DAO_postgreSQL;

import DAO.intefaces.IPersonagemDAO;
import java.util.ArrayList;
import model.Personagem;
import connection.ConexaoBD_Setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Patrick
 */


public class PersonagemDAO implements IPersonagemDAO{

        @Override
        public boolean criar_personagem ( String nome, int nivel, int pontos_magia, int pontos_vida, int velocidade, int ataque_especial, int defesa_especial, int ataque, int defesa, int XP,  int evasao, String sprite) {

                Connection conexao  = ConexaoBD_Setup.abrirConexao( );
                boolean sucesso = false;
                PreparedStatement preStmt = null;

                try{
                                String sql = "INSERT INTO personagem "
                                                 + "( nome, nivel, pontos_magia, pontos_vida, velocidade, ataque_especial, defesa_especial, ataque, defesa, XP, evasao, sprite) "
                                                 + "values ( ?, ?, ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ? ) ";

                                preStmt =  conexao.prepareStatement( sql );

                                preStmt.setString(1, nome);
                                preStmt.setInt(2, nivel);
                                preStmt.setInt(3, pontos_magia);
                                preStmt.setInt(4, pontos_vida);
                                preStmt.setInt(5,velocidade);
                                preStmt.setInt(6, ataque_especial);
                                preStmt.setInt(7, defesa_especial);
                                preStmt.setInt(8, ataque);
                                preStmt.setInt(9, defesa);
                                preStmt.setInt(10, XP);
                                preStmt.setInt(11, evasao);
                                preStmt.setString(12, sprite);

                                if ( preStmt.executeUpdate() ==1)
                                           sucesso = true;

                }catch(SQLException sql){
                                sql.printStackTrace();
                                sucesso = false;

                }finally{
                        preStmt.close();
                        conexao.close();
                }

                return sucesso;
    }

     
    @Override
    public void atualiza_personagemPorID (int ID, Personagem person) {
           
                Connection conexao  = ConexaoBD_Setup.abrirConexao( );
                PreparedStatement preStmt = null;

                try{
                                String sql = "UPDATE personagem "
                                                 + "SET  nome = ?, "
                                                 + "nivel = ?, "
                                                 + "pontos_magia, "
                                                 + "pontos_vida = ?, "
                                                 + "velocidade = ?, "
                                                 + "ataque_especial = ?, "
                                                 + "defesa_especial = ?, "
                                                 + "ataque = ?, "
                                                 + "defesa = ?, "
                                                 + "XP = ?, "
                                                 + "evasao = ?, "
                                                 + "sprite = ?"
                                                 + "WHERE ID = ? ";

                                preStmt =  conexao.prepareStatement( sql );

                                preStmt.setString( 1, person.getNome() );
                                preStmt.setInt( 2, person.getNivel() );
                                preStmt.setInt( 3, person.getPontos_magia());
                                preStmt.setInt( 4, person.getPontos_vida());
                                preStmt.setInt( 5, person.getVelocidade());
                                preStmt.setInt( 6, person.getAtaque_especial());
                                preStmt.setInt( 7, person.getDefesa_especial());
                                preStmt.setInt( 8, person.getAtaque());
                                preStmt.setInt( 9, person.getDefesa());
                                preStmt.setInt( 10, person.getXP());
                                preStmt.setInt( 11, person.getEvasao());
                                preStmt.setString( 12, person.getSprite());

                                if ( preStmt.executeUpdate() ==1)
                                         JOptionPane.showMessageDialog(null, "O personagem com ID "+ID+"foi atulizado com sucesso!!!", "Gotcha!!!", JOptionPane.INFORMATION_MESSAGE);
                  

                }catch(SQLException sql){
                                sql.printStackTrace();

                }finally{
                                preStmt.close();
                                conexao.close();
                }
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
