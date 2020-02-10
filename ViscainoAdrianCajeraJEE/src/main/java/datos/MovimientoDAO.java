package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cuenta;
import modelo.Movimiento;

@Stateless
public class MovimientoDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Movimiento movimiento) {
		em.persist(movimiento);
	}

	public void update(Movimiento movimiento) {
		em.merge(movimiento);
	}

	public void remove(String moviId) {
		em.remove(this.read(moviId));
	}

	public Movimiento read(String moviId) {
		return em.find(Movimiento.class, moviId);
	}


	public List<Movimiento> getMovimientos(){
		String jpql = "SELECT l FROM Movimiento l";
		Query q = em.createQuery(jpql, Movimiento.class);
		
		List<Movimiento> movimientos = q.getResultList();
		
		return movimientos;
	}
	
}



