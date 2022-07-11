package DAO.DAO_postgreSQL;
import DAO.intefaces.IPersonagemDAO;
import java.util.ArrayList;
import model.Personagem;
import connection.ConexaoBD_Setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Patrick
 */


public class PersonagemDAO implements IPersonagemDAO{

        @Override
        public int adicionar_personagem ( 
                   String nome, int nivel, 
                     int pontos_vida, int pontos_magia,
                        int velocidade, int XP, int evasao,
                          int ataque, int defesa, 
                            int ataque_especial, int defesa_especial,
                               int classe_id, String sprite,
                                 int destreza, int forca,
                                   int HP_atual, int MP_atual
                                //       ,int acessorio_id, 
                                   ) {

            
                Connection conexao  = ConexaoBD_Setup.abrirConexao( );
                int idPersonagem = 0;
                PreparedStatement preStmt = null;
                ResultSet ultimoPersonagem = null;

                try{
                                String sql = "INSERT INTO \"Personagem\" ("
                                                + "nome, "
                                                + "nivel, "
                                                + "\"HP_maximo\", "
                                                + "\"MP_maximo\", "
                                                + "velocidade, "
                                                + "\"XP\", "
                                                + "evasao, "
                                                + "ataque, "
                                                + "defesa, "
                                                + "ataque_especial, "
                                                + "defesa_especial, "
                                                + "classe_id, "
                                                + "sprite, "
                                                + "destreza, "
                                                + "forca, "
                                                + "\"HP_atual\", "
                                                + "\"MP_atual\" ) "
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
                                preStmt.setString(13, sprite);
                                preStmt.setInt(14, destreza);
                                preStmt.setInt(15, forca);
                                preStmt.setInt(16, HP_atual);
                                preStmt.setInt(17, MP_atual);
                                

                                if ( preStmt.executeUpdate()==1 ){
                                
                                        preStmt = conexao.prepareStatement("SELECT max(\"ID\") AS \"ultimo_id\" FROM \"Personagem\" ");
                                        ultimoPersonagem = preStmt.executeQuery();

                                        if( ultimoPersonagem.next() )
                                            idPersonagem = ultimoPersonagem.getInt("ultimo_id");

                                                   // NAO FUNCIONA:
                                                     /*      
                                                       res = preStmt.getGeneratedKeys();//Recupera o ultimo registro inserido na tabela

                                                        if(res.next()){
                                                             System.out.println("ID do ultimo personagem: "+res.getInt(1));
                                                             id = res.getInt("ID");
                                                        }
        *                                            */
                                }
                                
                                           
                                ultimoPersonagem.close();
                                preStmt.close();
                                ConexaoBD_Setup.encerrarConexao(conexao);
                                
                }catch(SQLException sql){
                        System.err.println("Houve um erro no cadastro do personagem... ");
                        sql.printStackTrace();

                }finally{
                        return idPersonagem;
                }
    }
        

//========================================================================================================
     
        
    @Override
    public void atualiza_personagem_por_ID (int ID, Personagem person) throws SQLException {
           
                Connection conexao  = ConexaoBD_Setup.abrirConexao( );
                PreparedStatement preStmt = null;

                String sql =  "UPDATE \"Personagem\" "
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
                            + "classe_id = ?, "
                            + "sprite = ?, "
                            + "destreza = ?, "
                            + "forca = ?, "
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
                preStmt.setString( 13, person.getSprite());
                preStmt.setInt( 14, person.getDestreza());
                preStmt.setInt( 15, person.getForca());
                preStmt.setInt( 16, person.getHP_atual());
                preStmt.setInt( 17, person.getMP_atual());
                

                if ( preStmt.executeUpdate() ==1)
                         JOptionPane.showMessageDialog(null, "O personagem com ID "+ID+"foi atualizado com sucesso!!!", "Gotcha!!!", JOptionPane.INFORMATION_MESSAGE);

                preStmt.close();
                ConexaoBD_Setup.encerrarConexao(conexao);
    }

//========================================================================================================
    
    @Override
    public void excluir_personagem_por_ID (int ID) throws SQLException{
      
                Connection conexao  = ConexaoBD_Setup.abrirConexao( );
                PreparedStatement preStmt = null;
           
                String sql = "DELETE FROM \"Personagem\" WHERE \"ID\" = ?";
                preStmt =  conexao.prepareStatement(sql);
                preStmt.setInt( 1, ID );

                if ( preStmt.executeUpdate() ==1)
                         JOptionPane.showMessageDialog(null, "O personagem com ID "+ID+"foi atulizado com sucesso!!!", "Gotcha!!!", JOptionPane.INFORMATION_MESSAGE);

                preStmt.close();
                ConexaoBD_Setup.encerrarConexao(conexao);
    }

//========================================================================================================
    
    @Override
    public List<Personagem> obter_personagens() {
                
                Connection con = ConexaoBD_Setup.abrirConexao();
                PreparedStatement preStmt = null;
                List<Personagem> personagens = null;
                Personagem pers;
                String query = "SELECT * from \"Personagem\"";
                
                try{
                    preStmt = con.prepareStatement( query );
                    ResultSet resultado = preStmt.executeQuery();
                    personagens = new ArrayList<Personagem>();

                    while ( resultado.next() ){
                            pers = new Personagem( resultado );
                            personagens.add(pers);
                    }

                    resultado.close();
                    preStmt.close();
                    ConexaoBD_Setup.encerrarConexao(con);
                    
                }catch(SQLException sqle){
                    System.out.println("Houve um problema ao tentar recuperar todos os personagens...");
                    sqle.printStackTrace();
                }finally{
                    return personagens;
                }
    }
    
//========================================================================================================
  
    @Override
    public List<Personagem> obter_personagens_por_classe(String nomeClasse) {
                
                Connection con = ConexaoBD_Setup.abrirConexao();
                PreparedStatement preStmt = null;
                List<Personagem> personagens = null;
                Personagem pers;
                int id_classe;
               // String subQuery = "SELECT \"ID\" FROM \"Classe\" WHERE \"nome\"=?";
                ClasseDAO classDAO = new ClasseDAO();
                String query = "SELECT * from \"Personagem\" WHERE \"classe_id\"= ?";
                
                try{
               //     preStmt = con.prepareStatement(subQuery);
              /*      preStmt.setString(1, nomeClasse);
                    if( preStmt.executeQuery().next() )
                       idClasse = preStmt.getInt(1); 
                    */
                    id_classe = classDAO.obter_id_classe_por_nome(nomeClasse);
                    
                    if(id_classe != 0){
                            preStmt = con.prepareStatement( query );
                            preStmt.setInt(1, id_classe);
                            ResultSet resultado = preStmt.executeQuery();
                            
                   //VERIFICANDO SE O RESULTSET TEM UMA OU MAIS LINHAS. SE TIVER, ELE IRA PREENCHER A LISTA: 
                            personagens = new ArrayList<Personagem>();
                            while ( resultado.next() ){
                                    pers = new Personagem( resultado );
                                    personagens.add(pers);
                                    System.out.println("Tamanho da lista: "+personagens.size()+" // nome do personagem: "+personagens.get(0).getNome());
                            }
                            
                            
                            if (personagens.size()==0){
                                personagens.add(0, null);
                             // ISSO INDICA QUE A CLASSE PESQUISADA EXISTE, 
                             // POREM, NAO HÁ NENHUM PERSONAGEM CADASTRADO COM ELA
                                System.out.println("Tamanho da lista2: "+personagens.size()+" // nome do personagem: "+personagens.get(0).getNome());
                            }

                            resultado.close();
                            preStmt.close();
                            ConexaoBD_Setup.encerrarConexao(con);
                    }else{
                         JOptionPane.showMessageDialog(null, "A referida classe não existe no banco de dados!!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }catch(SQLException sqle){
                    System.out.println("Houve um problema ao tentar recuperar todos os personagens por classe...");
                    sqle.printStackTrace();
                    
                }finally{
                    return personagens;
                }
    }
    
//========================================================================================================

    @Override
    public Personagem obter_personagem_por_ID (int ID) {
               
                Connection con = ConexaoBD_Setup.abrirConexao();
                PreparedStatement preStmt = null;
                Personagem pers = null;
                String query = "SELECT * FROM \"Personagem\" WHERE \"ID\" = ?";
                
                try{
                    preStmt = con.prepareStatement( query );
                    preStmt.setInt(1, ID);
                    ResultSet resultado = preStmt.executeQuery();

                    if( resultado.next() )
                            pers = new Personagem( resultado );

                    resultado.close();
                    preStmt.close();
                    ConexaoBD_Setup.encerrarConexao(con);
               
                }catch(SQLException sqle){
                    System.out.println("Houve um problema ao tentar recuperar o personagem através do seu ID...");
                    sqle.printStackTrace();
                    
                }finally{
                    return pers;
                }
    }

//========================================================================================================
    
    @Override
    public Personagem obter_personagem_por_nome(String nome) {
           
                Connection con = ConexaoBD_Setup.abrirConexao();
                PreparedStatement preStmt = null;
                Personagem pers = null;
                String query = "SELECT * FROM \"Personagem\" WHERE \"nome\" ='"+nome+"'";
                
                try{
                    preStmt = con.prepareStatement( query);
                    //preStmt.setString(1, nome);

                    ResultSet resultado = preStmt.executeQuery();

                    if( resultado.next())
                         pers = new Personagem( resultado ); 
                    
                    resultado.close();
                    preStmt.close();
                    ConexaoBD_Setup.encerrarConexao(con);
                
                }catch(SQLException sqle){
                  //  System.out.println("Houve um problema ao tentar recuperar o personagem através do seu nome...");
                    sqle.printStackTrace();
                    
                }finally{
                    return pers;
                }
    }
    
    
//========================================================================================================

    
    @Override
    public boolean deletar_personagem_por_ID ( int idSelecionado ){
    
                Connection con = ConexaoBD_Setup.abrirConexao();
                PreparedStatement preStmt = null;
                boolean deletado = false;
                String query = "DELETE FROM \"Personagem\" WHERE \"ID\" = ?";
                
                try{
                    preStmt = con.prepareStatement( query );
                    preStmt.setInt(1, idSelecionado);
                   

                    if( preStmt.executeUpdate()==1 )
                            deletado = true;

                 
                    preStmt.close();
                    ConexaoBD_Setup.encerrarConexao(con);
               
                }catch(SQLException sqle){
                    sqle.printStackTrace();
                    
                }finally{
                    return deletado;
                }
    }
 
    
//========================================================================================================

 
    @Override
    public boolean deletar_personagem_por_nome ( String nomePersonagem ){
    
                Connection con = ConexaoBD_Setup.abrirConexao();
                PreparedStatement preStmt = null;
                boolean deletado = false;
                String query = "DELETE FROM \"Personagem\" WHERE \"nome\"='"+nomePersonagem+"'";
                
                try{
                    preStmt = con.prepareStatement( query );

                    if( preStmt.executeUpdate()==1 )
                            deletado = true;

                    preStmt.close();
                    ConexaoBD_Setup.encerrarConexao(con);
               
                }catch(SQLException sqle){
                    sqle.printStackTrace();
                    
                }finally{
                    return deletado;
                }
    }
    
 
//========================================================================================================
 
    
    @Override
    public boolean atualizar_personagem_atributos ( Personagem pers){
            
                Connection con = ConexaoBD_Setup.abrirConexao();
                PreparedStatement preStmt = null;
                boolean atualizado = false;
                String sql = "UPDATE \"Personagem\" "
                            + "SET nome = '"+pers.getNome()+"', "
                            + "nivel = ?, "
                            + "\"HP_maximo\"= ?, "
                            + "\"MP_maximo\" = ?, "
                            + "velocidade = ?, "
                            + "\"XP\" = ?, "
                            + "evasao = ?, "
                            + "ataque = ?, "
                            + "defesa = ?, "
                            + "ataque_especial = ?, "
                            + "defesa_especial = ?, "
                            + "classe_id = ?, "
                          //  + "sprite = ?, "
                            + "destreza = ?, "
                            + "forca = ?, "
                            + "\"HP_atual\"= ?, "
                            + "\"MP_atual\" = ? "
                            + "WHERE \"ID\" = ? ";
                
                try{
                    preStmt = con.prepareStatement(sql);
             //       preStmt.setString(1, pers.getNome());
                    preStmt.setInt(1, pers.getNivel());
                    preStmt.setInt(2, pers.getPontos_vida());
                    preStmt.setInt(3, pers.getPontos_magia());
                    preStmt.setInt(4, pers.getVelocidade());
                    preStmt.setInt(5, pers.getXP());
                    preStmt.setInt(6, pers.getEvasao());
                    preStmt.setInt(7, pers.getAtaque());
                    preStmt.setInt(8, pers.getDefesa());
                    preStmt.setInt(9, pers.getAtaque_especial());
                    preStmt.setInt(10, pers.getDefesa_especial());
                    preStmt.setInt(11, pers.getClasse_id());
            //        preStmt.setString(13, pers.getSprite());
                    preStmt.setInt(12, pers.getDestreza());
                    preStmt.setInt(13, pers.getForca());
                    preStmt.setInt(14, pers.getHP_atual());
                    preStmt.setInt(15, pers.getMP_atual());
                    preStmt.setInt(16, pers.getID());
                    
                    
                    if( preStmt.executeUpdate() ==0 ){
                          
                            System.out.println("No Atualizado!! retornou 0");
                    }
                    
                    if( preStmt.executeUpdate() >0 ){
                            atualizado = true;
                            System.out.println("Atualizado!!");
                    }
                    
                    System.out.println("Atualizado? "+atualizado);

                    preStmt.close();
                    ConexaoBD_Setup.encerrarConexao(con);
               
                }catch(SQLException sqle){
                    sqle.printStackTrace();
                    
                }finally{
                    return atualizado;
                }
    }
    
    
    @Override
    public boolean atualizar_imagem_personagem ( String imagem){
        return false;
    }
    
}
