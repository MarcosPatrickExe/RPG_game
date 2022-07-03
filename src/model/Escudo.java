
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Patrick
 */
public class Escudo {
    
    
    private int ID;
    private String nome;
    private int resistencia;
    private String tipo;
    private String descricao;
    private float preco;
    private byte[] imagem;

    
    public Escudo(int ID, String nome, int resistencia, String tipo, String descricao, float preco, byte[] imagem) {
            this.ID = ID;
            this.nome = nome;
            this.resistencia = resistencia;
            this.tipo = tipo;
            this.descricao = descricao;
            this.preco = preco;
            this.imagem = imagem;
    }
    
    
    public Escudo( ResultSet escudo) throws SQLException{
         
            this.ID = escudo.getInt(1);
            this.nome = escudo.getString(2);
            this.resistencia = escudo.getInt(3);
            this.tipo = escudo.getString(4);
            this.descricao = escudo.getString(5);
            this.preco = escudo.getFloat(6);
            this.imagem = escudo.getBytes(7);
        
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public int getResistencia() {
        return resistencia;
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

    public byte[] getImagem() {
        return imagem;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
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

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    
    
    
    
    
}
