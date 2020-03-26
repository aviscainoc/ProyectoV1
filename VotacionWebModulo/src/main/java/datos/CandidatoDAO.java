package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Candidato;

@Stateless
public class CandidatoDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Candidato candidato) {
		em.persist(candidato);
	}
	
	public void update(Candidato candidato) {
		em.merge(candidato);
	}
	
	public void remove(String codigo) {
		Candidato candidato = this.read(codigo);
		em.remove(candidato);
	}
	
	public Candidato read(String codigo) {
		codigo = codigo.trim();
		Candidato u = em.find(Candidato.class, codigo);
		return u;
	}
	
	public List<Candidato> getCandidatos(){
		String rol = "pac";
		String jpql = "SELECT u FROM Candidato u";
		Query q = em.createQuery(jpql, Candidato.class);
		
		
		List<Candidato> candidatos = q.getResultList();
		
		return candidatos;
	}
	
	
	/*public Candidato login(String correo, String contrasena) throws Exception {
		String jpql = "SELECT u FROM Usuario u WHERE us_correo = ?1 AND us_contrasena = ?2";
		Query q = em.createQuery(jpql, Candidato.class);
		q.setParameter(1, correo );
		q.setParameter(2, contrasena );
		
		Candidato us = (Candidato) q.getSingleResult();
		
		if(us==null)
			throw new Exception("Usuario no existe");
		/*
		us.getHistorias_clinica().size();
		us.getCitas().size();*/
		/*return us;
	}	*/
	
	
	
	
}







