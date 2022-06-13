package rpg_game;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * @author Patrick
 */
public class ConexaoBD {
    
        private static Connection conexao= null;
        
        public void abrirConexao(){
                    
                try{
                     /*
                    //metodo 1:
                        String URL = "jdbc:postgresql:rpg_database?user=postgres&password=";
                        conexao = DriverManager.getConnection(URL);
                
                        if( conexao != null){
                                System.out.println("conexao iniciada com sucesso!!!!  \n"
                                        + " database name: "+conexao.get);
                        }
                    */
                               
                     /*
                    //metodo 2:
                        String URL = "jdbc:postgresql://localhost/rpg_game";
                        String user = "postgres";
                        String pass = "";
 
                        conexao = DriverManager.getConnection(URL, user, pass);
                
                        if( conexao != null){
                                System.out.println("conexao iniciada com sucesso!!!!  \n"
                                        + " database name: rpg_game"conexao.);
                        }
                     */
                        
                        
                     // metodo 3:
                        String URL = "jdbc:postgresql://localhost:5432/rpg_database";
                        Properties parameters = new Properties();
                        parameters.put("user", "postgres");
                        parameters.put("password", "postgres");

                        conexao = DriverManager.getConnection( URL, parameters);
                        if (conexao != null) {
                               System.out.println("Conectado ao banco de dados com sucesso!!!!");
                        }
                        
                        
                }catch(SQLException sqlE){
                        JOptionPane.showMessageDialog(null, "Houve erro de conexao", "Errro!!!", JOptionPane.ERROR_MESSAGE);
                        sqlE.printStackTrace();
                }
        }
        
        
        public void encerrarConexao(){
                 try{
                        conexao.close();
                        
                 }catch(SQLException sqlE){
                        JOptionPane.showMessageDialog(null, "Houve um erro ao tentar desconectar com o banco", "Errro!!!", JOptionPane.ERROR_MESSAGE);
                        sqlE.printStackTrace();
                }
        }
    
}
