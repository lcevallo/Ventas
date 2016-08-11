package com.alphacell.service;

import com.alphacell.model.DiccionarioAlph;
import com.alphacell.repository.OperadorRepository;
import com.alphacell.util.jpa.Transacional;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by luis on 10/08/16.
 */
public class RegistroDiccionario  implements Serializable{
    private static final long serialVersionUID = -385496440555854460L;

    @Inject
    private OperadorRepository operadorRepository;


    @Transacional
    public void guardarRegistro(DiccionarioAlph diccionarioAlphPersistencia)
    {
        operadorRepository.guardar(diccionarioAlphPersistencia);
    }
}
