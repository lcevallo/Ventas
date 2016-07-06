package com.alphacell.controller.config;


import com.alphacell.model.Cadena;
import com.alphacell.model.TmpProductoDiccionario;
import com.alphacell.repository.ConfigRepository;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
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
	private List<TmpProductoDiccionario> tblTmpProductoDiccionario;

    @Inject
    private ConfigRepository configRepository;


    @PostConstruct
    public void iniciar()
    {
        this.tblTmpProductoDiccionario= new ArrayList<TmpProductoDiccionario>();
		this.cmbCadenas=this.configRepository.findAll();

    }

	public void cargarTablaRelacionProductoDiccionario()
	{

		this.tblTmpProductoDiccionario.clear();
		this.tblTmpProductoDiccionario= this.configRepository.cargarTablaProductoDiccionario(this.selectedCadena.getId());

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

	public List<TmpProductoDiccionario> getTblTmpProductoDiccionario() {
		return tblTmpProductoDiccionario;
	}

	public void setTblTmpProductoDiccionario(List<TmpProductoDiccionario> tblTmpProductoDiccionario) {
		this.tblTmpProductoDiccionario = tblTmpProductoDiccionario;
	}
}
