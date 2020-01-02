package negocio;

import java.util.List;
import javax.ejb.Remote;

import modelo.Cita;
import modelo.ExamenLaboratorio;


@Remote
public interface GestionExamenLaboratorioRemote {
	public void guardarExamenLaboratorio(int el_codigo,  String el_sangre, String el_plaquetas, String el_grupo_sanguineo, Cita ci_codigo);
	public List<ExamenLaboratorio> getExamenLaboratorios();
	public void update(int el_codigo,  String el_sangre, String el_plaquetas, String el_grupo_sanguineo, Cita ci_codigo);
	public void eliminar(int codigo);
}
