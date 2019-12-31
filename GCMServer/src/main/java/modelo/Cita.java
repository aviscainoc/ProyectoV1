package modelo;

import javax.persistence.*;

@Entity
public class Cita {

	@Id
	private int ci_codigo;
	
	@ManyToOne
	private Medico me_codigo;
	
	@ManyToOne
	private Paciente pa_codigo;
	
	private String ci_fecha_agendacion;
	private String ci_fecha_cita;
	
	public int getCi_codigo() {
		return ci_codigo;
	}
	public void setCi_codigo(int ci_codigo) {
		this.ci_codigo = ci_codigo;
	}
	public Medico getMe_codigo() {
		return me_codigo;
	}
	public void setMe_codigo(Medico me_codigo) {
		this.me_codigo = me_codigo;
	}
	public Paciente getPa_codigo() {
		return pa_codigo;
	}
	public void setPa_codigo(Paciente pa_codigo) {
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
	@Override
	public String toString() {
		return "Cita [ci_codigo=" + ci_codigo + ", me_codigo=" + me_codigo + ", pa_codigo=" + pa_codigo
				+ ", ci_fecha_agendacion=" + ci_fecha_agendacion + ", ci_fecha_cita=" + ci_fecha_cita + "]";
	}
	
	
}
