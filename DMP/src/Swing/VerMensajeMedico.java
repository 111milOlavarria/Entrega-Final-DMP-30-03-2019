package Swing;

import conexion.ConexionSQL;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class VerMensajeMedico extends javax.swing.JFrame {

    ConexionSQL csql;
    String user;
    String matricula;
    MenuMed menumed;

    public VerMensajeMedico() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    void listaDeMensajes() {
        csql = new ConexionSQL();
        String fecha, mensajede;
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT mensaje, mensajeDe, fecha FROM dmp.mensajes WHERE usuario LIKE'" + user + "';");
            while (csql.resultado.next()) {
                fecha = csql.resultado.getString("fecha");
                mensajede = csql.resultado.getString("mensajeDe");
                this.seleccionMensaje.addItem(fecha + ", " + mensajede);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void verMensaje() {
        csql = new ConexionSQL();
        String fecha, mensajede, comparacion;
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT mensaje, mensajeDe, fecha FROM dmp.mensajes WHERE usuario LIKE'" + user + "';");
            while (csql.resultado.next()) {
                fecha = csql.resultado.getString("fecha");
                mensajede = csql.resultado.getString("mensajeDe");
                comparacion = fecha + ", " + mensajede;
                if (comparacion.compareTo(seleccionMensaje.getSelectedItem().toString()) == 0) {
                    txtMensaje.setText(csql.resultado.getString("mensaje"));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void borrarMensaje() {
        csql = new ConexionSQL();
        String mensajeAEliminar;
        mensajeAEliminar = txtMensaje.getText();
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.consulta.executeUpdate("DELETE FROM dmp.mensajes WHERE usuario LIKE'" + user + "' AND mensaje LIKE'" + mensajeAEliminar + "';");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        txtMensaje.setText("");
        seleccionMensaje.removeItem(seleccionMensaje.getSelectedItem());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_cerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_minimizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        btn_borrarMensaje = new javax.swing.JButton();
        seleccionMensaje = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(71, 98, 98));

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ver Mensaje");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_minimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_cerrar)
                    .addComponent(btn_minimizar))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mensajes Disponibles:");

        txtMensaje.setEditable(false);
        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        jScrollPane1.setViewportView(txtMensaje);

        btn_borrarMensaje.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_borrarMensaje.setText("Borrar Mensaje");
        btn_borrarMensaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_borrarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarMensajeActionPerformed(evt);
            }
        });

        seleccionMensaje.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        seleccionMensaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Un Mensaje:" }));
        seleccionMensaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seleccionMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionMensajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seleccionMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_borrarMensaje)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(seleccionMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_borrarMensaje)))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        menumed = new MenuMed();
        menumed.setVisible(true);
        menumed.u = user;
        menumed.matricula = matricula;
        menumed.actualizarDestinatarios();
        this.setVisible(false);
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btn_minimizarActionPerformed

    private void btn_borrarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarMensajeActionPerformed
        borrarMensaje();
        listaDeMensajes();
    }//GEN-LAST:event_btn_borrarMensajeActionPerformed

    private void seleccionMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionMensajeActionPerformed
        verMensaje();
    }//GEN-LAST:event_seleccionMensajeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrarMensaje;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_minimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> seleccionMensaje;
    private javax.swing.JTextArea txtMensaje;
    // End of variables declaration//GEN-END:variables
}
