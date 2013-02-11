//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.02.11 à 11:00:21 AM CET 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nodeNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}edge" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nodeNum",
    "weight",
    "name",
    "edge"
})
@XmlRootElement(name = "node")
public class Node {

    protected int nodeNum;
    protected int weight;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected List<Edge> edge;

    /**
     * Obtient la valeur de la propriété nodeNum.
     * 
     */
    public int getNodeNum() {
        return nodeNum;
    }

    /**
     * Définit la valeur de la propriété nodeNum.
     * 
     */
    public void setNodeNum(int value) {
        this.nodeNum = value;
    }

    /**
     * Obtient la valeur de la propriété weight.
     * 
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Définit la valeur de la propriété weight.
     * 
     */
    public void setWeight(int value) {
        this.weight = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the edge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the edge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEdge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Edge }
     * 
     * 
     */
    public List<Edge> getEdge() {
        if (edge == null) {
            edge = new ArrayList<Edge>();
        }
        return this.edge;
    }

}
