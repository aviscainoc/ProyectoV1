package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Usuario us_id;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<FacturaDetalle> facs_det;

	public int getFac_cab_id() {
		return fac_cab_id;
	}

	public void setFac_cab_id(int fac_cab_id) {
		this.fac_cab_id = fac_cab_id;
	}

	public Usuario getUs_id() {
		return us_id;
	}

	public void setUs_id(Usuario us_id) {
		this.us_id = us_id;
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
}
