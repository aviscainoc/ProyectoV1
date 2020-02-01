package modelo;

import javax.persistence.*;

@Entity
public class ExamenLaboratorio {

	@Id
	private int el_codigo;
	
	@OneToOne
	private Cita cita;
	
	private String el_sangre;
	private String el_plaquetas;
	private String el_grupo_sanguineo;
	public int getEl_codigo() {
		return el_codigo;
	}
	public void setEl_codigo(int el_codigo) {
		this.el_codigo = el_codigo;
	}
	public Cita getCita() {
		return cita;
	}
	public void setCita(Cita cita) {
		this.cita = cita;
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
		return "ExamenLaboratorio [el_codigo=" + el_codigo + ", cita=" + cita + ", el_sangre=" + el_sangre
				+ ", el_plaquetas=" + el_plaquetas + ", el_grupo_sanguineo=" + el_grupo_sanguineo + "]";
	}
	
	
}
