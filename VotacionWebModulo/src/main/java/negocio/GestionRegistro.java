package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import datos.RegistroDAO;
import datos.CandidatoDAO;
import modelo.Registro;
import modelo.Candidato;




@Stateless
public class GestionRegistro implements  GestionRegistroLocal {

	@Inject
	private RegistroDAO dao;
	@Inject
	private CandidatoDAO daoC;
	
	
	
	public void guardarRegistro(String titulo, String fecha) {
		Registro u = new Registro();
		u.setRe_titulo(titulo);
		u.setRe_fecha(fecha);
		dao.insert(u);
		System.out.println(u);
	}
	
	public void agregarCandidato(int cod_re, String us_cedula, String us_nombres, int us_num_lista, String us_titulo_universitario) {
		Registro r = dao.read(cod_re);
		Candidato c = new Candidato();
		c.setUs_cedula(us_cedula);
		c.setUs_nombres(us_nombres);
		c.setUs_num_lista(us_num_lista);
		c.setUs_titulo_universitario(us_titulo_universitario);
		
		daoC.insert(c);
		r.addCandidato(c);
		dao.update(r);	
		
	}
	
	public List<Candidato> verResultados() {
		return daoC.getCandidatos();// .getRegistros(codigo);
	}
	/*
	
	
	public List<Registro> getCertificadoAusencias(){
		return dao.getCertificados();
	}
	
	public void update(int ca_codigo, String ca_descripcion) {
		Registro u = new Registro();
		u.setCa_codigo(ca_codigo);
		u.setCa_descripcion(ca_descripcion);
		dao.update(u);
	}
	

	public void eliminar(int ca_codigo) {
		dao.remove(ca_codigo);
	}
	
	public Registro getCertificado(int codigo) {
		return dao.read(codigo);
	}
	
	public int obtenerCodigoCertificado(int codigo) {
		System.out.println(daoC.obtenerCodigoCertificado(codigo));
		return daoC.obtenerCodigoCertificado(codigo);
	}
	
	public String obtenerTexto(int codigoCA) {
		String texto = dao.obtenerTextoCA(codigoCA);
		return texto;
	}*/

	

	
}
