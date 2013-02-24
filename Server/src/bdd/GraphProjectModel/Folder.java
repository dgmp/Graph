package bdd.GraphProjectModel;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Folders")
public class Folder implements Serializable {

	   
	@Id
	private String idFolder;
	@OneToOne
	@PrimaryKeyJoinColumn
	private User idUser;
	private String name;
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	@JoinTable( name="GraphsFolder",
				joinColumns={ @JoinColumn(name="idFolder") }, 
				inverseJoinColumns={ @JoinColumn(name="idGraph")}
				)
	private transient List<Graph> graphs;

	public Folder() {
		super();
	}
	
	public Folder( String name, User user)
	{
		super();
		setIdFolder(user.getId() + name);
		setIdUser(user);
		setName(name);
	}
	
	public String getIdFolder() {
		return this.idFolder;
	}

	public void setIdFolder(String idFolder) {
		this.idFolder = idFolder;
	}
	
	public User getIdUser() {
		return this.idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addGraph(Graph graph)
	{
		graphs.add(graph);
	}
	
	public List<Graph> getGraphs()
	{
		return graphs;
	}
   
}
