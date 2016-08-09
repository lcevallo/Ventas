/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphacell.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis
 */
@Entity
@Table(name = "cadena_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadenaProducto.findAll", query = "SELECT c FROM CadenaProducto c"),
    @NamedQuery(name = "CadenaProducto.findByProducto", query = "SELECT c FROM CadenaProducto c WHERE c.producto = :producto"),
    @NamedQuery(name = "CadenaProducto.findByCadena", query = "SELECT c FROM CadenaProducto c WHERE c.fkCadena.id = :idCadena"),
    @NamedQuery(name = "CadenaProducto.findByRecid", query = "SELECT c FROM CadenaProducto c WHERE c.recid = :recid")})
public class CadenaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 300)
    @Column(name = "producto")
    private String producto;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recid",unique = true)
    private Integer recid;
    @JoinColumn(name = "fk_cadena", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cadena fkCadena;
    @JoinColumn(name = "fk_operadora", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Operador fkOperadora;

    public CadenaProducto() {
    }

    public CadenaProducto(Integer recid) {
        this.recid = recid;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getRecid() {
        return recid;
    }

    public void setRecid(Integer recid) {
        this.recid = recid;
    }

    public Cadena getFkCadena() {
        return fkCadena;
    }

    public void setFkCadena(Cadena fkCadena) {
        this.fkCadena = fkCadena;
    }

    public Operador getFkOperadora() {
        return fkOperadora;
    }

    public void setFkOperadora(Operador fkOperadora) {
        this.fkOperadora = fkOperadora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recid != null ? recid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadenaProducto)) {
            return false;
        }
        CadenaProducto other = (CadenaProducto) object;
        if ((this.recid == null && other.recid != null) || (this.recid != null && !this.recid.equals(other.recid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alphacell.model.CadenaProducto[ recid=" + recid + " ]";
    }
    
}
