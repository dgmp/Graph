package bdd.GraphProjectModel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="GraphsPublic")
public class GraphsPublic implements Serializable {

	@Id	
	@OneToMany
	@JoinColumn(name="Graphs", referencedColumnName="idGraph")
	private List<Graph> idGraph;
	private static final long serialVersionUID = 1L;

	@Transient
	private static GraphsPublic INSTANCE = null;
	
	public static GraphsPublic getInstance()
	{
		if( INSTANCE == null )
		{
			INSTANCE = new GraphsPublic();
		}
		
		return INSTANCE;
	}
	
	protected GraphsPublic() {
		super();
	}

	public void addGraph(Graph graph) {
		if( ! idGraph.contains(graph) )
			this.idGraph.add(graph);
	}
	
	public List<Graph> getGraphs()
	{
		return idGraph;		
	}
	
	public Graph getGraph(String id)
	{
		for( Graph graph : idGraph )
			if( graph.getIdGraph() == id )
				return graph;
				
		return null;
	}
   
}
