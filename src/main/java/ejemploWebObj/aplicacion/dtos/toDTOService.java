package ejemploWebObj.aplicacion.dtos;

import ejemploWebObj.aplicacion.dao.AlumnoMatriculado;
import ejemploWebObj.aplicacion.dao.PortatilAsignado;

public interface toDTOService {

	public AlumnoMatrDto AlumnoMatriculadoToDTO(AlumnoMatriculado alumnoMatriculado);
	
	public PortatilAsigDto PortatilAsignadoToDTO(PortatilAsignado portatilAsignado);
	
}
