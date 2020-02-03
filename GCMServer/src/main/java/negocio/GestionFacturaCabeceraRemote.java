package negocio;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import modelo.FacturaCabecera;
import modelo.Usuario;

@Remote
public interface GestionFacturaCabeceraRemote {
	public void guardarFacturaCabecera(String us_id, List<Integer> facs_detalle);
	public List<FacturaCabecera> getFactura();	
}
