package SwingIHM;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import javax.swing.*;


import inscriptions.*;
import database.*;

import javax.swing.Action;

public class IhmV1 {
	
	protected static final Inscriptions inscription = Inscriptions.getInscriptions();
	public JFrame frmTest1;
	private JTextField txtNomEquipe;
	private JTextField txtNomCompet;
	private JTextField txtDateCompet;
	private JTextField txtNomCompet2;
	private JTextField txtDateCompet2;
	private JTextField txtNomPersonne;
	private JTextField txtMailPersonne;
	private JTextField txtNomPersonne2;
	private JTextField txtPrenomPersonne;
	private JTextField txtPrenomPersonne2;
	private static JList listEquipe;
	private static JList listCompet;
	private static JList listPersonne;
	private JTextField txtMailPersonne2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IhmV1 window = new IhmV1();
					window.frmTest1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public IhmV1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTest1 = new JFrame();
		frmTest1.getContentPane().setBackground(new Color(255, 255, 255));
		frmTest1.getContentPane().setForeground(new Color(0, 255, 255));
		frmTest1.setFont(new Font("Verdana", Font.BOLD, 12));
		frmTest1.setType(Type.POPUP);
		frmTest1.setTitle("Test");
		frmTest1.setForeground(new Color(0, 0, 0));
		frmTest1.setBackground(new Color(0, 0, 0));
		frmTest1.setBounds(100, 100, 776, 477);
		frmTest1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTest1.getContentPane().setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmTest1.setLocation(dim.width/2 - frmTest1.getWidth()/2, dim.height/2 - frmTest1.getHeight()/2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 755, 453);
		frmTest1.getContentPane().add(panel);
		panel.setBackground(new Color(25, 25, 112));
		panel.setForeground(new Color(0, 0, 0));
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 245, 442);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAjouterUnequipe = new JButton("Ajouter");
		btnAjouterUnequipe.setBounds(113, 109, 100, 23);
		panel_1.add(btnAjouterUnequipe);
		
		Label labelEquipe = new Label("G\u00E9rer une Equipe");
		labelEquipe.setFont(new Font("Verdana", Font.BOLD, 15));
		labelEquipe.setBounds(53, 10, 132, 22);
		panel_1.add(labelEquipe);
		
		JButton btnSupprimerUnequipe = new JButton("Supprimer");
		btnSupprimerUnequipe.setBounds(113, 203, 100, 23);
		panel_1.add(btnSupprimerUnequipe);
		
		listEquipe = new JList(); 
		
		listEquipe.setToolTipText("");
		listEquipe.setBackground(new Color(128, 0, 0));
		listEquipe.setModel(new AbstractListModel() {
			String[] values = new String[] {"list"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listEquipe.setBounds(0, 285, 245, 157);
		panel_1.add(listEquipe);
		
		txtNomEquipe = new JTextField();
		txtNomEquipe.setText("Nom");
		txtNomEquipe.setBounds(113, 88, 100, 20);
		panel_1.add(txtNomEquipe);
		txtNomEquipe.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pour ajouter une équipe :");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2.setBounds(7, 63, 178, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblRentrerLes = new JLabel("1) Champ(s) requi(s)");
		lblRentrerLes.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblRentrerLes.setBounds(7, 88, 202, 20);
		panel_1.add(lblRentrerLes);
		
		JLabel lblPuisAppuyerSur = new JLabel("2) Bouton \"Ajouter\"");
		lblPuisAppuyerSur.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblPuisAppuyerSur.setBounds(7, 113, 138, 14);
		panel_1.add(lblPuisAppuyerSur);
		
		JLabel lblPourSupprimerUne = new JLabel("Pour supprimer une \u00E9quipe :");
		lblPourSupprimerUne.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourSupprimerUne.setBounds(7, 160, 187, 14);
		panel_1.add(lblPourSupprimerUne);
		
		JLabel lblSelectionnerUne = new JLabel("1) Selectionner une \u00C3\u00A9quipe dans la liste");
		lblSelectionnerUne.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSelectionnerUne.setBounds(7, 182, 202, 20);
		panel_1.add(lblSelectionnerUne);
		
		JLabel lblBoutonsupprimer = new JLabel("2) Bouton \"Supprimer\"");
		lblBoutonsupprimer.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBoutonsupprimer.setBounds(7, 207, 138, 14);
		panel_1.add(lblBoutonsupprimer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(255, 0, 245, 442);
		panel.add(panel_2);
		
		JButton btnAjouterUneCompet = new JButton("Ajouter");
		btnAjouterUneCompet.setBounds(117, 95, 100, 20);
		panel_2.add(btnAjouterUneCompet);
		
		Label labelCompet = new Label("Gérer une compétition");
		labelCompet.setFont(new Font("Verdana", Font.BOLD, 15));
		labelCompet.setBounds(32, 10, 166, 22);
		panel_2.add(labelCompet);
		
		JButton btnSupprimerUneCompet = new JButton("Supprimer");
		btnSupprimerUneCompet.setBounds(120, 157, 97, 23);
		panel_2.add(btnSupprimerUneCompet);
		
		listCompet = new JList();
		listCompet.setBackground(new Color(128, 0, 0));
		listCompet.setBounds(0, 284, 245, 158);
		panel_2.add(listCompet);
		
		JLabel lblPourAjouterUne = new JLabel("Pour ajouter une compétition :");
		lblPourAjouterUne.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourAjouterUne.setBounds(10, 38, 207, 14);
		panel_2.add(lblPourAjouterUne);
		
		JLabel label_3 = new JLabel("1° Champ(s) requi(s)");
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_3.setBounds(10, 52, 202, 20);
		panel_2.add(label_3);
		
		txtNomCompet = new JTextField();
		txtNomCompet.setText("Nom");
		txtNomCompet.setColumns(10);
		txtNomCompet.setBounds(10, 70, 100, 20);
		panel_2.add(txtNomCompet);
		
		txtDateCompet = new JTextField();
		txtDateCompet.setText("Date(YYYY-MM-DD)");
		txtDateCompet.setColumns(10);
		txtDateCompet.setBounds(117, 70, 100, 20);
		panel_2.add(txtDateCompet);
		
		JLabel label_4 = new JLabel("2° Bouton \"Ajouter\"");
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_4.setBounds(10, 98, 138, 14);
		panel_2.add(label_4);
		
		JLabel lblPourSupprimerUne_1 = new JLabel("Pour supprimer une compétition");
		lblPourSupprimerUne_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourSupprimerUne_1.setBounds(10, 126, 225, 14);
		panel_2.add(lblPourSupprimerUne_1);
		
		JLabel label_6 = new JLabel("1° Selectionner une équipe dans la liste");
		label_6.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_6.setBounds(10, 142, 202, 20);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("2° Bouton \"Supprimer\"");
		label_7.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_7.setBounds(10, 161, 138, 14);
		panel_2.add(label_7);
		
		JLabel lblPourModifierUne = new JLabel("Pour modifier une compétition");
		lblPourModifierUne.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourModifierUne.setBounds(10, 185, 225, 14);
		panel_2.add(lblPourModifierUne);
		
		txtNomCompet2 = new JTextField();
		txtNomCompet2.setText("Nom");
		txtNomCompet2.setColumns(10);
		txtNomCompet2.setBounds(135, 204, 100, 20);
		panel_2.add(txtNomCompet2);
		
		JLabel lblNouveauNom = new JLabel("1°a Nouveau nom");
		lblNouveauNom.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNouveauNom.setBounds(10, 204, 202, 20);
		panel_2.add(lblNouveauNom);
		
		JLabel lblbNouvelleDatecloture = new JLabel("1°b Nouvelle DateCloture");
		lblbNouvelleDatecloture.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblbNouvelleDatecloture.setBounds(10, 224, 122, 20);
		panel_2.add(lblbNouvelleDatecloture);
		
		txtDateCompet2 = new JTextField();
		txtDateCompet2.setText("Date(dd/mm/yyyy)");
		txtDateCompet2.setColumns(10);
		txtDateCompet2.setBounds(135, 224, 100, 20);
		panel_2.add(txtDateCompet2);
		
		JLabel lblBoutonmodifier = new JLabel("2° Bouton \"Modifier\"");
		lblBoutonmodifier.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBoutonmodifier.setBounds(10, 245, 138, 14);
		panel_2.add(lblBoutonmodifier);
		
		JButton btnModifierUneCompet = new JButton("Modifier");
		btnModifierUneCompet.setBounds(135, 244, 102, 20);
		panel_2.add(btnModifierUneCompet);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(510, 0, 245, 442);
		panel.add(panel_3);
		
		JButton btnAjouterUnePersonne = new JButton("Ajouter");
		btnAjouterUnePersonne.setBounds(117, 114, 100, 20);
		panel_3.add(btnAjouterUnePersonne);
		
		Label labelPersonne = new Label("G\u00E9rer une personne");
		labelPersonne.setFont(new Font("Verdana", Font.BOLD, 15));
		labelPersonne.setBounds(32, 10, 166, 22);
		panel_3.add(labelPersonne);
		
		JButton btnSupprimerUnePersonne = new JButton("Supprimer");
		btnSupprimerUnePersonne.setBounds(120, 176, 97, 23);
		panel_3.add(btnSupprimerUnePersonne);
		
		listPersonne = new JList();
		listPersonne.setBackground(new Color(128, 0, 0));
		listPersonne.setBounds(0, 321, 245, 121);
		panel_3.add(listPersonne);
		
		JLabel lblPourAjouterUne_1 = new JLabel("Pour ajouter une personne :");
		lblPourAjouterUne_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourAjouterUne_1.setBounds(10, 38, 207, 14);
		panel_3.add(lblPourAjouterUne_1);
		
		JLabel lblChampsRequis = new JLabel("1) Champ(s) requi(s)");
		lblChampsRequis.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblChampsRequis.setBounds(10, 52, 202, 20);
		panel_3.add(lblChampsRequis);
		
		txtNomPersonne = new JTextField();
		txtNomPersonne.setText("Nom");
		txtNomPersonne.setColumns(10);
		txtNomPersonne.setBounds(10, 70, 100, 20);
		panel_3.add(txtNomPersonne);
		
		txtMailPersonne = new JTextField();
		txtMailPersonne.setText("Mail");
		txtMailPersonne.setColumns(10);
		txtMailPersonne.setBounds(10, 96, 100, 20);
		panel_3.add(txtMailPersonne);
		
		JLabel lblBoutonajouter = new JLabel("2) Bouton \"Ajouter\"");
		lblBoutonajouter.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBoutonajouter.setBounds(10, 117, 138, 14);
		panel_3.add(lblBoutonajouter);
		
		JLabel lblPourSupprimerUne_2 = new JLabel("Pour supprimer une personne");
		lblPourSupprimerUne_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourSupprimerUne_2.setBounds(10, 145, 225, 14);
		panel_3.add(lblPourSupprimerUne_2);
		
		JLabel lblSelectionnerUne_1 = new JLabel("1) Selectionner une personne dans la liste");
		lblSelectionnerUne_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSelectionnerUne_1.setBounds(10, 161, 202, 20);
		panel_3.add(lblSelectionnerUne_1);
		
		JLabel lblBoutonsupprimer_1 = new JLabel("2) Bouton \"Supprimer\"");
		lblBoutonsupprimer_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBoutonsupprimer_1.setBounds(10, 180, 138, 14);
		panel_3.add(lblBoutonsupprimer_1);
		
		JLabel lblPourModifierUne_1 = new JLabel("Pour modifier une personne");
		lblPourModifierUne_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourModifierUne_1.setBounds(10, 204, 225, 14);
		panel_3.add(lblPourModifierUne_1);
		
		txtNomPersonne2 = new JTextField();
		txtNomPersonne2.setText("Nom");
		txtNomPersonne2.setColumns(10);
		txtNomPersonne2.setBounds(135, 223, 100, 20);
		panel_3.add(txtNomPersonne2);
		
		JLabel lblaNouveauNom = new JLabel("1a) Nouveau nom");
		lblaNouveauNom.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblaNouveauNom.setBounds(10, 223, 202, 20);
		panel_3.add(lblaNouveauNom);
		
		JLabel lblbNouvelleMail = new JLabel("1b) Nouveau prenom");
		lblbNouvelleMail.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblbNouvelleMail.setBounds(10, 243, 122, 20);
		panel_3.add(lblbNouvelleMail);
		
		txtPrenomPersonne2 = new JTextField();
		txtPrenomPersonne2.setText("Prenom");
		txtPrenomPersonne2.setColumns(10);
		txtPrenomPersonne2.setBounds(135, 243, 100, 20);
		panel_3.add(txtPrenomPersonne2);
		
		JLabel lblBoutonmodifier_1 = new JLabel("2) Bouton \"Modifier\"");
		lblBoutonmodifier_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBoutonmodifier_1.setBounds(10, 299, 138, 14);
		panel_3.add(lblBoutonmodifier_1);
		
		JButton btnModifierUnePersonne = new JButton("Modifier");
		btnModifierUnePersonne.setBounds(133, 296, 102, 20);
		panel_3.add(btnModifierUnePersonne);
		
		txtPrenomPersonne = new JTextField();
		txtPrenomPersonne.setText("Prenom");
		txtPrenomPersonne.setBounds(117, 70, 100, 20);
		panel_3.add(txtPrenomPersonne);
		txtPrenomPersonne.setColumns(10);
		
		JLabel lblcNouveauMail = new JLabel("1c) Nouveau mail");
		lblcNouveauMail.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblcNouveauMail.setBounds(10, 271, 122, 20);
		panel_3.add(lblcNouveauMail);
		
		txtMailPersonne2 = new JTextField();
		txtMailPersonne2.setText("Mail");
		txtMailPersonne2.setBounds(135, 265, 100, 20);
		panel_3.add(txtMailPersonne2);
		txtMailPersonne2.setColumns(10);
		
		btnModifierUnePersonne.addActionListener(new modifierPersonne());
		btnSupprimerUnePersonne.addActionListener(new supprimerPersonne());
	 	btnAjouterUnePersonne.addActionListener(new ajouterPersonne());
		btnModifierUneCompet.addActionListener(new modifierCompet());
		btnSupprimerUneCompet.addActionListener(new supprimerCompet());
		btnAjouterUneCompet.addActionListener(new ajouterCompet());
		btnAjouterUnequipe.addActionListener(new ajouterEquipe()); 
		btnSupprimerUnequipe.addActionListener(new supprimerEquipe());
		
		/* listCompet.add(inscriptions.bdd.AfficherCompetitions(); */
		
	}
	
	public class modifierPersonne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class supprimerPersonne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class ajouterPersonne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		
			txtNomPersonne.setText("Nom");
			txtMailPersonne.setText("Mail");
		}
	}
	
	public class ajouterCompet implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			txtNomCompet.setText("Nom");
			txtDateCompet.setText("Date(YYYY-MM-DD)");
		}
	}
	
	public class modifierCompet implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class supprimerCompet implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class ajouterEquipe implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			txtNomEquipe.setText("Nom");
		}
	}
	
	public class supprimerEquipe implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Ajouter");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
