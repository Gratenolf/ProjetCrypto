package projetcrypto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CryptageManuel extends javax.swing.JDialog {
    private CinqEtapes a5;
    private int etapeEff;
    private java.awt.Frame parentP;
    public boolean codEff;
    public final int N = 54;
    
    public CryptageManuel(java.awt.Frame parent, boolean modal, Carte[] jeuDeCarte, CinqEtapes a5,String messCrypt) {
        super(parent, modal);
        a5 = new CinqEtapes(jeuDeCarte);
        this.a5 = a5;
        etapeEff = 0;
        parentP = parent;
        initComponents();
        this.myInitComponent();
        varMessage.setText(messCrypt);
        this.codEff = false;
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        this.affGraphCarte(this.ordreCarte, jeuDeCarte);
    }
    public CinqEtapes getA5(){
        return this.a5;
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
    
    private void affGraphCarte(JPanel jp, Carte[] tabCarte){
        JLabel afficheCarte[] = new JLabel[N * 2];
        
        for(int i = 0; i < N * 2; i++)
            afficheCarte[i] = genLabelAff();
                
        for(int i = 0; i < N; i++){
            Carte c = tabCarte[i];
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
    
    private void myInitComponent(){
        this.step1.setLayout(new java.awt.GridLayout(2, N));
        this.jPanel15.setPreferredSize(new java.awt.Dimension(17 * N + N, 3 * 17));
        this.jPanel15.setMaximumSize(new java.awt.Dimension(17 * N + N, 3 * 17));
        
        this.step2.setLayout(new java.awt.GridLayout(2, N));
        this.jPanel16.setPreferredSize(new java.awt.Dimension(17 * N + N, 3 * 17));
        this.jPanel16.setMaximumSize(new java.awt.Dimension(17 * N + N, 3 * 17));
        
        this.step3.setLayout(new java.awt.GridLayout(2, N));
        this.jPanel17.setPreferredSize(new java.awt.Dimension(17 * N + N, 4 * 17));
        this.jPanel17.setMaximumSize(new java.awt.Dimension(17 * N + N, 4 * 17));
        
        this.step4.setLayout(new java.awt.GridLayout(2, N));
        this.jPanel18.setPreferredSize(new java.awt.Dimension(17 * N + N, 4 * 17));
        this.jPanel18.setMaximumSize(new java.awt.Dimension(17 * N + N, 4 * 17));
        
        this.step5.setLayout(new java.awt.GridLayout(2, N));
        this.jPanel19.setPreferredSize(new java.awt.Dimension(17 * N + N, 4 * 17));
        this.jPanel19.setMaximumSize(new java.awt.Dimension(17 * N + N, 4 * 17));
        
        this.jPanel20.setPreferredSize(new java.awt.Dimension(17 * N + N, 4 * 17));
        this.jPanel20.setMaximumSize(new java.awt.Dimension(17 * N + N, 4 * 17));
        
        this.Etape1But.setBackground(Color.green);
        this.Etape2But.setBackground(Color.green);
        this.Etape3But.setBackground(Color.green);
        this.Etape4But.setBackground(Color.green);
        this.Etape5But.setBackground(Color.green);

        this.Etape2But.setEnabled(false);
        this.Etape3But.setEnabled(false);
        this.Etape4But.setEnabled(false);
        this.Etape5But.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        varMessage = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel20 = new javax.swing.JPanel();
        ordreCarte = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        etape1Pan = new javax.swing.JPanel();
        etape1Lab = new javax.swing.JLabel();
        Etape1But = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        step1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        etape2Pan = new javax.swing.JPanel();
        etape2Lab = new javax.swing.JLabel();
        Etape2But = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        step2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        etape3Pan = new javax.swing.JPanel();
        etape3Lab = new javax.swing.JLabel();
        Etape3But = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel17 = new javax.swing.JPanel();
        step3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        etape4Pan = new javax.swing.JPanel();
        etape4Lab = new javax.swing.JLabel();
        Etape4But = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel18 = new javax.swing.JPanel();
        step4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        etape5Pan = new javax.swing.JPanel();
        etape5Lab = new javax.swing.JLabel();
        Etape5But = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel19 = new javax.swing.JPanel();
        step5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        varClefCrypt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        varMessCrypt = new javax.swing.JTextField();
        quitterBut = new javax.swing.JButton();
        terminerBut = new javax.swing.JButton();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, quitterBut, org.jdesktop.beansbinding.ELProperty.create("${action.enabled}"), this, org.jdesktop.beansbinding.BeanProperty.create("defaultCloseOperation"));
        bindingGroup.addBinding(binding);

        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 150));
        jPanel1.setPreferredSize(new java.awt.Dimension(751, 150));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 85));
        jPanel5.setPreferredSize(new java.awt.Dimension(376, 85));
        jPanel5.setLayout(new java.awt.GridLayout(3, 1));

        jLabel1.setText("Message :");
        jPanel5.add(jLabel1);

        varMessage.setEditable(false);
        varMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varMessageActionPerformed(evt);
            }
        });
        jPanel5.add(varMessage);

        jLabel2.setText("Ordre des Cartes :");
        jPanel5.add(jLabel2);

        jPanel1.add(jPanel5, java.awt.BorderLayout.NORTH);

        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel20.setLayout(new java.awt.BorderLayout());

        ordreCarte.setLayout(new java.awt.GridLayout(2, 54));
        jPanel20.add(ordreCarte, java.awt.BorderLayout.NORTH);

        jScrollPane7.setViewportView(jPanel20);

        jPanel1.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.GridLayout(5, 1));

        jPanel4.setLayout(new java.awt.BorderLayout());

        etape1Pan.setLayout(new java.awt.GridLayout(1, 0));

        etape1Lab.setText("Etape 1");
        etape1Pan.add(etape1Lab);

        Etape1But.setText("Appliquer");
        Etape1But.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Etape1ButMouseClicked(evt);
            }
        });
        etape1Pan.add(Etape1But);

        jPanel4.add(etape1Pan, java.awt.BorderLayout.NORTH);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel15.setMaximumSize(new java.awt.Dimension(2147483647, 75));
        jPanel15.setPreferredSize(new java.awt.Dimension(750, 75));
        jPanel15.setLayout(new java.awt.BorderLayout());

        step1.setLayout(new java.awt.GridLayout(2, 54));
        jPanel15.add(step1, java.awt.BorderLayout.NORTH);

        jScrollPane1.setViewportView(jPanel15);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        jPanel7.setLayout(new java.awt.BorderLayout());

        etape2Pan.setLayout(new java.awt.GridLayout(1, 0));

        etape2Lab.setText("Etape 2");
        etape2Pan.add(etape2Lab);

        Etape2But.setText("Appliquer");
        Etape2But.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Etape2ButMouseClicked(evt);
            }
        });
        etape2Pan.add(Etape2But);

        jPanel7.add(etape2Pan, java.awt.BorderLayout.NORTH);

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel16.setMaximumSize(new java.awt.Dimension(2147483647, 51));
        jPanel16.setPreferredSize(new java.awt.Dimension(749, 51));
        jPanel16.setLayout(new java.awt.BorderLayout());

        step2.setLayout(new java.awt.GridLayout(2, 54));
        jPanel16.add(step2, java.awt.BorderLayout.NORTH);

        jScrollPane3.setViewportView(jPanel16);

        jPanel7.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        etape3Pan.setLayout(new java.awt.GridLayout(1, 0));

        etape3Lab.setText("Etape 3");
        etape3Pan.add(etape3Lab);

        Etape3But.setText("Appliquer");
        Etape3But.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Etape3ButMouseClicked(evt);
            }
        });
        etape3Pan.add(Etape3But);

        jPanel8.add(etape3Pan, java.awt.BorderLayout.NORTH);

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel17.setMaximumSize(new java.awt.Dimension(2147483647, 51));
        jPanel17.setPreferredSize(new java.awt.Dimension(750, 51));
        jPanel17.setLayout(new java.awt.BorderLayout());

        step3.setLayout(new java.awt.GridLayout(2, 54));
        jPanel17.add(step3, java.awt.BorderLayout.NORTH);

        jScrollPane4.setViewportView(jPanel17);

        jPanel8.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8);

        jPanel9.setLayout(new java.awt.BorderLayout());

        etape4Pan.setLayout(new java.awt.GridLayout(1, 0));

        etape4Lab.setText("Etape 4");
        etape4Pan.add(etape4Lab);

        Etape4But.setText("Appliquer");
        Etape4But.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Etape4ButMouseClicked(evt);
            }
        });
        Etape4But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Etape4ButActionPerformed(evt);
            }
        });
        etape4Pan.add(Etape4But);

        jPanel9.add(etape4Pan, java.awt.BorderLayout.NORTH);

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel18.setMaximumSize(new java.awt.Dimension(2147483647, 51));
        jPanel18.setPreferredSize(new java.awt.Dimension(750, 51));
        jPanel18.setLayout(new java.awt.BorderLayout());

        step4.setLayout(new java.awt.GridLayout(2, 54));
        jPanel18.add(step4, java.awt.BorderLayout.NORTH);

        jScrollPane5.setViewportView(jPanel18);

        jPanel9.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel9);

        jPanel10.setLayout(new java.awt.BorderLayout());

        etape5Pan.setLayout(new java.awt.GridLayout(1, 0));

        etape5Lab.setText("Etape 5");
        etape5Pan.add(etape5Lab);

        Etape5But.setText("Appliquer");
        Etape5But.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Etape5ButMouseClicked(evt);
            }
        });
        etape5Pan.add(Etape5But);

        jPanel10.add(etape5Pan, java.awt.BorderLayout.NORTH);

        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel19.setMaximumSize(new java.awt.Dimension(2147483647, 51));
        jPanel19.setPreferredSize(new java.awt.Dimension(750, 51));
        jPanel19.setLayout(new java.awt.BorderLayout());

        step5.setLayout(new java.awt.GridLayout(2, 54));
        jPanel19.add(step5, java.awt.BorderLayout.NORTH);

        jScrollPane6.setViewportView(jPanel19);

        jPanel10.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel10);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(3, 2));

        jLabel6.setText("Clef de cryptage");
        jPanel3.add(jLabel6);

        varClefCrypt.setEditable(false);
        varClefCrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varClefCryptActionPerformed(evt);
            }
        });
        jPanel3.add(varClefCrypt);

        jLabel7.setText("Message crypté");
        jPanel3.add(jLabel7);

        varMessCrypt.setEditable(false);
        jPanel3.add(varMessCrypt);

        quitterBut.setText("Quitter");
        quitterBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitterButMouseClicked(evt);
            }
        });
        jPanel3.add(quitterBut);

        terminerBut.setText("Terminer");
        terminerBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                terminerButMouseClicked(evt);
            }
        });
        jPanel3.add(terminerBut);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Etape1ButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Etape1ButMouseClicked
        if(etapeEff == 0 && this.Etape1But.isEnabled()){    
            a5.Etape1();
            etapeEff++;
            this.affGraphCarte(step1, a5.getJDC());
            this.Etape1But.setEnabled(false);
            this.Etape2But.setEnabled(true);
        }
    }//GEN-LAST:event_Etape1ButMouseClicked

    private void Etape2ButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Etape2ButMouseClicked
        if(etapeEff == 1){    
            a5.Etape2();
            etapeEff++;
            this.affGraphCarte(this.step2, a5.getJDC());
            this.Etape2But.setEnabled(false);
            this.Etape3But.setEnabled(true);
        }
    }//GEN-LAST:event_Etape2ButMouseClicked

    private void Etape3ButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Etape3ButMouseClicked
        if(etapeEff == 2){    
            a5.Etape3();
            etapeEff++;
            this.affGraphCarte(this.step3, a5.getJDC());
            this.Etape3But.setEnabled(false);
            this.Etape4But.setEnabled(true);
        }
    }//GEN-LAST:event_Etape3ButMouseClicked

    private void Etape4ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Etape4ButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Etape4ButActionPerformed

    private void Etape4ButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Etape4ButMouseClicked
        if(etapeEff == 3){    
            a5.Etape4();
            etapeEff++;
            this.affGraphCarte(this.step4, a5.getJDC());
            this.Etape4But.setEnabled(false);
            this.Etape5But.setEnabled(true);
        }
    }//GEN-LAST:event_Etape4ButMouseClicked

    private void Etape5ButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Etape5ButMouseClicked
        if(etapeEff == 4){ 
            boolean redo = false;
            redo = a5.Etape5();
            if(redo == false){
                String lettres = String.valueOf(a5.getLettres());
                a5.CodageDecodage(varMessage.getText(), lettres, true);
                varMessCrypt.setText(a5.getMessCrypt());
                varClefCrypt.setText(String.valueOf(a5.getLettres()));
                this.codEff = true;
            }
            etapeEff = 0;
            this.affGraphCarte(this.step5, a5.getJDC());
            this.Etape5But.setEnabled(false);
            if(redo)
                this.Etape1But.setEnabled(true);
        }
    }//GEN-LAST:event_Etape5ButMouseClicked

    private void quitterButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitterButMouseClicked
        parentP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_quitterButMouseClicked

    private void varClefCryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varClefCryptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varClefCryptActionPerformed

    private void terminerButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_terminerButMouseClicked
        if(!codEff){
            boolean redo = false;
            switch(etapeEff){
                case 0:a5.Etape1();a5.Etape2();a5.Etape3();a5.Etape4();redo = a5.Etape5();break;
                case 1:a5.Etape2();a5.Etape3();a5.Etape4();redo = a5.Etape5();break;
                case 2:a5.Etape3();a5.Etape4();redo = a5.Etape5();break;
                case 3:a5.Etape4();redo = a5.Etape5();break;
                case 4:redo = a5.Etape5();break;
            }// TODO add your handling code here:

            while(redo){
                a5.Etape1();
                a5.Etape2();
                a5.Etape3();
                a5.Etape4();
                redo = a5.Etape5();
                if(!redo){
                    this.step1.removeAll();
                    this.step2.removeAll();
                    this.step3.removeAll();
                    this.step4.removeAll();
                    this.affGraphCarte(this.step5, a5.getJDC());
                    this.Etape1But.setEnabled(false);
                    this.Etape2But.setEnabled(false);
                    this.Etape3But.setEnabled(false);
                    this.Etape4But.setEnabled(false);
                    this.Etape5But.setEnabled(false);
                }
            }
            String lettres = String.valueOf(a5.getLettres());
            a5.CodageDecodage(varMessage.getText(), lettres, true);
            varMessCrypt.setText(a5.getMessCrypt());
            varClefCrypt.setText(String.valueOf(a5.getLettres()));
            etapeEff = 0;
            this.codEff = true;
        }
    }//GEN-LAST:event_terminerButMouseClicked

    private void varMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varMessageActionPerformed

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
            java.util.logging.Logger.getLogger(CryptageManuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CryptageManuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CryptageManuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CryptageManuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Etape1But;
    private javax.swing.JButton Etape2But;
    private javax.swing.JButton Etape3But;
    private javax.swing.JButton Etape4But;
    private javax.swing.JButton Etape5But;
    private javax.swing.JLabel etape1Lab;
    private javax.swing.JPanel etape1Pan;
    private javax.swing.JLabel etape2Lab;
    private javax.swing.JPanel etape2Pan;
    private javax.swing.JLabel etape3Lab;
    private javax.swing.JPanel etape3Pan;
    private javax.swing.JLabel etape4Lab;
    private javax.swing.JPanel etape4Pan;
    private javax.swing.JLabel etape5Lab;
    private javax.swing.JPanel etape5Pan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel ordreCarte;
    private javax.swing.JButton quitterBut;
    private javax.swing.JPanel step1;
    private javax.swing.JPanel step2;
    private javax.swing.JPanel step3;
    private javax.swing.JPanel step4;
    private javax.swing.JPanel step5;
    private javax.swing.JButton terminerBut;
    private javax.swing.JTextField varClefCrypt;
    private javax.swing.JTextField varMessCrypt;
    private javax.swing.JTextField varMessage;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
