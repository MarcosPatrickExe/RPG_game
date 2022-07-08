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
    public List<Classe> obter_classes() throws SQLException {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
         Connection conexao  = ConexaoBD_Setup.abrirConexao();
         List<Classe> classes = new ArrayList<>();
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
        
         return classes;
    }
    
    
    
    @Override
    public int obter_classe_por_nome (String nomeClasse) {
        
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
            ID=0;
        
        }finally{
            return ID;
        }
         
    }
    
    
    
    
    
    
}
