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
	public boolean guardarFacturaDetalle(String fac_det_descripcion, double fac_det_precio, int fac_det_cantidad, int fac_cab_id) {
		FacturaDetalle fd = new FacturaDetalle();
		FacturaCabecera fc = daoFc.read(fac_cab_id);
		if(fc != null) {
			double precio = Math.round(fc.getFac_cab_precio() * 100) / 100d;
			precio = precio + (fac_det_precio * fac_det_cantidad);
			fd.setFac_det_descripcion(fac_det_descripcion);
			fd.setFac_det_precio(fac_det_precio);
			fd.setFac_det_cantidad(fac_det_cantidad);
			fd.setFac_cabecera(fc);
			fc.setFac_cab_precio(precio);
			fc.setFac_cab_iva(Math.round((precio * 1.12) * 100) / 100d);
			fc.addDetalle(fd);
			daoFd.insert(fd);
			daoFc.update(fc);
			System.out.println("Cabecera encontrada 1, " + fc.getFac_cab_nombre()); 
			return true;
		}else{
			FacturaCabecera fc1 = new FacturaCabecera();
			double precio = Math.round(fc1.getFac_cab_precio() * 100) / 100d;
			precio = precio + (fac_det_precio * fac_det_cantidad);
			fc1.setFac_cab_cedula("9999999999");
			fc1.setFac_cab_nombre("Consumidor Final");
			fd.setFac_det_descripcion(fac_det_descripcion);
			fd.setFac_det_precio(fac_det_precio);
			fd.setFac_det_cantidad(fac_det_cantidad);
			fd.setFac_cabecera(fc1);
			fc1.setFac_cab_precio(precio);
			fc1.setFac_cab_iva(Math.round((precio * 1.12) * 100) / 100d);
			fc1.addDetalle(fd);
			daoFd.insert(fd);
			daoFc.update(fc);
			System.out.println("Cabecera encontrada, " + fc1.getFac_cab_nombre()); 
			return true;
		}
	}

	@Override
	public List<FacturaDetalle> getFacturaDetalle() {
		return daoFd.getFacturasDet();
	}

	@Override
	public List<FacturaDetalle> getFacturaDetalleCabecera(int cod_cabecera) {
		return daoFd.getFacturasDetCabecera(cod_cabecera);
	}
	
	

	
}
