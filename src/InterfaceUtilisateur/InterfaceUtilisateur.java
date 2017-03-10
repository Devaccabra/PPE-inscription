package InterfaceUtilisateur;
import java.sql.Date;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;

import javax.swing.plaf.synth.SynthSpinnerUI;

import database.Connexion;
import inscriptions.*;
import commandLine.*;;

public class InterfaceUtilisateur {

	static Scanner sc = new Scanner(System.in);
protected static final Inscriptions inscription = Inscriptions.getInscriptions();

	public static List<Personne> GetPersonne()
	{
		SortedSet<inscriptions.Candidat> candidats = inscription.getCandidats();
		List<Personne> personnes = new ArrayList<>();
		for (inscriptions.Candidat candidat : candidats)
			if(candidat instanceof Personne)
				personnes.add((Personne) candidat);
		return personnes;
	}
	
	public static List<Equipe> GetEquipe()
	{
			SortedSet<inscriptions.Candidat> candidats = inscription.getCandidats();
			List<Equipe> team = new ArrayList<>();
			for (inscriptions.Candidat candidat : candidats)
				if(candidat instanceof Equipe)
					team.add((Equipe) candidat);
			return team;
	}
	
	public static List<Competition> GetCompetition()
	{
			SortedSet<inscriptions.Competition> compet = inscription.getCompetitions();
			List<Competition> listCompet = new ArrayList<>();
			for (inscriptions.Competition competition : compet)
				if(competition instanceof Competition)
					listCompet.add((Competition) competition);
			return listCompet;
	}
	
		public static void main(String[] args)
		{
			
			final Inscriptions inscriptions = Inscriptions.getInscriptions();
			// les menus
			Menu MenuPrincipal= new Menu("Veuillez faire un choix");
			final Menu equipe = new Menu("Gerer les equipe", "1");
			final Menu compet = new Menu("Gerer les competitions", "2");
			final Menu personne = new Menu("Gerer les personnes", "3");
			// final Menu candidat = new Menu("Gerer les candidats", "4"); 
			MenuPrincipal.ajoute(equipe);
			MenuPrincipal.ajoute(compet);
			MenuPrincipal.ajoute(personne);
			//MenuPrincipal.ajoute(candidat);
			MenuPrincipal.ajouteQuitter("q");
		
			// Option 1 du Menu Principal (Equipe) 
			Option ajouterEquipe = new Option("Ajouter", "1");
			equipe.ajoute(ajouterEquipe);		
		
			//Option 2 du Menu Principal (Compet)
			Option ajouterCompet = new Option("Ajouter", "1");
			compet.ajoute(ajouterCompet);
		
			//Option 3 du Menu principal (personne)
			Option ajouterPersonne = new Option("Ajouter", "1");
			personne.ajoute(ajouterPersonne);
		
			
			//Option 4 du Menu principal (candidat)
			//Option supprimerCandidat = new Option("Supprimer un candidat", "1");
		//	candidat.ajoute(supprimerCandidat);
			//candidat.ajouteRevenir("r");
			
			
/**************************************************************************************************************************************		
/*************************************************Personnes(Ajout)***************************************************************************
/**********************************************************************************************************************************/		
		ajouterPersonne.setAction(new Action()
		{
		
			public void optionSelectionnee()
			{
				
				System.out.println("Saisissez le nom : ");
				String nom = sc.nextLine();
				System.out.println("Saisissez le prenom : ");
				String prenom = sc.nextLine();
				System.out.println("Saisissez le mail : ");
			    String mail = sc.nextLine();
				Personne pers = Inscriptions.getInscriptions().createPersonne(nom, prenom, mail);
				System.out.println("Recapitulatif : votre nom est : " + nom + ", Votre prenom : " + prenom + ", Votre mail : " + mail );
				SortedSet<Candidat> candidats = inscriptions.getCandidats();
				List<Personne> personnes = new ArrayList<>();
				for (Candidat candidat : candidats)
					if (candidat instanceof Personne)
						personnes.add((Personne)candidat);
				personnes.add(pers);
				Connexion Connect = new Connexion();
				Connect.AjouterPersonne(nom, prenom, mail);
			}
			
		}); 
	
/**************************************************************************************************************************************		
/*************************************************Personnes(Suppresion)***************************************************************************
/**********************************************************************************************************************************/				
	Liste<Personne> ListePerson = new Liste<Personne>("Supprimer","2",  
			new ActionListe<Personne>()
	{
		
		
					public List<Personne> getListe()
					{
						return GetPersonne();
						
					}
					
					
		@Override
		public void elementSelectionne(int indice, Personne element) {
			/*Connexion Connect = new Connexion();
			Connect.AfficherPersonnes();
			Connect.RecupId(String nom, String mail);
			Connect.SupprimerPersonne();*/
			element.delete();
		}


		@Override
		public Option getOption(Personne arg0)
		{
			// TODO Auto-generated method stub
			return null;
		}
	});
	personne.ajoute(ListePerson);
/**************************************************************************************************************************************		
/*************************************************Personnes(Afficher)***************************************************************************
/**********************************************************************************************************************************/							
	personne.ajoute(new Option("Afficher", "3", new Action()
	{	
		public void optionSelectionnee() 
		{
		SortedSet<Candidat> candidats = inscriptions.getCandidats();
		List<Personne> personnes = new ArrayList<>();
		for (Candidat candidat : candidats)
			if (candidat instanceof Personne)
				personnes.add((Personne)candidat);
		
		/*Connexion Connect = new Connexion();
		Connect.AfficherPersonnes();*/
		
		System.out.println(personnes);
		
		}
		
	}));
				
/**************************************************************************************************************************************		
/*************************************************Personnes(Modifier mail)***************************************************************************
/**********************************************************************************************************************************/										
	Liste<Personne> ModifierMailPerson = new Liste<Personne>("Modifier le mail","4",  
			new ActionListe<Personne>()
	{
		
		
					public List<Personne> getListe()
					{
						return GetPersonne();
					}
					
		
		@Override
		public void elementSelectionne(int indice, Personne element) {
			System.out.println("Saisissez le nouveau mail : ");
		    String mail = sc.nextLine();
			element.setMail(mail);
			/* Connexion Connect = new Connexion();
			 * Connect.modifierMailPersonne(int idCand, String mail);*/
			System.out.println("Recapitulatif : le nouveau mail est : " + mail );
		}


		@Override
		public Option getOption(Personne arg0)
		{
			// TODO Auto-generated method stub
			return null;
		}
	});
	personne.ajoute(ModifierMailPerson);

/**************************************************************************************************************************************		
/*************************************************Personnes(Modifier nom)***************************************************************************
/**********************************************************************************************************************************/										
Liste<Personne> ModifierNomPerson = new Liste<Personne>("Modifier le nom","5",  
		new ActionListe<Personne>()
				{
					
					
					public List<Personne> getListe()
						{
						return GetPersonne();
						}
								
					
		@Override
		public void elementSelectionne(int indice, Personne element) {
		System.out.println("Saisissez le nouveau nom : ");
	    String nom = sc.nextLine();
		/* Connexion Connect = new Connexion();
		 * Connect.modifierNomPersonne(int idCand, String nom)*/
		element.setNom(nom);
		System.out.println("Recapitulatif : le nouveau nom est : " + nom );
					}


		@Override
		public Option getOption(Personne arg0)
		{
			// TODO Auto-generated method stub
			return null;
		}
				});
			personne.ajoute(ModifierNomPerson);
/**************************************************************************************************************************************		
/*************************************************Personnes(Modifier prenom)***************************************************************************
/**********************************************************************************************************************************/										
  Liste<Personne> ModifierPrenomPerson = new Liste<Personne>("Modifier le prenom","6",  
			new ActionListe<Personne>()
						{
													
													
					public List<Personne> getListe()
						{
						return GetPersonne();
						}
																
													
		@Override
		public void elementSelectionne(int indice, Personne element) {
		System.out.println("Saisissez le nouveau prenom : ");
	    String prenom = sc.nextLine();
		/* Connexion Connect = new Connexion();
		 * Connect.modifierPrenomPersonne(int idCand, String prenom)*/
		element.setPrenom(prenom);
		System.out.println("Recapitulatif : le nouveau prenom est : " + prenom );
					}


		@Override
		public Option getOption(Personne arg0)
		{
			// TODO Auto-generated method stub
			return null;
		}
				});
		personne.ajoute(ModifierPrenomPerson);															
		personne.ajouteRevenir("r");



/**************************************************************************************************************************************		
/*************************************************Equipe(Ajouter)***************************************************************************
/**********************************************************************************************************************************/							
	ajouterEquipe.setAction(new Action()
	{
	
		public void optionSelectionnee()
		{
			System.out.println("Saisissez le nom de votre équipe : ");
		    String nom = sc.nextLine();
			Equipe equip = inscriptions.createEquipe(nom);
			System.out.println("Recapitulatif : votre nom d'equipe est : " + nom );
			SortedSet<Candidat> candidats = inscriptions.getCandidats();
			List<Equipe> equipe = new ArrayList<>();
			for (Candidat candidat : candidats)
				if (candidat instanceof Equipe)
					equipe.add((Equipe)candidat);
			equipe.add(equip);
			/*Connexion Connect = new Connexion();
			 * Connect.AjouterEquipe(String Nom)*/
		}
		
	}); 
	
/**************************************************************************************************************************************		
/*************************************************Equipe(Supprimer)***************************************************************************
/**********************************************************************************************************************************/							
	Liste<Equipe> ListeEquipe = new Liste<Equipe>("Supprimer","2",  
			new ActionListe<Equipe>()
	{
					public List<Equipe> getListe()
					{
						return GetEquipe();
					}
		
		@Override
		public void elementSelectionne(int indice, Equipe element) {
			element.delete();
			/*Connexion Connect = new Connexion();
			 * SupprimerEquipe(int idCand);*/
			
		}

		@Override
		public Option getOption(Equipe arg0)
		{
			// TODO Auto-generated method stub
			return null;
		}
	});
	equipe.ajoute(ListeEquipe);
					
/**************************************************************************************************************************************		
/*************************************************Equipe(Afficher)***************************************************************************
/**********************************************************************************************************************************/													
	equipe.ajoute(new Option("Afficher", "3", new Action()
	{	
		@Override
		public void optionSelectionnee() {
		SortedSet<inscriptions.Candidat> candidats = inscription.getCandidats();
		List<Equipe> team = new ArrayList<>();
		for (inscriptions.Candidat candidat : candidats)
			if(candidat instanceof Equipe)
				team.add((Equipe) candidat);
		for(int i = 0; i <= team.size()-1; i++)
		{
			System.out.println(team);
			/*Connexion Connect = new Connexion();
			Connect.AfficherEquipe();
			inscriptions.getCandidats().getMembres();*/ 
		}
		}	
		
	}));
	

	equipe.ajouteRevenir("r");		
					
/**************************************************************************************************************************************		
/*************************************************Compet(Ajouter)***************************************************************************
/**********************************************************************************************************************************/						

	ajouterCompet.setAction(new Action()
	{
	
		public void optionSelectionnee()
		{
			boolean boolenEquipe = false;
			String Status = "Vous etes inscrit en solo";
			System.out.println("Saisissez le nom de la competition : ");
		    String nom = sc.nextLine();
			System.out.println("Saisissez la date de cloture des inscriptions (YYYY-MM-DD) : ");
		    String dateCloture = sc.nextLine();
		    System.out.println("Saisissez si la compet est en equipe (Y/N) : ");
			String enEquipe = sc.nextLine();
			LocalDate Cloture = LocalDate.parse(dateCloture);
			if(enEquipe == "Y")
			//ajouter le lien avec la variable getinitbdd dans inscription
				 boolenEquipe = true;
				 Status = "Vous etes inscrit en equipe";
			System.out.println("Recapitulatif : votre nom de competition est : " + nom + " La date de cloture sera le : " + Cloture + " " + Status);
			List<Competition> comp = new ArrayList<>();
			
			/*Connexion Connect = new Connexion();
			 * Connect.AjouterCompetition(String NomCompet,Date dateCompet)*/
		}
		
	}); 
	
/**************************************************************************************************************************************		
/*************************************************Compet(Afficher)***************************************************************************
/**********************************************************************************************************************************/					
	
	compet.ajoute(new Option("Afficher", "2", new Action()
	{

		@Override
		public void optionSelectionnee() {
			SortedSet<inscriptions.Competition> compet = inscription.getCompetitions();
			List<Competition> listCompet = new ArrayList<>();
			for (inscriptions.Competition competition : compet)
				if(competition instanceof Competition)
					listCompet.add((Competition) competition);
			for(int i = 0; i <= listCompet.size()-1; i++)
				{
				System.out.print("Le nom de la compet est : ");
				System.out.print(listCompet.get(i).getNom());
				System.out.print(" , la date de cloture sera le : ");
				if(listCompet.get(i).getDateCloture() == null)
				System.out.println("Aucune date n'a ete prevu");
				else
				System.out.println(listCompet.get(i).getDateCloture());
				/*Connexion Connect = new Connexion();
				 * AfficherCompetitions();*/
				}
		}
	}));			
			
				
/**************************************************************************************************************************************		
/*************************************************Compet(Supprimer)***************************************************************************
/**********************************************************************************************************************************/														
	Liste<Competition> Competition = new Liste<Competition>("Supprimer","3",  
			new ActionListe<Competition>()
	{
		
					public List<Competition> getListe()
					{
						return GetCompetition();
					}

		@Override
		public void elementSelectionne(int indice, Competition element) {
			
			element.delete();
			/*Connexion Connect = new Connexion();
			 * SupprimerCompetition(int idCompet);*/
		}

		@Override
		public Option getOption(inscriptions.Competition arg0)
		{
			// TODO Auto-generated method stub
			return null;
		}
	});
	compet.ajoute(Competition);
/**************************************************************************************************************************************		
/*************************************************Compet(ModifDateCloture)***************************************************************************
/**********************************************************************************************************************************/														
			Liste<Competition> ModifDateCloture = new Liste<Competition>("Modifier","4",  
					new ActionListe<Competition>()
						{
				public List<Competition> getListe()
				{
				return GetCompetition();
				}
														
											
				@Override
				public void elementSelectionne(int indice, Competition element) {
				System.out.println("Saisissez la nouvelle date(Format : yyyy-mm-dd : )");
				String dateCloture = sc.nextLine();
				LocalDate Cloture = LocalDate.parse(dateCloture);
				System.out.println("Recapitulatif : la nouvelle date pour la competition est : " + Cloture );
						}


				@Override
				public Option getOption(inscriptions.Competition arg0)
				{
					// TODO Auto-generated method stub
					return null;
				}
						});

/**************************************************************************************************************************************		
/*************************************************Equipe(Ajout Personne)***************************************************************************
/**********************************************************************************************************************************/														
		/* 	Liste<Equipe> ListeEquipeAjoutPersonne = new Liste<Equipe>("Ajouter des personnes Ã  une equipes","z",  
					new ActionListe<Equipe>()
			{
							public List<Equipe> getListe()
							{
								return GetEquipe();
							}
				
				@Override
				public void elementSelectionne(int indice, Equipe element) {
					GetPersonne();
					element.add(null);
					
				}
			});
			equipe.ajoute(ListeEquipeAjoutPersonne); */
			
			compet.ajoute(ModifDateCloture);
			compet.ajouteRevenir("r");
			MenuPrincipal.start();
			System.out.println("bonjour!");


		}

		
}
