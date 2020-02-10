package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class ConteoCitas {

   
    private long idcuenta;
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
