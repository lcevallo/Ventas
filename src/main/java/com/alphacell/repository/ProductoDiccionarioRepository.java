package com.alphacell.repository;

import com.alphacell.model.ProductoDiccionario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

/**
 * Created by luis on 07/07/16.
 */
public class ProductoDiccionarioRepository implements Serializable {


    private static final long serialVersionUID = -5078523132776802546L;

    @Inject
    private EntityManager manager;

    public ProductoDiccionario guardar(ProductoDiccionario productoDiccionario)
    {
        return manager.merge(productoDiccionario);
    }


}
