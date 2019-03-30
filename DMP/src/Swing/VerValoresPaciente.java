package Swing;

import conexion.ConexionSQL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VerValoresPaciente extends javax.swing.JFrame {

    String nombre;
    String apellido;
    String user;
    String usuarioPaciente;
    String matricula;
    ConexionSQL csql;
    List<String> dest = new ArrayList();
    VerHistoriaClinicaPacientes vhcp;

    public VerValoresPaciente() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    void recibirNombres(List<String> pacientes) {
        csql = new ConexionSQL();
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            for (int i = 0; i < pacientes.size(); i++) {
                dest.add(pacientes.get(i));
                csql.resultado = csql.consulta.executeQuery("SELECT nombre, apellido FROM dmp.usuarios WHERE usuario LIKE'" + pacientes.get(i) + "';");
            }
            while (csql.resultado.next()) {
                nombre = csql.resultado.getString("nombre");
                apellido = csql.resultado.getString("apellido");
                this.comboPacientes.addItem(nombre + " " + apellido);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void saberUsuario() {
        String combo;
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT usuario, nombre, apellido FROM dmp.usuarios");
            while (csql.resultado.next()) {
                nombre = csql.resultado.getString("nombre");
                apellido = csql.resultado.getString("apellido");
                combo = nombre + " " + apellido;
                if (combo.compareTo(this.comboPacientes.getSelectedItem().toString()) == 0) {
                    usuarioPaciente = csql.resultado.getString("usuario");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("" + usuarioPaciente);
        mostrarTabla(usuarioPaciente);
    }

    void mostrarTabla(String usuarioPaciente) {

        csql = new ConexionSQL();
        String datos[] = new String[6];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre y Apellido");
        modelo.addColumn("Enfermedad");
        modelo.addColumn("Nombre De Valor");
        modelo.addColumn("Valor");
        modelo.addColumn("Resultado");
        modelo.addColumn("Fecha");
        tablaValores.setModel(modelo);
        try {
            csql.conexion = DriverManager.getConnection(csql.sql, csql.usuario, csql.contraseña);
            csql.consulta = csql.conexion.createStatement();
            csql.resultado = csql.consulta.executeQuery("SELECT enfermedad, nombreValor, valor, resultado, fecha FROM dmp.historial WHERE usuario LIKE '" + usuarioPaciente + "';");
            while (csql.resultado.next()) {
                datos[0] = this.comboPacientes.getSelectedItem().toString();
                datos[1] = csql.resultado.getString(1);
                datos[2] = csql.resultado.getString(2);
                datos[3] = csql.resultado.getString(3);
                datos[4] = csql.resultado.getString(4);
                datos[5] = csql.resultado.getString(5);
                modelo.addRow(datos);
            }
            tablaValores.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_cerrar = new javax.swing.JButton();
        btn_minimizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaValores = new javax.swing.JTable();
        comboPacientes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ver Valores Ingresados Por Pacientes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
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
                .addComponent(jLabel2)
                .addContainerGap())
        );

        tablaValores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaValores);

        comboPacientes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        comboPacientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:" }));
        comboPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPacientesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista de Pacientes:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(353, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        vhcp = new VerHistoriaClinicaPacientes();
        vhcp.setVisible(true);
        vhcp.user = this.user;
        vhcp.matricula = this.matricula;
        vhcp.mostrarTabla(dest);
        this.setVisible(false);
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btn_minimizarActionPerformed

    private void comboPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPacientesActionPerformed
        if (this.comboPacientes.getSelectedItem().toString() == "Seleccione:") {
            JOptionPane.showMessageDialog(this, "Por Favor Seleccione Un Paciente", "\nAdvertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            saberUsuario();
        }
    }//GEN-LAST:event_comboPacientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_minimizar;
    private javax.swing.JComboBox<String> comboPacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaValores;
    // End of variables declaration//GEN-END:variables
}
