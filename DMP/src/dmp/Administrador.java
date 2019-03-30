package dmp;

public class Administrador extends Persona {

    private UsuarioPaciente usuarioPaciente;
    private UsuarioMedico usuarioMedico;
    private UsuarioInvestigador usuarioInvestigador;

    public Administrador() {
        this.setIdTipo(4);
    }

    public UsuarioPaciente getUsuarioPaciente() {
        return usuarioPaciente;
    }

    public void setUsuarioPaciente(UsuarioPaciente usuarioPaciente) {
        this.usuarioPaciente = usuarioPaciente;
    }

    public UsuarioMedico getUsuarioMedico() {
        return usuarioMedico;
    }

    public void setUsuarioMedico(UsuarioMedico usuarioMedico) {
        this.usuarioMedico = usuarioMedico;
    }

    public UsuarioInvestigador getUsuarioInvestigador() {
        return usuarioInvestigador;
    }

    public void setUsuarioInvestigador(UsuarioInvestigador usuarioInvestigador) {
        this.usuarioInvestigador = usuarioInvestigador;
    }

}
