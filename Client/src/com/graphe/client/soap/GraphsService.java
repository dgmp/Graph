
package com.graphe.client.soap;

public interface GraphsService extends javax.xml.rpc.Service {
    public java.lang.String getGraphsSOAPAddress();

    public com.graphe.client.soap.Graphs getGraphsSOAP() throws javax.xml.rpc.ServiceException;

    public com.graphe.client.soap.Graphs getGraphsSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
