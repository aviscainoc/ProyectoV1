package negocio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import modelo.Candidato;
import modelo.Voto;


public interface GestionUsuariosLocal {
	
	public void agregarVoto(String ced_candidato,String ced_votante, String nom_votante);
	public List<Candidato> getUsuarios();
}
