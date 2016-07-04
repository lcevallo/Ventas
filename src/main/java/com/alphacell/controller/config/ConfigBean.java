package com.alphacell.controller.config;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.alphacell.model.Cadena;
import com.alphacell.repository.ConfigRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by luis on 04/07/16.
 */

@Named
@ViewScoped
public class ConfigBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Cadena> cmbCadenas;
	private Cadena selectedCadena;

    @Inject
    private ConfigRepository configRepository;


    @PostConstruct
    public void iniciar()
    {
        this.cmbCadenas=this.configRepository.findAll();
    }


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
}
