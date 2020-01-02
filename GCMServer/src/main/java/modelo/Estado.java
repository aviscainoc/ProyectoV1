package modelo;

import javax.persistence.*;

@Entity
public class Estado {

	@Id
	private int es_codigo;
	
	private String es_tipo;

	
	public int getEs_codigo() {
		return es_codigo;
	}
	public void setEs_codigo(int es_codigo) {
		this.es_codigo = es_codigo;
	}
	
	public String getEs_tipo() {
		return es_tipo;
	}
	public void setEs_tipo(String es_tipo) {
		this.es_tipo = es_tipo;
	}
	
	@Override
	public String toString() {
		return "Estado [es_codigo=" + es_codigo  + ", es_tipo=" + es_tipo + "]";
	}
	
	
}
