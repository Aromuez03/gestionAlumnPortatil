package ejemploWebObj;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ejemploWebObj.web.WebConfiguracionContexto;
import ejemploWebObj.aplicacion.AplicacionConfiguracionContexto;

public class EnrutadorWeb extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { AplicacionConfiguracionContexto.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfiguracionContexto.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
