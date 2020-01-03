package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.*;
import negocio.GestionMedicosLocal;

@ManagedBean
public class GestionMedicosBean {
	
	@Inject
	private GestionMedicosLocal gl;
	
	private int us_codigo;
	private String us_nombre;
	private String us_apellidos;
	private String us_cedula;
	private String us_fechaNacimiento;
	private String us_password;
	private String us_correo;
	private String us_area_especializacion;
	private String us_descripcion;
	
	private List<Medico> medicos;

	public String getUs_apellidos() {
		return us_apellidos;
	}

	public void setUs_apellidos(String us_apellidos) {
		this.us_apellidos = us_apellidos;
	}

	public String getUs_cedula() {
		return us_cedula;
	}

	public void setUs_cedula(String us_cedula) {
		this.us_cedula = us_cedula;
	}

	public String getUs_correo() {
		return us_correo;
	}

	public void setUs_correo(String us_correo) {
		this.us_correo = us_correo;
	}

	public String getUs_area_especializacion() {
		return us_area_especializacion;
	}

	public void setUs_area_especializacion(String us_area_especializacion) {
		this.us_area_especializacion = us_area_especializacion;
	}

	public String getUs_descripcion() {
		return us_descripcion;
	}

	public void setUs_descripcion(String us_descripcion) {
		this.us_descripcion = us_descripcion;
	}

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
		gl.guardarMedico(1, us_nombre, us_apellidos, us_fechaNacimiento, us_correo, us_password, us_descripcion, us_area_especializacion);
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
		gl.update(us_codigo, us_nombre, us_apellidos, us_fechaNacimiento, us_correo, us_password, us_descripcion, us_area_especializacion);
	}
	/*public Medico login(String usuario, String contrasena) {
		Medico md = gl.Login(usuario, contrasena);
		return md;
	}*/
}
