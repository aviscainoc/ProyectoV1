package negocio;

import java.util.Date;
import java.util.List;

import modelo.Candidato;

public interface GestionUsuariosRemote {
	public void agregarVoto(String ced_candidato,String ced_votante, String nom_votante);
	public List<Candidato> getUsuarios();
}
