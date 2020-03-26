
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

    private final static QName _Votar_QNAME = new QName("http://servicios/", "Votar");
    private final static QName _VotarResponse_QNAME = new QName("http://servicios/", "VotarResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VotarResponse }
     * 
     */
    public VotarResponse createVotarResponse() {
        return new VotarResponse();
    }

    /**
     * Create an instance of {@link Votar }
     * 
     */
    public Votar createVotar() {
        return new Votar();
    }

    /**
     * Create an instance of {@link Respuesta }
     * 
     */
    public Respuesta createRespuesta() {
        return new Respuesta();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Votar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "Votar")
    public JAXBElement<Votar> createVotar(Votar value) {
        return new JAXBElement<Votar>(_Votar_QNAME, Votar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VotarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "VotarResponse")
    public JAXBElement<VotarResponse> createVotarResponse(VotarResponse value) {
        return new JAXBElement<VotarResponse>(_VotarResponse_QNAME, VotarResponse.class, null, value);
    }

}
