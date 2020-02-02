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

	
	private Date ci_fecha_agendacion;
	private Date ci_fecha_cita;
	private String ci_estado;
	
	@ManyToOne
	private Usuario usuario;
	@OneToOne
	private Cita cita;
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
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario us_usuario) {
		this.usuario = us_usuario;
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
	public Cita getCita() {
		return cita;
	}
	public void setCita(Cita cita) {
		this.cita = cita;
	}
	public ExamenLaboratorio getEl_examenLaboratorio() {
		return el_examenLaboratorio;
	}
	public void setEl_examenLaboratorio(ExamenLaboratorio el_examenLaboratorio) {
		this.el_examenLaboratorio = el_examenLaboratorio;
	}
	public CertificadoAusencia getCa_certificadoAusencia() {
		return ca_certificadoAusencia;
	}
	public void setCa_certificadoAusencia(CertificadoAusencia ca_certificadoAusencia) {
		this.ca_certificadoAusencia = ca_certificadoAusencia;
	}
	public RecetaMedica getRm_recetaMedica() {
		return rm_recetaMedica;
	}
	public void setRm_recetaMedica(RecetaMedica rm_recetaMedica) {
		this.rm_recetaMedica = rm_recetaMedica;
	}
	@Override
	public String toString() {
		return "Cita [ci_codigo=" + ci_codigo + ", ci_fecha_agendacion=" + ci_fecha_agendacion + ", ci_fecha_cita="
				+ ci_fecha_cita + ", ci_estado=" + ci_estado + ", usuario=" + usuario + ", cita=" + cita
				+ ", el_examenLaboratorio=" + el_examenLaboratorio + ", ca_certificadoAusencia="
				+ ca_certificadoAusencia + ", rm_recetaMedica=" + rm_recetaMedica + "]";
	}
	
	
}
