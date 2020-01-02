package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.ExamenLaboratorioDAO;
import modelo.Cita;
import modelo.ExamenLaboratorio;



@Stateless
public class GestionExamenLaboratorio implements GestionExamenLaboratorioRemote, GestionExamenLaboratorioLocal {

	@Inject
	private ExamenLaboratorioDAO dao;
	
	
	public void guardarExamenLaboratorio(int el_codigo,  String el_sangre, String el_plaquetas, String el_grupo_sanguineo, Cita ci_codigo) {
		ExamenLaboratorio u = new ExamenLaboratorio();
		u.setEl_codigo(el_codigo);
		u.setEl_sangre(el_sangre);
		u.setEl_plaquetas(el_plaquetas);
		u.setEl_grupo_sanguineo(el_grupo_sanguineo);
		u.setCi_codigo(ci_codigo);
		dao.insert(u);
	}
	
	public List<ExamenLaboratorio> getExamenLaboratorios(){
		return dao.getCitas();
	}
	
	public void update(int el_codigo,  String el_sangre, String el_plaquetas, String el_grupo_sanguineo, Cita ci_codigo) {
		ExamenLaboratorio u = new ExamenLaboratorio();
		u.setEl_codigo(el_codigo);
		u.setEl_sangre(el_sangre);
		u.setEl_plaquetas(el_plaquetas);
		u.setEl_grupo_sanguineo(el_grupo_sanguineo);
		u.setCi_codigo(ci_codigo);
		dao.update(u);
	}
	

	public void eliminar(int el_codigo) {
		dao.remove(el_codigo);
	}
}
