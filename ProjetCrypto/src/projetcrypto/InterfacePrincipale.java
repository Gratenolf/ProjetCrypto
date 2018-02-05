/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetcrypto;

/**
 *
 * @author ng452532
 */
public class InterfacePrincipale extends javax.swing.JFrame {

    /**
     * Creates new form InterfacePrincipale
     */
    public InterfacePrincipale() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        i_head = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        randClef = new javax.swing.JButton();
        defClef = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        i_foot = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        affCCP3 = new javax.swing.JTextField();
        affMessDecrypt = new javax.swing.JTextField();
        i_body = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        affCdB = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        affCC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        messCrypt = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        crypter = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        affCrypt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        i_head.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        randClef.setText("Aléatoire");
        jPanel5.add(randClef);

        defClef.setText("Définir");
        jPanel5.add(defClef);

        i_head.add(jPanel5, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Definition Clef");
        i_head.add(jLabel1, java.awt.BorderLayout.NORTH);

        getContentPane().add(i_head, java.awt.BorderLayout.PAGE_START);

        i_foot.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        jButton3.setText("Décrypter");
        jPanel4.add(jButton3);
        jPanel4.add(affCCP3);

        i_foot.add(jPanel4, java.awt.BorderLayout.CENTER);
        i_foot.add(affMessDecrypt, java.awt.BorderLayout.SOUTH);

        getContentPane().add(i_foot, java.awt.BorderLayout.PAGE_END);

        i_body.setLayout(new java.awt.GridLayout(8, 1));

        jLabel4.setText("Clef de base");
        i_body.add(jLabel4);
        i_body.add(affCdB);

        jLabel5.setText("Clef courante");
        i_body.add(jLabel5);
        i_body.add(affCC);

        jLabel6.setText("Message à crypter : ");
        i_body.add(jLabel6);
        i_body.add(messCrypt);

        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        crypter.setText("Crypter");
        jPanel6.add(crypter);
        jPanel6.add(jLabel7);

        i_body.add(jPanel6);
        i_body.add(affCrypt);

        getContentPane().add(i_body, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JTextField affCC;
    private javax.swing.JTextField affCCP3;
    private javax.swing.JTextField affCdB;
    private javax.swing.JTextField affCrypt;
    private javax.swing.JTextField affMessDecrypt;
    private javax.swing.JButton crypter;
    private javax.swing.JButton defClef;
    private javax.swing.JPanel i_body;
    private javax.swing.JPanel i_foot;
    private javax.swing.JPanel i_head;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField messCrypt;
    private javax.swing.JButton randClef;
    // End of variables declaration//GEN-END:variables
}
