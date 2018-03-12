package projetcrypto;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import javax.swing.border.LineBorder;

public class InterfaceGenerClef extends javax.swing.JDialog {
    
    private int jeuDeCarte[];
    private boolean ok;
    private int k = 0;
    private final int N = 54;
    private JPanel tabCarte[];
    private JTextField tabIdCarte[];
    private JToggleButton tabButtonCarte[];
    private JLabel afficheCarte[];
    private static final int[] size = {50,35,17};

    public InterfaceGenerClef(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.ok = false;
        jeuDeCarte = new int[N];
        tabCarte = new JPanel[N];
        tabIdCarte = new JTextField[N];
        tabButtonCarte = new JToggleButton[N];
        afficheCarte = new JLabel[2 * N];
        for(int i = 0; i < N; i++){
            jeuDeCarte[i] = 0;
            afficheCarte[i] = genLabelAff();
            afficheCarte[i + N] = genLabelAff();
            tabCarte[i] = creerPanCarte(new Carte(i + 1));
            panneauCarte.add(tabCarte[i]);
            System.out.print((i + 1) + "");
        }
        for(int i = 0; i< 2 * N; i++)
            affichage.add(afficheCarte[i]);
        
        for(int i = N; i < (N + 13 - (N % 13)); i++)
            panneauCarte.add(new JPanel());
    }
    
    public int getJDC(int i){
        return jeuDeCarte[i];
    }
    
    private void afficheJDC(){
        for(int i = 0 ; i< N; i++)
            System.out.print(jeuDeCarte[i] + " ");
        System.out.println("");
    }
    
    private JLabel genLabelAff(){
        JLabel jlb = new JLabel("", SwingConstants.CENTER);
        jlb.setFont(new Font("Arial",Font.BOLD,12));
        jlb.setPreferredSize(new Dimension(size[2],size[2]));
        jlb.setMaximumSize(new Dimension(size[2],size[2]));
        jlb.setForeground(Color.black);
        return jlb;
    }
    
    private JPanel creerPanCarte(Carte c){
        int valCarte = 0;
        if(c.getValeur() == (N - 1) && c.getElement().equals("Noir"))
            valCarte = c.getValeur();
        else
            valCarte = c.getValeur() - 1;

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        
        tabButtonCarte[valCarte] = new JToggleButton();
        tabButtonCarte[valCarte].setPreferredSize(new Dimension(size[0],size[0]));
        tabButtonCarte[valCarte].setMaximumSize(new Dimension(size[0],size[0]));
        tabButtonCarte[valCarte].setBackground(Color.white);
        tabButtonCarte[valCarte].setFont(new Font("Arial",Font.BOLD,12));
        if(c.getElement() != "Noir" && c.getElement() != "Rouge"){
            tabButtonCarte[valCarte].setIcon(new ImageIcon("img/" + c.getElement() + ".png"));
            tabButtonCarte[valCarte].setText(c.getNom());
            tabButtonCarte[valCarte].setForeground(Color.white);
            tabButtonCarte[valCarte].setBackground(Color.white);
            tabButtonCarte[valCarte].setHorizontalTextPosition(SwingConstants.CENTER);
        }
        else if(c.getElement() == "Noir")
            tabButtonCarte[valCarte].setIcon(new ImageIcon("img/JokerN.png"));
        else
            tabButtonCarte[valCarte].setIcon(new ImageIcon("img/JokerR.png"));            
        
        tabIdCarte[valCarte] = new JTextField();
        tabIdCarte[valCarte].setPreferredSize(new Dimension(size[1],size[2]));
        tabIdCarte[valCarte].setMaximumSize(new Dimension(size[1],size[2]));
        tabIdCarte[valCarte].setBackground(Color.white);
        tabIdCarte[valCarte].setHorizontalAlignment(JTextField.CENTER);
        //tabIdCarte[c.getValeur()].setBorder(new LineBorder(Color.BLACK,20,false));
        tabIdCarte[valCarte].setText("");
        tabIdCarte[valCarte].setFont(new Font("Arial",Font.BOLD,12));
        tabIdCarte[valCarte].setBorder(new LineBorder(Color.gray, 0, true));
        tabIdCarte[valCarte].setEditable(false);
        
        jp.add(tabButtonCarte[valCarte], BorderLayout.CENTER);
        jp.add(tabIdCarte[valCarte],BorderLayout.SOUTH);
         
        tabButtonCarte[valCarte].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JToggleButton jtb = (JToggleButton) e.getSource();
                int valCarte = 0;
                if(c.getValeur() == (N - 1) && c.getElement().equals("Noir"))
                    valCarte = c.getValeur();
                else
                    valCarte = c.getValeur() - 1;
                
                if(jtb.isSelected()){
                    jeuDeCarte[k] = (valCarte + 1);
                    jtb.setForeground(new Color(200,200,200));
                    rempLab(k, new Carte(valCarte + 1), true);
                    if(k < (N))
                        k++;
                    tabIdCarte[valCarte].setText((k) + "");
                    jtb.setBackground(new Color(200,200,200));
                    afficheJDC();
                    tabIdCarte[valCarte].setBackground(new Color(200,200,200));
                }
                else{
                    tabIdCarte[valCarte].setText("");
                    int tmp = 0;
                    while(jeuDeCarte[tmp] != (valCarte + 1))
                        tmp++;
                    for(int i = tmp; i < (k - 1); i++){
                        jeuDeCarte[i] = jeuDeCarte[i + 1];
                        tabIdCarte[(jeuDeCarte[i] - 1)].setText("" + (i + 1));
                    }
                    jeuDeCarte[--k] = 0;
                    rempLab(k, null, false);
                    jtb.setForeground(Color.white);
                    tabIdCarte[valCarte].setBackground(Color.white);
                    afficheJDC();
                    jtb.setBackground(Color.white);
                }
            }
        });        
        return jp;
    }
    
    private void rempLab(int i, Carte c, boolean ok){
        afficheCarte[i].setText("");
        afficheCarte[i].setName("");
        afficheCarte[i + N].setIcon(null);
        afficheCarte[i + N].setName("");
        if(ok){
            afficheCarte[i].setText(c.getNom());
            if(c.getElement() != "Noir" && c.getElement() != "Rouge"){
                ImageIcon icon = new ImageIcon("img/" + c.getElement() + ".png");
                afficheCarte[i + N].setIcon(new ImageIcon(icon.getImage().getScaledInstance(size[2], size[2], Image.SCALE_DEFAULT)));
                afficheCarte[i].setName(""+c.getValeur());
            }
            else if(c.getElement() == "Noir"){
                afficheCarte[i].setText("");
                ImageIcon icon = new ImageIcon("img/JokerN.png");
                afficheCarte[i + N].setIcon(new ImageIcon(icon.getImage().getScaledInstance(size[2], size[2], Image.SCALE_DEFAULT)));
                afficheCarte[i].setName("54");
            }
            else{
                afficheCarte[i].setText("");
                ImageIcon icon = new ImageIcon("img/JokerR.png");
                afficheCarte[i + N].setIcon(new ImageIcon(icon.getImage().getScaledInstance(size[2], size[2], Image.SCALE_DEFAULT)));
                afficheCarte[i].setName(""+c.getValeur());
            }
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        reinit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        annuler = new javax.swing.JButton();
        valider = new javax.swing.JButton();
        affichage = new javax.swing.JPanel();
        bas = new javax.swing.JPanel();
        panneauCarte = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bas.setPreferredSize(new java.awt.Dimension(size[2] * N + N * 2, 500));
        bas.setMaximumSize(new java.awt.Dimension(size[2] * N + N * 2, 500));
        
        jPanel1.setLayout(new java.awt.BorderLayout());

        reinit.setText("Réinitialiser");
        reinit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reinitActionPerformed(evt);
            }
        });
        jPanel1.add(reinit, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        annuler.setText("Annuler");
        annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerActionPerformed(evt);
            }
        });
        jPanel4.add(annuler);

        valider.setText("Valider");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });
        jPanel4.add(valider);

        jPanel1.add(jPanel4, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);
        

        bas.setPreferredSize(new java.awt.Dimension(size[2] * N + N, 3 * size[2]));
        bas.setMaximumSize(new java.awt.Dimension(size[2] * N + N, 3 * size[2]));
        bas.setLayout(new java.awt.BorderLayout());
        
        affichage.setLayout(new java.awt.GridLayout(2, 54, 0, 0));
        bas.add(affichage, java.awt.BorderLayout.NORTH);
        
        jspBas = new JScrollPane(bas);
        
        getContentPane().add(jspBas, java.awt.BorderLayout.PAGE_END);

        panneauCarte.setName("");
        panneauCarte.setPreferredSize(new java.awt.Dimension(size[0] * 13 + size[0], (size[0] + size[2]) * 5 + 5));
        panneauCarte.setMaximumSize(new java.awt.Dimension(size[0] * 13 + size[0]+1, (size[0] + size[2]) * 5 + 6));
        panneauCarte.setLayout(new java.awt.GridLayout(5, 13));
        jspPC = new JScrollPane(panneauCarte);
        getContentPane().add(jspPC, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    private void reinitActionPerformed(java.awt.event.ActionEvent evt) {
        if(JOptionPane.showConfirmDialog(this,"Etes-vous sur de vouloir reinitialiser le code ?","Attention !",JOptionPane.YES_NO_OPTION) == 0){
            for(int i = 0; i < N; i++){
                if(tabButtonCarte[i].isSelected())
                    tabButtonCarte[i].setSelected(false);
                tabIdCarte[i].setText("");
                jeuDeCarte[i] = 0;
                tabButtonCarte[i].setForeground(Color.white);
                tabButtonCarte[i].setBackground(Color.white);
                tabIdCarte[i].setBackground(Color.white);
                rempLab(i, null, false);
            }
            this.k = 0;
        }
    }                                      

    private void annulerActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if(JOptionPane.showConfirmDialog(this,"Etes-vous sur de vouloir annuler ?\ntoute les selections seront perdues.","Attention !",JOptionPane.YES_NO_OPTION) == 0){
            this.setVisible(false);
            this.dispose();
        }
    }                                       

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if(k != (N - 1))
            JOptionPane.showMessageDialog(this,"Le code n'est pas complet.");
        else{
            if(JOptionPane.showConfirmDialog(this,"Etes-vous sur de vouloir valider le code ?","Attention !",JOptionPane.YES_NO_OPTION) == 0){
                this.ok = true;
                for(int i =0; i < N; i++)
                    jeuDeCarte[i] += 1;
                this.setVisible(false);
                this.dispose();
            }
        }
    }                                       

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceGenerClef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGenerClef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGenerClef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGenerClef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceGenerClef dialog = new InterfaceGenerClef(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel affichage;
    private javax.swing.JButton annuler;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel bas;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panneauCarte;
    private javax.swing.JButton reinit;
    private javax.swing.JButton valider;
    private javax.swing.JScrollPane jspBas;
    private javax.swing.JScrollPane jspPC;
    // End of variables declaration                   
}