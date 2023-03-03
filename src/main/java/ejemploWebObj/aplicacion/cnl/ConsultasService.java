package ejemploWebObj.aplicacion.cnl;

import java.util.List;

import ejemploWebObj.aplicacion.dao.*;

public interface ConsultasService {
	
	public int insertarPortatil(PortatilAsignado portatil);
	public void insertarAlumno(AlumnoMatriculado alumnoDAO);
	public List<PortatilAsignado> seleccionarPortatiles();
	public PortatilAsignado seleccionarPortatil(int idPortatil);
	public AlumnoMatriculado seleccionarAlumno(int idAlumno);
	public List<AlumnoMatriculado> seleccionarTodosAlumnos();
	public void eliminaAlumnoId(int idAlumno);
}
