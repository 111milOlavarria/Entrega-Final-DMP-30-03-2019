package Swing;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import dmp.*;
import conexion.*;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Registro extends javax.swing.JFrame {

    PreguntaClave pc;
    IniSesion is;
    RegMed registm;
    RegInv registi;
    UsuarioPaciente up;
    ConexionSQL csql;
    Menu menu = new Menu();
    int compartirDatos;

    public Registro() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    boolean sexoVacio(String sexo) {
        boolean retorno;
        if (sexo == "Seleccione:") {
            retorno = true;
        } else {
            retorno = false;
        }
        return retorno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPasswordField1 = new javax.swing.JPasswordField();
        btn_salir = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtSexo = new javax.swing.JComboBox<>();
        btn_regMed = new javax.swing.JButton();
        btn_regInv = new javax.swing.JButton();
        btn_registrar = new javax.swing.JButton();
        checkBox = new javax.swing.JCheckBox();
        scroll = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtLocalidad = new javax.swing.JTextField();
        jLabel1Fnd2 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Cerrar1.png"))); // NOI18N
        btn_salir.setBorder(null);
        btn_salir.setBorderPainted(false);
        btn_salir.setContentAreaFilled(false);
        btn_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/atras.png"))); // NOI18N
        btn_volver.setBorder(null);
        btn_volver.setBorderPainted(false);
        btn_volver.setContentAreaFilled(false);
        btn_volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        getContentPane().add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dni");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha Nacimiento");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Telefono");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Correo");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sexo");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, 20));

        txtUsuario.setBackground(new java.awt.Color(153, 255, 255));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 180, 25));

        txtNombre.setBackground(new java.awt.Color(153, 255, 255));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 180, 25));

        txtApellido.setBackground(new java.awt.Color(153, 255, 255));
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 180, 25));

        txtDni.setBackground(new java.awt.Color(153, 255, 255));
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        getContentPane().add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 180, 25));

        txtFechaNacimiento.setBackground(new java.awt.Color(153, 255, 255));
        txtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoActionPerformed(evt);
            }
        });
        getContentPane().add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 180, 25));

        txtTelefono.setBackground(new java.awt.Color(153, 255, 255));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 180, 25));

        txtCorreo.setBackground(new java.awt.Color(153, 255, 255));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 180, 25));

        txtPassword.setBackground(new java.awt.Color(153, 255, 255));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 180, 25));

        txtSexo.setBackground(new java.awt.Color(153, 255, 255));
        txtSexo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:", "Masculino", "Femenino" }));
        txtSexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexoActionPerformed(evt);
            }
        });
        getContentPane().add(txtSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 110, -1));

        btn_regMed.setBackground(new java.awt.Color(51, 102, 255));
        btn_regMed.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_regMed.setForeground(new java.awt.Color(255, 255, 255));
        btn_regMed.setText("Medico");
        btn_regMed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_regMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regMedActionPerformed(evt);
            }
        });
        getContentPane().add(btn_regMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 90, -1));

        btn_regInv.setBackground(new java.awt.Color(51, 102, 255));
        btn_regInv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_regInv.setForeground(new java.awt.Color(255, 255, 255));
        btn_regInv.setText("Investigador");
        btn_regInv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_regInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regInvActionPerformed(evt);
            }
        });
        getContentPane().add(btn_regInv, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 650, -1, -1));

        btn_registrar.setBackground(new java.awt.Color(51, 102, 255));
        btn_registrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_registrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_registrar.setText("Registrar");
        btn_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 650, 100, -1));

        checkBox.setContentAreaFilled(false);
        checkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });
        getContentPane().add(checkBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 30, 40));

        textArea.setEditable(false);
        textArea.setBackground(new java.awt.Color(0, 153, 255));
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textArea.setForeground(new java.awt.Color(255, 255, 255));
        textArea.setRows(2);
        textArea.setText("Desea compartir sus datos de analisis de forma anonima \npara ayudara futuras investigaciones medicas.");
        textArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea.setSelectionColor(new java.awt.Color(0, 153, 255));
        scroll.setViewportView(textArea);

        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 330, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Registro De Paciente");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Direccion");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        txtDireccion.setBackground(new java.awt.Color(153, 255, 255));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 180, 25));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Localidad");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        txtLocalidad.setBackground(new java.awt.Color(153, 255, 255));
        txtLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalidadActionPerformed(evt);
            }
        });
        getContentPane().add(txtLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, 180, 25));

        jLabel1Fnd2.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1Fnd2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1Fnd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/FondoRegistro (2).png"))); // NOI18N
        jLabel1Fnd2.setText("jLabel1");
        getContentPane().add(jLabel1Fnd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtUsuario.transferFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        is = new IniSesion();
        is.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(1);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        txtPassword.transferFocus();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtNombre.transferFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        txtApellido.transferFocus();
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        txtDni.transferFocus();
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoActionPerformed
        txtFechaNacimiento.transferFocus();
    }//GEN-LAST:event_txtFechaNacimientoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        txtTelefono.transferFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        txtCorreo.transferFocus();
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSexoActionPerformed
        txtSexo.transferFocus();
    }//GEN-LAST:event_txtSexoActionPerformed

    private void btn_regMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regMedActionPerformed
        registm = new RegMed();
        registm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_regMedActionPerformed

    private void btn_regInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regInvActionPerformed
        registi = new RegInv();
        registi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_regInvActionPerformed

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        pc = new PreguntaClave();
        up = new UsuarioPaciente();
        String error = "0";
        String usuario, contraseña, nombre, apellido, dni, fechaNacimiento, telefono, mail, direccion, sexo, localidad;
        up = new UsuarioPaciente();
        csql = new ConexionSQL();

        usuario = (txtUsuario.getText());

        if (usuario.compareTo(error) == 0) {
            JOptionPane.showMessageDialog(this, "No se Puede Utilizar el Nombre de Usuario: " + usuario, "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        contraseña = (txtPassword.getText());
        if (contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        nombre = (txtNombre.getText());
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        apellido = (txtApellido.getText());
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        dni = (txtDni.getText());

        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        fechaNacimiento = (txtFechaNacimiento.getText());
        if (fechaNacimiento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        telefono = (txtTelefono.getText());
        if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        mail = (txtCorreo.getText());
        if (mail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        direccion = (txtDireccion.getText());
        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        localidad = (txtLocalidad.getText());
        if (localidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        sexo = txtSexo.getSelectedItem().toString();

        if (this.sexoVacio(sexo) == true) {
            JOptionPane.showMessageDialog(this, "Por Favor Seleccione Un Sexo", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            sexoVacio(sexo);
        } else {

            if (csql.verificarUsuario(txtUsuario.getText()) == false) {
                txtUsuario.setText("");
                JOptionPane.showMessageDialog(this, "Nombre de Usuario ya Existente", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
                csql.verificarUsuario(txtUsuario.getText());
            } else {

                if (checkBox.isEnabled() == true) {
                    compartirDatos = 1;
                } else {
                    compartirDatos = 0;
                }

                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fechaNac = LocalDate.parse(txtFechaNacimiento.getText(), fmt);
                LocalDate ahora = LocalDate.now();
                Period periodo = Period.between(fechaNac, ahora);
                int edad = periodo.getYears();

                up.setUsuario(txtUsuario.getText());
                up.setContraseña(txtPassword.getText());
                up.setNombre(txtNombre.getText());
                up.setApellido(txtApellido.getText());
                up.setDni(txtDni.getText());
                up.setFechaNacimiento(txtFechaNacimiento.getText());
                up.setTelefono(txtTelefono.getText());
                up.setMail(txtCorreo.getText());
                up.setDireccion(txtDireccion.getText());
                up.setLocalidad(txtLocalidad.getText());
                up.setSexo(sexo);
                up.setCompartirDatos(compartirDatos);
                up.setEdad(edad);
                csql.insertPaciente(up);

                try {
                    if (csql.verificarConexion()) {
                        JOptionPane.showMessageDialog(null, "Registro Exitoso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error de Registro");
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
        }
    }//GEN-LAST:event_btn_registrarActionPerformed

    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed

    }//GEN-LAST:event_checkBoxActionPerformed

    private void txtLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalidadActionPerformed
        txtLocalidad.transferFocus();
    }//GEN-LAST:event_txtLocalidadActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        txtDireccion.transferFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    void limpiar() {
        txtUsuario.setText("");
        txtPassword.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtFechaNacimiento.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_regInv;
    private javax.swing.JButton btn_regMed;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_volver;
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel1Fnd2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JComboBox<String> txtSexo;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
