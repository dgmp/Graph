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
      System.out.println(g1.toString());
        System.out.println(M.get(2).toString());
        System.out.println(M.toString());

        M.deleteGraph(1);
        System.out.println(M.toString());
    }
}
