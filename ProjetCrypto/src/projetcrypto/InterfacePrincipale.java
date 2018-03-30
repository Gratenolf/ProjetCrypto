package projetcrypto;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import javax.swing.border.LineBorder;

public class InterfacePrincipale extends javax.swing.JFrame {
    public final int N = 54;
    private Carte jeuDeCarte[];
    private char lettres[];
    private char clefDeBase[];
    private char clefCourante[];
    public boolean clefNonNulle;
    private CinqEtapes a5;
    private boolean redo;
    private String ancienMess;
    private boolean messADecrypt;
    private boolean genJDC;
    
    private JPanel tabPan[];
    private JPanel tabPanNorth[];
    private JPanel tabPanCenter[];
    private JScrollPane tabJSP[];
    private JPanel tabPNP[];
    private JPanel tabPNPN[];
    private JLabel tabMess[];
    private JLabel tabMessCrypt[];
    
    private int idCourant;
    
    public InterfacePrincipale() {
        initComponents();
        this.setLocationRelativeTo(null);
        myInitComponents();
        this.jeuDeCarte = new Carte[N];
        this.idCourant = 0;
        this.clefNonNulle = false;
        this.ancienMess = "";
        this.messADecrypt = false;
        this.genJDC = false;
    }
    
    private void affGraphCarte(JPanel jp, Carte[] tabCarte){
        JLabel afficheCarte[] = new JLabel[N * 2];
        
        for(int i = 0; i < N * 2; i++)
            afficheCarte[i] = genLabelAff();
                
        for(int i = 0; i < N; i++){
            Carte c = tabCarte[i];
            //System.out.print(" i : " + i + " ");
            afficheCarte[i].setText(c.getNom());
            if(c.getElement() != "Noir" && c.getElement() != "Rouge"){
                ImageIcon icon = new ImageIcon("img/" + c.getElement() + ".png");
                afficheCarte[i + N].setIcon(new ImageIcon(icon.getImage().getScaledInstance(17, 17, Image.SCALE_DEFAULT)));
                afficheCarte[i + N].setName(""+c.getValeur());
            }
            else if(c.getElement() == "Noir"){
                afficheCarte[i].setText("");
                ImageIcon icon = new ImageIcon("img/JokerN.png");
                afficheCarte[i + N].setIcon(new ImageIcon(icon.getImage().getScaledInstance(17, 17, Image.SCALE_DEFAULT)));
                afficheCarte[i + N].setName("54");
            }
            else{
                afficheCarte[i].setText("");
                ImageIcon icon = new ImageIcon("img/JokerR.png");
                afficheCarte[i + N].setIcon(new ImageIcon(icon.getImage().getScaledInstance(17, 17, Image.SCALE_DEFAULT)));
                afficheCarte[i + N].setName(""+c.getValeur());
            }
        }
        jp.removeAll();
        
        for(int i = 0; i < N * 2; i++)
            jp.add(afficheCarte[i]);
        
        jp.repaint();
        jp.revalidate();
    }
    
        
    private JLabel genLabelAff(){
        JLabel jlb = new JLabel("", SwingConstants.CENTER);
        jlb.setFont(new Font("Arial",Font.BOLD,12));
        jlb.setPreferredSize(new Dimension(17,17));
        jlb.setMaximumSize(new Dimension(17,17));
        jlb.setForeground(Color.black);
        jlb.setBackground(Color.red);
        return jlb;
    }
    
    private void logAnPol(){
        affGraphCarte(this.tabPNPN[this.idCourant], this.a5.getJDC());
        this.tabMess[idCourant].setText(this.messCrypt.getText());
        this.tabMessCrypt[idCourant].setText(a5.getMessCrypt()+"\n");
        this.tabPan[idCourant++].setVisible(true);
    }

    private void myInitComponents(){        
        this.panGraphCarte.setLayout(new java.awt.GridLayout(2, N));
        this.jPanelN.setPreferredSize(new java.awt.Dimension(17 * N + N, 3 * 17));
        this.jPanelN.setMaximumSize(new java.awt.Dimension(17 * N + N, 3 * 17));
        
        this.originalJDCN.setLayout(new java.awt.GridLayout(2, N));        
        this.originalJDC.setPreferredSize(new java.awt.Dimension(17 * N + N, 3 * 17));
        this.originalJDC.setMaximumSize(new java.awt.Dimension(17 * N + N, 3 * 17));
        
        this.tabPan = new JPanel[N];
        this.tabJSP = new JScrollPane[N];
        this.tabPanNorth = new JPanel[N];
        this.tabPanCenter = new JPanel[N];
        this.tabPNP = new JPanel[N];
        this.tabPNPN = new JPanel[N];
        this.tabMess = new JLabel[N];
        this.tabMessCrypt = new JLabel[N];
        
        for(int i =0; i < N; i++){
            this.tabPan[i] = new JPanel(new java.awt.BorderLayout());
            this.tabPanNorth[i] = new JPanel(new java.awt.BorderLayout());
            this.tabPanCenter[i] = new JPanel(new java.awt.GridLayout(4,1));
            this.tabPNP[i] = new JPanel(new java.awt.BorderLayout());
            this.tabPNPN[i] = new JPanel(new java.awt.GridLayout(2,N));
            this.tabMess[i] = new JLabel("");
            this.tabMessCrypt[i] = new JLabel("");
            
            this.tabPNP[i].setPreferredSize(new Dimension(N*17 + N, 3 * 17));
            this.tabPNP[i].setMaximumSize(new Dimension(N*17 + N, 3 * 17));
            
            this.tabPanNorth[i].add(new JLabel("Ordre des cartes :"), java.awt.BorderLayout.NORTH);
            this.tabJSP[i] = new JScrollPane(this.tabPNP[i]);
            this.tabJSP[i].setPreferredSize(new Dimension(18 * 17 + 18, 4 * 17));
            this.tabJSP[i].setMaximumSize(new Dimension(21 * 17 + 21, 4 * 17));
            this.tabJSP[i].setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            this.tabPNP[i].add(this.tabPNPN[i],java.awt.BorderLayout.NORTH);
            this.tabPanNorth[i].add(this.tabJSP[i],java.awt.BorderLayout.CENTER);
            
            this.tabPanCenter[i].add(new JLabel("Message courant :"));
            this.tabPanCenter[i].add(this.tabMess[i]);
            this.tabPanCenter[i].add(new JLabel("Message crypté courant :"));
            this.tabPanCenter[i].add(this.tabMessCrypt[i]);
            
            this.tabPan[i].add(this.tabPanNorth[i],java.awt.BorderLayout.NORTH);
            this.tabPan[i].add(this.tabPanCenter[i],java.awt.BorderLayout.CENTER);
            
            this.centerAff.setLayout(new java.awt.GridLayout(N,1));
            
            this.centerAff.add(this.tabPan[i]);
            
            this.tabPan[i].setVisible(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CentreMod = new javax.swing.JPanel();
        i_head = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        randClef = new javax.swing.JButton();
        defClef = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        i_foot = new javax.swing.JPanel();
        decrypter = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        decMess = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        decMessSous = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        decMessFinal = new javax.swing.JLabel();
        i_body = new javax.swing.JPanel();
        ordrCarte = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ordreCourantCarte = new javax.swing.JScrollPane();
        jPanelN = new javax.swing.JPanel();
        panGraphCarte = new javax.swing.JPanel();
        messAndData = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        messCrypt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        crypter = new javax.swing.JButton();
        cryptManu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        messageCrpt = new javax.swing.JLabel();
        AffichageGeneral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        centerAff = new javax.swing.JPanel();
        topAff = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        originalJDC = new javax.swing.JPanel();
        originalJDCN = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        CentreMod.setLayout(new java.awt.BorderLayout());

        i_head.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        randClef.setText("Aléatoire");
        randClef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randClefActionPerformed(evt);
            }
        });
        jPanel5.add(randClef);

        defClef.setText("Définir");
        defClef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defClefActionPerformed(evt);
            }
        });
        jPanel5.add(defClef);

        i_head.add(jPanel5, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Définition de l'ordre initial des cartes :");
        i_head.add(jLabel1, java.awt.BorderLayout.NORTH);

        CentreMod.add(i_head, java.awt.BorderLayout.PAGE_START);

        i_foot.setLayout(new java.awt.BorderLayout());

        decrypter.setText("Décrypter");
        decrypter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decrypterMouseClicked(evt);
            }
        });
        i_foot.add(decrypter, java.awt.BorderLayout.NORTH);

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 150));
        jPanel2.setPreferredSize(new java.awt.Dimension(98, 150));
        jPanel2.setLayout(new java.awt.GridLayout(6, 0));

        jLabel3.setText("Message crypté :");
        jPanel2.add(jLabel3);
        jPanel2.add(decMess);

        jLabel8.setText("Soustraction :");
        jPanel2.add(jLabel8);
        jPanel2.add(decMessSous);

        jLabel10.setText("Message :");
        jPanel2.add(jLabel10);
        jPanel2.add(decMessFinal);

        i_foot.add(jPanel2, java.awt.BorderLayout.CENTER);

        CentreMod.add(i_foot, java.awt.BorderLayout.PAGE_END);

        i_body.setLayout(new java.awt.BorderLayout());

        ordrCarte.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Ordre courant des cartes :");
        jLabel4.setMaximumSize(new java.awt.Dimension(188, 25));
        jLabel4.setPreferredSize(new java.awt.Dimension(188, 25));
        ordrCarte.add(jLabel4, java.awt.BorderLayout.NORTH);

        ordreCourantCarte.setToolTipText("");
        ordreCourantCarte.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ordreCourantCarte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanelN.setLayout(new java.awt.BorderLayout());

        panGraphCarte.setMaximumSize(new java.awt.Dimension(32767, 37));
        panGraphCarte.setPreferredSize(new java.awt.Dimension(10, 37));
        panGraphCarte.setLayout(new java.awt.GridLayout(1, 0));
        jPanelN.add(panGraphCarte, java.awt.BorderLayout.NORTH);

        ordreCourantCarte.setViewportView(jPanelN);

        ordrCarte.add(ordreCourantCarte, java.awt.BorderLayout.CENTER);

        i_body.add(ordrCarte, java.awt.BorderLayout.NORTH);

        messAndData.setMaximumSize(new java.awt.Dimension(32767, 150));
        messAndData.setPreferredSize(new java.awt.Dimension(388, 150));
        messAndData.setLayout(new java.awt.GridLayout(5, 1));

        jLabel6.setText("Message à crypter : ");
        jLabel6.setMaximumSize(new java.awt.Dimension(145, 25));
        jLabel6.setPreferredSize(new java.awt.Dimension(145, 25));
        messAndData.add(jLabel6);
        messAndData.add(messCrypt);

        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 25));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        crypter.setText("Cryptage automatique");
        crypter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crypterMouseClicked(evt);
            }
        });
        crypter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crypterActionPerformed(evt);
            }
        });
        jPanel3.add(crypter);

        cryptManu.setText("Cryptage manuel");
        cryptManu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cryptManuMouseClicked(evt);
            }
        });
        cryptManu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cryptManuActionPerformed(evt);
            }
        });
        jPanel3.add(cryptManu);

        messAndData.add(jPanel3);

        jLabel2.setText("Message crypté :");
        messAndData.add(jLabel2);
        messAndData.add(messageCrpt);

        i_body.add(messAndData, java.awt.BorderLayout.CENTER);

        CentreMod.add(i_body, java.awt.BorderLayout.CENTER);

        getContentPane().add(CentreMod);

        AffichageGeneral.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        centerAff.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(centerAff);

        AffichageGeneral.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        topAff.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("Ordre Initial des Cartes");
        topAff.add(jLabel7, java.awt.BorderLayout.NORTH);

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        originalJDC.setMaximumSize(new java.awt.Dimension(32767, 50));
        originalJDC.setPreferredSize(new java.awt.Dimension(10, 50));
        originalJDC.setLayout(new java.awt.BorderLayout());

        originalJDCN.setLayout(new java.awt.GridLayout(1, 0));
        originalJDC.add(originalJDCN, java.awt.BorderLayout.NORTH);

        jScrollPane3.setViewportView(originalJDC);

        topAff.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        AffichageGeneral.add(topAff, java.awt.BorderLayout.NORTH);

        getContentPane().add(AffichageGeneral);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void randClefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randClefActionPerformed
        int tmp = 0;
        if(this.genJDC)
            tmp = JOptionPane.showConfirmDialog(this,"Etes-vous sur de vouloir changer l'ordre ?\nAucun retour ne sera possible.","Attention !",JOptionPane.YES_NO_OPTION);
        
        if(tmp == 0){
            this.jeuDeCarte = new Carte[54];
            int val[] = new int[54];
            for(int i = 0; i < 54; i++)
                val[i] = i + 1;
            int k = 0;
            while(k != 54){
                int rnd = (int) (Math.random() * 54) + 1;
                if(val[rnd - 1] != 0){
                    this.jeuDeCarte[k] = new Carte(rnd);
                    //System.out.println("indice : " + rnd + " getElement : " + jeuDeCarte[k].getElement());
                    k++;
                    val[rnd - 1] = 0;
                }
            }
            this.clefNonNulle = true;
            this.a5 = new CinqEtapes(this.jeuDeCarte);
            affGraphCarte(this.panGraphCarte, this.jeuDeCarte);
            affGraphCarte(this.originalJDCN, this.jeuDeCarte);
            this.genJDC = true;
        }
    }//GEN-LAST:event_randClefActionPerformed

    private void defClefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defClefActionPerformed
        int tmp = 0;
        if(this.genJDC)
            tmp = JOptionPane.showConfirmDialog(this,"Etes-vous sur de vouloir changer l'ordre ?\nAucun retour ne sera possible.","Attention !",JOptionPane.YES_NO_OPTION);
        
        if(tmp == 0){
            InterfaceGenerClef igc = new InterfaceGenerClef(this,true);
            super.setVisible(false);
            igc.setVisible(true);
            super.setVisible(true);
            if(igc.ok){
                //System.out.println("HEY COUCOU");
                this.jeuDeCarte = igc.jdc;
                this.clefNonNulle = true;
                this.a5 = new CinqEtapes(this.jeuDeCarte);
                affGraphCarte(this.panGraphCarte, this.jeuDeCarte);
                affGraphCarte(this.originalJDCN, this.jeuDeCarte);
                this.genJDC = true;
            }
        }
    }//GEN-LAST:event_defClefActionPerformed

    private void cryptManuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cryptManuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cryptManuActionPerformed

    private void crypterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crypterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crypterActionPerformed

    private void crypterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crypterMouseClicked
        if(clefNonNulle && !messCrypt.getText().equals("") && !ancienMess.equals(messCrypt.getText())){
            do{
                a5.Etape1();
                a5.Etape2();
                a5.Etape3();
                a5.Etape4();
                redo=a5.Etape5();
            }while(redo == true);                               //Recommence tant que la carte trouvé à l'étape 5 est un joker
            if(a5.CodageDecodage(messCrypt.getText(), String.valueOf(a5.getLettres()), true)){//Codage du message
                messageCrpt.setText(a5.getMessCrypt());             //Affichage du message coder
                ancienMess = messCrypt.getText();
                messADecrypt = true;
                affGraphCarte(this.panGraphCarte, a5.getJDC());
                this.logAnPol();
            }
            else
                JOptionPane.showMessageDialog(this,"Veuillez initialiser la clef et rentrez un message différent du précédent");
        }
        else
            JOptionPane.showMessageDialog(this,"Veuillez initialiser la clef et rentrez un message différent du précédent");
    }//GEN-LAST:event_crypterMouseClicked

    private void cryptManuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptManuMouseClicked
        CryptageManuel cM;
        if(clefNonNulle && !messCrypt.getText().equals("") && !ancienMess.equals(messCrypt.getText())){
            cM = new CryptageManuel(this,true,jeuDeCarte,a5,messCrypt.getText());      //Création de la fenêtre du cryptage manuel
            this.setVisible(false);                             //Cache la fenêtre principale
            cM.setVisible(true);                                //Affiche la fenêtre du cryptage manuel
            this.a5 = cM.getA5();
            //System.out.println("J'ai FINI !");
            messageCrpt.setText(a5.getMessCrypt());
            if(cM.codEff){
                messADecrypt = true;
                affGraphCarte(this.panGraphCarte, a5.getJDC());
                this.logAnPol();
                ancienMess = messCrypt.getText();
            }
        }
        else{
            //System.out.println("Veuillez initialiser la clef");
            JOptionPane.showMessageDialog(this,"Veuillez initialiser la clef et rentrez un message différent du précédent");
        }
    }//GEN-LAST:event_cryptManuMouseClicked

    private void decrypterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decrypterMouseClicked
        if(messADecrypt){
           decMess.setText(a5.getMessCrypt());
            a5.CodageDecodage(a5.getMessCrypt(), String.valueOf(a5.getLettres()), false);
            //System.out.println("Message décrypté "+a5.getMessCrypt());
            decMessFinal.setText(a5.getMessCrypt());
            int[] messCryptInt = a5.getMessCryptInt();
            String strMessCryptInt ="";
            for(int i=0;i<messCryptInt.length;i++)
                strMessCryptInt += String.valueOf(messCryptInt[i]);
            decMessSous.setText(strMessCryptInt);
            messADecrypt = false;
        }
    }//GEN-LAST:event_decrypterMouseClicked
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfacePrincipale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AffichageGeneral;
    private javax.swing.JPanel CentreMod;
    private javax.swing.JPanel centerAff;
    private javax.swing.JButton cryptManu;
    private javax.swing.JButton crypter;
    private javax.swing.JLabel decMess;
    private javax.swing.JLabel decMessFinal;
    private javax.swing.JLabel decMessSous;
    private javax.swing.JButton decrypter;
    private javax.swing.JButton defClef;
    private javax.swing.JPanel i_body;
    private javax.swing.JPanel i_foot;
    private javax.swing.JPanel i_head;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelN;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel messAndData;
    private javax.swing.JTextField messCrypt;
    private javax.swing.JLabel messageCrpt;
    private javax.swing.JPanel ordrCarte;
    private javax.swing.JScrollPane ordreCourantCarte;
    private javax.swing.JPanel originalJDC;
    private javax.swing.JPanel originalJDCN;
    private javax.swing.JPanel panGraphCarte;
    private javax.swing.JButton randClef;
    private javax.swing.JPanel topAff;
    // End of variables declaration//GEN-END:variables
}


