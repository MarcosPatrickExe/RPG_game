/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import DAO.DAO_postgreSQL.AcessorioDAO;
import DAO.DAO_postgreSQL.ArmaDAO;
import DAO.DAO_postgreSQL.ClasseDAO;
import DAO.DAO_postgreSQL.EscudoDAO;
import DAO.DAO_postgreSQL.ItemDAO;
import DAO.DAO_postgreSQL.PersonagemDAO;
import DAO.DAO_postgreSQL.Personagem_Equipamento_DAO;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Acessorio;
import model.Arma;
import model.Classe;
import model.Escudo;
import model.Item;
import model.Personagem;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Patrick
 */

/*
interface Pessoa{
    public short getIdade();

}
*/
public class CadastroPersonagem extends JFrame {

   // private boolean atributosInseridos = false;
   // private boolean equipamentosInseridos = false;
   
    private File imagemPerfilPersonagem = null;
    
    /**
     * Creates new form CadastroPersonagem
     */
    public CadastroPersonagem() {
        initComponents();
        
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo( null);
        
        ClasseDAO classeDAO = new ClasseDAO();
        ArmaDAO armaDAO = new ArmaDAO();
        EscudoDAO escudoDAO = new EscudoDAO();
        AcessorioDAO acessDAO = new AcessorioDAO();
        ItemDAO itensDAO = new ItemDAO();
        
        
       // this.btn_salvar.setEnabled(false);
        this.lab_equipar_arma.setVisible(false);
        this.lab_equipar_escudo.setVisible(false);
        this.lab_equipar_acessorio.setVisible(false);
        this.combo_equipar_arma.setVisible(false);
        this.combo_equipar_escudo.setVisible(false);
        this.combo_equipar_acessorio.setVisible(false);
        
        
        try { 
   // ===================== lista de classes para o personagem ==================================
            
                List<Classe> classes = classeDAO.obter_classes();
                String[] classeNames = new String [ classes.size()+1 ];
                
                int contador=1;
                classeNames[0] = "Selecione";
                
                for( Classe classe : classes){
                    classeNames[contador] = classe.getNome();
                    contador++;
                }
        
                this.combo_classe.setModel( 
                        new DefaultComboBoxModel(classeNames)
                );
                
   // ================================= lista de armas =====================================
                contador=0;
                
                List<Arma> armas = armaDAO.obter_armas();
                String[] armasNomes = new String[armas.size()];
                
                for( Arma arma : armas){
                    armasNomes[contador] = arma.getNome();
                    contador++;
                }
                
                this.list_armas.setListData( armasNomes );
                
          //      DefaultComboBoxModel dtm = new DefaultComboBoxModel( new String[]{"Nenhum"});// combo vazio
            //      combo_equipar_arma.setModel( dtm );
                
  // ================================= lista de escudos =====================================
                contador=0;
                
                List<Escudo> escudos = escudoDAO.obter_escudos();
                String[] escudosNomes = new String[escudos.size()];
                
                for( Escudo escudo : escudos){
                    escudosNomes[contador] = escudo.getNome();
                    contador++;
                }
                
                this.list_escudos.setListData( escudosNomes );
   
  // ================================= lista de Acessorios =====================================
                contador=0;
                
                List<Acessorio> acessorios = acessDAO.obter_acessorios();
                String[] acessoriosNomes = new String[acessorios.size()];
                
                for( Acessorio acessorio : acessorios){
                    acessoriosNomes[contador] = acessorio.getNome();
                    contador++;
                }
                
                this.list_acessorios.setListData( acessoriosNomes );
   
                
  // ================================= lista de Itens =====================================
                contador=0;
                
                List<Item> itens = itensDAO.obter_itens();
                String[] itensNomes = new String[itens.size()];
                
                for( Item item : itens){
                    itensNomes[contador] = item.getNome();
                    contador++;
                }
                
                this.list_itens.setListData( itensNomes );
   
        
        }catch (SQLException ex){
            System.out.println("houve erro no acesso ao banco de dados....");
            ex.printStackTrace(); 
        }catch(java.lang.NullPointerException npe){
            System.out.println("houve erro de NullPointerException....");
            npe.printStackTrace(); 
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

        lab_titulo_fundo = new javax.swing.JPanel();
        lab_titulo = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        tabbed_informacoes = new javax.swing.JTabbedPane();
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
        jLabel2 = new javax.swing.JLabel();
        lab_HP_atual = new javax.swing.JLabel();
        lab_MP_atual = new javax.swing.JLabel();
        spn_HP_atual = new javax.swing.JSpinner();
        spn_MP_atual = new javax.swing.JSpinner();
        pnl_fundo_equipamento = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_armas = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_escudos = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_acessorios = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        list_itens = new javax.swing.JList<>();
        combo_equipar_arma = new javax.swing.JComboBox<>();
        combo_equipar_escudo = new javax.swing.JComboBox<>();
        combo_equipar_acessorio = new javax.swing.JComboBox<>();
        lab_equipar_arma = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lab_equipar_escudo = new javax.swing.JLabel();
        lab_equipar_acessorio = new javax.swing.JLabel();
        btn_salvar_itens = new javax.swing.JButton();
        btn_salvar_armas = new javax.swing.JButton();
        btn_salvar_escudos = new javax.swing.JButton();
        btn_salvar_acessorios = new javax.swing.JButton();
        pnl_fundo_sprites = new javax.swing.JPanel();
        pnl_fundo_perfil = new javax.swing.JPanel();
        btn_selecionar_perfil = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lab_titulo_sprites = new javax.swing.JLabel();
        lab_perfil = new javax.swing.JLabel();
        lab_perfil_imagem = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JButton();
        lab_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_titulo_fundo.setBackground(new java.awt.Color(36, 0, 0));
        lab_titulo_fundo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(238, 96, 0), new java.awt.Color(238, 96, 0), null, null));
        lab_titulo_fundo.setMinimumSize(new java.awt.Dimension(991, 576));
        lab_titulo_fundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_titulo.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 55)); // NOI18N
        lab_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lab_titulo.setText("Cadastrar personagem");
        lab_titulo_fundo.add(lab_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, -20, 400, 100));

        getContentPane().add(lab_titulo_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 70));

        btn_salvar.setBackground(new java.awt.Color(51, 51, 51));
        btn_salvar.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        btn_salvar.setForeground(new java.awt.Color(204, 204, 204));
        btn_salvar.setText("Salvar tudo");
        btn_salvar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 190, 50));

        tabbed_informacoes.setBackground(new java.awt.Color(49, 60, 81));
        tabbed_informacoes.setForeground(new java.awt.Color(204, 204, 204));
        tabbed_informacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabbed_informacoes.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N

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
        txt_nome.setText("XXX");
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
        txt_level.setText("1");
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
        pnl_fundo_atributos.add(combo_classe, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 160, 30));

        txt_evasao.setBackground(new java.awt.Color(102, 102, 102));
        txt_evasao.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_evasao.setForeground(new java.awt.Color(255, 255, 255));
        txt_evasao.setText("00");
        txt_evasao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_evasao, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 60, 30));

        txt_forca.setBackground(new java.awt.Color(102, 102, 102));
        txt_forca.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_forca.setForeground(new java.awt.Color(255, 255, 255));
        txt_forca.setText("00");
        txt_forca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_forca, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 60, 30));

        txt_destreza.setBackground(new java.awt.Color(102, 102, 102));
        txt_destreza.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_destreza.setForeground(new java.awt.Color(255, 255, 255));
        txt_destreza.setText("00");
        txt_destreza.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_destreza, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 60, 30));

        txt_velocidade.setBackground(new java.awt.Color(102, 102, 102));
        txt_velocidade.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_velocidade.setForeground(new java.awt.Color(255, 255, 255));
        txt_velocidade.setText("00");
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
        txt_atk.setText("00");
        txt_atk.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_atk, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 70, 30));

        txt_sp_atk.setBackground(new java.awt.Color(102, 102, 102));
        txt_sp_atk.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_sp_atk.setForeground(new java.awt.Color(255, 255, 255));
        txt_sp_atk.setText("00");
        txt_sp_atk.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_sp_atk, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 70, 30));

        txt_def.setBackground(new java.awt.Color(102, 102, 102));
        txt_def.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_def.setForeground(new java.awt.Color(255, 255, 255));
        txt_def.setText("00");
        txt_def.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_def, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, 70, 30));

        txt_sp_def.setBackground(new java.awt.Color(102, 102, 102));
        txt_sp_def.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_sp_def.setForeground(new java.awt.Color(255, 255, 255));
        txt_sp_def.setText("00");
        txt_sp_def.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_sp_def, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, 70, 30));

        spn_HP_max.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pnl_fundo_atributos.add(spn_HP_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 90, 30));

        spn_MP_max.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pnl_fundo_atributos.add(spn_MP_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 90, 30));

        txt_XP.setBackground(new java.awt.Color(102, 102, 102));
        txt_XP.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_XP.setForeground(new java.awt.Color(255, 255, 255));
        txt_XP.setText("0000");
        pnl_fundo_atributos.add(txt_XP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 120, 30));

        jPanel7.setBackground(new java.awt.Color(49, 60, 81));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Defina os valores de todos os atributos do seu personagem");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

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

        tabbed_informacoes.addTab("Atributos", pnl_fundo_atributos);

        pnl_fundo_equipamento.setBackground(new java.awt.Color(23, 0, 0));
        pnl_fundo_equipamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(49, 60, 81));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Selecione os equipamentos que o personagem terá. Você pode selecionar vários segurando o botão CTRL.");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pnl_fundo_equipamento.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        jLabel21.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("Armas");
        pnl_fundo_equipamento.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, 60));

        jLabel22.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("Escudos");
        pnl_fundo_equipamento.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, 60));

        jLabel23.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("Acessórios");
        pnl_fundo_equipamento.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, 60));

        jLabel24.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("Itens");
        pnl_fundo_equipamento.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, -1, 80));

        list_armas.setBackground(new java.awt.Color(51, 51, 51));
        list_armas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        list_armas.setForeground(new java.awt.Color(255, 255, 255));
        list_armas.setToolTipText("");
        list_armas.setSelectionBackground(new java.awt.Color(204, 0, 51));
        jScrollPane1.setViewportView(list_armas);

        pnl_fundo_equipamento.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 210, 110));

        list_escudos.setBackground(new java.awt.Color(51, 51, 51));
        list_escudos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        list_escudos.setForeground(new java.awt.Color(255, 255, 255));
        list_escudos.setSelectionBackground(new java.awt.Color(204, 0, 51));
        jScrollPane2.setViewportView(list_escudos);

        pnl_fundo_equipamento.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 220, 110));

        list_acessorios.setBackground(new java.awt.Color(51, 51, 51));
        list_acessorios.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        list_acessorios.setForeground(new java.awt.Color(255, 255, 255));
        list_acessorios.setSelectionBackground(new java.awt.Color(204, 0, 51));
        jScrollPane3.setViewportView(list_acessorios);

        pnl_fundo_equipamento.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 220, 110));

        list_itens.setBackground(new java.awt.Color(51, 51, 51));
        list_itens.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        list_itens.setForeground(new java.awt.Color(255, 255, 255));
        list_itens.setSelectionBackground(new java.awt.Color(204, 0, 51));
        jScrollPane4.setViewportView(list_itens);

        pnl_fundo_equipamento.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 200, 110));

        combo_equipar_arma.setBackground(new java.awt.Color(51, 51, 51));
        combo_equipar_arma.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        combo_equipar_arma.setForeground(new java.awt.Color(204, 204, 204));
        combo_equipar_arma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhuma" }));
        combo_equipar_arma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_fundo_equipamento.add(combo_equipar_arma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 170, 35));

        combo_equipar_escudo.setBackground(new java.awt.Color(51, 51, 51));
        combo_equipar_escudo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        combo_equipar_escudo.setForeground(new java.awt.Color(204, 204, 204));
        combo_equipar_escudo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));
        combo_equipar_escudo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_fundo_equipamento.add(combo_equipar_escudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 170, -1));

        combo_equipar_acessorio.setBackground(new java.awt.Color(51, 51, 51));
        combo_equipar_acessorio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        combo_equipar_acessorio.setForeground(new java.awt.Color(204, 204, 204));
        combo_equipar_acessorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));
        combo_equipar_acessorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_fundo_equipamento.add(combo_equipar_acessorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 170, -1));

        lab_equipar_arma.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lab_equipar_arma.setForeground(new java.awt.Color(204, 204, 204));
        lab_equipar_arma.setText("Equipar arma....");
        pnl_fundo_equipamento.add(lab_equipar_arma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 50));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("( Itens não precisam ser");
        pnl_fundo_equipamento.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 300, -1, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("equipados )");
        pnl_fundo_equipamento.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 320, -1, 20));

        lab_equipar_escudo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lab_equipar_escudo.setForeground(new java.awt.Color(204, 204, 204));
        lab_equipar_escudo.setText("Equipar escudo...");
        pnl_fundo_equipamento.add(lab_equipar_escudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, 50));

        lab_equipar_acessorio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lab_equipar_acessorio.setForeground(new java.awt.Color(204, 204, 204));
        lab_equipar_acessorio.setText("Equipar acessório...");
        pnl_fundo_equipamento.add(lab_equipar_acessorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, 50));

        btn_salvar_itens.setBackground(new java.awt.Color(51, 51, 51));
        btn_salvar_itens.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_salvar_itens.setForeground(new java.awt.Color(204, 204, 204));
        btn_salvar_itens.setText("salvar itens");
        btn_salvar_itens.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salvar_itens.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salvar_itens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar_itensActionPerformed(evt);
            }
        });
        pnl_fundo_equipamento.add(btn_salvar_itens, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, 130, 30));

        btn_salvar_armas.setBackground(new java.awt.Color(51, 51, 51));
        btn_salvar_armas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_salvar_armas.setForeground(new java.awt.Color(204, 204, 204));
        btn_salvar_armas.setText("salvar armas");
        btn_salvar_armas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salvar_armas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salvar_armas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar_armasActionPerformed(evt);
            }
        });
        pnl_fundo_equipamento.add(btn_salvar_armas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 130, 30));

        btn_salvar_escudos.setBackground(new java.awt.Color(51, 51, 51));
        btn_salvar_escudos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_salvar_escudos.setForeground(new java.awt.Color(204, 204, 204));
        btn_salvar_escudos.setText("salvar escudos");
        btn_salvar_escudos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salvar_escudos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salvar_escudos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar_escudosActionPerformed(evt);
            }
        });
        pnl_fundo_equipamento.add(btn_salvar_escudos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 130, 30));

        btn_salvar_acessorios.setBackground(new java.awt.Color(51, 51, 51));
        btn_salvar_acessorios.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_salvar_acessorios.setForeground(new java.awt.Color(204, 204, 204));
        btn_salvar_acessorios.setText("salvar acessórios");
        btn_salvar_acessorios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salvar_acessorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salvar_acessorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar_acessoriosActionPerformed(evt);
            }
        });
        pnl_fundo_equipamento.add(btn_salvar_acessorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 160, 30));

        tabbed_informacoes.addTab("Equipamento", pnl_fundo_equipamento);

        pnl_fundo_sprites.setBackground(new java.awt.Color(23, 0, 0));
        pnl_fundo_sprites.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_fundo_sprites.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_fundo_perfil.setBackground(new java.awt.Color(51, 51, 51));
        pnl_fundo_perfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnl_fundo_sprites.add(pnl_fundo_perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 220, 220));

        btn_selecionar_perfil.setBackground(new java.awt.Color(51, 51, 51));
        btn_selecionar_perfil.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_selecionar_perfil.setForeground(new java.awt.Color(255, 255, 255));
        btn_selecionar_perfil.setText("Selecionar");
        btn_selecionar_perfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_selecionar_perfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_selecionar_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selecionar_perfilActionPerformed(evt);
            }
        });
        pnl_fundo_sprites.add(btn_selecionar_perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 317, 120, 30));

        jPanel6.setBackground(new java.awt.Color(49, 60, 81));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_titulo_sprites.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lab_titulo_sprites.setForeground(new java.awt.Color(204, 204, 204));
        lab_titulo_sprites.setText("Escolha as imagens para cada sprite do personagem. Somente a imagem do perfil é obrigatória!!!");
        jPanel6.add(lab_titulo_sprites, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 820, 40));

        pnl_fundo_sprites.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        lab_perfil.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lab_perfil.setForeground(new java.awt.Color(204, 204, 204));
        lab_perfil.setText("IMAGEM DO PERFIL");
        pnl_fundo_sprites.add(lab_perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 45, -1, 40));

        lab_perfil_imagem.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_perfil_imagem.setForeground(new java.awt.Color(204, 204, 204));
        lab_perfil_imagem.setText("foto aqui");
        pnl_fundo_sprites.add(lab_perfil_imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 80, 30));

        tabbed_informacoes.addTab("Sprites (PNGs)", pnl_fundo_sprites);

        getContentPane().add(tabbed_informacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 950, 410));

        btn_voltar.setBackground(new java.awt.Color(51, 51, 51));
        btn_voltar.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        btn_voltar.setForeground(new java.awt.Color(204, 204, 204));
        btn_voltar.setText("Voltar");
        btn_voltar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, 190, 50));

        lab_fundo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Patrick\\Pictures\\Background menu RPG.jpg")); // NOI18N
        getContentPane().add(lab_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 60, 990, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        super.dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_salvar_armasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvar_armasActionPerformed
         
         List<String> armas_selecionadas = list_armas.getSelectedValuesList();
         
         if( !armas_selecionadas.isEmpty() ){ 
                this.list_armas.setEnabled(false);
                
                String[] armas = armas_selecionadas.toArray( new String[0] );
                DefaultComboBoxModel dcbm = new DefaultComboBoxModel( armas );
                this.combo_equipar_arma.setModel(dcbm);

                this.btn_salvar_armas.setEnabled(false);
                this.lab_equipar_arma.setVisible(true);
                this.combo_equipar_arma.setVisible(true);
            
         }else{
              JOptionPane.showMessageDialog(null, "Por favor, selecione pelo menos uma arma da lista!!!", "Error!!!", JOptionPane.ERROR_MESSAGE);                 
         }
    }//GEN-LAST:event_btn_salvar_armasActionPerformed

    
    
    private void btn_salvar_escudosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvar_escudosActionPerformed
        
        List<String> escudos_selecionados = list_escudos.getSelectedValuesList();
         
        if( !escudos_selecionados.isEmpty() ){ 
            
                this.list_escudos.setEnabled(false);

                String[] escudos = escudos_selecionados.toArray( new String[0] );
                DefaultComboBoxModel dcbm = new DefaultComboBoxModel( escudos );
                this.combo_equipar_escudo.setModel(dcbm);

                this.btn_salvar_escudos.setEnabled(false);
                this.lab_equipar_escudo.setVisible(true);
                this.combo_equipar_escudo.setVisible(true);
            
        }else{
                JOptionPane.showMessageDialog(null, "Por favor, selecione pelo menos 1 escudo da lista!!!", "Error!!!", JOptionPane.ERROR_MESSAGE);                 
        }
        
    }//GEN-LAST:event_btn_salvar_escudosActionPerformed

    
    
    //forma mais simples
    private void btn_salvar_acessoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvar_acessoriosActionPerformed
       
         List<String> acessorios_selecionados = list_acessorios.getSelectedValuesList(); // pegando acessorios selecionados
         
         if( acessorios_selecionados.size() != 0){ 
             
                this.list_acessorios.setEnabled(false);
             
                this.combo_equipar_acessorio.setModel( // inserindo valores selecionados para dentro do combo-box
                       new DefaultComboBoxModel( // recebe array de String[]
                                   acessorios_selecionados.toArray( new String[0] ) // convertendo lista List<String> com o metodo "toArray()", o qual retorna Strin[]
                       )
                );

                this.btn_salvar_acessorios.setEnabled(false);
                this.lab_equipar_acessorio.setVisible(true);
                this.combo_equipar_acessorio.setVisible(true);
            
         }else{
              JOptionPane.showMessageDialog(null, "Por favor, selecione pelo menos 1 acessório da lista!!!", "Error!!!", JOptionPane.ERROR_MESSAGE);                 
         }
    }//GEN-LAST:event_btn_salvar_acessoriosActionPerformed

    
    
    private void btn_salvar_itensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvar_itensActionPerformed
         
         List<String> itens_selecionados = list_itens.getSelectedValuesList();
         
         if( !itens_selecionados.isEmpty() ) 
              this.list_itens.setEnabled(false);
         else
              JOptionPane.showMessageDialog(null, "Por favor, selecione pelo menos 1 item da lista!!!", "Error!!!", JOptionPane.ERROR_MESSAGE);                      
    }//GEN-LAST:event_btn_salvar_itensActionPerformed

    
    
    // BOTAO PRINCIPAL - SALVAR TUDO (ATRIBUTOS, EQUIPAMENTOS E FOTO DO PERFIL DO PERSONAGEM)
    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed

         String hp_max = this.spn_HP_max.getValue().toString();
         String mp_max = this.spn_MP_max.getValue().toString();
         
        
         if( hp_max==" " || hp_max=="0"){
               JOptionPane.showMessageDialog(null, "O campo 'HP máximo' é obrigatório !!!", "Error!!!", JOptionPane.ERROR_MESSAGE);                 
        
         }else if( mp_max==" " || mp_max=="0" ){
               JOptionPane.showMessageDialog(null, "O campo 'MP máximo' é obrigatório !!!", "Error!!!", JOptionPane.ERROR_MESSAGE);                 
         
         }else if( this.combo_classe.getSelectedIndex() != 0 ){ // É TRUE CASO O ITEM SELECIONADO NAO SEJA O PRIMEIRO, O QUAL TEM VALOR "Selecione"
              ClasseDAO clasDAO = new ClasseDAO();
              String spriteEncoded = null;// STRING QUE ARMAZENA IMAGEM NO FORMATO "base64"
             
 //================================================================================================================
              
              // OBTENDO O ID DA CLASSE SELECIONADA:
              int id_classe_selecionada = clasDAO.obter_classe_por_nome( 
                                                 this.combo_classe.getSelectedItem().toString()
                                           );
              
              System.out.println("ID da classe selecionada: "+ id_classe_selecionada );
             
              
              // CAPTURANDO OS DADOS DA IMAGEM DE PERFIL DO PERSONAGEM CASO ELE SEJA INSERIDO
             // if ( this.pnl_fundo_perfil.getComponents().length == 1 ){  }
             
             
             
//======================= ENCRIPTANDO IMAGEM PARA ARMAZENAMENTO NO BANCO DE DADOS ===========================================================================
             

 //      VERIFICANDO SE ALGUMA IMAGEM FOI INSERIDA PARA O PERFIL DO PERSONAGEM
             if( (this.pnl_fundo_perfil.getComponents().length !=0) 
                  && (this.imagemPerfilPersonagem != null)  ){
                    
                 
                         try{
             
                                byte[] imagemBytes = FileUtils.readFileToByteArray( this.imagemPerfilPersonagem );

                                String base64ImageFormat = Base64.getEncoder().encodeToString( imagemBytes);

                                spriteEncoded = base64ImageFormat;
                                
                         }catch(IOException ioe){
                                System.out.println("Houve um erro de conversao da imagem em bytes.....");
                                ioe.printStackTrace();
                         }
                           
                            // OU:
                            // ByteStreams.toByteArray(InputStream is)
                            // IOUtils.toByteArray(InputStream input) 
                         //    try{ byte[] imageBytes = IOUtils.toByteArray( new URL( this.imagemPerfilPersonagem.getAbsolutePath()  ) );                    
                      //       }catch(MalformedURLException mfURLe){}; 
             }
             
             
             
          
 //=================================== CADASTRO DO PERSONAGEM =============================================================================
 
              PersonagemDAO personDAO = new PersonagemDAO();
              
              int id_novo_personagem = personDAO.adicionar_personagem(
                      
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
                               spriteEncoded,
                                Integer.parseInt( this.txt_destreza.getText()),
                                 Integer.parseInt( this.txt_forca.getText()),
                                  Integer.parseInt( this.spn_HP_atual.getValue().toString() ),
                                   Integer.parseInt( this.spn_MP_atual.getValue().toString() )
              
              );
              
              System.out.println("ID do personagem cadastrado: "+ id_novo_personagem );
             
              
            
//================================= CADASTRO DE EQUIPAMENTOS DO PERSONAGEM =========================================================================       
       
              Personagem_Equipamento_DAO personEquipDAO = new Personagem_Equipamento_DAO();

              // CADASTRANDO O "ID" DO PERSONAGEM, "ID DOS ESCUDOS SELECIONADOS" E QUAL ESCUDO FOI EQUIPADO

              // SE UM DETERMINADO BOTAO NAO ESTIVER HABILITADO ENTAO ALGUNS ITENS DA LISTA FORAM SELECIONADOS
              if( !this.btn_salvar_armas.isEnabled() ){
                  
                        String armaSelecionada = this.combo_equipar_arma.getSelectedItem().toString();

                        for( String nomeArma : this.list_armas.getSelectedValuesList()){

                              int id_arma = personEquipDAO.obter_id_equipamento_por_nome(nomeArma, "arma");

                              if( nomeArma.equals(armaSelecionada) )
                                  personEquipDAO.add_equipamentos_personagem(id_novo_personagem, id_arma, true, 1, "arma");
                              else
                                  personEquipDAO.add_equipamentos_personagem(id_novo_personagem, id_arma, false, 1, "arma");
                        }
             
                        
              } if( !this.btn_salvar_escudos.isEnabled() ){
                        String escudoSelecionado = this.combo_equipar_escudo.getSelectedItem().toString();

                        for( String nomeEscudo : this.list_escudos.getSelectedValuesList()){

                              int id_escudo = personEquipDAO.obter_id_equipamento_por_nome(nomeEscudo, "escudo");

                              if( nomeEscudo.equals(escudoSelecionado) )
                                  personEquipDAO.add_equipamentos_personagem(id_novo_personagem, id_escudo, true, 1, "escudo");
                              else
                                  personEquipDAO.add_equipamentos_personagem(id_novo_personagem, id_escudo, false, 1, "escudo");
                        }
                  
                  
              } if( !this.btn_salvar_acessorios.isEnabled() ){
                        String acessorioSelecionado = this.combo_equipar_acessorio.getSelectedItem().toString();
                        
                        for( String nomeAcessorio : this.list_acessorios.getSelectedValuesList() ){
                              
                               int id_acessorio = personEquipDAO.obter_id_equipamento_por_nome(nomeAcessorio, "acessorio");
                               System.out.println("nome do acessorio: "+nomeAcessorio+" \n ID: "+ id_acessorio);
                               
                               if( nomeAcessorio.equals(acessorioSelecionado) )
                                   personEquipDAO.add_equipamentos_personagem(id_novo_personagem, id_acessorio, true, 1, "acessorio");
                               else
                                   personEquipDAO.add_equipamentos_personagem(id_novo_personagem, id_acessorio, false, 1, "acessorio");
                        }
                  
                 
              } if( !this.btn_salvar_itens.isEnabled() ){
                        
                        for(String nomeItem : this.list_itens.getSelectedValuesList() ){

                               int id_item = personEquipDAO.obter_id_equipamento_por_nome(nomeItem, "item");
                               personEquipDAO.add_itens_personagem(id_novo_personagem, id_item, 1);
                        }
                        
              }
 
              
    /* 
             Component[] inputsValues = this.pnl_fundo_atributos.getComponents();
             for( int c=0; c<inputsValues.length; c++ ){
                System.out.println("Nome: "+inputsValues[c].getClass().getName());
             }
    */
         }else{ 
                JOptionPane.showMessageDialog(null, "Por favor selecione uma classe para o personagem!!!", "Error!!!", JOptionPane.ERROR_MESSAGE);                 
         }
        
    }//GEN-LAST:event_btn_salvarActionPerformed

    
    
    // BOTAO DE SALAR IMAGEM
    private void btn_selecionar_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selecionar_perfilActionPerformed
         BufferedImage imagemImportada = null; //BufferedImage estende de "Image"

         /*  // ERRO DE IMPORTACAO DE IMAGEM EM LAYOUT ABSOLUTO:
         
            Exception in thread "AWT-EventQueue-0" java.lang.IllegalArgumentException
                at org.netbeans.lib.awtextra.AbsoluteLayout.addLayoutComponent(Unknown Source)
         */
         
         
         try{
                JFileChooser imagemSelecionada = new JFileChooser();// janela de escolha do arquivo/imagem

                if( imagemSelecionada.showOpenDialog(this) == JFileChooser.APPROVE_OPTION ){

                    imagemImportada = ImageIO.read( // retorna um "BufferedImage"
                                  imagemSelecionada.getSelectedFile()// retorna um "File"
                    );
                    
                    this.imagemPerfilPersonagem = imagemSelecionada.getSelectedFile();
                }
       
         }catch(IOException ioe){ 
                System.out.println("\n Houve um erro na importação da imagem..... ");
                ioe.printStackTrace(); 
         }
         //Exception in thread "AWT-EventQueue-0" java.lang.IllegalArgumentException: input == null!
        
         // REDIMENSIONANDO A IMAGEM:
         Image imagemRedimensionada  = (imagemImportada).getScaledInstance(240, 240, Image.SCALE_DEFAULT);
         //BufferedImage bufImage = (BufferedImage) imagemRedimensionada; // NAO PRECISA, MAS TBM FUNCIONA!
        
         
       
         JLabel imagem = new JLabel( new ImageIcon (imagemRedimensionada) ); 

         Dimension tamanhoImagem = new Dimension( this.pnl_fundo_perfil.getWidth(), this.pnl_fundo_perfil.getHeight() );
         imagem.setSize(tamanhoImagem);
         imagem.setPreferredSize(tamanhoImagem);
         imagem.setMinimumSize(tamanhoImagem);
         imagem.setMaximumSize(tamanhoImagem);
         imagem.setLocation(0, 0);
         imagem.setBounds(0, 0, this.pnl_fundo_perfil.getWidth(), this.pnl_fundo_perfil.getHeight());

         this.pnl_fundo_perfil.add(imagem, 0); 
    }//GEN-LAST:event_btn_selecionar_perfilActionPerformed
    
        //     this.lab_perfil_imagem.setIcon( // ImageIcon é a classe q implementa a interface "Icon"
    //              new ImageIcon( imagemImportada ) // ImageIcon recebe "BufferedImage" ou "Image"
   //     );
   
        
        /*
            ImageLabel imagem = new ImageLabel(
                 // new ImageIcon( imagemImportada )
                   //    .getImage()
            );
        */
       
        /*   // FUNCIONA MAIS A IMAGEM NAO É REDIMENSIONADA:
           ImageLabel imagem = new ImageLabel();
           imagem.setIcon( new ImageIcon( imagemImportada ) );
           imagem.width = this.pnl_fundo_perfil.getWidth();
           imagem.height= this.pnl_fundo_perfil.getHeight();
           imagem.setLocation(0, 0);
           imagem.setText("importando imagem.....");
           */

     
        /*  // NAO FUNCIONOU:
           JLabel imagem = new JLabel( new ImageIcon( imagemImportada ));
           imagem.setMaximumSize( this.pnl_fundo_perfil.getSize() );
           imagem.setMinimumSize( this.pnl_fundo_perfil.getSize() );
           imagem.setSize( this.pnl_fundo_perfil.getSize() );
           imagem.setBounds(0, 0, this.pnl_fundo_perfil.getWidth(), this.pnl_fundo_perfil.getHeight());
           imagem.setLocation(0, 0);
       */
    
    
    
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
            java.util.logging.Logger.getLogger(CadastroPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPersonagem().setVisible(true);
            }
        });
    }
    
    
    
    
    
    
/*
    private class ImageLabel extends JLabel{
    
         private Image imageIcon;
         int width;
         int height;
         JFrame context;
         
    
         public ImageLabel(JFrame context_this){ 
             this.context = context_this;
         };
         
         public ImageLabel(){
             this.setLayout( new BorderLayout() );
         };
         
         public ImageLabel(String url){
             super(url);
         }
         
         public void setIcon(Icon icon){
          //   super.setIcon(icon);
            
             if( icon instanceof ImageIcon){
                  System.out.println("imagem convertida para Image");
                  this.imageIcon = ((ImageIcon) icon).getImage();// metodo "getImage" so eh acessivel pela classe "ImageIcon"
             }
         }
         
         @Override
         public void paintComponent(Graphics g){
             super.paintComponent(g);
             g.drawImage(this.imageIcon, 0, 0, this.width, this.height, null);
         }
    
    }
*/
    
    

    // String avg[] = new String[]{"dwdwd", "dwdwd"};

    // cor azul de fundo para pnl:  [13,17,25]

      /* // TESTANDO LAMBDA

      Pessoa pes = new Pessoa(){

          @Override
          public short getIdade(){
              return 1;
          }

      };

      // OU:
      //  Pessoa pes = (short b) -> (short) (b+1);

      */
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_salvar;
    private javax.swing.JButton btn_salvar_acessorios;
    private javax.swing.JButton btn_salvar_armas;
    private javax.swing.JButton btn_salvar_escudos;
    private javax.swing.JButton btn_salvar_itens;
    private javax.swing.JButton btn_selecionar_perfil;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JComboBox<String> combo_classe;
    private javax.swing.JComboBox<String> combo_equipar_acessorio;
    private javax.swing.JComboBox<String> combo_equipar_arma;
    private javax.swing.JComboBox<String> combo_equipar_escudo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lab_HP_atual;
    private javax.swing.JLabel lab_HP_max;
    private javax.swing.JLabel lab_MP_atual;
    private javax.swing.JLabel lab_MP_max;
    private javax.swing.JLabel lab_XP;
    private javax.swing.JLabel lab_atk;
    private javax.swing.JLabel lab_classe;
    private javax.swing.JLabel lab_def;
    private javax.swing.JLabel lab_destreza;
    private javax.swing.JLabel lab_equipar_acessorio;
    private javax.swing.JLabel lab_equipar_arma;
    private javax.swing.JLabel lab_equipar_escudo;
    private javax.swing.JLabel lab_evasao;
    private javax.swing.JLabel lab_forca;
    private javax.swing.JLabel lab_fundo;
    private javax.swing.JLabel lab_level;
    private javax.swing.JLabel lab_nome;
    private javax.swing.JLabel lab_perfil;
    private javax.swing.JLabel lab_perfil_imagem;
    private javax.swing.JLabel lab_sp_atk;
    private javax.swing.JLabel lab_sp_def;
    private javax.swing.JLabel lab_titulo;
    private javax.swing.JPanel lab_titulo_fundo;
    private javax.swing.JLabel lab_titulo_sprites;
    private javax.swing.JLabel lab_velocidade;
    private javax.swing.JList<String> list_acessorios;
    private javax.swing.JList<String> list_armas;
    private javax.swing.JList<String> list_escudos;
    private javax.swing.JList<String> list_itens;
    private javax.swing.JPanel pnl_fundo_atributos;
    private javax.swing.JPanel pnl_fundo_equipamento;
    private javax.swing.JPanel pnl_fundo_perfil;
    private javax.swing.JPanel pnl_fundo_sprites;
    private javax.swing.JSpinner spn_HP_atual;
    private javax.swing.JSpinner spn_HP_max;
    private javax.swing.JSpinner spn_MP_atual;
    private javax.swing.JSpinner spn_MP_max;
    private javax.swing.JTabbedPane tabbed_informacoes;
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
