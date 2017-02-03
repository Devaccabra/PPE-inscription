package database;

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.corba.se.pept.transport.Connection;

import inscriptions.*;

public class Bdd {

	String url = "jdbc:mysql://localhost:3306/inscriptions";
    String userid = "root";
    String password = "";
	private static Connection connexion;
	private static Statement statement;
    
    private static final long serialVersionUID = -2882150118573759729L;
    
    public void ConnexionBdd()
    {
    	try
    	{
    		Connection connexion = (Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/inscriptions" );
    		this.connexion = connexion;
    		System.out.println("vous etes connecté !");
    	}
    	catch(SQLException e)
    	{
    		System.out.println("Erreur lors de la connexion !" +e.getMessage());
    	}
    }
    
    public static void ajouterCandidat(String nom)
    {
    	try
    	{
    		Statement statement = null ;
    		
    		statement = (Statement) ((java.sql.Connection) connexion).createStatement();
    		int ajouterCandidat = ((java.sql.Statement) statement).executeUpdate( "INSERT INTO `candidat` VALUES ('"+nom+"') " );
    		if(ajouterCandidat == 1)
    		{
    			System.out.println( "Ajout du candidat réussi !" );
    		}
    		else
    		{
    			System.out.println( "Le candidat n'a pas été enregistré" );
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println( "Erreur ajout candidat : " + e.getMessage() );
    	}
    }
    
    public static void AjouterPersonne(String prenom, String mail)
    {
    	try
    	{
    		Statement statement = null;
    		statement = (Statement) ((java.sql.Connection) connexion).createStatement();
    		int ajouterPersonne = ((java.sql.Statement) statement).executeUpdate( "INSERT INTO `personne`(`id_p`, `prenom`, `mail`) VALUES ('"+prenom+"','"+mail+"') " );
    		if(ajouterPersonne == 1)
    		{
    			System.out.println("Ajout de la personne réussi !");
    		}
    		else
    		{
    			System.out.println("La personne n'a pas été enregistrée");
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println( "Erreur ajout de la personne :" + e.getMessage());
    	}
    }
}
