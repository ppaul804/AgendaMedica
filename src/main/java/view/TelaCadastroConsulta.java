/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import controllers.ConsultaController;
import datasouces.hsqldb.models.Consulta;

/**
 *
 * @author Paul-PC
 */
public class TelaCadastroConsulta extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroConsulta
     */
    public TelaCadastroConsulta() {
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
        formularioPanel = new javax.swing.JPanel();
        idPlanoLabel = new javax.swing.JLabel();
        idPlanoTextField = new javax.swing.JTextField();
        crmMedicoLabel = new javax.swing.JLabel();
        crmMedicoTextField = new javax.swing.JTextField();
        idPacienteLabel = new javax.swing.JLabel();
        idPacienteTextField = new javax.swing.JTextField();
        salaLabel = new javax.swing.JLabel();
        salaTextField = new javax.swing.JTextField();
        dataDaConsultaLabel = new javax.swing.JLabel();
        dataDaConsultaFormatadoTextField = new javax.swing.JFormattedTextField();
        horaDaConsultaLabel = new javax.swing.JLabel();
        horaDaConsultaFormatadoTextField = new javax.swing.JFormattedTextField();
        cadastrarButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloTextArea.setEditable(false);
        tituloTextArea.setColumns(20);
        tituloTextArea.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        tituloTextArea.setRows(5);
        tituloTextArea.setText(" ___                   _        __ __         _  _           \n| . | ___  ___ ._ _  _| | ___  |  \\  \\ ___  _| |<_> ___  ___ \n|   |/ . |/ ._>| ' |/ . |<_> | |     |/ ._>/ . || |/ | '<_> |\n|_|_|\\_. |\\___.|_|_|\\___|<___| |_|_|_|\\___.\\___||_|\\_|_.<___|\n     <___'                                                   ");
        tituloScrollPanel.setViewportView(tituloTextArea);

        formularioPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulário de cadastro de consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        idPlanoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idPlanoLabel.setText("ID PLANO");

        idPlanoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPlanoTextFieldActionPerformed(evt);
            }
        });

        crmMedicoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        crmMedicoLabel.setText("CRM MÉDICO");

        crmMedicoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crmMedicoTextFieldActionPerformed(evt);
            }
        });

        idPacienteLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idPacienteLabel.setText("ID PACIENTE");

        idPacienteTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPacienteTextFieldActionPerformed(evt);
            }
        });

        salaLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salaLabel.setText("SALA");

        salaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaTextFieldActionPerformed(evt);
            }
        });

        dataDaConsultaLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dataDaConsultaLabel.setText("DATA DA CONSULTA");

        try {
            dataDaConsultaFormatadoTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        horaDaConsultaLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        horaDaConsultaLabel.setText("HORA DA CONSUTA");

        try {
            horaDaConsultaFormatadoTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cadastrarButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cadastrarButton.setText("CADASTRAR");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        voltarButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        voltarButton.setText("VOLTAR");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formularioPanelLayout = new javax.swing.GroupLayout(formularioPanel);
        formularioPanel.setLayout(formularioPanelLayout);
        formularioPanelLayout.setHorizontalGroup(
            formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formularioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formularioPanelLayout.createSequentialGroup()
                        .addComponent(voltarButton)
                        .addGap(188, 188, 188)
                        .addComponent(cadastrarButton))
                    .addGroup(formularioPanelLayout.createSequentialGroup()
                        .addGroup(formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataDaConsultaLabel)
                            .addComponent(horaDaConsultaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horaDaConsultaFormatadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataDaConsultaFormatadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formularioPanelLayout.createSequentialGroup()
                            .addComponent(idPacienteLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(idPacienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salaLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(salaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formularioPanelLayout.createSequentialGroup()
                            .addComponent(idPlanoLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(idPlanoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(crmMedicoLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(crmMedicoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        formularioPanelLayout.setVerticalGroup(
            formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formularioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idPlanoLabel)
                    .addComponent(idPlanoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crmMedicoLabel)
                    .addComponent(crmMedicoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idPacienteLabel)
                        .addComponent(idPacienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(salaLabel)
                        .addComponent(salaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataDaConsultaLabel)
                    .addComponent(dataDaConsultaFormatadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horaDaConsultaLabel)
                    .addComponent(horaDaConsultaFormatadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formularioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarButton)
                    .addComponent(voltarButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(formularioPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(tituloScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(formularioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaTextFieldActionPerformed

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        ConsultaController consultaController = new ConsultaController();
        Consulta consulta = new Consulta();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm");

        try {
            consulta.setIdPlanoDeSaude(Integer.parseInt(idPlanoTextField.getText()));
            consulta.setIdPaciente(Integer.parseInt(idPacienteTextField.getText()));
            consulta.setCrmMedico(Integer.parseInt(crmMedicoTextField.getText()));
            consulta.setSala(salaTextField.getText());
            consulta.setDataDaConsulta(LocalDate.parse(dataDaConsultaFormatadoTextField.getText(), dateFormatter));
            consulta.setHoraDaConsulta(LocalTime.parse(horaDaConsultaFormatadoTextField.getText(), timeFormatter));

            consultaController.cadastrarConsulta(consulta);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(null, "Data e/ou hora da consulta inválida", "ERRO",
                JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_cadastrarButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        dispose();

        TelaSistema telaSistema = new TelaSistema();
        telaSistema.setResizable(false);
        telaSistema.setLocationRelativeTo(null);
        telaSistema.setVisible(true);
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void idPlanoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPlanoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPlanoTextFieldActionPerformed

    private void idPacienteTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPacienteTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPacienteTextFieldActionPerformed
    
    private void crmMedicoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:crmMedicoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:crmMedicoTextFieldActionPerformed
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
            java.util.logging.Logger.getLogger(TelaCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JLabel crmMedicoLabel;
    private javax.swing.JTextField crmMedicoTextField;
    private javax.swing.JFormattedTextField dataDaConsultaFormatadoTextField;
    private javax.swing.JLabel dataDaConsultaLabel;
    private javax.swing.JPanel formularioPanel;
    private javax.swing.JFormattedTextField horaDaConsultaFormatadoTextField;
    private javax.swing.JLabel horaDaConsultaLabel;
    private javax.swing.JLabel idPacienteLabel;
    private javax.swing.JTextField idPacienteTextField;
    private javax.swing.JLabel idPlanoLabel;
    private javax.swing.JTextField idPlanoTextField;
    private javax.swing.JLabel salaLabel;
    private javax.swing.JTextField salaTextField;
    private javax.swing.JScrollPane tituloScrollPanel;
    private javax.swing.JTextArea tituloTextArea;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
