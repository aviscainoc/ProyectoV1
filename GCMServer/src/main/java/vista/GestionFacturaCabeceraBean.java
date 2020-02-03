package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Cita;
import modelo.FacturaCabecera;
import modelo.FacturaDetalle;
import modelo.Usuario;
import negocio.GestionFacturaCabeceraLocal;

@ManagedBean
public class GestionFacturaCabeceraBean {
	@Inject
	private GestionFacturaCabeceraLocal glc;
	
	private Usuario us_usuario;
	private FacturaDetalle fac_det;
	private List<FacturaDetalle> fac_cab_detalles;
	
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
	
	public String guardarFacturaCabecera() {
		glc.guardarFacturaCabecera(us_usuario.getUs_cedula());
		return "listar_cabeceras";
	}
	public List<FacturaCabecera> recuperarCabeceras(){
		return glc.getFactura();
	}
}
