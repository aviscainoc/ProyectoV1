package modelo;

import javax.persistence.*;

@Entity
@TableGenerator(
		name = "CertificadoAusencia", 
		initialValue = 1, 
		pkColumnName = "ENTITY", 
		pkColumnValue = "ca_codigo", 
		allocationSize = 1, 
		table = "ENTITY_GENERATOR"
)
public class CertificadoAusencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ca_codigo;
	private String ca_descripcion;
	
	public int getca_codigo() {
		return ca_codigo;
	}
	public void setCa_codigo(int ca_codigo) {
		this.ca_codigo = ca_codigo;
	}
	public String getCa_descripcion() {
		return ca_descripcion;
	}
	public void setCa_descripcion(String ca_descripcion) {
		this.ca_descripcion = ca_descripcion;
	}
	@Override
	public String toString() {
		return "CertificadoAusencia [ca_codigo=" + ca_codigo + ", ca_descripcion=" + ca_descripcion
				+ "]";
	}
	
	
}