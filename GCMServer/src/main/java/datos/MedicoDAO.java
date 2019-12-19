package datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class MedicoDAO {
	
	@Inject
	private EntityManager dao;
	
}
