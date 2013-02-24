package bdd.GraphProjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="graphs")
public class Graph implements Serializable {

	   
	@Id
	private String idGraph;
	private String name;
	private String pathName;
	@Temporal( TemporalType.DATE)
	private Date dateCreation;
	@OneToOne
	@PrimaryKeyJoinColumn
	private User idCreator;
	
	// utilisateurs qui peuvent acceder a ce graphe
	@ManyToMany
	@JoinTable( name="GraphsUser",
				joinColumns={ @JoinColumn(name="idGraph") }, 
				inverseJoinColumns={ @JoinColumn(name="idUser")}
				)
	private transient List<User> users;
	
	private static final long serialVersionUID = 1L;

	public Graph(String name, User creator, FileInputStream file ) throws IOException
	{
		super();
		setIdGraph(creator.getId() + name);
		setIdGraph(creator.getId() + name);
		setName(name);
		setPathName("../GraphUsers/" + name);
		setDateCreation(new Date() );
		this.idCreator = creator;
		
		FileOutputStream out = new FileOutputStream( getPathName() );

		byte[] buffer = new byte[512 * 1024];
		int nbLu;
		while( (nbLu = file.read(buffer) ) > 0 )
		{
			out.write(buffer, 0, nbLu);
		}
	}
	
	public Graph() {
		super();
	}
	
	public void delete()
	{
		// suppression du fichier sur le disque
		File file = new File( getPathName() );
		file.delete();
		
		// on retire le graph de tous les utilisateurs
		for( User u : users )
			u.removeGraph(this);
	}
	
	public String getIdGraph() {
		return this.idGraph;
	}

	public void setIdGraph(String idGraph) {
		this.idGraph = idGraph;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPathName() {
		return this.pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}  
	
	public User getCreator() {
		return this.idCreator;
	}
	
	public void addUsers(User user)
	{
		if( ! users.contains(user) )
		{
			users.add(user);
			user.addGraph(this);
		}
	}
	
	public void removeUser(User user)
	{
		if( users.contains(user) )
		{
			users.remove(user);
			user.removeGraph(this);
		}
	}
	
	public FileInputStream getFile() throws FileNotFoundException
	{
		return new FileInputStream(getPathName());
	}
}
