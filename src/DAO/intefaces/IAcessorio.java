package DAO.intefaces;
import java.sql.SQLException;
import java.util.List;
import model.Acessorio;

/**
 *
 * 
 * @author Patrick
 * 
 * 
 */

public interface IAcessorio {
    
    public List<Acessorio> obter_acessorios () throws SQLException;
    
}
