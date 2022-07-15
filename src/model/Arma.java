package model;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Patrick
 */
public class Arma {
    
    private int ID;
    private String nome;
    private int dano;
    private String tipo; // corpo-a-corpo OU longo-alcance
    private String descricao;
    private float preco;
    private String imagem;
    
    
    public Arma(int ID, String nome, int dano, String tipo, String descricao, float preco, String imagem) {
            this.ID = ID;
            this.nome = nome;
            this.dano = dano;
            this.tipo = tipo;
            this.descricao = descricao;
            this.preco = preco;
            this.imagem = imagem;
    }

    
     public Arma ( ResultSet arma) throws SQLException{
         
            this.ID = arma.getInt(1);
            this.nome = arma.getString(2);
            this.dano = arma.getInt(3);
            this.tipo = arma.getString(4);
            this.descricao = arma.getString(5);
            this.preco = arma.getFloat(6);
            this.imagem = arma.getString(7);
    }
    
    
    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPreco() {
        return preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    
    
    
}
