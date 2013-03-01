
package com.graphe.client.soap;

public interface Graphs extends java.rmi.Remote {
    public boolean addEdge(int idGraph, java.lang.String labelNode1, java.lang.String labelNode2, int weight) throws java.rmi.RemoteException;
    public java.lang.String test() throws java.rmi.RemoteException;
    public boolean createGraph(boolean matrix, java.lang.String name) throws java.rmi.RemoteException;
    public boolean addNode(int idGraph, java.lang.String label) throws java.rmi.RemoteException;
    public boolean deleteGraph(int idGraph) throws java.rmi.RemoteException;
    public boolean deleteNode(int idGraph, java.lang.String label) throws java.rmi.RemoteException;
    public boolean addArc(int idGraph, java.lang.String labelNode1, java.lang.String labelNode2, int weight) throws java.rmi.RemoteException;
    public boolean unMarshalling(java.lang.String file) throws java.rmi.RemoteException;
    public boolean deleteArc(int idGraph, int idArc) throws java.rmi.RemoteException;
    public boolean deleteEdge(int idGraph, int idEdge) throws java.rmi.RemoteException;
    public boolean marshalling(int idGraph) throws java.rmi.RemoteException;
}
