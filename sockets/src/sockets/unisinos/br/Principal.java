
package sockets.unisinos.br;

import static java.awt.SystemColor.text;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static sockets.unisinos.br.Analisador.entrada;


public class Principal extends javax.swing.JFrame {
    String jogada;
    InputStream entrada;
    Socket cliente;
    
    public Principal() throws Exception {
        initComponents();
        cliente = new Socket("127.0.0.1", 420);
    }

    
    public void setJogada(String s){
        this.jogada = s;
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPedra = new javax.swing.JButton();
        btnTesoura = new javax.swing.JButton();
        btnPapel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JokenPo");
        setResizable(false);

        btnPedra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sockets/unisinos/br/resources/pedra.png"))); // NOI18N
        btnPedra.setBorderPainted(false);
        btnPedra.setFocusPainted(false);
        btnPedra.setFocusable(false);
        btnPedra.setRequestFocusEnabled(false);
        btnPedra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedraActionPerformed(evt);
            }
        });

        btnTesoura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sockets/unisinos/br/resources/tesoura.png"))); // NOI18N
        btnTesoura.setBorderPainted(false);
        btnTesoura.setFocusPainted(false);
        btnTesoura.setFocusable(false);
        btnTesoura.setRequestFocusEnabled(false);
        btnTesoura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTesouraActionPerformed(evt);
            }
        });

        btnPapel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sockets/unisinos/br/resources/papel.png"))); // NOI18N
        btnPapel.setBorderPainted(false);
        btnPapel.setFocusPainted(false);
        btnPapel.setFocusable(false);
        btnPapel.setRequestFocusEnabled(false);
        btnPapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPapelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPedra)
                .addGap(18, 18, 18)
                .addComponent(btnPapel)
                .addGap(18, 18, 18)
                .addComponent(btnTesoura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTesoura)
                    .addComponent(btnPapel)
                    .addComponent(btnPedra))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//////////////////////////////-------ACOES------////////////////////////////////////
    
    
    public void enviarDados() throws IOException{
     
     //Converte o valor da jogada em um array de bytes para a Input Stream
     entrada = new ByteArrayInputStream( jogada.getBytes());
      
     //DEFINE ESSE VALOR NA ENTRADA PADRAO
     System.setIn(entrada);
     
     
     //scaneando a nova entrada padrao
     Scanner scan = new Scanner(System.in);
     
     //pegando a saida do cliente e jogando na stream de saida 
     PrintStream saida = new PrintStream(cliente.getOutputStream());
     
     
     //INFORMACAO VAI SER ENVIADA
      saida.print(jogada);
       
       //forca envio
       saida.close();
       scan.close();
       entrada.close();
     
     
   }
    
    private void mensagem(){
         JOptionPane.showMessageDialog(null,"Erro no envio dos dados. Verifique se o servidor está rodando");
    }
    
    //BOTAO PEDRA
    private void btnPedraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedraActionPerformed
        setJogada("PEDRA");
        try {
         enviarDados();
        } catch (IOException ex) {
           mensagem();
        }
    }//GEN-LAST:event_btnPedraActionPerformed

    //BOTAO PAPEL
    private void btnPapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPapelActionPerformed
      
        setJogada("PAPEL");
        try {
            enviarDados();
        } catch (IOException ex) {
           mensagem();
        }
    }//GEN-LAST:event_btnPapelActionPerformed

    
    //BOTAO TESOURA
    private void btnTesouraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTesouraActionPerformed
        setJogada("TESOURA");
        try {
            enviarDados();
        } catch (IOException ex) {
           mensagem();
        }
    }//GEN-LAST:event_btnTesouraActionPerformed

    
//////////////////////////////-------FIM ACOES------////////////////////////////////////
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    new Principal().setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPapel;
    private javax.swing.JButton btnPedra;
    private javax.swing.JButton btnTesoura;
    // End of variables declaration//GEN-END:variables
}
