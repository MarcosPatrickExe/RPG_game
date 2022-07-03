package DAO.intefaces;
import java.sql.SQLException;
import java.util.List;
import model.Escudo;

/**
 * @author Patrick
 * 
 */

public interface IEscudoDAO {
    
     public List<Escudo> obter_escudos () throws SQLException;
    
    
}
