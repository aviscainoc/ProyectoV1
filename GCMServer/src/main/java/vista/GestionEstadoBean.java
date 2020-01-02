package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.*;
import negocio.GestionEstadoLocal;


@ManagedBean
public class GestionEstadoBean {
	
	@Inject
	private GestionEstadoLocal gl;
	
	private int es_codigo;
	private String es_tipo;

	
	private List<Estado> estados;
	
	public GestionEstadoLocal getGl() {
		return gl;
	}

	public void setGl(GestionEstadoLocal gl) {
		this.gl = gl;
	}

	public int getEs_codigo() {
		return es_codigo;
	}

	public void setEs_codigo(int es_codigo) {
		this.es_codigo = es_codigo;
	}

	public String getEs_tipo() {
		return es_tipo;
	}

	public void setEs_tipo(String es_tipo) {
		this.es_tipo = es_tipo;
	}


	public String guardarUsuarios() {
		System.out.println(es_codigo + " " + es_tipo + " ");
		gl.guardarEstado(1, es_tipo);
		estados = gl.getEstados();
		return "principal";
	}
	
	public List<Estado> recuperarEstados(){
		estados = gl.getEstados();
		return estados;
	}
	public void eliminar() {
		gl.eliminar(es_codigo);
	}
	
	public void update() {
		gl.update(es_codigo, es_tipo);
	}
}
