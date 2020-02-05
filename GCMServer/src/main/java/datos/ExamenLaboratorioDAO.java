package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cita;
import modelo.ExamenLaboratorio;

@Stateless
public class ExamenLaboratorioDAO {


	@Inject
	private EntityManager em;
	
	public void insert(ExamenLaboratorio examen) {
		em.persist(examen);
	}
	
	public void update(ExamenLaboratorio examen) {
		em.merge(examen);
	}
	
	public void remove(int codigo) {
		ExamenLaboratorio examen = this.read(codigo);
		em.remove(examen);
	}
	
	public ExamenLaboratorio read(int codigo) {
		ExamenLaboratorio u = em.find(ExamenLaboratorio.class, codigo);
		return u;
	}
	
	public List<ExamenLaboratorio> getExamenes(){
		String jpql = "SELECT u FROM ExamenLaboratorio u";
		Query q = em.createQuery(jpql, ExamenLaboratorio.class);
		
		List<ExamenLaboratorio> examen = q.getResultList();
		
		return examen;
	}
	
}
