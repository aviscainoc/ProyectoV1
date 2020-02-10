package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import modelo.IngresosEgresos;

@Stateless
public class IngresoEgresoDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(IngresosEgresos ie) {
		em.persist(ie);
	}
	
	public void update(IngresosEgresos ie) {
		em.merge(ie);
	}
	
	public IngresosEgresos read(int codigo) {
		IngresosEgresos ie = em.find(IngresosEgresos.class, codigo);
		return ie;
	}
	
	public List<IngresosEgresos> getIngresosEgresos(){
		String jpql = "SELECT u FROM IngresosEgresos u";
		Query q = em.createQuery(jpql, IngresosEgresos.class);
		List<IngresosEgresos> facturasDet = q.getResultList();
		return facturasDet;
	}
	
}
