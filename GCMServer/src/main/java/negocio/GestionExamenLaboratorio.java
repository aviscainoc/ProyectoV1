package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CitaDAO;
import datos.ExamenLaboratorioDAO;
import modelo.Cita;
import modelo.ExamenLaboratorio;



@Stateless
public class GestionExamenLaboratorio implements GestionExamenLaboratorioRemote, GestionExamenLaboratorioLocal {

	@Inject
	private ExamenLaboratorioDAO dao;
	@Inject CitaDAO daoC;
	
	
	public int guardarExamenLaboratorio(String el_quimica, String el_heces, String el_microbiologia, String el_hematologia, String el_orina) {
		ExamenLaboratorio u = new ExamenLaboratorio();
		u.setEl_quimica(el_quimica);
		u.setEl_heces(el_heces);
		u.setEl_microbiologia(el_microbiologia);
		u.setEl_hematologia(el_hematologia);
		u.setEl_orina(el_orina);
		dao.insert(u);
		System.out.println(u);
		return u.getEl_codigo();
	}
	
	public List<ExamenLaboratorio> getExamenLaboratorios(){
		return dao.getExamenes();
	}
	
	public void update(int el_codigo, String el_quimica, String el_heces, String el_microbiologia, String el_hematologia, String el_orina) {
		ExamenLaboratorio u = new ExamenLaboratorio();
		u.setEl_codigo(el_codigo);
		u.setEl_quimica(el_quimica);
		u.setEl_heces(el_heces);
		u.setEl_microbiologia(el_microbiologia);
		u.setEl_hematologia(el_hematologia);
		u.setEl_orina(el_orina);
		dao.update(u);
	}
	
	public void eliminar(int el_codigo) {
		dao.remove(el_codigo);
	}
	
	public ExamenLaboratorio getExamen(int codigo) {
		return dao.read(codigo);
	}
	
	public int obtenerCodigoExamen(int codigo) {
		System.out.println(daoC.obtenerCodigoCertificado(codigo));
		return daoC.obtenerCodigoCertificado(codigo);
	}
	
	public String obtenerTextoEx(int codigoCA) {
		String texto = dao.obtenerTextoEX(codigoCA);
		return texto;
	}
}
