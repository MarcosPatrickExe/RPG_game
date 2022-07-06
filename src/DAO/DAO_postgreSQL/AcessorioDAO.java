package DAO.DAO_postgreSQL;
import DAO.intefaces.IAcessorio;
import connection.ConexaoBD_Setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Acessorio;
/**
 *
 * @author Patrick
 */

public class AcessorioDAO implements IAcessorio {

    @Override
    public List<Acessorio> obter_acessorios() throws SQLException {
        
         Connection conexao  = ConexaoBD_Setup.abrirConexao( );
         List<Acessorio> acessorios = new ArrayList<>();
         PreparedStatement ps;
         String query = "SELECT * FROM \"Acessorio\"";
         ResultSet acessoriosCadastrados; 
      
         ps = conexao.prepareStatement(query);
         acessoriosCadastrados = ps.executeQuery();
         
         
         while( acessoriosCadastrados.next() ){
             acessorios.add( 
                     new Acessorio( acessoriosCadastrados ) 
             );
         }
         
         ps.close();
         acessoriosCadastrados.close();
         ConexaoBD_Setup.encerrarConexao( conexao );
        
         return acessorios;
    }
    
    
    
}
