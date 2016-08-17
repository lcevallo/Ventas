/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphacell.controller;

import com.alphacell.model.Cadena;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author luis
 */
@Named
@ViewScoped
public class CargarDatosBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<Cadena> cmbCadenas;
    private Cadena selectedCadena;
    private Date fechaInventario;
    private Date fechaVenta;



    public List<Cadena> getCmbCadenas() {
        return cmbCadenas;
    }

    public void setCmbCadenas(List<Cadena> cmbCadenas) {
        this.cmbCadenas = cmbCadenas;
    }

    public Cadena getSelectedCadena() {
        return selectedCadena;
    }

    public void setSelectedCadena(Cadena selectedCadena) {
        this.selectedCadena = selectedCadena;
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
}
