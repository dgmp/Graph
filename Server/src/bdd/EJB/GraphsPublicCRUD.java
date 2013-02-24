package bdd.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bdd.GraphProjectModel.*;

/**
 * Session Bean implementation class GraphsPublicCRUD
 */
@Stateless
public class GraphsPublicCRUD {

	@PersistenceContext(unitName="GraphProjectModel")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public GraphsPublicCRUD() {
        // TODO Auto-generated constructor stub
    }
    
    public void create(GraphsPublic graph)
    {
    	em.persist(graph);
    }
    
    public void remove(GraphsPublic graph)
    {
    	em.remove(em.merge(graph));
    }
    
    public void update(GraphsPublic graph)
    {
    	em.merge(graph);
    }
    
    public GraphsPublic getPublicGraphs()
    {
    	Query query = em.createQuery("Select g from GraphsPublic g");
    	GraphsPublic graphPublic = GraphsPublic.getInstance();
    	
    	List<String> rs = query.getResultList();
    	GraphCRUD graphCRUD = new GraphCRUD();
    	
    	for( String id : rs )
    	{
    		Graph graph = graphCRUD.find(id);
    		graphPublic.addGraph(graph);
    	}
    	
    	return graphPublic;
    }

}
