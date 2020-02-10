
package servicios;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servicios package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RealizarRecargaResponse_QNAME = new QName("http://servicios/", "realizarRecargaResponse");
    private final static QName _RealizarRecarga_QNAME = new QName("http://servicios/", "realizarRecarga");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RealizarRecargaResponse }
     * 
     */
    public RealizarRecargaResponse createRealizarRecargaResponse() {
        return new RealizarRecargaResponse();
    }

    /**
     * Create an instance of {@link RealizarRecarga }
     * 
     */
    public RealizarRecarga createRealizarRecarga() {
        return new RealizarRecarga();
    }

    /**
     * Create an instance of {@link Respuesta }
     * 
     */
    public Respuesta createRespuesta() {
        return new Respuesta();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealizarRecargaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "realizarRecargaResponse")
    public JAXBElement<RealizarRecargaResponse> createRealizarRecargaResponse(RealizarRecargaResponse value) {
        return new JAXBElement<RealizarRecargaResponse>(_RealizarRecargaResponse_QNAME, RealizarRecargaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealizarRecarga }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "realizarRecarga")
    public JAXBElement<RealizarRecarga> createRealizarRecarga(RealizarRecarga value) {
        return new JAXBElement<RealizarRecarga>(_RealizarRecarga_QNAME, RealizarRecarga.class, null, value);
    }

}
