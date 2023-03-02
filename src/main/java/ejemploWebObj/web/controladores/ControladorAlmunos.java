package ejemploWebObj.web.controladores;

import ejemploWebObj.aplicacion.dao.*;
import ejemploWebObj.aplicacion.dtos.*;
import ejemploWebObj.aplicacion.cnl.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorAlmunos {

	@Autowired
	ConsultasImpl consulta;
	
	//Creamos una lista donde guardaremos los alumnos
	List<AlumnoMatriculado> listaAlumnos= new ArrayList<AlumnoMatriculado>();
	List<PortatilAsignado> listaPortatil = new ArrayList<PortatilAsignado>();
	
	//Se crea tanto un toDAO como un toDTO para su futura utilizacion
	toDAOs toDAO = new toDAOs();
	toDTOs toDTO = new toDTOs();
	
	protected final Log logger = LogFactory.getLog(getClass());
	Map<String, Object> miModelo = new HashMap<String,Object>();
	
	@RequestMapping(value ="/redirectTOnuevoAlumno")
	public ModelAndView gestionSolicitud() {
		try {
		System.out.println("[INFORMACION]: Entrando en el metodo nuevoAlumno en ControladorAlumnos");
		return new ModelAndView("nuevoAlumno");
		}catch (Exception e) {
			System.out.println(e);
			return new ModelAndView();
		}
	}
	
    @PostMapping("/nuevoAlumno")
    public ModelAndView procesarConsulta(@RequestParam int idAlumno, @RequestParam String nombre, @RequestParam String telefono, @RequestParam String marca, @RequestParam String modelo) {
        
    	//Se crea el ModelAndView;
    	ModelAndView miModelo = new ModelAndView("../index");
    	
    	//Se crean los DTOs
    	AlumnoMatrDto alumnDTO = new AlumnoMatrDto();
    	PortatilAsigDto portatilDTO = new PortatilAsigDto();
    	portatilDTO.setMarca(marca);
    	portatilDTO.setModelo(modelo);
    	alumnDTO.setIdAlumno(idAlumno);
    	alumnDTO.setNombre(nombre);
    	alumnDTO.setTelefono(telefono);
    	alumnDTO.setPortatilAsignado(toDAO.PortatilAsignadoToDAO(portatilDTO));
    	
       //Insertamos los datos en BBDD
        consulta.insertarAlumno(toDAO.AlumnoMatriculadoToDAO(alumnDTO));
       
	   
        //Devolvemos el ModelAndView
        return miModelo;
    }
    
    @RequestMapping(value ="/redirectTOalumnosPorPortatil")
	public ModelAndView gestionQuery() {
    	try {
		System.out.println("[INFORMACION]: Entrando en el metodo alumnosPorPortatil en ControladorAlumnos");
		return new ModelAndView("alumnosPorPortatil");
		}catch (Exception e) {
			System.out.println(e);
			return new ModelAndView();
		}
	}
    @PostMapping("/alumnosPorPortatil")
    public ModelAndView alumnosPorPortatil(@RequestParam int alumnPortatil) {
        try {
            System.out.println("[INFORMACION]: Se muestra el alumno asignado al id del portatil concreto");
            PortatilAsignado portatil = consulta.seleccionarPortatil(alumnPortatil);
            
            // Se guarda el objeto portatil en la lista de portátiles
            listaPortatil.add(portatil);
            
            // Se guarda la lista de alumnos
            listaAlumnos = consulta.seleccionarTodosAlumnos();
            
            AlumnoMatriculado alumnoEncontrado = null;
            
            // Se recorre la lista de alumnos para encontrar el que tiene asignado el portátil
            for (AlumnoMatriculado alumno : listaAlumnos) {
                if (alumno.getPortatilAsignado().equals(portatil)) {
                    alumnoEncontrado = alumno;
                    break;
                }
            }
            
            if (alumnoEncontrado == null) {
                System.out.println("[ERROR]: No se encontró ningún alumno asignado al portátil buscado");
                return new ModelAndView();
            }
            
            miModelo.put("idAlumno", alumnoEncontrado.getIdAlumno());
            miModelo.put("nombre", alumnoEncontrado.getNombre());
            miModelo.put("telefono", alumnoEncontrado.getTelefono());
            miModelo.put("idPortatil", portatil.getIdPortatil());
            miModelo.put("marca", portatil.getMarca());
            miModelo.put("modelo", portatil.getModelo());
            
            return new ModelAndView("resultadoPortAlumn", "miModelo", miModelo);
        } catch (Exception e) {
            System.out.println("[ERROR]: El portatil que busca no existe o no esta asignado");
            return new ModelAndView();
        }
    }
}
