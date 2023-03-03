package ejemploWebObj.aplicacion.dtos;

import ejemploWebObj.aplicacion.dao.AlumnoMatriculado;
import ejemploWebObj.aplicacion.dao.PortatilAsignado;

public class toDTOs {

	public AlumnoMatrDto AlumnoMatriculadoToDTO(AlumnoMatriculado alumnoMatriculado) {
		AlumnoMatrDto alumno = new AlumnoMatrDto();
		alumno.setIdAlumno(alumnoMatriculado.getIdAlumno());
		alumno.setNombre(alumnoMatriculado.getNombre());
		alumno.setTelefono(alumnoMatriculado.getTelefono());
		alumno.setPortatilAsignado(alumnoMatriculado.getPortatilAsignado());
		
		return alumno;
	}
	
	public PortatilAsigDto PortatilAsignadoToDTO(PortatilAsignado portatilAsignado) {
		PortatilAsigDto portatil = new PortatilAsigDto();
		portatil.setIdPortatil(portatilAsignado.getIdPortatil());
		portatil.setMarca(portatilAsignado.getMarca());
		portatil.setModelo(portatilAsignado.getModelo());
		
		return portatil;
	}
}
