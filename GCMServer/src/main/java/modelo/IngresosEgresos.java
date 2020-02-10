package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(
	name = "IngresosEgresos", 
	initialValue = 1, 
	pkColumnName = "ENTITY", 
	pkColumnValue = "ie_codigo", 
	allocationSize = 1, 
	table = "ENTITY_GENERATOR"
)
public class IngresosEgresos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ie_codigo;
	private String ie_descripcion;
	private double ie_dinero;
	
	public int getIe_codigo() {
		return ie_codigo;
	}
	public void setIe_codigo(int ie_codigo) {
		this.ie_codigo = ie_codigo;
	}
	public String getIe_descripcion() {
		return ie_descripcion;
	}
	public void setIe_descripcion(String ie_descripcion) {
		this.ie_descripcion = ie_descripcion;
	}
	public double getIe_dinero() {
		return ie_dinero;
	}
	public void setIe_dinero(double ie_dinero) {
		this.ie_dinero = ie_dinero;
	}
	@Override
	public String toString() {
		return "IngresosEgresos [ie_codigo=" + ie_codigo + ", ie_descripcion=" + ie_descripcion + ", ie_dinero="
				+ ie_dinero + "]";
	}
}
