package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Patrick
 * 
 */
public class Tecnica {
    
      private int ID;
      private String nome;
      private int custo_mana;
      private int dano;
      private String tipo; // nome do elemento que a tecnica pertence
      private String descricao;
      private String precisao; // chance (em %) da tecnica ser efetuada 

      
      public Tecnica( int ID, String nome, int custo_mana, int dano, String tipo, String descricao, String precisao) {
            this.ID = ID;
            this.nome = nome;
            this.custo_mana = custo_mana;
            this.dano = dano;
            this.tipo = tipo;
            this.descricao = descricao;
            this.precisao = precisao;
      }
      
      
      public Tecnica( ResultSet tecnica ) throws SQLException{
            this.ID = tecnica.getInt("ID");
            this.nome = tecnica.getString("nome");
            this.custo_mana = tecnica.getInt("custo_mana");
            this.dano = tecnica.getInt("dano");
            this.tipo = tecnica.getString("tipo");
            this.descricao = tecnica.getString("descricao");
            this.precisao = tecnica.getString("precisao");
      }

      public int getID() {
            return ID;
      }

      public String getNome() {
            return nome;
      }

      public int getCusto_mana() {
            return custo_mana;
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

      public String getPrecisao() {
            return precisao;
      }

      public void setID(int ID) {
            this.ID = ID;
      }

      public void setNome(String nome) {
            this.nome = nome;
      }

      public void setCusto_mana(int custo_mana) {
            this.custo_mana = custo_mana;
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

      public void setPrecisao(String precisao) {
            this.precisao = precisao;
      }

      
}
