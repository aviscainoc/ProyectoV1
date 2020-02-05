package vista;

import java.util.Arrays;
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
	
	private int el_codigo;
	private String[] el_quimica;
	private String[] el_heces;
	private String[] el_microbiologia;
	private String[] el_hematologia;
	private String[] el_orina;
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
	public String[] getEl_quimica() {
		return el_quimica;
	}
	public void setEl_quimica(String[] el_quimica) {
		this.el_quimica = el_quimica;
	}
	public String[] getEl_heces() {
		return el_heces;
	}
	public void setEl_heces(String[] el_heces) {
		this.el_heces = el_heces;
	}
	public String[] getEl_microbiologia() {
		return el_microbiologia;
	}
	public void setEl_microbiologia(String[] el_microbiologia) {
		this.el_microbiologia = el_microbiologia;
	}
	public String[] getEl_hematologia() {
		return el_hematologia;
	}
	public void setEl_hematologia(String[] el_hematologia) {
		this.el_hematologia = el_hematologia;
	}
	public String[] getEl_orina() {
		return el_orina;
	}
	public void setEl_orina(String[] el_orina) {
		this.el_orina = el_orina;
	}
	public List<ExamenLaboratorio> getExamenLaboratorios() {
		return ExamenLaboratorios;
	}
	public void setExamenLaboratorios(List<ExamenLaboratorio> examenLaboratorios) {
		ExamenLaboratorios = examenLaboratorios;
	}
	
	public boolean guardarExamenLaboratorios() {
		try {
			gl.guardarExamenLaboratorio(Arrays.toString(el_quimica), Arrays.toString(el_heces), Arrays.toString(el_microbiologia), Arrays.toString(el_hematologia), Arrays.toString(el_orina));
			ExamenLaboratorios = gl.getExamenLaboratorios();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public List<ExamenLaboratorio> recuperarExamenLaboratorios(){
		ExamenLaboratorios = gl.getExamenLaboratorios();
		return ExamenLaboratorios;
	}
	public void eliminar() {
		gl.eliminar(el_codigo);
	}
	/*
	public void update() {
		gl.update(el_codigo, el_sangre, el_plaquetas, el_grupo_sanguineo, ci_codigo);
	}*/
	
	public ExamenLaboratorio getExamen(int codigo) {
		return gl.getExamen(codigo);
	}
	
	@Override
	public String toString() {
		String str = "GestionExamenLaboratorioBean [el_codigo=" + el_codigo + ", el_quimica="
				+ Arrays.toString(el_quimica) + ", el_heces=" + Arrays.toString(el_heces) + ", el_microbiologia="
				+ Arrays.toString(el_microbiologia) + ", el_hematologia=" + Arrays.toString(el_hematologia)
				+ ", el_orina=" + Arrays.toString(el_orina) + ", ExamenLaboratorios=" + ExamenLaboratorios + "]";
		System.out.println(str);
		return str;
	}
}
