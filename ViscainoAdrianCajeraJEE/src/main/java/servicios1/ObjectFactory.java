
package servicios1;

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

    private final static QName _RealizarRecargaFactura_QNAME = new QName("http://servicios/", "realizarRecargaFactura");
    private final static QName _RealizarRecargaFacturaResponse_QNAME = new QName("http://servicios/", "realizarRecargaFacturaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RealizarRecargaFacturaResponse }
     * 
     */
    public RealizarRecargaFacturaResponse createRealizarRecargaFacturaResponse() {
        return new RealizarRecargaFacturaResponse();
    }

    /**
     * Create an instance of {@link RealizarRecargaFactura }
     * 
     */
    public RealizarRecargaFactura createRealizarRecargaFactura() {
        return new RealizarRecargaFactura();
    }

    /**
     * Create an instance of {@link RespuestaFac }
     * 
     */
    public RespuestaFac createRespuestaFac() {
        return new RespuestaFac();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealizarRecargaFactura }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "realizarRecargaFactura")
    public JAXBElement<RealizarRecargaFactura> createRealizarRecargaFactura(RealizarRecargaFactura value) {
        return new JAXBElement<RealizarRecargaFactura>(_RealizarRecargaFactura_QNAME, RealizarRecargaFactura.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealizarRecargaFacturaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "realizarRecargaFacturaResponse")
    public JAXBElement<RealizarRecargaFacturaResponse> createRealizarRecargaFacturaResponse(RealizarRecargaFacturaResponse value) {
        return new JAXBElement<RealizarRecargaFacturaResponse>(_RealizarRecargaFacturaResponse_QNAME, RealizarRecargaFacturaResponse.class, null, value);
    }

}
