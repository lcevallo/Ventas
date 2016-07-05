package com.alphacell.conversor;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.alphacell.model.Cadena;
import com.alphacell.repository.ConfigRepository;
import com.alphacell.util.cdi.CDIServiceLocator;

/**
 * Created by luis on 04/07/16.
 */

@FacesConverter(forClass = Cadena.class)
public class ConfigConversor implements Converter{

    private ConfigRepository configRepository;

    public ConfigConversor() {
        configRepository= CDIServiceLocator.getBean(ConfigRepository.class);
    }

    @Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            Object obj = configRepository.findById(Integer.parseInt(value));
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ConverterException(new FacesMessage(String.format("No se puede convertir %s a un Proveedor", value)), e);

        }


	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Cadena)) {
            return null;
        }
        String s = String.valueOf(((Cadena) value).getNombre());
        return s;
	}
}
