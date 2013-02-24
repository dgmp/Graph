package bdd.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import bdd.EJB.GraphsPublicCRUD;
import bdd.EJB.UserCRUD;
import bdd.GraphProjectModel.*;

/**
 * Session Bean implementation class UserNotConnectedImp
 */
@Stateless(name="userNotConnected", mappedName="ejb/userNotConnected")
@LocalBean
public class UserNotConnectedImp 
{

    	// Acceder aux graphes public
    	public List<Graph> getGraphsPublic()
    	{
    		GraphsPublicCRUD crud = new GraphsPublicCRUD();
    		
    		GraphsPublic graphsPublic = crud.getPublicGraphs();
    		
    		return graphsPublic.getGraphs();
    	}
    	
    	// Importer Graphes public
    	public FileInputStream importGraph(String id) throws FileNotFoundException
    	{
			GraphsPublicCRUD crud = new GraphsPublicCRUD();
    		
    		GraphsPublic graphsPublic = crud.getPublicGraphs();
    		
    		Graph graph = graphsPublic.getGraph(id);
    		
    		if( graph != null )
    			return graph.getFile();
    		
    		return null;
    	}
    	
    	// Creer un compte
    	public void createAccount(String identifiant, String password, String name, String firstName)
    	{
    		User user = new User(identifiant, password, name, firstName);
    		
    		UserCRUD crud = new UserCRUD();
    		crud.create(user);
    	}

}
