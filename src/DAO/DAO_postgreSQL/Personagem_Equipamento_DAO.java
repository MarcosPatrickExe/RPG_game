package DAO.DAO_postgreSQL;
import connection.ConexaoBD_Setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                           nomeColuna = "Arma_id"; break;
                           
                    case "escudo":
                           nomeTabela = "Personagem_Escudo";
                           nomeColuna = "Escudo_id"; break;
                           
                    case "acessorio":
                           nomeTabela = "Personagem_Acessorio";
                           nomeColuna = "Acessorio_id"; break;
                }
         
         
                Connection conexao  = ConexaoBD_Setup.abrirConexao();
                boolean sucesso = false;
                PreparedStatement preStmt = null;

                try{
                                String sql =  "INSERT INTO \""+nomeTabela+"\" (" 
                                            + "\"Personagem_id\", " 
                                            + "\""+nomeColuna+"\", "
                                            + "quantidade, "
                                            + "equipado ) "
                                            + "values (?, ?, ?, ?)";

                                
                                System.out.println("\nQuery para inserir o ID de "+tipo_cadastro+" na coluna: "+nomeColuna+":  "+sql);
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
                                            + "\"Personagem_id\", "
                                            + "\"Item_id\", "
                                            + "quantidade )"
                                            + "values (?, ?, ?)";

                                
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
     
     
     
     
     public int obter_id_equipamento_por_nome (String nomeEquipamento, String tipoEquipamento) {
     
                String nomeTabela = null;
         
                switch( tipoEquipamento ){
                    case "arma":
                        nomeTabela = "Arma"; break;
                        
                    case "escudo":
                        nomeTabela = "Escudo"; break;
                        
                    case "acessorio":
                        nomeTabela = "Acessorio"; break;
                        
                    case "item":
                        nomeTabela = "Itens"; break;
                   /*     
                    case "tecnica":
                        nomeTabela = "Tecnicas"; */
                }
         
 /* 
        org.postgresql.util.PSQLException: O índice da coluna está fora do intervalo: 1, número de colunas: 0.
	at org.postgresql.core.v3.SimpleParameterList.bind(SimpleParameterList.java:70)
	at org.postgresql.core.v3.SimpleParameterList.setStringParameter(SimpleParameterList.java:133)
	at org.postgresql.jdbc.PgPreparedStatement.bindString(PgPreparedStatement.java:1078)
	at org.postgresql.jdbc.PgPreparedStatement.setString(PgPreparedStatement.java:379)
	at org.postgresql.jdbc.PgPreparedStatement.setString(PgPreparedStatement.java:365) 
  */          
                
                Connection conexao  = ConexaoBD_Setup.abrirConexao();
                String sql = "SELECT \"ID\" FROM \""+nomeTabela+"\" WHERE nome =\'"+nomeEquipamento+"\'";// SELECT \"ID\" FROM \""+nomeTabela+"\" WHERE nome='?'  
                int idEquipamento = 0;
                PreparedStatement preStmt = null;
                ResultSet result;
                
                
                try{
                       System.out.println("SQL QUERY para pegar o ID do "+nomeTabela+": "+sql);
                       preStmt = conexao.prepareStatement(sql);
                     //  preStmt.setString(1, nomeEquipamento);
                       result = preStmt.executeQuery();
                    
                       if( result.next()){
                           idEquipamento = result.getInt("ID");
                           System.out.println("ID do equipamento: "+idEquipamento+"");
                       }
                       
                       result.close();
                       preStmt.close();
                       ConexaoBD_Setup.encerrarConexao(conexao);
                    
                }catch( SQLException sqle){
                       System.out.println("Houve um erro com o banco de dados no metodo: 'obter_id_equipamento_por_nome' ");
                       sqle.printStackTrace();

                }finally{
                        return idEquipamento;
                }
     }
     
     
     
     
/*
     
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

*/

}
