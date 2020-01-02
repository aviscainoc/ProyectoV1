package datos;

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
	
	public List<CertificadoAusencia> getCitas(){
		String jpql = "SELECT u FROM Paciente u";
		Query q = em.createQuery(jpql, CertificadoAusencia.class);
		
		List<CertificadoAusencia> certificadoAusencia = q.getResultList();
		
		return certificadoAusencia;
	}
	
}
