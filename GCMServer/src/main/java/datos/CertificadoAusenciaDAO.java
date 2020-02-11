package datos;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.CertificadoAusencia;
import modelo.Cita;


@Stateless
public class CertificadoAusenciaDAO {


	@Inject
	private EntityManager em;
	
	public void insert(CertificadoAusencia certificadoAusencia) {
		em.persist(certificadoAusencia);
	}
	
	public void update(CertificadoAusencia certificadoAusencia) {
		em.merge(certificadoAusencia);
	}
	
	public void remove(int codigo) {
		CertificadoAusencia certificadoAusencia = this.read(codigo);
		em.remove(certificadoAusencia);
	}
	
	public CertificadoAusencia read(int codigo) {
		CertificadoAusencia u = em.find(CertificadoAusencia.class, codigo);
		return u;
	}
	
	public List<CertificadoAusencia> getCertificados(){
		String jpql = "SELECT u FROM CertificadoAusencia u";
		Query q = em.createQuery(jpql, CertificadoAusencia.class);
		
		List<CertificadoAusencia> certificadoAusencia = q.getResultList();
		
		return certificadoAusencia;
	}

	public String obtenerTextoCA(int codigoCA) {
		// TODO Auto-generated method stub
		String jpql = "SELECT u.ca_descripcion FROM CertificadoAusencia u WHERE u.ca_codigo = ?1";
		Query q = em.createQuery(jpql, String.class);
		q.setParameter(1, codigoCA);
		
		String texto = (String) q.getSingleResult().toString();
		System.out.println(texto+"Texto en DAO");
		return texto;
	}
	
	
	
}
