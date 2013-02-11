//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.02.11 à 11:00:21 AM CET 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="nodeA" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nodeB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="directed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "nodeA",
    "nodeB",
    "weight",
    "directed"
})
@XmlRootElement(name = "edge")
public class Edge {

    protected int nodeA;
    protected int nodeB;
    protected int weight;
    protected boolean directed;

    /**
     * Obtient la valeur de la propriété nodeA.
     * 
     */
    public int getNodeA() {
        return nodeA;
    }

    /**
     * Définit la valeur de la propriété nodeA.
     * 
     */
    public void setNodeA(int value) {
        this.nodeA = value;
    }

    /**
     * Obtient la valeur de la propriété nodeB.
     * 
     */
    public int getNodeB() {
        return nodeB;
    }

    /**
     * Définit la valeur de la propriété nodeB.
     * 
     */
    public void setNodeB(int value) {
        this.nodeB = value;
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
     * Obtient la valeur de la propriété directed.
     * 
     */
    public boolean isDirected() {
        return directed;
    }

    /**
     * Définit la valeur de la propriété directed.
     * 
     */
    public void setDirected(boolean value) {
        this.directed = value;
    }

}
