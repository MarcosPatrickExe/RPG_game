package DAO.DAO_postgreSQL;
import DAO.intefaces.ITecnicaDAO;
import connection.ConexaoBD_Setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Tecnica;

/**
 *
 * @author Patrick
 * 
 */

public class TecnicaDAO implements ITecnicaDAO {

    @Override
    public List<Tecnica> obter_tecnicas() throws SQLException {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
         Connection conexao  = ConexaoBD_Setup.abrirConexao();
         List<Tecnica> tecnicas = new ArrayList<>();
         PreparedStatement ps;
         String query = "SELECT * FROM \"Tecnica\"";
         ResultSet tecnicasCadastradas; 
      
        
         ps = conexao.prepareStatement(query);
         tecnicasCadastradas = ps.executeQuery();
         
         
         while( tecnicasCadastradas.next() ){
             tecnicas.add( 
                     new Tecnica( tecnicasCadastradas ) 
             );
         }
         
         ps.close();
         tecnicasCadastradas.close();
         ConexaoBD_Setup.encerrarConexao(conexao);
        
         return tecnicas;
    }


}
