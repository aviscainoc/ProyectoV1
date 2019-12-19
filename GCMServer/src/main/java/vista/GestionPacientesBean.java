package vista;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Paciente;
import negocio.GestionPaciente;
import negocio.GestionPacientesLocal;

@ManagedBean
public class GestionPacientesBean {
	
	@Inject
	//private GestionUsuarios gl = new GestionUsuarios();
	private GestionPacientesLocal gl;

	private int pa_codigo;
	private String pa_estado_civil;
	private String pa_nivel_estudio;
	private String pa_ocupacion;
	private String pa_etnia;
	private String pa_religion;
	private String pa_tipo_sangre;
	private String pa_identidad_sexual;
	private String pa_precedencia;
	
	private List<Paciente> pacientes;

	
		
	public GestionPacientesLocal getGl() {
		return gl;
	}

	public void setGl(GestionPacientesLocal gl) {
		this.gl = gl;
	}

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

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
public String guardarPaciente() {
	
	gl.guardarPaciente(pa_codigo, pa_estado_civil, pa_nivel_estudio, pa_ocupacion, pa_etnia, pa_religion, pa_tipo_sangre, pa_identidad_sexual, pa_precedencia);
	pacientes= gl.getPacientes();	
	System.out.println(pacientes);
		
	return "listar-pacientes";
	}
	

	public void eliminar() {
		gl.eliminar(pa_codigo);
	}

	public void update() {
		gl.updatePaciente(pa_codigo, pa_estado_civil,pa_nivel_estudio, pa_ocupacion, 
				pa_etnia, pa_religion, pa_tipo_sangre, pa_identidad_sexual, pa_precedencia);
	}
	/*public Paciente login(String usuario, String contrasena) {
		Paciente us = gl.login(usuario, contrasena);
		return us;

	}*/
	
}
