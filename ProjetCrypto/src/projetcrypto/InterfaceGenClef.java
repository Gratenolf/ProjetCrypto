package projetcrypto;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfaceGenClef extends javax.swing.JDialog {
    
    public int jeuDeCarte[];
    private int k = 0;

    public InterfaceGenClef(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jeuDeCarte = new int[54];
        for(int i = 0; i < 54; i++)
            jeuDeCarte[i] = 0;
        for(int i = 0; i < 54; i++){
            this.panneauCarte.add(creerPanCarte(new Carte(i+1)));
            System.out.print((i+1)+"");
        }
    }
    
    private void afficheJDC(){
        for(int i = 0 ; i< 54; i++)
            System.out.print(jeuDeCarte[i]+" ");
        System.out.println("");
    }
    
    private JPanel creerPanCarte(Carte c){
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        
        JToggleButton jb = new JToggleButton();
        jb.setPreferredSize(new Dimension(40, 40));
        jb.setBackground(Color.white);
        if(c.getValeur() < 53){
            jb.setIcon(new ImageIcon("img/"+c.getElement()+".png"));
            jb.setText(c.getNom());
            jb.setForeground(Color.WHITE);
            jb.setHorizontalTextPosition(SwingConstants.CENTER);
        }
        else if(c.getValeur() == 53 && c.getElement() == "Noir")
            jb.setIcon(new ImageIcon("img/JokerN.png"));
        else
            jb.setIcon(new ImageIcon("img/JokerR.png"));            
        
        JTextField jtf = new JTextField();
        jtf.setText("");
        jtf.setEditable(false);
        
        jp.add(jb, BorderLayout.CENTER);
        jp.add(jtf,BorderLayout.SOUTH);
        
        // Y A UN SOUCIS ICI 
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JToggleButton jtb = (JToggleButton) e.getSource();
                if(jtb.isSelected()){
                    jeuDeCarte[k] = c.getValeur();
                    jtf.setText((++k)+"");
                    afficheJDC();
                    System.out.println("ajout element");
                }
                else{
                    jtf.setText("");
                    int tmp = 0;
                    while(tmp != c.getValeur())
                        tmp++;
                    for(int i = tmp; i < k; i++)
                        jeuDeCarte[i] = jeuDeCarte[i + 1];
                    k--;
                    afficheJDC();
                    System.out.println("element supprimé");
                }
            }
        });        
        
        return jp;
    }
    
    public void initPanneau(){
        for(int i = 0; i < 54; i++)
            this.panneauCarte.add(creerPanCarte(new Carte(i+1)));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        reinit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        annuler = new javax.swing.JButton();
        valider = new javax.swing.JButton();
        affichage = new javax.swing.JPanel();
        panneauCarte = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        reinit.setText("Réinitialiser");
        jPanel1.add(reinit, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        annuler.setText("Annuler");
        jPanel4.add(annuler);

        valider.setText("Valider");
        jPanel4.add(valider);

        jPanel1.add(jPanel4, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        affichage.setLayout(new java.awt.GridLayout(1, 54));
        getContentPane().add(affichage, java.awt.BorderLayout.PAGE_END);

        panneauCarte.setLayout(new java.awt.GridLayout(5, 13));
        getContentPane().add(panneauCarte, java.awt.BorderLayout.CENTER);

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
            java.util.logging.Logger.getLogger(InterfaceGenClef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGenClef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGenClef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGenClef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceGenClef dialog = new InterfaceGenClef(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel affichage;
    private javax.swing.JButton annuler;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panneauCarte;
    private javax.swing.JButton reinit;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
