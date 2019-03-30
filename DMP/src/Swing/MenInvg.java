package Swing;

import conexion.ConexionSQL;
import javax.swing.JOptionPane;

public class MenInvg extends javax.swing.JFrame {

    String u;
    String password;
    IniSesion is;
    ConexionSQL csql;
    VerInformacion vi;
    ModificarPerfilInvestigador mpi;
    PreguntaClaveInvestigador pci;

    public MenInvg() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        btn_minimizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnlMenu1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btn_modificarPerfil = new javax.swing.JButton();
        btn_preguntaSeguridad = new javax.swing.JButton();
        btn_borrarCuenta = new javax.swing.JButton();
        btn_cerrarSesion = new javax.swing.JButton();
        btn_verInformacion = new javax.swing.JButton();
        jLabelMenInv = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 0));

        pnlMenu.setBackground(new java.awt.Color(102, 102, 0));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu5.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu Investigador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(122, 122, 122)
                .addComponent(btn_minimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_salir))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_salir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_minimizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 30));

        pnlMenu1.setBackground(new java.awt.Color(102, 102, 0));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu6.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_modificarPerfil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_modificarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add_insert_new_2.png"))); // NOI18N
        btn_modificarPerfil.setText("Modificar Perfil");
        btn_modificarPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificarPerfil.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_modificarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarPerfilActionPerformed(evt);
            }
        });

        btn_preguntaSeguridad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_preguntaSeguridad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pencil_2.png"))); // NOI18N
        btn_preguntaSeguridad.setText("Pregunta Seguridad");
        btn_preguntaSeguridad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_preguntaSeguridad.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_preguntaSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preguntaSeguridadActionPerformed(evt);
            }
        });

        btn_borrarCuenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_borrarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete_remove_exit_2.png"))); // NOI18N
        btn_borrarCuenta.setText("Borrar Cuenta");
        btn_borrarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_borrarCuenta.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_borrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarCuentaActionPerformed(evt);
            }
        });

        btn_cerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/off_logout_2.png"))); // NOI18N
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
            .addComponent(btn_borrarCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMenu1Layout.createSequentialGroup()
                .addGroup(pnlMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2)
                    .addComponent(btn_preguntaSeguridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_modificarPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenu1Layout.setVerticalGroup(
            pnlMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenu1Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modificarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_preguntaSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_borrarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -270, 170, 270));

        btn_verInformacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_verInformacion.setText("Ver Información");
        btn_verInformacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_verInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verInformacionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_verInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 160, 40));

        jLabelMenInv.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabelMenInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/FndInvt.png"))); // NOI18N
        getContentPane().add(jLabelMenInv, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.pnlMenu.setVisible(false);
        this.pnlMenu1.setVisible(true);
        int posicion = this.pnlMenu.getX();
        if (posicion > -1) {
            Animacion.Animacion.bajar(1, 1, 5, 5, pnlMenu1);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.pnlMenu1.setVisible(false);
        this.pnlMenu.setVisible(true);
        int posicion = this.pnlMenu1.getX();
        if (posicion > 1) {
            Animacion.Animacion.subir(0, -270, 5, 5, pnlMenu1);
        }
        this.pnlMenu.setSize(1, 1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_modificarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarPerfilActionPerformed
        mpi = new ModificarPerfilInvestigador();
        mpi.setVisible(true);
        mpi.contraseña = this.password;
        mpi.user = this.u;
        this.setVisible(false);
    }//GEN-LAST:event_btn_modificarPerfilActionPerformed

    private void btn_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarSesionActionPerformed
        is = new IniSesion();
        int i = JOptionPane.showConfirmDialog(null, "Realmente Desea Cerrar Sesion", "Cerrar Sesion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i != 1) {
            is.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btn_cerrarSesionActionPerformed

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

    private void btn_preguntaSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preguntaSeguridadActionPerformed
        pci = new PreguntaClaveInvestigador();
        pci.setVisible(true);
        pci.user = this.u;
        pci.password = this.password;
        this.setVisible(false);
    }//GEN-LAST:event_btn_preguntaSeguridadActionPerformed

    private void btn_verInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verInformacionActionPerformed
        vi = new VerInformacion();
        vi.setVisible(true);
        vi.user = this.u;
        vi.contraseña = this.password;
        vi.mostrarTabla();
        this.setVisible(false);
    }//GEN-LAST:event_btn_verInformacionActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Desea Salir", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (i != 1) {
            System.exit(1);
        }
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btn_minimizarActionPerformed

    void recibirString(String UserName) {
        u = UserName;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrarCuenta;
    private javax.swing.JButton btn_cerrarSesion;
    private javax.swing.JButton btn_minimizar;
    private javax.swing.JButton btn_modificarPerfil;
    private javax.swing.JButton btn_preguntaSeguridad;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_verInformacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMenInv;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenu1;
    // End of variables declaration//GEN-END:variables
}
