package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(
	name = "FacturaDetalle", 
	initialValue = 1, 
	pkColumnName = "ENTITY", 
	pkColumnValue = "fac_det_id", 
	allocationSize = 1, 
	table = "ENTITY_GENERATOR"
)
public class FacturaDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fac_det_id;
	
	@ManyToOne
	private FacturaCabecera fac_cabecera;
	
	private String fac_det_descripcion;
	private double fac_det_precio;
	private int fac_det_cantidad;
	
	public int getFac_det_id() {
		return fac_det_id;
	}
	public void setFac_det_id(int fac_det_id) {
		this.fac_det_id = fac_det_id;
	}
	public FacturaCabecera getFac_cabecera() {
		return fac_cabecera;
	}
	public void setFac_cabecera(FacturaCabecera fac_cabecera) {
		this.fac_cabecera = fac_cabecera;
	}
	public String getFac_det_descripcion() {
		return fac_det_descripcion;
	}
	public void setFac_det_descripcion(String fac_det_descripcion) {
		this.fac_det_descripcion = fac_det_descripcion;
	}
	public double getFac_det_precio() {
		return fac_det_precio;
	}
	public void setFac_det_precio(double fac_det_precio) {
		this.fac_det_precio = fac_det_precio;
	}
	public int getFac_det_cantidad() {
		return fac_det_cantidad;
	}
	public void setFac_det_cantidad(int fac_det_cantidad) {
		this.fac_det_cantidad = fac_det_cantidad;
	}
	@Override
	public String toString() {
		return "FacturaDetalle [fac_det_id=" + fac_det_id + ", fac_cabecera=" + fac_cabecera.getFac_cab_id() + ", fac_det_descripcion="
				+ fac_det_descripcion + ", fac_det_precio=" + fac_det_precio + ", fac_det_cantidad=" + fac_det_cantidad
				+ "]";
	}
}
