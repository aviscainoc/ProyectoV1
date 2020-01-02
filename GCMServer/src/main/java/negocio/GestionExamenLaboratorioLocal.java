package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.Cita;
import modelo.ExamenLaboratorio;



@Local
public interface GestionExamenLaboratorioLocal {
	public void guardarExamenLaboratorio(int el_codigo,  String el_sangre, String el_plaquetas, String el_grupo_sanguineo, Cita ci_codigo);
	public List<ExamenLaboratorio> getExamenLaboratorios();
	public void update(int el_codigo,  String el_sangre, String el_plaquetas, String el_grupo_sanguineo, Cita ci_codigo);
	public void eliminar(int codigo);
	
	
}
