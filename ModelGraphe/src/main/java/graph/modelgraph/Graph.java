//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.02.08 à 11:08:13 AM CET 
//


package graph.modelgraph;

import generated.Node;
import graph.exception.ArcException;
import graph.exception.AreteException;
import graph.exception.NodeException;
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
 *         &lt;element name="nbNode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idGraph" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}node" maxOccurs="unbounded"/>
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
    "nbNode",
    "idGraph",
    "name",
    "node",
    "edge"
})
@XmlRootElement(name = "graphe")
public class Graph implements GraphCRUD{
    
    protected int nbNode;
    protected int idGraph;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected List<Node> node;
    
    public Graph() {
       node = null;
       nbNode = 0;
       name = "";
         
    }
    /**
     * Obtient la valeur de la propriété nbNode.
     * 
     */
    public int getNbNode() {
        return nbNode;
    }

    /**
     * Définit la valeur de la propriété nbNode.
     * 
     */
    public void setNbNode(int value) {
        this.nbNode = value;
    }

    /**
     * Obtient la valeur de la propriété idGraph.
     * 
     */
    public int getIdGraph() {
        return idGraph;
    }

    /**
     * Définit la valeur de la propriété idGraph.
     * 
     */
    public void setIdGraph(int value) {
        this.idGraph = value;
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
     * Gets the value of the node property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the node property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Node }
     * 
     * 
     */
    public List<Node> getNode() {
        if (node == null) {
            node = new ArrayList<>();
        }
        return this.node;
    }

    @Override
    public boolean isEdge(Node s1, Node s2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int degre(Node s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(Node s) throws NodeException {
        if(s == null)
        {
           throw new NodeException("not add null node");
        }
        s.setNodeNum(nbNode);
         nbNode++;
         node.add(s);
    }

    @Override
    public String toString() {
        return "Graph{" + "nbNode=" + nbNode + ", idGraph=" + idGraph + ", name=" + name + '}';
    }

    @Override
    public void delete(Node s) throws NodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addArc(Node s1, Node s2, int poid) throws ArcException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteArc(Node s1, Node s2) throws ArcException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addEdge(Node s1, Node s2, int poid) throws AreteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteEdge(Node s1, Node s2) throws AreteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Node> adjacentsNode(Node s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public Node getNode(String labelNode) {
        for(int i=0; i<node.size();i++)
        {
            Node s = node.get(i);
            if(s.getName() != null ? labelNode != null : s.getName().equals(labelNode)) {
                return s;
            }
        }
        return null;
    }

}
