package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.Cita;
import modelo.ExamenLaboratorio;



@Local
public interface GestionExamenLaboratorioLocal {
	public int guardarExamenLaboratorio(String el_quimica, String el_heces, String el_microbiologia, String el_hematologia, String el_orina);
	public List<ExamenLaboratorio> getExamenLaboratorios();
	public void update(int el_codigo, String el_quimica, String el_heces, String el_microbiologia, String el_hematologia, String el_orina);
	public void eliminar(int codigo);
	public ExamenLaboratorio getExamen(int codigo);
	
	public int obtenerCodigoExamen(int codigo);
	public String obtenerTextoEx(int codigoCA);
	
}
