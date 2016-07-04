package com.alphacell.repository;

import com.alphacell.model.Cadena;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class ConfigRepository implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public List<Cadena> findByNombre(String nombre) {
        Query query = manager.createNamedQuery("Cadena.findByNombre");
        query.setParameter("nombre", "%" + nombre + "%");

        return query.getResultList();
    }

    public List<Cadena> findById(Integer id) {
        Query query = manager.createNamedQuery("Cadena.findById");
        query.setParameter("id", "%" + id + "%");

        return query.getResultList();
    }

    public List<Cadena> findAll() {
        Query query = manager.createNamedQuery("Cadena.findAll");

        return query.getResultList();
    }

}
