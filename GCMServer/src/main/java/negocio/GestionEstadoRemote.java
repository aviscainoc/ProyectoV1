package negocio;

import java.util.List;
import javax.ejb.Remote;
import modelo.Estado;

@Remote
public interface GestionEstadoRemote {
	public void guardarEstado(int es_codigo,  String es_tipo);
	public List<Estado> getEstados();
	public void update(int es_codigo,  String es_tipo);
	public void eliminar(int codigo);
}
