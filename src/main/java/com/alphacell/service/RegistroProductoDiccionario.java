package com.alphacell.service;

import com.alphacell.model.ProductoDiccionario;
import com.alphacell.repository.ProductoDiccionarioRepository;
import com.alphacell.util.jpa.Transacional;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by luis on 06/07/16.
 */
public class RegistroProductoDiccionario implements Serializable{

    private static final long serialVersionUID = -2370876160702074328L;

    @Inject
    private ProductoDiccionarioRepository productoDiccionarioRepository;

    @Transacional
    public ProductoDiccionario guardarRegistro(ProductoDiccionario productoDiccionario)
    {
        return productoDiccionarioRepository.guardar(productoDiccionario);

    }

    @Transacional
    public String  guardarRegistro2(Integer diccionario_old,ProductoDiccionario productoDiccionario,Integer  OperadoraFK)
    {

       return  productoDiccionarioRepository.guardar2(diccionario_old,productoDiccionario,OperadoraFK);

    }


}
