package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Voto;

@Stateless
public class VotoDAO {
	
	@Inject
	private EntityManager em;
	
	
	public void insert(Voto voto) {
		em.persist(voto);
	}
	
	public void update(Voto voto) {
		em.merge(voto);
	}
	
	public void remove(int codigo) {
		Voto voto = this.read(codigo);
		em.remove(voto);
	}
	
	public Voto read(int codigo) {
		Voto u = em.find(Voto.class, codigo);
		return u;
	}
	
	public List<Voto> getVotos(){
		String jpql = "SELECT u FROM Voto u";
		Query q = em.createQuery(jpql, Voto.class);
		
		List<Voto> voto = q.getResultList();
		
		return voto;
	}

/*	public String obtenerTextoCA(int codigoCA) {
		// TODO Auto-generated method stub
		String jpql = "SELECT u.ca_descripcion FROM registro u WHERE u.ca_codigo = ?1";
		Query q = em.createQuery(jpql, String.class);
		q.setParameter(1, codigoCA);
		
		String texto = (String) q.getSingleResult().toString();
		System.out.println(texto+"Texto en DAO");
		return texto;
	}
	*/

}

