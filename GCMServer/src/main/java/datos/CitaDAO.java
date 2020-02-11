package datos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.primefaces.json.JSONObject;

import modelo.Cita;
import modelo.IngresosEgresos;

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
		String jpql = "SELECT u FROM Cita u WHERE ci_estado = ?1 ORDER BY ci_fecha_cita";
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
	
	public String contarCitasPorMesUsuario(String cedula) {
		Query q = em.createNativeQuery("select count(*) AS contador FROM Cita u WHERE u.usuario_us_cedula like ?1 AND MONTH(ci_fecha_cita) = ?2");
		q.setParameter(1, cedula);
		q.setParameter(2, 1);
		int conteo = ((BigInteger) q.getSingleResult()).intValue();
		String count = Integer.toString(conteo);
		for (int i = 1; i < 12; i++) {
			q.setParameter(2, i+1);
			conteo =  ((BigInteger) q.getSingleResult()).intValue();
			System.out.println(conteo);
			count = count + "," + Integer.toString(conteo);
		}

		System.out.println(count);
		return count;				
	}
	
	public String contarCitasPorMesGeneral() {
		Query q = em.createNativeQuery("select count(*) AS contador FROM Cita u WHERE MONTH(ci_fecha_cita) = ?1");
		q.setParameter(1, 1);
		int conteo = ((BigInteger) q.getSingleResult()).intValue();
		String count = Integer.toString(conteo);
		for (int i = 1; i < 12; i++) {
			q.setParameter(1, i+1);
			conteo =  ((BigInteger) q.getSingleResult()).intValue();
			System.out.println(conteo);
			count = count + "," + Integer.toString(conteo);
		}

		System.out.println(count);
		return count;				
	}
	
	
	public List<Cita> getProximasCitas(String cedula, Date fecha){
		String jpql = "SELECT u FROM Cita u WHERE ci_fecha_cita > ?1 AND usuario_us_cedula = ?2 AND ci_estado = ?3 ORDER BY ci_fecha_cita";
		Query q = em.createQuery(jpql, Cita.class);
		q.setParameter(1, fecha);
		q.setParameter(2, cedula);
		q.setParameter(3, "pendiente");
		List<Cita> citas = q.getResultList();
		return citas;
	}
	public List<Cita> getCitasPasadas(Date fecha){
		String jpql = "SELECT u FROM Cita u WHERE ci_estado = ?1";
		Query q = em.createQuery(jpql, Cita.class);
		q.setParameter(1, "terminada");
		
		List<Cita> citas = q.getResultList();
		
		return citas;
	}
	//metodo codigo certificado
	public int obtenerCodigoCertificado(int codigo) {
		String jpql = "SELECT u.certificado.ca_codigo FROM Cita u WHERE u.ci_codigo = ?1";
		Query q = em.createQuery(jpql, Integer.class);
		q.setParameter(1, codigo);
			
		int codCertificado =  (int) q.getSingleResult();
		System.out.println(codCertificado+"esto habia");
		return codCertificado;
	}
	//metodo codigo receta
	public int obtenerCodigoReceta(int codigo) {
		String jpql = "SELECT u.receta.rm_codigo FROM Cita u WHERE u.ci_codigo = ?1";
		Query q = em.createQuery(jpql, Integer.class);
		q.setParameter(1, codigo);
			
		int codReceta =  (int) q.getSingleResult();
		System.out.println(codReceta+" :Codigo de receta");
		return codReceta;
	}
	
	//metodo codigo examenes
		public int obtenerCodigoExamen(int codigo) {
			String jpql = "SELECT u.examen.el_codigo FROM Cita u WHERE u.ci_codigo = ?1";
			Query q = em.createQuery(jpql, Integer.class);
			q.setParameter(1, codigo);
				
			int codEx =  (int) q.getSingleResult();
			System.out.println(codEx+" :Codigo de receta");
			return codEx;
		}
		
		//metodo codigo factura
		public int obtenerCodigoFactura(int codigo) {
			String jpql = "SELECT u.fac_cab_factura.fac_cab_id FROM Cita u WHERE u.ci_codigo = ?1";
			Query q = em.createQuery(jpql, Integer.class);
			q.setParameter(1, codigo);
				
			int codReceta =  (int) q.getSingleResult();
			System.out.println(codReceta+" :Codigo de receta");
			return codReceta;
		}
		
		public double getSaldo() {
			String jpql = "SELECT ie.ie_dinero FROM IngresosEgresos ie";
			Query q = em.createQuery(jpql, Double.class);
			List<Double> saldos = q.getResultList();
			double saldo = 0.0;
			for (double i: saldos)
				saldo = saldo + i;
			return saldo;
		}
}
