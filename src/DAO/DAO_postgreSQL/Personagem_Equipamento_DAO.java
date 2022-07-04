package DAO.DAO_postgreSQL;
import connection.ConexaoBD_Setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Patrick
 * 
 */

public class Personagem_Equipamento_DAO {
    
    // MÉTODO QUE CADASTRA AS REFERENCIAS DE ESCUDO, ARMAS OU ACESSORIOS DE DETERMINADO PERSONAGEM
     public boolean add_equipamentos_personagem(int id_personagem, int id_equipamento, boolean equipado, int quantidade, String tipo_cadastro){
         
                String nomeTabela = null, nomeColuna = null;
         
                switch(tipo_cadastro){
                    case "arma":
                           nomeTabela = "Personagem_Arma";
                           nomeColuna = "Arma_id";
                           
                    case "escudo":
                           nomeTabela = "Personagem_Escudo";
                           nomeColuna = "Escudo_id";
                           
                    case "acessorio":
                           nomeTabela = "Personagem_Acessorio";
                           nomeColuna = "Acessorio_id";
                }
         
         
                Connection conexao  = ConexaoBD_Setup.abrirConexao();
                boolean sucesso = false;
                PreparedStatement preStmt = null;

                try{
                                String sql =  "INSERT INTO \""+nomeTabela+"\" ("
                                            + "Personagem_id, "
                                            +  nomeColuna +", "
                                            + "quantidade, "
                                            + "equipado ) "
                                            + "values ( ?, ?, ?, ?)";

                                
                                preStmt =  conexao.prepareStatement( sql );
                                preStmt.setInt(1, id_personagem);
                                preStmt.setInt(2, id_equipamento);
                                preStmt.setInt(3, quantidade);
                                preStmt.setBoolean(4, equipado);

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
     
     
     
     public boolean add_itens_personagem(int id_personagem, int id_item, int quantidade){
     
                Connection conexao  = ConexaoBD_Setup.abrirConexao();
                boolean sucesso = false;
                PreparedStatement preStmt = null;

                try{
                                String sql =  "INSERT INTO \"Personagem_Itens\" ("
                                            + "Personagem_id, "
                                            + "Item_id, "
                                            + "quantidade )"
                                            + "values ( ?, ?, ?)";

                                
                                preStmt =  conexao.prepareStatement( sql );
                                preStmt.setInt(1, id_personagem);
                                preStmt.setInt(2, id_item);
                                preStmt.setInt(3, quantidade);

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
     
     
     public boolean add_tecnicas_personagem( int id_personagem, int id_tecnica){
     
                Connection conexao  = ConexaoBD_Setup.abrirConexao();
                boolean sucesso = false;
                PreparedStatement preStmt = null;

                try{
                                String sql =  "INSERT INTO \"Personagem_Tecnicas\" ("
                                            + "Personagem_id, "
                                            + "Tecnicas_id )"
                                            + "values ( ?, ?)";
                                
                                preStmt =  conexao.prepareStatement( sql );
                                preStmt.setInt(1, id_personagem);
                                preStmt.setInt(2, id_tecnica);

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
}
