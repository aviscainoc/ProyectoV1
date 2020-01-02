package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import modelo.*;
import negocio.GestionExamenLaboratorioLocal;


@ManagedBean
public class GestionExamenLaboratorioBean {
	
	@Inject
	private GestionExamenLaboratorioLocal gl;
	
	@Id
	private int el_codigo;
	@OneToOne
	private Cita ci_codigo;
	private String el_sangre;
	private String el_plaquetas;
	private String el_grupo_sanguineo;
	
	private List<ExamenLaboratorio> ExamenLaboratorios;

	public GestionExamenLaboratorioLocal getGl() {
		return gl;
	}

	public void setGl(GestionExamenLaboratorioLocal gl) {
		this.gl = gl;
	}

	public int getEl_codigo() {
		return el_codigo;
	}

	public void setEl_codigo(int el_codigo) {
		this.el_codigo = el_codigo;
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

	public List<ExamenLaboratorio> getExamenLaboratorios() {
		return ExamenLaboratorios;
	}

	public void setExamenLaboratorios(List<ExamenLaboratorio> examenLaboratorios) {
		ExamenLaboratorios = examenLaboratorios;
	}
	

	public Cita getCi_codigo() {
		return ci_codigo;
	}

	public void setCi_codigo(Cita ci_codigo) {
		this.ci_codigo = ci_codigo;
	}
	
	
	
	

	public List<ExamenLaboratorio> getExamenLaboratorio() {
		return ExamenLaboratorios;
	}

	public void setExamenLaboratorio(List<ExamenLaboratorio> ExamenLaboratorios) {
		this.ExamenLaboratorios = ExamenLaboratorios;
	}

	public String guardarExamenLaboratorios() {
		System.out.println(el_codigo + " " );
		gl.guardarExamenLaboratorio(1, el_sangre, el_plaquetas, el_grupo_sanguineo, ci_codigo);
		ExamenLaboratorios = gl.getExamenLaboratorios();
		return "principal";
	}
	
	public List<ExamenLaboratorio> recuperarExamenLaboratorios(){
		ExamenLaboratorios = gl.getExamenLaboratorios();
		return ExamenLaboratorios;
	}
	public void eliminar() {
		gl.eliminar(el_codigo);
	}
	
	public void update() {
		gl.update(el_codigo, el_sangre, el_plaquetas, el_grupo_sanguineo, ci_codigo);
	}

}
