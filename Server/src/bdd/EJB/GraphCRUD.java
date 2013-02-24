package bdd.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bdd.GraphProjectModel.*;

/**
 * Session Bean implementation class GraphCRUD
 */
@Stateless
public class GraphCRUD {

	@PersistenceContext(unitName="GraphProjectModel")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public GraphCRUD() {
        // TODO Auto-generated constructor stub
    }
    
    public void create(Graph graph)
    {
    	em.persist(graph);
    }
    
    public void remove(Graph graph)
    {
    	em.remove(em.merge(graph));
    }
    
    public void update(Graph graph)
    {
    	em.merge(graph);
    }
    
	public List<Graph> findAll()
    {
    	Query query = em.createQuery("Select g from Graphs g");
    	return (List<Graph>)query.getResultList();
    }
    
    public Graph find(String id)
    {
    	Query query = em.createQuery("Select g from Graphs g where u.idGraph='" + id + "'");
    	return (Graph)query.getSingleResult();
    }

}
