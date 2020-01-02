package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.Estado;

@Local
public interface GestionEstadoLocal {
	public void guardarEstado(int es_codigo,  String es_tipo);
	public List<Estado> getEstados();
	public void update(int es_codigo,  String es_tipo);
	public void eliminar(int codigo);
	
	
}
