/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphacell.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis
 */
@Entity
@Table(name = "DICCIONARIO_ALPH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiccionarioAlph.findAll", query = "SELECT d FROM DiccionarioAlph d"),
    @NamedQuery(name = "DiccionarioAlph.findById", query = "SELECT d FROM DiccionarioAlph d WHERE d.id = :id"),
    @NamedQuery(name = "DiccionarioAlph.findByCodDescripcion", query = "SELECT d FROM DiccionarioAlph d WHERE d.codDescripcion = :codDescripcion")})
public class DiccionarioAlph implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",unique = true)    
    private Integer id;
    @Size(max = 300)
    @Column(name = "COD_DESCRIPCION")
    private String codDescripcion;

    public DiccionarioAlph() {
    }

    public DiccionarioAlph(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodDescripcion() {
        return codDescripcion;
    }

    public void setCodDescripcion(String codDescripcion) {
        this.codDescripcion = codDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiccionarioAlph)) {
            return false;
        }
        DiccionarioAlph other = (DiccionarioAlph) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alphacell.model.DiccionarioAlph[ id=" + id + " ]";
    }
    
}
