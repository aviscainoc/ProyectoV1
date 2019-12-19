package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paciente implements Serializable {

	@Id
	private int pa_codigo;
	private String pa_estado_civil;
	private String pa_nivel_estudio;
	private String pa_ocupacion;
	private String pa_etnia;
	private String pa_religion;
	private String pa_tipo_sangre;
	private String pa_identidad_sexual;
	private String pa_precedencia;
	
	
	public int getPa_codigo() {
		return pa_codigo;
	}
	public void setPa_codigo(int pa_codigo) {
		this.pa_codigo = pa_codigo;
	}
	public String getPa_estado_civil() {
		return pa_estado_civil;
	}
	public void setPa_estado_civil(String pa_estado_civil) {
		this.pa_estado_civil = pa_estado_civil;
	}
	public String getPa_nivel_estudio() {
		return pa_nivel_estudio;
	}
	public void setPa_nivel_estudio(String pa_nivel_estudio) {
		this.pa_nivel_estudio = pa_nivel_estudio;
	}
	public String getPa_ocupacion() {
		return pa_ocupacion;
	}
	public void setPa_ocupacion(String pa_ocupacion) {
		this.pa_ocupacion = pa_ocupacion;
	}
	public String getPa_etnia() {
		return pa_etnia;
	}
	public void setPa_etnia(String pa_etnia) {
		this.pa_etnia = pa_etnia;
	}
	public String getPa_religion() {
		return pa_religion;
	}
	public void setPa_religion(String pa_religion) {
		this.pa_religion = pa_religion;
	}
	public String getPa_tipo_sangre() {
		return pa_tipo_sangre;
	}
	public void setPa_tipo_sangre(String pa_tipo_sangre) {
		this.pa_tipo_sangre = pa_tipo_sangre;
	}
	public String getPa_identidad_sexual() {
		return pa_identidad_sexual;
	}
	public void setPa_identidad_sexual(String pa_identidad_sexual) {
		this.pa_identidad_sexual = pa_identidad_sexual;
	}
	public String getPa_precedencia() {
		return pa_precedencia;
	}
	public void setPa_precedencia(String pa_precedencia) {
		this.pa_precedencia = pa_precedencia;
	}
	
	
	@Override
	public String toString() {
		return "Paciente [pa_codigo=" + pa_codigo + ", pa_estado_civil=" + pa_estado_civil + ", pa_nivel_estudio="
				+ pa_nivel_estudio + ", pa_ocupacion=" + pa_ocupacion + ", pa_etnia=" + pa_etnia + ", pa_religion="
				+ pa_religion + ", pa_tipo_sangre=" + pa_tipo_sangre + ", pa_identidad_sexual=" + pa_identidad_sexual
				+ ", pa_precedencia=" + pa_precedencia + "]";
	}
	
	
	/*private Antecedentes_Personales antecedentes_personales;
	private Antecedentes_Familiares antecedentes_familiares;
	private Historia_Clinica historia_clinica;
	private Factua_Cabecera factura_cabecera;
	private Cita cita;
	private Usuario usuario;
	private Antecedentes_Sociales antecedentes_sociales;*/
	
	/*private int ap_codigo;
	private String ap_adulto_medicas;
	private String ap_quirurjicas;
	private String ap_gineco_obstetricos;
	private String ap_psiquiatricas;*/
	
	
}
