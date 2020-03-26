package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Candidato {
	
	@Id
	private String us_cedula;
	
	private String us_nombres;
	
	private int us_num_lista;
	
	private String us_titulo_universitario;
	

	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name="us_cedula")
	private List<Voto> votos;

	public String getUs_cedula() {
		return us_cedula;
	}

	public void setUs_cedula(String us_cedula) {
		this.us_cedula = us_cedula;
	}

	public String getUs_nombres() {
		return us_nombres;
	}

	public void setUs_nombres(String us_nombres) {
		this.us_nombres = us_nombres;
	}

	public int getUs_num_lista() {
		return us_num_lista;
	}

	public void setUs_num_lista(int us_num_lista) {
		this.us_num_lista = us_num_lista;
	}

	public String getUs_titulo_universitario() {
		return us_titulo_universitario;
	}

	public void setUs_titulo_universitario(String us_titulo_universitario) {
		this.us_titulo_universitario = us_titulo_universitario;
	}


	
	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	
	public void addVoto(Voto voto) {
		if(votos==null)
			votos = new ArrayList<Voto>();
		votos.add(voto);
	}


	@Override
	public String toString() {
		return "Candidato [us_cedula=" + us_cedula + ", us_nombres=" + us_nombres + ", us_num_lista=" + us_num_lista
				+ ", us_titulo_universitario=" + us_titulo_universitario + ", us_fec_nac="  + ", votos="
				+ votos + "]";
	}

	
	
}