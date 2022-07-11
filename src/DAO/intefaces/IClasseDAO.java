package DAO.intefaces;
import java.sql.SQLException;
import java.util.List;
import model.Classe;

/**
 *
 * @author Patrick
 * 
 */

public interface IClasseDAO {
    
    public List<Classe> obter_classes () ;
    
    public int obter_id_classe_por_nome (String nomeClasse) throws SQLException;
}
