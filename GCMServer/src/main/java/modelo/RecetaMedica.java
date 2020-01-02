package modelo;

import javax.persistence.*;

@Entity
public class RecetaMedica {

	@Id
	private int rm_codigo;
	private Paciente pa_codigo;
	@OneToOne
	private Cita ci_codigo;
	private String rm_medicamento;
	private String rm_forma_farmaceutica;
	private String rm_via_administracion;
	private String rm_presentacion;
	private int rm_cantidad;
	private String rm_horario;
	private String rm_duracion_tratamiento;
	public int getRm_codigo() {
		return rm_codigo;
	}
	public void setRm_codigo(int rm_codigo) {
		this.rm_codigo = rm_codigo;
	}
	public Paciente getPa_codigo() {
		return pa_codigo;
	}
	public void setPa_codigo(Paciente pa_codigo) {
		this.pa_codigo = pa_codigo;
	}
	public Cita getCi_codigo() {
		return ci_codigo;
	}
	public void setCi_codigo(Cita ci_codigo) {
		this.ci_codigo = ci_codigo;
	}
	public String getRm_medicamento() {
		return rm_medicamento;
	}
	public void setRm_medicamento(String rm_medicamento) {
		this.rm_medicamento = rm_medicamento;
	}
	public String getRm_forma_farmaceutica() {
		return rm_forma_farmaceutica;
	}
	public void setRm_forma_farmaceutica(String rm_forma_farmaceutica) {
		this.rm_forma_farmaceutica = rm_forma_farmaceutica;
	}
	public String getRm_via_administracion() {
		return rm_via_administracion;
	}
	public void setRm_via_administracion(String rm_via_administracion) {
		this.rm_via_administracion = rm_via_administracion;
	}
	public String getRm_presentacion() {
		return rm_presentacion;
	}
	public void setRm_presentacion(String rm_presentacion) {
		this.rm_presentacion = rm_presentacion;
	}
	public int getRm_cantidad() {
		return rm_cantidad;
	}
	public void setRm_cantidad(int rm_cantidad) {
		this.rm_cantidad = rm_cantidad;
	}
	public String getRm_horario() {
		return rm_horario;
	}
	public void setRm_horario(String rm_horario) {
		this.rm_horario = rm_horario;
	}
	public String getRm_duracion_tratamiento() {
		return rm_duracion_tratamiento;
	}
	public void setRm_duracion_tratamiento(String rm_duracion_tratamiento) {
		this.rm_duracion_tratamiento = rm_duracion_tratamiento;
	}
	@Override
	public String toString() {
		return "RecetaMedica [rm_codigo=" + rm_codigo + ", pa_codigo=" + pa_codigo + ", ci_codigo=" + ci_codigo
				+ ", rm_medicamento=" + rm_medicamento + ", rm_forma_farmaceutica=" + rm_forma_farmaceutica
				+ ", rm_via_administracion=" + rm_via_administracion + ", rm_presentacion=" + rm_presentacion
				+ ", rm_cantidad=" + rm_cantidad + ", rm_horario=" + rm_horario + ", rm_duracion_tratamiento="
				+ rm_duracion_tratamiento + "]";
	}
	
	
}
