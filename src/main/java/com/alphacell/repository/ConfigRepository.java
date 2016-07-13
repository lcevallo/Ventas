package com.alphacell.repository;

import com.alphacell.model.Cadena;
import com.alphacell.model.TmpProductoDiccionario;


import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

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

    public Cadena findByNombre(String nombre) {
        Query query = manager.createNamedQuery("Cadena.findByNombre");
        query.setParameter("nombre",nombre);

        return (Cadena)query.getSingleResult();
    }

    public Cadena findById(Integer id) {
        Query query = manager.createNamedQuery("Cadena.findById");
        query.setParameter("id",id);
        return (Cadena)query.getSingleResult();
    }

    public List<Cadena> findAll() {
        Query query = manager.createNamedQuery("Cadena.findAll");

        return query.getResultList();
    }

    public List<TmpProductoDiccionario> cargarTablaProductoDiccionario(Integer canal)
    {
        List<TmpProductoDiccionario> listaEnviada;

        try {

            Session session = manager.unwrap(Session.class);

            SQLQuery query = session.createSQLQuery("EXEC dbo.LC_ObtenerProductoxCadena :codigoCadena").addEntity(TmpProductoDiccionario.class);
            query.setInteger("codigoCadena", canal);
            listaEnviada = query.list();
            return listaEnviada;

        } catch (SecurityException | IllegalStateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cadena guardarCadena(Cadena cadenaObj) {

        /*
        if (!manager.contains(cadenaObj)) {
            manager.persist(cadenaObj);
        }
            */

        return manager.merge(cadenaObj);
    }
}
