package com.alphacell.conversor;

import com.alphacell.model.DiccionarioAlph;
import com.alphacell.repository.DiccionarioRepository;
import com.alphacell.util.cdi.CDIServiceLocator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by luis on 07/07/16.
 */
@FacesConverter(forClass = DiccionarioAlph.class)
public class DiccionarioConversor implements Converter{


    private DiccionarioRepository diccionarioRepository;

    public DiccionarioConversor() {
        diccionarioRepository= CDIServiceLocator.getBean(DiccionarioRepository.class);
    }


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {


        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            Object obj = diccionarioRepository.findById(Integer.parseInt(value));
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ConverterException(new FacesMessage(String.format("No se puede convertir %s a un Diccionario Alph", value)), e);

        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof DiccionarioAlph)) {
            return null;
        }
        String s = String.valueOf(((DiccionarioAlph) value).getId());
        return s;
    }
}
