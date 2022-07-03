package DAO.intefaces;
import java.sql.SQLException;
import java.util.List;
import model.Item;
/**
 *
 * @author Patrick
 * 
 */

public interface IItemDAO {
    
     public List<Item> obter_itens () throws SQLException;
     
}
