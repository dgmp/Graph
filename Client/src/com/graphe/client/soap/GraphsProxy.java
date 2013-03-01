package com.graphe.client.soap;

public class GraphsProxy implements com.graphe.client.soap.Graphs {
  private String _endpoint = null;
  private com.graphe.client.soap.Graphs graphsSOAP = null;
  
  public GraphsProxy() {
    _initGraphsSOAPProxy();
  }
  
  public GraphsProxy(String endpoint) {
    _endpoint = endpoint;
    _initGraphsSOAPProxy();
  }
  
  private void _initGraphsSOAPProxy() {
    try {
      graphsSOAP = (new com.graphe.client.soap.GraphsServiceLocator()).getGraphsSOAP();
      if (graphsSOAP != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)graphsSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)graphsSOAP)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (graphsSOAP != null)
      ((javax.xml.rpc.Stub)graphsSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.graphe.client.soap.Graphs getGraphsSOAP() {
    if (graphsSOAP == null)
      _initGraphsSOAPProxy();
    return graphsSOAP;
  }
  
  public boolean addEdge(int idGraph, java.lang.String labelNode1, java.lang.String labelNode2, int weight) throws java.rmi.RemoteException{
    if (graphsSOAP == null)
      _initGraphsSOAPProxy();
    return graphsSOAP.addEdge(idGraph, labelNode1, labelNode2, weight);
  }
  
  public java.lang.String test() throws java.rmi.RemoteException{
    if (graphsSOAP == null)
      _initGraphsSOAPProxy();
    return graphsSOAP.test();
  }
  
  public boolean createGraph(boolean matrix, java.lang.String name) throws java.rmi.RemoteException{
    if (graphsSOAP == null)
      _initGraphsSOAPProxy();
    return graphsSOAP.createGraph(matrix, name);
  }
  
  public boolean addNode(int idGraph, java.lang.String label) throws java.rmi.RemoteException{
    if (graphsSOAP == null)
      _initGraphsSOAPProxy();
    return graphsSOAP.addNode(idGraph, label);
  }
  
  public boolean deleteGraph(int idGraph) throws java.rmi.RemoteException{
    if (graphsSOAP == null)
      _initGraphsSOAPProxy();
    return graphsSOAP.deleteGraph(idGraph);
  }
  
  public boolean deleteNode(int idGraph, java.lang.String label) throws java.rmi.RemoteException{
    if (graphsSOAP == null)
      _initGraphsSOAPProxy();
    return graphsSOAP.deleteNode(idGraph, label);
  }
  
  public boolean addArc(int idGraph, java.lang.String labelNode1, java.lang.String labelNode2, int weight) throws java.rmi.RemoteException{
    if (graphsSOAP == null)
      _initGraphsSOAPProxy();
    return graphsSOAP.addArc(idGraph, labelNode1, labelNode2, weight);
  }
  
  public boolean unMarshalling(java.lang.String file) throws java.rmi.RemoteException{
    if (graphsSOAP == null)
      _initGraphsSOAPProxy();
    return graphsSOAP.unMarshalling(file);
  }
  
  public boolean deleteArc(int idGraph, int idArc) throws java.rmi.RemoteException{
    if (graphsSOAP == null)
      _initGraphsSOAPProxy();
    return graphsSOAP.deleteArc(idGraph, idArc);
  }
  
  public boolean deleteEdge(int idGraph, int idEdge) throws java.rmi.RemoteException{
    if (graphsSOAP == null)
      _initGraphsSOAPProxy();
    return graphsSOAP.deleteEdge(idGraph, idEdge);
  }
  
  public boolean marshalling(int idGraph) throws java.rmi.RemoteException{
    if (graphsSOAP == null)
      _initGraphsSOAPProxy();
    return graphsSOAP.marshalling(idGraph);
  }
  
  
}