package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medico extends Usuario{

	@Id
	private String md_id;
	private String md_fecha_inicio;
	private String md_area_especializacion;
	
	public String getMd_id() {
		return md_id;
	}
	public void setMd_id(String md_id) {
		this.md_id = md_id;
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
		return "Medico [md_id=" + md_id + ", md_fecha_inicio=" + md_fecha_inicio + ", md_area_especializacion="
				+ md_area_especializacion + "]";
	}
	
	
}
