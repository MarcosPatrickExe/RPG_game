package DAO.DAO_postgreSQL;
import DAO.intefaces.IArmaDAO;
import connection.ConexaoBD_Setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Arma;

/**
 * @author Patrick
 * 
 */

public class ArmaDAO implements IArmaDAO{
    
     @Override
     public List<Arma> obter_armas () throws SQLException{
         
         Connection conexao  = ConexaoBD_Setup.abrirConexao( );
         List<Arma> armas = new ArrayList<>();
         PreparedStatement ps;
         String query = "SELECT * FROM Arma";
         ResultSet armasCadastradas; 
      
        
         ps = conexao.prepareStatement(query);
         armasCadastradas = ps.executeQuery();
         
         
         while( armasCadastradas.next() ){
             armas.add( 
                     new Arma( armasCadastradas ) 
             );
         }
         
         ps.close();
         armasCadastradas.close();
         ConexaoBD_Setup.encerrarConexao(conexao);
        
         return armas;
     }
    
}
