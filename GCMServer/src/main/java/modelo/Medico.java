package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medico {

	@Id
	private int md_id;
	String md_nombre;
	String md_fechaNacimiento;
	String md_usuario;
	String md_password;
	
	private String md_fecha_inicio;
	private String md_area_especializacion;
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
	public String getMd_usuario() {
		return md_usuario;
	}
	public void setMd_usuario(String md_usuario) {
		this.md_usuario = md_usuario;
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
				+ ", md_usuario=" + md_usuario + ", md_password=" + md_password + ", md_fecha_inicio=" + md_fecha_inicio
				+ ", md_area_especializacion=" + md_area_especializacion + "]";
	}

	
}
