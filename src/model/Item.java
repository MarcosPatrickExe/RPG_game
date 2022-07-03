package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Patrick
 * 
 */

public class Item {
    
    private int ID;
    private String nome;
    private float preco;
    private String descricao;
    private byte[] imagem;

    
    public Item(int ID, String nome, float preco, String descricao, byte[] imagem) {
          this.ID = ID;
          this.nome = nome;
          this.preco = preco;
          this.descricao = descricao;
          this.imagem = imagem;
    }

    
     public Item( ResultSet item) throws SQLException{
         
          this.ID = item.getInt("ID");
          this.nome = item.getString("nome");
          this.preco = item.getFloat("preco");
          this.descricao = item.getString("descricao");
          this.imagem = item.getBytes("imagem");
    }
    
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
   
    
}
