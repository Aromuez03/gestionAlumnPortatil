package ejemploWebObj.aplicacion.cnl;

import java.util.List;

import ejemploWebObj.aplicacion.dao.*;
import ejemploWebObj.aplicacion.dtos.*;

public interface ConsultasService {
	
	public void insertarPortatil(PortatilAsignado portatil);
	public void insertarAlumno(AlumnoMatriculado alumnoDAO);
	public List<PortatilAsignado> seleccionarPortatiles();
	public PortatilAsignado seleccionarPortatil(int idPortatil);
	public AlumnoMatriculado seleccionarAlumno(int idAlumno);
	public List<AlumnoMatriculado> seleccionarTodosAlumnos();
}