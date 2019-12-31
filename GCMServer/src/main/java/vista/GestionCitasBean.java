package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;
import negocio.GestionCitaLocal;
import negocio.GestionMedicosLocal;
@ManagedBean
public class GestionCitasBean {

	@Inject
	private GestionCitaLocal gl;
	
	private int ci_codigo;
	private int me_codigo;
	private int pa_codigo;
	private String ci_fecha_agendacion;
	private String ci_fecha_cita;
	
	private List<Cita> citas;
	
	
	public int getCi_codigo() {
		return ci_codigo;
	}

	public void setCi_codigo(int ci_codigo) {
		this.ci_codigo = ci_codigo;
	}

	public int getMe_codigo() {
		return me_codigo;
	}

	public void setMe_codigo(int me_codigo) {
		this.me_codigo = me_codigo;
	}

	public int getPa_codigo() {
		return pa_codigo;
	}

	public void setPa_codigo(int pa_codigo) {
		this.pa_codigo = pa_codigo;
	}

	public String getCi_fecha_agendacion() {
		return ci_fecha_agendacion;
	}

	public void setCi_fecha_agendacion(String ci_fecha_agendacion) {
		this.ci_fecha_agendacion = ci_fecha_agendacion;
	}

	public String getCi_fecha_cita() {
		return ci_fecha_cita;
	}

	public void setCi_fecha_cita(String ci_fecha_cita) {
		this.ci_fecha_cita = ci_fecha_cita;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public void setGl(GestionCitaLocal gl) {
		this.gl = gl;
	}
	
	public String guardarCita() {
		gl.guardarCita(ci_codigo, me_codigo, pa_codigo, ci_fecha_agendacion, ci_fecha_cita);
		citas=gl.getCitas();
		return "index-citas";
	}
	
	public List<Cita> recuperarCitas(){
		citas=gl.getCitas();
		return citas;
		
	}
	
	public void eliminar() {
		gl.eliminar(ci_codigo);
	}
	
	public void update() {
		gl.updateCita(ci_codigo, me_codigo, pa_codigo, ci_fecha_agendacion, ci_fecha_cita);
		
	}

}



	