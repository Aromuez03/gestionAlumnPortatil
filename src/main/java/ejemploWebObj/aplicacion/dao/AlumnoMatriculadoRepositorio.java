package ejemploWebObj.aplicacion.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ejemploWebObj.aplicacion.dao.AlumnoMatriculado;

@Repository
public interface AlumnoMatriculadoRepositorio extends CrudRepository<AlumnoMatriculado,Integer> {


}
