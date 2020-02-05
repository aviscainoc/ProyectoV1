package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cita;
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
	
	public void remove(String codigo) {
		Usuario usuario = this.read(codigo);
		em.remove(usuario);
	}
	
	public Usuario read(String codigo) {
		codigo = codigo.trim();
		Usuario u = em.find(Usuario.class, codigo);
		return u;
	}
	
	public List<Usuario> getUsuarios(){
		String rol = "pac";
		String jpql = "SELECT u FROM Usuario u WHERE us_rol = ?1";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter(1, rol);
		
		List<Usuario> usuarios = q.getResultList();
		
		return usuarios;
	}
	
	
	public Usuario login(String correo, String contrasena) throws Exception {
		String jpql = "SELECT u FROM Usuario u WHERE us_correo = ?1 AND us_contrasena = ?2";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter(1, correo );
		q.setParameter(2, contrasena );
		
		Usuario us = (Usuario) q.getSingleResult();
		
		if(us==null)
			throw new Exception("Usuario no existe");
		/*
		us.getHistorias_clinica().size();
		us.getCitas().size();*/
		return us;
	}	
	
	
}







