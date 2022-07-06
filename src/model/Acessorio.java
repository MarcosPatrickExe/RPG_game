package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Patrick
 * 
 * 
 */

public class Acessorio {
    
    private int ID;
    private String nome;
    private String descricao;
    private float preco;
    private String imagem;

    public Acessorio(int ID, String nome, String descricao, float preco, String imagem) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
    }
    
    public Acessorio( ResultSet acessorios ) throws SQLException{
        this.ID = acessorios.getInt("ID");
        this.nome = acessorios.getString("nome");
        this.descricao = acessorios.getString("descricao");
        this.preco = acessorios.getFloat("preco");
        this.imagem = acessorios.getString("imagem");
    }
    

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
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
