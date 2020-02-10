package modelo;

import java.text.SimpleDateFormat;
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


	@Temporal(javax.persistence.TemporalType.DATE)
	private Date ci_fecha_agendacion;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
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

	@OneToOne(cascade= {CascadeType.REMOVE}, fetch=FetchType.EAGER)
	@JoinColumn(referencedColumnName="fac_cab_id")
	private FacturaCabecera fac_cab_factura;
	
	private int contador;
	
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
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
	public FacturaCabecera getFac_cab_factura() {
		return fac_cab_factura;
	}
	public void setFac_cab_factura(FacturaCabecera fac_cab_factura) {
		this.fac_cab_factura = fac_cab_factura;
	}
	
	@Transient
	public String getHora() {
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		String time = localDateFormat.format(ci_fecha_cita);
		System.out.println(time);
		return time;
	}
	
	@Override
	public String toString() {
		return "Cita [ci_codigo=" + ci_codigo + ", ci_fecha_agendacion=" + ci_fecha_agendacion + ", ci_fecha_cita="
				+ ci_fecha_cita + ", ci_estado=" + ci_estado + ", usuario=" + usuario + ", historia=" + historia
				+ ", examen=" + examen + ", receta=" + receta + ", certificado=" + certificado + ", fac_cab_factura="
				+ fac_cab_factura + "]";
	}	
}
