package DAO.intefaces;

import java.sql.SQLException;
import java.util.List;
import model.Tecnica;

/**
 *
 * @author Patrick
 * 
 */

public interface ITecnicaDAO {
    
    public List<Tecnica> obter_tecnicas () throws SQLException;
    
    
}
