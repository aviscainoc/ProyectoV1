package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Usuario {
	
	@Id
	private String us_cedula;
	private String us_rol;
	private String us_nombres;
	private String us_apellidos;
	private String us_sexo;
	@Temporal(TemporalType.TIMESTAMP)
	private Date us_fecha_nacimiento;
	private String us_correo;
	private String us_contrasena;

	
	private String us_md_area_especialidad;
	private String us_md_descripcion;
	
	private String us_pa_estado_civil;
	private String us_pa_nivel_estudio;
	private String us_pa_ocupacion;
	private String us_pa_etnia;
	private String us_pa_religion;
	private String us_pa_tipo_sangre;
	private String us_pa_identidad_sexual;
	private String us_pa_procedencia;	
	//atributo para saber si se registro o no 
	private int us_pa_registro;
	
	@OneToMany
	private List<IngresosEgresos> ingresosEgresos;
	
	/*@OneToMany
	private List<HistoriaClinica> historias_clinica;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name="us_cedula")
	private List<Cita> citas;*/
		
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
	public Date getUs_fecha_nacimiento() {
		return us_fecha_nacimiento;
	}
	public void setUs_fecha_nacimiento(Date us_fecha_nacimiento) {
		this.us_fecha_nacimiento = us_fecha_nacimiento;
	}
	public String getUs_correo() {
		return us_correo;
	}
	public void setUs_correo(String us_correo) {
		this.us_correo = us_correo;
	}
	public String getUs_contrasena() {
		return us_contrasena;
	}
	public void setUs_contrasena(String us_contrasena) {
		this.us_contrasena = us_contrasena;
	}
	public String getUs_md_area_especialidad() {
		return us_md_area_especialidad;
	}
	public void setUs_md_area_especialidad(String us_md_area_especialidad) {
		this.us_md_area_especialidad = us_md_area_especialidad;
	}
	public String getUs_md_descripcion() {
		return us_md_descripcion;
	}
	public void setUs_md_descripcion(String us_md_descripcion) {
		this.us_md_descripcion = us_md_descripcion;
	}
	public String getUs_pa_estado_civil() {
		return us_pa_estado_civil;
	}
	public void setUs_pa_estado_civil(String us_pa_estado_civil) {
		this.us_pa_estado_civil = us_pa_estado_civil;
	}
	public String getUs_pa_nivel_estudio() {
		return us_pa_nivel_estudio;
	}
	public void setUs_pa_nivel_estudio(String us_pa_nivel_estudio) {
		this.us_pa_nivel_estudio = us_pa_nivel_estudio;
	}
	public String getUs_pa_ocupacion() {
		return us_pa_ocupacion;
	}
	public void setUs_pa_ocupacion(String us_pa_ocupacion) {
		this.us_pa_ocupacion = us_pa_ocupacion;
	}
	public String getUs_pa_etnia() {
		return us_pa_etnia;
	}
	public void setUs_pa_etnia(String us_pa_etnia) {
		this.us_pa_etnia = us_pa_etnia;
	}
	public String getUs_pa_religion() {
		return us_pa_religion;
	}
	public void setUs_pa_religion(String us_pa_religion) {
		this.us_pa_religion = us_pa_religion;
	}
	public String getUs_pa_tipo_sangre() {
		return us_pa_tipo_sangre;
	}
	public void setUs_pa_tipo_sangre(String us_pa_tipo_sangre) {
		this.us_pa_tipo_sangre = us_pa_tipo_sangre;
	}
	public String getUs_pa_identidad_sexual() {
		return us_pa_identidad_sexual;
	}
	public void setUs_pa_identidad_sexual(String us_pa_identidad_sexual) {
		this.us_pa_identidad_sexual = us_pa_identidad_sexual;
	}
	public String getUs_pa_procedencia() {
		return us_pa_procedencia;
	}
	public void setUs_pa_procedencia(String us_pa_procedencia) {
		this.us_pa_procedencia = us_pa_procedencia;
	}
	/*public List<HistoriaClinica> getHistorias_clinica() {
		return historias_clinica;
	}
	public void setHistorias_clinica(List<HistoriaClinica> historias_clinica) {
		this.historias_clinica = historias_clinica;
	}
	public List<Cita> getCitas() {
		return citas;
	}
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}*/
	public int getUs_pa_registro() {
		return us_pa_registro;
	}
	public void setUs_pa_registro(int us_pa_registro) {
		this.us_pa_registro = us_pa_registro;
	}
	/*
	public void addHistoriaClinica(HistoriaClinica hc) {
		if (historias_clinica == null)
			historias_clinica = new ArrayList<HistoriaClinica>();
		this.historias_clinica.add(hc);
	}
	
	public void addCita(Cita c) {
		if (citas == null)
			citas = new ArrayList<Cita>();
		this.citas.add(c);
	}
	/*public void addFactura(FacturaCabecera fc) {
		if (facs_cab == null)
			facs_cab = new ArrayList<FacturaCabecera>();
		this.facs_cab.add(fc);
	}
	
	/*public List<FacturaCabecera> getFacs_cab() {
		return facs_cab;
	}
	public void setFacs_cab(List<FacturaCabecera> facs_cab) {
		this.facs_cab = facs_cab;
	}*/
	public List<IngresosEgresos> getIngresosEgresos() {
		return ingresosEgresos;
	}

	public void setIngresosEgresos(List<IngresosEgresos> ingresosEgresos) {
		this.ingresosEgresos = ingresosEgresos;
	}

	public void addIngresoEgreso(IngresosEgresos ie) {
		if(ingresosEgresos == null) 
			ingresosEgresos = new ArrayList<IngresosEgresos>();
		ingresosEgresos.add(ie);
	}	
	@Override
	public String toString() {
		return "Usuario [us_cedula=" + us_cedula + ", us_rol=" + us_rol + ", us_nombres=" + us_nombres
				+ ", us_apellidos=" + us_apellidos + ", us_sexo=" + us_sexo + ", us_fecha_nacimiento="
				+ us_fecha_nacimiento + ", us_correo=" + us_correo + ", us_contrasena=" + us_contrasena
				+ ", us_md_area_especialidad=" + us_md_area_especialidad + ", us_md_descripcion=" + us_md_descripcion
				+ ", us_pa_estado_civil=" + us_pa_estado_civil + ", us_pa_nivel_estudio=" + us_pa_nivel_estudio
				+ ", us_pa_ocupacion=" + us_pa_ocupacion + ", us_pa_etnia=" + us_pa_etnia + ", us_pa_religion="
				+ us_pa_religion + ", us_pa_tipo_sangre=" + us_pa_tipo_sangre + ", us_pa_identidad_sexual="
				+ us_pa_identidad_sexual + ", us_pa_procedencia=" + us_pa_procedencia + ", us_pa_registro="
				+ us_pa_registro + "]";
	}	
}
