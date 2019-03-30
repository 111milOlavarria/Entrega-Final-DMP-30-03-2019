package Swing;

import javax.swing.JOptionPane;
import conexion.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CargarHistoriaClinica extends javax.swing.JFrame {

    ConexionSQL csql;
    float peso;
    float altura;
    float imc;
    String user;
    String sexo;
    float pesoIdeal;
    Menu menu;
    String grupoFactor;
    String enfermedad;

    public CargarHistoriaClinica() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    void actualizarEnfermedades() {
        String enfermedad;
        csql = new ConexionSQL();
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT enfermedad FROM dmp.enfermedades;");
            while (csql.resultado.next()) {
                enfermedad = csql.resultado.getString("enfermedad");
                if (enfermedad == null) {
                } else {
                    this.txtEnfermedad.addItem(enfermedad);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void saberSexo() {
        csql = new ConexionSQL();
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT sexo FROM dmp.usuarios WHERE usuario LIKE '" + user + "';");
            if (csql.resultado.next()) {
                sexo = csql.resultado.getString("sexo");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    boolean valoresVacios() {
        boolean ok;
        if (txtAltura.getText().compareTo("") == 0 || txtPeso.getText().compareTo("") == 0) {
            ok = false;
        } else {
            ok = true;
        }
        return ok;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        btn_calImc = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtGrupoFactor = new javax.swing.JComboBox<>();
        txtAltura = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEnfermedad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtEnfPreexistente = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_cerrar = new javax.swing.JButton();
        btn_minimizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtIMC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPesoIdeal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese Peso:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese Altura:");

        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });

        btn_calImc.setText("Calcular IMC");
        btn_calImc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_calImc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calImcActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Grupo y/o Factor Sanguineo:");

        txtGrupoFactor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtGrupoFactor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:", "A+", "A-", "B+", "B-", "AB+", "AB-", "0+", "0-" }));
        txtGrupoFactor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtGrupoFactor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrupoFactorActionPerformed(evt);
            }
        });

        txtAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlturaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Seleccione Enfermedad(opcional)");

        txtEnfermedad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtEnfermedad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:" }));
        txtEnfermedad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enfermedad Preexistente(opcional):");

        txtEnfPreexistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnfPreexistenteActionPerformed(evt);
            }
        });

        btn_agregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_agregar.setText("Agregar");
        btn_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

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

        btn_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Minimizar Menu.png"))); // NOI18N
        btn_minimizar.setToolTipText("");
        btn_minimizar.setBorder(null);
        btn_minimizar.setBorderPainted(false);
        btn_minimizar.setContentAreaFilled(false);
        btn_minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minimizarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cargar Historia Clinica");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_minimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cerrar))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_cerrar)
            .addComponent(btn_minimizar)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap())
        );

        txtIMC.setEditable(false);
        txtIMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIMCActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Peso Ideal:");

        txtPesoIdeal.setEditable(false);
        txtPesoIdeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoIdealActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Metros");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Kg");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Kg");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Metro. Centimetros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_agregar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(27, 27, 27)
                                        .addComponent(txtPesoIdeal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btn_calImc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel13)
                                                .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEnfPreexistente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGrupoFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtGrupoFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel4)
                    .addComponent(txtEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_calImc)
                    .addComponent(txtIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtPesoIdeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEnfPreexistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_agregar)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_calImcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calImcActionPerformed
        saberSexo();
        altura = Float.parseFloat(txtAltura.getText());
        peso = Float.parseFloat(txtPeso.getText());
        imc = peso / (altura * altura);
        if (sexo.compareTo("Masculino") == 0) {
            altura *= 100;
            pesoIdeal = 50 + 0.75f * (altura - 142.4f);
        } else {
            altura *= 100;
            pesoIdeal = 45.5f + 0.67f * (altura - 142.4f);
        }
        txtPesoIdeal.setText("" + pesoIdeal);
        txtIMC.setText(Float.toString(imc));
    }//GEN-LAST:event_btn_calImcActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        menu = new Menu();
        menu.setVisible(true);
        menu.u = this.user;
        menu.actualizarDestinatarios();
        menu.rellenarCuadro();
        this.setVisible(false);
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        csql = new ConexionSQL();
        if (txtGrupoFactor.getSelectedItem().toString().compareTo("Seleccione:") == 0) {
            JOptionPane.showMessageDialog(this, "Por favor Seleccione Su Grupo Y Factor", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
        }
        if (valoresVacios() == false) {
            JOptionPane.showMessageDialog(this, "Por favor Rellene Todos Los Campos", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            grupoFactor = txtGrupoFactor.getSelectedItem().toString();
            altura = Float.parseFloat(txtAltura.getText());
            peso = Float.parseFloat(txtPeso.getText());
            enfermedad = txtEnfermedad.getSelectedItem().toString();
            imc = peso / (altura * altura);

            if (enfermedad.compareTo("Seleccione:") == 0) {
                enfermedad = "Ninguna";
            } else if (txtEnfPreexistente.getText().compareTo(null) == 0) {
                txtEnfPreexistente.setText("Ninguna");
            }
            csql.cargarHistoriaClinica(peso, altura, imc, grupoFactor, enfermedad, txtEnfPreexistente.getText(), user);
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void txtGrupoFactorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrupoFactorActionPerformed

    }//GEN-LAST:event_txtGrupoFactorActionPerformed

    private void txtIMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIMCActionPerformed

    }//GEN-LAST:event_txtIMCActionPerformed

    private void txtEnfPreexistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnfPreexistenteActionPerformed

    }//GEN-LAST:event_txtEnfPreexistenteActionPerformed

    private void btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btn_minimizarActionPerformed

    private void txtPesoIdealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoIdealActionPerformed
        txtPesoIdeal.transferFocus();
    }//GEN-LAST:event_txtPesoIdealActionPerformed

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        txtPeso.transferFocus();
    }//GEN-LAST:event_txtPesoActionPerformed

    private void txtAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlturaActionPerformed
        txtAltura.transferFocus();
    }//GEN-LAST:event_txtAlturaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_calImc;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_minimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtEnfPreexistente;
    private javax.swing.JComboBox<String> txtEnfermedad;
    private javax.swing.JComboBox<String> txtGrupoFactor;
    private javax.swing.JTextField txtIMC;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPesoIdeal;
    // End of variables declaration//GEN-END:variables
}
