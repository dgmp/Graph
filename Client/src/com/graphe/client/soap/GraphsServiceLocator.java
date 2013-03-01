

package com.graphe.client.soap;

public class GraphsServiceLocator extends org.apache.axis.client.Service implements com.graphe.client.soap.GraphsService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GraphsServiceLocator() {
    }


    public GraphsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GraphsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GraphsSOAP
    private java.lang.String GraphsSOAP_address = "http://localhost:8080/Server/services/GraphsSOAP";

    public java.lang.String getGraphsSOAPAddress() {
        return GraphsSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GraphsSOAPWSDDServiceName = "GraphsSOAP";

    public java.lang.String getGraphsSOAPWSDDServiceName() {
        return GraphsSOAPWSDDServiceName;
    }

    public void setGraphsSOAPWSDDServiceName(java.lang.String name) {
        GraphsSOAPWSDDServiceName = name;
    }

    public com.graphe.client.soap.Graphs getGraphsSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GraphsSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGraphsSOAP(endpoint);
    }

    public com.graphe.client.soap.Graphs getGraphsSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.graphe.client.soap.GraphsSoapBindingStub _stub = new com.graphe.client.soap.GraphsSoapBindingStub(portAddress, this);
            _stub.setPortName(getGraphsSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGraphsSOAPEndpointAddress(java.lang.String address) {
        GraphsSOAP_address = address;
    }

    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.graphe.client.soap.Graphs.class.isAssignableFrom(serviceEndpointInterface)) {
                com.graphe.client.soap.GraphsSoapBindingStub _stub = new com.graphe.client.soap.GraphsSoapBindingStub(new java.net.URL(GraphsSOAP_address), this);
                _stub.setPortName(getGraphsSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("GraphsSOAP".equals(inputPortName)) {
            return getGraphsSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.graphes.com", "GraphsSOAPService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.graphes.com", "GraphsSOAP"));
        }
        return ports.iterator();
    }

    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GraphsSOAP".equals(portName)) {
            setGraphsSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
