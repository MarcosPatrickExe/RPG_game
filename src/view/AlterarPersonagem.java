/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.DAO_postgreSQL.ClasseDAO;
import DAO.DAO_postgreSQL.PersonagemDAO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Classe;
import model.Personagem;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Patrick
 */
public class AlterarPersonagem extends javax.swing.JFrame {

    /**
     * Creates new form AlterarPersonagem
     */
    private PersonagemDAO personDAO = null;
    
    
    public AlterarPersonagem() {
        initComponents();
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(null);
        
        
        this.btn_salvar_atributos.setVisible(true);
        this.btn_salvar_imagem.setVisible(false);
        
        personDAO = new PersonagemDAO();
        
        
        
//------ INICIALIZANDO COMBO BOX DE CLASSES DOS PERSONAGENS: -------------------
        List<Classe> classes = new ClasseDAO().obter_classes();
        String[] nomesClasses = new String [classes.size()+1];
        int contador = 1;
        nomesClasses[0] = "Selecione";

        for (Classe classe : classes){
            nomesClasses[contador] = classe.getNome();
            contador++;
        }

        this.combo_classe.setModel( new DefaultComboBoxModel( nomesClasses ));
        
       

//------ INICIALIZANDO COMBO BOX DE NOMES DOS PERSONAGENS: -------------------
        List<Personagem> persons = personDAO.obter_personagens();
        String[] nomes = new String [persons.size()+1];
        contador = 1;
        nomes[0] = "Selecione";

        for (Personagem personagem : persons){
            nomes[contador] = personagem.getNome();
            contador++;
        }

        this.combo_nomes_personagens.setModel( new DefaultComboBoxModel( nomes ));
        
        
        
   // ADICIONANDO EVENTO DE MUDANÇA DE NOME DE PERSONAGEM DO COMBO BOX:
        this.combo_nomes_personagens.addItemListener( new ItemListener(){
            
                @Override
                public void itemStateChanged(ItemEvent e) {
                    
                    String nomePersonagemSelecionado = ((JComboBox) e.getSource())// getSource() retorna um "Object", convertendo para "JComboBox"
                                                                       .getSelectedItem()// pode-se utilizar o metodo "getSelectedItem()" 
                                                                               .toString();// e emendar com "toString()"
                        
                    if( tabbed_pane.getSelectedIndex()==0 && nomePersonagemSelecionado != "Selecione" ){
                        // COMO O NOME DO PERSONAGEM VEM DO BANCO DE DADOS, 
                        //NAO PRECISA VALIDAR SE ELE EXISTE OU NAO NO BANCO
                        exibirDadosPersonagem( 
                                personDAO.obter_personagem_por_nome( nomePersonagemSelecionado ) 
                        );
                        
                    }//else if( tabbed_pane.getSelectedIndex()==1 ){
                     //   exibirImagemPersonagem();
                   // }
                    
                    
                }//FIM DO MÉTODO "itemStateChanged()"
        });
        
        
        // ADICIONANDO EVENTO NO JTABBED PANE
        this.tabbed_pane.addChangeListener( new ChangeListener(){
            
                @Override
                public void stateChanged(ChangeEvent e) {
                        JTabbedPane plano = (JTabbedPane) e.getSource();

                        if( plano.getSelectedIndex()==0 )
                               alternarBotoes( true );
                                         // O "THIS" FAZ REFERENCIA A CLASSE ANONIMA "ChangeListener"
                        else if( plano.getSelectedIndex()==1 )
                               alternarBotoes( false );
                }
        });
    }
    
    
    
    
    private void exibirDadosPersonagem( Personagem person ){
        
               this.txt_nome.setText( person.getNome());
               this.txt_level.setText( String.valueOf( person.getNivel() ));
               this.spn_HP_max.setValue( person.getPontos_vida());
               this.spn_MP_max.setValue( person.getPontos_magia());
               this.txt_velocidade.setText( String.valueOf( person.getVelocidade() ) );
               this.txt_XP.setText( String.valueOf(person.getXP()) );
               this.txt_evasao.setText( String.valueOf(person.getEvasao()) );
               this.txt_atk.setText( String.valueOf(person.getAtaque()) );
               this.txt_def.setText( String.valueOf( person.getDefesa()) );
               this.txt_sp_atk.setText( String.valueOf( person.getAtaque_especial()) );
               this.txt_sp_def.setText( String.valueOf(person.getDefesa_especial()) );
               this.txt_destreza.setText( String.valueOf(person.getDestreza()) );
               this.txt_forca.setText( String.valueOf( person.getForca() ));
               this.spn_HP_atual.setValue( person.getHP_atual() );
               this.spn_MP_atual.setValue( person.getMP_atual() );
               this.combo_classe.setSelectedIndex( person.getClasse_id());// +1 POIS O PRIMEIRO ITEM É "Selecione"
               
    }
    
    
    private void alternarBotoes( boolean aparecer){
            this.btn_salvar_atributos.setVisible( aparecer);
            this.btn_salvar_imagem.setVisible( !aparecer);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        combo_nomes_personagens = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        tabbed_pane = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        pnl_fundo_atributos = new javax.swing.JPanel();
        lab_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        lab_level = new javax.swing.JLabel();
        txt_level = new javax.swing.JTextField();
        lab_HP_max = new javax.swing.JLabel();
        lab_MP_max = new javax.swing.JLabel();
        lab_XP = new javax.swing.JLabel();
        lab_velocidade = new javax.swing.JLabel();
        lab_evasao = new javax.swing.JLabel();
        lab_forca = new javax.swing.JLabel();
        lab_destreza = new javax.swing.JLabel();
        lab_classe = new javax.swing.JLabel();
        combo_classe = new javax.swing.JComboBox<>();
        txt_evasao = new javax.swing.JTextField();
        txt_forca = new javax.swing.JTextField();
        txt_destreza = new javax.swing.JTextField();
        txt_velocidade = new javax.swing.JTextField();
        lab_atk = new javax.swing.JLabel();
        lab_def = new javax.swing.JLabel();
        lab_sp_def = new javax.swing.JLabel();
        lab_sp_atk = new javax.swing.JLabel();
        txt_atk = new javax.swing.JTextField();
        txt_sp_atk = new javax.swing.JTextField();
        txt_def = new javax.swing.JTextField();
        txt_sp_def = new javax.swing.JTextField();
        spn_HP_max = new javax.swing.JSpinner();
        spn_MP_max = new javax.swing.JSpinner();
        txt_XP = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lab_HP_atual = new javax.swing.JLabel();
        lab_MP_atual = new javax.swing.JLabel();
        spn_HP_atual = new javax.swing.JSpinner();
        spn_MP_atual = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        pnl_fundo_imagem_atual = new javax.swing.JPanel();
        pnl_fundo_nova_imagem = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_salvar_atributos = new javax.swing.JButton();
        btn_cancelar_voltar = new javax.swing.JButton();
        btn_salvar_imagem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(30, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(204, 102, 0), new java.awt.Color(204, 102, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 55)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Alterar dados do Personagem");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 2, -1, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        jPanel8.setBackground(new java.awt.Color(23, 0, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Selecione um personagem:");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, 40));

        combo_nomes_personagens.setBackground(new java.awt.Color(102, 102, 102));
        combo_nomes_personagens.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        combo_nomes_personagens.setForeground(new java.awt.Color(255, 255, 255));
        combo_nomes_personagens.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(combo_nomes_personagens, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 17, 260, 30));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("selecione um personagem:");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 310, 80));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 520, 60));

        tabbed_pane.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_fundo_atributos.setBackground(new java.awt.Color(23, 0, 0));
        pnl_fundo_atributos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        pnl_fundo_atributos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_nome.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_nome.setForeground(new java.awt.Color(204, 204, 204));
        lab_nome.setText("Nome:");
        pnl_fundo_atributos.add(lab_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 50));

        txt_nome.setBackground(new java.awt.Color(102, 102, 102));
        txt_nome.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_nome.setForeground(new java.awt.Color(255, 255, 255));
        txt_nome.setBorder(null);
        txt_nome.setMargin(new java.awt.Insets(5, 10, 5, 5));
        pnl_fundo_atributos.add(txt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 85, 160, 25));

        lab_level.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_level.setForeground(new java.awt.Color(204, 204, 204));
        lab_level.setText("Level:");
        pnl_fundo_atributos.add(lab_level, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 60, 50));

        txt_level.setBackground(new java.awt.Color(102, 102, 102));
        txt_level.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_level.setForeground(new java.awt.Color(255, 255, 255));
        txt_level.setBorder(null);
        pnl_fundo_atributos.add(txt_level, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 100, 30));

        lab_HP_max.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_HP_max.setForeground(new java.awt.Color(204, 204, 204));
        lab_HP_max.setText("HP Máx.:");
        pnl_fundo_atributos.add(lab_HP_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 50));

        lab_MP_max.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_MP_max.setForeground(new java.awt.Color(204, 204, 204));
        lab_MP_max.setText("MP Máx.:");
        pnl_fundo_atributos.add(lab_MP_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 110, 50));

        lab_XP.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_XP.setForeground(new java.awt.Color(204, 204, 204));
        lab_XP.setText("XP:");
        pnl_fundo_atributos.add(lab_XP, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 50, 50));

        lab_velocidade.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_velocidade.setForeground(new java.awt.Color(204, 204, 204));
        lab_velocidade.setText("Velocidade:");
        pnl_fundo_atributos.add(lab_velocidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 120, 50));

        lab_evasao.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_evasao.setForeground(new java.awt.Color(204, 204, 204));
        lab_evasao.setText("Evasão:");
        pnl_fundo_atributos.add(lab_evasao, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 100, 50));

        lab_forca.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_forca.setForeground(new java.awt.Color(204, 204, 204));
        lab_forca.setText("Força:");
        pnl_fundo_atributos.add(lab_forca, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 80, 60));

        lab_destreza.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_destreza.setForeground(new java.awt.Color(204, 204, 204));
        lab_destreza.setText("Destreza:");
        pnl_fundo_atributos.add(lab_destreza, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 100, 50));

        lab_classe.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_classe.setForeground(new java.awt.Color(204, 204, 204));
        lab_classe.setText("Classe:");
        pnl_fundo_atributos.add(lab_classe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 80, 50));

        combo_classe.setBackground(new java.awt.Color(102, 102, 102));
        combo_classe.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        combo_classe.setForeground(new java.awt.Color(255, 255, 255));
        pnl_fundo_atributos.add(combo_classe, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 144, 160, 30));

        txt_evasao.setBackground(new java.awt.Color(102, 102, 102));
        txt_evasao.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_evasao.setForeground(new java.awt.Color(255, 255, 255));
        txt_evasao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_evasao, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 60, 30));

        txt_forca.setBackground(new java.awt.Color(102, 102, 102));
        txt_forca.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_forca.setForeground(new java.awt.Color(255, 255, 255));
        txt_forca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_forca, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 60, 30));

        txt_destreza.setBackground(new java.awt.Color(102, 102, 102));
        txt_destreza.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_destreza.setForeground(new java.awt.Color(255, 255, 255));
        txt_destreza.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_destreza, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 60, 30));

        txt_velocidade.setBackground(new java.awt.Color(102, 102, 102));
        txt_velocidade.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_velocidade.setForeground(new java.awt.Color(255, 255, 255));
        txt_velocidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_velocidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 60, 30));

        lab_atk.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_atk.setForeground(new java.awt.Color(204, 204, 204));
        lab_atk.setText("ATK:");
        pnl_fundo_atributos.add(lab_atk, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, 50));

        lab_def.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_def.setForeground(new java.awt.Color(204, 204, 204));
        lab_def.setText("DEF:");
        pnl_fundo_atributos.add(lab_def, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, -1, 50));

        lab_sp_def.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_sp_def.setForeground(new java.awt.Color(204, 204, 204));
        lab_sp_def.setText("SP. DEF:");
        pnl_fundo_atributos.add(lab_sp_def, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, -1, 50));

        lab_sp_atk.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_sp_atk.setForeground(new java.awt.Color(204, 204, 204));
        lab_sp_atk.setText("SP. ATK:");
        pnl_fundo_atributos.add(lab_sp_atk, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, -1, 50));

        txt_atk.setBackground(new java.awt.Color(102, 102, 102));
        txt_atk.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_atk.setForeground(new java.awt.Color(255, 255, 255));
        txt_atk.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_atk, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 70, 30));

        txt_sp_atk.setBackground(new java.awt.Color(102, 102, 102));
        txt_sp_atk.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_sp_atk.setForeground(new java.awt.Color(255, 255, 255));
        txt_sp_atk.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_sp_atk, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 70, 30));

        txt_def.setBackground(new java.awt.Color(102, 102, 102));
        txt_def.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_def.setForeground(new java.awt.Color(255, 255, 255));
        txt_def.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_def, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, 70, 30));

        txt_sp_def.setBackground(new java.awt.Color(102, 102, 102));
        txt_sp_def.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_sp_def.setForeground(new java.awt.Color(255, 255, 255));
        txt_sp_def.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_sp_def, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, 70, 30));

        spn_HP_max.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pnl_fundo_atributos.add(spn_HP_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 90, 30));

        spn_MP_max.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pnl_fundo_atributos.add(spn_MP_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 90, 30));

        txt_XP.setBackground(new java.awt.Color(102, 102, 102));
        txt_XP.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_XP.setForeground(new java.awt.Color(255, 255, 255));
        pnl_fundo_atributos.add(txt_XP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 120, 30));

        jPanel7.setBackground(new java.awt.Color(49, 60, 81));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Selecione um nome de personagem acima (à direita) e altere os valores de seus atributos");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pnl_fundo_atributos.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        lab_HP_atual.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_HP_atual.setForeground(new java.awt.Color(204, 204, 204));
        lab_HP_atual.setText("HP atual:");
        pnl_fundo_atributos.add(lab_HP_atual, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, 70));

        lab_MP_atual.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_MP_atual.setForeground(new java.awt.Color(204, 204, 204));
        lab_MP_atual.setText("MP atual:");
        pnl_fundo_atributos.add(lab_MP_atual, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        spn_HP_atual.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pnl_fundo_atributos.add(spn_HP_atual, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 90, 30));

        spn_MP_atual.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pnl_fundo_atributos.add(spn_MP_atual, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 90, 30));

        jPanel5.add(pnl_fundo_atributos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 340));

        tabbed_pane.addTab("Alterar atributos", jPanel5);

        jPanel1.setBackground(new java.awt.Color(30, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_fundo_imagem_atual.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pnl_fundo_imagem_atualLayout = new javax.swing.GroupLayout(pnl_fundo_imagem_atual);
        pnl_fundo_imagem_atual.setLayout(pnl_fundo_imagem_atualLayout);
        pnl_fundo_imagem_atualLayout.setHorizontalGroup(
            pnl_fundo_imagem_atualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        pnl_fundo_imagem_atualLayout.setVerticalGroup(
            pnl_fundo_imagem_atualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        jPanel1.add(pnl_fundo_imagem_atual, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 240, 240));

        pnl_fundo_nova_imagem.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pnl_fundo_nova_imagemLayout = new javax.swing.GroupLayout(pnl_fundo_nova_imagem);
        pnl_fundo_nova_imagem.setLayout(pnl_fundo_nova_imagemLayout);
        pnl_fundo_nova_imagemLayout.setHorizontalGroup(
            pnl_fundo_nova_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        pnl_fundo_nova_imagemLayout.setVerticalGroup(
            pnl_fundo_nova_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        jPanel1.add(pnl_fundo_nova_imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 240, 240));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Inserir nova imagem");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 280, 210, 40));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Imagem atual");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        tabbed_pane.addTab("Alterar imagem", jPanel1);

        getContentPane().add(tabbed_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        btn_salvar_atributos.setBackground(new java.awt.Color(51, 51, 51));
        btn_salvar_atributos.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btn_salvar_atributos.setForeground(new java.awt.Color(255, 255, 255));
        btn_salvar_atributos.setText("salvar atributos");
        btn_salvar_atributos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salvar_atributos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salvar_atributos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar_atributosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salvar_atributos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 220, 40));

        btn_cancelar_voltar.setBackground(new java.awt.Color(51, 51, 51));
        btn_cancelar_voltar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btn_cancelar_voltar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar_voltar.setText("cancelar e voltar");
        btn_cancelar_voltar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 540, 220, 40));

        btn_salvar_imagem.setBackground(new java.awt.Color(51, 51, 51));
        btn_salvar_imagem.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btn_salvar_imagem.setForeground(new java.awt.Color(204, 204, 204));
        btn_salvar_imagem.setText("salvar imagem");
        btn_salvar_imagem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salvar_imagem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salvar_imagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar_imagemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salvar_imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 220, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background game.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    protected static boolean validarCampos(String hp, String mp, String xp, String nome, String level, JComboBox classes){
            boolean nehumErroEncontrado = true;

            if( Integer.parseInt(hp)>999 ){
                JOptionPane.showMessageDialog(null, "O campo 'HP máximo' suporta valores de até 999 pontos!!!", "Error!!!", JOptionPane.ERROR_MESSAGE);
                nehumErroEncontrado = false;

            }else if( Integer.parseInt(hp)<0){
                JOptionPane.showMessageDialog(null, "O campo 'HP máximo'não suporta valores negativos !!!", "Error!!!", JOptionPane.ERROR_MESSAGE);
                nehumErroEncontrado = false;

            }else if( Integer.parseInt(mp)>500 ){
                JOptionPane.showMessageDialog(null, "O campo 'MP máximo' suporta valores de até 500 pontos!!!", "Error!!!", JOptionPane.ERROR_MESSAGE);
                nehumErroEncontrado = false;

            }else if( Integer.parseInt(mp)<0){
                JOptionPane.showMessageDialog(null, "O campo 'MP máximo'não suporta valores negativos !!!", "Error!!!", JOptionPane.ERROR_MESSAGE);
                nehumErroEncontrado = false;
                
            }else if( nome.equals("") ){
                JOptionPane.showMessageDialog(null, "O campo 'Nome' não pode estar vazio!", "Error!!!", JOptionPane.ERROR_MESSAGE);
                nehumErroEncontrado = false;

            }else if( Integer.parseInt(level)>99){
                JOptionPane.showMessageDialog(null, "O campo 'Level' não suporta valores acima de 99 !!!", "Error!!!", JOptionPane.ERROR_MESSAGE);
                nehumErroEncontrado = false;
                
            }else if( classes.getSelectedIndex() == 0 ){
                JOptionPane.showMessageDialog(null, "Por favor selecione uma classe para o personagem!!!", "Error!!!", JOptionPane.ERROR_MESSAGE);    
                nehumErroEncontrado = false;
            }
            
            return nehumErroEncontrado;
    }
    
    
    
    
    private void btn_salvar_atributosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvar_atributosActionPerformed

        String hp_max = this.spn_HP_max.getValue().toString();
        String mp_max = this.spn_MP_max.getValue().toString();
        String xp = this.txt_XP.getText();
        String nome = this.txt_nome.getText();
        String level = this.txt_level.getText();
        
        
        if( AlterarPersonagem.validarCampos(hp_max, mp_max, xp, nome, level, combo_classe)){
   
                
                //================================================================================================================
                ClasseDAO clasDAO = new ClasseDAO();
                
                // OBTENDO O ID DA CLASSE SELECIONADA:
                int id_classe_selecionada = clasDAO.obter_id_classe_por_nome(
                           this.combo_classe.getSelectedItem().toString()
                );

                
                String nomePersonagemSelecionado = this.combo_nomes_personagens.getSelectedItem().toString();
                int idPersonagemSelecionado = this.personDAO.obter_personagem_por_nome( nomePersonagemSelecionado ).getID();
               
                
//=================================== ATUALIZAÇÃO DO PERSONAGEM =============================================================================

                Personagem personagemAlterado = new Personagem(
                        idPersonagemSelecionado,
                        this.txt_nome.getText(),
                        Integer.parseInt( this.txt_level.getText()),
                        Integer.parseInt( this.spn_HP_max.getValue().toString() ),
                        Integer.parseInt( this.spn_MP_max.getValue().toString() ),
                        Integer.parseInt( this.txt_velocidade.getText()),
                        Integer.parseInt( this.txt_XP.getText()),
                        Integer.parseInt( this.txt_evasao.getText()),
                        Integer.parseInt( this.txt_atk.getText()),
                        Integer.parseInt( this.txt_def.getText()),
                        Integer.parseInt( this.txt_sp_atk.getText()),
                        Integer.parseInt( this.txt_sp_def.getText()),
                        id_classe_selecionada,
                        null,
                        Integer.parseInt( this.txt_destreza.getText()),
                        Integer.parseInt( this.txt_forca.getText()),
                        Integer.parseInt( this.spn_HP_atual.getValue().toString() ),
                        Integer.parseInt( this.spn_MP_atual.getValue().toString() )
                );
                
                
                if( this.personDAO.atualizar_personagem_atributos(personagemAlterado) )
                     JOptionPane.showMessageDialog(null, "O personagem "+this.txt_nome+" foi alterado com sucesso!!", "Sucesso!!", JOptionPane.INFORMATION_MESSAGE);
                else
                     JOptionPane.showMessageDialog(null, "Não foi possível realizar a alteração do personagem. \n Verifique a conexão com o banco de dados!!!", "Error!!!", JOptionPane.ERROR_MESSAGE);    
        }
    }//GEN-LAST:event_btn_salvar_atributosActionPerformed

    
    
    private void btn_cancelar_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_voltarActionPerformed
            this.dispose();
    }//GEN-LAST:event_btn_cancelar_voltarActionPerformed

    private void btn_salvar_imagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvar_imagemActionPerformed
        
                //======================= ENCRIPTANDO IMAGEM PARA ARMAZENAMENTO NO BANCO DE DADOS ===========================================================================
                String spriteEncoded;
            
            
                //  =VERIFICANDO SE ALGUMA IMAGEM FOI INSERIDA PARA ATUALIZAÇÃO DA IMAGEM DO PERSONAGEM
    /*            if( (this.pnl_fundo_nova_imagem.getComponents().length !=0)
                    && (this.pnl_fundo_nova_imagem != null)  ){


                    // REALIZANDO A CONVERSAO DA IMAGEM PARA BYTES E DEPOIS ENCRIPTANDO ELA
                    try{
                        byte[] imagemBytes = FileUtils.readFileToByteArray( this.imagemPerfilPersonagem );

                        String base64ImageFormat = Base64.getEncoder().encodeToString( imagemBytes);

                        spriteEncoded = base64ImageFormat;

                    }catch(IOException ioe){ ioe.printStackTrace(); }
                }
                */

    }//GEN-LAST:event_btn_salvar_imagemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlterarPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarPersonagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar_voltar;
    private javax.swing.JButton btn_salvar_atributos;
    private javax.swing.JButton btn_salvar_imagem;
    private javax.swing.JComboBox<String> combo_classe;
    private javax.swing.JComboBox<String> combo_nomes_personagens;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lab_HP_atual;
    private javax.swing.JLabel lab_HP_max;
    private javax.swing.JLabel lab_MP_atual;
    private javax.swing.JLabel lab_MP_max;
    private javax.swing.JLabel lab_XP;
    private javax.swing.JLabel lab_atk;
    private javax.swing.JLabel lab_classe;
    private javax.swing.JLabel lab_def;
    private javax.swing.JLabel lab_destreza;
    private javax.swing.JLabel lab_evasao;
    private javax.swing.JLabel lab_forca;
    private javax.swing.JLabel lab_level;
    private javax.swing.JLabel lab_nome;
    private javax.swing.JLabel lab_sp_atk;
    private javax.swing.JLabel lab_sp_def;
    private javax.swing.JLabel lab_velocidade;
    private javax.swing.JPanel pnl_fundo_atributos;
    private javax.swing.JPanel pnl_fundo_imagem_atual;
    private javax.swing.JPanel pnl_fundo_nova_imagem;
    private javax.swing.JSpinner spn_HP_atual;
    private javax.swing.JSpinner spn_HP_max;
    private javax.swing.JSpinner spn_MP_atual;
    private javax.swing.JSpinner spn_MP_max;
    private javax.swing.JTabbedPane tabbed_pane;
    private javax.swing.JTextField txt_XP;
    private javax.swing.JTextField txt_atk;
    private javax.swing.JTextField txt_def;
    private javax.swing.JTextField txt_destreza;
    private javax.swing.JTextField txt_evasao;
    private javax.swing.JTextField txt_forca;
    private javax.swing.JTextField txt_level;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_sp_atk;
    private javax.swing.JTextField txt_sp_def;
    private javax.swing.JTextField txt_velocidade;
    // End of variables declaration//GEN-END:variables
}
