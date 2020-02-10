package modelo;

public class ConteoCitas {
	
	private int contador=0;
	private int mes;
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	@Override
	public String toString() {
		return "ConteoCitas [contador=" + contador + "]";
	}
	
	
	

}
