package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Cita;
import modelo.HistoriaClinica;
import modelo.RecetaMedica;
import modelo.Usuario;
import negocio.GestionHistoriaClinicaLocal;
import negocio.GestionRecetaMedicaLocal;

@ManagedBean
public class GestionHistoriaClinicaBean {

	@Inject
	private GestionHistoriaClinicaLocal gl;
	private int hc_codigo;
	private String hc_residencia;
	private String hc_fecha;
	private String hc_movito_consulta;
	private String hc_enfermedad_actual;
	private Usuario usuario;
	private Cita cita;
	
	private List<HistoriaClinica> historias;
	
	public GestionHistoriaClinicaLocal getGl() {
		return gl;
	}

	public void setGl(GestionHistoriaClinicaLocal gl) {
		this.gl = gl;
	}

	public int getHc_codigo() {
		return hc_codigo;
	}

	public void setHc_codigo(int hc_codigo) {
		this.hc_codigo = hc_codigo;
	}

	public String getHc_residencia() {
		return hc_residencia;
	}

	public void setHc_residencia(String hc_residencia) {
		this.hc_residencia = hc_residencia;
	}

	public String getHc_fecha() {
		return hc_fecha;
	}

	public void setHc_fecha(String hc_fecha) {
		this.hc_fecha = hc_fecha;
	}

	public String getHc_movito_consulta() {
		return hc_movito_consulta;
	}

	public void setHc_movito_consulta(String hc_movito_consulta) {
		this.hc_movito_consulta = hc_movito_consulta;
	}

	public String getHc_enfermedad_actual() {
		return hc_enfermedad_actual;
	}

	public void setHc_enfermedad_actual(String hc_enfermedad_actual) {
		this.hc_enfermedad_actual = hc_enfermedad_actual;
	}

	public List<HistoriaClinica> getHistorias() {
		return historias;
	}

	public void setHistorias(List<HistoriaClinica> historias) {
		this.historias = historias;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public boolean guardarHistoriasClinicas() {
		try {
			System.out.println(hc_codigo + " "+ usuario);
			gl.guardarHistoriaClinica(hc_residencia, hc_fecha, hc_movito_consulta, hc_enfermedad_actual);
			hc_codigo = gl.guardarHistoriaClinica(hc_residencia, hc_fecha, hc_movito_consulta, hc_enfermedad_actual);
			System.out.println("En el beam"+hc_codigo);
			historias = gl.getHistoriasClinicas();
			return true;	
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public List<HistoriaClinica> recuperarRecetas(){
		historias = gl.getHistoriasClinicas();
		return historias;
	}
	
	public void eliminar() {
		gl.eliminar(hc_codigo);
	}
	
	public void update() {
		gl.update(hc_codigo, hc_enfermedad_actual, hc_enfermedad_actual, hc_enfermedad_actual, hc_enfermedad_actual, usuario);
	}
	
	public HistoriaClinica getHistoria(int codigo) {
		return gl.getHistoria(codigo);
	}

	@Override
	public String toString() {
		return "GestionHistoriaClinicaBean [hc_codigo=" + hc_codigo + ", hc_residencia=" + hc_residencia + ", hc_fecha="
				+ hc_fecha + ", hc_movito_consulta=" + hc_movito_consulta + ", hc_enfermedad_actual="
				+ hc_enfermedad_actual + ", usuario=" + usuario + ", cita=" + cita + ", historias=" + historias + "]";
	}
	
}
