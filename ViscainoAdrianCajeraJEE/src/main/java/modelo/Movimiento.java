package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;



@TableGenerator(
		name = "Movimiento", 
		initialValue = 1, 
		pkColumnName = "ENTITY", 
		pkColumnValue = "mov_id", 
		allocationSize = 1, 
		table = "ENTITY_GENERATOR"
			)
@Entity
public class Movimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mov_id;
	
	@OneToOne
	private Cuenta cuentaOrigen;
	
	private int numFactura;
	
	private int claveAccs;
	
	private int valorRec;
	
	
	 

	public int getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(int numFactura) {
		this.numFactura = numFactura;
	}

	public int getClaveAccs() {
		return claveAccs;
	}

	public void setClaveAccs(int claveAccs) {
		this.claveAccs = claveAccs;
	}

	public int getValorRec() {
		return valorRec;
	}

	public void setValorRec(int valorRec) {
		this.valorRec = valorRec;
	}

	public int getMov_id() {
		return mov_id;
	}

	public void setMov_id(int mov_id) {
		this.mov_id = mov_id;
	}

	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	@Override
	public String toString() {
		return "Movimiento [mov_id=" + mov_id + ", cuentaOrigen=" + cuentaOrigen + ", numFactura=" + numFactura
				+ ", claveAccs=" + claveAccs + ", valorRec=" + valorRec + "]";
	}
	
	
}




