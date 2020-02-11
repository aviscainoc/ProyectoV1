package negocio;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;

import datos.FacturaCabeceraDAO;
import datos.FacturaDetalleDAO;
import datos.IngresoEgresoDAO;
import datos.UsuarioDAO;
import modelo.FacturaCabecera;
import modelo.FacturaDetalle;
import modelo.IngresosEgresos;
import modelo.Usuario;

@Stateful
public class GestionIngresosEgresos implements GestionIngresosEgresosLocal{
	
	@Inject
	private IngresoEgresoDAO daoIe;
	@Inject
	private UsuarioDAO daoU;
	
	@Override
	public int guardarIngresosEgresos(String ie_descripcion, double ie_dinero, String md_codigo) {
		IngresosEgresos ie = new IngresosEgresos();
		Usuario u = daoU.read(md_codigo);
		ie.setIe_descripcion(ie_descripcion);
		ie.setIe_dinero(ie_dinero);
		u.addIngresoEgreso(ie);
		daoIe.insert(ie);
		daoU.update(u);
		System.out.println(ie);
		return ie.getIe_codigo();
	}
	
	@Override
	public List<IngresosEgresos> getIngresosEgresos() {
		return daoIe.getIngresosEgresos();
	}

	@Override
	public IngresosEgresos getIngresoEgreso(int ie_codigo) {
		return daoIe.read(ie_codigo);
	}
}
