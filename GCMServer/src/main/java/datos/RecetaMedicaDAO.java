package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cita;
import modelo.RecetaMedica;

@Stateless
public class RecetaMedicaDAO {


	@Inject
	private EntityManager em;
	
	public void insert(RecetaMedica receta) {
		em.persist(receta);
	}
	
	public void update(RecetaMedica receta) {
		em.merge(receta);
	}
	
	public void remove(int codigo) {
		RecetaMedica receta = this.read(codigo);
		em.remove(receta);
	}
	
	public RecetaMedica read(int codigo) {
		RecetaMedica u = em.find(RecetaMedica.class, codigo);
		return u;
	}
	
	public List<RecetaMedica> getRecetasMedicas(){
		String jpql = "SELECT u FROM RecetaMedica u";
		Query q = em.createQuery(jpql, RecetaMedica.class);
		
		List<RecetaMedica> receta = q.getResultList();
		
		return receta;
	}
	
	public String obtenerTextoRM(int codigoCA) {
		// TODO Auto-generated method stub
		String jpql = "SELECT u FROM RecetaMedica u WHERE u.rm_codigo = ?1";
		Query q = em.createQuery(jpql, RecetaMedica.class);
		q.setParameter(1, codigoCA);
		
		String texto = (String) q.getSingleResult().toString();
		System.out.println(texto+"Texto en DAO");
		return texto;
	}
	
	
}
