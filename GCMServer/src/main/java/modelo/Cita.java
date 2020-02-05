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
	@OneToOne(cascade= {CascadeType.REMOVE}, fetch=FetchType.EAGER)
	@JoinColumn(referencedColumnName="hc_codigo")
	private HistoriaClinica historia;
	@OneToOne(cascade= {CascadeType.REMOVE}, fetch=FetchType.EAGER)
	@JoinColumn(referencedColumnName="el_codigo")
	private ExamenLaboratorio examen;
	@OneToOne(cascade= {CascadeType.REMOVE}, fetch=FetchType.EAGER)
	@JoinColumn(referencedColumnName="rm_codigo")
	private RecetaMedica receta;
	@OneToOne(cascade= {CascadeType.REMOVE}, fetch=FetchType.EAGER)
	@JoinColumn(referencedColumnName="ca_codigo")
	private CertificadoAusencia certificado;

	
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
	public HistoriaClinica getHistoria() {
		return historia;
	}
	public void setHistoria(HistoriaClinica historia) {
		this.historia = historia;
	}
	public RecetaMedica getReceta() {
		return receta;
	}
	public void setReceta(RecetaMedica receta) {
		this.receta = receta;
	}
	public CertificadoAusencia getCertificado() {
		return certificado;
	}
	public void setCertificado(CertificadoAusencia certificado) {
		this.certificado = certificado;
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
	public ExamenLaboratorio getExamen() {
		return examen;
	}
	public void setExamen(ExamenLaboratorio examen) {
		this.examen = examen;
	}
	public CertificadoAusencia getCa_certificadoAusencia() {
		return certificado;
	}
	public void setCa_certificadoAusencia(CertificadoAusencia ca_certificadoAusencia) {
		this.certificado = ca_certificadoAusencia;
	}
	public RecetaMedica getRm_recetaMedica() {
		return receta;
	}
	public void setRm_recetaMedica(RecetaMedica rm_recetaMedica) {
		this.receta = rm_recetaMedica;
	}
	@Override
	public String toString() {
		return "Cita [ci_codigo=" + ci_codigo + ", ci_fecha_agendacion=" + ci_fecha_agendacion + ", ci_fecha_cita="
				+ ci_fecha_cita + ", ci_estado=" + ci_estado + ", usuario=" + usuario + ", historia=" + historia
				+ ", examen=" + examen + ", receta=" + receta + ", certificado=" + certificado + "]";
	}
	
	
}
