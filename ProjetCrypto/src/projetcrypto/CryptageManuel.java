package projetcrypto;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CryptageManuel extends javax.swing.JDialog {
    private CinqEtapes a5;
    private int etapeEff;
    private java.awt.Frame parentP;
    
    public CryptageManuel(java.awt.Frame parent, boolean modal, Carte[] jeuDeCarte, CinqEtapes a5,String messCrypt) {
        super(parent, modal);
        a5 = new CinqEtapes(jeuDeCarte);
        this.a5 = a5;
        etapeEff = 0;
        parentP = parent;
        initComponents();
        varMessage.setText(messCrypt);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
    }
    public CinqEtapes getA5(){
        return this.a5;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        varMessage = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        etape1Pan = new javax.swing.JPanel();
        etape1Lab = new javax.swing.JLabel();
        Etape1But = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        etape2Pan = new javax.swing.JPanel();
        etape2Lab = new javax.swing.JLabel();
        Etape2But = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        etape3Pan = new javax.swing.JPanel();
        etape3Lab = new javax.swing.JLabel();
        Etape3But = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel17 = new javax.swing.JPanel();
        etape4Pan = new javax.swing.JPanel();
        etape4Lab = new javax.swing.JLabel();
        Etape4But = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel18 = new javax.swing.JPanel();
        etape5Pan = new javax.swing.JPanel();
        etape5Lab = new javax.swing.JLabel();
        Etape5But = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel19 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        varClefCrypt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        varMessCrypt = new javax.swing.JTextField();
        quitterBut = new javax.swing.JButton();
        terminerBut = new javax.swing.JButton();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, quitterBut, org.jdesktop.beansbinding.ELProperty.create("${action.enabled}"), this, org.jdesktop.beansbinding.BeanProperty.create("defaultCloseOperation"));
        bindingGroup.addBinding(binding);

        jPanel1.setLayout(new java.awt.GridLayout(4, 1));

        jLabel1.setText("Message :");
        jPanel1.add(jLabel1);

        varMessage.setText("jTextField5");
        jPanel1.add(varMessage);

        jLabel2.setText("Ordre des Cartes :");
        jPanel1.add(jLabel2);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane7.setViewportView(jPanel20);

        jPanel1.add(jScrollPane7);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel6);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(10, 1));

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

        jPanel2.add(etape1Pan);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel15);

        jPanel2.add(jScrollPane1);

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

        jPanel2.add(etape2Pan);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel16);

        jPanel2.add(jScrollPane3);

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

        jPanel2.add(etape3Pan);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jPanel17);

        jPanel2.add(jScrollPane4);

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

        jPanel2.add(etape4Pan);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(jPanel18);

        jPanel2.add(jScrollPane5);

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

        jPanel2.add(etape5Pan);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(jPanel19);

        jPanel2.add(jScrollPane6);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(5, 1));

        jLabel6.setText("Clef de cryptage");
        jPanel3.add(jLabel6);

        varClefCrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varClefCryptActionPerformed(evt);
            }
        });
        jPanel3.add(varClefCrypt);

        jLabel7.setText("Message crypté");
        jPanel3.add(jLabel7);
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
        System.out.println(varMessage.getText());
        if(etapeEff == 0){    
            a5.Etape1();
            etapeEff++;
        }
        else{
            etape1Pan.setBackground( new Color(50,50,50,128));
        }
    }//GEN-LAST:event_Etape1ButMouseClicked

    private void Etape2ButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Etape2ButMouseClicked
        if(etapeEff == 1){    
            a5.Etape2();
            etapeEff++;
        }
        else{
            etape2Pan.setBackground( new Color(50,50,50,128));
        }
    }//GEN-LAST:event_Etape2ButMouseClicked

    private void Etape3ButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Etape3ButMouseClicked
        if(etapeEff == 2){    
            a5.Etape3();
            etapeEff++;
        }
        else{
            etape3Pan.setBackground( new Color(50,50,50,128));
        }
    }//GEN-LAST:event_Etape3ButMouseClicked

    private void Etape4ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Etape4ButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Etape4ButActionPerformed

    private void Etape4ButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Etape4ButMouseClicked
        if(etapeEff == 3){    
            a5.Etape4();
            etapeEff++;
        }
        else{
            etape4Pan.setBackground( new Color(50,50,50,128));
        }
    }//GEN-LAST:event_Etape4ButMouseClicked

    private void Etape5ButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Etape5ButMouseClicked
        if(etapeEff == 4){ 
            boolean redo = false;
            redo = a5.Etape5();
            if(redo == true)
                System.out.println("Recommencez depuis l'étape 1");;
            
            if(redo == false){
                String lettres = String.valueOf(a5.getLettres());
                System.out.println("lettres récup depuis a5 : "+lettres);
                a5.CodageDecodage(varMessage.getText(), lettres, true);
                varMessCrypt.setText(a5.getMessCrypt());
                varClefCrypt.setText(String.valueOf(a5.getLettres()));
            }
            etapeEff = 0;
        }
        else{
            etape5Pan.setBackground( new Color(50,50,50,128));
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
        }
        
        String lettres = String.valueOf(a5.getLettres());
        System.out.println("lettres récup depuis a5 : "+lettres);
        a5.CodageDecodage(varMessage.getText(), lettres, true);
        varMessCrypt.setText(a5.getMessCrypt());
        varClefCrypt.setText(String.valueOf(a5.getLettres()));
        etapeEff = 0;
    }//GEN-LAST:event_terminerButMouseClicked

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
        /*java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
                System.out.println("Ouverture CryptageManuel");
                CryptageManuel dialog = new CryptageManuel(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                this.addWindowListener(new WindowAdapter(){
                @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                //dialog.setVisible(true);
            }
        });*/
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
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton quitterBut;
    private javax.swing.JButton terminerBut;
    private javax.swing.JTextField varClefCrypt;
    private javax.swing.JTextField varMessCrypt;
    private javax.swing.JTextField varMessage;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
