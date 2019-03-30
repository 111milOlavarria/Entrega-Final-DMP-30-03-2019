package Swing;

import javax.swing.JOptionPane;
import conexion.ConexionSQL;
import dmp.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

public class Menu extends javax.swing.JFrame {

    VerMensajePaciente vmp;
    VerResultados vr;
    VerEspecialistas ve;
    IniSesion is;
    PreguntaClavePaciente pcp;
    ConexionSQL csql;
    ModificarPerfil md;
    CargarHistoriaClinica chc;
    String u;
    String userMedicoMatricula;
    String userMedico;
    String password;
    AddValores av;
    ListadoVacunas lv;
    VerHistorial vh;
    String nombre;
    String apellido;
    String mensajeDe;

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    void rellenarCuadro() {
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT * FROM dmp.usuarios WHERE usuario LIKE'" + u + "'");
            if (csql.resultado.next()) {
                this.txtCuadroUsuario.setText(csql.resultado.getString("nombre"));
                this.txtCuadroApellido.setText(csql.resultado.getString("apellido"));
                this.txtCuadroDireccion.setText(csql.resultado.getString("direccion"));
                this.txtCuadroTelefono.setText(csql.resultado.getString("telefono"));
                this.txtCuadrioMail.setText(csql.resultado.getString("mail"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void obtenerMatricula(String nomb, String apell) {
        csql = new ConexionSQL();
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT idMatricula FROM dmp.especialistas WHERE usuario LIKE'" + u + "' AND nombre LIKE'" + nomb + "' AND apellido LIKE'" + apell + "';");
            if (csql.resultado.next()) {
                userMedicoMatricula = csql.resultado.getString("idMatricula");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("" + userMedicoMatricula);
    }

    public void obtenerMedico() {
        csql = new ConexionSQL();
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT usuario FROM dmp.usuarios WHERE matricula LIKE'" + userMedicoMatricula + "';");
            if (csql.resultado.next()) {
                userMedico = csql.resultado.getString("usuario");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void actualizarDestinatarios() {
        csql = new ConexionSQL();
        mensajede();
        String destinatario;
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT nombre, apellido FROM dmp.especialistas WHERE usuario LIKE'" + u + "';");

            while (csql.resultado.next()) {
                nombre = csql.resultado.getString("nombre");
                apellido = csql.resultado.getString("apellido");
                destinatario = nombre + " " + apellido;
                this.seleccionarDestinatario.addItem(destinatario);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void mensajede() {
        csql = new ConexionSQL();
        String apell;
        String nomb;
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT usuario, nombre, apellido, matricula FROM dmp.usuarios WHERE usuario LIKE'" + u + "';");
            if (csql.resultado.next()) {
                nomb = csql.resultado.getString("nombre");
                apell = csql.resultado.getString("apellido");
                mensajeDe = nomb + " " + apell;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void destinatario() {
        csql = new ConexionSQL();
        String destinatario;
        String comparacion = seleccionarDestinatario.getSelectedItem().toString();
        String idMatricula;
        if (errorDestinatario(comparacion) == true) {
            JOptionPane.showMessageDialog(this, "Por Favor Seleccione Un Destinatario", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            errorDestinatario(comparacion);
        }
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT nombre, apellido FROM dmp.especialistas WHERE usuario LIKE'" + u + "';");
            while (csql.resultado.next()) {
                nombre = csql.resultado.getString("nombre");
                apellido = csql.resultado.getString("apellido");
                destinatario = nombre + " " + apellido;
                if (comparacion.compareTo(destinatario) == 0) {
                    obtenerMatricula(nombre, apellido);
                    obtenerMedico();
                    Calendar Calendario = Calendar.getInstance();
                    String fecha = Calendario.get(Calendario.DATE) + "/" + (Calendario.get(Calendario.MONTH) + 1) + "/" + Calendario.get(Calendario.YEAR) + " " + Calendario.get(Calendario.HOUR_OF_DAY) + ":" + Calendario.get(Calendario.MINUTE) + ":" + Calendario.get(Calendario.SECOND);
                    csql.enviarMensajePacienteAMedico(txtMensaje.getText(), fecha, mensajeDe, userMedico);
                    JOptionPane.showMessageDialog(null, "Mensaje Enviado");
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
        if (comparacion == "Seleccione Destinatario:") {
            retorno = true;
        } else {
            retorno = false;
        }
        return retorno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();
        btn_Minimizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMensaje = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pnlMenu1 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        btn_modificarPerfil = new javax.swing.JButton();
        btn_preguntaDeSeguridad = new javax.swing.JButton();
        btn_borrarCuenta = new javax.swing.JButton();
        btn_cerrarSesion = new javax.swing.JButton();
        panelDatosUsuario = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCuadroUsuario = new javax.swing.JTextField();
        txtCuadroApellido = new javax.swing.JTextField();
        txtCuadroDireccion = new javax.swing.JTextField();
        txtCuadroTelefono = new javax.swing.JTextField();
        txtCuadrioMail = new javax.swing.JTextField();
        btn_enviarMensaje = new javax.swing.JButton();
        btn_agregarValores = new javax.swing.JButton();
        btn_verEspecialistas = new javax.swing.JButton();
        btn_verResultados = new javax.swing.JButton();
        btn_cargarHistoriaClinica = new javax.swing.JButton();
        btn_verHistorial = new javax.swing.JButton();
        seleccionarDestinatario = new javax.swing.JComboBox<>();
        btn_listadoDeVacunas = new javax.swing.JButton();
        btn_verMensajes = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();
        publicidadAbajo = new javax.swing.JPanel();
        publicidad1 = new javax.swing.JLabel();
        publicidad2 = new javax.swing.JLabel();
        publicidadDerecha = new javax.swing.JPanel();
        publicidad3 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        pnlMenu.setBackground(new java.awt.Color(51, 102, 255));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu.png"))); // NOI18N
        jButton14.setBorder(null);
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(jButton14)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Cerrar Menu.png"))); // NOI18N
        btn_cerrar.setBorder(null);
        btn_cerrar.setBorderPainted(false);
        btn_cerrar.setContentAreaFilled(false);
        btn_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        btn_Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Minimizar Menu.png"))); // NOI18N
        btn_Minimizar.setBorder(null);
        btn_Minimizar.setBorderPainted(false);
        btn_Minimizar.setContentAreaFilled(false);
        btn_Minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MinimizarActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Menu Usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(278, 278, 278)
                .addComponent(btn_Minimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cerrar)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Minimizar)
                    .addComponent(btn_cerrar)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 800, 30));

        txtMensaje.setBackground(new java.awt.Color(0, 153, 255));
        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });
        jPanel1.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 690, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BUZON DE CONSULTAS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        pnlMenu1.setBackground(new java.awt.Color(51, 102, 255));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu2.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btn_modificarPerfil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_modificarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add_insert_new_17850.png"))); // NOI18N
        btn_modificarPerfil.setText("Modificar Perfil");
        btn_modificarPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificarPerfil.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_modificarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarPerfilActionPerformed(evt);
            }
        });

        btn_preguntaDeSeguridad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_preguntaDeSeguridad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pencil_17925.png"))); // NOI18N
        btn_preguntaDeSeguridad.setText("Pregunta  Seguridad");
        btn_preguntaDeSeguridad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_preguntaDeSeguridad.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_preguntaDeSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preguntaDeSeguridadActionPerformed(evt);
            }
        });

        btn_borrarCuenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_borrarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete_remove_exit_17812.png"))); // NOI18N
        btn_borrarCuenta.setText("Borrar Cuenta");
        btn_borrarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_borrarCuenta.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_borrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarCuentaActionPerformed(evt);
            }
        });

        btn_cerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/off_logout_17916.png"))); // NOI18N
        btn_cerrarSesion.setText("Cerrar Sesion");
        btn_cerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenu1Layout = new javax.swing.GroupLayout(pnlMenu1);
        pnlMenu1.setLayout(pnlMenu1Layout);
        pnlMenu1Layout.setHorizontalGroup(
            pnlMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(btn_preguntaDeSeguridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_modificarPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_borrarCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButton8)
        );
        pnlMenu1Layout.setVerticalGroup(
            pnlMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenu1Layout.createSequentialGroup()
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_modificarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_preguntaDeSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_borrarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -290, 170, 290));

        panelDatosUsuario.setBackground(new java.awt.Color(0, 153, 255));
        panelDatosUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nombre:");
        panelDatosUsuario.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Apellido:");
        panelDatosUsuario.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Direccion:");
        panelDatosUsuario.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 10));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Mail:");
        panelDatosUsuario.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 30, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Telefono:");
        panelDatosUsuario.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 10));

        txtCuadroUsuario.setEditable(false);
        txtCuadroUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtCuadroUsuario.setBorder(null);
        txtCuadroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuadroUsuarioActionPerformed(evt);
            }
        });
        panelDatosUsuario.add(txtCuadroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 200, 15));

        txtCuadroApellido.setEditable(false);
        txtCuadroApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtCuadroApellido.setBorder(null);
        panelDatosUsuario.add(txtCuadroApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 200, 15));

        txtCuadroDireccion.setEditable(false);
        txtCuadroDireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtCuadroDireccion.setBorder(null);
        panelDatosUsuario.add(txtCuadroDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 200, 15));

        txtCuadroTelefono.setEditable(false);
        txtCuadroTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtCuadroTelefono.setBorder(null);
        txtCuadroTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuadroTelefonoActionPerformed(evt);
            }
        });
        panelDatosUsuario.add(txtCuadroTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 200, 15));

        txtCuadrioMail.setEditable(false);
        txtCuadrioMail.setBackground(new java.awt.Color(255, 255, 255));
        txtCuadrioMail.setBorder(null);
        panelDatosUsuario.add(txtCuadrioMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 200, 15));

        jPanel1.add(panelDatosUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 320, 160));

        btn_enviarMensaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_enviarMensaje.setForeground(new java.awt.Color(255, 255, 255));
        btn_enviarMensaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/env3.png"))); // NOI18N
        btn_enviarMensaje.setText("Enviar");
        btn_enviarMensaje.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_enviarMensaje.setBorderPainted(false);
        btn_enviarMensaje.setContentAreaFilled(false);
        btn_enviarMensaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_enviarMensaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_enviarMensaje.setIconTextGap(-3);
        btn_enviarMensaje.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_enviarMensaje.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_enviarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarMensajeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_enviarMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, 70, 80));

        btn_agregarValores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_agregarValores.setText("Agregar Valores");
        btn_agregarValores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_agregarValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarValoresActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregarValores, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 160, 50));

        btn_verEspecialistas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_verEspecialistas.setText("Ver Especialistas");
        btn_verEspecialistas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_verEspecialistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verEspecialistasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_verEspecialistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 160, 50));

        btn_verResultados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_verResultados.setText("Ver Resultados");
        btn_verResultados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_verResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verResultadosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_verResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 160, 50));

        btn_cargarHistoriaClinica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_cargarHistoriaClinica.setText("Cargar Historia Clinica");
        btn_cargarHistoriaClinica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cargarHistoriaClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarHistoriaClinicaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cargarHistoriaClinica, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 170, 50));

        btn_verHistorial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_verHistorial.setText("Ver Historial");
        btn_verHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_verHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btn_verHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 170, 50));

        seleccionarDestinatario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        seleccionarDestinatario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Destinatario:" }));
        seleccionarDestinatario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seleccionarDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarDestinatarioActionPerformed(evt);
            }
        });
        jPanel1.add(seleccionarDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 170, -1));

        btn_listadoDeVacunas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_listadoDeVacunas.setText("Listado De Vacunas");
        btn_listadoDeVacunas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_listadoDeVacunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listadoDeVacunasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_listadoDeVacunas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 170, 50));

        btn_verMensajes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_verMensajes.setText("Ver Mensajes");
        btn_verMensajes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_verMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verMensajesActionPerformed(evt);
            }
        });
        jPanel1.add(btn_verMensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, 20));

        jLabelFondo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFondo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/FndMenu.png"))); // NOI18N
        jLabelFondo.setText("jLabel1");
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -130, 770, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, -1));

        publicidadAbajo.setBackground(new java.awt.Color(0, 0, 0));

        publicidad1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        publicidad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/horizontal2.jpg"))); // NOI18N

        publicidad2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/slideIbupiretas (1).jpg"))); // NOI18N

        javax.swing.GroupLayout publicidadAbajoLayout = new javax.swing.GroupLayout(publicidadAbajo);
        publicidadAbajo.setLayout(publicidadAbajoLayout);
        publicidadAbajoLayout.setHorizontalGroup(
            publicidadAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(publicidadAbajoLayout.createSequentialGroup()
                .addComponent(publicidad1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(publicidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        publicidadAbajoLayout.setVerticalGroup(
            publicidadAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(publicidadAbajoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(publicidadAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(publicidad1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publicidad2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(publicidadAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 770, 90));

        publicidad3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Vert1.png"))); // NOI18N

        javax.swing.GroupLayout publicidadDerechaLayout = new javax.swing.GroupLayout(publicidadDerecha);
        publicidadDerecha.setLayout(publicidadDerechaLayout);
        publicidadDerechaLayout.setHorizontalGroup(
            publicidadDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
            .addGroup(publicidadDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(publicidadDerechaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(publicidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        publicidadDerechaLayout.setVerticalGroup(
            publicidadDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(publicidadDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(publicidadDerechaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(publicidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(publicidadDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 170, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        this.pnlMenu.setVisible(false);
        this.pnlMenu1.setVisible(true);
        int posicion = this.pnlMenu.getX();
        if (posicion > -1) {
            Animacion.Animacion.bajar(1, 1, 5, 5, pnlMenu1);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.pnlMenu1.setVisible(false);
        this.pnlMenu.setVisible(true);
        int posicion = this.pnlMenu1.getX();
        if (posicion > 1) {
            Animacion.Animacion.subir(0, -290, 5, 5, pnlMenu1);
        }
        this.pnlMenu.setSize(1, 1);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btn_modificarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarPerfilActionPerformed
        md = new ModificarPerfil();
        md.setVisible(true);
        md.user = this.u;
        this.setVisible(false);
    }//GEN-LAST:event_btn_modificarPerfilActionPerformed

    private void btn_preguntaDeSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preguntaDeSeguridadActionPerformed
        pcp = new PreguntaClavePaciente();
        pcp.setVisible(true);
        pcp.user = this.u;
        this.setVisible(false);
    }//GEN-LAST:event_btn_preguntaDeSeguridadActionPerformed

    private void btn_borrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarCuentaActionPerformed
        csql = new ConexionSQL();
        is = new IniSesion();
        int i = JOptionPane.showConfirmDialog(null, "Realmente desea Eliminar su Usuario", "Borrar Cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i != 1) {
            csql.eliminarUsuarioPaciente(u);
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

    private void btn_verEspecialistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verEspecialistasActionPerformed
        ve = new VerEspecialistas();
        ve.user = u;
        ve.mostrarTabla();
        ve.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_verEspecialistasActionPerformed

    private void btn_agregarValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarValoresActionPerformed
        av = new AddValores();
        av.setVisible(true);
        av.user = u;
        av.listaDeEnfermedades();
        this.setVisible(false);
    }//GEN-LAST:event_btn_agregarValoresActionPerformed

    private void btn_verResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verResultadosActionPerformed
        vr = new VerResultados();
        vr.setVisible(true);
        vr.user = u;
        vr.mostarTabla();
        this.setVisible(false);
    }//GEN-LAST:event_btn_verResultadosActionPerformed

    private void btn_cargarHistoriaClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarHistoriaClinicaActionPerformed
        chc = new CargarHistoriaClinica();
        chc.setVisible(true);
        chc.actualizarEnfermedades();
        chc.user = u;
        this.setVisible(false);
    }//GEN-LAST:event_btn_cargarHistoriaClinicaActionPerformed

    private void btn_verHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verHistorialActionPerformed
        vh = new VerHistorial();
        vh.user = u;
        vh.setVisible(true);
        vh.mostrarTabla();
        this.setVisible(false);
    }//GEN-LAST:event_btn_verHistorialActionPerformed

    private void btn_listadoDeVacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listadoDeVacunasActionPerformed
        ListadoVacunas lv = new ListadoVacunas();
        lv.user = u;
        lv.setVisible(true);
        lv.mostrarTabla();
        this.setVisible(false);
    }//GEN-LAST:event_btn_listadoDeVacunasActionPerformed

    private void btn_enviarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarMensajeActionPerformed
        if (mensajeVacio(txtMensaje.getText())) {
            JOptionPane.showMessageDialog(this, "Por Favor Redacte Un Mensaje Antes De Enviar", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            mensajeVacio(txtMensaje.getText());
        } else {
            destinatario();
        }
    }//GEN-LAST:event_btn_enviarMensajeActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Desea Salir", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i != 1) {
            System.exit(1);
        }
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajeActionPerformed

    }//GEN-LAST:event_txtMensajeActionPerformed

    private void seleccionarDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarDestinatarioActionPerformed

    }//GEN-LAST:event_seleccionarDestinatarioActionPerformed

    private void btn_verMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verMensajesActionPerformed
        vmp = new VerMensajePaciente();
        vmp.setVisible(true);
        vmp.user = this.u;
        vmp.listaDeMensajes();
        this.setVisible(false);
    }//GEN-LAST:event_btn_verMensajesActionPerformed

    private void btn_MinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btn_MinimizarActionPerformed

    private void txtCuadroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuadroUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuadroUsuarioActionPerformed

    private void txtCuadroTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuadroTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuadroTelefonoActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }

    void recibirString(String UserName) {
        this.u = UserName;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Minimizar;
    private javax.swing.JButton btn_agregarValores;
    private javax.swing.JButton btn_borrarCuenta;
    private javax.swing.JButton btn_cargarHistoriaClinica;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_cerrarSesion;
    private javax.swing.JButton btn_enviarMensaje;
    private javax.swing.JButton btn_listadoDeVacunas;
    private javax.swing.JButton btn_modificarPerfil;
    private javax.swing.JButton btn_preguntaDeSeguridad;
    private javax.swing.JButton btn_verEspecialistas;
    private javax.swing.JButton btn_verHistorial;
    private javax.swing.JButton btn_verMensajes;
    private javax.swing.JButton btn_verResultados;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JPanel panelDatosUsuario;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenu1;
    private javax.swing.JLabel publicidad1;
    private javax.swing.JLabel publicidad2;
    private javax.swing.JLabel publicidad3;
    private javax.swing.JPanel publicidadAbajo;
    private javax.swing.JPanel publicidadDerecha;
    public javax.swing.JComboBox<String> seleccionarDestinatario;
    private javax.swing.JTextField txtCuadrioMail;
    private javax.swing.JTextField txtCuadroApellido;
    private javax.swing.JTextField txtCuadroDireccion;
    private javax.swing.JTextField txtCuadroTelefono;
    private javax.swing.JTextField txtCuadroUsuario;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables
}
