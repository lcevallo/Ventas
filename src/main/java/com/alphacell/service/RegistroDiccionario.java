package com.alphacell.service;

import com.alphacell.model.DiccionarioAlph;
import com.alphacell.repository.DiccionarioRepository;
import com.alphacell.util.jpa.Transacional;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by luis on 10/08/16.
 */
public class RegistroDiccionario  implements Serializable{
    private static final long serialVersionUID = -385496440555854460L;

    @Inject
    private DiccionarioRepository diccionarioRepository;


    @Transacional
    public void guardarRegistro(DiccionarioAlph diccionarioAlphPersistencia)
    {
        diccionarioRepository.guardar(diccionarioAlphPersistencia);
    }

    @Transacional
    public void remover(DiccionarioAlph diccionario) {

        diccionarioRepository.remover(diccionario);


    }
}
