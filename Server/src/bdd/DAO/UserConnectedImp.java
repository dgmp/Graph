package bdd.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import bdd.EJB.GraphCRUD;
import bdd.EJB.GraphsPublicCRUD;
import bdd.EJB.UserCRUD;
import bdd.GraphProjectException.GraphException;
import bdd.GraphProjectModel.Graph;
import bdd.GraphProjectModel.GraphsPublic;
import bdd.GraphProjectModel.User;

/**
 * Session Bean implementation class UserConnectedImp
 */
@Stateful(name="userConnected", mappedName="ejb/userConnected")
@LocalBean
public class UserConnectedImp implements UserConnected
{
	private User user = null;
	
	private byte[] getEncodePassword( String password )
	{
		byte[] key = password.getBytes();
		byte[] hash = null;
		
		try
		{
			hash = MessageDigest.getInstance("SHA1").digest(key);
		}
		catch( NoSuchAlgorithmException e)
		{
			throw new Error("no SHA1 support in this VM");
		}
		
		return hash;
	}
	
	// Se connecter
	public void connection(String identifiant, String password)
	{
		UserCRUD crud = new UserCRUD();
		User tmp = crud.find(identifiant);
		
		if( tmp != null )
			if( tmp.getPassword() == getEncodePassword(password) )
				user = tmp;
			else
				throw new GraphException(1, "erreur : Mot de passe incorrect");
		else
			throw new GraphException(2, "erreur : Identifiant incorrect");
	}
	
	// Modifier son compte
	public void setPassword(String password)
	{
		if( user != null )
		{
			user.setPassword(password);
			UserCRUD crud = new UserCRUD();
			crud.update(user);
		}
		else
			throw new GraphException(0, "erreur : non connect�");
	}
	
	public void setName(String name)
	{
		if( user != null )
		{
			user.setName(name);
			UserCRUD crud = new UserCRUD();
			crud.update(user);
		}
		else
			throw new GraphException(0, "erreur : non connect�");
	}
	
	public void setFirstName(String firstName)
	{
		if( user != null )
		{
			user.setFirstName(firstName);
			UserCRUD crud = new UserCRUD();
			crud.update(user);
		}
		else
			throw new GraphException(0, "erreur : non connect�");	
	}
	
	// Acceder a ses graphes
	public List<Graph> getGraphs()
	{
		if( user != null )
			return user.getGraphs();
		else
			throw new GraphException(0, "erreur : non connect�");
	}
	
	// Importer son Graphe
	public FileInputStream importGraph(String id) throws FileNotFoundException
	{
		if( user != null )
			return user.getGraph(id).getFile();
		else
			throw new GraphException(0, "erreur : non connect�");
	}
	
	// Supprimer son graphe
	public void removeGraph(String id)
	{
		if( user != null )
		{
			GraphCRUD graphCrud = new GraphCRUD();
			Graph graph = graphCrud.find(id);
			if( graph != null )
			{
				user.removeGraph(graph);
				graphCrud.remove(graph);
				UserCRUD userCrud = new UserCRUD();
				userCrud.update(user);
			}
		}
		else
			throw new GraphException(0, "erreur : non connect�");
	}
	
	// Partager son graphe
	public void shareGraph(String idUser, String idGraph)
	{
		if( user != null )
		{
			GraphCRUD graphCrud = new GraphCRUD();
			Graph graph = graphCrud.find(idGraph);
			UserCRUD userCrud = new UserCRUD();
			User contact = userCrud.find(idUser);
			
			if( contact != null && graph != null )
			{
				user.shareGraph(contact, graph);
				
				userCrud.update(contact);
				graphCrud.update(graph);
			}
		}
		else
			throw new GraphException(0, "erreur : non connect�");
	}
	
	// Rendre public un graphe
	public void makePublicGraph(String id)
	{
		if( user != null )
		{
			GraphCRUD graphCrud = new GraphCRUD();
			Graph graph = graphCrud.find(id);
			
			if( graph != null )
			{
				user.makePublicGraph(graph.getIdGraph());
				GraphsPublicCRUD crud = new GraphsPublicCRUD();
				crud.update(GraphsPublic.getInstance());
			}
		}
		else
			throw new GraphException(0, "erreur : non connect�");
	}
	
	// Ajouter des contacts
	public void addContact(String id)
	{
		if( user != null )
		{
			UserCRUD userCrud = new UserCRUD();
			User contact = userCrud.find(id);
			
			if( contact != null )
			{
				user.addContact(contact);
				userCrud.update(user);
			}
		}
		else
			throw new GraphException(0, "erreur : non connect�");
	}
	
	// Acceder a ses contacts
	public List<User> getAllContact()
	{
		if( user != null )
		{
			return user.getContacts();
		}
		else
			throw new GraphException(0, "erreur : non connect�");
	}
	
	// Recupere un contact
	public User getContact(String id)
	{
		if( user != null )
		{
			return user.getContactById(id);
		}
		else
			throw new GraphException(0, "erreur : non connect�");
	}
}
