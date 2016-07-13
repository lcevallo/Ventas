package com.alphacell.repository;

import com.alphacell.model.CadenaProducto;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by luis on 07/07/16.
 */
public class CadenaProductoRepository implements Serializable {

    private static final long serialVersionUID = 4089221707896925833L;

    @Inject
    private EntityManager manager;


    public List<CadenaProducto> findAll() {
        Query query = manager.createNamedQuery("CadenaProducto.findAll");

        return query.getResultList();
    }

    public CadenaProducto findById(Integer id) {
        Query query = manager.createNamedQuery("CadenaProducto.findByRecid");
        query.setParameter("recid",id);
        return (CadenaProducto)query.getSingleResult();
    }


    public CadenaProducto guardar(CadenaProducto cadenaProductoPersistencia) {
        return manager.merge(cadenaProductoPersistencia);
    }
}
