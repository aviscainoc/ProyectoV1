package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import modelo.ExamenLaboratorio;
import modelo.FacturaCabecera;

@Stateless
public class FacturaCabeceraDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(FacturaCabecera fc) {
		em.persist(fc);
	}
	
	public void update(FacturaCabecera fc) {
		em.merge(fc);
	}
	
	public FacturaCabecera read(int codigo) {
		FacturaCabecera fc = em.find(FacturaCabecera.class, codigo);
		return fc;
	}
	
	public List<FacturaCabecera> getFacturasCab(){
		String jpql = "SELECT u FROM FacturaCabecera u";
		Query q = em.createQuery(jpql, FacturaCabecera.class);
		List<FacturaCabecera> facturas = q.getResultList();
		return facturas;
	}
	
	public FacturaCabecera getFacturaCab(int codigo){
		String jpql = "SELECT u FROM FacturaCabecera u WHERE fac_cab_id = ?1";
		Query q = em.createQuery(jpql, FacturaCabecera.class);
		q.setParameter(1, codigo);
		FacturaCabecera factura = (FacturaCabecera) q.getSingleResult();
		return factura;
	}
	
	public String obtenerTextoPdf(int codigoCA) {
		// TODO Auto-generated method stub
		String jpql = "SELECT u FROM FacturaCabecera u WHERE u.fac_cab_id = ?1";
		Query q = em.createQuery(jpql, FacturaCabecera.class);
		q.setParameter(1, codigoCA);
		
		String texto = (String) q.getSingleResult().toString();
		System.out.println(texto+"Texto en DAO");
		return texto;
	}
	
}
