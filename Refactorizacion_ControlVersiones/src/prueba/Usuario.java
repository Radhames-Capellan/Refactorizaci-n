package prueba;

public class Usuario {
    private String nombre;
    private String email;
    private boolean empleado;
    private boolean miembroGold;
    private boolean miembroSilver;

 
    public Usuario(String nombre, String email, boolean empleado, boolean miembroGold, boolean miembroSilver) {
        this.nombre = nombre;
        this.email = email;
        this.empleado = empleado;
        this.miembroGold = miembroGold;
        this.miembroSilver = miembroSilver;
    }

   
    public boolean esEmpleado() {
        return empleado;
    }

    public boolean esMiembroGold() {
        return miembroGold;
    }

    public boolean esMiembroSilver() {
        return miembroSilver;
    }


   
    

    public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isEmpleado() {
		return empleado;
	}


	public void setEmpleado(boolean empleado) {
		this.empleado = empleado;
	}


	public boolean isMiembroGold() {
		return miembroGold;
	}


	public void setMiembroGold(boolean miembroGold) {
		this.miembroGold = miembroGold;
	}


	public boolean isMiembroSilver() {
		return miembroSilver;
	}


	public void setMiembroSilver(boolean miembroSilver) {
		this.miembroSilver = miembroSilver;
	}


	@Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", empleado=" + empleado +
                ", miembroGold=" + miembroGold +
                ", miembroSilver=" + miembroSilver +
                '}';
    }
}