package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Paciente;

@Stateless
public class PacienteDAO {
	
	
	@Inject
	private EntityManager em;
	
	public void insert(Paciente usuario) {
		em.persist(usuario);
	}
	
	public void update(Paciente usuario) {
		em.merge(usuario);
	}
	
	public void remove(int codigo) {
		Paciente usuario = this.read(codigo);
		em.remove(usuario);
	}
	
	public Paciente read(int codigo) {
		Paciente u = em.find(Paciente.class, codigo);
		return u;
	}
	
	public List<Paciente> getUsuarios(){
		String jpql = "SELECT u FROM Usuario u";
		Query q = em.createQuery(jpql, Paciente.class);
		
		List<Paciente> usuarios = q.getResultList();
		
		return usuarios;
	}
	
	public Paciente login(String usuario, String contrasena) {
		String jpql = "SELECT u FROM Usuario u WHERE us_usuario = ?1 AND us_password = ?2";
		Query q = em.createQuery(jpql, Paciente.class);
		q.setParameter(1, "%" + usuario + "%");
		q.setParameter(2, "%" + contrasena + "%");
		
		List<Paciente> user = q.getResultList();
		Paciente us = user.get(0);
		return us;
	}
	
}
