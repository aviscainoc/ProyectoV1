package vista;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import modelo.CertificadoAusencia;
import modelo.Cita;
import modelo.ExamenLaboratorio;
import modelo.HistoriaClinica;
import modelo.Medico;
import modelo.Paciente;
import modelo.RecetaMedica;
import modelo.Usuario;
import negocio.GestionCertificadoAusenciaLocal;
import negocio.GestionCitaLocal;
import negocio.GestionExamenLaboratorioLocal;
import negocio.GestionHistoriaClinicaLocal;
import negocio.GestionMedicosLocal;
import negocio.GestionRecetaMedicaLocal;
import negocio.GestionUsuariosLocal;
@ManagedBean
public class GestionCitasBean {

	@Inject
	private GestionCitaLocal gl;
	@Inject 
	private GestionUsuariosLocal gul;
	
	@Inject
	private GestionHistoriaClinicaLocal gh;
	@Inject
	private GestionCertificadoAusenciaLocal gc;
	@Inject
	private GestionExamenLaboratorioLocal ge;
	@Inject
	private GestionRecetaMedicaLocal gr;
	
	private int ci_codigo;
	private String us_codigo;
	private String ci_estado;
	private String ci_diagnostico;
	private Date ci_fecha_agendacion ;
	private Date ci_fecha_cita;
	private List<Cita> citas;
	private String codigoPasable;
	private Cita cita;
	
	
	private int hc_codigo;
	private String hc_residencia;
	private String hc_fecha;
	private String hc_movito_consulta;
	private String hc_enfermedad_actual;
	private Usuario usuario;
	private List<HistoriaClinica> historias;
	
	
	private int ca_codigo;
	private String ca_descripcion;
	private List<CertificadoAusencia> CertificadoAusencias;
	
	
	private int el_codigo;
	private String[] el_quimica;
	private String[] el_heces;
	private String[] el_microbiologia;
	private String[] el_hematologia;
	private String[] el_orina;
	private List<ExamenLaboratorio> ExamenLaboratorios;	
	
	
	private int rm_codigo;
	private String rm_peso;
	private String rm_talla;
	private String rm_edad;
	private String rm_TA;
	private String rm_rx;
	private List<RecetaMedica> recetas;
	

	
	public GestionCitaLocal getGl() {
		return gl;
	}
	public void setGl(GestionCitaLocal gl) {
		this.gl = gl;
	}
	public GestionUsuariosLocal getGul() {
		return gul;
	}
	public void setGul(GestionUsuariosLocal gul) {
		this.gul = gul;
	}
	public GestionHistoriaClinicaLocal getGh() {
		return gh;
	}
	public void setGh(GestionHistoriaClinicaLocal gh) {
		this.gh = gh;
	}
	public GestionCertificadoAusenciaLocal getGc() {
		return gc;
	}
	public void setGc(GestionCertificadoAusenciaLocal gc) {
		this.gc = gc;
	}
	public GestionExamenLaboratorioLocal getGe() {
		return ge;
	}
	public void setGe(GestionExamenLaboratorioLocal ge) {
		this.ge = ge;
	}
	public GestionRecetaMedicaLocal getGr() {
		return gr;
	}
	public void setGr(GestionRecetaMedicaLocal gr) {
		this.gr = gr;
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
	public String getCodigoPasable() {
		return codigoPasable;
	}
	public void setCodigoPasable(String codigoPasable) {
		this.codigoPasable = codigoPasable;
	}
	public Cita getCita() {
		return cita;
	}
	public void setCita(Cita cita) {
		this.cita = cita;
	}
	public int getHc_codigo() {
		return hc_codigo;
	}
	public void setHc_codigo(int hc_codigo) {
		this.hc_codigo = hc_codigo;
	}
	public String getHc_residencia() {
		return hc_residencia;
	}
	public void setHc_residencia(String hc_residencia) {
		this.hc_residencia = hc_residencia;
	}
	public String getHc_fecha() {
		return hc_fecha;
	}
	public void setHc_fecha(String hc_fecha) {
		this.hc_fecha = hc_fecha;
	}
	public String getHc_movito_consulta() {
		return hc_movito_consulta;
	}
	public void setHc_movito_consulta(String hc_movito_consulta) {
		this.hc_movito_consulta = hc_movito_consulta;
	}
	public String getHc_enfermedad_actual() {
		return hc_enfermedad_actual;
	}
	public void setHc_enfermedad_actual(String hc_enfermedad_actual) {
		this.hc_enfermedad_actual = hc_enfermedad_actual;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<HistoriaClinica> getHistorias() {
		return historias;
	}
	public void setHistorias(List<HistoriaClinica> historias) {
		this.historias = historias;
	}
	public int getCa_codigo() {
		return ca_codigo;
	}
	public void setCa_codigo(int ca_codigo) {
		this.ca_codigo = ca_codigo;
	}
	public String getCa_descripcion() {
		return ca_descripcion;
	}
	public void setCa_descripcion(String ca_descripcion) {
		this.ca_descripcion = ca_descripcion;
	}
	public List<CertificadoAusencia> getCertificadoAusencias() {
		return CertificadoAusencias;
	}
	public void setCertificadoAusencias(List<CertificadoAusencia> certificadoAusencias) {
		CertificadoAusencias = certificadoAusencias;
	}
	public int getEl_codigo() {
		return el_codigo;
	}
	public void setEl_codigo(int el_codigo) {
		this.el_codigo = el_codigo;
	}
	public String[] getEl_quimica() {
		return el_quimica;
	}
	public void setEl_quimica(String[] el_quimica) {
		this.el_quimica = el_quimica;
	}
	public String[] getEl_heces() {
		return el_heces;
	}
	public void setEl_heces(String[] el_heces) {
		this.el_heces = el_heces;
	}
	public String[] getEl_microbiologia() {
		return el_microbiologia;
	}
	public void setEl_microbiologia(String[] el_microbiologia) {
		this.el_microbiologia = el_microbiologia;
	}
	public String[] getEl_hematologia() {
		return el_hematologia;
	}
	public void setEl_hematologia(String[] el_hematologia) {
		this.el_hematologia = el_hematologia;
	}
	public String[] getEl_orina() {
		return el_orina;
	}
	public void setEl_orina(String[] el_orina) {
		this.el_orina = el_orina;
	}
	public List<ExamenLaboratorio> getExamenLaboratorios() {
		return ExamenLaboratorios;
	}
	public void setExamenLaboratorios(List<ExamenLaboratorio> examenLaboratorios) {
		ExamenLaboratorios = examenLaboratorios;
	}
	public int getRm_codigo() {
		return rm_codigo;
	}
	public void setRm_codigo(int rm_codigo) {
		this.rm_codigo = rm_codigo;
	}
	public String getRm_peso() {
		return rm_peso;
	}
	public void setRm_peso(String rm_peso) {
		this.rm_peso = rm_peso;
	}
	public String getRm_talla() {
		return rm_talla;
	}
	public void setRm_talla(String rm_talla) {
		this.rm_talla = rm_talla;
	}
	public String getRm_edad() {
		return rm_edad;
	}
	public void setRm_edad(String rm_edad) {
		this.rm_edad = rm_edad;
	}
	public String getRm_TA() {
		return rm_TA;
	}
	public void setRm_TA(String rm_TA) {
		this.rm_TA = rm_TA;
	}
	public String getRm_rx() {
		return rm_rx;
	}
	public void setRm_rx(String rm_rx) {
		this.rm_rx = rm_rx;
	}
	public List<RecetaMedica> getRecetas() {
		return recetas;
	}
	public void setRecetas(List<RecetaMedica> recetas) {
		this.recetas = recetas;
	}
	public String guardarCita() {
		String rol="pac";
		int registro=0;
		ci_fecha_agendacion = new Date();
		ci_estado = "pendiente";
		
		if (gul.recuperarUsuario(us_codigo)!=null) {
			gl.guardarCita(us_codigo, ci_fecha_agendacion, ci_fecha_cita, ci_estado);
			citas=gl.getCitas();
			return "index";
		} else {
			gul.guardarUsuarioPaciente(us_codigo, rol, registro, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
			gl.guardarCita(us_codigo, ci_fecha_agendacion, ci_fecha_cita, ci_estado);
			citas=gl.getCitas();
			return "persuasiva";
		}
	}
	
//	public void actualizarCita()
	
	public List<Cita> recuperarCitas(){
		citas=gl.getCitas();
		return citas;	
	}
	
	public List<Cita> recuperarCitasPendientes(){
		citas=gl.getCitasPendientes();
		return citas;	
	}
	
	public void eliminar() {
		gl.eliminar(ci_codigo);
	}

	public void recuperarCita() {
		System.out.println(ci_codigo);
		if(ci_codigo==0)
			return;
		try {
			this.cita = gl.getCita(ci_codigo);
		} catch (Exception e) {
			System.out.println("error recuperarCita: " + e);
			e.printStackTrace();
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}
	}

	public Cita recuperarCita(int codigo) {
		System.out.println(codigo);
		if(codigo==0)
			return null;
		try {
			Cita  c = gl.getCita(codigo);
			return c;
		} catch (Exception e) {
			System.out.println("error recuperarCita: " + e);
			e.printStackTrace();
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
            return null;
		}
	}
	
	public void terminarCita() {
		if (guardarHistoriasClinicas() && guardarExamenLaboratorios() && guardarRecetas() && guardarCertificado()) {
			HistoriaClinica hc = gh.getHistoria(hc_codigo);
			ExamenLaboratorio el = ge.getExamen(el_codigo);
			RecetaMedica rm = gr.getReceta(rm_codigo);
			CertificadoAusencia ca = gc.getCertificado(ca_codigo);
			Cita c = recuperarCita(ci_codigo);
			c.setHistoria(hc);
			c.setExamen(el);
			c.setReceta(rm);
			c.setCertificado(ca);
			c.setCi_estado("terminada");
			System.out.println(c);
			gl.updateCita(c);
		}
	}
	
	
	
	
	
	public boolean guardarHistoriasClinicas() {
		try {
			hc_codigo = gh.guardarHistoriaClinica(hc_residencia, hc_fecha, hc_movito_consulta, hc_enfermedad_actual, usuario);
			historias = gh.getHistoriasClinicas();
			return true;	
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean guardarExamenLaboratorios() {
		try {
			el_codigo = ge.guardarExamenLaboratorio(Arrays.toString(el_quimica), Arrays.toString(el_heces), Arrays.toString(el_microbiologia), Arrays.toString(el_hematologia), Arrays.toString(el_orina));
			ExamenLaboratorios = ge.getExamenLaboratorios();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean guardarRecetas() {
		try {
			rm_codigo = gr.guardarRecetaMedica(rm_peso, rm_talla, rm_edad, rm_TA, rm_rx);
			recetas = gr.listarRecetasMedicas();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean guardarCertificado() {
		try {
			ca_codigo = gc.guardarCertificadoAusencia(ca_descripcion);
			CertificadoAusencias = gc.getCertificadoAusencias();
			return true;	
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}



	