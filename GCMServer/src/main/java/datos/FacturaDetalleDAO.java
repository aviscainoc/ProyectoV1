package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import modelo.FacturaDetalle;

@Stateless
public class FacturaDetalleDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(FacturaDetalle fd) {
		em.persist(fd);
	}
	
	public void update(FacturaDetalle fd) {
		em.merge(fd);
	}
	
	public FacturaDetalle read(int codigo) {
		FacturaDetalle fd = em.find(FacturaDetalle.class, codigo);
		return fd;
	}
	
	public List<FacturaDetalle> getFacturasDet(){
		String jpql = "SELECT u FROM FacturaDetalle u";
		Query q = em.createQuery(jpql, FacturaDetalle.class);
		List<FacturaDetalle> facturasDet = q.getResultList();
		return facturasDet;
	}
	
}
