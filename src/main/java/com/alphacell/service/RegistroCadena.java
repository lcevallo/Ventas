package com.alphacell.service;

import com.alphacell.model.Cadena;
import com.alphacell.repository.ConfigRepository;
import com.alphacell.util.jpa.Transacional;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by luis on 11/07/16.
 */
public class RegistroCadena implements Serializable{
    private static final long serialVersionUID = -8047853346235370147L;


    @Inject
    private ConfigRepository configRepository;

    @Transacional
    public void guardarCadena(Cadena cadenaObj)
    {
        configRepository.guardarCadena(cadenaObj);

    }



}
