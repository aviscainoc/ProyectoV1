package modelo;

import javax.persistence.*;

@Entity
public class CertificadoAusencia {

	@Id
	private int ca_codigo;
	
	@OneToOne
	private Cita ci_codigo;
	
	private String ca_descripcion;

	public int getca_codigo() {
		return ca_codigo;
	}
	public void setCa_codigo(int ca_codigo) {
		this.ca_codigo = ca_codigo;
	}
	public Cita getCi_codigo() {
		return ci_codigo;
	}
	public void setCi_codigo(Cita ci_codigo) {
		this.ci_codigo = ci_codigo;
	}
	public String getCa_descripcion() {
		return ca_descripcion;
	}
	public void setCa_descripcion(String ca_descripcion) {
		this.ca_descripcion = ca_descripcion;
	}
	@Override
	public String toString() {
		return "CertificadoAusencia [ca_codigo=" + ca_codigo + ", ci_codigo=" + ci_codigo + ", ca_descripcion=" + ca_descripcion
				+ "]";
	}
	
	
}