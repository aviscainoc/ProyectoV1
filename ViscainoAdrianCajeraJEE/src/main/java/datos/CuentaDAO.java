package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cuenta;


@Stateless
public class CuentaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Cuenta cuenta) {
		em.persist(cuenta);
	}

	public void update(Cuenta cuenta) {
		em.merge(cuenta);
	}


	public Cuenta read(String numCuenta) {
		return em.find(Cuenta.class, numCuenta);
	}


	
	
		
		
		
	

}













