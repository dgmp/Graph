/*__________________________________________________________*/

package soap;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "GraphsSOAP")
public class GraphsSOAP
{
	@WebMethod(operationName = "createGraph")
	public boolean createGraph(boolean matrix, String name)
	{
		return true;
	}
	
	@WebMethod(operationName = "deleteGraph")
    public boolean deleteGraph(int idGraph)
    {
    	return true;
    }
    
//    public Graph get(int idGraph)
//    {
//    	return true;
//    }
//    
	@WebMethod(operationName = "addNode")
    public boolean addNode(int idGraph,String label)
    {
    	return true;
    }
    
	@WebMethod(operationName = "deleteNode")
    public boolean deleteNode(int idGraph,String label)
    {
    	return true;
    }
    
	@WebMethod(operationName = "addArc")
    public boolean addArc(int idGraph,String labelNode1,String labelNode2,int weight)
    {
    	return true;
    }
    
	@WebMethod(operationName = "deleteArc")
    public boolean deleteArc(int idGraph,int idArc)
    {
    	return true;
    }
    
	@WebMethod(operationName = "addEdge")
    public boolean addEdge(int idGraph,String labelNode1,String labelNode2,int weight)
    {
    	return true;
    }
    
	@WebMethod(operationName = "deleteEdge")
    public boolean deleteEdge(int idGraph,int idEdge)
    {
    	return true;
    }
	
	@WebMethod(operationName = "marshalling")
    public boolean marshalling(int idGraph)
    {
    	return true;
    }
    
	@WebMethod(operationName = "unMarshalling")
    public boolean unMarshalling(String file)
    {
    	return true;
    }
    
	@WebMethod(operationName = "test")
    public String test()
    {
    	return new Date().toString();
    }

}

/*__________________________________________________________*/
/*   Fin du fichier GraphsSOAP.java
/*__________________________________________________________*/