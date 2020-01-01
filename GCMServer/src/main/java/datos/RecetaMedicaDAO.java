package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cita;
import modelo.RecetaMedica;

@Stateless
public class RecetaMedicaDAO {


	@Inject
	private EntityManager em;
	
	public void insert(RecetaMedica receta) {
		em.persist(receta);
	}
	
	public void update(RecetaMedica receta) {
		em.merge(receta);
	}
	
	public void remove(int codigo) {
		RecetaMedica receta = this.read(codigo);
		em.remove(receta);
	}
	
	public RecetaMedica read(int codigo) {
		RecetaMedica u = em.find(RecetaMedica.class, codigo);
		return u;
	}
	
	public List<RecetaMedica> getRecetasMedicas(){
		String jpql = "SELECT u FROM Paciente u";
		Query q = em.createQuery(jpql, RecetaMedica.class);
		
		List<RecetaMedica> receta = q.getResultList();
		
		return receta;
	}
	
	
}
