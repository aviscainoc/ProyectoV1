package vista;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;
import modelo.Usuario;
import negocio.GestionCitaLocal;
import negocio.GestionMedicosLocal;
import negocio.GestionUsuariosRemote;
@ManagedBean
public class GestionCitasBean {

	@Inject
	private GestionCitaLocal gl;
	@Inject GestionUsuariosRemote gul;
	
	public GestionUsuariosRemote getGul() {
		return gul;
	}

	public void setGul(GestionUsuariosRemote gul) {
		this.gul = gul;
	}

	private int ci_codigo;
	private String us_codigo;
	private String ci_estado;
	private String ci_diagnostico;
	private Date ci_fecha_agendacion ;
	private Date ci_fecha_cita;
	private List<Cita> citas;
	
	private String codigoPasable;
	
	public String getCodigoPasable() {
		return codigoPasable;
	}

	public void setCodigoPasable(String codigoPasable) {
		this.codigoPasable = codigoPasable;
	}

	public String getCi_estado() {
		return ci_estado;
	}

	public void setCi_estado(String ci_estado) {
		this.ci_estado = ci_estado;
	}

	public String getCi_diagnostico() {
		return ci_diagnostico;
	}

	public void setCi_diagnostico(String ci_diagnostico) {
		this.ci_diagnostico = ci_diagnostico;
	}
	
	public int getCi_codigo() {
		return ci_codigo;
	}

	public void setCi_codigo(int ci_codigo) {
		this.ci_codigo = ci_codigo;
	}

	public String getUs_codigo() {
		return us_codigo;
	}

	public void setUs_codigo(String us_codigo) {
		this.us_codigo = us_codigo;
	}

	public GestionCitaLocal getGl() {
		return gl;
	}

	public Date getCi_fecha_agendacion() {
		return ci_fecha_agendacion;
	}

	public void setCi_fecha_agendacion(Date ci_fecha_agendacion) {
		this.ci_fecha_agendacion = ci_fecha_agendacion;
	}

	public Date getCi_fecha_cita() {
		return ci_fecha_cita;
	}

	public void setCi_fecha_cita(Date ci_fecha_cita) {
		this.ci_fecha_cita = ci_fecha_cita;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public void setGl(GestionCitaLocal gl) {
		this.gl = gl;
	}
	
	public String guardarCita() {
		String rol="pac";
		int registro=0;
		ci_fecha_agendacion = new Date();
		
		
	
	
		gl.guardarCita(us_codigo, ci_fecha_agendacion, ci_fecha_cita, ci_estado, ci_diagnostico);
		
		citas=gl.getCitas();
		Usuario userRecuperado = gul.recuperarUsuario(us_codigo);
		if(userRecuperado!=null) {
			return "index-citas";
		}else {
		gul.guardarUsuarioPaciente(us_codigo, rol, registro, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		return "LaPaginaPersuadisadora";
		}
	}
	
	public List<Cita> recuperarCitas(){
		citas=gl.getCitas();
		return citas;	
	}
	
	public void eliminar() {
		gl.eliminar(ci_codigo);
	}
	
	public void update() {
		gl.updateCita(us_codigo, ci_fecha_agendacion, ci_fecha_cita, ci_estado, ci_diagnostico);
	}
	

}



	