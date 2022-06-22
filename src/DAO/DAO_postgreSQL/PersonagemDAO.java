package DAO.DAO_postgreSQL;

import DAO.intefaces.IPersonagemDAO;
import java.util.ArrayList;
import model.Personagem;
import connection.ConexaoBD_Setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Patrick
 */


public class PersonagemDAO implements IPersonagemDAO{

        @Override
        public boolean criar_personagem ( String nome, int nivel, int pontos_magia, int pontos_vida, int velocidade, int ataque_especial, int defesa_especial, int ataque, int defesa, int XP,  int evasao, String sprite,  int classe_id) {

                Connection conexao  = ConexaoBD_Setup.abrirConexao( );
                boolean sucesso = false;
                PreparedStatement preStmt = null;

                try{
                                String sql = "INSERT INTO personagem "
                                                 + "( nome, nivel, pontos_magia, pontos_vida, velocidade, ataque_especial, defesa_especial, ataque, defesa, XP, evasao, sprite, classe_id) "
                                                 + "values ( ?, ?, ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?, ? ) ";

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
                                preStmt.setInt(13, classe_id);

                                if ( preStmt.executeUpdate() ==1)
                                           sucesso = true;

                                preStmt.close();
                                conexao.close();
                                
                }catch(SQLException sql){
                        sql.printStackTrace();
                        sucesso = false;

                }finally{
                        return sucesso;
                }
    }

     
    @Override
    public void atualiza_personagemPorID (int ID, Personagem person) throws SQLException {
           
                Connection conexao  = ConexaoBD_Setup.abrirConexao( );
                PreparedStatement preStmt = null;

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
                                 + "classe_id = ?"
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
                preStmt.setInt( 13, person.getClasse_id());

                if ( preStmt.executeUpdate() ==1)
                         JOptionPane.showMessageDialog(null, "O personagem com ID "+ID+"foi atualizado com sucesso!!!", "Gotcha!!!", JOptionPane.INFORMATION_MESSAGE);

                preStmt.close();
                conexao.close();
    }

    
    @Override
    public void excluir_personagemPorID (int ID) throws SQLException{
      
                Connection conexao  = ConexaoBD_Setup.abrirConexao( );
                PreparedStatement preStmt = null;
           
                String sql = "DELETE FROM personagem WHERE ID = ?";
                preStmt =  conexao.prepareStatement( sql );
                preStmt.setInt( 1, ID );

                if ( preStmt.executeUpdate() ==1)
                         JOptionPane.showMessageDialog(null, "O personagem com ID "+ID+"foi atulizado com sucesso!!!", "Gotcha!!!", JOptionPane.INFORMATION_MESSAGE);

                preStmt.close();
                conexao.close();
    }

    
    @Override
    public List<Personagem> obter_personagens() throws SQLException{
                
                Connection con = ConexaoBD_Setup.abrirConexao();
                PreparedStatement preStmt = null;
                List<Personagem> personagens = new ArrayList<Personagem>();
                Personagem pers;
                
                String query = "SELECT * from personagem";
                PreparedStatement ps = con.prepareStatement( query );
                ResultSet resultado = ps.executeQuery();
               
                while ( resultado.next() ){
                         pers = new Personagem( resultado  );
                         
                         personagens.add ( pers );
                }
                
                resultado.close();
                ps.close();
                con.close();
                
                return personagens;
    }
    

    @Override
    public Personagem obter_Personagem_por_ID (int ID)  throws SQLException{
               
                Connection con = ConexaoBD_Setup.abrirConexao();
                PreparedStatement preStmt = null;
                Personagem pers = null;
              
                String query = "SELECT * FROM personagem WHERE ID = ?";
                preStmt = con.prepareStatement( query );
                preStmt.setInt(1, ID);

                ResultSet resultado = preStmt.executeQuery();

                if( resultado.isFirst() )
                        pers = new Personagem( resultado );
                
               resultado.close();
               preStmt.close();
               con.close();
               
               return pers;
    }

    
    
    @Override
    public Personagem obter_Personagem_por_nome(String nome) throws SQLException{
      
                Connection con = ConexaoBD_Setup.abrirConexao();
                PreparedStatement preStmt = null;
                Personagem pers = null;
                
                String query = "SELECT * FROM personagem WHERE nome = ?";
                preStmt = con.prepareStatement( query);
                preStmt.setString(1, nome);
               
                ResultSet resultado = preStmt.executeQuery();
                
                if( resultado.isFirst())
                     pers = new Personagem( resultado ); 
                
                resultado.close();
                preStmt.close();
                con.close();
                
                return pers;
    }
    
        
    
}
