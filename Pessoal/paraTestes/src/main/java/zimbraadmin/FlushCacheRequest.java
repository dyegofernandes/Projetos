
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de flushCacheRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="flushCacheRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cache" type="{urn:zimbraAdmin}cacheSelector" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flushCacheRequest", propOrder = {
    "cache"
})
public class FlushCacheRequest {

    protected CacheSelector cache;

    /**
     * Obtém o valor da propriedade cache.
     * 
     * @return
     *     possible object is
     *     {@link CacheSelector }
     *     
     */
    public CacheSelector getCache() {
        return cache;
    }

    /**
     * Define o valor da propriedade cache.
     * 
     * @param value
     *     allowed object is
     *     {@link CacheSelector }
     *     
     */
    public void setCache(CacheSelector value) {
        this.cache = value;
    }

}
