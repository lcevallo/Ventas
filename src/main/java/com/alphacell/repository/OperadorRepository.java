package com.alphacell.repository;

import com.alphacell.model.Operador;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by luis on 08/08/16.
 */
public class OperadorRepository implements Serializable{

    private static final long serialVersionUID = -432982980346060760L;

    @Inject
    private EntityManager manager;

    public List<Operador> findALl()
    {
        Query query = manager.createNamedQuery("Operador.findAll");

        return query.getResultList();
    }

    public Operador findById(Integer id)
    {
        Query query = manager.createNamedQuery("Operador.findById");
        query.setParameter("id",id);
        return (Operador)query.getSingleResult();

    }
}
