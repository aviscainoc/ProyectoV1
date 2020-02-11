package servicios;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import datos.*;
import modelo.*;
import negocio.*;

@WebService
public class ServicesSoap {

	@Inject
	private GestionFacturaCabeceraLocal glc;
	
	@Inject 
	private GestionFacturaDetalleLocal gld;
	
	
	/*@WebMethod
	public Respuesta CrearCabecera(String cedula){
		Respuesta res = new Respuesta();
		try {
			glc.guardarFacturaCabecera(cedula);
			res.setCodigo(1);
			res.setMensaje("Cabecera creada Correctamente: " + cedula + glc.getFacturas());
		}catch(Exception e) {
			res.setCodigo(505);
			res.setMensaje("Error creando cabecera");
		}
		return res;
	}*/
	
	@WebMethod
	public Respuesta CrearDetalle (String fac_det_descripcion, double fac_det_precio, int fac_det_cantidad, int fac_cab_id) {
		Respuesta res = new Respuesta();
		try {		
			if(gld.guardarFacturaDetalle(fac_det_descripcion, fac_det_precio, fac_det_cantidad, fac_cab_id)) {
				res.setCodigo(1);
				res.setMensaje("Detalle guardado Correctamente ");
			}else {
				res.setCodigo(300);
				res.setMensaje("Error insertando detalle");
			}
		}catch(Exception e) {
			res.setCodigo(505);
			res.setMensaje("Error insertando detalle2");
		}
		return res;
	}
	/*
	@WebMethod
	public Respuesta CrearEstado (String nombre) {
		Respuesta res = new Respuesta();
		try {		
			gle.guardarEstado(nombre);
			res.setCodigo(1);
			res.setMensaje("Estado guardado Correctamente");
		}catch(Exception e) {
			res.setCodigo(505);
			res.setMensaje("Error insertando Estado");
		}
		return res;
	}
	
	
	@WebMethod
	public List<Persona> getPersonas(){
		return glp.getPersonas();
	}
	
	@WebMethod
	public List<Estado> getEstados(){
		return gle.getEstados();
	}
	*/
	@WebMethod
	public List<FacturaCabecera> getCabeceras(){
		return glc.getFacturas();
	}
	/*
	@WebMethod
	public List<Titulo> getTituloNombre(String nombre){
		return glt.getTituloNombre(nombre);
	}
	
	@WebMethod
	public Respuesta CrearEstadoAuto () {
		Respuesta res = new Respuesta();
		try {		
			gle.crearEstado();
			res.setCodigo(1);
			res.setMensaje("Estado guardado Correctamente");
		}catch(Exception e) {
			res.setCodigo(505);
			res.setMensaje("Error insertando Estado");
		}
		return res;
	}*/
	
	
}
