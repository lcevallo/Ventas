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
@Table(name = "TMP_PRODUCTO_DICCIONARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpProductoDiccionario.findAll", query = "SELECT t FROM TmpProductoDiccionario t"),
    @NamedQuery(name = "TmpProductoDiccionario.findById", query = "SELECT t FROM TmpProductoDiccionario t WHERE t.id = :id"),
    @NamedQuery(name = "TmpProductoDiccionario.findByProducto", query = "SELECT t FROM TmpProductoDiccionario t WHERE t.producto = :producto"),
    @NamedQuery(name = "TmpProductoDiccionario.findByRecid", query = "SELECT t FROM TmpProductoDiccionario t WHERE t.recid = :recid"),
    @NamedQuery(name = "TmpProductoDiccionario.findByFkDiccionario", query = "SELECT t FROM TmpProductoDiccionario t WHERE t.fkDiccionario = :fkDiccionario"),
    @NamedQuery(name = "TmpProductoDiccionario.findByCodDescripcion", query = "SELECT t FROM TmpProductoDiccionario t WHERE t.codDescripcion = :codDescripcion")})
public class TmpProductoDiccionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 300)
    @Column(name = "producto")
    private String producto;
    @Column(name = "recid")
    private Integer recid;
    @Column(name = "fk_diccionario")
    private Integer fkDiccionario;
    @Size(max = 300)
    @Column(name = "COD_DESCRIPCION")
    private String codDescripcion;

    public TmpProductoDiccionario() {
    }

    public TmpProductoDiccionario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getFkDiccionario() {
        return fkDiccionario;
    }

    public void setFkDiccionario(Integer fkDiccionario) {
        this.fkDiccionario = fkDiccionario;
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
        if (!(object instanceof TmpProductoDiccionario)) {
            return false;
        }
        TmpProductoDiccionario other = (TmpProductoDiccionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alphacell.model.TmpProductoDiccionario[ id=" + id + " ]";
    }
    
}
