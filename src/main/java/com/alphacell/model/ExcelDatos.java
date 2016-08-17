/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphacell.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis
 */
@Entity
@Table(name = "excel_datos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExcelDatos.findAll", query = "SELECT e FROM ExcelDatos e"),
    @NamedQuery(name = "ExcelDatos.findById", query = "SELECT e FROM ExcelDatos e WHERE e.id = :id"),
    @NamedQuery(name = "ExcelDatos.findByEstado", query = "SELECT e FROM ExcelDatos e WHERE e.estado = :estado"),
    @NamedQuery(name = "ExcelDatos.findByDescripcion", query = "SELECT e FROM ExcelDatos e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "ExcelDatos.findByInventario", query = "SELECT e FROM ExcelDatos e WHERE e.inventario = :inventario"),
    @NamedQuery(name = "ExcelDatos.findByVenta", query = "SELECT e FROM ExcelDatos e WHERE e.venta = :venta"),
    @NamedQuery(name = "ExcelDatos.findByFechaInventario", query = "SELECT e FROM ExcelDatos e WHERE e.fechaInventario = :fechaInventario"),
    @NamedQuery(name = "ExcelDatos.findByFechaVenta", query = "SELECT e FROM ExcelDatos e WHERE e.fechaVenta = :fechaVenta")})
public class ExcelDatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "estado")
    private Boolean estado;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "inventario")
    private Integer inventario;
    @Column(name = "venta")
    private Integer venta;
    @Column(name = "fecha_inventario")
    @Temporal(TemporalType.DATE)
    private Date fechaInventario;
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;

    public ExcelDatos() {
    }

    public ExcelDatos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

    public Integer getVenta() {
        return venta;
    }

    public void setVenta(Integer venta) {
        this.venta = venta;
    }

    public Date getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(Date fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
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
        if (!(object instanceof ExcelDatos)) {
            return false;
        }
        ExcelDatos other = (ExcelDatos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alphacell.model.ExcelDatos[ id=" + id + " ]";
    }
    
}
