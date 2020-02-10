package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.IngresosEgresos;

@Local
public interface GestionIngresosEgresosLocal{
	public int guardarIngresosEgresos(String ie_descripcion, double ie_dinero, String md_codigo);
	public List<IngresosEgresos> getIngresosEgresos();
	public IngresosEgresos getIngresoEgreso(int ie_codigo);
}
