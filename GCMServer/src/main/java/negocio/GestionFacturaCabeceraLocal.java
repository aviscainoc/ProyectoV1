package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.FacturaCabecera;
import modelo.FacturaDetalle;

@Local
public interface GestionFacturaCabeceraLocal {
	public void guardarFacturaCabecera(String us_id);
	public List<FacturaCabecera> getFactura();	
}