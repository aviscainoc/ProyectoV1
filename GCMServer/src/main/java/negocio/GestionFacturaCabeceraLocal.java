package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.FacturaCabecera;
import modelo.FacturaDetalle;

@Local
public interface GestionFacturaCabeceraLocal {
	public int guardarFacturaCabecera(String fac_cab_nombre, String fac_cab_direccion, String fac_cab_telefono, String fac_cab_cedula, String fac_cab_correo);
	public int guardarFacturaCabeceraConsumidorFinal();
	public List<FacturaCabecera> getFacturas();	
	public FacturaCabecera getFacturaCabecera(int codigo);
	public FacturaCabecera getFactura(int codigo);
	public int obtenerCodigoFactura(int codigo); 
	public String obtenerTexto(int codigoCA);
}
