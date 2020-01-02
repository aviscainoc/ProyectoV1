package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import negocio.GestionMedicosLocal;
import modelo.*;
@ManagedBean
public class GestionMedicosBean {
	
	@Inject
	private GestionMedicosLocal gl;
	
	private int us_codigo;
	private String us_nombre;
	private String us_fechaNacimiento;
	private String us_nickname;
	private String us_password;
	
	private List<Medico> medicos;
	
	
	
	
	
	
	
	public GestionMedicosLocal getGl() {
		return gl;
	}

	public void setGl(GestionMedicosLocal gl) {
		this.gl = gl;
	}

	public int getUs_codigo() {
		return us_codigo;
	}

	public void setUs_codigo(int us_codigo) {
		this.us_codigo = us_codigo;
	}

	public String getUs_nombre() {
		return us_nombre;
	}

	public void setUs_nombre(String us_nombre) {
		this.us_nombre = us_nombre;
	}

	public String getUs_fechaNacimiento() {
		return us_fechaNacimiento;
	}

	public void setUs_fechaNacimiento(String us_fechaNacimiento) {
		this.us_fechaNacimiento = us_fechaNacimiento;
	}

	public String getUs_nickname() {
		return us_nickname;
	}

	public void setUs_nickname(String us_nickname) {
		this.us_nickname = us_nickname;
	}

	public String getUs_password() {
		return us_password;
	}

	public void setUs_password(String us_password) {
		this.us_password = us_password;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public String guardarUsuarios() {
		System.out.println(us_codigo + " " + us_nombre + " ");
		gl.guardarMedico(1, us_nombre, us_fechaNacimiento, us_nickname, us_password);
		medicos = gl.getMedicos();
		return "principal";
	}
	
	public List<Medico> recuperarMedicos(){
		medicos = gl.getMedicos();
		return medicos;
	}
	public void eliminar() {
		gl.eliminar(us_codigo);
	}
	
	public void update() {
		gl.update(us_codigo, us_nombre, us_fechaNacimiento, us_nickname, us_password);
	}
	/*public Medico login(String usuario, String contrasena) {
		Medico md = gl.Login(usuario, contrasena);
		return md;
	}*/
}
