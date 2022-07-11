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
        private int pontos_vida;
        private int pontos_magia;
        private int velocidade;
        private int XP;
        private int evasao;
        private int ataque;
        private int defesa;
        private int ataque_especial;
        private int defesa_especial;
        private int classe_id;
        private String sprite;
        private int destreza;
        private int forca;
        private int HP_atual;
        private int MP_atual;

        public Personagem ( 
              int ID, 
                 String nome, 
                   int nivel, 
                     int pontos_vida, 
                       int pontos_magia, 
                         int velocidade, 
                           int XP, 
                             int evasao, 
                               int ataque, 
                                 int defesa, 
                                   int ataque_especial, 
                                     int defesa_especial, 
                                       int classe_id, 
                                         String sprite, 
                                           int destreza, 
                                             int forca, 
                                               int HP_atual, 
                                                 int MP_atual) {
                
            
               // this.ID = ID;
                this.nome = nome;
                this.nivel = nivel;
                this.pontos_vida = pontos_vida;
                this.pontos_magia = pontos_magia;
                this.velocidade = velocidade;
                this.XP = XP;
                this.evasao = evasao;
                this.ataque = ataque;
                this.defesa = defesa;
                this.ataque_especial = ataque_especial;
                this.defesa_especial = defesa_especial;
                this.classe_id = classe_id;
                this.sprite = sprite;
                this.destreza = destreza;
                this.forca = forca;
                this.HP_atual = HP_atual;
                this.MP_atual = MP_atual;
                
        }
        
        
        
        public Personagem ( ResultSet rs ) throws SQLException{
                this.ID = rs.getInt("ID");
                this.nome = rs.getString("nome");
                this.nivel = rs.getInt("nivel");
                this.pontos_vida = rs.getInt("HP_maximo");
                this.pontos_magia = rs.getInt("MP_maximo");
                this.velocidade = rs.getInt("velocidade");
                this.XP = rs.getInt("XP");
                this.evasao = rs.getInt("evasao");
                this.ataque = rs.getInt("ataque");
                this.defesa = rs.getInt("defesa");
                this.ataque_especial = rs.getInt("ataque_especial");
                this.defesa_especial = rs.getInt("defesa_especial");
                this.classe_id = rs.getInt("classe_id") ;
                this.sprite = rs.getString("sprite");
                this.destreza = rs.getInt("destreza");
                this.forca = rs.getInt("forca");
                this.HP_atual = rs.getInt("HP_atual");
                this.MP_atual = rs.getInt("MP_atual");
         }
         
        //--------------------------------- GETTERS -----------------------------------

        public int getID() {
            return ID;
        }

        public String getNome() {
            return nome;
        }

        public int getNivel() {
            return nivel;
        }

        public int getPontos_vida() {
            return pontos_vida;
        }

        public int getPontos_magia() {
            return pontos_magia;
        }

        public int getVelocidade() {
            return velocidade;
        }

        public int getXP() {
            return XP;
        }

        public int getEvasao() {
            return evasao;
        }

        public int getAtaque() {
            return ataque;
        }

        public int getDefesa() {
            return defesa;
        }

        public int getAtaque_especial() {
            return ataque_especial;
        }

        public int getDefesa_especial() {
            return defesa_especial;
        }

        public int getClasse_id() {
            return classe_id;
        }

        public String getSprite() {
            return sprite;
        }

        public int getDestreza() {
            return destreza;
        }

        public int getForca() {
            return forca;
        }

        public int getHP_atual() {
            return HP_atual;
        }

        public int getMP_atual() {
            return MP_atual;
        }

        
        //--------------------------------- SETTERS -------------------------------------
        public void setID(int ID) {
            this.ID = ID;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setNivel(int nivel) {
            this.nivel = nivel;
        }

        public void setPontos_vida(int pontos_vida) {
            this.pontos_vida = pontos_vida;
        }

        public void setPontos_magia(int pontos_magia) {
            this.pontos_magia = pontos_magia;
        }

        public void setVelocidade(int velocidade) {
            this.velocidade = velocidade;
        }

        public void setXP(int XP) {
            this.XP = XP;
        }

        public void setEvasao(int evasao) {
            this.evasao = evasao;
        }

        public void setAtaque(int ataque) {
            this.ataque = ataque;
        }

        public void setDefesa(int defesa) {
            this.defesa = defesa;
        }

        public void setAtaque_especial(int ataque_especial) {
            this.ataque_especial = ataque_especial;
        }

        public void setDefesa_especial(int defesa_especial) {
            this.defesa_especial = defesa_especial;
        }

        public void setClasse_id(int classe_id) {
            this.classe_id = classe_id;
        }

        public void setSprite( String sprite) {
            this.sprite = sprite;
        }

        public void setDestreza(int destreza) {
            this.destreza = destreza;
        }

        public void setForca(int forca) {
            this.forca = forca;
        }

        public void setHP_atual(int HP_atual) {
            this.HP_atual = HP_atual;
        }

        public void setMP_atual(int MP_atual) {
            this.MP_atual = MP_atual;
        }
        
            
        
}
