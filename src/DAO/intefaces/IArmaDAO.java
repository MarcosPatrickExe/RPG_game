package DAO.intefaces;
import java.sql.SQLException;
import java.util.List;
import model.Arma;

/**
 * @author Patrick
 * 
 */

public interface IArmaDAO {
    
     public List<Arma> obter_armas () throws SQLException;
    
     
}
