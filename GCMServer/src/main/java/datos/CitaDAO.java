package datos;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cita;
import modelo.ConteoCitas;

@Stateless
public class CitaDAO {
	

	@Inject
	private EntityManager em;
	
	public void insert(Cita cita) {
		em.persist(cita);
	}
	
	public void update(Cita cita) {
		em.merge(cita);
	}
	
	public void remove(int codigo) {
		Cita cita = this.read(codigo);
		em.remove(cita);
	}
	
	public Cita read(int codigo) {
		Cita u = em.find(Cita.class, codigo);
		return u;
	}
	
	public List<Cita> getCitas(){
		String jpql = "SELECT u FROM Cita u";
		Query q = em.createQuery(jpql, Cita.class);
		
		List<Cita> citas = q.getResultList();
		
		return citas;
	}
	
	public List<Cita> getCitasPendientes(){
		String jpql = "SELECT u FROM Cita u WHERE ci_estado = ?1";
		Query q = em.createQuery(jpql, Cita.class);
		q.setParameter(1, "pendiente");
		
		List<Cita> citas = q.getResultList();
		
		return citas;
	}
	
	public List<Cita> getCitasTerminadas(){
		String jpql = "SELECT u FROM Cita u WHERE ci_estado = ?1";
		Query q = em.createQuery(jpql, Cita.class);
		q.setParameter(1, "terminada");
		
		List<Cita> citas = q.getResultList();
		
		return citas;
	}
	
	public List<ConteoCitas> contarCitasPorMesUsuario(String cedula) {
		
		Query q = em.createNativeQuery("select count(*) AS contador FROM Cita WHERE cita.usuario_us_cedula like ?1 GROUP BY MONTH(ci_fecha_cita) ORDER BY YEAR(ci_fecha_cita), MONTH(ci_fecha_cita) ASC");
		q.setParameter(1, cedula);
		List<ConteoCitas> conteos =  q.getResultList();
	
		return conteos	;				
	}
	
	public List<ConteoCitas> contarCitasPorMesGeneral() {
		
		Query q = em.createNativeQuery("select count(*) AS contador FROM Cita GROUP BY MONTH(ci_fecha_cita) ORDER BY YEAR(ci_fecha_cita), MONTH(ci_fecha_cita) ASC");
		
		List<ConteoCitas> conteos =  q.getResultList();
	
		return conteos	;				
	}
	
	
	public List<Cita> getProximasCitas(Date fecha){
		String jpql = "SELECT u FROM Cita u WHERE ci_fecha_cita => ?1";
		Query q = em.createQuery(jpql, Cita.class);
		q.setParameter(1, fecha);
		
		List<Cita> citas = q.getResultList();
		
		return citas;
	}
}
