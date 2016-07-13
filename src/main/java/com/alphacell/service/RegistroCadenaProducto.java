package com.alphacell.service;

import com.alphacell.model.CadenaProducto;
import com.alphacell.repository.CadenaProductoRepository;
import com.alphacell.util.jpa.Transacional;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by luis on 13/07/16.
 */
public class RegistroCadenaProducto implements Serializable{


    private static final long serialVersionUID = 8241402303385350405L;

    @Inject
    private CadenaProductoRepository cadenaProductoRepository;

    @Transacional
    public void guardarRegistro(CadenaProducto cadenaProductoPersistencia)
    {
        cadenaProductoRepository.guardar(cadenaProductoPersistencia);
    }

}
