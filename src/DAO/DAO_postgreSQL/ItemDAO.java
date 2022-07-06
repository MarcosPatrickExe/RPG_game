package DAO.DAO_postgreSQL;
import DAO.intefaces.IItemDAO;
import connection.ConexaoBD_Setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Item;

/**
 * 
 * @author Patrick
 * 
 */

public class ItemDAO implements IItemDAO{
    
     
     @Override
     public List<Item> obter_itens () throws SQLException{
     
         Connection conexao  = ConexaoBD_Setup.abrirConexao();
         List<Item> itens = new ArrayList<>();
         PreparedStatement ps;
         String query = "SELECT * FROM \"Itens\"";
         ResultSet itensCadastrados; 
      
        
         ps = conexao.prepareStatement( query );
         itensCadastrados = ps.executeQuery();
         
         
         while( itensCadastrados.next() ){
             itens.add( 
                     new Item( itensCadastrados ) 
             );
         }
         
         ps.close();
         itensCadastrados.close();
         ConexaoBD_Setup.encerrarConexao( conexao );
        
         return itens;
     }
     
     
}
