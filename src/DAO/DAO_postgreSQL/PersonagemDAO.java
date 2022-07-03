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
        public boolean criar_personagem ( 
                   String nome, int nivel, 
                     int pontos_vida, int pontos_magia,
                        int velocidade, int XP, int evasao,
                          int ataque, int defesa, 
                            int ataque_especial, int defesa_especial,
                               int classe_id, int sprite_id,
                                 int destreza, int forca,
                                   int HP_atual, int MP_atual
                                //       ,int acessorio_id, 
                                   ) {

            
                Connection conexao  = ConexaoBD_Setup.abrirConexao( );
                boolean sucesso = false;
                PreparedStatement preStmt = null;

                try{
                                String sql = "INSERT INTO personagem ("
                                                + "nome, "
                                                + "nivel, "
                                                + "HP_maximo, "
                                                + "MP_maximo, "
                                                + "velocidade, "
                                                + "XP, "
                                                + "evasao, "
                                                + "ataque, "
                                                + "defesa, "
                                                + "ataque_especial, "
                                                + "defesa_especial, "
                                                + "classe_id, "
                                                + "sprite_id, "
                                                + "destreza, "
                                                + "forca, "
                                                + "HP_atual, "
                                                + "MP_atual "
                                                + "values ( ?, ?, ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?, ?,  ?,  ?,  ?, ?)";

                                
                                preStmt =  conexao.prepareStatement( sql );

                                preStmt.setString(1, nome);
                                preStmt.setInt(2, nivel);
                                preStmt.setInt(3, pontos_vida);
                                preStmt.setInt(4, pontos_magia);
                                preStmt.setInt(5,velocidade);
                                preStmt.setInt(6, XP);
                                preStmt.setInt(7, evasao);
                                preStmt.setInt(8, ataque);
                                preStmt.setInt(9, defesa);
                                preStmt.setInt(10, ataque_especial);
                                preStmt.setInt(11, defesa_especial);
                                preStmt.setInt(12, classe_id);
                                preStmt.setInt(13, sprite_id);
                                preStmt.setInt(14, destreza);
                                preStmt.setInt(15, forca);
                                preStmt.setInt(16, HP_atual);
                                preStmt.setInt(17, MP_atual);
                                

                                if ( preStmt.executeUpdate() ==1)
                                           sucesso = true;

                                preStmt.close();
                                ConexaoBD_Setup.encerrarConexao(conexao);
                                
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

                String sql =  "UPDATE personagem "
                            + "SET nome = ?, "
                            + "nivel = ?, "
                            + "HP_maximo= ?, "
                            + "MP_maximo = ?, "
                            + "velocidade = ?, "
                            + "XP = ?, "
                            + "evasao = ?, "
                            + "ataque = ?, "
                            + "defesa = ?, "
                            + "ataque_especial = ?, "
                            + "defesa_especial = ?, "
                            + "classe_id = ?"
                            + "sprite_id = ?"
                            + "destreza = ?"
                            + "forca = ?"
                            + "HP_atual= ?, "
                            + "MP_atual = ?, "
                            + "WHERE ID = ? ";

                preStmt =  conexao.prepareStatement( sql );

                preStmt.setString( 1, person.getNome() );
                preStmt.setInt( 2, person.getNivel() );
                preStmt.setInt( 3, person.getPontos_vida());
                preStmt.setInt( 4, person.getPontos_magia());
                preStmt.setInt( 5, person.getVelocidade());
                preStmt.setInt( 6, person.getXP());
                preStmt.setInt( 7, person.getEvasao());
                preStmt.setInt( 8, person.getAtaque());
                preStmt.setInt( 9, person.getDefesa());
                preStmt.setInt( 10, person.getAtaque_especial());
                preStmt.setInt( 11, person.getDefesa_especial());
                preStmt.setInt( 12, person.getClasse_id());
                preStmt.setInt( 13, person.getSprite_id());
                preStmt.setInt( 14, person.getDestreza());
                preStmt.setInt( 15, person.getForca());
                preStmt.setInt( 16, person.getHP_atual());
                preStmt.setInt( 17, person.getMP_atual());
                

                if ( preStmt.executeUpdate() ==1)
                         JOptionPane.showMessageDialog(null, "O personagem com ID "+ID+"foi atualizado com sucesso!!!", "Gotcha!!!", JOptionPane.INFORMATION_MESSAGE);

                preStmt.close();
                ConexaoBD_Setup.encerrarConexao(conexao);
    }

    
    @Override
    public void excluir_personagemPorID (int ID) throws SQLException{
      
                Connection conexao  = ConexaoBD_Setup.abrirConexao( );
                PreparedStatement preStmt = null;
           
                String sql = "DELETE FROM personagem WHERE ID = ?";
                preStmt =  conexao.prepareStatement(sql);
                preStmt.setInt( 1, ID );

                if ( preStmt.executeUpdate() ==1)
                         JOptionPane.showMessageDialog(null, "O personagem com ID "+ID+"foi atulizado com sucesso!!!", "Gotcha!!!", JOptionPane.INFORMATION_MESSAGE);

                preStmt.close();
                ConexaoBD_Setup.encerrarConexao(conexao);
    }

    
    @Override
    public List<Personagem> obter_personagens() throws SQLException{
                
                Connection con = ConexaoBD_Setup.abrirConexao();
                PreparedStatement preStmt = null;
                List<Personagem> personagens = new ArrayList<Personagem>();
                Personagem pers;
                
                String query = "SELECT * from Personagem";
                preStmt = con.prepareStatement( query );
                ResultSet resultado = preStmt.executeQuery();
               
                while ( resultado.next() ){
                    pers = new Personagem( resultado );

                    personagens.add ( pers );
                }
                
                resultado.close();
                preStmt.close();
                ConexaoBD_Setup.encerrarConexao(con);
                
                
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
               ConexaoBD_Setup.encerrarConexao(con);
               
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
                ConexaoBD_Setup.encerrarConexao(con);
                
                return pers;
    }
    
        
    
}
