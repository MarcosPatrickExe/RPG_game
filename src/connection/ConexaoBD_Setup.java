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
    
        public static boolean conexaoEstabelecida = false;
        
        private static String URL;
        private static String database;
        private static String host;
        private static short port;
        private static String user;
        private static String password;
        
        public static void conexao_Setup( String database, String host, short port, String user, String password ) throws ClassNotFoundException{
                  Class.forName("org.postgresql.Driver");
            
                  ConexaoBD_Setup.database = database;
                  ConexaoBD_Setup.host = host;
                  ConexaoBD_Setup.port = port;
                  ConexaoBD_Setup.user = user;
                  ConexaoBD_Setup.password = password;
                  ConexaoBD_Setup.URL = "jdbc:postgresql://"+host+":"+port+"/"+database;
        }
        
        
        public static Connection abrirConexao(){
                    
                Connection conexao = null;
            
                try{
                     /*
                    //metodo 1:
                        String URL = "jdbc:postgresql:+"+ConexaoBD_Setup.database+"+?user="+ConexaoBD_Setup.user+"&password="+ConexaoBD_Setup.password;
                        conexao = DriverManager.getConnection(URL);
                
                        if( conexao != null){
                                System.out.println("conexao iniciada com sucesso!!!!  \n"
                                        + " database name: "+ConexaoBD_Setup.getConexao());
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
                        String URL = "jdbc:postgresql://"+host+":"+port+"/"+database;
                        Properties properties = new Properties();
                        properties.put("user", user);
                        properties.put("password", password);

                        conexao = DriverManager.getConnection( URL, properties);
                        
                        if ( conexao != null) {
                                JOptionPane.showMessageDialog(null, "Conexão com o banco estabelecida!", "Gotcha!!!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    
                    
                    /*
                          String URL = ConexaoBD_Setup.URL;
                          String user = ConexaoBD_Setup.user;
                          String pass = String.valueOf(  ConexaoBD_Setup.password  );
 
                          conexao = DriverManager.getConnection(URL, user, pass);
                    */
                      
                        
                }catch(SQLException sqlE){
                         JOptionPane.showMessageDialog(null, "Houve um erro de conexão com o banco de dados", "Erro!!!", JOptionPane.ERROR_MESSAGE);
                         sqlE.printStackTrace();
                        
                }finally{
                    
                         return conexao;
                }
                
        }
        
    
        public static void encerrarConexao(Connection con){
                 try{
                        con.close();
                        
                 }catch(SQLException sqlE){
                        JOptionPane.showMessageDialog(null, "Houve um erro ao tentar desconectar com o banco", "Errro!!!", JOptionPane.ERROR_MESSAGE);
                        sqlE.printStackTrace();
                }
        }

        
        /*
        public static Connection getConexao(){
                   return ConexaoBD_Setup.conexao;
        }
*/
    
}
