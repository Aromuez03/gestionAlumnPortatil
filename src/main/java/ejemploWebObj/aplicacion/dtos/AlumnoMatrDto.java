package ejemploWebObj.aplicacion.dtos;


import ejemploWebObj.aplicacion.dao.*;

public class AlumnoMatrDto {

	//ATRIBUTOS
	private int idAlumno;
	
	private String nombre;

	private String telefono;
	
	private PortatilAsignado portatilAsignado;
    
    //GETTERS & SETTERS

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public PortatilAsignado getPortatilAsignado() {
		return portatilAsignado;
	}

	public void setPortatilAsignado(PortatilAsignado portatilAsignado) {
		this.portatilAsignado = portatilAsignado;
	}

    //CONSTRUCTORES
	public AlumnoMatrDto(int idAlumno, String nombre, String telefono, PortatilAsignado portatilAsignado) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.telefono = telefono;
		this.portatilAsignado = portatilAsignado;
	}

	public AlumnoMatrDto() {
        this.portatilAsignado = new PortatilAsignado();
    }

	@Override
	public String toString() {
		return "AlumnoMatrDto [idAlumno=" + idAlumno + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", portatilAsignado=" + portatilAsignado + "]";
	}
    
	
    
}
