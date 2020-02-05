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
	public boolean guardarFacturaCabecera(String us_id) {
		FacturaCabecera fc = new FacturaCabecera();
		Usuario u = daoU.read(us_id);
		if (u != null) {
			fc.setUs_usuario(u);
			fc.setFac_cab_precio(0.0);
			fc.setFac_cab_iva(0.0);
			daoFc.insert(fc);
			System.out.println("Usuario existente "+ u);
			return true;
		}else {
			Usuario u1 = new Usuario();
			u1.setUs_cedula("999999999");
			u1.setUs_nombres("Consumidor Final");
			daoU.insert(u1);
			fc.setFac_cab_precio(0.0);
			fc.setUs_usuario(u1);
			fc.setFac_cab_iva(0.0);
			daoFc.insert(fc);
			System.out.println("Consumidor final: " + u1);
			return true;
		}
	}

	@Override
	public List<FacturaCabecera> getFacturas() {
		return daoFc.getFacturasCab();
	}

	
}
