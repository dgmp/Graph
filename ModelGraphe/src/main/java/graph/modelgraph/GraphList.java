//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.02.08 à 11:08:13 AM CET 
//


package graph.modelgraph;

import generated.Edge;
import generated.Node;
import graph.exception.ArcException;
import graph.exception.NodeException;
import java.util.List;
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
@XmlRootElement(name = "grapheList")
public class GraphList extends Graph {

    GraphList(String name,int idGraph) {
        super();
        this.name = name;
        this.idGraph = idGraph;
    }

    @Override
    public String toString() {
        String res= "GraphList number " + idGraph + " nbNode " +nbNode ;
        
        for (int i =0;i<node.size();i++)
        {
           res += "\n" + node.get(i).getName();
        }
        return res; 
    }
    @Override
    public void add(Node s) throws NodeException {
        if(s == null)
        {
           throw new NodeException("not add null node");
        }
        /*numéro de sommet de 0 à n-1*/
        s.setNodeNum(numNextNode);
        node.add(numNextNode,s);
        nbNode++;
        numNextNode=nbNode;
        for(int i = 0;i<node.size();i++)
        {
            if(node.get(i).getNodeNum() != i)
            {
                numNextNode = i;
                break;
            }
        }
    }
    @Override
    public void delete(Node s) throws NodeException {
        
        
        if(s == null) {
            throw new NodeException("cannot delete null node");
        }
        int numNode = s.getNodeNum();
        for( int i=0;i<node.size();++i)
        {
            if(i == numNode) {
                continue;
            }
            List<Edge> edge = node.get(i).getEdge();
            for(int j = 0;j<edge.size();j++)
            {
                Edge cE =edge.get(i);
                if(cE.getNodeA() == numNode ||cE.getNodeB() == numNode)
                {
                    edge.remove(i);
                }
            }
        }
        boolean remove = node.remove(s);
        if(!remove) {
            throw new NodeException("remove node error");
        }
        if(numNextNode >numNode)
        {
            numNextNode = numNode;
        }
        nbNode--;
        
    }
    
    @Override
    public void addArc(Node s1, Node s2, int poid) throws ArcException {
        
        Edge edge = new Edge();
        edge.setNodeA(s1.getNodeNum());
        edge.setNodeB(s2.getNodeNum());
        edge.setWeight(poid);
        boolean add;
        add = s1.getEdge().add(edge);
        if(!add)
        {
            throw new ArcException("Arc not add");
        }   
    }
    
    public List<Edge> getEdge() {
        return null;
    }

}
