package com.alphacell.conversor;

import com.alphacell.model.Operador;
import com.alphacell.repository.OperadorRepository;
import com.alphacell.util.cdi.CDIServiceLocator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by luis on 09/08/16.
 */
@FacesConverter(forClass = Operador.class)
public class OperadorConversor implements Converter{
    private OperadorRepository operadorRepository;


    public OperadorConversor() {
        this.operadorRepository = CDIServiceLocator.getBean(OperadorRepository.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            Object obj = operadorRepository.findById(Integer.parseInt(value));
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ConverterException(new FacesMessage(String.format("No se puede convertir %s a un Operador", value)), e);

        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Operador)) {
            return null;
        }
        String s = String.valueOf(((Operador) value).getId());
        return s;
    }
}
