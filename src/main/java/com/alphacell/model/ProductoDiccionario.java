/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphacell.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis
 */
@Entity
@Table(name = "producto_diccionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoDiccionario.findAll", query = "SELECT p FROM ProductoDiccionario p"),
    @NamedQuery(name = "ProductoDiccionario.findByFkProducto", query = "SELECT p FROM ProductoDiccionario p WHERE p.productoDiccionarioPK.fkProducto = :fkProducto"),
    @NamedQuery(name = "ProductoDiccionario.findByFkDiccionario", query = "SELECT p FROM ProductoDiccionario p WHERE p.productoDiccionarioPK.fkDiccionario = :fkDiccionario")})
public class ProductoDiccionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoDiccionarioPK productoDiccionarioPK;

    public ProductoDiccionario() {
    }

    public ProductoDiccionario(ProductoDiccionarioPK productoDiccionarioPK) {
        this.productoDiccionarioPK = productoDiccionarioPK;
    }

    public ProductoDiccionario(int fkProducto, int fkDiccionario) {
        this.productoDiccionarioPK = new ProductoDiccionarioPK(fkProducto, fkDiccionario);
    }

    public ProductoDiccionarioPK getProductoDiccionarioPK() {
        return productoDiccionarioPK;
    }

    public void setProductoDiccionarioPK(ProductoDiccionarioPK productoDiccionarioPK) {
        this.productoDiccionarioPK = productoDiccionarioPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoDiccionarioPK != null ? productoDiccionarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoDiccionario)) {
            return false;
        }
        ProductoDiccionario other = (ProductoDiccionario) object;
        if ((this.productoDiccionarioPK == null && other.productoDiccionarioPK != null) || (this.productoDiccionarioPK != null && !this.productoDiccionarioPK.equals(other.productoDiccionarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alphacell.model.ProductoDiccionario[ productoDiccionarioPK=" + productoDiccionarioPK + " ]";
    }
    
}
