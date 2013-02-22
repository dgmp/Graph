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
@XmlRootElement(name = "grapheMatrix")
public class GraphMatrix extends Graph{

    public GraphMatrix() {
        super();
    }

    Edge [][] edge;
    int maxMat;

    GraphMatrix(String name,int idGraph) {
       super();
       this.name = name;
       this.idGraph = idGraph;
       maxMat=0;
    }

    @Override
    public String toString() {
        
                String res= "GraphMatrix number "+ idGraph + " nbNode "+nbNode;
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
        
        /*reallocation of matrix */
        if(numNextNode == maxMat)/*if we add a new not allowed node*/
        {
            Edge[][] Nedge = new Edge[nbNode][nbNode];
            for( int i=0;i<maxMat;++i)
             {
                for(int j = 0; j<maxMat; ++j)
                {
                Nedge[i][j]= edge[i][j];
                }
            }
            edge = Nedge;
            maxMat++;
        }
        
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
        for(int i=0;i<maxMat;i++)
        {
            edge[numNode][i]=null;
        }
        if(numNextNode >numNode)
        {
            numNextNode = numNode;
        }
        node.remove(s);
        nbNode--;
    }
    
    @Override
    public void addArc(Node s1, Node s2, int weight) throws ArcException {
        
        if(s1 == null || s2 == null)
        {
            throw new ArcException("arc not add, node null");
        }
        Edge nEdge = new Edge();
        nEdge.setNodeA(s1.getNodeNum());
        nEdge.setNodeB(s2.getNodeNum());
        nEdge.setWeight(weight);
        edge[s1.getNodeNum()][s2.getNodeNum()] =nEdge; 
    }
    
    
    public Edge[][] getEdge() {  
        return this.edge;
    }

}
