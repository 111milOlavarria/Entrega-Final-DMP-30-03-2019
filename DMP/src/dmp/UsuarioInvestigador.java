package dmp;

public class UsuarioInvestigador extends Persona {

    protected String nombreDeCompania;
    protected String codigoDeValidacion;

    public UsuarioInvestigador() {
        this.setIdTipo(3);
    }

    public String getNombreDeCompania() {
        return nombreDeCompania;
    }

    public void setNombreDeCompania(String nombreDeCompania) {
        this.nombreDeCompania = nombreDeCompania;
    }

    public String getCodigoDeValidacion() {
        return codigoDeValidacion;
    }

    public void setCodigoDeValidacion(String codigoDeValidacion) {
        this.codigoDeValidacion = codigoDeValidacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
