/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.modelgraph;

/**
 *
 * @author Hyruga
 */
public interface InterfaceManager {
    public boolean createGraph(boolean matrix, String name);
    public boolean deleteGrpah(int idGraph);
    public boolean addNode(int idGraph,String label);
    public boolean deleteNode(int idGraph,String label);
    public boolean addArc(int idGraph,String labelNode1,String labelNode2,int weight);
    public boolean deleteArc(int idGraph,int idArc);
    public boolean addEdge(int idGraph,String labelNode1,String labelNode2,int weight);
    public boolean deleteEdge(int idGraph,int idEdge);
    public boolean marshalling(int idGraph);
    public boolean unMarshalling(String file);    
}
