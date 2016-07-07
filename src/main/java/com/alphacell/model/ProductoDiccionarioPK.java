/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphacell.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author luis
 */
@Embeddable
public class ProductoDiccionarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_producto")
    private int fkProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_diccionario")
    private int fkDiccionario;

    public ProductoDiccionarioPK() {
    }

    public ProductoDiccionarioPK(int fkProducto, int fkDiccionario) {
        this.fkProducto = fkProducto;
        this.fkDiccionario = fkDiccionario;
    }

    public int getFkProducto() {
        return fkProducto;
    }

    public void setFkProducto(int fkProducto) {
        this.fkProducto = fkProducto;
    }

    public int getFkDiccionario() {
        return fkDiccionario;
    }

    public void setFkDiccionario(int fkDiccionario) {
        this.fkDiccionario = fkDiccionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkProducto;
        hash += (int) fkDiccionario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoDiccionarioPK)) {
            return false;
        }
        ProductoDiccionarioPK other = (ProductoDiccionarioPK) object;
        if (this.fkProducto != other.fkProducto) {
            return false;
        }
        if (this.fkDiccionario != other.fkDiccionario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alphacell.model.ProductoDiccionarioPK[ fkProducto=" + fkProducto + ", fkDiccionario=" + fkDiccionario + " ]";
    }
    
}
