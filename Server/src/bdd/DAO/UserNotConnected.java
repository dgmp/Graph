package bdd.DAO;

import java.io.FileInputStream;
import java.util.List;

import bdd.GraphProjectModel.*;


public interface UserNotConnected
{
	// Acceder aux graphes public
	public List<Graph> getGraphsPublic();
	// Importer Graphes public
	public FileInputStream importGraphPublic(String id);
	// Creer un compte
	public void createAccount(String identifiant, String password, String name, String firstName);
}
