package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Estado;



@Stateless
public class EstadoDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Estado estado) {
		em.persist(estado);
	}
	
	public void update(Estado estado) {
		em.merge(estado);
	}
	
	public void remove(int codigo) {
		Estado estado = this.read(codigo);
		em.remove(estado);
	}
	
	public Estado read(int codigo) {
		Estado u = em.find(Estado.class, codigo);
		return u;
	}
	
	public List<Estado> getEstado(){
		String jpql = "SELECT u FROM Estado u";
		Query q = em.createQuery(jpql, Estado.class);
		
		List<Estado> estados = q.getResultList();
		
		return estados;
	}
	
	
}
