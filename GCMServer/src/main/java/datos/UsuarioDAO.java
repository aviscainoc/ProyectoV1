package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Usuario;

@Stateless
public class UsuarioDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void update(Usuario usuario) {
		em.merge(usuario);
	}
	
	public void remove(int codigo) {
		Usuario usuario = this.read(codigo);
		em.remove(usuario);
	}
	
	public Usuario read(int codigo) {
		Usuario u = em.find(Usuario.class, codigo);
		return u;
	}
	
	public List<Usuario> getUsuarios(){
		String jpql = "SELECT u FROM Paciente u";
		Query q = em.createQuery(jpql, Usuario.class);
		
		List<Usuario> usuarios = q.getResultList();
		
		return usuarios;
	}
	
	
	public Usuario login(String usuario, String contrasena) {
		String jpql = "SELECT u FROM Usuario u WHERE us_usuario = ?1 AND us_password = ?2";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter(1, "%" + usuario + "%");
		q.setParameter(2, "%" + contrasena + "%");
		
		List<Usuario> user = q.getResultList();
		Usuario us = user.get(0);
		return us;
	}
	
	


	
	
}







