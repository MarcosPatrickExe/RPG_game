package rpg_game.Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Patrick
 */
public class Menu_Inicial extends javax.swing.JFrame {

    public static double widthScreen;  //   1366.0  
    public static double heightScreen; //768.0
    private JFrame ConexaoBD = new ConexaoBD();
    
    /**
     * Creates new form Menu_Inicial
     */
    public Menu_Inicial() {
          initComponents();
    
          Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
     //     widthScreen = dim.getWidth();   // descomentar somente na versao final
      //    heightScreen = dim.getHeight(); // descomentar somente na versao final
         
          // MAXIMIZANDO A TELA DO GAME
     //    super.setExtendedState( super.getExtendedState() | JFrame.MAXIMIZED_BOTH);
         //System.out.println("width:  "+dim.getWidth()+"  \n height:  "+dim.getHeight());
         //this.getContentPane().setBackground(Color.gray); //colocando cor preta no fundo
         
         URL url_image;
         Image img;
         
       
     //    setBounds(300, 100, 990, 560);
      //   setPreferredSize(new Dimension(990, 560));
         btn_iniciar_campanha.setBackground( new Color(60,63,65) );
         btn_gerenciar_personagem.setBackground( new Color(60,63,65) );
         btn_configuracoes.setBackground( new Color(60,63,65) );
         btn_sair.setBackground( new Color(60,63,65) );
         this.setLocationRelativeTo(null);
       //  getContentPane().setBackground(Color.BLACK);
         
            /*
                      try{
                             //     url_image = new URL("file:/C:/Users/Patrick/Pictures/Background%20menu%20RPG.jpg");
                              // url_image = new URL("https://lh5.googleusercontent.com/proxy/5mD0bhPsejeYVwnxD4CnrbPhNeFcee0iJwCjY-T8Dqje9aCq3YkIWzTA1TAogoiZsKIMlzNEa-d2qkKUSIB2r0ndLZ9KKiw_a_GHgo39O5Ju7zwT0qqGRPTG4uyBnQJzb3sCkI-BF29S7wB6ZE8n_SaIWPE=w1200-h630-p-k-no-nu");
                            //     img = ImageIO.read( url_image ); //has private access in imageIO [deve-se nao instanciar ImageIO]
                           //     fundo =  new JLabel(   new ImageIcon(img)  );
                           //     fundo.setMinimumSize(dim);
                           //     setContentPane( fundo  );// adiciona o label/imagem sem precisar do metodo "super.add()"


                            JPanel fundoImagem = new JPanel(){ // anonymous class that extends a JPanel....
                                    @Override
                                    protected void paintComponent(Graphics g) {
                                           super.paintComponent(g); 
                                           g.drawImage( img, 0, 0,  (int) widthScreen, (int) heightScreen, this); // draw image in the parent content
                                    }
                            };

                           fundoImagem.setBounds(0, 0, (int) widthScreen, (int) heightScreen);
                           super.add(fundoImagem);  
               
            
               
                      }catch(MalformedURLException  e){
                          System.out.println("Erro ao acessar a imagem oferecida pela URL... \n"+e.getMessage());

                      }catch(IOException  ioe){
                          System.out.println("Erro ao adicionar a imagem dentro da programa......  \n"+ioe.getMessage());
                      }   
         
            */
         
      //  this.container.setLayout(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        btn_iniciar_campanha = new javax.swing.JButton();
        btn_gerenciar_personagem = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        lab_aviso = new javax.swing.JLabel();
        btn_configuracoes = new javax.swing.JButton();
        lab_aviso2 = new javax.swing.JLabel();
        btn_duelo_rapido = new javax.swing.JToggleButton();
        lab_duelo_rapido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setBounds(new java.awt.Rectangle(300, 100, 990, 560));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(300, 100));
        setMinimumSize(new java.awt.Dimension(991, 576));
        setName("Tela inical"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(991, 576));
        setResizable(false);
        setSize(new java.awt.Dimension(991, 576));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 122)); // NOI18N
        titulo.setForeground(new java.awt.Color(245, 245, 245));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("RPG game");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -30, 450, 190));
        titulo.getAccessibleContext().setAccessibleParent(this);

        btn_iniciar_campanha.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        btn_iniciar_campanha.setForeground(new java.awt.Color(255, 255, 255));
        btn_iniciar_campanha.setText("Iniciar campanha");
        btn_iniciar_campanha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_iniciar_campanha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_iniciar_campanhaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_iniciar_campanhaMouseExited(evt);
            }
        });
        btn_iniciar_campanha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciar_campanhaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_iniciar_campanha, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 200, 40));
        btn_iniciar_campanha.getAccessibleContext().setAccessibleParent(this);

        btn_gerenciar_personagem.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        btn_gerenciar_personagem.setForeground(new java.awt.Color(255, 255, 255));
        btn_gerenciar_personagem.setText("Gerenciar personagem");
        btn_gerenciar_personagem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_gerenciar_personagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_gerenciar_personagemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_gerenciar_personagemMouseExited(evt);
            }
        });
        btn_gerenciar_personagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerenciar_personagemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_gerenciar_personagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 250, 50));

        btn_sair.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        btn_sair.setForeground(new java.awt.Color(255, 255, 255));
        btn_sair.setText("Sair");
        btn_sair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_sairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_sairMouseExited(evt);
            }
        });
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, 110, 30));

        lab_aviso.setForeground(new java.awt.Color(204, 204, 204));
        lab_aviso.setText("  (Disponível em breve.....)");
        getContentPane().add(lab_aviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 170, 40));

        btn_configuracoes.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        btn_configuracoes.setForeground(new java.awt.Color(255, 255, 255));
        btn_configuracoes.setText("Configurações");
        btn_configuracoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_configuracoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_configuracoesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_configuracoesMouseExited(evt);
            }
        });
        btn_configuracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_configuracoesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_configuracoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 170, 40));

        lab_aviso2.setForeground(new java.awt.Color(204, 204, 204));
        lab_aviso2.setText("( Somente para ADMs )");
        getContentPane().add(lab_aviso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 150, -1));

        btn_duelo_rapido.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        btn_duelo_rapido.setForeground(new java.awt.Color(255, 255, 255));
        btn_duelo_rapido.setText("Duelo rápido multiplayer");
        btn_duelo_rapido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btn_duelo_rapido, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 260, 40));

        lab_duelo_rapido.setText("(Disponível em breve.....)");
        getContentPane().add(lab_duelo_rapido, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, -1));

        jLabel1.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/C:/Users/Patrick/Pictures/Background%20menu%20RPG.jpg")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel1.setMaximumSize(new java.awt.Dimension(991, 576));
        jLabel1.setMinimumSize(new java.awt.Dimension(991, 576));
        jLabel1.setPreferredSize(new java.awt.Dimension(991, 576));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 580));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciar_campanhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciar_campanhaActionPerformed
                JOptionPane.showMessageDialog(this, "Funcionalidade ainda não implementada....", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_iniciar_campanhaActionPerformed

    private void btn_iniciar_campanhaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_iniciar_campanhaMouseEntered
               btn_iniciar_campanha.setBackground(Color.red);
    }//GEN-LAST:event_btn_iniciar_campanhaMouseEntered

    private void btn_iniciar_campanhaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_iniciar_campanhaMouseExited
               btn_iniciar_campanha.setBackground( new Color(60,63,65) );
    }//GEN-LAST:event_btn_iniciar_campanhaMouseExited

    private void btn_gerenciar_personagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerenciar_personagemActionPerformed
              JOptionPane.showMessageDialog(rootPane, "Clicou!");
    }//GEN-LAST:event_btn_gerenciar_personagemActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
             this.dispose();
             System.exit(0);
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_gerenciar_personagemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gerenciar_personagemMouseEntered
            btn_gerenciar_personagem.setBackground( Color.red );
    }//GEN-LAST:event_btn_gerenciar_personagemMouseEntered

    private void btn_configuracoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_configuracoesMouseEntered
           btn_configuracoes.setBackground( Color.red );
    }//GEN-LAST:event_btn_configuracoesMouseEntered

    private void btn_sairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sairMouseEntered
           btn_sair.setBackground( Color.red );
    }//GEN-LAST:event_btn_sairMouseEntered

    private void btn_sairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sairMouseExited
          btn_sair.setBackground( CorPersonalizada.CINZA.cor  );
    }//GEN-LAST:event_btn_sairMouseExited

    private void btn_gerenciar_personagemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gerenciar_personagemMouseExited
          btn_gerenciar_personagem.setBackground( CorPersonalizada.CINZA.cor );
    }//GEN-LAST:event_btn_gerenciar_personagemMouseExited

    private void btn_configuracoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_configuracoesMouseExited
          btn_configuracoes.setBackground( CorPersonalizada.CINZA.cor );
    }//GEN-LAST:event_btn_configuracoesMouseExited

    private void btn_configuracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configuracoesActionPerformed
          this.ConexaoBD.setVisible(true);
    }//GEN-LAST:event_btn_configuracoesActionPerformed

    enum CorPersonalizada{
           CINZA(   new Color(60,63,65) );
           
           private Color cor;
           
           CorPersonalizada( Color cor  ){
                    this.cor = cor;
           }
           
           private Color obterCor(){
                     return this.cor; 
           }
    }
    
    
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
            java.util.logging.Logger.getLogger(Menu_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Inicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_configuracoes;
    private javax.swing.JToggleButton btn_duelo_rapido;
    private javax.swing.JButton btn_gerenciar_personagem;
    private javax.swing.JButton btn_iniciar_campanha;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lab_aviso;
    private javax.swing.JLabel lab_aviso2;
    private javax.swing.JLabel lab_duelo_rapido;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
