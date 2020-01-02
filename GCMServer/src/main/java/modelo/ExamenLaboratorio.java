package modelo;

import javax.persistence.*;

@Entity
public class ExamenLaboratorio {

	@Id
	private int el_codigo;
	
	private Cita ci_codigo;
	private String el_sangre;
	private String el_plaquetas;
	private String el_grupo_sanguineo;
	public int getEl_codigo() {
		return el_codigo;
	}
	public void setEl_codigo(int el_codigo) {
		this.el_codigo = el_codigo;
	}
	public Cita getCi_codigo() {
		return ci_codigo;
	}
	public void setCi_codigo(Cita ci_codigo) {
		this.ci_codigo = ci_codigo;
	}
	public String getEl_sangre() {
		return el_sangre;
	}
	public void setEl_sangre(String el_sangre) {
		this.el_sangre = el_sangre;
	}
	public String getEl_plaquetas() {
		return el_plaquetas;
	}
	public void setEl_plaquetas(String el_plaquetas) {
		this.el_plaquetas = el_plaquetas;
	}
	public String getEl_grupo_sanguineo() {
		return el_grupo_sanguineo;
	}
	public void setEl_grupo_sanguineo(String el_grupo_sanguineo) {
		this.el_grupo_sanguineo = el_grupo_sanguineo;
	}
	@Override
	public String toString() {
		return "ExamenLaboratorio [el_codigo=" + el_codigo + ", ci_codigo=" + ci_codigo + ", el_sangre=" + el_sangre
				+ ", el_plaquetas=" + el_plaquetas + ", el_grupo_sanguineo=" + el_grupo_sanguineo + "]";
	}
	
	
}
