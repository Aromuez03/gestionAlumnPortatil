package ejemploWebObj.aplicacion.dao;

import javax.persistence.*;

@Entity
@Table(name="dlk_gap_tch_alumnos",schema="dlk_gestionAlumnoPortatil")
public class AlumnoMatriculado {
	
		//ATRIBUTOS
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id_alumn")
		private int idAlumno;
		
		@Column(name="nombre_alumn")
		private String nombre;
		
		@Column(name="telefono_alumn")
		private String telefono;
		
		@OneToOne
	    @JoinColumn(name = "id_portatil")
	    private PortatilAsignado portatilAsignado;
		
		//GETTERS & SETTERS
		public int getIdAlumno() {
			return idAlumno;
		}

		public void setPortatilAsignado(PortatilAsignado portatilAsignado) {
			this.portatilAsignado = portatilAsignado;
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
		    return this.portatilAsignado;
		}

		
		@Override
		public String toString() {
			return "AlumnoMatriculado [idAlumno=" + idAlumno + ", nombre=" + nombre + ", telefono=" + telefono + ", portatilAsignado=" + portatilAsignado +"]";
		}

		
		
		
}
