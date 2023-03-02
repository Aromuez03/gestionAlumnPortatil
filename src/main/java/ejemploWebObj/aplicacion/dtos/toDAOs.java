package ejemploWebObj.aplicacion.dtos;

import ejemploWebObj.aplicacion.dao.AlumnoMatriculado;
import ejemploWebObj.aplicacion.dao.PortatilAsignado;

public class toDAOs implements toDAOService {

	public AlumnoMatriculado AlumnoMatriculadoToDAO(AlumnoMatrDto alumnoMatriculadoDto) {
		
		AlumnoMatriculado alumno = new AlumnoMatriculado();
		alumno.setIdAlumno(alumnoMatriculadoDto.getIdAlumno());
		alumno.setNombre(alumnoMatriculadoDto.getNombre());
		alumno.setTelefono(alumnoMatriculadoDto.getTelefono());
		alumno.setPortatilAsignado(alumnoMatriculadoDto.getPortatilAsignado());
		
		return alumno;
	}
	public PortatilAsignado PortatilAsignadoToDAO(PortatilAsigDto portatilAsigDto) {
		
		PortatilAsignado portatil = new PortatilAsignado();
		portatil.setIdPortatil(portatilAsigDto.getIdPortatil());
		portatil.setMarca(portatilAsigDto.getMarca());
		portatil.setModelo(portatilAsigDto.getModelo());

		
		return portatil;
	}
}