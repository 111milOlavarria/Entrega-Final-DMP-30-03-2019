package dmp;

import Swing.VerResultados;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UsuarioPaciente extends Persona {

    protected float peso;
    protected float altura;
    protected char grupo;
    protected char factor;
    protected String mensaje;
    protected float imc;
    protected int compartirDatos;
    protected int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public UsuarioPaciente() {
        this.idTipo = 1;
    }

    public int getCompartirDatos() {
        return compartirDatos;
    }

    public void setCompartirDatos(int compartirDatos) {
        this.compartirDatos = compartirDatos;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    public char getFactor() {
        return factor;
    }

    public void setFactor(char factor) {
        this.factor = factor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

}
