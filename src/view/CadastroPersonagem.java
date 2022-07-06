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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Acessorio;
import model.Arma;
import model.Classe;
import model.Escudo;
import model.Item;

/**
 *
 * @author Patrick
 */

/*
interface Pessoa{
    public short getIdade();

}
*/
public class CadastroPersonagem extends javax.swing.JFrame {

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
        
        
        try { 
   // ===================== lista de classes para o personagem ==================================
            
                List<Classe> classes = classeDAO.obter_classes();
                String[] classeNames = new String[classes.size()];
                
                int contador=0;

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
                
                
                DefaultComboBoxModel dtm = new DefaultComboBoxModel( new String[]{"Nenhum"});// combo vazio
                
                this.list_armas.addListSelectionListener(
                        
                       new ListSelectionListener(){ // classe anonima que implementa interface "ListSelectionListener"
                            
                            @Override
                            public void valueChanged(ListSelectionEvent e) {
                                    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                    List<String> items_selecionados = list_armas.getSelectedValuesList();
                                    String[] itens = items_selecionados.toArray(new String[0]);
                                    
                                    
                               //     for( String ite : items_selecionados){
                                           System.out.println("nome do ultimo item: "+itens[itens.length-1]);
                                           
                                          
                                           combo_equipar_arma.setModel( dtm );
                                        
                                           combo_equipar_arma.addItem( itens[itens.length-1] );
                                  //  }
                            }
                
                });
   
                
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
        }
        
      
       
        
        
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
        jLabel25 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        pnl_fundo_sprites = new javax.swing.JPanel();
        pnl_fundo_perfil = new javax.swing.JPanel();
        lab_perfil_imagem = new javax.swing.JLabel();
        btn_selecionar_perfil = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lab_titulo_sprites = new javax.swing.JLabel();
        lab_perfil = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lab_frente_imagem = new javax.swing.JLabel();
        lab_sprite_lateral_esquerda = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lab_costas_imagem = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lab_esquerdo_imagem = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lab_direito_imagem = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btn_selecionar_frente = new javax.swing.JButton();
        btn_selecionar_costas = new javax.swing.JButton();
        btn_selecionar_lado_esquerdo = new javax.swing.JButton();
        btn_selecionar_lado_direito = new javax.swing.JButton();
        pnl_fundo_sprites2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        lab_frente_url = new javax.swing.JLabel();
        txt_frente_url = new javax.swing.JTextField();
        lab_costas_url = new javax.swing.JLabel();
        lab_esquerda_url = new javax.swing.JLabel();
        lab_direita_url = new javax.swing.JLabel();
        txt_costas_url = new javax.swing.JTextField();
        txt_esquerda_url = new javax.swing.JTextField();
        txt_direita_url = new javax.swing.JTextField();
        lab_perfil_url = new javax.swing.JLabel();
        txt_perfil_url = new javax.swing.JTextField();
        pnl_imagem_url = new javax.swing.JPanel();
        lab_imagem = new javax.swing.JLabel();
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
        getContentPane().add(btn_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 190, 50));

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
        txt_nome.setBorder(null);
        txt_nome.setMargin(new java.awt.Insets(5, 10, 5, 5));
        pnl_fundo_atributos.add(txt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 85, 160, 25));

        lab_level.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_level.setForeground(new java.awt.Color(204, 204, 204));
        lab_level.setText("Level:");
        pnl_fundo_atributos.add(lab_level, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 60, 50));

        txt_level.setBackground(new java.awt.Color(102, 102, 102));
        txt_level.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_level.setForeground(new java.awt.Color(255, 255, 255));
        txt_level.setText("1");
        txt_level.setBorder(null);
        pnl_fundo_atributos.add(txt_level, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 100, 30));

        lab_HP_max.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_HP_max.setForeground(new java.awt.Color(204, 204, 204));
        lab_HP_max.setText("HP Máx.:");
        pnl_fundo_atributos.add(lab_HP_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, 50));

        lab_MP_max.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_MP_max.setForeground(new java.awt.Color(204, 204, 204));
        lab_MP_max.setText("MP Máx.:");
        pnl_fundo_atributos.add(lab_MP_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 110, 50));

        lab_XP.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_XP.setForeground(new java.awt.Color(204, 204, 204));
        lab_XP.setText("XP:");
        pnl_fundo_atributos.add(lab_XP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 50, 50));

        lab_velocidade.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_velocidade.setForeground(new java.awt.Color(204, 204, 204));
        lab_velocidade.setText("Velocidade:");
        pnl_fundo_atributos.add(lab_velocidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 120, 40));

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
        pnl_fundo_atributos.add(lab_destreza, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 100, 50));

        lab_classe.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_classe.setForeground(new java.awt.Color(204, 204, 204));
        lab_classe.setText("Classe:");
        pnl_fundo_atributos.add(lab_classe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 80, 50));

        combo_classe.setBackground(new java.awt.Color(102, 102, 102));
        combo_classe.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        combo_classe.setForeground(new java.awt.Color(255, 255, 255));
        combo_classe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));
        pnl_fundo_atributos.add(combo_classe, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 160, 30));

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
        pnl_fundo_atributos.add(txt_destreza, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 60, 30));

        txt_velocidade.setBackground(new java.awt.Color(102, 102, 102));
        txt_velocidade.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_velocidade.setForeground(new java.awt.Color(255, 255, 255));
        txt_velocidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_fundo_atributos.add(txt_velocidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 60, 30));

        lab_atk.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_atk.setForeground(new java.awt.Color(204, 204, 204));
        lab_atk.setText("ATK:");
        pnl_fundo_atributos.add(lab_atk, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, -1));

        lab_def.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_def.setForeground(new java.awt.Color(204, 204, 204));
        lab_def.setText("DEF:");
        pnl_fundo_atributos.add(lab_def, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, -1, -1));

        lab_sp_def.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_sp_def.setForeground(new java.awt.Color(204, 204, 204));
        lab_sp_def.setText("SP. DEF:");
        pnl_fundo_atributos.add(lab_sp_def, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, -1, -1));

        lab_sp_atk.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_sp_atk.setForeground(new java.awt.Color(204, 204, 204));
        lab_sp_atk.setText("SP. ATK:");
        pnl_fundo_atributos.add(lab_sp_atk, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, -1, -1));

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
        pnl_fundo_atributos.add(spn_HP_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 90, 30));

        spn_MP_max.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pnl_fundo_atributos.add(spn_MP_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 90, 30));

        txt_XP.setBackground(new java.awt.Color(102, 102, 102));
        txt_XP.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_XP.setForeground(new java.awt.Color(255, 255, 255));
        txt_XP.setText("00");
        pnl_fundo_atributos.add(txt_XP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 120, 30));

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
        pnl_fundo_atributos.add(lab_HP_atual, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 60));

        lab_MP_atual.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lab_MP_atual.setForeground(new java.awt.Color(204, 204, 204));
        lab_MP_atual.setText("MP atual:");
        pnl_fundo_atributos.add(lab_MP_atual, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        spn_HP_atual.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pnl_fundo_atributos.add(spn_HP_atual, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 90, 30));

        spn_MP_atual.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pnl_fundo_atributos.add(spn_MP_atual, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 90, 30));

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
        pnl_fundo_equipamento.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel22.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("Escudos");
        pnl_fundo_equipamento.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        jLabel23.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("Acessórios");
        pnl_fundo_equipamento.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, -1, -1));

        jLabel24.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("Itens");
        pnl_fundo_equipamento.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, -1, -1));

        list_armas.setBackground(new java.awt.Color(51, 51, 51));
        list_armas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        list_armas.setForeground(new java.awt.Color(255, 255, 255));
        list_armas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Arma 1" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_armas.setToolTipText("");
        list_armas.setSelectionBackground(new java.awt.Color(204, 0, 51));
        jScrollPane1.setViewportView(list_armas);

        pnl_fundo_equipamento.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 160, 140));

        list_escudos.setBackground(new java.awt.Color(51, 51, 51));
        list_escudos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        list_escudos.setForeground(new java.awt.Color(255, 255, 255));
        list_escudos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Escudo 1" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_escudos.setSelectionBackground(new java.awt.Color(204, 0, 51));
        jScrollPane2.setViewportView(list_escudos);

        pnl_fundo_equipamento.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 160, 140));

        list_acessorios.setBackground(new java.awt.Color(51, 51, 51));
        list_acessorios.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        list_acessorios.setForeground(new java.awt.Color(255, 255, 255));
        list_acessorios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Acessorio 1" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_acessorios.setSelectionBackground(new java.awt.Color(204, 0, 51));
        jScrollPane3.setViewportView(list_acessorios);

        pnl_fundo_equipamento.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 150, 140));

        list_itens.setBackground(new java.awt.Color(51, 51, 51));
        list_itens.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        list_itens.setForeground(new java.awt.Color(255, 255, 255));
        list_itens.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_itens.setSelectionBackground(new java.awt.Color(204, 0, 51));
        jScrollPane4.setViewportView(list_itens);

        pnl_fundo_equipamento.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 150, 140));

        combo_equipar_arma.setBackground(new java.awt.Color(51, 51, 51));
        combo_equipar_arma.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        combo_equipar_arma.setForeground(new java.awt.Color(204, 204, 204));
        combo_equipar_arma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhuma" }));
        pnl_fundo_equipamento.add(combo_equipar_arma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 150, 30));

        combo_equipar_escudo.setBackground(new java.awt.Color(51, 51, 51));
        combo_equipar_escudo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        combo_equipar_escudo.setForeground(new java.awt.Color(204, 204, 204));
        combo_equipar_escudo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));
        combo_equipar_escudo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_fundo_equipamento.add(combo_equipar_escudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 140, -1));

        combo_equipar_acessorio.setBackground(new java.awt.Color(51, 51, 51));
        combo_equipar_acessorio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        combo_equipar_acessorio.setForeground(new java.awt.Color(204, 204, 204));
        combo_equipar_acessorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));
        pnl_fundo_equipamento.add(combo_equipar_acessorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 120, -1));

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("Equipar arma....");
        pnl_fundo_equipamento.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 50));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("( Itens não precisam ser");
        pnl_fundo_equipamento.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, -1, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("equipados )");
        pnl_fundo_equipamento.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, -1, 20));

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setText("Equipar escudo...");
        pnl_fundo_equipamento.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 239, -1, 50));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setText("Equipar acessório...");
        pnl_fundo_equipamento.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, -1, 50));

        tabbed_informacoes.addTab("Equipamento", pnl_fundo_equipamento);

        pnl_fundo_sprites.setBackground(new java.awt.Color(23, 0, 0));
        pnl_fundo_sprites.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_fundo_sprites.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_fundo_perfil.setBackground(new java.awt.Color(51, 51, 51));
        pnl_fundo_perfil.setLayout(null);

        lab_perfil_imagem.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_perfil_imagem.setForeground(new java.awt.Color(204, 204, 204));
        lab_perfil_imagem.setText("foto aqui");
        pnl_fundo_perfil.add(lab_perfil_imagem);
        lab_perfil_imagem.setBounds(40, 60, 80, 30);

        pnl_fundo_sprites.add(pnl_fundo_perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 170, 160));

        btn_selecionar_perfil.setBackground(new java.awt.Color(51, 51, 51));
        btn_selecionar_perfil.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_selecionar_perfil.setForeground(new java.awt.Color(255, 255, 255));
        btn_selecionar_perfil.setText("Selecionar");
        btn_selecionar_perfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_selecionar_perfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_fundo_sprites.add(btn_selecionar_perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 120, 30));

        jPanel6.setBackground(new java.awt.Color(49, 60, 81));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_titulo_sprites.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lab_titulo_sprites.setForeground(new java.awt.Color(204, 204, 204));
        lab_titulo_sprites.setText("Escolha as imagens para cada sprite do personagem. Somente a imagem do perfil é obrigatória!!!");
        jPanel6.add(lab_titulo_sprites, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 820, 40));

        pnl_fundo_sprites.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        lab_perfil.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lab_perfil.setForeground(new java.awt.Color(204, 204, 204));
        lab_perfil.setText("PERFIL");
        pnl_fundo_sprites.add(lab_perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, 30));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(null);

        lab_frente_imagem.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_frente_imagem.setForeground(new java.awt.Color(204, 204, 204));
        lab_frente_imagem.setText("foto aqui");
        jPanel5.add(lab_frente_imagem);
        lab_frente_imagem.setBounds(40, 70, 80, 24);

        pnl_fundo_sprites.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 160, 160));

        lab_sprite_lateral_esquerda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lab_sprite_lateral_esquerda.setForeground(new java.awt.Color(204, 204, 204));
        lab_sprite_lateral_esquerda.setText("COSTAS");
        pnl_fundo_sprites.add(lab_sprite_lateral_esquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, 30));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(null);

        lab_costas_imagem.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_costas_imagem.setForeground(new java.awt.Color(204, 204, 204));
        lab_costas_imagem.setText("foto aqui");
        jPanel8.add(lab_costas_imagem);
        lab_costas_imagem.setBounds(40, 70, 90, 24);

        pnl_fundo_sprites.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 170, 160));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("FRENTE");
        pnl_fundo_sprites.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, 30));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(null);

        lab_esquerdo_imagem.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_esquerdo_imagem.setForeground(new java.awt.Color(204, 204, 204));
        lab_esquerdo_imagem.setText("foto aqui");
        jPanel9.add(lab_esquerdo_imagem);
        lab_esquerdo_imagem.setBounds(40, 70, 80, 24);

        pnl_fundo_sprites.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 160, 160));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setLayout(null);

        lab_direito_imagem.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lab_direito_imagem.setForeground(new java.awt.Color(204, 204, 204));
        lab_direito_imagem.setText("foto aqui");
        jPanel10.add(lab_direito_imagem);
        lab_direito_imagem.setBounds(40, 70, 90, 20);

        pnl_fundo_sprites.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 160, 160));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("LADO ESQUERDO");
        pnl_fundo_sprites.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 150, 30));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("LADO DIREITO");
        pnl_fundo_sprites.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 69, -1, 30));

        btn_selecionar_frente.setBackground(new java.awt.Color(51, 51, 51));
        btn_selecionar_frente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_selecionar_frente.setForeground(new java.awt.Color(255, 255, 255));
        btn_selecionar_frente.setText("Selecionar");
        btn_selecionar_frente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_selecionar_frente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_selecionar_frente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selecionar_frenteActionPerformed(evt);
            }
        });
        pnl_fundo_sprites.add(btn_selecionar_frente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 120, 30));

        btn_selecionar_costas.setBackground(new java.awt.Color(51, 51, 51));
        btn_selecionar_costas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_selecionar_costas.setForeground(new java.awt.Color(255, 255, 255));
        btn_selecionar_costas.setText("Selecionar");
        btn_selecionar_costas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_selecionar_costas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_selecionar_costas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_selecionar_costasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_selecionar_costasMouseExited(evt);
            }
        });
        pnl_fundo_sprites.add(btn_selecionar_costas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 120, 30));

        btn_selecionar_lado_esquerdo.setBackground(new java.awt.Color(51, 51, 51));
        btn_selecionar_lado_esquerdo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_selecionar_lado_esquerdo.setForeground(new java.awt.Color(255, 255, 255));
        btn_selecionar_lado_esquerdo.setText("Selecionar");
        btn_selecionar_lado_esquerdo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_selecionar_lado_esquerdo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_fundo_sprites.add(btn_selecionar_lado_esquerdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 120, 30));

        btn_selecionar_lado_direito.setBackground(new java.awt.Color(51, 51, 51));
        btn_selecionar_lado_direito.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_selecionar_lado_direito.setForeground(new java.awt.Color(255, 255, 255));
        btn_selecionar_lado_direito.setText("Selecionar");
        btn_selecionar_lado_direito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_selecionar_lado_direito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_fundo_sprites.add(btn_selecionar_lado_direito, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 120, 30));

        tabbed_informacoes.addTab("Sprites (PNGs)", pnl_fundo_sprites);

        pnl_fundo_sprites2.setBackground(new java.awt.Color(23, 0, 0));
        pnl_fundo_sprites2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(49, 60, 81));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 204, 204));
        jLabel28.setText("Coloque a URL de cada sprite do seu personagem. Certifique-se que a referida imagem é acessível pela URL!");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, -1, 30));

        pnl_fundo_sprites2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        lab_frente_url.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lab_frente_url.setForeground(new java.awt.Color(204, 204, 204));
        lab_frente_url.setText("FRENTE:");
        pnl_fundo_sprites2.add(lab_frente_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        txt_frente_url.setBackground(new java.awt.Color(102, 102, 102));
        txt_frente_url.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_frente_url.setForeground(new java.awt.Color(255, 255, 255));
        pnl_fundo_sprites2.add(txt_frente_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 440, 33));

        lab_costas_url.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lab_costas_url.setForeground(new java.awt.Color(204, 204, 204));
        lab_costas_url.setText("COSTAS:");
        pnl_fundo_sprites2.add(lab_costas_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 60));

        lab_esquerda_url.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lab_esquerda_url.setForeground(new java.awt.Color(204, 204, 204));
        lab_esquerda_url.setText("ESQUERDA:");
        pnl_fundo_sprites2.add(lab_esquerda_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 208, 110, 70));

        lab_direita_url.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lab_direita_url.setForeground(new java.awt.Color(204, 204, 204));
        lab_direita_url.setText("DIREITA:");
        pnl_fundo_sprites2.add(lab_direita_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 280, 80, 30));

        txt_costas_url.setBackground(new java.awt.Color(102, 102, 102));
        txt_costas_url.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_costas_url.setForeground(new java.awt.Color(255, 255, 255));
        pnl_fundo_sprites2.add(txt_costas_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 173, 440, 33));

        txt_esquerda_url.setBackground(new java.awt.Color(102, 102, 102));
        txt_esquerda_url.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_esquerda_url.setForeground(new java.awt.Color(255, 255, 255));
        pnl_fundo_sprites2.add(txt_esquerda_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 228, 440, 33));

        txt_direita_url.setBackground(new java.awt.Color(102, 102, 102));
        txt_direita_url.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_direita_url.setForeground(new java.awt.Color(255, 255, 255));
        pnl_fundo_sprites2.add(txt_direita_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 440, 33));

        lab_perfil_url.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lab_perfil_url.setForeground(new java.awt.Color(204, 204, 204));
        lab_perfil_url.setText("PERFIL:");
        pnl_fundo_sprites2.add(lab_perfil_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, 50));

        txt_perfil_url.setBackground(new java.awt.Color(102, 102, 102));
        txt_perfil_url.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_perfil_url.setForeground(new java.awt.Color(255, 255, 255));
        pnl_fundo_sprites2.add(txt_perfil_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 440, 33));

        pnl_imagem_url.setBackground(new java.awt.Color(51, 51, 51));
        pnl_imagem_url.setLayout(null);

        lab_imagem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lab_imagem.setForeground(new java.awt.Color(204, 204, 204));
        lab_imagem.setText("IMAGEM AQUI");
        pnl_imagem_url.add(lab_imagem);
        lab_imagem.setBounds(50, 100, 140, 30);

        pnl_fundo_sprites2.add(pnl_imagem_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 220, 220));

        tabbed_informacoes.addTab("Sprites (URL)", pnl_fundo_sprites2);

        getContentPane().add(tabbed_informacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 950, 390));

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
        getContentPane().add(btn_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, 190, 50));

        lab_fundo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Patrick\\Pictures\\Background menu RPG.jpg")); // NOI18N
        getContentPane().add(lab_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 990, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        super.dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_selecionar_frenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selecionar_frenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_selecionar_frenteActionPerformed

    private void btn_selecionar_costasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_selecionar_costasMouseEntered
        //  this.btn_selecionar_costas.setBackground( new Color(60,63,65) );
        //  this.btn_selecionar_costas.setBackground( new Color(187,187,187 ));
    }//GEN-LAST:event_btn_selecionar_costasMouseEntered

    private void btn_selecionar_costasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_selecionar_costasMouseExited
        // this.btn_selecionar_costas.setBackground( new Color(51,51,51) );
        //  this.btn_selecionar_costas.setBackground( new Color(255,255,255 ));
    }//GEN-LAST:event_btn_selecionar_costasMouseExited

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_salvar;
    private javax.swing.JButton btn_selecionar_costas;
    private javax.swing.JButton btn_selecionar_frente;
    private javax.swing.JButton btn_selecionar_lado_direito;
    private javax.swing.JButton btn_selecionar_lado_esquerdo;
    private javax.swing.JButton btn_selecionar_perfil;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JComboBox<String> combo_classe;
    private javax.swing.JComboBox<String> combo_equipar_acessorio;
    private javax.swing.JComboBox<String> combo_equipar_arma;
    private javax.swing.JComboBox<String> combo_equipar_escudo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
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
    private javax.swing.JLabel lab_costas_imagem;
    private javax.swing.JLabel lab_costas_url;
    private javax.swing.JLabel lab_def;
    private javax.swing.JLabel lab_destreza;
    private javax.swing.JLabel lab_direita_url;
    private javax.swing.JLabel lab_direito_imagem;
    private javax.swing.JLabel lab_esquerda_url;
    private javax.swing.JLabel lab_esquerdo_imagem;
    private javax.swing.JLabel lab_evasao;
    private javax.swing.JLabel lab_forca;
    private javax.swing.JLabel lab_frente_imagem;
    private javax.swing.JLabel lab_frente_url;
    private javax.swing.JLabel lab_fundo;
    private javax.swing.JLabel lab_imagem;
    private javax.swing.JLabel lab_level;
    private javax.swing.JLabel lab_nome;
    private javax.swing.JLabel lab_perfil;
    private javax.swing.JLabel lab_perfil_imagem;
    private javax.swing.JLabel lab_perfil_url;
    private javax.swing.JLabel lab_sp_atk;
    private javax.swing.JLabel lab_sp_def;
    private javax.swing.JLabel lab_sprite_lateral_esquerda;
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
    private javax.swing.JPanel pnl_fundo_sprites2;
    private javax.swing.JPanel pnl_imagem_url;
    private javax.swing.JSpinner spn_HP_atual;
    private javax.swing.JSpinner spn_HP_max;
    private javax.swing.JSpinner spn_MP_atual;
    private javax.swing.JSpinner spn_MP_max;
    private javax.swing.JTabbedPane tabbed_informacoes;
    private javax.swing.JTextField txt_XP;
    private javax.swing.JTextField txt_atk;
    private javax.swing.JTextField txt_costas_url;
    private javax.swing.JTextField txt_def;
    private javax.swing.JTextField txt_destreza;
    private javax.swing.JTextField txt_direita_url;
    private javax.swing.JTextField txt_esquerda_url;
    private javax.swing.JTextField txt_evasao;
    private javax.swing.JTextField txt_forca;
    private javax.swing.JTextField txt_frente_url;
    private javax.swing.JTextField txt_level;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_perfil_url;
    private javax.swing.JTextField txt_sp_atk;
    private javax.swing.JTextField txt_sp_def;
    private javax.swing.JTextField txt_velocidade;
    // End of variables declaration//GEN-END:variables
}
