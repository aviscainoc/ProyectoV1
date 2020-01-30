package modelo;

import java.util.Date;

import javax.persistence.*;

@Entity

@TableGenerator(
	name = "Cita", 
	initialValue = 1, 
	pkColumnName = "ENTITY", 
	pkColumnValue = "ci_codigo", 
	allocationSize = 1, 
	table = "ENTITY_GENERATOR"
		)
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ci_codigo;

	@ManyToOne
	private Usuario us_usuario;
	
	private Date ci_fecha_agendacion;
	private Date ci_fecha_cita;
	private String ci_estado;
	
	@OneToOne
	private ExamenLaboratorio el_examenLaboratorio;
	
	@OneToOne
	private CertificadoAusencia ca_certificadoAusencia;
	
	@OneToOne
	private RecetaMedica rm_recetaMedica;

	
	
	public String getCi_estado() {
		return ci_estado;
	}
	public void setCi_estado(String ci_estado) {
		this.ci_estado = ci_estado;
	}
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
