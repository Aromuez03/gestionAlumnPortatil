package ejemploWebObj.aplicacion.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortatilAsignadoRepositorio extends CrudRepository<PortatilAsignado,Integer>  {

}