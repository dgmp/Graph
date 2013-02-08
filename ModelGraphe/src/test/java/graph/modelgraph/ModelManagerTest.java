/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.modelgraph;

import generated.Node;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author jemorgon1
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
       // ModelManager expResult = null;
        ModelManager result = ModelManager.getInstance();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of arete method, of class ModelManager.
     */
    public void testArete() {
        System.out.println("arete");
        Node s1 = null;
        Node s2 = null;
        ModelManager instance = null;
        boolean expResult = false;
        boolean result = instance.arete(s1, s2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of degre method, of class ModelManager.
     */
    public void testDegre() {
        System.out.println("degre");
        Node s = null;
        ModelManager instance = null;
        int expResult = 0;
        int result = instance.degre(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class ModelManager.
     */
    public void testAdd() throws Exception {
        System.out.println("add");
        Node s = null;
        ModelManager instance = null;
        instance.add(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ModelManager.
     */
    public void testDelete() throws Exception {
        System.out.println("delete");
        Node s = null;
        ModelManager instance = null;
        instance.delete(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addArc method, of class ModelManager.
     */
    public void testAddArc() throws Exception {
        System.out.println("addArc");
        Node s1 = null;
        Node s2 = null;
        int poid = 0;
        ModelManager instance = null;
        instance.addArc(s1, s2, poid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteArc method, of class ModelManager.
     */
    public void testDeleteArc() throws Exception {
        System.out.println("deleteArc");
        Node s1 = null;
        Node s2 = null;
        ModelManager instance = null;
        instance.deleteArc(s1, s2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEdge method, of class ModelManager.
     */
    public void testAddEdge() throws Exception {
        System.out.println("addEdge");
        Node s1 = null;
        Node s2 = null;
        int poid = 0;
        ModelManager instance = null;
        instance.addEdge(s1, s2, poid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEdge method, of class ModelManager.
     */
    public void testDeleteEdge() throws Exception {
        System.out.println("deleteEdge");
        Node s1 = null;
        Node s2 = null;
        ModelManager instance = null;
        instance.deleteEdge(s1, s2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adjacentsNode method, of class ModelManager.
     */
    public void testAdjacentsNode() {
        System.out.println("adjacentsNode");
        Node s = null;
        ModelManager instance = null;
        List expResult = null;
        List result = instance.adjacentsNode(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
