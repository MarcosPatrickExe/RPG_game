package rpg_game;
import rpg_game.ConexaoBD;

 /* @author Patrick
 */
public class RPGame {

    public static void main(String[] args) {
             new ConexaoBD().abrirConexao();
    }
    
}


// convert byte[] array to imageIcon:
// https://stackoverflow.com/questions/7119472/convert-byte-array-byte-to-image-in-java#:~:text=To%20convert%20an%20array%20of%20bytes%2C%20i.e.%20byte,in%20the%20method%20below%2C%20particularly%20the%20last%20line%3A

// query database with PreparedStatement:
// https://www.postgresql.org/docs/7.4/jdbc-binary-data.html

// conexao com o banco:
// https://www.codejava.net/java-se/jdbc/connect-to-postgresql-database-server-via-jdbc

// conexao v2 com o banco:
// https://dzone.com/articles/how-to-connect-postgresql-with-java-application#:~:text=%20How%20to%20Connect%20PostgreSQL%20With%20Java%20Application,in%20our%20case%29%20to%20access%20the...%20More%20