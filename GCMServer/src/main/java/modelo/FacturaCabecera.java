package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(
	name = "FacturaCabecera", 
	initialValue = 1, 
	pkColumnName = "ENTITY", 
	pkColumnValue = "fac_cab_id", 
	allocationSize = 1, 
	table = "ENTITY_GENERATOR"
)
public class FacturaCabecera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fac_cab_id;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name="fac_cab_id")
	private List<FacturaDetalle> facs_det;
	
	private double fac_cab_precio;
	private double fac_cab_iva;
	private String fac_cab_nombre;
	private String fac_cab_direccion;
	private String fac_cab_telefono;
	private String fac_cab_cedula;
	
	public int getFac_cab_id() {
		return fac_cab_id;
	}
	public void setFac_cab_id(int fac_cab_id) {
		this.fac_cab_id = fac_cab_id;
	}
	public List<FacturaDetalle> getFacs_det() {
		return facs_det;
	}
	public void setFacs_det(List<FacturaDetalle> facs_det) {
		this.facs_det = facs_det;
	}
	public double getFac_cab_precio() {
		return fac_cab_precio;
	}
	public void setFac_cab_precio(double fac_cab_precio) {
		this.fac_cab_precio = fac_cab_precio;
	}
	public double getFac_cab_iva() {
		return fac_cab_iva;
	}
	public void setFac_cab_iva(double fac_cab_iva) {
		this.fac_cab_iva = fac_cab_iva;
	}
	public String getFac_cab_nombre() {
		return fac_cab_nombre;
	}
	public void setFac_cab_nombre(String fac_cab_nombre) {
		this.fac_cab_nombre = fac_cab_nombre;
	}
	public String getFac_cab_direccion() {
		return fac_cab_direccion;
	}
	public void setFac_cab_direccion(String fac_cab_direccion) {
		this.fac_cab_direccion = fac_cab_direccion;
	}
	public String getFac_cab_telefono() {
		return fac_cab_telefono;
	}
	public void setFac_cab_telefono(String fac_cab_telefono) {
		this.fac_cab_telefono = fac_cab_telefono;
	}
	public String getFac_cab_cedula() {
		return fac_cab_cedula;
	}
	public void setFac_cab_cedula(String fac_cab_cedula) {
		this.fac_cab_cedula = fac_cab_cedula;
	}
	
	public void addDetalle(FacturaDetalle fd) {
		if(facs_det == null)
			facs_det = new ArrayList<FacturaDetalle>();
		facs_det.add(fd);
	}
	
	@Override
	public String toString() {
		return "Factura  \n\n\n"
				+ "Codigo de la factura = " + fac_cab_id + 
				"\nDescripciones = " + facs_det
				+"\nPrecio del producto = " + fac_cab_precio + 
				"\nIVA = " + fac_cab_iva + 
				"\nDATOS DEL CLIENTE\n\n"
				+ "Nombres = "+ fac_cab_nombre + "Direccion = " + fac_cab_direccion + 
				"\nTelefono = " + fac_cab_telefono
				+ ", Cedula=" + fac_cab_cedula + "]";
	}
}
