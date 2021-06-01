/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Paul-PC
 */
public class TelaSistema extends javax.swing.JFrame {

    /**
     * Creates new form TelaSistema
     */
    public TelaSistema() {
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

        tituloScrollPanel = new javax.swing.JScrollPane();
        tituloTextArea = new javax.swing.JTextArea();
        voltarButton = new javax.swing.JButton();
        cadastrarMedicoButton = new javax.swing.JButton();
        cadastrarPacienteButton = new javax.swing.JButton();
        cadastrarConsultaButton = new javax.swing.JButton();
        cadastrarPlanoDeSaudeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloTextArea.setEditable(false);
        tituloTextArea.setColumns(20);
        tituloTextArea.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        tituloTextArea.setRows(5);
        tituloTextArea.setText(" ___                   _        __ __         _  _           \n| . | ___  ___ ._ _  _| | ___  |  \\  \\ ___  _| |<_> ___  ___ \n|   |/ . |/ ._>| ' |/ . |<_> | |     |/ ._>/ . || |/ | '<_> |\n|_|_|\\_. |\\___.|_|_|\\___|<___| |_|_|_|\\___.\\___||_|\\_|_.<___|\n     <___'                                                   ");
        tituloScrollPanel.setViewportView(tituloTextArea);

        voltarButton.setText("Voltar/Sair");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        cadastrarMedicoButton.setText("Cadastrar Médico");
        cadastrarMedicoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarMedicoButtonActionPerformed(evt);
            }
        });

        cadastrarPacienteButton.setText("Cadastrar Paciente");
        cadastrarPacienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPacienteButtonActionPerformed(evt);
            }
        });

        cadastrarConsultaButton.setText("Cadastrar Consulta");
        cadastrarConsultaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarConsultaButtonActionPerformed(evt);
            }
        });

        cadastrarPlanoDeSaudeButton.setText("Cadastrar Plano de Saúde");
        cadastrarPlanoDeSaudeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPlanoDeSaudeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voltarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastrarMedicoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cadastrarPacienteButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadastrarConsultaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastrarPlanoDeSaudeButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voltarButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cadastrarPacienteButton)
                            .addComponent(cadastrarMedicoButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cadastrarPlanoDeSaudeButton)
                            .addComponent(cadastrarConsultaButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarMedicoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarMedicoButtonActionPerformed
        dispose();
        TelaCadastroMedico telaCadastroMedico = new TelaCadastroMedico();
        telaCadastroMedico.setResizable(false);
        telaCadastroMedico.setLocationRelativeTo(null);
        telaCadastroMedico.setVisible(true);
    }//GEN-LAST:event_cadastrarMedicoButtonActionPerformed

    private void cadastrarPacienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPacienteButtonActionPerformed
        dispose();
        TelaCadastroPaciente telaCadastroPaciente = new TelaCadastroPaciente();
        telaCadastroPaciente.setResizable(false);
        telaCadastroPaciente.setLocationRelativeTo(null);
        telaCadastroPaciente.setVisible(true);
    }//GEN-LAST:event_cadastrarPacienteButtonActionPerformed

    private void cadastrarConsultaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarConsultaButtonActionPerformed
        dispose();
        TelaCadastroConsulta telaCadastroConsulta = new TelaCadastroConsulta();
        telaCadastroConsulta.setResizable(false);
        telaCadastroConsulta.setLocationRelativeTo(null);
        telaCadastroConsulta.setVisible(true);
    }//GEN-LAST:event_cadastrarConsultaButtonActionPerformed

    private void cadastrarPlanoDeSaudeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPlanoDeSaudeButtonActionPerformed
        dispose();
        TelaCadastroPlanoDeSaude telaCadastroPlanoDeSaude = new TelaCadastroPlanoDeSaude();
        telaCadastroPlanoDeSaude.setResizable(false);
        telaCadastroPlanoDeSaude.setLocationRelativeTo(null);
        telaCadastroPlanoDeSaude.setVisible(true);
    }//GEN-LAST:event_cadastrarPlanoDeSaudeButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        dispose();
        TelaLogin telaCadastro = new TelaLogin();
        telaCadastro.setResizable(false);
        telaCadastro.setLocationRelativeTo(null);
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_voltarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarConsultaButton;
    private javax.swing.JButton cadastrarMedicoButton;
    private javax.swing.JButton cadastrarPacienteButton;
    private javax.swing.JButton cadastrarPlanoDeSaudeButton;
    private javax.swing.JScrollPane tituloScrollPanel;
    private javax.swing.JTextArea tituloTextArea;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}