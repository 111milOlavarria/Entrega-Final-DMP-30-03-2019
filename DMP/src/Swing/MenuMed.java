package Swing;

import conexion.ConexionSQL;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.*;

public class MenuMed extends javax.swing.JFrame {

    List<String> dest = new ArrayList();
    VerHistoriaClinicaPacientes vhcp;
    PreguntaClaveMedico pcm;
    VerListadoPacientes vlp;
    VerMensajeMedico vmm;
    ConexionSQL csql;
    IniSesion is;
    ModificarPerfilMedico mdm;
    String u;
    String usuario;
    String password;
    String nombre;
    String apellido;
    String medNombre;
    String medApellido;
    AgregarEnfermedad adde;
    String matricula;
    String mensajeDe;

    public MenuMed() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void recibirMatricula() {
        String n;
        String a;
        csql = new ConexionSQL();
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT usuario, nombre, apellido, matricula FROM dmp.usuarios WHERE usuario LIKE'" + u + "';");
            if (csql.resultado.next()) {
                matricula = csql.resultado.getString("matricula");
                medNombre = csql.resultado.getString("nombre");
                medApellido = csql.resultado.getString("apellido");
                mensajeDe = medNombre + " " + medApellido;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        actualizarDestinatarios();
    }

    public void actualizarDestinatarios() {
        csql = new ConexionSQL();
        String destinatario;
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT usuario FROM especialistas WHERE idMatricula LIKE '" + matricula + "';");
            while (csql.resultado.next()) {
                dest.add(csql.resultado.getString("usuario"));
            }
            for (int i = 0; i < dest.size(); i++) {
                csql.resultado = csql.consulta.executeQuery("SELECT nombre, apellido FROM usuarios WHERE usuario LIKE '" + dest.get(i) + "';");

                if (csql.resultado.next()) {
                    nombre = csql.resultado.getString("nombre");
                    apellido = csql.resultado.getString("apellido");
                    destinatario = nombre + " " + apellido;
                    seleccionarDestinatario.addItem(destinatario);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void destinatario() {
        csql = new ConexionSQL();
        String destinatario;
        String comparacion = seleccionarDestinatario.getSelectedItem().toString();
        if (errorDestinatario(comparacion) == true) {
            JOptionPane.showMessageDialog(this, "Por Favor Seleccione Un Destinatario", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            errorDestinatario(comparacion);
        }
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT usuario, nombre, apellido FROM dmp.usuarios;");
            while (csql.resultado.next()) {
                nombre = csql.resultado.getString("nombre");
                apellido = csql.resultado.getString("apellido");
                destinatario = nombre + " " + apellido;
                if (comparacion.compareTo(destinatario) == 0) {
                    usuario = csql.resultado.getString("usuario");
                    JOptionPane.showMessageDialog(null, "Mensaje Enviado");;
                    Calendar Calendario = Calendar.getInstance();
                    String fecha = Calendario.get(Calendario.DATE) + "/" + (Calendario.get(Calendario.MONTH) + 1) + "/" + Calendario.get(Calendario.YEAR) + " " + Calendario.get(Calendario.HOUR_OF_DAY) + ":" + Calendario.get(Calendario.MINUTE) + ":" + Calendario.get(Calendario.SECOND);
                    csql.enviarMensajeMedicoAPaciente(usuario, txtMensaje.getText(), fecha, mensajeDe);
                    txtMensaje.setText("");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean mensajeVacio(String mensaje) {
        boolean retorno;
        if (mensaje.isEmpty()) {
            retorno = true;
        } else {
            retorno = false;
        }
        return retorno;
    }

    public boolean errorDestinatario(String comparacion) {
        boolean retorno;
        if (comparacion == "Seleccionar Destinatario:") {
            retorno = true;
        } else {
            retorno = false;
        }
        return retorno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlMedmnu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        btn_minimizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pnlMedmnu1 = new javax.swing.JPanel();
        btn_modificarPerfil = new javax.swing.JButton();
        btn_preguntaSeguridad = new javax.swing.JButton();
        btn_borrarCuenta = new javax.swing.JButton();
        btn_cerrarSesion = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btn_verPacientes = new javax.swing.JButton();
        btn_verHistoriaClinica = new javax.swing.JButton();
        btn_agregarEnfermedad = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMensaje = new javax.swing.JTextField();
        seleccionarDestinatario = new javax.swing.JComboBox<>();
        btn_enviar = new javax.swing.JButton();
        btn_verMensajes = new javax.swing.JButton();
        jLabelFndMenMed = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(71, 98, 98));

        pnlMedmnu.setBackground(new java.awt.Color(71, 98, 98));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu3.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMedmnuLayout = new javax.swing.GroupLayout(pnlMedmnu);
        pnlMedmnu.setLayout(pnlMedmnuLayout);
        pnlMedmnuLayout.setHorizontalGroup(
            pnlMedmnuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMedmnuLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 70, Short.MAX_VALUE))
        );
        pnlMedmnuLayout.setVerticalGroup(
            pnlMedmnuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMedmnuLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Cerrar Menu.png"))); // NOI18N
        btn_salir.setBorder(null);
        btn_salir.setBorderPainted(false);
        btn_salir.setContentAreaFilled(false);
        btn_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Minimizar Menu.png"))); // NOI18N
        btn_minimizar.setBorder(null);
        btn_minimizar.setBorderPainted(false);
        btn_minimizar.setContentAreaFilled(false);
        btn_minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minimizarActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Menu Médico");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlMedmnu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(btn_minimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_salir))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(pnlMedmnu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_minimizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_salir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 30));

        pnlMedmnu1.setBackground(new java.awt.Color(71, 98, 98));

        btn_modificarPerfil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_modificarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add_insert_new_1.png"))); // NOI18N
        btn_modificarPerfil.setText("Modificar Perfil");
        btn_modificarPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificarPerfil.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_modificarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarPerfilActionPerformed(evt);
            }
        });

        btn_preguntaSeguridad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_preguntaSeguridad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pencil_1.png"))); // NOI18N
        btn_preguntaSeguridad.setText("Pregunta Seguridad");
        btn_preguntaSeguridad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_preguntaSeguridad.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_preguntaSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preguntaSeguridadActionPerformed(evt);
            }
        });

        btn_borrarCuenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_borrarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete_remove_exit_1.png"))); // NOI18N
        btn_borrarCuenta.setText("Borrar Cuenta");
        btn_borrarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_borrarCuenta.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_borrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarCuentaActionPerformed(evt);
            }
        });

        btn_cerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/off_logout_1.png"))); // NOI18N
        btn_cerrarSesion.setText("Cerrar Sesion");
        btn_cerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarSesionActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu4.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMedmnu1Layout = new javax.swing.GroupLayout(pnlMedmnu1);
        pnlMedmnu1.setLayout(pnlMedmnu1Layout);
        pnlMedmnu1Layout.setHorizontalGroup(
            pnlMedmnu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_borrarCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMedmnu1Layout.createSequentialGroup()
                .addGroup(pnlMedmnu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMedmnu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_preguntaSeguridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_modificarPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton6))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlMedmnu1Layout.setVerticalGroup(
            pnlMedmnu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMedmnu1Layout.createSequentialGroup()
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modificarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_preguntaSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btn_borrarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(pnlMedmnu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -270, 170, 270));

        btn_verPacientes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_verPacientes.setText("Ver Listado De Pacientes");
        btn_verPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_verPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verPacientesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_verPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 220, 50));

        btn_verHistoriaClinica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_verHistoriaClinica.setText(" Ver Historias Clinicas");
        btn_verHistoriaClinica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_verHistoriaClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verHistoriaClinicaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_verHistoriaClinica, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 210, 50));

        btn_agregarEnfermedad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_agregarEnfermedad.setText("Ver/Agregar Nueva Enfermedades");
        btn_agregarEnfermedad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_agregarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarEnfermedadActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregarEnfermedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 230, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buzon De Consultas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        txtMensaje.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 620, 80));

        seleccionarDestinatario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        seleccionarDestinatario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Destinatario:" }));
        seleccionarDestinatario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seleccionarDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarDestinatarioActionPerformed(evt);
            }
        });
        getContentPane().add(seleccionarDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 170, -1));

        btn_enviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_enviar.setForeground(new java.awt.Color(255, 255, 255));
        btn_enviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/env4.png"))); // NOI18N
        btn_enviar.setText("Enviar");
        btn_enviar.setBorder(null);
        btn_enviar.setBorderPainted(false);
        btn_enviar.setContentAreaFilled(false);
        btn_enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_enviar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_enviar.setIconTextGap(-3);
        btn_enviar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_enviar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, -1, 80));

        btn_verMensajes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_verMensajes.setText("Ver Mensajes");
        btn_verMensajes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_verMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verMensajesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_verMensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, 20));

        jLabelFndMenMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/FndMenMed.png"))); // NOI18N
        getContentPane().add(jLabelFndMenMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.pnlMedmnu.setVisible(false);
        this.pnlMedmnu1.setVisible(true);
        int posicion = this.pnlMedmnu.getX();
        if (posicion > -1) {
            Animacion.Animacion.bajar(1, 1, 5, 5, pnlMedmnu1);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.pnlMedmnu1.setVisible(false);
        this.pnlMedmnu.setVisible(true);
        int posicion = this.pnlMedmnu1.getX();
        if (posicion > 1) {
            Animacion.Animacion.subir(0, -270, 5, 5, pnlMedmnu1);
        }
        this.pnlMedmnu.setSize(1, 1);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_verHistoriaClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verHistoriaClinicaActionPerformed
        vhcp = new VerHistoriaClinicaPacientes();
        vhcp.setVisible(true);
        vhcp.user = this.u;
        vhcp.matricula = this.matricula;
        vhcp.mostrarTabla(dest);
        this.setVisible(false);
    }//GEN-LAST:event_btn_verHistoriaClinicaActionPerformed

    private void btn_modificarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarPerfilActionPerformed
        mdm = new ModificarPerfilMedico();
        mdm.setVisible(true);
        mdm.user = this.u;
        this.setVisible(false);
    }//GEN-LAST:event_btn_modificarPerfilActionPerformed

    private void btn_preguntaSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preguntaSeguridadActionPerformed
        pcm = new PreguntaClaveMedico();
        pcm.setVisible(true);
        pcm.user = this.u;
        pcm.matricula = this.matricula;
        this.setVisible(false);
    }//GEN-LAST:event_btn_preguntaSeguridadActionPerformed

    private void btn_borrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarCuentaActionPerformed
        csql = new ConexionSQL();
        is = new IniSesion();
        int i = JOptionPane.showConfirmDialog(null, "Realmente desea Eliminar su Usuario", "Borrar Cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i != 1) {
            csql.eliminarMI(u);
            this.setVisible(false);
            is.setVisible(true);
        }
    }//GEN-LAST:event_btn_borrarCuentaActionPerformed

    private void btn_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarSesionActionPerformed
        is = new IniSesion();
        int i = JOptionPane.showConfirmDialog(null, "Realmente Desea Cerrar Sesion", "Cerrar Sesion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i != 1) {
            is.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btn_cerrarSesionActionPerformed

    private void btn_verPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verPacientesActionPerformed
        vlp = new VerListadoPacientes();
        vlp.setVisible(true);
        vlp.matricula = this.matricula;
        vlp.user = this.u;
        vlp.nombre = this.nombre;
        vlp.apellido = this.apellido;
        vlp.recibirPacientes();
        this.setVisible(false);
    }//GEN-LAST:event_btn_verPacientesActionPerformed

    private void btn_agregarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarEnfermedadActionPerformed
        adde = new AgregarEnfermedad();
        adde.setVisible(true);
        adde.matricula = this.matricula;
        adde.user = this.u;
        this.setVisible(false);
    }//GEN-LAST:event_btn_agregarEnfermedadActionPerformed

    private void seleccionarDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarDestinatarioActionPerformed

    }//GEN-LAST:event_seleccionarDestinatarioActionPerformed

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        if (mensajeVacio(txtMensaje.getText())) {
            JOptionPane.showMessageDialog(this, "Por Favor Redacte Un Mensaje Antes De Enviar", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            mensajeVacio(txtMensaje.getText());
        } else {
            destinatario();
        }
    }//GEN-LAST:event_btn_enviarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Desea Salir", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i != 1) {
            System.exit(1);
        }
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_verMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verMensajesActionPerformed
        vmm = new VerMensajeMedico();
        vmm.setVisible(true);
        vmm.matricula = this.matricula;
        vmm.user = this.u;
        vmm.listaDeMensajes();
        this.setVisible(false);
    }//GEN-LAST:event_btn_verMensajesActionPerformed

    private void btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btn_minimizarActionPerformed

    void recibirString(String UserName) {
        u = UserName;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregarEnfermedad;
    private javax.swing.JButton btn_borrarCuenta;
    private javax.swing.JButton btn_cerrarSesion;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JButton btn_minimizar;
    private javax.swing.JButton btn_modificarPerfil;
    private javax.swing.JButton btn_preguntaSeguridad;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_verHistoriaClinica;
    private javax.swing.JButton btn_verMensajes;
    private javax.swing.JButton btn_verPacientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFndMenMed;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlMedmnu;
    private javax.swing.JPanel pnlMedmnu1;
    private javax.swing.JComboBox<String> seleccionarDestinatario;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables
}
