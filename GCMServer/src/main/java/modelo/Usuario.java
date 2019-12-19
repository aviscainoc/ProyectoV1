package modelo;

import javax.persistence.*;

public class Usuario {
	
	private String us_cedula;
	private String us_rol;
	private String us_nombres;
	private String us_apellidos;
	private String us_sexo;
	private String us_fecha_nacimiento;
	private String us_correo;
	private String us_usuario;
	private String us_contrasena;
	
	public String getUs_cedula() {
		return us_cedula;
	}
	public void setUs_cedula(String us_cedula) {
		this.us_cedula = us_cedula;
	}
	public String getUs_rol() {
		return us_rol;
	}
	public void setUs_rol(String us_rol) {
		this.us_rol = us_rol;
	}
	public String getUs_nombres() {
		return us_nombres;
	}
	public void setUs_nombres(String us_nombres) {
		this.us_nombres = us_nombres;
	}
	public String getUs_apellidos() {
		return us_apellidos;
	}
	public void setUs_apellidos(String us_apellidos) {
		this.us_apellidos = us_apellidos;
	}
	public String getUs_sexo() {
		return us_sexo;
	}
	public void setUs_sexo(String us_sexo) {
		this.us_sexo = us_sexo;
	}
	public String getUs_fecha_nacimiento() {
		return us_fecha_nacimiento;
	}
	public void setUs_fecha_nacimiento(String us_fecha_nacimiento) {
		this.us_fecha_nacimiento = us_fecha_nacimiento;
	}
	public String getUs_correo() {
		return us_correo;
	}
	public void setUs_correo(String us_correo) {
		this.us_correo = us_correo;
	}
	public String getUs_usuario() {
		return us_usuario;
	}
	public void setUs_usuario(String us_usuario) {
		this.us_usuario = us_usuario;
	}
	public String getUs_contrasena() {
		return us_contrasena;
	}
	public void setUs_contrasena(String us_contrasena) {
		this.us_contrasena = us_contrasena;
	}
	
	@Override
	public String toString() {
		return "Usuario [us_cedula=" + us_cedula + ", us_rol=" + us_rol + ", us_nombres=" + us_nombres
				+ ", us_apellidos=" + us_apellidos + ", us_sexo=" + us_sexo + ", us_fecha_nacimiento="
				+ us_fecha_nacimiento + ", us_correo=" + us_correo + ", us_usuario=" + us_usuario + ", us_contrasena="
				+ us_contrasena + "]";
	}
}
