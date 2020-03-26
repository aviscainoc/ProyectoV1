package datos;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Registro;


@Stateless
public class RegistroDAO {


	@Inject
	private EntityManager em;
	
	public void insert(Registro registro) {
		em.persist(registro);
	}
	
	public void update(Registro registro) {
		em.merge(registro);
	}
	
	public void remove(int codigo) {
		Registro registro = this.read(codigo);
		em.remove(registro);
	}
	
	public Registro read(int codigo) {
		Registro u = em.find(Registro.class, codigo);
		return u;
	}
	
	public List<Registro> getRegistros(int codigo){
		String jpql = "SELECT u.candidatos FROM Registro u WHERE re_codigo = ?1";
		Query q = em.createQuery(jpql, Registro.class);
		q.setParameter(1, codigo);
		List<Registro> registro = q.getResultList();
		
		return registro;
	}
	
	public Registro obtenerCodigo(String titulo) {
		System.out.println("esto llega a DAO"+titulo);
		String jpql = "SELECT u FROM Registro u WHERE re_titulo LIKE ?1";
		Query q = em.createQuery(jpql, Registro.class);
		q.setParameter(1, titulo);
		Registro registro = (Registro) q.getSingleResult();
				
		return registro;
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
