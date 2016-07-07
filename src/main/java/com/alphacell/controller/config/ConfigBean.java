package com.alphacell.controller.config;


import com.alphacell.model.*;
import com.alphacell.repository.CadenaProductoRepository;
import com.alphacell.repository.ConfigRepository;
import com.alphacell.repository.DiccionarioRepository;
import com.alphacell.service.RegistroProductoDiccionario;
import com.alphacell.util.jsf.FacesUtil;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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

	private List<DiccionarioAlph> cmbDiccionario;
	private DiccionarioAlph selectedDiccionario;


	private List<CadenaProducto> cmbCadenaProducto;
	private CadenaProducto selectedCadenaProducto;

	private List<TmpProductoDiccionario> tblTmpProductoDiccionario;

	private TmpProductoDiccionario tmpProductoDiccionarioSelected;

	private TmpProductoDiccionario tmpProductoDiccionarioEdicion;

	private ProductoDiccionario productoDiccionarioEdicion;

    @Inject
    private ConfigRepository configRepository;

	@Inject
	private DiccionarioRepository diccionarioRepository;

	@Inject
	private CadenaProductoRepository cadenaProductoRepository;

	@Inject
	private RegistroProductoDiccionario registroProductoDiccionario;

    @PostConstruct
    public void iniciar()
    {
        this.tblTmpProductoDiccionario= new ArrayList<TmpProductoDiccionario>();
		this.cmbCadenas=this.configRepository.findAll();
		this.cmbDiccionario=this.diccionarioRepository.findAll();
		this.cmbCadenaProducto=this.cadenaProductoRepository.findAll();

    }


	public void prepararNuevoRegistro(){

		this.tmpProductoDiccionarioEdicion= new TmpProductoDiccionario();
		
	}

	public void cargarTablaRelacionProductoDiccionario()
	{

		this.tblTmpProductoDiccionario.clear();
		this.tblTmpProductoDiccionario= this.configRepository.cargarTablaProductoDiccionario(this.selectedCadena.getId());

	}


	public void guardarNuevoRegistro()
	{

		this.productoDiccionarioEdicion= new ProductoDiccionario();


		this.productoDiccionarioEdicion.setProductoDiccionarioPK(new ProductoDiccionarioPK(this.selectedCadenaProducto.getRecid(),this.selectedDiccionario.getId()) );

		this.registroProductoDiccionario.guardarRegistro(this.productoDiccionarioEdicion);

		FacesUtil.addInfoMessage("Registro Guardado con exito!");

		RequestContext.getCurrentInstance().update(
				Arrays.asList("configForm:msgs", "configForm:tableProductoDiccionario"));
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

	public List<DiccionarioAlph> getCmbDiccionario() {
		return cmbDiccionario;
	}

	public void setCmbDiccionario(List<DiccionarioAlph> cmbDiccionario) {
		this.cmbDiccionario = cmbDiccionario;
	}

	public DiccionarioAlph getSelectedDiccionario() {
		return selectedDiccionario;
	}

	public void setSelectedDiccionario(DiccionarioAlph selectedDiccionario) {
		this.selectedDiccionario = selectedDiccionario;
	}

	public TmpProductoDiccionario getTmpProductoDiccionarioSelected() {
		return tmpProductoDiccionarioSelected;
	}

	public void setTmpProductoDiccionarioSelected(TmpProductoDiccionario tmpProductoDiccionarioSelected) {
		this.tmpProductoDiccionarioSelected = tmpProductoDiccionarioSelected;
	}

	public List<CadenaProducto> getCmbCadenaProducto() {
		return cmbCadenaProducto;
	}

	public void setCmbCadenaProducto(List<CadenaProducto> cmbCadenaProducto) {
		this.cmbCadenaProducto = cmbCadenaProducto;
	}

	public CadenaProducto getSelectedCadenaProducto() {
		return selectedCadenaProducto;
	}

	public void setSelectedCadenaProducto(CadenaProducto selectedCadenaProducto) {
		this.selectedCadenaProducto = selectedCadenaProducto;
	}

	public ProductoDiccionario getProductoDiccionarioEdicion() {
		return productoDiccionarioEdicion;
	}

	public void setProductoDiccionarioEdicion(ProductoDiccionario productoDiccionarioEdicion) {
		this.productoDiccionarioEdicion = productoDiccionarioEdicion;
	}

	public TmpProductoDiccionario getTmpProductoDiccionarioEdicion() {
		return tmpProductoDiccionarioEdicion;
	}

	public void setTmpProductoDiccionarioEdicion(TmpProductoDiccionario tmpProductoDiccionarioEdicion) {
		this.tmpProductoDiccionarioEdicion = tmpProductoDiccionarioEdicion;
	}
}
