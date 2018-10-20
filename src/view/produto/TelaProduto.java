/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.produto;

import controller.ControllerProduto;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import model.GestaoProduto;
import view.main.TelaPrincipal;

/**
 *
 * @author Enoque
 */
public class TelaProduto extends javax.swing.JFrame {
    ControllerProduto cp;
    DefaultListModel dfProdutoNome;
    DefaultListModel dfProdutoCodigo;
    ArrayList<GestaoProduto> produtos;
    Object placeholder;
    
    
    /**
     * Creates new form TelaProduto
     */
    public TelaProduto() throws SQLException {
        initComponents();
         dfProdutoCodigo = new DefaultListModel();
        dfProdutoNome = new DefaultListModel();
        cp = new ControllerProduto();
        placeholder =  jComboBoxSelecionarBusca.getSelectedItem();
        produtos =  cp.getAll();
       
        if(produtos.size() > 0 ){
          for (int i =0 ; i< produtos.size() ; i++){
            //  dfProdutoCodigo.addElement(produtos.get(i).getCodigo());
              dfProdutoNome.addElement(produtos.get(i).getNome());
          }
          jLabelInfoProduto.setText(produtos.size() + "  Produtos Cadastrados");
          
        }else{
            jLabelInfoProduto.setText("Sem Produtos Cadastrados");
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
        jTextFieldBuscarProduto = new javax.swing.JTextField();
        jComboBoxSelecionarBusca = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProdutoNome = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListProdutoCodigo = new javax.swing.JList<>();
        jButtonBuscar = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabelInfoProduto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscar :");

        jTextFieldBuscarProduto.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldBuscarProduto.setText("Digite o Nome do Produto");
        jTextFieldBuscarProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldBuscarProdutoFocusLost(evt);
            }
        });
        jTextFieldBuscarProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarProdutoKeyPressed(evt);
            }
        });

        jComboBoxSelecionarBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Codigo" }));
        jComboBoxSelecionarBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelecionarBuscaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListProdutoNome);

        jScrollPane2.setViewportView(jListProdutoCodigo);

        jButtonBuscar.setText("Buscar");

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonRemover.setText("Remover");
        jButtonRemover.setEnabled(false);

        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Codigo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabelInfoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(88, 88, 88)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxSelecionarBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSelecionarBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelInfoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        try {
            new TelaFormProduto().setVisible(true);
        } catch (SQLException ex) {
            System.out.println("Erro ao instanciar Formulario");      
        }
        this.dispose();
        
            // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        new TelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jComboBoxSelecionarBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelecionarBuscaActionPerformed
    placeholder =  jComboBoxSelecionarBusca.getSelectedItem();
        jTextFieldBuscarProduto.setText("Digite o "+ placeholder + " do Produto");
        jTextFieldBuscarProduto.setForeground(Color.GRAY);
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSelecionarBuscaActionPerformed

    private void jTextFieldBuscarProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldBuscarProdutoFocusLost
           if(jTextFieldBuscarProduto.getText().equals("")){
            jTextFieldBuscarProduto.setText("Digite o "+ placeholder + " do Produto");
            jTextFieldBuscarProduto.setForeground(Color.GRAY);
            jButtonBuscar.setEnabled(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarProdutoFocusLost

    private void jTextFieldBuscarProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarProdutoKeyPressed
         if(jTextFieldBuscarProduto.getText().equals("Digite o "+ placeholder + " do Produto")){
          jTextFieldBuscarProduto.setText("");
        jTextFieldBuscarProduto.setForeground(Color.BLACK);       
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarProdutoKeyPressed

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
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaProduto().setVisible(true);
                } catch (SQLException ex) {
                    System.out.println("Erro ao instanciar Listagem Produto");
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxSelecionarBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelInfoProduto;
    private javax.swing.JList<String> jListProdutoCodigo;
    private javax.swing.JList<String> jListProdutoNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldBuscarProduto;
    // End of variables declaration//GEN-END:variables
}
