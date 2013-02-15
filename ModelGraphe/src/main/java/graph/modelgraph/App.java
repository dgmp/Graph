package graph.modelgraph;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        
        ModelManager M;
        M = ModelManager.getInstance();
        System.out.println(M.toString());
        
        M.createGraph(true, "GMat1");
        
        M.createGraph(false, "GList1");
        Graph g1 = M.get(1);
        
        M.addNode(1, "a");
        M.addNode(1,"b");
        System.out.println(g1.toString());
        M.deleteNode(1, "a");
        M.addNode(1, "c");
       
        
        
        M.addNode(2, "a");
        M.addNode(2,"b");
        System.out.println(g1.toString());
        M.deleteNode(2, "a");
        M.addNode(2, "c");
        M.addNode(2,"b");
      System.out.println(g1.toString());
        System.out.println(M.get(2).toString());
        System.out.println(M.toString());

        M.deleteGraph(1);
        System.out.println(M.toString());
    }
}
