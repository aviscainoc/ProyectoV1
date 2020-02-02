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
public class GestionFacturaDetalle implements GestionFacturaDetalleLocal{

	@Inject
	private FacturaCabeceraDAO daoFc;
	
	@Inject
	private FacturaDetalleDAO daoFd;
	
	@Inject
	private UsuarioDAO daoU;

	@Override
	public void guardarFacturaDetalle(String fac_det_descripcion, double fac_det_precio, int fac_det_cantidad, int fac_cab_id) {
		FacturaDetalle fd = new FacturaDetalle();
		FacturaCabecera fc = daoFc.read(fac_cab_id);
		if(fc != null) {	
			fd.setFac_det_descripcion(fac_det_descripcion);
			fd.setFac_det_precio(fac_det_precio);
			fd.setFac_det_cantidad(fac_det_cantidad);
			fd.setFac_cab_id(fc);
			fc.addFacturasDetalle(fd);
			daoFd.insert(fd);
			System.out.println("Cabecera encontrada, " + fc); 
		}else {
			FacturaCabecera fc1 = new FacturaCabecera();
			Usuario u = new Usuario();
			u.setUs_cedula("9999999999");
			u.setUs_nombres("Consumidor Final");
			fc1.setUs_id(u);
			fd.setFac_det_descripcion(fac_det_descripcion);
			fd.setFac_det_precio(fac_det_precio);
			fd.setFac_det_cantidad(fac_det_cantidad);
			fd.setFac_cab_id(fc);
			fc1.addFacturasDetalle(fd);
			daoFd.insert(fd);
		}
	}

	@Override
	public List<FacturaDetalle> getFacturaDetalle() {
		return daoFd.getFacturasDet();
	}
	

	
}
