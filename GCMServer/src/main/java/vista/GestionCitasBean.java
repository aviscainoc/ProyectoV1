package vista;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import datos.UsuarioDAO;
import modelo.CertificadoAusencia;
import modelo.Cita;
import modelo.ExamenLaboratorio;
import modelo.FacturaCabecera;
import modelo.FacturaDetalle;
import modelo.HistoriaClinica;
import modelo.IngresosEgresos;
import modelo.RecetaMedica;
import modelo.Usuario;
import negocio.GestionCertificadoAusenciaLocal;
import negocio.GestionCitaLocal;
import negocio.GestionExamenLaboratorioLocal;
import negocio.GestionFacturaCabeceraLocal;
import negocio.GestionFacturaDetalleLocal;
import negocio.GestionHistoriaClinicaLocal;
import negocio.GestionIngresosEgresosLocal;
import negocio.GestionRecetaMedicaLocal;
import negocio.GestionUsuariosLocal;
import net.sf.jasperreports.engine.JRException;
@ManagedBean
@SessionScoped
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
	@Inject
	private GestionFacturaCabeceraLocal glf;
	@Inject
	private GestionFacturaDetalleLocal gld;
	@Inject
	private GestionIngresosEgresosLocal glie;
	
	private int ci_codigo;
	private String us_codigo;
	private String ci_estado;
	private String ci_diagnostico;
	private Date ci_fecha_agendacion ;
	private String ci_fecha_cita;
	private int hora;
	private int minuto;
	private List<Cita> citas;
	private String codigoPasable;
	private Cita cita;
	String cantidad;
	
	
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
	
	
	private int fac_cab_codigo;
	private String fac_cab_nombre;
	private String fac_cab_direccion;
	private String fac_cab_telefono;
	private String fac_cab_cedula;
	private String fac_cab_correo;
	private FacturaCabecera factura;
	private List<FacturaCabecera> facturasCabecera;
	
	
	private int fac_det_codigo;
	private String fac_det_descripcion;
	private double fac_det_precio;
	private int fac_det_cantidad;
	private List<FacturaDetalle> facturasDetalle;
	
	
	private int ie_codigo;
	private String ie_descripcion;
	private double ie_dinero;
	private String md_codigo;
	public double us_dinero;
	private List<IngresosEgresos> ingresosEgresos;
		
	private UIComponent mybutton;
	
	public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }
	public UIComponent getMybutton() {
		return mybutton;
    }
	
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
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
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
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
	public String getCi_fecha_cita() {
		return ci_fecha_cita;
	}
	public void setCi_fecha_cita(String ci_fecha_cita) {
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
		
	public String getFac_cab_nombre() {
		return fac_cab_nombre;
	}
	public void setFac_cab_nombre(String fac_cab_nombre) {
		this.fac_cab_nombre = fac_cab_nombre;
	}
	public String getFac_cab_direccion() {
		return fac_cab_direccion;
	}
	public void setFac_cab_direccion(String fac_cab_direccion) {
		this.fac_cab_direccion = fac_cab_direccion;
	}
	public String getFac_cab_telefono() {
		return fac_cab_telefono;
	}
	public void setFac_cab_telefono(String fac_cab_telefono) {
		this.fac_cab_telefono = fac_cab_telefono;
	}
	public String getFac_cab_cedula() {
		return fac_cab_cedula;
	}
	public void setFac_cab_cedula(String fac_cab_cedula) {
		this.fac_cab_cedula = fac_cab_cedula;
	}
	public String getFac_cab_correo() {
		return fac_cab_correo;
	}
	public void setFac_cab_correo(String fac_cab_correo) {
		this.fac_cab_correo = fac_cab_correo;
	}
	public int getFac_cab_codigo() {
		return fac_cab_codigo;
	}
	public void setFac_cab_codigo(int fac_cab_codigo) {
		this.fac_cab_codigo = fac_cab_codigo;
	}	
	public List<FacturaCabecera> getFacturasCabecera() {
		return facturasCabecera;
	}
	public void setFacturasCabecera(List<FacturaCabecera> facturasCabecera) {
		this.facturasCabecera = facturasCabecera;
	}
	public int getFac_det_codigo() {
		return fac_det_codigo;
	}
	public void setFac_det_codigo(int fac_det_codigo) {
		this.fac_det_codigo = fac_det_codigo;
	}
	public String getFac_det_descripcion() {
		return fac_det_descripcion;
	}
	public void setFac_det_descripcion(String fac_det_descripcion) {
		this.fac_det_descripcion = fac_det_descripcion;
	}
	public double getFac_det_precio() {
		return fac_det_precio;
	}
	public void setFac_det_precio(double fac_det_precio) {
		this.fac_det_precio = fac_det_precio;
	}
	public int getFac_det_cantidad() {
		return fac_det_cantidad;
	}
	public void setFac_det_cantidad(int fac_det_cantidad) {
		this.fac_det_cantidad = fac_det_cantidad;
	}
	public List<FacturaDetalle> getFacturasDetalle() {
		return facturasDetalle;
	}
	public void setFacturasDetalle(List<FacturaDetalle> facturasDetalle) {
		this.facturasDetalle = facturasDetalle;
	}
	public int getIe_codigo() {
		return ie_codigo;
	}
	public void setIe_codigo(int ie_codigo) {
		this.ie_codigo = ie_codigo;
	}
	public String getIe_descripcion() {
		return ie_descripcion;
	}
	public void setIe_descripcion(String ie_descripcion) {
		this.ie_descripcion = ie_descripcion;
	}
	public double getIe_dinero() {
		return ie_dinero;
	}
	public void setIe_dinero(double ie_dinero) {
		this.ie_dinero = ie_dinero;
	}	
	public String getMd_codigo() {
		return md_codigo;
	}
	public void setMd_codigo(String md_codigo) {
		this.md_codigo = md_codigo;
	}
	public List<IngresosEgresos> getIngresosEgresos() {
		return ingresosEgresos;
	}
	public void setIngresosEgresos(List<IngresosEgresos> ingresosEgresos) {
		this.ingresosEgresos = ingresosEgresos;
	}	
	public double getUs_dinero() {
		return us_dinero;
	}
	public void setUs_dinero(double us_dinero) {
		this.us_dinero = us_dinero;
	}
	
	public String guardarCita() {
		String rol="pac";
		int registro=0;
		ci_fecha_agendacion = new Date();
		ci_estado = "pendiente";
		String[] fecha = ci_fecha_cita.split("-");
		int dia = Integer.parseInt(fecha[0]);
		int mes = Integer.parseInt(fecha[1]) - 1;
		int anio = Integer.parseInt(fecha[2]);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hora);
		cal.set(Calendar.MINUTE, minuto);
		cal.set(Calendar.SECOND, 00);
		cal.set(Calendar.DATE, dia);
		cal.set(Calendar.MONTH, mes);
		cal.set(Calendar.YEAR, anio);
		
		Date fecha_cita = cal.getTime();
		
		if (gul.recuperarUsuario(us_codigo)!=null) {
			gl.guardarCita(us_codigo, ci_fecha_agendacion, fecha_cita, ci_estado);
			System.out.println("aqui va la fecha");
			System.out.println(fecha_cita);
			citas=gl.getCitas();
			return "index";
		} else {
			gul.guardarUsuarioPaciente(us_codigo, rol, registro, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
			gl.guardarCita(us_codigo, ci_fecha_agendacion, fecha_cita, ci_estado);
			System.out.println("aqui va la fecha");
			System.out.println(fecha_cita);
			citas=gl.getCitas();
			return "persuasiva";
		}
	}
	
	public String guardarCita(Usuario u) {
		ci_fecha_agendacion = new Date();
		ci_estado = "pendiente";
		String[] fecha = ci_fecha_cita.split("-");
		int dia = Integer.parseInt(fecha[0]);
		int mes = Integer.parseInt(fecha[1]) - 1;
		int anio = Integer.parseInt(fecha[2]);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hora);
		cal.set(Calendar.MINUTE, minuto);
		cal.set(Calendar.SECOND, 00);
		cal.set(Calendar.DATE, dia);
		cal.set(Calendar.MONTH, mes);
		cal.set(Calendar.YEAR, anio);
		
		Date fecha_cita = cal.getTime();
		
		gl.guardarCita(u.getUs_cedula(), ci_fecha_agendacion, fecha_cita, ci_estado);
		System.out.println("aqui va la fecha");
		System.out.println(fecha_cita);
		citas=gl.getCitas();
		return "perfil";
	}
		
	public List<Cita> recuperarCitas(){
		citas=gl.getCitas();
		return citas;	
	}
	
	public List<Cita> recuperarCitasPendientes() throws JRException, IOException{
		citas=gl.getCitasPendientes();
//		gul.guardarPdfUsuario();
		System.out.println(citas);
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
			usuario = cita.getUsuario();
			fac_cab_cedula = usuario.getUs_cedula();
			fac_cab_nombre = usuario.getUs_nombres();
			fac_cab_correo = usuario.getUs_correo();
		} catch (Exception e) {
			System.out.println("error recuperarCita: " + e);
			e.printStackTrace();
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}
	}
	
	public String cancelarCita(int ci_codigo) {
		System.out.println(ci_codigo);
		Cita c = recuperarCita(ci_codigo);
		c.setCi_estado("cancelada");
		gl.updateCita(c);
		System.out.println("cita cancelada " + c);
		return "indexCita";
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
	
	public String terminarCita(int cod) {
		if (guardarHistoriasClinicas() && guardarExamenLaboratorios() && guardarRecetas() && guardarCertificado()) {
			if(cod == 1) {
				guardarFacturaCabeceraDatos();
			}else if(cod ==2) {
				guardarFacturaCabeceraConsumidorFinal();
			}
			HistoriaClinica hc = gh.getHistoria(hc_codigo);
			ExamenLaboratorio el = ge.getExamen(el_codigo);
			RecetaMedica rm = gr.getReceta(rm_codigo);
			CertificadoAusencia ca = gc.getCertificado(ca_codigo);
			FacturaCabecera fc = glf.getFacturaCabecera(fac_cab_codigo);
			Cita c = recuperarCita(ci_codigo);
			c.setHistoria(hc);
			c.setExamen(el);
			c.setReceta(rm);
			c.setCertificado(ca);
			c.setFac_cab_factura(fc);
			c.setCi_estado("terminada");
			System.out.println(c);
			System.out.println("FACTURA CABECERA: " + fc.toString());
			gl.updateCita(c);
		}
		recuperarFacturaCabecera();
		return "/Factura/listar_cabecera";
	}
	
	public boolean guardarHistoriasClinicas() {
		try {
			System.out.println("Llama a guardarBean");
			gh.guardarHistoriaClinica(hc_residencia, hc_fecha, hc_movito_consulta, hc_enfermedad_actual);
			hc_codigo = getHc_codigo();
			historias = gh.getHistoriasClinicas();
			return true;	
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public List<Cita> recuperarProximasCitas(String cedula){
		System.out.println("recuperar proximas citas " + cedula);
		Date fecha = new Date();
		citas = gl.recuperarProximasCitas(cedula, fecha);
		System.out.println("recuperar proximas citas " + citas);
		return 	citas;
	}
	
	public List<Cita> recuperarCitasPasadas(){
		Date fecha = new Date();
		//citas=gl.getCitasPendientes();
		return gl.recuperarCitasPasadas(fecha);	
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
	
	public boolean guardarFacturaCabeceraDatos() {
		try {
			fac_cab_codigo = glf.guardarFacturaCabecera(fac_cab_nombre, fac_cab_direccion, fac_cab_telefono, fac_cab_cedula, fac_cab_correo);
			facturasCabecera = glf.getFacturas();
			return true;
		}catch(Exception e) {
			System.out.println("### Error Guardando Cabecera ### " + e + " " + cita + " " + ci_codigo);
			return false;
		}
	}
	
	public boolean guardarFacturaCabeceraConsumidorFinal() {
		try {
			fac_cab_codigo = glf.guardarFacturaCabeceraConsumidorFinal();
			facturasCabecera = glf.getFacturas();
			return true;
		}catch(Exception e) {
			System.out.println("### Error Guardando Cabecera ### " + e);
			return false;
		}
	}

	public List<FacturaCabecera> recuperarFacturasCabecera(){
		return glf.getFacturas();
	}

	public FacturaCabecera recuperarFacturaCabecera(){
		factura = glf.getFactura(fac_cab_codigo);
		System.out.println("fac cabecera " + factura);
		return factura;
	}
	
	public FacturaCabecera getFactura() {
		return factura;
	}
	
	public void setFactura(FacturaCabecera factura) {
		this.factura = factura;
	}
	
	public List<FacturaDetalle> recuperarFacturasDetalle(){
		facturasDetalle = gld.getFacturaDetalleCabecera(fac_cab_codigo);
		System.out.println("fac detalle " + facturasDetalle);
		return facturasDetalle;
	}
	 
	public String contarCitasUsuario(String cedula){
		cantidad = gl.contarCitasUsuario(cedula); 
		return cantidad;
	}
	 
	public String contarCitasGeneral(){
		cantidad = gl.contarCitasGeneral(); 
		return cantidad;
	}
	
	public FacturaCabecera recuperarFactura(int codigo) {
		System.out.println(codigo);
		if(codigo==0)
			return null;
		try {
			FacturaCabecera fc = glf.getFacturaCabecera(codigo);
			return fc;
		} catch (Exception e) {
			System.out.println("error recuperarFactura: " + e);
			e.printStackTrace();
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
            return null;
		}
	}
	
	
	
	public String guardarDetalle(Usuario u) {
		if(gld.guardarFacturaDetalle(fac_det_descripcion, fac_det_precio, fac_det_cantidad, fac_cab_codigo)) {
			setIe_descripcion(fac_det_descripcion);
			setIe_dinero(fac_det_precio*fac_det_cantidad);
			guardarIngreso(u);
			recuperarFacturaCabecera();
			return "listar_cabecera";
		}else {
			System.out.println("########################## ! ! ! ERROR ! ! ! ############################");
			return "error";
		}
	}
	
	public boolean guardarIngreso(Usuario u) {
		try {
			ie_codigo = glie.guardarIngresosEgresos(ie_descripcion, ie_dinero, u.getUs_cedula());
			ingresosEgresos = glie.getIngresosEgresos();
			Usuario usu = gul.recuperarUsuario(u.getUs_cedula()); 
			IngresosEgresos ie = glie.getIngresoEgreso(ie_codigo);
			System.out.println("### Ingreso ### " + ie);
			return true;
		}catch(Exception e) {
			System.out.println("### Error Guardando Ingreso ### " + e);
			return false;
		}
	}
	
	public boolean guardarEgreso(Usuario u) {
		try {
			ie_codigo = glie.guardarIngresosEgresos(ie_descripcion, (ie_dinero*-1), u.getUs_cedula());
			ingresosEgresos = glie.getIngresosEgresos();
			Usuario usu = gul.recuperarUsuario(u.getUs_cedula()); 
			IngresosEgresos ie = glie.getIngresoEgreso(ie_codigo);
			System.out.println("### Ingreso ### " + ie);
			
			if (us_dinero - ie.getIe_dinero() < 0) {
				FacesMessage message = new FacesMessage("¡Egresos superan los ingresos!");
	            FacesContext context = FacesContext.getCurrentInstance();
	            context.addMessage(mybutton.getClientId(context), message);
			}
			return true;
		}catch(Exception e) {
			System.out.println("### Error Guardando Ingreso ### " + e);
			return false;
		}
	}
	
	public List<IngresosEgresos> recuperarIngresosEgresos(){
		return glie.getIngresosEgresos();
	}
	
	
	public void imprimirCertificado(int codigoCita) throws IOException {
		//recuperar el texto del certificado
		int codigoCA = gc.obtenerCodigoCertificado(codigoCita);
		System.out.println("esto viene "+codigoCA);
		
		String texto = gc.obtenerTexto(codigoCA);
		System.out.println(texto+"Texto que va al pdf");
		
		
		//System.out.println("Codigo de la cita"+code);
		//String texto = gc.getCertificado()//String texto = gul.descargarCertificadoMedico();
		gul.descargarCertificadoMedico(texto);
	}
	
	
	public void imprimirRecetaMedica(int codigoCita) throws IOException {
		//recuperar el texto del certificado
		int codigoCA = gr.obtenerCodigoRM(codigoCita);
		System.out.println("esto viene "+codigoCA);
		
		String texto = gr.obtenerTextoRM(codigoCA);
		System.out.println(texto+"Texto que va al pdf");
		
		
		//System.out.println("Codigo de la cita"+code);
		//String texto = gc.getCertificado()//String texto = gul.descargarCertificadoMedico();
		gul.descargarRecetaMedica(texto);
	}
	
	public void imprimirFactura(int codigoCita) throws IOException {
		//recuperar el texto del certificado
		int codigoCA = glf.obtenerCodigoFactura(codigoCita);
		System.out.println("esto viene "+codigoCA);
		
		String texto = glf.obtenerTexto(codigoCA);
		System.out.println(texto+"Texto que va al pdf");
		
		
		//System.out.println("Codigo de la cita"+code);
		//String texto = gc.getCertificado()//String texto = gul.descargarCertificadoMedico();
		gul.descargarExamenes(texto);
	}
	
	public void imprimirExamen(int codigoCita) throws IOException {
		//recuperar el texto del certificado
		int codigoCA = ge.obtenerCodigoExamen(codigoCita);
		System.out.println("esto viene "+codigoCA);
		
		String texto = ge.obtenerTextoEx(codigoCA);
		System.out.println(texto+"Texto que va al pdf");
		
		
		//System.out.println("Codigo de la cita"+code);
		//String texto = gc.getCertificado()//String texto = gul.descargarCertificadoMedico();
		gul.descargarExamenes(texto);
	}
	
	public String tipo(double valor) {
		if (valor < 0.0)
			return "Egreso";
		else
			return "Ingreso";
	}
	
	public double getSaldo() {
		return gl.getSaldo();
	}
	
   public String moveToPageDefecto() {
      return "/User/index";
   }
	
  
}
