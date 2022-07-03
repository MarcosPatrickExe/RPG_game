package DAO.DAO_postgreSQL;
import DAO.intefaces.IEscudoDAO;
import connection.ConexaoBD_Setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Escudo;

/**
 * @author Patrick
 * 
 */

public class EscudoDAO implements IEscudoDAO {
    
   @Override
   public List<Escudo> obter_escudos () throws SQLException{
   
         Connection conexao  = ConexaoBD_Setup.abrirConexao( );
         List<Escudo> escudos = new ArrayList<>();
         PreparedStatement ps;
         String query = "SELECT * FROM Escudo";
         ResultSet escudosCadastrados; 
      
        
         ps = conexao.prepareStatement(query);
         escudosCadastrados = ps.executeQuery();
         
         
         while( escudosCadastrados.next() ){
             escudos.add( 
                     new Escudo( escudosCadastrados ) 
             );
         }
         
         ps.close();
         escudosCadastrados.close();
         ConexaoBD_Setup.encerrarConexao( conexao );
        
         return escudos;
   }
    
}
