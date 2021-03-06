/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import connection.ConexaoBD_Setup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Patrick
 */
public class ConexaoBD extends JFrame {
    /**
     * Creates new form ConexaoBD
     */
    
    // ONLINE DATABASE PARAMETERS
    private static final String host_address = "ec2-3-217-14-181.compute-1.amazonaws.com";
    private static final String maintenance_database = "d4u4qkp2hum7jj";
    private static final String user = "rqegqbmcckiazc";
    private static final int port = 5432;
    private static final String password = "d50a51752e3559cbefded88da28ef6579e8d1df07d669f12b084689194fc29e9";
    private static final String URI = "postgres://rqegqbmcckiazc:d50a51752e3559cbefded88da28ef6579e8d1df07d669f12b084689194fc29e9@ec2-3-217-14-181.compute-1.amazonaws.com:5432/d4u4qkp2hum7jj";
    
    
    // LCCAL DATABASE PARAMETERS 
    private static final String host_address2 = "localhost";
    private static final String maintenance_database2 = "rpg_database";
    private static final String user2 = "postgres";
    private static final int port2 = 5432;
    private static final String password2 = "postgres";
   
    
    public ConexaoBD() {
            initComponents();
            
            this.setLocationRelativeTo(null);
            
            if ( ConexaoBD_Setup.conexaoEstabelecida == true ){ // Se estiver conectado ao banco.....
                    btn_new_connection.setVisible(true);
                    btn_conect.setEnabled(false);
            }else{
                    btn_new_connection.setVisible(false);
                    btn_conect.setEnabled(true);
            }
            
            
            //this.lab_database_checkbox.setText("Usar banco de \n dados online?");
            
            // ADICIONANDO EVENTO DE MUDANCA DE ESTADO NO CHECKBOX CHAMADO "Usar banco online?":
            this.check_use_online_database.addChangeListener(
                
                  new btnAlterarDatabase( // "btnAlterarDatabase" ?? UMA CLASSE PERSONALIADA
                       this.check_use_online_database
                  ) 
            );
    }
    
    
    // CLASSE QUE IMPLEMENTA EVENTO DO BOTAO DE CHECK BOX:
    private class btnAlterarDatabase 
                     //  extends javax.swing.JComboBox 
                            implements javax.swing.event.ChangeListener{

        private JCheckBox esseCheckBox;
        
        private btnAlterarDatabase(JCheckBox btnContext){
             this.esseCheckBox = btnContext;
        }
        
        @Override
        public void stateChanged(ChangeEvent evt) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
          //   System.out.println("classe em execucao: "+evt.getClass());// EXIBE "javax.swing.event.ChangeEvent"
          //   System.out.println("Est?? marcado: "+this.esseCheckBox.isSelected());
              if (this.esseCheckBox.isSelected())
                  online_database_parameters();
              else
                  local_database_parameters();
            
        }
    }
    

    private void local_database_parameters(){
          this.text_database.setText(ConexaoBD.maintenance_database2 );
          this.text_host.setText(ConexaoBD.host_address2);
          this.text_port.setText( String.valueOf( ConexaoBD.port2) );
          this.text_user.setText(ConexaoBD.user2);
          this.text_password.setText(ConexaoBD.password2);
          
          this.text_database.setEnabled(true);
          this.text_host.setEnabled(true);
          this.text_port.setEnabled(true);
          this.text_user.setEnabled(true);
          this.text_password.setEnabled(true);
    }
    
    
    private void online_database_parameters(){
          this.text_database.setText( ConexaoBD.maintenance_database );
          this.text_host.setText( ConexaoBD.host_address);
          this.text_port.setText( String.valueOf( ConexaoBD.port) );
          this.text_user.setText( ConexaoBD.user);
          this.text_password.setText( ConexaoBD.password);
          
          this.text_database.setEnabled(false);
          this.text_host.setEnabled(false);
          this.text_port.setEnabled(false);
          this.text_user.setEnabled(false);
          this.text_password.setEnabled(false);
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pan_card_setup = new javax.swing.JPanel();
        lab_database = new javax.swing.JLabel();
        text_database = new javax.swing.JTextField();
        lab_user = new javax.swing.JLabel();
        lab_port = new javax.swing.JLabel();
        lab_host = new javax.swing.JLabel();
        lab_password = new javax.swing.JLabel();
        text_host = new javax.swing.JTextField();
        text_port = new javax.swing.JTextField();
        text_user = new javax.swing.JTextField();
        text_password = new javax.swing.JTextField();
        lab_database_checkbox = new javax.swing.JLabel();
        check_use_online_database = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        btn_conect = new javax.swing.JButton();
        btn_new_connection = new javax.swing.JButton();
        pnl_fundo_titulo = new javax.swing.JPanel();
        lab_titulo = new javax.swing.JLabel();
        lab_fundo_imagem = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configura????es");
        setBackground(new java.awt.Color(23, 0, 0));
        setMinimumSize(new java.awt.Dimension(599, 455));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan_card_setup.setBackground(new java.awt.Color(30, 0, 0));
        pan_card_setup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_database.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        lab_database.setForeground(new java.awt.Color(255, 255, 255));
        lab_database.setText("Nome do banco:");
        pan_card_setup.add(lab_database, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 160, 30));

        text_database.setBackground(new java.awt.Color(102, 102, 102));
        text_database.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_database.setForeground(new java.awt.Color(255, 255, 255));
        text_database.setText("rpg_database");
        pan_card_setup.add(text_database, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 200, 30));

        lab_user.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        lab_user.setForeground(new java.awt.Color(255, 255, 255));
        lab_user.setText("Usuario:");
        pan_card_setup.add(lab_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 100, 50));

        lab_port.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        lab_port.setForeground(new java.awt.Color(255, 255, 255));
        lab_port.setText("Porta:");
        pan_card_setup.add(lab_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 120, 60, 60));

        lab_host.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        lab_host.setForeground(new java.awt.Color(255, 255, 255));
        lab_host.setText("Nome/IP do Host:");
        pan_card_setup.add(lab_host, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 170, 50));

        lab_password.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        lab_password.setForeground(new java.awt.Color(255, 255, 255));
        lab_password.setText("Senha:");
        pan_card_setup.add(lab_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 230, 70, 50));

        text_host.setBackground(new java.awt.Color(102, 102, 102));
        text_host.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_host.setForeground(new java.awt.Color(255, 255, 255));
        text_host.setText("localhost");
        pan_card_setup.add(text_host, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 200, 30));

        text_port.setBackground(new java.awt.Color(102, 102, 102));
        text_port.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_port.setForeground(new java.awt.Color(255, 255, 255));
        text_port.setText("5432");
        pan_card_setup.add(text_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 136, 200, 30));

        text_user.setBackground(new java.awt.Color(102, 102, 102));
        text_user.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_user.setForeground(new java.awt.Color(255, 255, 255));
        text_user.setText("postgres");
        pan_card_setup.add(text_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 140, 30));

        text_password.setBackground(new java.awt.Color(102, 102, 102));
        text_password.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_password.setForeground(new java.awt.Color(255, 255, 255));
        text_password.setText("postgres");
        pan_card_setup.add(text_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 140, 30));

        lab_database_checkbox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lab_database_checkbox.setForeground(new java.awt.Color(255, 255, 255));
        lab_database_checkbox.setText("Usar banco de");
        pan_card_setup.add(lab_database_checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 100, 50));

        check_use_online_database.setBackground(new java.awt.Color(51, 51, 51));
        check_use_online_database.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        check_use_online_database.setForeground(new java.awt.Color(204, 204, 204));
        check_use_online_database.setText("Sim");
        pan_card_setup.add(check_use_online_database, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 250, 90, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("dados online?");
        pan_card_setup.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 210, -1, 50));

        getContentPane().add(pan_card_setup, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 110, 680, 290));

        btn_conect.setBackground(new java.awt.Color(51, 51, 51));
        btn_conect.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_conect.setForeground(new java.awt.Color(255, 255, 255));
        btn_conect.setText("Conectar ao banco de dados");
        btn_conect.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_conect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_conect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conectActionPerformed(evt);
            }
        });
        getContentPane().add(btn_conect, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 270, 40));

        btn_new_connection.setBackground(new java.awt.Color(51, 51, 51));
        btn_new_connection.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_new_connection.setForeground(new java.awt.Color(255, 255, 255));
        btn_new_connection.setText("Nova conex??o");
        btn_new_connection.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_new_connection.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_new_connection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_new_connectionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_new_connection, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 160, 40));

        pnl_fundo_titulo.setBackground(new java.awt.Color(36, 0, 0));
        pnl_fundo_titulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 102, 0), new java.awt.Color(204, 102, 0), null, null));
        pnl_fundo_titulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_titulo.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 55)); // NOI18N
        lab_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lab_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_titulo.setText("Configurar banco de dados");
        pnl_fundo_titulo.add(lab_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -10, -1, 80));

        getContentPane().add(pnl_fundo_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 70));

        lab_fundo_imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/background game.jpg"))); // NOI18N
        getContentPane().add(lab_fundo_imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_conectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conectActionPerformed
              
                String database = this.text_database.getText() ;
                String host = this.text_host.getText() ;
                short port = Short.parseShort(this.text_port.getText() ) ;
                String user = this.text_user.getText() ;
                String password =  this.text_password.getText();
        
                 
                try{        
                        ConexaoBD_Setup.conexao_Setup( database, host, port, user, password);
                        Connection conexao = ConexaoBD_Setup.abrirConexao();

                        if ( conexao != null  ){
                               JOptionPane.showMessageDialog(null, "Conex??o com o banco bem sucedida!", "Gotcha!!!", JOptionPane.INFORMATION_MESSAGE);
                               ConexaoBD_Setup.conexaoEstabelecida = true;
                               this.btn_new_connection.setVisible(true);
                               this.btn_conect.setEnabled(false);
                        }

                        ConexaoBD_Setup.encerrarConexao(conexao);
                        
                        this.dispose();
                            
                }catch(ClassNotFoundException cnfe){
                         JOptionPane.showMessageDialog(null, "Erro ao tentar realizar uma conex??o com o banco.....", "Error!!!", JOptionPane.ERROR_MESSAGE);
                       //  System.out.println("Erro ao tentar realizar uma conex??o com o banco..... "+cnfe);
                         ConexaoBD_Setup.conexaoEstabelecida = false;  
                       
                }catch(java.lang.NumberFormatException errorFormat){
                        JOptionPane.showMessageDialog(null, "Erro ao tentar realizar convers??o de um formato de dado para outro.....", "Error!!!", JOptionPane.ERROR_MESSAGE);
                        errorFormat.printStackTrace();
                }
                
    }//GEN-LAST:event_btn_conectActionPerformed

    private void btn_new_connectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_new_connectionActionPerformed
               ConexaoBD_Setup.conexaoEstabelecida = false;
               
               this.text_database.setText("");
               this.text_host.setText("");
               this.text_port.setText("");
               this.text_user.setText("");
               this.text_password.setText("");
               
               this.btn_new_connection.setVisible(false);
               this.btn_conect.setEnabled(true);
    }//GEN-LAST:event_btn_new_connectionActionPerformed

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
            java.util.logging.Logger.getLogger(ConexaoBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConexaoBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConexaoBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConexaoBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new ConexaoBD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_conect;
    private javax.swing.JButton btn_new_connection;
    private javax.swing.JCheckBox check_use_online_database;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lab_database;
    private javax.swing.JLabel lab_database_checkbox;
    private javax.swing.JLabel lab_fundo_imagem;
    private javax.swing.JLabel lab_host;
    private javax.swing.JLabel lab_password;
    private javax.swing.JLabel lab_port;
    private javax.swing.JLabel lab_titulo;
    private javax.swing.JLabel lab_user;
    private javax.swing.JPanel pan_card_setup;
    private javax.swing.JPanel pnl_fundo_titulo;
    private javax.swing.JTextField text_database;
    private javax.swing.JTextField text_host;
    private javax.swing.JTextField text_password;
    private javax.swing.JTextField text_port;
    private javax.swing.JTextField text_user;
    // End of variables declaration//GEN-END:variables
}

/*
       restore and store image bytea from postgre database:
       https://stackoverflow.com/questions/6078525/displaying-image-from-postgresql-database-bytea


       https://stackoverflow.com/questions/15127100/store-and-retrieve-images-in-postgresql-using-java

 */