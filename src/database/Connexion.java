package database;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

import inscriptions.Competition;
import inscriptions.Inscriptions;

public class Connexion {
	
	private static Connection connexion = null;
	private static Statement statement;
	private boolean interrupteur = true;
	
	public boolean getInterrupteur()
    {
          return this.interrupteur;
    }
     //
	public void initialisationBdd(Inscriptions inscription)
	{
			/*ListePersonne(inscription);
			ListeEquipe(inscription);
			ListeCompet(inscription);
			persEqui(inscription);
			listInscri(inscription);*/
		
	}
	
	public Connexion()
	{
		try
		{
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/inscriptions", "root","");
			//Connection connexion = DriverManager.getConnection("jdbc:mysql://mysql.m2l.local/dmerigou", "dmerigou","GP2dC3US");
			this.connexion = connexion;

			

			System.out.println("Connection réussi");


		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : " + e.getMessage() );
		} 
		
	}
	
	
	public static void ajouterCandidat(String nom)
	{
		try
		{
			Statement statement = null ;
			
			statement = connexion.createStatement();
			int ajoutCand = statement.executeUpdate( "INSERT INTO `candidat`(`nom`) VALUES ('"+nom+"') ");
			if(ajoutCand == 1)
			{
				System.out.println( "Ajout du candidat réussi");
			}
			else
			{
				System.out.println( "Ajout du candidat : Echec");
			}
		
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur ajout candidat : " + e.getMessage() );
		} 
	}
	
	public static void AjouterPersonne(String nom, String prenom, String mail)
	{
		
		try
		{
			Statement statement = null ;
			statement = connexion.createStatement();
			int ajoutPers = statement.executeUpdate( "INSERT INTO `personne`(`id_p`, `prenom`, `mail`) VALUES (LAST_INSERT_ID(),'"+prenom+"' ,'"+mail+"')");
			if ( ajoutPers == 1) {
	        	
	        	
	        	System.out.println("Ajout de la personne réussi" );
	        }
	        else{
	        	System.out.println("L'ajout de la personne n'a pas ete enregistré");
	        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur ajout de la personne : "
		                + e.getMessage());
		} 
		
	}
	
	
	public static void AjouterEquipe(String Nom)
	{
		try
		{
			ajouterCandidat(Nom);
			
			Statement statement = null ;
			
			statement = connexion.createStatement();
			
			int ajoutEquipe = statement.executeUpdate( "INSERT INTO composer_equipe (`id_equipe`, `id_p`) VALUES (LAST_INSERT_ID())");
	        if ( ajoutEquipe == 1) {
	        	
	        	
	        	System.out.println("Equipe créée" );
	        }
	        else{
	        	System.out.println("Echec lors de l'ajout d'une équipe");
	        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur création de l'équipe : " + e.getMessage() );
		} 
		
	}

	
	public void AjouterCompetition(String NomCompet,java.util.Date dateCompet,boolean enEquipe)
	{
		try
		{
			Statement statement = null ;
			
			

			statement = connexion.createStatement();
			int ajoutCompet = statement.executeUpdate( "INSERT INTO competition (nom,date_cloture,en_equipe) VALUES ('"+NomCompet+"','"+dateCompet+"',"+enEquipe+")");
			
	        if ( ajoutCompet == 1) {
	        	
	        	
	        	System.out.println("Compétition créée" );
	        }
	        else{
	        	System.out.println("La compétition n'a pas été créée");
	        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : " + e.getMessage() );
		} 
		
	}
	public static void modifierNomPersonne(String ancienNom, String nouveauNom)
	{
		try
		{
			Statement statement = null;
			
			statement = connexion.createStatement();
			 
			 
		        	int ModifCand = statement.executeUpdate( "UPDATE candidat SET nom = '"+ nouveauNom +"' WHERE nom='"+ ancienNom +"'" );
		        	if(ModifCand == 1)
		        	{
		        		System.out.println("Modification du nom de la personne réussi" );
		        	}
		        	else{
			        	System.out.println("Echec lors de la modification" );
			        }
		        
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public static void modifierPrenomPersonne(String ancienPrenom, String nouveauPrenom)
	{
		try
		{
			Statement statement = null;
			/* int ModifDate = statement.executeUpdate( "UPDATE personne SET idPers = "+ date +" WHERE idCompet = "+ idCompet +"" );*/
			statement = connexion.createStatement();
			 
			 int ModifPers = statement.executeUpdate("UPDATE personne SET prenom = '"+ nouveauPrenom +"' WHERE prenom = '"+ ancienPrenom +"'");
			 
		        if(ModifPers == 1)
		        {
		        	System.out.println("Modification du prénom de la personne réussi " );
		        }
		        else{
		        	System.out.println("Echec lors de la modification" );
		        }
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public static void modifierMailPersonne(String ancienMail, String nouveauMail)
	{
		try
		{
			Statement statement = null;
			
			statement = connexion.createStatement();
			 
			 int ModifPers = statement.executeUpdate("UPDATE personne SET mail = '"+ nouveauMail +"' WHERE mail = '"+ ancienMail +"'");
			 
		        if(ModifPers == 1)
		        {
		        	
		        		System.out.println("Modification du mail de la personne réussi" );
		        	
		        }
		        else{
		        	System.out.println("Echec lors de la modification" );
		        }
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	//MODIFIER NOM D'UNE COMPETITION v1
	public static void modifierNomCompet(String ancienNom, String nouveauNom)
	{
		try
		{
			Statement statement = null;
			
			statement = connexion.createStatement();
			 
			 
		        	int ModifCand = statement.executeUpdate( "UPDATE competition SET nom = '"+ nouveauNom +"' WHERE nom='"+ ancienNom +"'" );
		        	if(ModifCand == 1)
		        	{
		        		System.out.println("Le nom de la compet a été mis à jour" );
		        	}
		        	else{
			        	System.out.println("Echec lors de la modification" );
			        }
		        
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	//MODIFIER NOM D'UNE EQUIPE v1
	public static void modifierNomEquipe(String ancienNom, String nouveauNom)
	{
		try
		{
			Statement statement = null;
			
			statement = connexion.createStatement();
			 
			 
		    int ModifCand = statement.executeUpdate( "UPDATE candidat SET nom = '"+ nouveauNom +"' WHERE nom='"+ ancienNom +"'" );
		    if(ModifCand == 1)
		    {
		        System.out.println("Modification du nom de l'équipe réussi" );
		    }
		    else{
	        	System.out.println("Echec lors de la modification" );
	        }
		        
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public void MofidierDateCloture(Date date, int idCompet)
	{
		try
		{
			 Statement statement = null;
			 statement = connexion.createStatement();
			 int ModifDate = statement.executeUpdate( "UPDATE competition SET date_cloture = "+ date +" WHERE id_comp = "+ idCompet +"" );
		        System.out.println( "Affichage des candidats" );
		        
		        if(ModifDate == 1){
		        	System.out.println("Modification de la date de cloture réussi" );
		        }
		        else{
		        	System.out.println("Echec lors de la modification" );
		        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public static int recupID(String Nom)
	{
		int id = 0;
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT id_c,nom FROM candidat WHERE nom = '"+Nom+"'");
												
	        while ( resultat.next())
	        {
	        	id = resultat.getInt("id_cand");
	        	System.out.println(id);
	        }
			
		}
		catch(Exception e)
		{	
				 System.out.println( "Erreur lors de la recuperation de l'id : "
			                + e.getMessage() );
		}
		return id; 
		
	}
	
	public static int recupIDCompet(String Nom)
	{
		int id = 0;
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT id_comp,nom FROM competition WHERE nom = '"+Nom+"'");
												
	        while ( resultat.next())
	        {
	        	id = resultat.getInt("id_compet");
	        	System.out.println(id);
	        }
			
		}
		catch(Exception e)
		{	
				 System.out.println( "Erreur lors de la recuperation de l'id : "
			                + e.getMessage() );
		}
		return id; 
		
	}
	
	
	
	public static void SupprimerCandidat(String nomCand)
	{
		
		try
		{
			int id = recupID(nomCand);
			statement = connexion.createStatement();
			
			int SupprCandidat = statement.executeUpdate( "DELETE FROM candidat WHERE id_c = "+id+"" );
			int SupprCandidatInscr = statement.executeUpdate( "DELETE FROM `candidat_has_competition` WHERE `Candidat_id_candidat`= "+id+"");
			
			if(verifCand(id) == 1)
			{
				int supprEquipe = statement.executeUpdate("DELETE FROM composer_equipe WHERE id_equipe = "+ id +"");
				if(supprEquipe == 1)
				{
					System.out.println("Equipe supprimée" );
				}
				else{
		        	System.out.println("Echec lors de la suppression" );
		        }
			}
			else
			{
				int supprPers = statement.executeUpdate("DELETE FROM personne WHERE id_p ="+id+"");
				if(supprPers == 1)
				{
					System.out.println("Suppression de la personne réussi" );
				}
				else{
		        	System.out.println("Echec lors de la suppression" );
		        }
			}
			
		}
		catch(Exception e)
		{	
				 System.out.println( "Erreur lors de la connexion : "
			                + e.getMessage() );
		} 
	}	
	
	public static void InscriptionCandidatCompetition(int idCand, int idCompet)
	{
		try
		{
			statement = connexion.createStatement();
			ResultSet verifCandCompet = null;
			verifCandCompet = statement.executeQuery("SELECT candidat_id,competition_id FROM candidat_competition WHERE candidat_id ="+idCand+" AND competition_id ="+idCompet+"");
			if(verifCandCompet.next())
			{
				 ResultSet VerifNomCompet = null;
				 VerifNomCompet = statement.executeQuery( "SELECT c_nom FROM competition C, candidat_competition CC WHERE C.id_comp = CC.competiton_id AND id_comp ="+idCompet+"" );
				 while(VerifNomCompet.next())
			     {
					 
					 System.out.println("Le candidat n°"+idCand+" est deja inscrit a la competition n°"+idCompet+" - "+ VerifNomCompet.getString("compet_nom") );
			     }

			}
			else
			{
				int cand = verifCand(idCand);
				if(cand == 1)
				{
					ResultSet verifEnEquipe = null;
					verifEnEquipe = statement.executeQuery("SELECT * FROM competition WHERE en_equipe = 1 AND id_comp = "+idCompet+"");
					if(verifEnEquipe.next())
					{
						int insertCandCompet = statement.executeUpdate( "INSERT INTO candidat_competition (candidat_id,competition_id) VALUES ("+idCand+","+idCompet+")");
						if(insertCandCompet == 1)
						{
							System.out.println("Vous vous etes bien inscris a la competition n°"+idCompet+"");
						}
						else
						{
				        	System.out.println("Echec de l'inscription" );
				        }
					}
					else
					{
						System.out.println("Vous ne pouvez pas vous inscrire car cette competition se déroule en solo");
					}
				}
				else
				{

					ResultSet verifEnEquipe = null;
					verifEnEquipe = statement.executeQuery("SELECT * FROM competition WHERE en_equipe = 0 AND id_comp = "+idCompet+"");
					if(verifEnEquipe.next())
					{
						int insertCandCompet = statement.executeUpdate( "INSERT INTO candidat_competition (Ccandidat_id,competition_id) VALUES ("+idCand+","+idCompet+")");
						if(insertCandCompet == 1)
						{
							System.out.println("Vous vous etes bien inscrit pour participer a la competition n°"+idCompet+"");
						}
						else
						{
				        	System.out.println("L'inscription n'a pas ete prise en compts" );
				        }
					
					}
					else
					{
						System.out.println("Vous ne pouvez pas vous inscrire car cette competition se joue en equipe");
					}
				}
				
			}
			
			
		}
		catch(Exception e)
		{	
				 System.out.println( "Erreur lors de la connexion : "
			                + e.getMessage());
		} 
	}
	
	public static void inscriptionPersonneDansEquipe(int idPers, int idEquipe)
	{
		try
		{
			statement = connexion.createStatement();
			ResultSet verifPersEquipe = null;
			verifPersEquipe = statement.executeQuery("SELECT personne_id, equipe_id FROM personne_equipe WHERE personne_id ="+idPers+" AND equipe_id ="+idEquipe+"");
			if(verifPersEquipe.next())
			{
				System.out.println("Vous etes deja inscrit dans l'equipe n "+idEquipe+"");
			}
			else
			{
				ResultSet verifPers = null;
				verifPers = statement.executeQuery("SELECT id_p, prenom FROM personne WHERE id_p = "+idPers+"");
				if(verifPers.next())
				{
					int insertPersEquipe = statement.executeUpdate( "INSERT INTO personne_equipe (personne_id,equipe_id) VALUES ("+idPers+","+idEquipe+")");
						
					if(insertPersEquipe == 1)
					{
						System.out.println("Vous vous êtes bien inscrit dans l'equipe n°"+idEquipe+"");
					}
					else
					{
				        System.out.println("L'inscription a échoué" );
				    }
				}
				else
				{
					System.out.println("Il faut d'abord vous inscrire pour rejoindre une equipe");
				}
			}
			
		}
		catch(Exception e)
		{	
				 System.out.println( "Erreur lors de la connexion : "
			                + e.getMessage());
		} 
	}
	
	public static int verifCand(int idCand)
	{
		int result = 0;
		try
		{
			
			
			ResultSet verifPers = null;
			statement = connexion.createStatement();
			
			
			verifPers = statement.executeQuery( "SELECT * FROM equipe" );
			  while( verifPers.next())
		        {
				  if(idCand == verifPers.getInt("id_equipe"))
				  {
					  result = 1; //si le candidat est une equipe
				  }
				  
		        }
			
		}
		catch(Exception e)
		{	
				 System.out.println( "Erreur lors de la connexion : "
			                + e.getMessage() );
		} 
		return result;
	}
	
	
	
	public static HashMap<String, Integer> MajListeEquipe()
	{
		HashMap<String, Integer> maliste = new LinkedHashMap<String, Integer>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT nom_c, id_equipe FROM Candidat C, Equipe E WHERE E.id_equipe = C.id_c" );
	        
	        while ( resultat.next())
	        {
	        	int idEquipe = resultat.getInt("id_equipe");
	        	String Nom = resultat.getString("nom_c");

	        	 maliste.put(Nom, idEquipe);
	        	System.out.println("Equipe n°"+ idEquipe + " - " + Nom);


	        }
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return maliste; 
	    
	

	}


	
	



	public static void SupprimerCompetition(String NomCompet)
	{
		
		try
		{
				int id = recupIDCompet(NomCompet);
				statement = connexion.createStatement();

				int SupprCompet = statement.executeUpdate( "DELETE FROM competition WHERE id_comp = "+ id  +"" );

		        if(SupprCompet == 1){
		        	System.out.println("La suppression a bien ete prise en compte" );
		        }
		        else{
		        	System.out.println("La suppression n'a pas été prise en compte" );
		        }
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public static void SupprimerPersonne(String nomCand)
	{
		try
		{
			int id = recupID(nomCand);
			statement = connexion.createStatement();
			System.out.println(id);
			 int SupprPers = statement.executeUpdate("DELETE FROM personne WHERE id_p = "+ id +"");
			 
		        if(SupprPers == 1)
		        {
		        	System.out.println("1ere etape de suppression" );
		        	int SupprCand = statement.executeUpdate( "DELETE FROM candidat WHERE id_c = "+ id +"" );
		        	if(SupprCand == 1)
		        	{
		        		System.out.println("La suppression de l'equipe a bien ete prise en compte" );
		        	}	
		        }
		        else{
		        	System.out.println("La suppression n'a PAS ete prise en compte" );
		        }
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	
	public static void main(String[] args) 
	{

		/*Connexion connect = new Connexion();
		connect.ajouterCandidat("Jewbaccabra");
		connect.ajouterCandidat("MrReYz");
		connect.ajouterCandidat("SuceurDeQueue");*/
		
	}


	
}