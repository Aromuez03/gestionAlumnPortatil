package ejemploWebObj.web.controladores;

import ejemploWebObj.aplicacion.dao.*;
import ejemploWebObj.aplicacion.dtos.*;
import ejemploWebObj.aplicacion.cnl.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPortatiles {

	@Autowired
	ConsultasImpl consulta;
	
	//Creamos una lista donde guardaremos los portatiles
	List<PortatilAsignado> listaPortatil = new ArrayList<PortatilAsignado>();
	
	//Se crea tanto un toDAO como un toDTO para su futura utilizacion
	toDAOs toDAO = new toDAOs();
	toDTOs toDTO = new toDTOs();
	
	protected final Log logger = LogFactory.getLog(getClass());
	Map<String, Object> miModelo = new HashMap<String,Object>();
	
	@RequestMapping(value ="/redirectTOnuevoPortatil")
	public ModelAndView gestionSolicitud() {
		System.out.println("[INFORMACION]: Entrando en el metodo nuevoPortatil en ControladorPortatiles");
		return new ModelAndView("nuevoPortatil");
	}
	
	
    @PostMapping("/nuevoPortatil")
    public ModelAndView nuevoPortatil( @RequestParam String marca, @RequestParam String modelo) {
        
    	//Se crea el ModelAndView;
    	ModelAndView miModelo = new ModelAndView("../index");
    	
    	//Se crea un DTO de PortatilAsignado
    	PortatilAsigDto portatilDTO = new PortatilAsigDto();
    	portatilDTO.setMarca(marca);
    	portatilDTO.setModelo(modelo);
    	
        //Insertamos los datos en base de datos
        consulta.insertarPortatil(toDAO.PortatilAsignadoToDAO(portatilDTO));
       
	   
        //Devolvemos el ModelAndView
        return miModelo;
    }
    
    
	@RequestMapping(value="/redirectTOportatilesPorAlumnos")
	public ModelAndView gestionQuery() {
		System.out.println("[INFORMACION]: Entrando en el metodo portatilesPorAlumnos");
		return new ModelAndView("portatilesPorAlumnos");
	}
    
    
    @PostMapping("/portatilesPorAlumnos")
    public ModelAndView portatilesPorAlumnos(@RequestParam int alumnPortatil) {
    	try {
    		System.out.println("[INFORMACION]: Se muestra el portatil asignado al id del alumno concreto");
    		PortatilAsigDto portatil = toDTO.PortatilAsignadoToDTO(consulta.seleccionarPortatil(alumnPortatil));
        	AlumnoMatrDto alumn = toDTO.AlumnoMatriculadoToDTO(consulta.seleccionarAlumno(alumnPortatil));
        	System.out.println(portatil.toString());
        	miModelo.put("idAlumno", alumn.getIdAlumno());
        	miModelo.put("idPortatil", portatil.getIdPortatil());
        	miModelo.put("marca", portatil.getMarca());
        	miModelo.put("modelo", portatil.getModelo());
        	
        	
        	return new ModelAndView("resultadoPortAlumn", "miModelo", miModelo );
		} catch (Exception e) {
			System.out.println("[ERROR]: El portatil que busca no existe o no esta asignado");
			return new ModelAndView();
		}
    	
    }
}
