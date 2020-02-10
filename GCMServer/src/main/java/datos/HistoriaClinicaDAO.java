package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cita;
import modelo.HistoriaClinica;

@Stateless
public class HistoriaClinicaDAO {

	@Inject
	private EntityManager em;
	
	public void insert(HistoriaClinica hc) {
		em.persist(hc);
	}
	
	
	public void update(HistoriaClinica hc) {
		em.merge(hc);
	}
	
	public void remove(int codigo) {
		HistoriaClinica hc = this.read(codigo);
		em.remove(hc);
	}
	
	public HistoriaClinica read(int codigo) {
		HistoriaClinica u = em.find(HistoriaClinica.class, codigo);
		return u;
	}
	
	public List<HistoriaClinica> getHistoriasClinicas(){
		String jpql = "SELECT u FROM HistoriaClinica u";
		Query q = em.createQuery(jpql, HistoriaClinica.class);
		
		List<HistoriaClinica> hc = q.getResultList();
		
		return hc;
	}
	
	
}
