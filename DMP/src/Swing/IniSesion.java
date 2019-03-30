package Swing;

import conexion.ConexionSQL;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class IniSesion extends javax.swing.JFrame {

    protected Registro regist;
    ConexionSQL csql;
    Menu menu;
    MenuMed menumed;
    MenInvg menuinvg;
    AddEspecialista ae;
    OlvideContraseña ov;

    public IniSesion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Icons/dmpIcon1.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        btn_ingresar = new javax.swing.JButton();
        btn_nuevoRegistro = new javax.swing.JButton();
        btn_olvideContraseña = new javax.swing.JButton();
        btn_minimizar = new javax.swing.JButton();
        jLabel1Fnd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Cerrar Menu Negro.png"))); // NOI18N
        btn_salir.setBorder(null);
        btn_salir.setBorderPainted(false);
        btn_salir.setContentAreaFilled(false);
        btn_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Diagnosticador Medico Personal");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ab.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 160, 130));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Contraseña");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        user.setBackground(new java.awt.Color(153, 255, 255));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 270, 210, -1));

        pass.setBackground(new java.awt.Color(153, 255, 255));
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 210, -1));

        btn_ingresar.setBackground(new java.awt.Color(51, 102, 255));
        btn_ingresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ingresar.setText("Iniciar Sesion");
        btn_ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 210, -1));

        btn_nuevoRegistro.setBackground(new java.awt.Color(51, 102, 255));
        btn_nuevoRegistro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_nuevoRegistro.setForeground(new java.awt.Color(255, 255, 255));
        btn_nuevoRegistro.setText("Nuevo Registro");
        btn_nuevoRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_nuevoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoRegistroActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevoRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 210, -1));

        btn_olvideContraseña.setBackground(new java.awt.Color(51, 102, 255));
        btn_olvideContraseña.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_olvideContraseña.setForeground(new java.awt.Color(255, 255, 255));
        btn_olvideContraseña.setText("Olvide mi Contraseña");
        btn_olvideContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_olvideContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_olvideContraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_olvideContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 210, -1));

        btn_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Minimizar Menu Negro.png"))); // NOI18N
        btn_minimizar.setBorder(null);
        btn_minimizar.setBorderPainted(false);
        btn_minimizar.setContentAreaFilled(false);
        btn_minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minimizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, -1));

        jLabel1Fnd.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1Fnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Sin título-2.png"))); // NOI18N
        jLabel1Fnd.setText("jLabel1");
        getContentPane().add(jLabel1Fnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        user.transferFocus();
    }//GEN-LAST:event_userActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        pass.transferFocus();
    }//GEN-LAST:event_passActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        csql = new ConexionSQL();
        menu = new Menu();
        menumed = new MenuMed();
        menuinvg = new MenInvg();
        if (csql.verificarlogin(pass.getText(), user.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Usuario y/o Contraseña Incorrectos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
            csql.verificarlogin(pass.getText(), user.getText());
        } else {
            if (csql.tipoUsuario(user.getText()) == 1) {
                menu.recibirString(user.getText());
                menu.setVisible(true);
                menu.actualizarDestinatarios();
                menu.rellenarCuadro();
                this.setVisible(false);
            } else if (csql.tipoUsuario(user.getText()) == 2) {
                menumed.recibirString(user.getText());
                menumed.recibirMatricula();
                menumed.setVisible(true);
                this.setVisible(false);
            } else {
                menuinvg.recibirString(user.getText());
                menuinvg.setVisible(true);
                this.setVisible(false);
            }
        }

    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void btn_nuevoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoRegistroActionPerformed
        regist = new Registro();
        regist.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_nuevoRegistroActionPerformed

    private void btn_olvideContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_olvideContraseñaActionPerformed
        ov = new OlvideContraseña();
        ov.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_olvideContraseñaActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(1);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btn_minimizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_minimizar;
    private javax.swing.JButton btn_nuevoRegistro;
    private javax.swing.JButton btn_olvideContraseña;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1Fnd;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
