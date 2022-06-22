package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * @author Patrick
 */
public class ConexaoBD_Setup {
    
        private static Connection conexao = null;
        
        private static String URL;
        private static String database;
        private static String host;
        private static short port;
        private static String user;
        private static int password;
        
        public static Connection conexao_Setup( String database, String host, short port, String user, int password ){
                  ConexaoBD_Setup.database = database;
                  ConexaoBD_Setup.host = host;
                  ConexaoBD_Setup.port = port;
                  ConexaoBD_Setup.user = user;
                  ConexaoBD_Setup.password = password;
                  ConexaoBD_Setup.URL = "jdbc:postgresql://"+host+":"+port+"/"+database;
      
                  return abrirConexao();
        }
        
        
        public static Connection abrirConexao ( ){
                    
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
                        
                    /*
                     // metodo 3:
                        String URL = "jdbc:postgresql://"+host+":"+port+"/"+database;
                        Properties properties = new Properties();
                        properties.put("user", user);
                        properties.put("password", password);

                        ConexaoBD_Setup.conexao = DriverManager.getConnection( URL, properties);
                        
                        if ( ConexaoBD_Setup.conexao != null) {
                                JOptionPane.showMessageDialog(null, "Conexão com o banco estabelecida!", "Gotcha!!!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    */
                          String URL = ConexaoBD_Setup.URL;
                          String user = ConexaoBD_Setup.user;
                          String pass = String.valueOf(  ConexaoBD_Setup.password  );
 
                          conexao = DriverManager.getConnection(URL, user, pass);
                          return conexao;
                        
                }catch(SQLException sqlE){
                        JOptionPane.showMessageDialog(null, "Houve erro de conexao", "Erro!!!", JOptionPane.ERROR_MESSAGE);
                        sqlE.printStackTrace();
                }
        }
        
        
        public static void encerrarConexao(){
                 try{
                        ConexaoBD_Setup.conexao.close();
                        
                 }catch(SQLException sqlE){
                        JOptionPane.showMessageDialog(null, "Houve um erro ao tentar desconectar com o banco", "Errro!!!", JOptionPane.ERROR_MESSAGE);
                        sqlE.printStackTrace();
                }
        }
        
        
        public static Connection getConexao(){
                   return ConexaoBD_Setup.conexao;
        }
    
}
