package conexion;

import java.sql.*;
import dmp.*;
import java.sql.SQLException;
import Swing.*;
import javax.swing.JOptionPane;
import java.sql.Date;

public class ConexionSQL {

    public Connection conexion;
    MenuMed menumed;
    public Statement consulta;
    public ResultSet resultado;
    public String usuario = "root";
    public String contraseña = "21939786";
    protected String vUsuario;
    protected String vContraseña;
    protected String vMatricula;
    protected String vCodigoValidacion;
    public String gUsuario;
    protected int vId;
    public String sql;
    boolean ok;

    public void guardarUsuario(String user) {
        this.gUsuario = user;
    }

    public ConexionSQL() {
        this.sql = "jdbc:mysql://localhost:3306/dmp?serverTimezone=America/Argentina/Buenos_Aires";
    }

    public int getvId() {
        return vId;
    }

    public void setvId(int vId) {
        this.vId = vId;
    }

    public String getvCodigoValidacion() {
        return vCodigoValidacion;
    }

    public void setvCodigoValidacion(String vCodigoValidacion) {
        this.vCodigoValidacion = vCodigoValidacion;
    }

    public String getvMatricula() {
        return vMatricula;
    }

    public void setvMatricula(String vMatricula) {
        this.vMatricula = vMatricula;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getvUsuario() {
        return vUsuario;
    }

    public void setvUsuario(String vUsuario) {
        this.vUsuario = vUsuario;
    }

    public String getvContraseña() {
        return vContraseña;
    }

    public void setvContraseña(String vContraseña) {
        this.vContraseña = vContraseña;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getConsulta() {
        return consulta;
    }

    public void setConsulta(Statement consulta) {
        this.consulta = consulta;
    }

    public ResultSet getResultado() {
        return resultado;
    }

    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    public boolean verificarConexion() throws SQLException {
        int Verificar = 0;
        if (conexion.isValid(Verificar)) {
            return true;
        } else {
            return false;
        }
    }

    public void insertPaciente(UsuarioPaciente up) {
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("INSERT INTO usuarios (tipoUsuario, usuario, contraseña, nombre, apellido, dni, mail, telefono, sexo, compartirDatos, direccion, edad, localidad) VALUES (" + up.getIdTipo() + ",'" + up.getUsuario() + "','" + up.getContraseña() + "','" + up.getNombre() + "','" + up.getApellido() + "','" + up.getDni() + "','" + up.getMail() + "','" + up.getTelefono() + "', '" + up.getSexo() + "', " + up.getCompartirDatos() + ", '" + up.getDireccion() + "', '" + up.getEdad() + "', '" + up.getLocalidad() + "');");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertMedico(UsuarioMedico um) {
        try {

            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("UPDATE dmp.usuarios SET tipoUsuario =" + um.getIdTipo() + ", usuario='" + um.getUsuario() + "', contraseña='" + um.getContraseña() + "', nombre ='" + um.getNombre() + "', apellido='" + um.getApellido() + "', dni='" + um.getDni() + "', mail='" + um.getMail() + "', direccion='" + um.getDireccion() + "', telefono='" + um.getTelefono() + "' ,fechaNacimiento='" + um.getFechaNacimiento() + "', especialidad='" + um.getEspecialidad() + "', sexo='" + um.getSexo() + "', direccion ='" + um.getDireccion() + "', localidad ='" + um.getLocalidad() + "' WHERE matricula LIKE '" + um.getMatricula() + "';");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertInvestigador(UsuarioInvestigador ui) {
        try {

            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("UPDATE dmp.usuarios SET tipoUsuario =" + ui.getIdTipo() + ", usuario='" + ui.getUsuario() + "', contraseña='" + ui.getContraseña() + "', nombreCompania ='" + ui.getNombreDeCompania() + "', mail='" + ui.getMail() + "', direccion='" + ui.getDireccion() + "', telefono='" + ui.getTelefono() + "' WHERE codigoValidacion LIKE '" + ui.getCodigoDeValidacion() + "';");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void verUsuarioPaciente(UsuarioPaciente up) {
        try {

            conexion = DriverManager.getConnection(sql, usuario, contraseña);

            consulta = conexion.createStatement();

            resultado = consulta.executeQuery("SELECT * FROM usuarios WHERE tipoUsuario = 1");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void verUsuarioPaciente(UsuarioMedico um) {
        try {

            conexion = DriverManager.getConnection(sql, usuario, contraseña);

            consulta = conexion.createStatement();

            resultado = consulta.executeQuery("SELECT * FROM usuarios WHERE tipoUsuario = " + um.getIdTipo());

            while (resultado.next()) {
                System.out.println(
                        resultado.getString("idUsuario") + "\t"
                        + resultado.getString("tipoUsuario") + "\t"
                        + resultado.getString("matricula") + "\t"
                        + resultado.getString("usuario") + "\t"
                        + resultado.getString("contraseña") + "\t"
                        + resultado.getString("nombre") + "\t"
                        + resultado.getString("apellido") + "\t"
                        + resultado.getString("dni") + "\t"
                        + resultado.getString("mail") + "\t"
                        + resultado.getString("telefono") + "\t"
                        + resultado.getString("sexo")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void verUsuarioInvestigador(UsuarioInvestigador ui) {
        try {

            conexion = DriverManager.getConnection(sql, usuario, contraseña);

            consulta = conexion.createStatement();

            resultado = consulta.executeQuery("SELECT * FROM usuarios WHERE tipoUsuario = " + ui.getIdTipo());

            while (resultado.next()) {
                System.out.println(
                        resultado.getString("idUsuario") + "\t"
                        + resultado.getString("tipoUsuario") + "\t"
                        + resultado.getString("nombreCompania") + "\t"
                        + resultado.getString("usuario") + "\t"
                        + resultado.getString("contraseña") + "\t"
                        + resultado.getString("mail") + "\t"
                        + resultado.getString("telefono")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean verificarlogin(String verificarContraseña, String verificarUsuario) {

        String user = verificarUsuario;
        String pass = verificarContraseña;
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT usuario, contraseña FROM dmp.usuarios WHERE usuario LIKE '" + user + "'");

            if (resultado.next() == true) {
                vUsuario = resultado.getString("usuario");
                vContraseña = resultado.getString("contraseña");
            }
            if (user.equals(vUsuario) && pass.equals(vContraseña)) {
                ok = true;
            } else {
                ok = false;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ok;
    }

    public boolean verificarUsuario(String user) {
        String nUsuario = user;

        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT usuario FROM dmp.usuarios WHERE usuario LIKE '" + nUsuario + "'");

            if (resultado.next() == true) {
                vUsuario = resultado.getString("usuario");

            }
            if (nUsuario.equals(vUsuario)) {
                ok = false;
            } else {
                ok = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ok;

    }

    public boolean verificarMatricula(String matricula) {
        String nMatricula = matricula;

        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT matricula FROM dmp.usuarios WHERE matricula LIKE '" + nMatricula + "'");

            if (resultado.next() == true) {
                vMatricula = resultado.getString("matricula");
            } else {
                ok = false;
                return ok;
            }
            if (nMatricula.equals(vMatricula)) {
                ok = true;
            } else {
                ok = false;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ok;
    }

    public boolean verificarCV(String codigoValidacion) {

        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT codigoValidacion FROM dmp.usuarios WHERE codigoValidacion LIKE '" + codigoValidacion + "'");

            if (resultado.next()) {
                vCodigoValidacion = resultado.getString("codigoValidacion");
            } else {
                ok = false;
                return ok;
            }
            if (codigoValidacion.compareTo(vCodigoValidacion) == 0) {
                ok = true;
            } else {
                ok = false;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ok;
    }

    public void eliminarUsuarioPaciente(String userName) {
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("UPDATE dmp.usuarios SET tipoUsuario =" + 0 + ", usuario='" + 0 + "', contraseña='" + 0 + "', nombre ='" + 0 + "', apellido='" + 0 + "', dni='" + 0 + "', mail='" + 0 + "', direccion='" + 0 + "', telefono='" + 0 + "' WHERE usuario LIKE '" + userName + "';");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void eliminarMI(String UserName) {
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("DELETE FROM dmp.usuarios WHERE usuario LIKE '" + UserName + "';");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int tipoUsuario(String user) {
        String nUser = user;
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT usuario, tipoUsuario FROM dmp.usuarios WHERE usuario LIKE '" + nUser + "'");
            if (resultado.next() == true) {
                vId = resultado.getInt("tipoUsuario");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return vId;
    }

    public void cambiarContraseña(String user, String password) {
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("UPDATE dmp.usuarios SET contraseña = '" + password + "' WHERE usuario LIKE '" + user + "';");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AddValor(String user, String enfermedad, String nombreValor, float comparacion, String resultado, java.sql.Date fecha) {
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("INSERT INTO historial(usuario, enfermedad, nombreValor, valor, resultado, fecha) VALUES('" + user + "', '" + enfermedad + "', '" + nombreValor + "', " + comparacion + ", '" + resultado + "', '" + fecha + "');");

            JOptionPane.showMessageDialog(null, "Valor Agregado Con Exito");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public boolean verificarMedico(String nombre, String matricula) {
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT nombre, matricula FROM usuarios WHERE nombre LIKE '" + nombre + "' AND matricula LIKE '" + matricula + "';");
            if (resultado.next()) {
                ok = true;
            } else {
                ok = false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ok;
    }

    public void agregarMedico(String user, String nombre, String apellido, String matricula) {
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("INSERT INTO especialistas(usuario, nombre, apellido, idMatricula) VALUES('" + user + "', '" + nombre + "', '" + apellido + "', '" + matricula + "');");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        menumed = new MenuMed();
        menumed.recibirMatricula();

    }

    public void eliminarMedicoAsociado(String matricula, String nombre) {
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("DELETE FROM especialistas WHERE idMatricula LIKE '" + matricula + "' AND nombre LIKE '" + nombre + "';");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cargarHistoriaClinica(float peso, float altura, float imc, String grupoFactor, String enfermedad, String enfPreexistente, String user) {
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("UPDATE dmp.usuarios set peso=" + peso + ", altura=" + altura + ", imc=" + imc + ", enfermedadPrincipal='" + enfermedad + "', enfermedadPreexistente='" + enfPreexistente + "', grupoYFactor='" + grupoFactor + "'  WHERE usuario LIKE '" + user + "';");
            JOptionPane.showMessageDialog(null, "Historia Clinica Cargada Con Exito");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void enviarMensajePacienteAMedico(String mensaje, String mensajefecha, String mensajeDe, String userMedico) {
        System.out.println("Entro");
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("INSERT INTO dmp.mensajes (usuario, mensaje, mensajeDe, fecha) VALUES('" + userMedico + "', '" + mensaje + "', '" + mensajeDe + "', '" + mensajefecha + "')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void enviarMensajeMedicoAPaciente(String user, String mensaje, String mensajeFecha, String mensajeDe) {
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("INSERT INTO dmp.mensajes (usuario, mensaje, mensajeDe, fecha) VALUES('" + user + "', '" + mensaje + "', '" + mensajeDe + "', '" + mensajeFecha + "');");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void añadirEnfermedad(String enfermedad) {
        try {
            conexion = DriverManager.getConnection(sql, usuario, contraseña);
            consulta = conexion.createStatement();
            consulta.executeUpdate("INSERT INTO enfermedades(enfermedadSolicitud) VALUES('" + enfermedad + "');");
            JOptionPane.showMessageDialog(null, "Solicitud Para Añadir Enfermedad Enviada");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
