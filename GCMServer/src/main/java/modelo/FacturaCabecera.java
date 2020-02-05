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
	
	@ManyToOne
	private Usuario us_usuario;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name="fac_cab_id")
	private List<FacturaDetalle> facs_det;
	
	private double fac_cab_precio;
	private double fac_cab_iva;

	public int getFac_cab_id() {
		return fac_cab_id;
	}

	public void setFac_cab_id(int fac_cab_id) {
		this.fac_cab_id = fac_cab_id;
	}

	public Usuario getUs_usuario() {
		return us_usuario;
	}

	public void setUs_usuario(Usuario us_usuario) {
		this.us_usuario = us_usuario;
	}
	public List<FacturaDetalle> getFacs_det() {
		return facs_det;
	}

	public void setFacs_det(List<FacturaDetalle> facs_det) {
		this.facs_det = facs_det;
	}

	public void addFacturasDetalle(FacturaDetalle fd) {
		if (facs_det == null)
			facs_det = new ArrayList<FacturaDetalle>();
		this.facs_det.add(fd);
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

	@Override
	public String toString() {
		return "FacturaCabecera [fac_cab_id=" + fac_cab_id + ", us_usuario=" + us_usuario + ", facs_det=" + facs_det
				+ ", fac_cab_precio=" + fac_cab_precio + ", fac_cab_iva=" + fac_cab_iva + "]";
	}
}
