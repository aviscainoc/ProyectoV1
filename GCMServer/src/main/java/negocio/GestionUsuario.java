package negocio;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.OneToMany;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import datos.CitaDAO;
import datos.ExamenLaboratorioDAO;
import datos.MedicoDAO;
import datos.PacienteDAO;
import datos.UsuarioDAO;
import modelo.Cita;
import modelo.Conexion;
import modelo.HistoriaClinica;
import modelo.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

@Stateless
public class GestionUsuario implements GestionUsuariosLocal, GestionUsuariosRemote {
	
	@Inject 
	private UsuarioDAO daoU;
	@Inject 
	ExamenLaboratorioDAO daoEL;
	@Inject
	private CitaDAO daoC;
	
	public void guardarUsuarioPaciente(String us_cedula, String us_rol, int us_pa_registro, String  us_nombres, String  us_apellidos, String us_sexo, Date us_fecha_nacimiento,
			String us_correo, String us_contrasena, String us_pa_estado_civil, String us_pa_nivel_estudio, String us_pa_ocupacion, String us_pa_etnia, 
			String us_pa_religion, String us_pa_tipo_sangre, String us_pa_identidad_sexual, String us_pa_procedencia) {		
		Usuario u = new Usuario();
		u.setUs_cedula(us_cedula);
		u.setUs_rol(us_rol);
		u.setUs_pa_registro(us_pa_registro);
		u.setUs_nombres(us_nombres);
		u.setUs_apellidos(us_apellidos);
		u.setUs_sexo(us_sexo);
		u.setUs_fecha_nacimiento(us_fecha_nacimiento);
		u.setUs_correo(us_correo);
		u.setUs_contrasena(us_contrasena);
		u.setUs_pa_estado_civil(us_pa_estado_civil);
		u.setUs_pa_nivel_estudio(us_pa_nivel_estudio);
		u.setUs_pa_ocupacion(us_pa_ocupacion);
		u.setUs_pa_etnia(us_pa_etnia);
		u.setUs_pa_religion(us_pa_religion);
		u.setUs_pa_tipo_sangre(us_pa_tipo_sangre);
		u.setUs_pa_identidad_sexual(us_pa_identidad_sexual);
		u.setUs_pa_procedencia(us_pa_procedencia);
		System.out.println(u);
		daoU.insert(u);
	}
	
	public void guardarUsuarioMedico(String us_cedula, String us_rol, String  us_nombres, String  us_apellidos, String us_sexo, Date us_fecha_nacimiento,
			String us_correo, String us_contrasena, String us_md_area_especialidad, String us_md_descripcion) {
		
		Usuario u = new Usuario();
		u.setUs_cedula(us_cedula);
		u.setUs_rol(us_rol);
		u.setUs_nombres(us_nombres);
		u.setUs_apellidos(us_apellidos);
		u.setUs_sexo(us_sexo);
		u.setUs_fecha_nacimiento(us_fecha_nacimiento);
		u.setUs_correo(us_correo);
		u.setUs_contrasena(us_contrasena);
		u.setUs_md_area_especialidad(us_md_area_especialidad);
		u.setUs_md_descripcion(us_md_descripcion);
		daoU.insert(u);
		//return index';
	}
		
	public List<Usuario> getUsuarios(){
		return daoU.getUsuarios();
	}
	
	public Usuario login(String usuario, String contrasena) throws Exception {
		Usuario usr= daoU.login(usuario, contrasena);
		
		return usr;
	}
	
	public Usuario recuperarUsuario(String cedula) {
		System.out.println("mostrando a "+daoU.read(cedula));
		
		return daoU.read(cedula);
	}

	public void actualizarDatos(String cedula, String nombres, String apellidos, String sexo, Date nacimiento, String correo, 
			String civil, String estudio, String ocupacion, String etnia, String religion, String sangre, String identidad, String procedencia) {
		Usuario u = new Usuario();
		u.setUs_cedula(cedula);
		u.setUs_nombres(nombres);
		u.setUs_apellidos(apellidos);
		u.setUs_sexo(sexo);
		u.setUs_fecha_nacimiento(nacimiento);
		u.setUs_correo(correo);
		u.setUs_pa_estado_civil(civil);
		u.setUs_pa_nivel_estudio(estudio);
		u.setUs_pa_ocupacion(ocupacion);
		u.setUs_pa_etnia(etnia);
		u.setUs_pa_religion(religion);
		u.setUs_pa_tipo_sangre(sangre);
		u.setUs_pa_identidad_sexual(identidad);
		u.setUs_pa_procedencia(procedencia);
		daoU.update(u);
		System.out.println(u);
	}

	public void actualizarDatos(Usuario u) {
		System.out.println("GestionUsuario antes" + u);
		daoU.update(u);
		u = recuperarUsuario(u.getUs_cedula());
		System.out.println("GestionUsuario " + u);
	}
	
	
	
	private static final int DEFAULT_BUFFER_SIZE = 1024;
	public void downloadFile() throws IOException {
		  
		  
		  
		// Creating a PdfWriter       
			//String dest = "C:\\Users\\PCX\\Documents\\7mo Ciclo\\Plataformas Web\\addingParagraph.pdf";
			String dest = "C:\\Users\\PCX\\eclipse-workspace\\ProyectoV1\\GCMServer\\ArchivosPDF\\CertificadoMedico.pdf";
			PdfWriter writer = new PdfWriter(dest);           
		    
		    // Creating a PdfDocument       
		    PdfDocument pdf = new PdfDocument(writer);              
		    
		    // Creating a Document        
		    Document document = new Document(pdf);       
		    
		    
		    String para0 = "CERTIFICA";
		   
		    
		    String para1 = "Que la Sra."+" con cédula de\r\n" + 
		    		"		    identidad no. 01CI205752-8 recibe tratamiento de hemodiálisis desde el 29 de\r\n" + 
		    		"		    junio del 2012 en la Unidad Renal de Baxter los días lunes, miércoles y\r\n" + 
		    		"		    viernes en el turno de 16h30 a 20h30 por adolecer de Enfermedad Renal\r\n" + 
		    		"		    Crónica etiología Hipertensión Arterial.\r\n" + 
		    		"		    Es cuanto informo a la verdad, autorizo al peticionario hacer del presente\r\n" + 
		    		"		    certificado el uso legal que crea conveniente. ";  
		    
		    String para2 = "The journey commenced with a single tutorial on HTML in 2006 ";              
		    
		    // Creating Paragraphs       
		    Paragraph paragraph1 = new Paragraph(para1);             
		    Paragraph paragraph2 = new Paragraph(para2);              
		    
		    // Adding paragraphs to document
		    
		    document.add(paragraph1);       
		    document.add(paragraph2);           
		    
		    // Closing the document       
		    document.close();             
		    System.out.println("Paragraph added"); 
		  
		  
		  FacesContext context = FacesContext.getCurrentInstance();
		  HttpServletResponse response =
		  	        (HttpServletResponse) FacesContext.getCurrentInstance()
		  	            .getExternalContext().getResponse();
		  File file = new File("C:\\Users\\PCX\\eclipse-workspace\\ProyectoV1\\GCMServer\\ArchivosPDF\\CertificadoMedico.pdf");
		  if(file.exists()){
			  System.out.println("oye no esta encontrando");
		      response.sendError(HttpServletResponse.SC_NOT_FOUND);
		      //return;
		  }
		  response.reset();
		  response.setBufferSize(DEFAULT_BUFFER_SIZE);
		  response.setContentType("application/octet-stream");
		  response.setHeader("Content-Length", String.valueOf(file.length()));
		  response.setHeader("Content-Disposition","attachment;filename=instructions.pdf");
		  System.out.println("aqui no llega");
		  BufferedInputStream input = null;
		  BufferedOutputStream output = null;

		  try
		  {
		      input = new BufferedInputStream(new FileInputStream(file),DEFAULT_BUFFER_SIZE);
		      output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

		      byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
		      int length;
		      while ((length = input.read(buffer)) > 0){
		          output.write(buffer, 0, length);
		      }

		  }
		  finally
		  {
		      input.close();
		      output.close();
		  }
		  context.responseComplete();
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	    /* File file = new File("C:\\Users\\PCX\\Documents\\7mo Ciclo\\Plataformas Web\\cambiosGit.txt");
	     System.out.println(file);
	     InputStream fis = new FileInputStream(file);
	     byte[] buf = new byte[1024];
	     int offset = 0;
	     int numRead = 0;
	     while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0)) 
	     {
	       offset += numRead;
	     }
	     fis.close();
	     HttpServletResponse response =
	        (HttpServletResponse) FacesContext.getCurrentInstance()
	            .getExternalContext().getResponse();
	    
	    response.setContentType("application/octet-stream");
	    response.setHeader("Content-Disposition", "attachment;filename=instructions.txt");
	   /* response.getOutputStream().write(buf);
	    
	   */ 
	   /* response.getOutputStream().write();
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	    FacesContext.getCurrentInstance().responseComplete();
		 /*
		  InputStream input = new FileInputStream("c:\\data\\input-text.txt");

		  int data = input.read();
		  while(data != -1) {
		    //do something with data...
		    doSomethingWithData(data);

		    data = input.read();
		  }*/
		  //input.close();*/
		  
		  
		  /*
		  
		  
		  final FacesContext fc = FacesContext.getCurrentInstance();
		    final ExternalContext externalContext = fc.getExternalContext();

		    //final File file = new File();
		    final File file = new File("C:\\Users\\PCX\\Documents\\7mo Ciclo\\Plataformas Web\\cambiosGit.txt");
		    externalContext.responseReset();
		    externalContext.setResponseContentType("application/octet-stream");
		    //externalContext.setResponseContentType(ContentType.APPLICATION_OCTET_STREAM.getMimeType());
		    externalContext.setResponseContentLength(Long.valueOf(file.lastModified()).intValue());
		    externalContext.setResponseHeader("Content-Disposition", "attachment;filename=" + file.getName());

		    final HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

		    FileInputStream input = new FileInputStream(file);
		    byte[] buffer = new byte[1024];
		    final ServletOutputStream out = response.getOutputStream();

		    while ((input.read(buffer)) != -1) {
		        out.write(buffer);
		    }

		    out.flush();
		    fc.responseComplete();
		}*/
	  
	
	/*
		  final FacesContext fc = FacesContext.getCurrentInstance();
		    final ExternalContext externalContext = fc.getExternalContext();

		    final File file = new File("C:\\Users\\PCX\\Documents\\7mo Ciclo\\Plataformas Web\\cambiosGit.txt");
		    System.out.println(file.canRead()+"ver si vale");
		    externalContext.responseReset();
		    externalContext.setResponseContentType("application/octet-stream");
		    externalContext.setResponseContentLength(Long.valueOf(file.lastModified()).intValue());
		    externalContext.setResponseHeader("Content-Disposition", "attachment;filename=" + file.getName());

		    final HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		    response.reset();
		    FileInputStream input = new FileInputStream(file);
		    byte[] buffer = new byte[1024];
		    final ServletOutputStream out = response.getOutputStream();

		    while ((input.read(buffer)) != -1) {
		        out.write(buffer);
		    }

		    out.flush();
		    fc.responseComplete();*/
}}



/*


@Stateless
public class GestionCita implements GestionCitaLocal, GestionCitaRemote{
	@Inject
	private CitaDAO dao;
	@Inject
	private MedicoDAO daoM;
	@Inject
	private PacienteDAO daoP;

	public void guardarCita(int ci_codigo, int codigoM, int codigoPa, String ci_fecha_agendacion, String ci_fecha_cita) {
		Cita c = new Cita();
		c.setCi_codigo(ci_codigo);
		c.setMe_codigo(daoM.read(codigoM));
		c.setPa_codigo(daoP.read(codigoPa));
		c.setCi_fecha_agendacion(ci_fecha_agendacion);
		c.setCi_fecha_cita(ci_fecha_cita);
		dao.insert(c);
	}
	
	public List<Cita> getCitas(){
		return dao.getCitas();
	}
	
	public void updateCita(int ci_codigo, int codigoM, int codigoPa, String ci_fecha_agendacion, String ci_fecha_cita) {
		Cita c = new Cita();
		c.setCi_codigo(ci_codigo);
		c.setMe_codigo(daoM.read(codigoM));
		c.setPa_codigo(daoP.read(codigoPa));
		c.setCi_fecha_agendacion(ci_fecha_agendacion);
		c.setCi_fecha_cita(ci_fecha_cita);
		dao.update(c);
	}
	
	/*public Medico Login(String usuario, String contrasena) {
		return dao.login(usuario, contrasena);
	}

	public void eliminar(int ci_codigo) {
		dao.remove(ci_codigo);
	}*/