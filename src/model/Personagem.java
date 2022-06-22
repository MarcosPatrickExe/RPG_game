package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Patrick
 */
public class Personagem {
    
        private int ID;
        private String nome;
        private int nivel;
        private int pontos_magia;
        private int pontos_vida;
        private int velocidade;
        private int ataque_especial;
        private int defesa_especial;
        private int ataque;
        private int defesa;
        private int XP;
        private int evasao;
        private String sprite;
        private int classe_id;

        public Personagem( int ID, String nome, int nivel, int pontos_magia, int pontos_vida, int velocidade, int ataque_especial, int defesa_especial, int ataque, int defesa, int XP, int evasao, String sprite, int classe_id) {
                this.ID = ID;    
                this.nome = nome;
                this.nivel = nivel;
                this.pontos_magia = pontos_magia;
                this.pontos_vida = pontos_vida;
                this.velocidade = velocidade;
                this.ataque_especial = ataque_especial;
                this.defesa_especial = defesa_especial;
                this.ataque = ataque;
                this.defesa = defesa;
                this.XP = XP;
                this.evasao = evasao;
                this.sprite = sprite;
                this.classe_id = classe_id;
        }
        
         public Personagem( ResultSet rs  ) throws SQLException{
                this.ID = rs.getInt("ID");
                this.nome = rs.getString("nome");
                this.nivel = rs.getInt("nivel");
                this.pontos_magia = rs.getInt("pontos_magia");
                this.pontos_vida = rs.getInt("pontos_vida");
                this.velocidade = rs.getInt("velocidade");
                this.ataque_especial = rs.getInt("ataque_especial");
                this.defesa_especial = rs.getInt("defesa_especial");
                this.ataque = rs.getInt("ataque");
                this.defesa = rs.getInt("defesa");
                this.XP = rs.getInt("XP");
                this.evasao = rs.getInt("evasao");
                this.sprite = rs.getString("sprite");
                this.classe_id = rs.getInt("classe_id") ;
         }
        
        
        public int getID() {
            return ID;
        }

        public String getNome() {
            return nome;
        }

        public int getNivel() {
            return nivel;
        }

        public int getPontos_magia() {
            return pontos_magia;
        }

        public int getPontos_vida() {
            return pontos_vida;
        }

        public int getVelocidade() {
            return velocidade;
        }

        public int getAtaque_especial() {
            return ataque_especial;
        }

        public int getDefesa_especial() {
            return defesa_especial;
        }

        public int getAtaque() {
            return ataque;
        }

        public int getDefesa() {
            return defesa;
        }

        public int getXP() {
            return XP;
        }

        public int getEvasao() {
            return evasao;
        }

        public String getSprite() {
            return sprite;
        }

        public int getClasse_id() {
            return classe_id;
        }

        
        public void setID(int ID) {
            this.ID = ID;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setNivel(int nivel) {
            this.nivel = nivel;
        }

        public void setPontos_magia(int pontos_magia) {
            this.pontos_magia = pontos_magia;
        }

        public void setPontos_vida(int pontos_vida) {
            this.pontos_vida = pontos_vida;
        }

        public void setVelocidade(int velocidade) {
            this.velocidade = velocidade;
        }

        public void setAtaque_especial(int ataque_especial) {
            this.ataque_especial = ataque_especial;
        }

        public void setDefesa_especial(int defesa_especial) {
            this.defesa_especial = defesa_especial;
        }

        public void setAtaque(int ataque) {
            this.ataque = ataque;
        }

        public void setDefesa(int defesa) {
            this.defesa = defesa;
        }

        public void setXP(int XP) {
            this.XP = XP;
        }

        public void setEvasao(int evasao) {
            this.evasao = evasao;
        }

        public void setSprite(String sprite) {
            this.sprite = sprite;
        }

        public void setClasse_id(int classe_id) {
            this.classe_id = classe_id;
        }
        
}
