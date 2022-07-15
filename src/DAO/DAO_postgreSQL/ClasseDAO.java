package DAO.DAO_postgreSQL;
import DAO.intefaces.IClasseDAO;
import connection.ConexaoBD_Setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Classe;

/**
 * @author Patrick
 * 
 */

public class ClasseDAO implements IClasseDAO{

    @Override
    public List<Classe> obter_classes(){
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           
            List<Classe> classes = null;
            
            try{
                Connection conexao  = ConexaoBD_Setup.abrirConexao();
                classes = new ArrayList<>();
                PreparedStatement ps;
                String query = "SELECT * FROM \"Classe\"";
                ResultSet classesCadastradas;

                ps = conexao.prepareStatement(query);
                classesCadastradas = ps.executeQuery();

                while( classesCadastradas.next() ){
                    classes.add( 
                            new Classe( classesCadastradas ) 
                    );
                }

                ps.close();
                classesCadastradas.close();
                ConexaoBD_Setup.encerrarConexao(conexao);

            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                return classes;
            }
    }
    
    
    
    @Override
    public int obter_id_classe_por_nome (String nomeClasse) {
        
        int ID = 0;
        
        try{
            Connection conexao  = ConexaoBD_Setup.abrirConexao();
            List<Classe> classes = new ArrayList<>();
            PreparedStatement ps;
            String query = "SELECT * FROM \"Classe\" WHERE \"nome\" = ?";
            ResultSet resultado;

            ps = conexao.prepareStatement(query);
            ps.setString(1, nomeClasse);
            resultado = ps.executeQuery();
            
            if( resultado.next())
                ID = resultado.getInt("ID");
         
            resultado.close();
            ps.close();
            ConexaoBD_Setup.encerrarConexao(conexao);
            
        }catch( SQLException sqle){
            sqle.printStackTrace();
        
        }finally{
            return ID;
        }
         
    }
    
    
    
    
    @Override
    public String[] obter_nomes_classes () {
        String[] nomes = null;
        
        try{
            Connection conexao  = ConexaoBD_Setup.abrirConexao();
            
            PreparedStatement ps;
            String query = "SELECT \"nome\" FROM \"Classe\" ORDER BY \"ID\" ASC";
            ResultSet resultado;

           // OS 2 ULTIMOS PARAMETROS PERMITEM QUE O RESULSET SEJA LIDO DE TRÁS PRA FRENTE E/OU DE FRENTE PARA TRÁS
            ps = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultado = ps.executeQuery();
            
            resultado.last();// MOVENDO O PONTEIRO PARA A ULTIMA LINHA
            nomes = new String[ resultado.getRow() ]; 
            resultado.beforeFirst();// MOVENDO O PONTEIRO PARA ANTES DA PRIMEIRA LINHA
            
            if( resultado.next())
                nomes[ resultado.getRow()-1 ] = resultado.getString("nome");
               
            resultado.close();
            ps.close();
            ConexaoBD_Setup.encerrarConexao(conexao);
            
        }catch( SQLException sqle){
            sqle.printStackTrace();
        
        }finally{
            return nomes;
        }
         
    }
    
    
    
}
