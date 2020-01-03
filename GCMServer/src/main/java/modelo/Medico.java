package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medico {

	@Id
	private int md_id;
	String md_nombre;
	String md_apellidos;
	String md_fechaNacimiento;
	String md_correo;
	String md_password;
	private String md_fecha_inicio;
	private String md_area_especializacion;
	private String md_descripcion;

	public String getMd_descripcion() {
		return md_descripcion;
	}
	
	public void setMd_descripcion(String md_descripcion) {
		this.md_descripcion = md_descripcion;
	}
	
	public String getMd_apellidos() {
		return md_apellidos;
	}
	
	public void setMd_apellidos(String md_apellidos) {
		this.md_apellidos = md_apellidos;
	}
	
	public int getMd_id() {
		return md_id;
	}
	public void setMd_id(int md_id) {
		this.md_id = md_id;
	}
	public String getMd_nombre() {
		return md_nombre;
	}
	public void setMd_nombre(String md_nombre) {
		this.md_nombre = md_nombre;
	}
	public String getMd_fechaNacimiento() {
		return md_fechaNacimiento;
	}
	public void setMd_fechaNacimiento(String md_fechaNacimiento) {
		this.md_fechaNacimiento = md_fechaNacimiento;
	}
	public String getMd_correo() {
		return md_correo;
	}
	public void setMd_correo(String md_correo) {
		this.md_correo = md_correo;
	}
	public String getMd_password() {
		return md_password;
	}
	public void setMd_password(String md_password) {
		this.md_password = md_password;
	}
	public String getMd_fecha_inicio() {
		return md_fecha_inicio;
	}
	public void setMd_fecha_inicio(String md_fecha_inicio) {
		this.md_fecha_inicio = md_fecha_inicio;
	}
	public String getMd_area_especializacion() {
		return md_area_especializacion;
	}
	public void setMd_area_especializacion(String md_area_especializacion) {
		this.md_area_especializacion = md_area_especializacion;
	}
	@Override
	public String toString() {
		return "Medico [md_id=" + md_id + ", md_nombre=" + md_nombre + ", md_fechaNacimiento=" + md_fechaNacimiento
				+ ", md_usuario=" + md_correo + ", md_password=" + md_password + ", md_fecha_inicio=" + md_fecha_inicio
				+ ", md_area_especializacion=" + md_area_especializacion + "]";
	}

	
}
