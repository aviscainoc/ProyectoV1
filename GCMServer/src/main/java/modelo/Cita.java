package modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Cita {

	@Id
	private int ci_codigo;
	
	/*@ManyToOne
	private Medico me_codigo;
	
	@ManyToOne
	private Paciente pa_codigo;*/
	@ManyToOne
	private Usuario us_usuario;
	
	private Date ci_fecha_agendacion;
	private Date ci_fecha_cita;
	
	public int getCi_codigo() {
		return ci_codigo;
	}
	public void setCi_codigo(int ci_codigo) {
		this.ci_codigo = ci_codigo;
	}
	
	public Usuario getUs_usuario() {
		return us_usuario;
	}
	public void setUs_usuario(Usuario us_usuario) {
		this.us_usuario = us_usuario;
	}
	public Date getCi_fecha_agendacion() {
		return ci_fecha_agendacion;
	}
	public void setCi_fecha_agendacion(Date ci_fecha_agendacion) {
		this.ci_fecha_agendacion = ci_fecha_agendacion;
	}
	public Date getCi_fecha_cita() {
		return ci_fecha_cita;
	}
	public void setCi_fecha_cita(Date ci_fecha_cita) {
		this.ci_fecha_cita = ci_fecha_cita;
	}
	@Override
	public String toString() {
		return "Cita [ci_codigo=" + ci_codigo + ", us_usuario=" + us_usuario + ", ci_fecha_agendacion="
				+ ci_fecha_agendacion + ", ci_fecha_cita=" + ci_fecha_cita + "]";
	}
	
	
}
