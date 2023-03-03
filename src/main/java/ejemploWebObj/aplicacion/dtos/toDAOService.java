package ejemploWebObj.aplicacion.dtos;

import ejemploWebObj.aplicacion.dao.AlumnoMatriculado;
import ejemploWebObj.aplicacion.dao.PortatilAsignado;

public interface toDAOService {

	public AlumnoMatriculado AlumnoMatriculadoToDAO(AlumnoMatrDto alumnoMatriculadoDto);
		
	public PortatilAsignado PortatilAsignadoToDAO(PortatilAsigDto portatilAsigDto);
}
