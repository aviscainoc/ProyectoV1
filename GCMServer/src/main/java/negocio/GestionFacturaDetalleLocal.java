package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.FacturaCabecera;
import modelo.FacturaDetalle;

@Local
public interface GestionFacturaDetalleLocal {
	public void guardarFacturaDetalle(String fac_det_descripcion, double fac_det_precio, int fac_det_cantidad, int fac_cab_id);
	public List<FacturaDetalle> getFacturaDetalle();	
}