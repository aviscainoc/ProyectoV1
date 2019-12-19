package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Medico;
import modelo.Paciente;

@Stateless
public class MedicoDAO {
	
	@Inject
	private EntityManager em;
	

	public void insert(Medico medico) {
		em.persist(medico);
	}
	
	public void update(Medico medico) {
		em.merge(medico);
	}
	
	
	public void remove(int codigo) {
		Medico medico = this.read(codigo);
		em.remove(medico);
	}
	
	public Medico read(int codigo) {
		Medico m = em.find(Medico.class, codigo);
		return m;
	}
	
	public List<Medico> getMedicos(){
		String jpql = "SELECT u FROM Medico u";
		Query q = em.createQuery(jpql, Medico.class);
		
		List<Medico> medicos = q.getResultList();
		
		return medicos;
	}
	
	/*public Medico login(String usuario, String contrasena) {
		String jpql = "SELECT u FROM Medico u WHERE us_usuario = ?1 AND us_password = ?2";
		Query q = em.createQuery(jpql, Medico.class);
		q.setParameter(1, "%" + usuario + "%");
		q.setParameter(2, "%" + contrasena + "%");
		
		List<Medico> med = q.getResultList();
		Medico md = med.get(0);
		return md;
	}*/
}
