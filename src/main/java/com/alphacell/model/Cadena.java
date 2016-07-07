/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphacell.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luis
 */
@Entity
@Table(name = "CADENA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadena.findAll", query = "SELECT c FROM Cadena c"),
    @NamedQuery(name = "Cadena.findById", query = "SELECT c FROM Cadena c WHERE c.id = :id"),
    @NamedQuery(name = "Cadena.findByNombre", query = "SELECT c FROM Cadena c WHERE c.nombre = :nombre")})
public class Cadena implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCadena")
    private List<CadenaProducto> cadenaProductoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 75)
    @Column(name = "NOMBRE")
    private String nombre;

    public Cadena() {
    }

    public Cadena(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof Cadena)) {
            return false;
        }
        Cadena other = (Cadena) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alphacell.model.Cadena[ id=" + id + " ]";
    }

    @XmlTransient
    public List<CadenaProducto> getCadenaProductoList() {
        return cadenaProductoList;
    }

    public void setCadenaProductoList(List<CadenaProducto> cadenaProductoList) {
        this.cadenaProductoList = cadenaProductoList;
    }
    
}
