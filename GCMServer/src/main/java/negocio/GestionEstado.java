package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.EstadoDAO;
import modelo.Estado;


@Stateless
public class GestionEstado implements GestionEstadoRemote, GestionEstadoLocal {

	@Inject
	private EstadoDAO dao;
	
	
	public void guardarEstado(int es_codigo,  String es_tipo) {
		Estado e = new Estado();
		e.setEs_codigo(es_codigo);
		e.setEs_tipo(es_tipo);
		
		dao.insert(e);
	}
	
	public List<Estado> getEstados(){
		return dao.getEstado();
	}
	
	public void update(int es_codigo, String es_tipo) {
		Estado e = new Estado();
		e.setEs_codigo(es_codigo);
		e.setEs_tipo(es_tipo);
		
		dao.update(e);
	}
	

	public void eliminar(int es_codigo) {
		dao.remove(es_codigo);
	}
}

