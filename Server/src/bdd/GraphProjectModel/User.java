package bdd.GraphProjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.String;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Users")
public class User implements Serializable {

	   
	@Id
	private String idUser;
	private byte[] password;
	private String name;
	private String firstName;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	@JoinTable( name="contacts",
				joinColumns={ @JoinColumn(name="idContact") },
				inverseJoinColumns={ @JoinColumn(name="idUser") }
				)
	private transient List<User> contacts;
	
	@ManyToMany
	@JoinTable( name="GraphsUser",
				joinColumns={ @JoinColumn(name="idUser") }, 
				inverseJoinColumns={ @JoinColumn(name="idGraph")}
				)
	private transient List<Graph> graphs;
	
	@OneToMany
	@JoinTable( name="folders", 
				joinColumns={ @JoinColumn(name="idUser") },
				inverseJoinColumns={ @JoinColumn(name="idFolder") }
				)
	private transient List<Folder> folders;
	
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
	
	
	public User() {
		super();
		contacts = new ArrayList<User>();
		folders = new ArrayList<Folder>();
	} 
	
	public User(String id, String password, String name, String firstName)
	{
		super();
		setId(id);
		setPassword(password);
		setName(name);
		setFirstName(firstName);
		
		File folder = new File( "../GraphUsers/"+getId() );
		folder.mkdirs();
		
		contacts = new ArrayList<User>();
		folders = new ArrayList<Folder>();
	}
	
	public String getId() {
		return this.idUser;
	}

	public void setId(String id) {
		this.idUser = id;
	}  
	
	public byte[] getPassword() {
		return this.password;
	}

	public void setPassword(String password) 
	{
		this.password = getEncodePassword(password);
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void addContact( User user)
	{
		contacts.add(user);
	}
	
	public List<User> getContacts()
	{
		return contacts;
	}
	
	public User getContact(String name, String firstName )
	{
		for( User u : contacts )
			if( u.getName() == name && u.getFirstName() == firstName )
				return u;
		return null;
	}
	
	public User getContactById( String identifiant )
	{
		for( User u : contacts )
			if( u.getId() == identifiant )
				return u;
		return null;
	}
	
	public List<User> getConctactsByName(String name)
	{
		List<User> tmp = new ArrayList<User>();
		
		for( User u : contacts )
			if( u.getName() == name )
				tmp.add(u);
				
		return tmp;
	}
	
	public List<User> getContactsByFisrtName(String firstName)
	{
		List<User> tmp = new ArrayList<User>();
		
		for( User u : contacts )
			if( u.getFirstName() == firstName )
				tmp.add(u);
				
		return tmp;
	}
	
	public void removeContact(String identifiant)
	{
		for( User u : contacts )
			if( u.getId() == identifiant )
				contacts.remove(u);
	}
	
	public void createGraph( String name, FileInputStream file  ) throws IOException
	{ 
		Graph graph = new Graph(name, this, file);
		graphs.add(graph);
	}
	
	public void deleteGraph( String idGraph )
	{
		for( Graph graph : graphs )
			if( graph.getIdGraph() == idGraph )
			{
				graphs.remove(graph);
				if( graph.getCreator() == this )
					graph.delete();
			}
	}
	
	public List<Graph> getGraphs()
	{
		return graphs;
	}
	
	public void addGraph( Graph graph )
	{
		if( ! graphs.contains(graph) )
		{
			graphs.add(graph);
			graph.addUsers(this);
		}
	}
	
	public Graph getGraph( String idGraph )
	{
		for( Graph graph : graphs )
			if( graph.getIdGraph() == idGraph )
				return graph;
				
		return null;
	}
	
	public void removeGraph( Graph graph )
	{
		if( graphs.contains(graph) )
		{
			graphs.remove(graph);
			graph.removeUser(this);
		}
	}
	
	public void shareGraph(String idUser, String idGraph)
	{
		User contact = getContactById(idUser);
		Graph graph = getGraph(idGraph);
		
		shareGraph(contact, graph);
	}
	
	public void shareGraph(User contact, Graph graph)
	{
		// on partage que le graphe qu'on a creer
		if( contact != null && graph != null && graph.getCreator() == this )
		{
			contact.addGraph(graph);
			graph.addUsers(contact);
		}
	}
	
	public void makePublicGraph( String idGraph )
	{
		Graph graph = getGraph(idGraph);
		if( graph != null )
			GraphsPublic.getInstance().addGraph(graph);
	}
	
	public void CreateFolder( String name )
	{
		folders.add( new Folder(name, this) );
	}
	
	public Folder getFolder( String name )
	{
		for( Folder f : folders )
			if( f.getName() == name )
				return f;
				
		return null;
	}
	
	public void removeFolder( String name )
	{
		Folder folder = getFolder(name);
		
		if( folder != null )
			folders.remove(folder);
	}
	
	public void addGraphToFolder( String folderName, String idGraph )
	{
		Folder folder = getFolder(folderName);
		Graph graph = getGraph(idGraph);
		
		if( folder != null && graph != null )
			folder.addGraph(graph);
	}
}
