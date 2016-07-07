package com.alphacell.repository;

import com.alphacell.model.DiccionarioAlph;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by luis on 07/07/16.
 */
public class DiccionarioRepository implements Serializable {
    private static final long serialVersionUID = -3280348383946717687L;

    @Inject
    private EntityManager manager;


    public List<DiccionarioAlph> findAll() {
        Query query = manager.createNamedQuery("DiccionarioAlph.findAll");

        return query.getResultList();
    }

    public DiccionarioAlph findById(Integer id) {
        Query query = manager.createNamedQuery("DiccionarioAlph.findById");
        query.setParameter("id",id);
        return (DiccionarioAlph)query.getSingleResult();
    }

    public DiccionarioAlph findByNombre(String nombre) {
        Query query = manager.createNamedQuery("DiccionarioAlph.findByCodDescripcion");
        query.setParameter("codDescripcion",nombre);

        return (DiccionarioAlph)query.getSingleResult();
    }


}
