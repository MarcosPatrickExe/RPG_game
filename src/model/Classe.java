package model;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Patrick
 * 
 */

public class Classe {
    
    private int ID;
    private String nome;
    private float dinheiro;
    private int habilidade_id;

    public Classe(int ID, String nome, float dinheiro, int habilidade_id) {
        this.ID = ID;
        this.nome = nome;
        this.dinheiro = dinheiro;
        this.habilidade_id = habilidade_id;
    }

    public Classe( ResultSet rs) throws SQLException{
        this.ID = rs.getInt("ID");
        this.nome = rs.getString("nome");
        this.dinheiro = rs.getFloat("dinheiro");
        this.habilidade_id = rs.getInt("habilidade_id");
    }
    
    
    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public float getDinheiro() {
        return dinheiro;
    }

    public int getHabilidade_id() {
        return habilidade_id;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public void setHabilidade_id(int habilidade_id) {
        this.habilidade_id = habilidade_id;
    }
    
    
}
