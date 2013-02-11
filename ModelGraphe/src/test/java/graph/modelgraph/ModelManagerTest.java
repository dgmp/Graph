/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.modelgraph;

import junit.framework.TestCase;

/**
 *
 * @author Hyruga
 */
public class ModelManagerTest extends TestCase {
    
    public ModelManagerTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getInstance method, of class ModelManager.
     */
    public void testGetInstance() {
        System.out.println("getInstance");
        ModelManager expResult = null;
        ModelManager result = ModelManager.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createGraph method, of class ModelManager.
     */
    public void testCreateGraph() {
        System.out.println("createGraph");
        boolean matrix = false;
        String name = "";
        ModelManager instance = null;
        boolean expResult = false;
        boolean result = instance.createGraph(matrix, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteGrpah method, of class ModelManager.
     */
    public void testDeleteGraph() {
        System.out.println("deleteGrpah");
        int idGraph = 0;
        ModelManager instance = null;
        boolean expResult = false;
        boolean result = instance.deleteGraph(idGraph);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNode method, of class ModelManager.
     */
    public void testAddNode() {
        System.out.println("addNode");
        int idGraph = 0;
        String label = "";
        ModelManager instance = null;
        boolean expResult = false;
        boolean result = instance.addNode(idGraph, label);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteNode method, of class ModelManager.
     */
    public void testDeleteNode() {
        System.out.println("deleteNode");
        int idGraph = 0;
        String label = "";
        ModelManager instance = null;
        boolean expResult = false;
        boolean result = instance.deleteNode(idGraph, label);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addArc method, of class ModelManager.
     */
    public void testAddArc() {
        System.out.println("addArc");
        int idGraph = 0;
        String labelNode1 = "";
        String labelNode2 = "";
        int weight = 0;
        ModelManager instance = null;
        boolean expResult = false;
        boolean result = instance.addArc(idGraph, labelNode1, labelNode2, weight);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteArc method, of class ModelManager.
     */
    public void testDeleteArc() {
        System.out.println("deleteArc");
        int idGraph = 0;
        int idArc = 0;
        ModelManager instance = null;
        boolean expResult = false;
        boolean result = instance.deleteArc(idGraph, idArc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEdge method, of class ModelManager.
     */
    public void testAddEdge() {
        System.out.println("addEdge");
        int idGraph = 0;
        String labelNode1 = "";
        String labelNode2 = "";
        int weight = 0;
        ModelManager instance = null;
        boolean expResult = false;
        boolean result = instance.addEdge(idGraph, labelNode1, labelNode2, weight);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEdge method, of class ModelManager.
     */
    public void testDeleteEdge() {
        System.out.println("deleteEdge");
        int idGraph = 0;
        int idEdge = 0;
        ModelManager instance = null;
        boolean expResult = false;
        boolean result = instance.deleteEdge(idGraph, idEdge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of marshaling method, of class ModelManager.
     */
    public void testMarshaling() {
        System.out.println("marshaling");
        int idGraph = 0;
        ModelManager instance = null;
        boolean expResult = false;
        boolean result = instance.marshalling(idGraph);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
