package modelo;

import javax.persistence.*;

@Entity
@TableGenerator(
		name = "HistoriaClinica", 
		initialValue = 1, 
		pkColumnName = "ENTITY", 
		pkColumnValue = "hc_codigo", 
		allocationSize = 1, 
		table = "ENTITY_GENERATOR"
			)
public class HistoriaClinica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hc_codigo;
	private String hc_residencia;
	private String hc_fecha;
	private String hc_movito_consulta;
	private String hc_enfermedad_actual;
	
	
	public int getHc_codigo() {
		return hc_codigo;
	}
	public void setHc_codigo(int hc_codigo) {
		this.hc_codigo = hc_codigo;
	}
	public String getHc_residencia() {
		return hc_residencia;
	}
	public void setHc_residencia(String hc_residencia) {
		this.hc_residencia = hc_residencia;
	}
	public String getHc_fecha() {
		return hc_fecha;
	}
	public void setHc_fecha(String hc_fecha) {
		this.hc_fecha = hc_fecha;
	}
	public String getHc_movito_consulta() {
		return hc_movito_consulta;
	}
	public void setHc_movito_consulta(String hc_movito_consulta) {
		this.hc_movito_consulta = hc_movito_consulta;
	}
	public String getHc_enfermedad_actual() {
		return hc_enfermedad_actual;
	}
	public void setHc_enfermedad_actual(String hc_enfermedad_actual) {
		this.hc_enfermedad_actual = hc_enfermedad_actual;
	}
	
	
	@Override
	public String toString() {
		return "HistoriaClinica [hc_codigo=" + hc_codigo + ", hc_residencia=" + hc_residencia + ", hc_fecha=" + hc_fecha
				+ ", hc_movito_consulta=" + hc_movito_consulta + ", hc_enfermedad_actual=" + hc_enfermedad_actual + "]";
	}	
}
