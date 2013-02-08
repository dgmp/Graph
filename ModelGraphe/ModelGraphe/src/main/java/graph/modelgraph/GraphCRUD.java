/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.modelgraph;
import generated.Node;
import graph.exception.NodeException;
import java.util.List;

/**
 *
 * @author jemorgon1
 */
public interface GraphCRUD {
    public boolean arete(Node s1,Node s2);
    public int degre(Node s);
    public void add(Node s) throws NodeException;
    public void delete(Node s) throws NodeException;
    public void addArc(Node s1, Node s2, int poid)throws ArcException;
    public void deleteArc(Node s1, Node s2) throws ArcException;
    public void addEdge(Node s1, Node s2,int poid) throws AreteException;
    public void deleteEdge(Node s1 , Node s2) throws AreteException;
    public List<Node> adjacentsNode(Node s);

    public static class ArcException extends Exception {

        public ArcException() {
        }
    }

    public static class AreteException extends Exception {

        public AreteException() {
        }
    }
    
}
