package negocio;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;

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
	private UsuarioDAO daoU;
	
	
	@Override
	public void guardarFacturaCabecera(String us_id) {
		FacturaCabecera fc = new FacturaCabecera();
		Usuario u = daoU.read(us_id);
		fc.setUs_id(u);	
		daoFc.insert(fc);
	}

	@Override
	public List<FacturaCabecera> getFactura() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
