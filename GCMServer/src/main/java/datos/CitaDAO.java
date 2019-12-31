package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cita;
import modelo.Paciente;

@Stateless
public class CitaDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Cita cita) {
		em.persist(cita);
	}
	
	public void update(Cita cita) {
		em.merge(cita);
	}
	
	public void remove(int codigo) {
		Cita cita = this.read(codigo);
		em.remove(cita);
	}
	
	public Cita read(int codigo) {
		Cita u = em.find(Cita.class, codigo);
		return u;
	}
	
	public List<Cita> getCitas(){
		String jpql = "SELECT u FROM Cita u";
		Query q = em.createQuery(jpql, Cita.class);
		
		List<Cita> citas = q.getResultList();
		
		return citas;
	}
	
	
}
