/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.modelgraph;

import graph.exception.NodeException;
import generated.*;
import java.util.List;

/**
 *
 * @author jemorgon1
 */
public class ModelManager implements GraphCRUD {
    
    private ModelManager() {
    }
    
    public static ModelManager getInstance() {
        if(instance==null)
        {
            return instance= new ModelManager();
        }
        return instance;
    }

    
    private static ModelManager instance = null;
    private Graph G = null;

    @Override
    public boolean arete(Node s1, Node s2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int degre(Node s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(Node s) throws NodeException {
        throw new UnsupportedOperationException("Not supported yet.");
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
}
