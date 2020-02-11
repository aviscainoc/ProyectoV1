package negocio;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;

import datos.CitaDAO;
import datos.FacturaCabeceraDAO;
import datos.FacturaDetalleDAO;
import datos.UsuarioDAO;
import modelo.FacturaCabecera;
import modelo.FacturaDetalle;
import modelo.Usuario;

@Stateful
public class GestionFacturaCabecera implements GestionFacturaCabeceraLocal{

	@Inject
	private FacturaCabeceraDAO daoFc;
	
	@Inject
	private FacturaDetalleDAO daoFd;
	
	@Inject
	private CitaDAO daoCi;
	
	@Inject
	private UsuarioDAO daoU;
	
	
	@Override
	public int guardarFacturaCabecera(String fac_cab_nombre, String fac_cab_direccion, String fac_cab_telefono, String fac_cab_cedula, String fac_cab_correo) {
		FacturaCabecera fc = new FacturaCabecera();
		
		fc.setFac_cab_cedula(fac_cab_cedula);
		fc.setFac_cab_nombre(fac_cab_nombre);
		fc.setFac_cab_direccion(fac_cab_direccion);
		fc.setFac_cab_telefono(fac_cab_telefono);
		fc.setFac_cab_precio(0.0);
		fc.setFac_cab_iva(0.0);
		daoFc.insert(fc);
		return fc.getFac_cab_id();
	}

	@Override
	public List<FacturaCabecera> getFacturas() {
		return daoFc.getFacturasCab();
	}

	@Override
	public FacturaCabecera getFactura(int codigo) {
		return daoFc.getFacturaCab(codigo);
	}

	@Override
	public int guardarFacturaCabeceraConsumidorFinal() {
		FacturaCabecera fc = new FacturaCabecera();
		fc.setFac_cab_cedula("9999999999");
		fc.setFac_cab_nombre("Consumidor Final");
		fc.setFac_cab_direccion("Null");
		fc.setFac_cab_telefono("Null");
		fc.setFac_cab_telefono("Null");
		fc.setFac_cab_precio(0.0);
		fc.setFac_cab_iva(0.0);
		daoFc.insert(fc);
		return fc.getFac_cab_id();
	}

	@Override
	public FacturaCabecera getFacturaCabecera(int codigo) {
		return daoFc.read(codigo);
	}
	
	public int obtenerCodigoFactura(int codigo) {
		System.out.println(daoCi.obtenerCodigoFactura(codigo));
		return daoCi.obtenerCodigoFactura(codigo);
	}
	
	public String obtenerTexto(int codigoCA) {
		String texto = daoFc.obtenerTextoPdf(codigoCA);
		return texto;
	}

	
}
