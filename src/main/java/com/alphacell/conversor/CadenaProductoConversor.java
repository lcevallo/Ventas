package com.alphacell.conversor;

import com.alphacell.model.CadenaProducto;
import com.alphacell.repository.CadenaProductoRepository;
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
@FacesConverter(forClass = CadenaProducto.class)
public class CadenaProductoConversor implements Converter {

    private CadenaProductoRepository cadenaProductoRepository;

    public CadenaProductoConversor(){ cadenaProductoRepository = CDIServiceLocator.getBean(CadenaProductoRepository.class);}

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            Object obj = cadenaProductoRepository.findById(Integer.parseInt(value));
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ConverterException(new FacesMessage(String.format("No se puede convertir %s a un Proveedor", value)), e);

        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CadenaProducto)) {
            return null;
        }
        String s = String.valueOf(((CadenaProducto) value).getRecid());
        return s;
    }
}
