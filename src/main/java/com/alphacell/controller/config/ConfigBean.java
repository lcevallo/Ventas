package com.alphacell.controller.config;


import com.alphacell.model.*;
import com.alphacell.repository.CadenaProductoRepository;
import com.alphacell.repository.ConfigRepository;
import com.alphacell.repository.DiccionarioRepository;
import com.alphacell.repository.OperadorRepository;
import com.alphacell.service.RegistroCadena;
import com.alphacell.service.RegistroCadenaProducto;
import com.alphacell.service.RegistroDiccionario;
import com.alphacell.service.RegistroProductoDiccionario;
import com.alphacell.util.jsf.FacesUtil;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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

	private Boolean puedoCrearNuevo=false;
	private Boolean presioneNuevo=false;
	private Boolean puedoCrearNuevoProductoDiccionario=false;


	private List<DiccionarioAlph> cmbDiccionario;
	private DiccionarioAlph selectedDiccionario;


	private List<CadenaProducto> cmbCadenaProducto;
	private CadenaProducto selectedCadenaProducto;

	private List<Operador> cmbOperadora;
	private Operador selectedOperadora;

	private List<TmpProductoDiccionario> tblTmpProductoDiccionario;

	private TmpProductoDiccionario tmpProductoDiccionarioSelected;

	private TmpProductoDiccionario tmpProductoDiccionarioEdicion;

	private ProductoDiccionario productoDiccionarioEdicion;

	private Cadena cadenaEdicion= new Cadena();

    private DiccionarioAlph diccinarioAlphEdicion= new DiccionarioAlph();

	private CadenaProducto cadenaProductoEdicion= new CadenaProducto();

    @Inject
    private ConfigRepository configRepository;

	@Inject
	private DiccionarioRepository diccionarioRepository;

	@Inject
	private CadenaProductoRepository cadenaProductoRepository;

	@Inject
	private OperadorRepository operadorRepository;

	@Inject
	private RegistroProductoDiccionario registroProductoDiccionario;

	@Inject
	private RegistroCadena registroCadena;

	@Inject
	private RegistroCadenaProducto registroCadenaProducto;

	@Inject
	private RegistroDiccionario registroDiccionario;



    @PostConstruct
    public void iniciar()
    {

		this.puedoCrearNuevo=false;
		this.presioneNuevo=false;
		this.tblTmpProductoDiccionario= new ArrayList<TmpProductoDiccionario>();
		this.cmbCadenas=this.configRepository.findAll();
		this.cmbDiccionario=this.diccionarioRepository.findAll();
        this.cmbOperadora=this.operadorRepository.findALl();

    }

	public void selectEdicion(){

		this.presioneNuevo=false;
		this.cmbCadenaProducto=this.cadenaProductoRepository.findByCadenaId(this.selectedCadena.getId());
		this.tmpProductoDiccionarioEdicion=this.tmpProductoDiccionarioSelected;
		this.selectedCadenaProducto= cadenaProductoRepository.findById(this.tmpProductoDiccionarioEdicion.getRecid());
        this.selectedOperadora=this.operadorRepository.findById(this.tmpProductoDiccionarioEdicion.getFkOperadora());


		if(this.tmpProductoDiccionarioEdicion.getFkDiccionario()!=null)
        {
            this.selectedDiccionario=diccionarioRepository.findById(this.tmpProductoDiccionarioEdicion.getFkDiccionario());


        }

		else
        {

            this.selectedDiccionario=null;
        }

	}


	public void prepararNuevaCadena(){
		this.cadenaEdicion= new Cadena();
	}


	public void prepararNuevoRegistro(){

		this.tmpProductoDiccionarioEdicion= new TmpProductoDiccionario();
		this.cargarTablaRelacionProductoDiccionario();
		this.cmbCadenaProducto=this.cadenaProductoRepository.findByCadenaId(this.selectedCadena.getId());

		this.presioneNuevo=true;
	}

	public void prepararNuevoRegistroDiccionario()
	{
		this.diccinarioAlphEdicion=new DiccionarioAlph();
	}

	public void prepararNuevoRegistroCanalProducto(){
		this.cadenaProductoEdicion=new CadenaProducto();
		this.cadenaProductoEdicion.setFkCadena(this.selectedCadena);
		this.cmbCadenaProducto=this.cadenaProductoRepository.findByCadenaId(this.selectedCadena.getId());
	}

	public void cargarTablaRelacionProductoDiccionario()
	{

		this.tblTmpProductoDiccionario.clear();
		this.tblTmpProductoDiccionario= this.configRepository.cargarTablaProductoDiccionario(this.selectedCadena.getId());
		this.puedoCrearNuevo=true;
		this.puedoCrearNuevoProductoDiccionario=this.tblTmpProductoDiccionario.size()>0;
	}


    public void guardarNuevoRegistroDiccionario()
    {
       this.registroDiccionario.guardarRegistro(this.diccinarioAlphEdicion);

    }


	public void guardarNuevoRegistro()
	{

		this.productoDiccionarioEdicion= new ProductoDiccionario();

		Integer old_diccionario=-1;

		if(this.tmpProductoDiccionarioEdicion.getFkDiccionario()!=null)
		{
			old_diccionario=this.tmpProductoDiccionarioEdicion.getFkDiccionario();

		}
		this.productoDiccionarioEdicion.setProductoDiccionarioPK(new ProductoDiccionarioPK(this.selectedCadenaProducto.getRecid(),this.selectedDiccionario.getId()) );


		String salida= this.registroProductoDiccionario.guardarRegistro2(old_diccionario,this.productoDiccionarioEdicion,this.selectedOperadora.getId());

		FacesUtil.addInfoMessage(salida);

		this.cargarTablaRelacionProductoDiccionario();


		//cargarTablaRelacionProductoDiccionario();
		RequestContext.getCurrentInstance().update(
				Arrays.asList("configForm:msgs","configForm:tableProductoDiccionario"));
	}

	public void guardarCadena()
	{

		registroCadena.guardarCadena(this.cadenaEdicion);

/*
		this.cmbCadenas.clear();
		this.cmbCadenas=this.configRepository.findAll();
*/

		FacesUtil.addInfoMessage("Cadena agregada con exito");


		RequestContext.getCurrentInstance().update(
				Arrays.asList("configForm:cadenaCombo"));

	}



	/**
	 * Ingresa en la base de datos el registro de cadena producto.
	 * Toma los datos del dialogo de AgregarProductoCadena
	 * Como es el nombre del producto y ademas toma el valor seteado en
	 * el combobox de los canales
	 * This method always returns immediately, whether or not the
	 * image exists. When this applet attempts to draw the image on
	 * the screen, the data will be loaded. The graphics primitives
	 * that draw the image will incrementally paint on the screen.
	 *
	 * @see    null     En la pagina se agregara en el datatable un nuevo producto sin relacion del diccionario de alphacell
	 */

	public void guardarCadenaProducto()
	{

		registroCadenaProducto.guardarRegistro(this.cadenaProductoEdicion);

		FacesUtil.addInfoMessage("Producto agregado al canal"+ this.selectedCadena.getNombre()+" con exito!");

		this.cargarTablaRelacionProductoDiccionario();

		RequestContext.getCurrentInstance().update(
				Arrays.asList("configForm:tableProductoDiccionario"));


	}



	public void onEditTableDiccionario(RowEditEvent event)
	{

		FacesMessage msg = new FacesMessage("Diccionario Editado",((DiccionarioAlph) event.getObject()).getId().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


	public void onCellEdit(CellEditEvent event) {


		this.selectedDiccionario = this.cmbDiccionario.get(event.getRowIndex());

		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		if (newValue != null && !newValue.equals(oldValue)) {
			//TODO: Llamar a la persistencia para que guarde este valor
			this.registroDiccionario.guardarRegistro(this.selectedDiccionario);
		}

	}



	public void removeDiccionarioTabla(ActionEvent event) {
		//TODO:Aqui debo de efectuar la accion de remover de la base de datos
		//computers.remove(computerSelected);
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

	public Boolean getPuedoCrearNuevo() {
		return puedoCrearNuevo;
	}

	public void setPuedoCrearNuevo(Boolean puedoCrearNuevo) {
		this.puedoCrearNuevo = puedoCrearNuevo;
	}

	public Boolean getPresioneNuevo() {
		return presioneNuevo;
	}

	public Cadena getCadenaEdicion() {
		return cadenaEdicion;
	}

	public void setCadenaEdicion(Cadena cadenaEdicion) {
		this.cadenaEdicion = cadenaEdicion;
	}


	public CadenaProducto getCadenaProductoEdicion() {
		return cadenaProductoEdicion;
	}

	public void setCadenaProductoEdicion(CadenaProducto cadenaProductoEdicion) {
		this.cadenaProductoEdicion = cadenaProductoEdicion;
	}

	public Boolean getPuedoCrearNuevoProductoDiccionario() {
		return puedoCrearNuevoProductoDiccionario;
	}

	public void setPuedoCrearNuevoProductoDiccionario(Boolean puedoCrearNuevoProductoDiccionario) {
		this.puedoCrearNuevoProductoDiccionario = puedoCrearNuevoProductoDiccionario;
	}

	public List<Operador> getCmbOperadora() {
		return cmbOperadora;
	}

	public void setCmbOperadora(List<Operador> cmbOperadora) {
		this.cmbOperadora = cmbOperadora;
	}

	public Operador getSelectedOperadora() {
		return selectedOperadora;
	}

	public void setSelectedOperadora(Operador selectedOperadora) {
		this.selectedOperadora = selectedOperadora;
	}

    public DiccionarioAlph getDiccinarioAlphEdicion() {
        return diccinarioAlphEdicion;
    }

    public void setDiccinarioAlphEdicion(DiccionarioAlph diccinarioAlphEdicion) {
        this.diccinarioAlphEdicion = diccinarioAlphEdicion;
    }
}