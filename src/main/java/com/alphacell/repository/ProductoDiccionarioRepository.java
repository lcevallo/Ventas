package com.alphacell.repository;

import com.alphacell.model.ProductoDiccionario;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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



    public String guardar2 (Integer old_diccionario,ProductoDiccionario productoDiccionario)
    {

        String salida;
        try{

            Session session = manager.unwrap(Session.class);

            SQLQuery query = session.createSQLQuery("EXEC dbo.LC_GuardarProductoDiccionario :fk_producto_N, :fk_diccionario_O, :fk_diccionario_N");
            query.setInteger("fk_producto_N",productoDiccionario.getProductoDiccionarioPK().getFkProducto() );
            query.setInteger("fk_diccionario_O", old_diccionario);
            query.setInteger("fk_diccionario_N", productoDiccionario.getProductoDiccionarioPK().getFkDiccionario());


            salida = String.join("",query.list());

            return salida;

        }
        catch (SecurityException | IllegalStateException e)
        {
            e.printStackTrace();
        }
        return null;


    }




    public void guardar2(ProductoDiccionario productoDiccionario)
    {



        manager.persist(productoDiccionario);

    }

}
