package ejemploWebObj.aplicacion.cnl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejemploWebObj.aplicacion.dao.*;

@Service
public class ConsultasImpl implements ConsultasService{

	@Autowired
	private AlumnoMatriculadoRepositorio psi1;
	
	@Autowired 
	private PortatilAsignadoRepositorio psi2;
	
	@Override
    public List<PortatilAsignado> seleccionarPortatiles() {

        return (List<PortatilAsignado>) psi2.findAll();
    }

    @Override
    public void insertarPortatil(PortatilAsignado portatilDAO) {
        try {
            psi2.save(portatilDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @Override
    public void insertarAlumno(AlumnoMatriculado alumnoDAO) {
        try {
            psi1.save(alumnoDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public PortatilAsignado seleccionarPortatil(int idPortatil) {
    	try {
            Optional<AlumnoMatriculado> alumno = psi1.findById(idPortatil);
                return alumno.get().getPortatilAsignado();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        
        }
    }
    
    @Override
    public AlumnoMatriculado seleccionarAlumno(int idAlumno) {
    	try {
            Optional<AlumnoMatriculado> alumno = psi1.findById(idAlumno);
            	AlumnoMatriculado alumno2 = new AlumnoMatriculado();
            	alumno2.setNombre(alumno.get().getNombre());
            	alumno2.setIdAlumno(alumno.get().getIdAlumno());
            	alumno2.setTelefono(alumno.get().getTelefono());
            	alumno2.setPortatilAsignado(alumno.get().getPortatilAsignado());

                return alumno2;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        
        }
    }
    
    @Override
    public List<AlumnoMatriculado> seleccionarTodosAlumnos() {
    	try {
    		Iterable<AlumnoMatriculado> iterable  = psi1.findAll();
    		List<AlumnoMatriculado> lista = new ArrayList<>();
    		for (AlumnoMatriculado alumno : iterable) {
    		    lista.add(alumno);
    		}
    		return lista;
    	} catch (Exception e) {
            e.printStackTrace();
            return null;
        
        }
    }

}