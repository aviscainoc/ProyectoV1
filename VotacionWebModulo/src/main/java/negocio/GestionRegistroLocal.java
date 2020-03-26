package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Candidato;
import modelo.Registro;





@Local
public interface GestionRegistroLocal {
	public void guardarRegistro(String titulo, String fecha);
	
	public void agregarCandidato(int cod_re, String us_cedula, String us_nombres, int us_num_lista, String us_titulo_universitario);
	
	public List<Candidato> verResultados();
	
}
