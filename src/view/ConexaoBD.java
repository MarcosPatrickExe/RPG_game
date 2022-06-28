/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.ConexaoBD_Setup;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Patrick
 */
public class ConexaoBD extends javax.swing.JFrame {

    /**
     * Creates new form ConexaoBD
     */
    public ConexaoBD() {
            initComponents();
        
            this.setLocationRelativeTo(null);
            
            if ( connection.ConexaoBD_Setup.getConexao() !=null ){ // Se estiver conectado ao banco.....
                    btn_new_connection.setVisible(true);
                    btn_conect.setEnabled(false);
            }else{
                    btn_new_connection.setVisible(false);
                    btn_conect.setEnabled(true);
            }
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
        btn_conect = new javax.swing.JButton();
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
        lab_titulo = new javax.swing.JLabel();
        btn_new_connection = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações");
        setMinimumSize(new java.awt.Dimension(599, 455));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan_card_setup.setBackground(new java.awt.Color(36, 0, 0));
        pan_card_setup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_conect.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        btn_conect.setText("Conectar ao banco de dados");
        btn_conect.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_conect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_conect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conectActionPerformed(evt);
            }
        });
        pan_card_setup.add(btn_conect, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 270, 40));

        lab_database.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_database.setText("Nome do banco:");
        pan_card_setup.add(lab_database, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 150, 30));

        text_database.setBackground(new java.awt.Color(153, 153, 153));
        text_database.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_database.setForeground(new java.awt.Color(102, 102, 102));
        text_database.setText("rpg_database");
        pan_card_setup.add(text_database, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 200, 30));

        lab_user.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_user.setText("Usuario:");
        pan_card_setup.add(lab_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 90, 70));

        lab_port.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_port.setText("Porta:");
        pan_card_setup.add(lab_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, 50));

        lab_host.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_host.setText("Nome/IP do Host:");
        pan_card_setup.add(lab_host, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 160, 50));

        lab_password.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_password.setText("Senha:");
        pan_card_setup.add(lab_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        text_host.setBackground(new java.awt.Color(153, 153, 153));
        text_host.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_host.setForeground(new java.awt.Color(102, 102, 102));
        text_host.setText("localhost");
        pan_card_setup.add(text_host, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 200, 30));

        text_port.setBackground(new java.awt.Color(153, 153, 153));
        text_port.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_port.setForeground(new java.awt.Color(102, 102, 102));
        text_port.setText("5432");
        pan_card_setup.add(text_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 200, 30));

        text_user.setBackground(new java.awt.Color(153, 153, 153));
        text_user.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_user.setForeground(new java.awt.Color(102, 102, 102));
        text_user.setText("postgres");
        pan_card_setup.add(text_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 140, 30));

        text_password.setBackground(new java.awt.Color(153, 153, 153));
        text_password.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_password.setForeground(new java.awt.Color(102, 102, 102));
        text_password.setText("postgres");
        pan_card_setup.add(text_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 140, -1));

        lab_titulo.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 55)); // NOI18N
        lab_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_titulo.setText("Configurar banco de dados");
        pan_card_setup.add(lab_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 510, 60));

        btn_new_connection.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        btn_new_connection.setText("Nova conexão");
        btn_new_connection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_new_connectionActionPerformed(evt);
            }
        });
        pan_card_setup.add(btn_new_connection, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 160, 40));

        getContentPane().add(pan_card_setup, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 470, 510));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Patrick\\Pictures\\Background menu RPG.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_conectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conectActionPerformed
                String database = this.text_database.getText() ;
                String host = this.text_host.getText() ;
                short port = Short.valueOf( this.text_port.getText() ) ;
                String user = this.text_user.getText() ;
                int password =  Integer.valueOf( this.text_password.getText() );
                
                try{
                            ConexaoBD_Setup.conexao_Setup( database, host, port, user, password);
                            Connection conexao = ConexaoBD_Setup.abrirConexao();
                            
                            if ( conexao != null  )
                                      JOptionPane.showMessageDialog(null, "Conexão com o banco bem sucedida!", "Gotcha!!!", JOptionPane.INFORMATION_MESSAGE);
                                  
                            conexao.close();
                            
                }catch(ClassNotFoundException cnfe){
                         System.out.println("Erro ao tentar realizar uma conexão com o banco..... "+cnfe);
                         
                }catch(SQLException ex){
                         ex.printStackTrace();
                }
                
    }//GEN-LAST:event_btn_conectActionPerformed

    private void btn_new_connectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_new_connectionActionPerformed
               connection.ConexaoBD_Setup.encerrarConexao(); 
               
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lab_database;
    private javax.swing.JLabel lab_host;
    private javax.swing.JLabel lab_password;
    private javax.swing.JLabel lab_port;
    private javax.swing.JLabel lab_titulo;
    private javax.swing.JLabel lab_user;
    private javax.swing.JPanel pan_card_setup;
    private javax.swing.JTextField text_database;
    private javax.swing.JTextField text_host;
    private javax.swing.JTextField text_password;
    private javax.swing.JTextField text_port;
    private javax.swing.JTextField text_user;
    // End of variables declaration//GEN-END:variables
}