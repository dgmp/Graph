/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.modelgraph;

import generated.*;
import graph.exception.ArcException;
import graph.exception.NodeException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jemorgon1
 */
public class ModelManager implements InterfaceManager {
    private static ModelManager instance = null;
    private HashMap GList;
    private  int nbGraph;
    private ModelManager() {
        GList = new HashMap();
        nbGraph = 0;
    }
    
    public static ModelManager getInstance() {
        if(instance==null)
        {
            return instance= new ModelManager();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "ModelManager{" +  ", nbGraph=" + GList.size() + '}';
    }

    @Override
    public boolean createGraph(boolean matrix, String name)
    {   Graph g;
        g = null;
        nbGraph++;
        if(matrix)
        {
            g = new GraphMatrix(name,nbGraph);
        }
        else
        {
            g= new GraphList(name,nbGraph);
        }
       
        GList.put(nbGraph,g); 
        
        return true; 
    }

    @Override
    public boolean deleteGraph(int idGraph) {
         GList.remove(idGraph);
         return true;
    }
    
    @Override
    public Graph get(int idGraph) {
        return (Graph) GList.get(idGraph);
    }
    
    @Override
    public boolean addNode(int idGraph, String label) {
        
        Node s = new Node();
        s.setName(label);
        Graph g =(Graph) GList.get(idGraph);
        try {
            g.add(s);
        } catch (NodeException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    @Override
    public boolean deleteNode(int idGraph, String label) {
        
        Graph g =(Graph) GList.get(idGraph);
        Node n =  g.getNode(label);
        try {
            g.delete(n);
        } catch (NodeException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean addArc(int idGraph, String labelNode1, String labelNode2, int weight) {
        Graph g = (Graph)GList.get(idGraph);
        Node s1 = g.getNode(labelNode1);
        Node s2 = g.getNode(labelNode2);
        try {
            g.addArc(s1, s2, weight);
        } catch (ArcException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteArc(int idGraph, int idArc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addEdge(int idGraph, String labelNode1, String labelNode2, int weight) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteEdge(int idGraph, int idEdge) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean marshalling(int idGraph) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean unMarshalling(String file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }  
}
