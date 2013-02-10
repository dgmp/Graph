/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.modelgraph;

import generated.*;
import graph.exception.ArcException;
import graph.exception.NodeException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jemorgon1
 */
public class ModelManager implements InterfaceManager {
    
    private ModelManager() {
        GList = new LinkedList<>();
        nbGraph = 0;
        
    }
    
    public static ModelManager getInstance() {
        if(instance==null)
        {
            return instance= new ModelManager();
        }
        return instance;
    }

    
    private static ModelManager instance = null;
    private List<Graph> GList = null;
    private  int nbGraph;
    
    @Override
    public boolean createGraph(boolean matrix, String name)
    {   Graph g;
    
        if(matrix)
        {
            
            g = new GraphMatrix(name,nbGraph);
        }
        else
        {
            g= new GraphList(name,nbGraph);
        }
        nbGraph++;
        GList.add(g); 
        
        return true;
        
    }

    @Override
    public boolean deleteGrpah(int idGraph) {
         GList.remove(idGraph);
         return true;
    }
    @Override
    public boolean addNode(int idGraph, String label) {
        
        Node s = new Node();
        s.setName(label);
        Graph g = GList.get(idGraph);
        try {
            g.add(s);
        } catch (NodeException ex) {
            Logger.getLogger(ModelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean deleteNode(int idGraph, String label) {
        return false;
    }

    @Override
    public boolean addArc(int idGraph, String labelNode1, String labelNode2, int weight) {
        Graph g = GList.get(idGraph);
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
