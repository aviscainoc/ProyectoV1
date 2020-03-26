package vista;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import datos.RegistroDAO;
import modelo.*;
import negocio.GestionRegistroLocal;


@ManagedBean
public class GestionRegistroBean {	
	
	@Inject
	RegistroDAO dao;
	
	@Inject
	private GestionRegistroLocal gl;
	
	String titulo_pasar="";
	
	private int re_codigo;
	private String re_titulo;
	private String re_fecha;
	private List<Candidato> candidatos;
	
	
	
	private String us_cedula;
	private String us_nombres;
	private int us_num_lista;
	private String us_titulo_universitario;
	
	private List<Voto> votos;
	
		
	
	
	public String getTitulo_pasar() {
		return titulo_pasar;
	}

	public void setTitulo_pasar(String titulo_pasar) {
		this.titulo_pasar = titulo_pasar;
	}

	public String getUs_cedula() {
		return us_cedula;
	}

	public void setUs_cedula(String us_cedula) {
		this.us_cedula = us_cedula;
	}

	public String getUs_nombres() {
		return us_nombres;
	}

	public void setUs_nombres(String us_nombres) {
		this.us_nombres = us_nombres;
	}

	public int getUs_num_lista() {
		return us_num_lista;
	}

	public void setUs_num_lista(int us_num_lista) {
		this.us_num_lista = us_num_lista;
	}

	public String getUs_titulo_universitario() {
		return us_titulo_universitario;
	}

	public void setUs_titulo_universitario(String us_titulo_universitario) {
		this.us_titulo_universitario = us_titulo_universitario;
	}

	
	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public GestionRegistroLocal getGl() {
		return gl;
	}

	public void setGl(GestionRegistroLocal gl) {
		this.gl = gl;
	}

	public int getRe_codigo() {
		return re_codigo;
	}

	public void setRe_codigo(int re_codigo) {
		this.re_codigo = re_codigo;
	}

	public String getRe_titulo() {
		return re_titulo;
	}

	public void setRe_titulo(String re_titulo) {
		this.re_titulo = re_titulo;
	}

	public String getRe_fecha() {
		return re_fecha;
	}

	public void setRe_fecha(String re_fecha) {
		this.re_fecha = re_fecha;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	
	
	
	
	public boolean guardarRegistro() {
		try {
			titulo_pasar = re_titulo;
			System.out.println(titulo_pasar);
			gl.guardarRegistro(re_titulo, re_fecha);
			
			
	
			return true;	
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	public boolean agregarCandidato() {
		try {
			System.out.println(titulo_pasar+"esto pasa el metodo");
			Registro re = dao.obtenerCodigo("ELECCIONES");
			gl.agregarCandidato(re.getRe_codigo(), us_cedula, us_nombres, us_num_lista, us_titulo_universitario);
	
			return true;	
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	public List<Candidato> verResultados(){
		return gl.verResultados();
	}
	
	
	/*
	public void update() {
		gl.update(ca_codigo, ca_descripcion);
	}
	
	public Registro getCertificado(int codigo) {
		return gl.getCertificado(codigo);
	}

	@Override
	public String toString() {
		return "GestionCertificadoAusenciaBean [ca_codigo=" + ca_codigo + ", ca_descripcion=" + ca_descripcion
				+ ", CertificadoAusencias=" + CertificadoAusencias + "]";
	}*/

}
