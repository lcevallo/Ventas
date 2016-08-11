package com.alphacell.repository;

import com.alphacell.model.ProductoDiccionario;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.exception.GenericJDBCException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.swing.*;
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



    public String guardar2 (Integer old_diccionario,ProductoDiccionario productoDiccionario,Integer OperadoraFK)
    {

        String salida="";
        try{


           /*

            Session session = manager.unwrap(Session.class);

            SQLQuery query = session.createSQLQuery("EXEC dbo.LC_GuardarProductoDiccionario :fk_producto_N, :fk_diccionario_O, :fk_diccionario_N");
            query.setInteger("fk_producto_N",productoDiccionario.getProductoDiccionarioPK().getFkProducto() );
            query.setInteger("fk_diccionario_O", old_diccionario);
            query.setInteger("fk_diccionario_N", productoDiccionario.getProductoDiccionarioPK().getFkDiccionario());


            salida = String.join("",query.list());
         */
            StoredProcedureQuery query = this.manager.createStoredProcedureQuery("LC_GuardarProductoDiccionario");
            query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(4, Integer.class, ParameterMode.IN);

            query.setParameter(1, productoDiccionario.getProductoDiccionarioPK().getFkProducto());
            query.setParameter(2, old_diccionario);
            query.setParameter(3, productoDiccionario.getProductoDiccionarioPK().getFkDiccionario());
            query.setParameter(4, OperadoraFK);

            //aqui salio
            if (query.execute())
            {

                salida = query.getSingleResult().toString();

            }

            //salida = String.join("",query.getResultList());


        }
        catch (GenericJDBCException |SecurityException | IllegalStateException  e)
        {

            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR" + e, "ERROR", JOptionPane.WARNING_MESSAGE);

            e.printStackTrace();
        }

             return salida;

    }




    public void guardar2(ProductoDiccionario productoDiccionario)
    {



        manager.persist(productoDiccionario);

    }

}
