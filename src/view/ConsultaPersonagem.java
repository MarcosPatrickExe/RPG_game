package view;

import DAO.DAO_postgreSQL.PersonagemDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Personagem;
import org.apache.commons.io.FileUtils;

/**
 * @author Patrick
 * 
 */
public class ConsultaPersonagem extends javax.swing.JFrame {

    private static final Icon hand_icon = new ImageIcon("https://github.com/MarcosPatrickExe/images-for-all-repositories/blob/main/rpg_game/icon_hand.png?raw=true");                    
    private static final Color corBotaoSelecionado = new Color(204,0,51); // vermelho claro
    private static final Color corBotaoNaoSelecionado = new Color(22,0,0);  // vermelho escuro
    
    private static final Color letraSemFocus = new Color(187, 187, 187);
    private static final Color letraComFocus = new Color(255, 255, 255);
    private static final Color hpBar = new Color(102,204,0);
    private static final Color mpBar = new Color(0,153,255);
    private static final Color xpBar = new Color(255,102,0);
    
    private String nomeColuna;
    private PersonagemDAO person = null;
    private JLabel imagemLabel = null;
    private JLabel imagemInexistente = new JLabel();
    /**
     * Creates new form Consulta_Personagem
     */
    
    
    public ConsultaPersonagem() {
        initComponents();
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(null);
        
        this.pnl_fundo_equipamento.setVisible(false);
        this.list_equipamentos.setVisible(false);
        this.txtarea_descricao.setVisible(false);
        this.pnl_fundo_atributos_equip.setVisible(false);
        
        
        this.person = new PersonagemDAO();
        this.imagemLabel = new JLabel();

        nomeColuna = "*";
        exibirCampoValorBusca(false);// OCULTANDO CAMPO DE TEXTO/VALOR
        //this.list_personagens.setEnabled(false);
        
        this.combo_pesquisar_por.addItemListener( new SelecaoAlterada() ); // O 'THIS' AQUI DENTRO APONTA PARA A CLASSE PRIVADA 'SelecaoAlterada'
        this.list_personagens.addListSelectionListener( new SelecaoItemLista() );
        
      //  System.out.println("hand_icon: "+ConsultaPersonagem.hand_icon.toString());
       
        this.progress_HP.setForeground( ConsultaPersonagem.hpBar );
        this.progress_MP.setForeground( ConsultaPersonagem.mpBar );
        this.progress_XP.setForeground( ConsultaPersonagem.xpBar );
      
      //  this.txtarea_descricao.setBackground( corBotaoNaoSelecionado);
      
        //this.imagemInexistente.setText("");
        
      
        this.btn_armas.setForeground( letraSemFocus );
        this.btn_escudos.setForeground( letraSemFocus );
        this.btn_acessorios.setForeground( letraSemFocus );
        this.btn_itens.setForeground( letraSemFocus );
               
        
        List<JButton> botoesEquipamento = new ArrayList<JButton>();
        botoesEquipamento.add( this.btn_armas );
        botoesEquipamento.add( this.btn_escudos );
        botoesEquipamento.add( this.btn_acessorios);
        botoesEquipamento.add( this.btn_itens);
        
        
        for(JButton but : botoesEquipamento){
            
            but.addMouseListener(
                 new java.awt.event.MouseAdapter() {
                            
                    @Override
                    public void mouseEntered(MouseEvent e) {
                           // super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.

                           but.setBackground(ConsultaPersonagem.corBotaoSelecionado );
                           but.setForeground(ConsultaPersonagem.letraComFocus );
                           but.setIcon(ConsultaPersonagem.hand_icon );
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                             //    super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                           but.setBackground(ConsultaPersonagem.corBotaoSelecionado );
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                           //  super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                           but.setBackground(ConsultaPersonagem.corBotaoNaoSelecionado );
                           but.setForeground(ConsultaPersonagem.letraSemFocus );
                           but.setIcon( null );
                    }
           });
            
        }
        
        
    }// FINAL DO CONSTRUTOR
    
    
    private void exibirCampoValorBusca( boolean exibir){
            this.lab_categoria.setVisible(exibir);
            this.txt_valor_pesquisa.setVisible(exibir);
            //System.out.println("exibir? "+exibir);
    }
    
    
    
    // CLASSE DIRECIONADA PARA O EVENTO DE MUDANCA DE SELECAO NO COMBOBOX "classificar por"
    private class SelecaoAlterada implements ItemListener{
            @Override
            public void itemStateChanged(ItemEvent evt) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
                                            // RETORNA O OBJETO ORIGINAL. TBM SE PODE O USAR O "getSource"
                  String itemSelecionado = evt.getItemSelectable()
                                                  .getSelectedObjects()[0]// RETORNA O PRIMEIRO DAS OPCOES SELECIONADAS
                                                                .toString(); 
                  
                  switch(itemSelecionado){
                      case "MESMA CLASSE": 
                            exibirCampoValorBusca(true);
                            nomeColuna = "classe"; 
                            lab_categoria.setText("NOME DA CLASSE: ");
                            break;
                            
                      case "ID":
                            exibirCampoValorBusca(true);
                            nomeColuna = "ID"; 
                            lab_categoria.setText("VALOR DO ID: ");
                            break;

                      case "NOME":
                            exibirCampoValorBusca(true);
                            nomeColuna = "nome"; 
                            lab_categoria.setText("VALOR DO NOME: ");
                            break;

                      case "EXIBIR TODOS":
                            exibirCampoValorBusca(false);
                            nomeColuna = "*"; 
                            break;
                  }
            }
    }

    
    //CLASSE DEDICADA AO EVENTO DE MUDANCA DE SELECAO DA LISTA DE PERSONAGENS FILTRADOS
    private class SelecaoItemLista implements ListSelectionListener{

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                   //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                 JList<String> listaPersonagens = (JList) evt.getSource();
             //    String[] personagensSelecionados = (String[]) listaPersonagens.getSelectedValuesList().toArray();//toArray() retorna "Object[]" que pode ser convertido para qualquer classe do JDK
             // ERRO DE CONVERSAO DE TIPO (Object to String[]) LOGO ACIMA
                 
                 List<String> lista = listaPersonagens.getSelectedValuesList();
             
                 if( lista.size() > 1)
                     JOptionPane.showMessageDialog(null, "Ñ pode selecionar mais de um personagem...", "OOOPS!", JOptionPane.ERROR_MESSAGE);
                 else if( lista.size() == 1)
                     exibirDadosPersonagem( lista.get(0) );
            }
    }
    
    
    
    private void exibirDadosPersonagem(String nomePersonagem) {
            
          Personagem personModel = this.person.obter_personagem_por_nome( nomePersonagem);
          
          
     //------------ EXIBINDO ATRIBUTOS DO PERSONAGEM --------------
          this.lab_nome_dado.setText(personModel.getNome());
          this.lab_level_dado.setText( String.valueOf(personModel.getNivel()) );
          this.lab_atk_dado.setText( String.valueOf(personModel.getAtaque() ) );
          this.lab_sp_atk_dado.setText( String.valueOf(personModel.getAtaque_especial() ));
          this.lab_def_dado.setText( String.valueOf(personModel.getDefesa() ) );
          this.lab_sp_def_dado.setText( String.valueOf(personModel.getDefesa_especial() ) );
          this.lab_forca_dado.setText( String.valueOf(personModel.getForca() ));
          this.lab_evasao_dado.setText( String.valueOf(personModel.getEvasao() ));
          this.lab_destreza_dado.setText( String.valueOf(personModel.getDestreza() ) );
          this.lab_veloc_dado.setText( String.valueOf(personModel.getVelocidade() ) );
          
          this.progress_HP.setValue( personModel.getHP_atual() );
          this.progress_MP.setValue( personModel.getMP_atual() );
          this.progress_XP.setValue( personModel.getXP() );
          
          this.lab_HP_dado.setText( personModel.getHP_atual()+"/"+personModel.getPontos_vida()  );
          this.lab_MP_dado.setText( personModel.getMP_atual()+"/"+personModel.getPontos_magia() );
          this.lab_XP_dado.setText( personModel.getXP()+"/500k" );
      
  
     //------------ EXIBINDO IMAGEM DO PERSONAGEM --------------
            
          if(personModel.getSprite() != null){
                String imagem = personModel.getSprite();
          
                byte[] decodedBytesImage = null;
                //FileUtils.writeByteArrayToFile(new File(outputFileName), decodedBytes); //CASO FOSSE NECESSARIO EXPORTAR IMAGEM

                try{
                    decodedBytesImage = Base64.getDecoder().decode(imagem);
                    
                }catch(IllegalArgumentException iae){
                    System.out.println("Erro no formato da imagem passada como argumento para o metodo 'decode'!!!"+iae);
                }

                Dimension tamanhoImagem = new Dimension( this.pnl_imagem_perfil.getWidth(), this.pnl_imagem_perfil.getHeight() );
                
                Image imagemRedimensionada = new ImageIcon( decodedBytesImage )
                                                    .getImage() // REDIMENSIONANDO A IMAGEM
                                                       .getScaledInstance( 
                                                             tamanhoImagem.width, 
                                                               tamanhoImagem.height, 
                                                                  Image.SCALE_DEFAULT
                                                        );
                
                this.imagemLabel.setIcon( 
                       new ImageIcon( imagemRedimensionada )
                );
                
                this.imagemLabel.setSize(tamanhoImagem);
                this.imagemLabel.setPreferredSize(tamanhoImagem);
                this.imagemLabel.setMinimumSize(tamanhoImagem);
                this.imagemLabel.setMaximumSize(tamanhoImagem);
                this.imagemLabel.setLocation(0, 0);
                this.imagemLabel.setBounds(0, 0, tamanhoImagem.width, tamanhoImagem.height);
                this.imagemLabel.setBackground( new Color(255, 0, 0));

                this.pnl_imagem_perfil.add( imagemLabel);
          }
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // @SuppressWarnings("unchecked"); // ESTAVA DESCOMENTADOOOO!!!!
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_fundo_atributos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lab_velocidade = new javax.swing.JLabel();
        lab_forca = new javax.swing.JLabel();
        lab_sp_def = new javax.swing.JLabel();
        lab_destreza = new javax.swing.JLabel();
        lab_evasao = new javax.swing.JLabel();
        lab_destreza_dado = new javax.swing.JLabel();
        lab_veloc_dado = new javax.swing.JLabel();
        lab_forca_dado = new javax.swing.JLabel();
        lab_evasao_dado = new javax.swing.JLabel();
        lab_sp_def_dado = new javax.swing.JLabel();
        lab_titulo_fundo = new javax.swing.JPanel();
        lab_titulo = new javax.swing.JLabel();
        pnl_fundo_consulta = new javax.swing.JPanel();
        lab_pesquisar_por = new javax.swing.JLabel();
        lab_categoria = new javax.swing.JLabel();
        txt_valor_pesquisa = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_personagens = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        combo_pesquisar_por = new javax.swing.JComboBox<>();
        pnl_fundo_sobre = new javax.swing.JPanel();
        pnl_imagem_perfil = new javax.swing.JPanel();
        lab_nome = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lab_HP = new javax.swing.JLabel();
        lab_MP = new javax.swing.JLabel();
        lab_level = new javax.swing.JLabel();
        progress_HP = new javax.swing.JProgressBar();
        progress_MP = new javax.swing.JProgressBar();
        lab_level_dado = new javax.swing.JLabel();
        lab_nome_dado = new javax.swing.JLabel();
        lab_XP = new javax.swing.JLabel();
        progress_XP = new javax.swing.JProgressBar();
        lab_HP_dado = new javax.swing.JLabel();
        lab_MP_dado = new javax.swing.JLabel();
        lab_XP_dado = new javax.swing.JLabel();
        lab_atk = new javax.swing.JLabel();
        lab_def = new javax.swing.JLabel();
        lab_atk_dado = new javax.swing.JLabel();
        lab_def_dado = new javax.swing.JLabel();
        lab_sp_atk_dado = new javax.swing.JLabel();
        lab_sp_atk = new javax.swing.JLabel();
        lab_fundo = new javax.swing.JLabel();
        pnl_fundo_equipamento = new javax.swing.JPanel();
        pnl_fundo_titulo_equipamento = new javax.swing.JPanel();
        lab_equipamento = new javax.swing.JLabel();
        btn_armas = new javax.swing.JButton();
        btn_escudos = new javax.swing.JButton();
        btn_itens = new javax.swing.JButton();
        btn_acessorios = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_equipamentos = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtarea_descricao = new javax.swing.JTextArea();
        pnl_fundo_atributos_equip = new javax.swing.JPanel();
        lab_dano_ou_resistencia = new javax.swing.JLabel();
        lab_preco_dado = new javax.swing.JLabel();
        lab_dano_dado = new javax.swing.JLabel();
        lab_tipo = new javax.swing.JLabel();
        lab_preco = new javax.swing.JLabel();
        lab_tipo_dado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultar personagem");
        setMaximumSize(new java.awt.Dimension(998, 576));
        setMinimumSize(new java.awt.Dimension(998, 576));
        setName("Consulta"); // NOI18N
        setSize(new java.awt.Dimension(1000, 620));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_fundo_atributos.setBackground(new java.awt.Color(22, 0, 0));
        pnl_fundo_atributos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ATK: ");
        pnl_fundo_atributos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 90, 30));

        lab_velocidade.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_velocidade.setForeground(new java.awt.Color(255, 255, 255));
        lab_velocidade.setText("VELOCIDADE:");
        pnl_fundo_atributos.add(lab_velocidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 120, 40));

        lab_forca.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_forca.setForeground(new java.awt.Color(255, 255, 255));
        lab_forca.setText("FORÇA:");
        pnl_fundo_atributos.add(lab_forca, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 70, 30));

        lab_sp_def.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_sp_def.setForeground(new java.awt.Color(255, 255, 255));
        lab_sp_def.setText("SP. DEF:");
        pnl_fundo_atributos.add(lab_sp_def, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 70, 30));

        lab_destreza.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_destreza.setForeground(new java.awt.Color(255, 255, 255));
        lab_destreza.setText("DESTREZA:");
        pnl_fundo_atributos.add(lab_destreza, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 100, 30));

        lab_evasao.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_evasao.setForeground(new java.awt.Color(255, 255, 255));
        lab_evasao.setText("EVASÃO:");
        pnl_fundo_atributos.add(lab_evasao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 80, 30));

        lab_destreza_dado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_destreza_dado.setForeground(new java.awt.Color(51, 255, 51));
        lab_destreza_dado.setText("XX");
        pnl_fundo_atributos.add(lab_destreza_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 40, 30));

        lab_veloc_dado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_veloc_dado.setForeground(new java.awt.Color(51, 255, 51));
        lab_veloc_dado.setText("XX");
        pnl_fundo_atributos.add(lab_veloc_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 50, 40));

        lab_forca_dado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_forca_dado.setForeground(new java.awt.Color(51, 255, 51));
        lab_forca_dado.setText("XX");
        pnl_fundo_atributos.add(lab_forca_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 40, 30));

        lab_evasao_dado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_evasao_dado.setForeground(new java.awt.Color(51, 255, 51));
        lab_evasao_dado.setText("XX");
        pnl_fundo_atributos.add(lab_evasao_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 40, 30));

        lab_sp_def_dado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_sp_def_dado.setForeground(new java.awt.Color(51, 255, 51));
        lab_sp_def_dado.setText("XX");
        pnl_fundo_atributos.add(lab_sp_def_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 40, 30));

        getContentPane().add(pnl_fundo_atributos, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 340, 200, 200));

        lab_titulo_fundo.setBackground(new java.awt.Color(36, 0, 0));
        lab_titulo_fundo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(238, 96, 0), new java.awt.Color(255, 102, 0), null, new java.awt.Color(224, 129, 0)));
        lab_titulo_fundo.setMinimumSize(new java.awt.Dimension(991, 576));
        lab_titulo_fundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_titulo.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 55)); // NOI18N
        lab_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lab_titulo.setText("Consultar personagem");
        lab_titulo_fundo.add(lab_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, -20, 400, 100));

        getContentPane().add(lab_titulo_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1002, 70));

        pnl_fundo_consulta.setBackground(new java.awt.Color(55, 0, 0));
        pnl_fundo_consulta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.red, null, null));
        pnl_fundo_consulta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_pesquisar_por.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_pesquisar_por.setForeground(new java.awt.Color(255, 255, 255));
        lab_pesquisar_por.setText("CLASSIFICAR POR:");
        pnl_fundo_consulta.add(lab_pesquisar_por, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        lab_categoria.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_categoria.setForeground(new java.awt.Color(255, 255, 255));
        lab_categoria.setText("NOME DA X:");
        pnl_fundo_consulta.add(lab_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 94, -1, -1));

        txt_valor_pesquisa.setBackground(new java.awt.Color(102, 102, 102));
        txt_valor_pesquisa.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_valor_pesquisa.setForeground(new java.awt.Color(255, 255, 255));
        pnl_fundo_consulta.add(txt_valor_pesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 118, 180, 30));

        btn_buscar.setBackground(new java.awt.Color(51, 51, 51));
        btn_buscar.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setText("BUSCAR");
        btn_buscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        pnl_fundo_consulta.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 250, 40));

        list_personagens.setBackground(new java.awt.Color(22, 0, 0));
        list_personagens.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        list_personagens.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        list_personagens.setForeground(new java.awt.Color(255, 255, 255));
        list_personagens.setSelectionBackground(new java.awt.Color(204, 0, 51));
        list_personagens.setSelectionForeground(new java.awt.Color(51, 0, 0));
        jScrollPane1.setViewportView(list_personagens);

        pnl_fundo_consulta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 250, 280));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("RESULTADO:");
        pnl_fundo_consulta.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, 50));

        combo_pesquisar_por.setBackground(new java.awt.Color(102, 102, 102));
        combo_pesquisar_por.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        combo_pesquisar_por.setForeground(new java.awt.Color(255, 255, 255));
        combo_pesquisar_por.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EXIBIR TODOS", "MESMA CLASSE", "ID", "NOME" }));
        combo_pesquisar_por.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_fundo_consulta.add(combo_pesquisar_por, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 41, 230, 30));

        getContentPane().add(pnl_fundo_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 290, 570));

        pnl_fundo_sobre.setBackground(new java.awt.Color(22, 0, 0));
        pnl_fundo_sobre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.red, null, null));
        pnl_fundo_sobre.setForeground(new java.awt.Color(255, 255, 255));
        pnl_fundo_sobre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_imagem_perfil.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pnl_imagem_perfilLayout = new javax.swing.GroupLayout(pnl_imagem_perfil);
        pnl_imagem_perfil.setLayout(pnl_imagem_perfilLayout);
        pnl_imagem_perfilLayout.setHorizontalGroup(
            pnl_imagem_perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        pnl_imagem_perfilLayout.setVerticalGroup(
            pnl_imagem_perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        pnl_fundo_sobre.add(pnl_imagem_perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 240));

        lab_nome.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 36)); // NOI18N
        lab_nome.setForeground(new java.awt.Color(204, 204, 204));
        lab_nome.setText("NOME:");
        pnl_fundo_sobre.add(lab_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 100, 50));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("DESTREZA:");
        pnl_fundo_sobre.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 30));

        lab_HP.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lab_HP.setForeground(new java.awt.Color(255, 255, 255));
        lab_HP.setText("HP:");
        pnl_fundo_sobre.add(lab_HP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 50, 30));

        lab_MP.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lab_MP.setForeground(new java.awt.Color(255, 255, 255));
        lab_MP.setText("MP:");
        pnl_fundo_sobre.add(lab_MP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, 50));

        lab_level.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 36)); // NOI18N
        lab_level.setForeground(new java.awt.Color(204, 204, 204));
        lab_level.setText("LV:");
        pnl_fundo_sobre.add(lab_level, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 40, 50));

        progress_HP.setBackground(new java.awt.Color(22, 0, 0));
        progress_HP.setForeground(new java.awt.Color(255, 0, 51));
        progress_HP.setMaximum(999);
        progress_HP.setToolTipText("");
        progress_HP.setValue(100);
        pnl_fundo_sobre.add(progress_HP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 250, -1));

        progress_MP.setBackground(new java.awt.Color(22, 0, 0));
        progress_MP.setForeground(new java.awt.Color(0, 153, 255));
        progress_MP.setMaximum(500);
        progress_MP.setValue(90);
        pnl_fundo_sobre.add(progress_MP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 127, 250, 20));

        lab_level_dado.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_level_dado.setForeground(new java.awt.Color(51, 255, 51));
        lab_level_dado.setText("XX");
        pnl_fundo_sobre.add(lab_level_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 11, 40, 50));

        lab_nome_dado.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_nome_dado.setForeground(new java.awt.Color(51, 255, 51));
        lab_nome_dado.setText("XXXXXX");
        pnl_fundo_sobre.add(lab_nome_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 11, 190, 50));

        lab_XP.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lab_XP.setForeground(new java.awt.Color(255, 255, 255));
        lab_XP.setText("XP:");
        pnl_fundo_sobre.add(lab_XP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, 40));

        progress_XP.setBackground(new java.awt.Color(22, 0, 0));
        progress_XP.setForeground(new java.awt.Color(255, 0, 204));
        progress_XP.setMaximum(100000);
        progress_XP.setValue(60000);
        pnl_fundo_sobre.add(progress_XP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 250, 20));

        lab_HP_dado.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_HP_dado.setForeground(new java.awt.Color(255, 255, 255));
        lab_HP_dado.setText("XX");
        pnl_fundo_sobre.add(lab_HP_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 70, 30));

        lab_MP_dado.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_MP_dado.setForeground(new java.awt.Color(255, 255, 255));
        lab_MP_dado.setText("XX");
        pnl_fundo_sobre.add(lab_MP_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 60, 30));

        lab_XP_dado.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_XP_dado.setForeground(new java.awt.Color(255, 255, 255));
        lab_XP_dado.setText("XX");
        pnl_fundo_sobre.add(lab_XP_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 60, 40));

        lab_atk.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_atk.setForeground(new java.awt.Color(255, 255, 255));
        lab_atk.setText("ATK:");
        pnl_fundo_sobre.add(lab_atk, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 40, 30));

        lab_def.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_def.setForeground(new java.awt.Color(255, 255, 255));
        lab_def.setText("DEF:");
        pnl_fundo_sobre.add(lab_def, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 50, 30));

        lab_atk_dado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_atk_dado.setForeground(new java.awt.Color(51, 255, 51));
        lab_atk_dado.setText("XX");
        pnl_fundo_sobre.add(lab_atk_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, 30));

        lab_def_dado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_def_dado.setForeground(new java.awt.Color(51, 255, 51));
        lab_def_dado.setText("XX");
        pnl_fundo_sobre.add(lab_def_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 220, 30, 30));

        lab_sp_atk_dado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_sp_atk_dado.setForeground(new java.awt.Color(51, 255, 51));
        lab_sp_atk_dado.setText("XX");
        pnl_fundo_sobre.add(lab_sp_atk_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 40, 30));

        lab_sp_atk.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_sp_atk.setForeground(new java.awt.Color(255, 255, 255));
        lab_sp_atk.setText("SP. ATK:");
        pnl_fundo_sobre.add(lab_sp_atk, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 70, 30));

        getContentPane().add(pnl_fundo_sobre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 650, 260));

        lab_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background game.jpg"))); // NOI18N
        lab_fundo.setText(" ");
        getContentPane().add(lab_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 620));

        pnl_fundo_equipamento.setBackground(new java.awt.Color(22, 0, 0));
        pnl_fundo_equipamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_fundo_titulo_equipamento.setBackground(new java.awt.Color(76, 0, 0));
        pnl_fundo_titulo_equipamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_titulo_equipamento.setForeground(new java.awt.Color(255, 255, 255));
        pnl_fundo_titulo_equipamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_equipamento.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lab_equipamento.setForeground(new java.awt.Color(255, 255, 255));
        lab_equipamento.setText("equipamento:");
        pnl_fundo_titulo_equipamento.add(lab_equipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 60));

        pnl_fundo_equipamento.add(pnl_fundo_titulo_equipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 60));

        btn_armas.setBackground(new java.awt.Color(22, 0, 0));
        btn_armas.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        btn_armas.setText("Armas");
        btn_armas.setBorder(null);
        btn_armas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_fundo_equipamento.add(btn_armas, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 60, 190, 60));

        btn_escudos.setBackground(new java.awt.Color(22, 0, 0));
        btn_escudos.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        btn_escudos.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://github.com/MarcosPatrickExe/images-for-all-repositories/blob/main/rpg_game/icon_hand.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        btn_escudos.setText("Escudos");
        btn_escudos.setBorder(null);
        btn_escudos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_escudos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_escudosActionPerformed(evt);
            }
        });
        pnl_fundo_equipamento.add(btn_escudos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 120, 200, 50));

        btn_itens.setBackground(new java.awt.Color(22, 0, 0));
        btn_itens.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        btn_itens.setText("Itens");
        btn_itens.setBorder(null);
        btn_itens.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_fundo_equipamento.add(btn_itens, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 230, 190, 60));

        btn_acessorios.setBackground(new java.awt.Color(22, 0, 0));
        btn_acessorios.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        btn_acessorios.setText("Acessórios");
        btn_acessorios.setBorder(null);
        btn_acessorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_fundo_equipamento.add(btn_acessorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 170, 220, 60));

        getContentPane().add(pnl_fundo_equipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 160, 290));

        jScrollPane2.setForeground(new java.awt.Color(255, 51, 102));

        list_equipamentos.setBackground(new java.awt.Color(22, 0, 0));
        list_equipamentos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        list_equipamentos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        list_equipamentos.setForeground(new java.awt.Color(51, 255, 255));
        list_equipamentos.setSelectionBackground(new java.awt.Color(204, 0, 51));
        list_equipamentos.setSelectionForeground(new java.awt.Color(51, 0, 0));
        jScrollPane2.setViewportView(list_equipamentos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 260, 170));

        txtarea_descricao.setBackground(new java.awt.Color(22, 0, 0));
        txtarea_descricao.setColumns(20);
        txtarea_descricao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtarea_descricao.setForeground(new java.awt.Color(51, 255, 255));
        txtarea_descricao.setRows(5);
        txtarea_descricao.setText("\n");
        txtarea_descricao.setAlignmentX(2.5F);
        txtarea_descricao.setAlignmentY(2.5F);
        txtarea_descricao.setBorder(null);
        txtarea_descricao.setCaretColor(new java.awt.Color(22, 0, 0));
        txtarea_descricao.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtarea_descricao.setMargin(new java.awt.Insets(20, 20, 0, 0));
        jScrollPane3.setViewportView(txtarea_descricao);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 560, 260, 100));

        pnl_fundo_atributos_equip.setBackground(new java.awt.Color(22, 0, 0));
        pnl_fundo_atributos_equip.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_dano_ou_resistencia.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_dano_ou_resistencia.setForeground(new java.awt.Color(255, 255, 255));
        lab_dano_ou_resistencia.setText("DANO:");
        pnl_fundo_atributos_equip.add(lab_dano_ou_resistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 32, 65, 24));

        lab_preco_dado.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        lab_preco_dado.setForeground(new java.awt.Color(204, 0, 51));
        lab_preco_dado.setText("XX.XX");
        pnl_fundo_atributos_equip.add(lab_preco_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 5, -1, -1));

        lab_dano_dado.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        lab_dano_dado.setForeground(new java.awt.Color(204, 0, 51));
        lab_dano_dado.setText("XX");
        pnl_fundo_atributos_equip.add(lab_dano_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 32, 40, 24));

        lab_tipo.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_tipo.setForeground(new java.awt.Color(255, 255, 255));
        lab_tipo.setText("TIPO:");
        pnl_fundo_atributos_equip.add(lab_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, 20));

        lab_preco.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lab_preco.setForeground(new java.awt.Color(255, 255, 255));
        lab_preco.setText("PREÇO:");
        pnl_fundo_atributos_equip.add(lab_preco, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 5, -1, -1));

        lab_tipo_dado.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        lab_tipo_dado.setForeground(new java.awt.Color(204, 0, 51));
        lab_tipo_dado.setText("XXX");
        pnl_fundo_atributos_equip.add(lab_tipo_dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 32, -1, -1));

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setText("XXXX");
        pnl_fundo_atributos_equip.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 62, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DANO/RES.:");
        pnl_fundo_atributos_equip.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 20));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PRECO:");
        pnl_fundo_atributos_equip.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("xx");
        pnl_fundo_atributos_equip.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 8, 40, 20));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("xx");
        pnl_fundo_atributos_equip.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 37, -1, 20));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("xx");
        pnl_fundo_atributos_equip.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 63, 30, 30));

        getContentPane().add(pnl_fundo_atributos_equip, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 560, 200, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_escudosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_escudosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_escudosActionPerformed

    
    private String[] obterSomenteNomesPersonagens( List<Personagem> personagens){
        String[] nomes = new String[ personagens.size()];
        int contador = 0;
        
      //  System.out.println("tamanho da lista: "+personagens.size());
      //  System.out.println("primeiro da lista: "+personagens.get(0).getNome());
        
        for(Personagem personagen : personagens){
                nomes[contador] = personagen.getNome();
                contador++;
        }
        
        return nomes;
    }
     
    
    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
       
         String valor = this.txt_valor_pesquisa.getText();
         boolean campoVisivel = this.txt_valor_pesquisa.isVisible();
         
         
         if( (valor.equals("") || valor.length()==0) && (campoVisivel) ){
             JOptionPane.showMessageDialog(null, "O campo de valor não pode estar vazio!!!", "Error!!!", JOptionPane.ERROR_MESSAGE);                   
             
  // INICIO DA BUSCA POR TODOS OS PERSONAGENS CADASTRADOS:
         }else if( campoVisivel==false ){ 
           //  String[] nomesPersonagens = person.obter_personagens().toArray( new String[0] );
             String[] nomesPersonagens = this.obterSomenteNomesPersonagens( person.obter_personagens() );
           
             this.list_personagens.setListData(nomesPersonagens);
             this.list_personagens.setEnabled(true);
             
             
   // INICIO DA BUSCA EM REALAÇÃO AO "ID", OU "CLASSE" OU "NOME" DO PERSONAGEM....          
         }else if( campoVisivel ){ 
            
             switch ( this.combo_pesquisar_por.getSelectedItem().toString() ){// OBTENDO O NOME DA COLUNA QUE SERÁ PESQUISADA
     //===================================================================================
                      case "MESMA CLASSE":
                        List<Personagem> personss1 = this.person.obter_personagens_por_classe(valor);
                          
                        if( personss1 !=null ){
                            this.list_personagens.setListData(
                                 this.obterSomenteNomesPersonagens(// RETORNA "String[]"
                                      personss1
                                 )
                            );
                        }else if(personss1 !=null && personss1.get(0)==null){
                            JOptionPane.showMessageDialog(null, "Nenhum personagem foi cadastrado com a referida classe!!!", "Error", JOptionPane.WARNING_MESSAGE);                        
                        }

                      break;
     //=================================================================================== 
                      case "ID":
                          Personagem personn2;
                          
                          try{
                              personn2 = this.person.obter_personagem_por_ID( Integer.valueOf(valor));
                             
                              if(personn2 !=null){
                                    this.list_personagens.setListData(
                                          new String[]{  
                                             personn2.getNome() 
                                          }
                                    );
                              }else{ 
                                    JOptionPane.showMessageDialog(null, "O personagem com o referido ID não se encontra no banco de dados!!!", "Error", JOptionPane.ERROR_MESSAGE);                        
                              }
                          
                          }catch( NumberFormatException nfe){
                               JOptionPane.showMessageDialog(null, "Formato de ID inválido. Digite apenas números!!!", "Error", JOptionPane.WARNING_MESSAGE);                        
                               System.out.println(nfe.getMessage());
                          }
                          
                      break;
     //===================================================================================    
                      case "NOME":
                          Personagem personn3 = this.person.obter_personagem_por_nome(valor);
                          
                          if( personn3!=null ){
                                this.list_personagens.setListData(
                                      new String[]{
                                          personn3.getNome()
                                      }
                                );
                          }else{
                              JOptionPane.showMessageDialog(null, "O referido nome não se encontra no banco de dados!!!", "Error", JOptionPane.ERROR_MESSAGE);
                          }
                      break;
     //===================================================================================
                      default:
                          this.list_personagens.setEnabled(true);
             }//fechamento do switch
         }
    }//GEN-LAST:event_btn_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaPersonagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_acessorios;
    private javax.swing.JButton btn_armas;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_escudos;
    private javax.swing.JButton btn_itens;
    private javax.swing.JComboBox<String> combo_pesquisar_por;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lab_HP;
    private javax.swing.JLabel lab_HP_dado;
    private javax.swing.JLabel lab_MP;
    private javax.swing.JLabel lab_MP_dado;
    private javax.swing.JLabel lab_XP;
    private javax.swing.JLabel lab_XP_dado;
    private javax.swing.JLabel lab_atk;
    private javax.swing.JLabel lab_atk_dado;
    private javax.swing.JLabel lab_categoria;
    private javax.swing.JLabel lab_dano_dado;
    private javax.swing.JLabel lab_dano_ou_resistencia;
    private javax.swing.JLabel lab_def;
    private javax.swing.JLabel lab_def_dado;
    private javax.swing.JLabel lab_destreza;
    private javax.swing.JLabel lab_destreza_dado;
    private javax.swing.JLabel lab_equipamento;
    private javax.swing.JLabel lab_evasao;
    private javax.swing.JLabel lab_evasao_dado;
    private javax.swing.JLabel lab_forca;
    private javax.swing.JLabel lab_forca_dado;
    private javax.swing.JLabel lab_fundo;
    private javax.swing.JLabel lab_level;
    private javax.swing.JLabel lab_level_dado;
    private javax.swing.JLabel lab_nome;
    private javax.swing.JLabel lab_nome_dado;
    private javax.swing.JLabel lab_pesquisar_por;
    private javax.swing.JLabel lab_preco;
    private javax.swing.JLabel lab_preco_dado;
    private javax.swing.JLabel lab_sp_atk;
    private javax.swing.JLabel lab_sp_atk_dado;
    private javax.swing.JLabel lab_sp_def;
    private javax.swing.JLabel lab_sp_def_dado;
    private javax.swing.JLabel lab_tipo;
    private javax.swing.JLabel lab_tipo_dado;
    private javax.swing.JLabel lab_titulo;
    private javax.swing.JPanel lab_titulo_fundo;
    private javax.swing.JLabel lab_veloc_dado;
    private javax.swing.JLabel lab_velocidade;
    private javax.swing.JList<String> list_equipamentos;
    private javax.swing.JList<String> list_personagens;
    private javax.swing.JPanel pnl_fundo_atributos;
    private javax.swing.JPanel pnl_fundo_atributos_equip;
    private javax.swing.JPanel pnl_fundo_consulta;
    private javax.swing.JPanel pnl_fundo_equipamento;
    private javax.swing.JPanel pnl_fundo_sobre;
    private javax.swing.JPanel pnl_fundo_titulo_equipamento;
    private javax.swing.JPanel pnl_imagem_perfil;
    private javax.swing.JProgressBar progress_HP;
    private javax.swing.JProgressBar progress_MP;
    private javax.swing.JProgressBar progress_XP;
    private javax.swing.JTextField txt_valor_pesquisa;
    private javax.swing.JTextArea txtarea_descricao;
    // End of variables declaration//GEN-END:variables
}
