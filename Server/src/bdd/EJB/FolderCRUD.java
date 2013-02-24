package bdd.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bdd.GraphProjectModel.*;

/**
 * Session Bean implementation class FolderCRUD
 */
@Stateless
public class FolderCRUD {

	@PersistenceContext(unitName="GraphProjectModel")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public FolderCRUD() {
        // TODO Auto-generated constructor stub
    }
    
    public void create(Folder folder)
    {
    	em.persist(folder);
    }
    
    public void remove(Folder folder)
    {
    	em.remove(em.merge(folder));
    }
    
    public void update(Folder folder)
    {
    	em.merge(folder);
    }
    
	public List<Folder> findAll()
    {
    	Query query = em.createQuery("Select f from Folders f");
    	return (List<Folder>)query.getResultList();
    }
    
    public Folder find(String id)
    {
    	Query query = em.createQuery("Select f from Folders f where u.idFolder='" + id + "'");
    	return (Folder)query.getSingleResult();
    }

}
