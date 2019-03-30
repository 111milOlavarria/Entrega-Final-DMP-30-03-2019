package Swing;

import conexion.*;
import dmp.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RegInv extends javax.swing.JFrame {

    UsuarioInvestigador ui;
    ConexionSQL csql;
    IniSesion is;
    Registro regist;
    PreguntaClave pc;

    public RegInv() {
        initComponents();
        this.setLocationRelativeTo(null);
        limpiar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtNombreCompania = new javax.swing.JTextField();
        txtCodigoValidacion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtCorreo = new javax.swing.JTextField();
        btn_Registrar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1RegInv = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Cerrar3.png"))); // NOI18N
        btn_salir.setBorder(null);
        btn_salir.setBorderPainted(false);
        btn_salir.setContentAreaFilled(false);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Compania");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Codigo Validacion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Correo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(153, 255, 255));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 170, 25));

        txtNombreCompania.setBackground(new java.awt.Color(153, 255, 255));
        txtNombreCompania.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCompaniaActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreCompania, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 170, 25));

        txtCodigoValidacion.setBackground(new java.awt.Color(153, 255, 255));
        txtCodigoValidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoValidacionActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigoValidacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 170, 25));

        txtTelefono.setBackground(new java.awt.Color(153, 255, 255));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 170, 25));

        txtPassword.setBackground(new java.awt.Color(153, 255, 255));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 170, 25));

        txtCorreo.setBackground(new java.awt.Color(153, 255, 255));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 170, 25));

        btn_Registrar.setBackground(new java.awt.Color(51, 102, 255));
        btn_Registrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Registrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Registrar.setText("Registrar");
        btn_Registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 380, 100, -1));

        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/atras.png"))); // NOI18N
        btn_volver.setBorder(null);
        btn_volver.setBorderPainted(false);
        btn_volver.setContentAreaFilled(false);
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        getContentPane().add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Registro De Investigador");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel1RegInv.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1RegInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/FndRegInv.png"))); // NOI18N
        jLabel1RegInv.setText("jLabel1");
        getContentPane().add(jLabel1RegInv, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtUsuario.transferFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        txtPassword.transferFocus();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtNombreCompaniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCompaniaActionPerformed
        txtNombreCompania.transferFocus();
    }//GEN-LAST:event_txtNombreCompaniaActionPerformed

    private void txtCodigoValidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoValidacionActionPerformed
        txtCodigoValidacion.transferFocus();
    }//GEN-LAST:event_txtCodigoValidacionActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        txtTelefono.transferFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        txtCorreo.transferFocus();
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed

        String usuario, contraseña, nombreCompania, codigoValidacion, telefono, correo, sexo;
        ui = new UsuarioInvestigador();
        csql = new ConexionSQL();

        usuario = (txtUsuario.getText());
        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        contraseña = (txtPassword.getText());
        if (contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        nombreCompania = (txtNombreCompania.getText());
        if (nombreCompania.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        codigoValidacion = (txtCodigoValidacion.getText());
        if (codigoValidacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        telefono = (txtTelefono.getText());

        if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        correo = (txtCorreo.getText());
        if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (csql.verificarUsuario(txtUsuario.getText()) == false) {
            txtUsuario.setText("");
            JOptionPane.showMessageDialog(this, "Nombre de Usuario ya Existente", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            csql.verificarUsuario(txtUsuario.getText());
        } else if (csql.verificarCV(txtCodigoValidacion.getText()) == false) {
            txtCodigoValidacion.setText("");
            JOptionPane.showMessageDialog(this, "Codigo de Validacion Incorrecto", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            csql.verificarCV(txtCodigoValidacion.getText());
        } else {
            ui.setUsuario(txtUsuario.getText());
            ui.setContraseña(txtPassword.getText());
            ui.setNombreDeCompania(txtNombreCompania.getText());
            ui.setCodigoDeValidacion(txtCodigoValidacion.getText());
            ui.setTelefono(txtTelefono.getText());
            ui.setMail(txtCorreo.getText());

            csql.insertInvestigador(ui);

            try {
                if (csql.verificarConexion()) {
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                } else {
                    JOptionPane.showMessageDialog(null, "Error de registro");
                }
            } catch (SQLException ex) {

            }
            int i = JOptionPane.showConfirmDialog(null, "¿Desea Establecer La Pregunta De Seguridad En Caso De Olvidar Su Contraseña?", "Pregunta De Seguridad", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (i != 1) {
                pc.setVisible(true);
                pc.user = txtUsuario.getText();
                this.setVisible(false);
                limpiar();
            } else {
                is = new IniSesion();
                is.setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btn_RegistrarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(1);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        regist = new Registro();
        regist.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_volverActionPerformed

    void limpiar() {
        txtUsuario.setText("");
        txtPassword.setText("");
        txtNombreCompania.setText("");
        txtCodigoValidacion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1RegInv;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCodigoValidacion;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombreCompania;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
