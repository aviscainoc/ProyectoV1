package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Cita;
import modelo.FacturaCabecera;
import modelo.FacturaDetalle;
import modelo.Usuario;
import negocio.GestionFacturaCabeceraLocal;
import negocio.GestionFacturaDetalleLocal;

@ManagedBean
public class GestionFacturaCabeceraBean {
	@Inject
	private GestionFacturaCabeceraLocal glc;
	
	@Inject
	private GestionFacturaDetalleLocal gld;
	
	private Usuario us_usuario;
	private FacturaDetalle fac_det;
	private String us_cedula; 
	private List<FacturaDetalle> fac_cab_detalles;
	private String fac_det_descripcion;
	private double fac_det_precio;
	private int fac_det_cantidad;
	private int fac_cab_id;
	
	public GestionFacturaCabeceraLocal getGlc() {
		return glc;
	}
	public void setGlc(GestionFacturaCabeceraLocal glc) {
		this.glc = glc;
	}
	public Usuario getUs_usuario() {
		return us_usuario;
	}
	public void setUs_usuario(Usuario us_usuario) {
		this.us_usuario = us_usuario;
	}
	public FacturaDetalle getFac_det() {
		return fac_det;
	}
	public void setFac_det(FacturaDetalle fac_det) {
		this.fac_det = fac_det;
	}
	public List<FacturaDetalle> getFac_cab_detalles() {
		return fac_cab_detalles;
	}
	public void setFac_cab_detalles(List<FacturaDetalle> fac_cab_detalles) {
		this.fac_cab_detalles = fac_cab_detalles;
	}
	
	public String getUs_cedula() {
		return us_cedula;
	}
	public void setUs_cedula(String us_cedula) {
		this.us_cedula = us_cedula;
	}	
	public GestionFacturaDetalleLocal getGld() {
		return gld;
	}
	public void setGld(GestionFacturaDetalleLocal gld) {
		this.gld = gld;
	}
	public String getFac_det_descripcion() {
		return fac_det_descripcion;
	}
	public void setFac_det_descripcion(String fac_det_descripcion) {
		this.fac_det_descripcion = fac_det_descripcion;
	}
	public double getFac_det_precio() {
		return fac_det_precio;
	}
	public void setFac_det_precio(double fac_det_precio) {
		this.fac_det_precio = fac_det_precio;
	}
	public int getFac_det_cantidad() {
		return fac_det_cantidad;
	}
	public void setFac_det_cantidad(int fac_det_cantidad) {
		this.fac_det_cantidad = fac_det_cantidad;
	}
	public int getFac_cab_id() {
		return fac_cab_id;
	}
	public void setFac_cab_id(int fac_cab_id) {
		this.fac_cab_id = fac_cab_id;
	}
	
	public List<FacturaCabecera> recuperarCabeceras(){
		return glc.getFacturas();
	}
	
	public String guardarDetalle() {
		if(gld.guardarFacturaDetalle(fac_det_descripcion, fac_det_precio, fac_det_cantidad, fac_cab_id)) {
			System.out.println("Detalle insertado Correctamente");
			return "listar_cabecera";
		}else
			return "error";
	}

}
