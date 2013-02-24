package bdd.EJB;

import java.util.List;

import bdd.GraphProjectModel.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class UserCRUD
 */
@Stateless
public class UserCRUD 
{
	@PersistenceContext(unitName="GraphProjectModel")
	private EntityManager em;
	/**
     * Default constructor. 
     */
    public UserCRUD() {
        // TODO Auto-generated constructor stub
    }
    
    public void create(User user)
    {
    	em.persist(user);
    }
    
    public void remove(User user)
    {
    	em.remove(em.merge(user));
    }
    
    public void update(User user)
    {
    	em.merge(user);
    }
    
	public List<User> findAll()
    {
    	Query query = em.createQuery("Select u from Users u");
    	return (List<User>)query.getResultList();
    }
    
    public User find(String id)
    {
    	Query query = em.createQuery("Select u from Users u where u.idUser='" + id + "'");
    	return (User)query.getSingleResult();
    }

}
