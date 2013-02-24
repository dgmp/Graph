package bdd.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import bdd.GraphProjectModel.*;


public interface UserConnected 
{
	// Se connecter
	public void connection(String identifiant, String password);
	
	// Modifier son compte
	public void setPassword(String password);
	public void setName(String name);
	public void setFirstName(String firstName);
	
	// Acceder a ses graphes
	public List<Graph> getGraphs();
	
	// Importer son Graphe
	public FileInputStream importGraph(String id) throws FileNotFoundException;
	
	// Supprimer son graphe
	public void removeGraph(String id);
	
	// Partager son graphe
	public void shareGraph(String idUser, String idGraph);
	
	// Rendre public un graphe
	public void makePublicGraph(String id);
	
	// Ajouter des contacts
	public void addContact(String id);
	
	// Acceder a ses contacts
	public List<User> getAllContact();
	
	// Recupere un contact
	public User getContact(String id);
}
