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

	    // Se crea el ModelAndView
	    ModelAndView miModelo = new ModelAndView("../index");

	    System.out.println("idAlumno: " + idAlumno);
	    System.out.println("nombre: " + nombre);
	    System.out.println("telefono: " + telefono);
	    System.out.println("marca: " + marca);
	    System.out.println("modelo: " + modelo);
	    // Se crean los DTOs
	    AlumnoMatrDto alumnDTO = new AlumnoMatrDto();
	    PortatilAsigDto portatilDTO = new PortatilAsigDto();
	    portatilDTO.setMarca(marca);
	    portatilDTO.setModelo(modelo);
	    alumnDTO.setIdAlumno(idAlumno);
	    alumnDTO.setNombre(nombre);
	    alumnDTO.setTelefono(telefono);

	    // Insertamos primero el portátil y obtenemos su ID generado
	    PortatilAsignado portatilDAO = toDAO.PortatilAsignadoToDAO(portatilDTO);
	    int idPortatil = consulta.insertarPortatil(portatilDAO);

	    // Asignamos el ID del portátil al alumno
	    alumnDTO.getPortatilAsignado().setIdPortatil(idPortatil);

	    // Insertamos el alumno
	    consulta.insertarAlumno(toDAO.AlumnoMatriculadoToDAO(alumnDTO));

	    // Devolvemos el ModelAndView
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
                if (alumno.getPortatilAsignado().getIdPortatil() == (portatil.getIdPortatil())) {
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
    
    //todosLosAlumnos
    @RequestMapping(value ="/redirectTOtodosLosAlumnos")
	public ModelAndView seleccionAlumnos() {
    	try {
		System.out.println("[INFORMACION]: Entrando en el metodo seleccionAlumnos en ControladorAlumnos");
		return new ModelAndView("todosLosAlumnos");
		}catch (Exception e) {
			System.out.println(e);
			return new ModelAndView();
		}
	}
    @PostMapping("/todosLosAlumnos")
    public ModelAndView todosLosAlumnos() {
        try {
            List<AlumnoMatriculado> listaAlumnos = consulta.seleccionarTodosAlumnos();
            return new ModelAndView("todosLosAlumnos", "listaAlumnos", listaAlumnos);
        } catch (Exception e) {
            System.out.println("[ERROR]: Ha ocurrido un error al mostrar los alumnos");
            return new ModelAndView();
        }
    }
    
    @RequestMapping(value ="/redirectTOeliminaAlumno")
	public ModelAndView eliminandoAlumno() {
    	try {
		System.out.println("[INFORMACION]: Entrando en el metodo eliminaAlumno en ControladorAlumnos");
		return new ModelAndView("eliminaAlumno");
		}catch (Exception e) {
			System.out.println(e);
			return new ModelAndView();
		}
	}
    @PostMapping("/eliminaAlumno")
    public ModelAndView eliminaAlumno(@RequestParam int idAlumno) {
        try {
            consulta.eliminaAlumnoId(idAlumno);
            return new ModelAndView("eliminado");
        } catch (Exception e) {
            System.out.println("[ERROR]: " + e.getMessage());
            return new ModelAndView();
        }
    }
}
