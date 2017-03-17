package SwingIHM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import SwingIHM.IhmV1.ajouterCompet;
import SwingIHM.IhmV1.ajouterEquipe;
import SwingIHM.IhmV1.ajouterPersonne;

import java.awt.Component;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.sql.Date;
//import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SortedSet;
import inscriptions.*;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;


public class IhmV2 {

	private JFrame frmGestionDesComptitions;
	private JTextField txtNomEquipe;
	private JTextField txtNomCompetition;
	private JTextField txtDateCompetition;
	private JTextField txtNomCompetition2;
	private JTextField txtNomPersonne2;
	private JTextField txtMailPersonne;
	private JTextField txtPrenomPersonne;
	private JTextField txtNomPersonne;
	private JCheckBox chckbxCompetitionEnEquipe;
	
	List<Personne> personnes = new ArrayList<>();
	List<Competition> competitions = new ArrayList<>();
	List<Equipe> Equipe = new ArrayList<>();
	final HashMap<String, Integer> listePers = database.Connexion.AfficherPersonnes();
	final HashMap<String, Integer> listecandidat = database.Connexion.AfficherLesEquipes();
	final HashMap<String, Integer> listeCompet = database.Connexion.AfficherCompetitions();
	final HashMap<Integer, String> malisteCompetID = database.Connexion.AfficherCompetitionsID();
	final HashMap<Integer, String> malisteEquipeID = database.Connexion.AfficherLesEquipesID();
	final HashMap<Integer, String> malistePersID = database.Connexion.AfficherPersonnesID();
	final HashMap<String, Integer> malistePersPrenom = database.Connexion.AfficherPersonnesPrenom();
	final HashMap<String, Integer> malistePersMail = database.Connexion.AfficherPersonnesMail();
	final HashMap<String, Integer> malisteCompetDate = database.Connexion.AfficherCompetitionsDate();
	final HashMap<Integer, String> malistePersonneCompet = database.Connexion.AfficherPersonnesCompet();//1
	final HashMap<Integer, String> malistePersonneCompetID = database.Connexion.AfficherPersonnesCompetID();//2
	final HashMap<Integer, String> malistePersonneEquipeID = database.Connexion.AfficherPersonnesHasEquipeID();
	final HashMap<Integer, String> malistePersonneEquipe = database.Connexion.AfficherPersonnesEquipe();
	final HashMap<Integer, String> malisteEquipeIDID = database.Connexion.AfficherEquipeCompetID();
	final HashMap<Integer, String> malisteEquipeIDIDID = database.Connexion.AfficherPersonnesPersonneID();
	final JList list = new JList();
	final JList ListPersonnePrenom = new JList();
	final JList listPersonne = new JList();
	final JList listCompetition = new JList();
	final JList ListCompetID = new JList();
	final JList ListEquipeID = new JList();
	final JList ListPersonneID = new JList();
	final JList ListPersonneMail = new JList();
	final JList listCompetitionDate = new JList();
	final JList ListEquipeID2 = new JList();
	final JList ListNom2 = new JList();
	final JList ListPersNom = new JList();
	final JList ListPersID = new JList();
	final JList ListCompetID2 = new JList();
	final JList ListCompetName = new JList();
	final JList ListPersonneEquipe = new JList();
	final JList ListPersonneCompet = new JList();
	final JList ListPersonneCompetID = new JList();
	final JList ListPersonneEquipeID = new JList();
	final JList ListCandidatIdCandidat = new JList();
	final JList ListCompetIDCompet = new JList();
	private JTextField txtMailPersonne2;
	
	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IhmV2 window = new IhmV2();
					window.frmGestionDesComptitions.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IhmV2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmGestionDesComptitions = new JFrame();
		frmGestionDesComptitions.setTitle("Gestion des compétitions");
		frmGestionDesComptitions.setResizable(false);
		frmGestionDesComptitions.setBounds(100, 100, 650, 408);
		frmGestionDesComptitions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesComptitions.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 652, 504);
		frmGestionDesComptitions.getContentPane().add(tabbedPane);
		
		JPanel panelAccueil = new JPanel();
		tabbedPane.addTab("Accueil", null, panelAccueil, null);
		panelAccueil.setLayout(null);
		
		// PANEL ACCUEIL
		
		panelAccueil.add(getLblGestionDesInscriptions());
		
		panelAccueil.add(getlblNewLabel());
		
		panelAccueil.add(getlblDansCetteApplication());
		
		panelAccueil.add(getlblEquipe());
		
		panelAccueil.add(getlblCompetition());
		
		panelAccueil.add(getlblPersonne());
		
		panelAccueil.add(getlblEquipe_1());
		
		panelAccueil.add(getlblComptition());
		
		panelAccueil.add(getlblPersonne_1());
		
		
		// PANEL PERSONNE
		
		JPanel panelPersonne = new JPanel();
		tabbedPane.addTab("Personne", null, panelPersonne, null);
		panelPersonne.setLayout(null);
		
		panelPersonne.add(getlblGestionDesPersonnes());
		
		panelPersonne.add(getlabel_19());
		
		panelPersonne.add(getlabel_22());
		
		panelPersonne.add(getlabel_25());
		
		panelPersonne.add(gettxtAncienNomPersonne());
		
		panelPersonne.add(gettxtAncienPrenom());
		((JTextField) gettxtAncienPrenom()).setColumns(10);
		
		panelPersonne.add(gettxtAncienMail());
		((JTextField) gettxtAncienMail()).setColumns(10);
		
		panelPersonne.add(gettxtPrenomPersonne2());
		((JTextField) gettxtPrenomPersonne2()).setColumns(10);
		
		panelPersonne.add(gettxtNomPersonne2());
		
		panelPersonne.add(gettxtMailPersonne2());
		
		panelPersonne.add(gettxtMailPersonne());
		
		panelPersonne.add(gettxtPrenomPersonne());
		
		panelPersonne.add(gettxtNomPersonne());
		ListPersonneID.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListPersonneID.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListPersonneID.setBackground(Color.LIGHT_GRAY);
		
		ListPersonneID.setBounds(283, 45, 35, 168);
		panelPersonne.add(ListPersonneID);
		listPersonne.setFont(new Font("Tahoma", Font.PLAIN, 10));
		listPersonne.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listPersonne.setVisibleRowCount(30);
		ListPersonneMail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListPersonneMail.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListPersonneMail.setBackground(Color.LIGHT_GRAY);
		
		ListPersonneMail.setModel(new AbstractListModel() {
			public int getSize() {
				return malistePersMail.size();
			}
			public Object getElementAt(int index) {
				return malistePersMail.keySet().toArray()[index];
			}
		});
		ListPersonnePrenom.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListPersonnePrenom.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListPersonnePrenom.setBackground(Color.LIGHT_GRAY);
		
		ListPersonnePrenom.setModel(new AbstractListModel() {
			public int getSize() {
				return malistePersPrenom.size();
			}
			public Object getElementAt(int index) {
				return malistePersPrenom.keySet().toArray()[index];
			}
		});
		
		
		listPersonne.setModel(new AbstractListModel() {
			public int getSize() {
				return listePers.size();
			}
			public Object getElementAt(int index) {
				return listePers.keySet().toArray()[index];
			}
		});
		
		ListPersonneID.setModel(new AbstractListModel() {
			public int getSize() {
				return malistePersID.size();
			}
			public Object getElementAt(int index) {
				return malistePersID.keySet().toArray()[index];
			}
		});
		ListPersonneEquipe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListPersonneEquipe.setBackground(Color.LIGHT_GRAY);
		ListPersonneEquipe.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		ListPersonneEquipe.setModel(new AbstractListModel() {
			public int getSize() {
				return malistePersonneEquipe.size();
			}
			public Object getElementAt(int index) {
				return malistePersonneEquipe.keySet().toArray()[index];
			}
		});
		ListPersonneCompet.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListPersonneCompet.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListPersonneCompet.setBackground(Color.LIGHT_GRAY);
		ListPersonneCompet.setForeground(Color.BLACK);
		
		ListPersonneCompet.setModel(new AbstractListModel() {
			public int getSize() {
				return malistePersonneCompet.size();
			}
			public Object getElementAt(int index) {
				return malistePersonneCompet.keySet().toArray()[index];
			}
		});
		ListPersonneCompetID.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListPersonneCompetID.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListPersonneCompetID.setBackground(Color.LIGHT_GRAY);
		ListPersonneCompetID.setForeground(Color.BLACK);
		
		ListPersonneCompetID.setModel(new AbstractListModel() {
			public int getSize() {
				return malistePersonneCompetID.size();
			}
			public Object getElementAt(int index) {
				return malistePersonneCompetID.keySet().toArray()[index];
			}
		});
		ListPersonneEquipeID.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListPersonneEquipeID.setBackground(Color.LIGHT_GRAY);
		ListPersonneEquipeID.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		ListPersonneEquipeID.setModel(new AbstractListModel() {
			public int getSize() {
				return malistePersonneEquipeID.size();
			}
			public Object getElementAt(int index) {
				return malistePersonneEquipeID.keySet().toArray()[index];
			}
		});
		
			//maj malistePersonneCompetID
			
		JButton btnAjouterPersonne = new JButton("Ajouter");
		btnAjouterPersonne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listePers.clear();
				malistePersID.clear();
				malistePersMail.clear();
				malistePersPrenom.clear();
				ListPersonneID.revalidate();
				ListPersonneID.repaint();
				listPersonne.revalidate();
				listPersonne.repaint();
				ListPersonneMail.revalidate();
				ListPersonneMail.repaint();
				ListPersonnePrenom.revalidate();
				ListPersonnePrenom.repaint();
				ListPersNom.revalidate();
				ListPersNom.repaint();
				ListPersID.revalidate();
				ListPersID.repaint();
				final HashMap<String, Integer> listePers = database.Connexion.AfficherPersonnes();
				final HashMap<Integer, String> malistePersID = database.Connexion.AfficherPersonnesID();
				final HashMap<String, Integer> malistePersPrenom = database.Connexion.AfficherPersonnesPrenom();
				final HashMap<String, Integer> malistePersMail = database.Connexion.AfficherPersonnesMail();
				listPersonne.setModel(new AbstractListModel() {
					public int getSize() {
						return listePers.size();
					}
					public Object getElementAt(int index) {
						return listePers.keySet().toArray()[index];
					}
				});
				ListPersonneID.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersID.size();
					}
					public Object getElementAt(int index) {
						return malistePersID.keySet().toArray()[index];
					}
				});
				ListPersonneMail.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersMail.size();
					}
					public Object getElementAt(int index) {
						return malistePersMail.keySet().toArray()[index];
					}
				});
				ListPersonnePrenom.setBackground(Color.LIGHT_GRAY);
				
				ListPersonnePrenom.setModel(new AbstractListModel() {
					public int getSize() {
						return 
								malistePersPrenom.size();
					}
					public Object getElementAt(int index) {
						return malistePersPrenom.keySet().toArray()[index];
					}
				});
				ListPersNom.setModel(new AbstractListModel() {
					public int getSize() {
						return listePers.size();
					}
					public Object getElementAt(int index) {
						return listePers.keySet().toArray()[index];
					}
				});
				
				ListPersID.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersID.size();
					}
					public Object getElementAt(int index) {
						return malistePersID.keySet().toArray()[index];
					}
				});
				//MAJ
				ListPersNom.revalidate();
				ListPersNom.repaint();
				ListPersID.revalidate();
				ListPersID.repaint();
				ListPersonneID.revalidate();
				ListPersonneID.repaint();
				listPersonne.revalidate();
				listPersonne.repaint();
				ListPersonneMail.revalidate();
				ListPersonneMail.repaint();
				ListPersonnePrenom.revalidate();
				ListPersonnePrenom.repaint();
			}
		});
		btnAjouterPersonne.setBounds(189, 101, 84, 20);
		panelPersonne.add(btnAjouterPersonne);
		
		JButton btnSupprimerPersonne = new JButton("Supprimer");
		

		
		btnSupprimerPersonne.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						listePers.clear();
						malistePersID.clear();
						malistePersMail.clear();
						malistePersPrenom.clear();
						ListPersonneID.revalidate();
						ListPersonneID.repaint();
						listPersonne.revalidate();
						listPersonne.repaint();
						ListPersonneMail.revalidate();
						ListPersonneMail.repaint();
						ListPersonnePrenom.revalidate();
						ListPersonnePrenom.repaint();
						ListPersNom.revalidate();
						ListPersNom.repaint();
						ListPersID.revalidate();
						ListPersID.repaint();
						final HashMap<String, Integer> listePers = database.Connexion.AfficherPersonnes();
						final HashMap<Integer, String> malistePersID = database.Connexion.AfficherPersonnesID();
						final HashMap<String, Integer> malistePersPrenom = database.Connexion.AfficherPersonnesPrenom();
						final HashMap<String, Integer> malistePersMail = database.Connexion.AfficherPersonnesMail();
						listPersonne.setModel(new AbstractListModel() {
							public int getSize() {
								return listePers.size();
							}
							public Object getElementAt(int index) {
								return listePers.keySet().toArray()[index];
							}
						});
						ListPersonneID.setModel(new AbstractListModel() {
							public int getSize() {
								return malistePersID.size();
							}
							public Object getElementAt(int index) {
								return malistePersID.keySet().toArray()[index];
							}
						});
						ListPersonneMail.setModel(new AbstractListModel() {
							public int getSize() {
								return malistePersMail.size();
							}
							public Object getElementAt(int index) {
								return malistePersMail.keySet().toArray()[index];
							}
						});
						ListPersonnePrenom.setBackground(Color.LIGHT_GRAY);
						
						ListPersonnePrenom.setModel(new AbstractListModel() {
							public int getSize() {
								return 
										malistePersPrenom.size();
							}
							public Object getElementAt(int index) {
								return malistePersPrenom.keySet().toArray()[index];
							}
						});
						ListPersNom.setModel(new AbstractListModel() {
							public int getSize() {
								return listePers.size();
							}
							public Object getElementAt(int index) {
								return listePers.keySet().toArray()[index];
							}
						});
						
						ListPersID.setModel(new AbstractListModel() {
							public int getSize() {
								return malistePersID.size();
							}
							public Object getElementAt(int index) {
								return malistePersID.keySet().toArray()[index];
							}
						});
						//MAJ
						ListPersNom.revalidate();
						ListPersNom.repaint();
						ListPersID.revalidate();
						ListPersID.repaint();
						ListPersonneID.revalidate();
						ListPersonneID.repaint();
						listPersonne.revalidate();
						listPersonne.repaint();
						ListPersonneMail.revalidate();
						ListPersonneMail.repaint();
						ListPersonnePrenom.revalidate();
						ListPersonnePrenom.repaint();
					}
				});
		btnSupprimerPersonne.setBounds(173, 182, 100, 20);
		panelPersonne.add(btnSupprimerPersonne);
		

		JButton btnModifNomPersonne = new JButton("Modifier");
		btnModifNomPersonne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listePers.clear();
				malistePersID.clear();
				malistePersMail.clear();
				malistePersPrenom.clear();
				ListPersonneID.revalidate();
				ListPersonneID.repaint();
				listPersonne.revalidate();
				listPersonne.repaint();
				ListPersonneMail.revalidate();
				ListPersonneMail.repaint();
				ListPersonnePrenom.revalidate();
				ListPersonnePrenom.repaint();
				ListPersNom.revalidate();
				ListPersNom.repaint();
				ListPersID.revalidate();
				ListPersID.repaint();
				final HashMap<String, Integer> listePers = database.Connexion.AfficherPersonnes();
				final HashMap<Integer, String> malistePersID = database.Connexion.AfficherPersonnesID();
				final HashMap<String, Integer> malistePersPrenom = database.Connexion.AfficherPersonnesPrenom();
				final HashMap<String, Integer> malistePersMail = database.Connexion.AfficherPersonnesMail();
				listPersonne.setModel(new AbstractListModel() {
					public int getSize() {
						return listePers.size();
					}
					public Object getElementAt(int index) {
						return listePers.keySet().toArray()[index];
					}
				});
				ListPersonneID.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersID.size();
					}
					public Object getElementAt(int index) {
						return malistePersID.keySet().toArray()[index];
					}
				});
				ListPersonneMail.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersMail.size();
					}
					public Object getElementAt(int index) {
						return malistePersMail.keySet().toArray()[index];
					}
				});
				ListPersonnePrenom.setBackground(Color.LIGHT_GRAY);
				
				ListPersonnePrenom.setModel(new AbstractListModel() {
					public int getSize() {
						return 
								malistePersPrenom.size();
					}
					public Object getElementAt(int index) {
						return malistePersPrenom.keySet().toArray()[index];
					}
				});
				ListPersNom.setModel(new AbstractListModel() {
					public int getSize() {
						return listePers.size();
					}
					public Object getElementAt(int index) {
						return listePers.keySet().toArray()[index];
					}
				});
				
				ListPersID.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersID.size();
					}
					public Object getElementAt(int index) {
						return malistePersID.keySet().toArray()[index];
					}
				});
				//MAJ
				ListPersNom.revalidate();
				ListPersNom.repaint();
				ListPersID.revalidate();
				ListPersID.repaint();
				ListPersonneID.revalidate();
				ListPersonneID.repaint();
				listPersonne.revalidate();
				listPersonne.repaint();
				ListPersonneMail.revalidate();
				ListPersonneMail.repaint();
				ListPersonnePrenom.revalidate();
				ListPersonnePrenom.repaint();
			}
		});
		btnModifNomPersonne.setBounds(189, 240, 84, 20);
		panelPersonne.add(btnModifNomPersonne);
		
		
				
			
				
				
				
				listPersonne.setForeground(Color.BLACK);
				listPersonne.setBackground(Color.LIGHT_GRAY);
				
		listPersonne.setBounds(317, 45, 59, 168);
		
		ListCandidatIdCandidat.setModel(new AbstractListModel() {
			public int getSize() {
				return malisteEquipeIDID.size();
			}
			public Object getElementAt(int index) {
				return malisteEquipeIDID.keySet().toArray()[index];
			}
		});
		listCompetition.setFont(new Font("Tahoma", Font.PLAIN, 10));
		listCompetition.setValueIsAdjusting(true);
		listCompetition.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		ListCompetIDCompet.setModel(new AbstractListModel() {
			public int getSize() {
				return malisteEquipeIDIDID.size();
			}
			public Object getElementAt(int index) {
				return malisteEquipeIDIDID.keySet().toArray()[index];
			}
		});
		
		panelPersonne.add(listPersonne);
		
		NomPersSuppr = new JTextField();
		NomPersSuppr.setText("Nom");
		NomPersSuppr.setBounds(10, 182, 100, 23);
		panelPersonne.add(NomPersSuppr);
		NomPersSuppr.setColumns(10);
		JButton btnModifPrenomPersonne = new JButton("Modifier");
		btnModifPrenomPersonne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listePers.clear();
				malistePersID.clear();
				malistePersMail.clear();
				malistePersPrenom.clear();
				ListPersonneID.revalidate();
				ListPersonneID.repaint();
				listPersonne.revalidate();
				listPersonne.repaint();
				ListPersonneMail.revalidate();
				ListPersonneMail.repaint();
				ListPersonnePrenom.revalidate();
				ListPersonnePrenom.repaint();
				ListPersNom.revalidate();
				ListPersNom.repaint();
				ListPersID.revalidate();
				ListPersID.repaint();
				final HashMap<String, Integer> listePers = database.Connexion.AfficherPersonnes();
				final HashMap<Integer, String> malistePersID = database.Connexion.AfficherPersonnesID();
				final HashMap<String, Integer> malistePersPrenom = database.Connexion.AfficherPersonnesPrenom();
				final HashMap<String, Integer> malistePersMail = database.Connexion.AfficherPersonnesMail();
				listPersonne.setModel(new AbstractListModel() {
					public int getSize() {
						return listePers.size();
					}
					public Object getElementAt(int index) {
						return listePers.keySet().toArray()[index];
					}
				});
				ListPersonneID.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersID.size();
					}
					public Object getElementAt(int index) {
						return malistePersID.keySet().toArray()[index];
					}
				});
				ListPersonneMail.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersMail.size();
					}
					public Object getElementAt(int index) {
						return malistePersMail.keySet().toArray()[index];
					}
				});
				ListPersonnePrenom.setBackground(Color.LIGHT_GRAY);
				
				ListPersonnePrenom.setModel(new AbstractListModel() {
					public int getSize() {
						return 
								malistePersPrenom.size();
					}
					public Object getElementAt(int index) {
						return malistePersPrenom.keySet().toArray()[index];
					}
				});
				ListPersNom.setModel(new AbstractListModel() {
					public int getSize() {
						return listePers.size();
					}
					public Object getElementAt(int index) {
						return listePers.keySet().toArray()[index];
					}
				});
				
				ListPersID.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersID.size();
					}
					public Object getElementAt(int index) {
						return malistePersID.keySet().toArray()[index];
					}
				});
				//MAJ
				ListPersNom.revalidate();
				ListPersNom.repaint();
				ListPersID.revalidate();
				ListPersID.repaint();
				ListPersonneID.revalidate();
				ListPersonneID.repaint();
				listPersonne.revalidate();
				listPersonne.repaint();
				ListPersonneMail.revalidate();
				ListPersonneMail.repaint();
				ListPersonnePrenom.revalidate();
				ListPersonnePrenom.repaint();
			}
		});
		btnModifPrenomPersonne.setBounds(189, 271, 84, 20);
		panelPersonne.add(btnModifPrenomPersonne);
		JButton btnModifMailPersonne = new JButton("Modifier");
		btnModifMailPersonne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listePers.clear();
				malistePersID.clear();
				malistePersMail.clear();
				malistePersPrenom.clear();
				ListPersonneID.revalidate();
				ListPersonneID.repaint();
				listPersonne.revalidate();
				listPersonne.repaint();
				ListPersonneMail.revalidate();
				ListPersonneMail.repaint();
				ListPersonnePrenom.revalidate();
				ListPersonnePrenom.repaint();
				ListPersNom.revalidate();
				ListPersNom.repaint();
				ListPersID.revalidate();
				ListPersID.repaint();
				final HashMap<String, Integer> listePers = database.Connexion.AfficherPersonnes();
				final HashMap<Integer, String> malistePersID = database.Connexion.AfficherPersonnesID();
				final HashMap<String, Integer> malistePersPrenom = database.Connexion.AfficherPersonnesPrenom();
				final HashMap<String, Integer> malistePersMail = database.Connexion.AfficherPersonnesMail();
				listPersonne.setModel(new AbstractListModel() {
					public int getSize() {
						return listePers.size();
					}
					public Object getElementAt(int index) {
						return listePers.keySet().toArray()[index];
					}
				});
				ListPersonneID.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersID.size();
					}
					public Object getElementAt(int index) {
						return malistePersID.keySet().toArray()[index];
					}
				});
				ListPersonneMail.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersMail.size();
					}
					public Object getElementAt(int index) {
						return malistePersMail.keySet().toArray()[index];
					}
				});
				ListPersonnePrenom.setBackground(Color.LIGHT_GRAY);
				
				ListPersonnePrenom.setModel(new AbstractListModel() {
					public int getSize() {
						return 
								malistePersPrenom.size();
					}
					public Object getElementAt(int index) {
						return malistePersPrenom.keySet().toArray()[index];
					}
				});
				ListPersNom.setModel(new AbstractListModel() {
					public int getSize() {
						return listePers.size();
					}
					public Object getElementAt(int index) {
						return listePers.keySet().toArray()[index];
					}
				});
				
				ListPersID.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersID.size();
					}
					public Object getElementAt(int index) {
						return malistePersID.keySet().toArray()[index];
					}
				});
				//MAJ
				ListPersNom.revalidate();
				ListPersNom.repaint();
				ListPersID.revalidate();
				ListPersID.repaint();
				ListPersonneID.revalidate();
				ListPersonneID.repaint();
				listPersonne.revalidate();
				listPersonne.repaint();
				ListPersonneMail.revalidate();
				ListPersonneMail.repaint();
				ListPersonnePrenom.revalidate();
				ListPersonnePrenom.repaint();
			}
		});
		btnModifMailPersonne.setBounds(189, 301, 84, 22);
		panelPersonne.add(btnModifMailPersonne);
		
		
				JList list_1 = new JList();
				list_1.setBounds(442, 45, 1, 1);
				panelPersonne.add(list_1);
				
				
				panelPersonne.add(getListPersonnePrenom());
				
	
				panelPersonne.add(getListPersonneMail());
				
	
				panelPersonne.add(getlblNewLabel_1());
				
			
				panelPersonne.add(getlblNewLabel_2());
				
	
				panelPersonne.add(getlblNewLabel_3());
				
			
				panelPersonne.add(getlblNewLabel_4());
				

				panelPersonne.add(getListPersonneEquipe());
				

				panelPersonne.add(getListPersonneCompet());
				
	
				panelPersonne.add(getListPersonneCompetID());
				
				
				panelPersonne.add(getListPersonneEquipeID());
				

				panelPersonne.add(getlblIdEquipe());
				
	
				panelPersonne.add(getlblNewLabel_11());
				
	
				panelPersonne.add(getlabel());
				
		
				panelPersonne.add(getlblIdCompet_1());
				
			
				panelPersonne.add(getlblPersonneDansUne());
				
				
				panelPersonne.add(getlblPersonneDansUne_1());
				
		

				JPanel panelEquipe = new JPanel();
				tabbedPane.addTab("Equipe", null, panelEquipe, null);
				panelEquipe.setLayout(null);
	
				
				JLabel lblGestionDesquipes = new JLabel("Gestion des équipes");
				JPanel panelCompetition = new JPanel();
				
						btnAjouterPersonne.addActionListener(new ajouterPersonne());
						btnSupprimerPersonne.addActionListener(new supprimerPersonne());
						btnModifNomPersonne.addActionListener(new modifierNomPersonne());
						btnModifPrenomPersonne.addActionListener(new modifierPrenomPersonne());
						btnModifMailPersonne.addActionListener(new modifierMailPersonne());
						frmGestionDesComptitions.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelAccueil, tabbedPane, getLblGestionDesInscriptions(), panelEquipe, lblGestionDesquipes, panelPersonne, panelCompetition}));
		
		
		
		
	
		panelCompetition.setToolTipText("");
		tabbedPane.addTab("Competition", null, panelCompetition, null);
		panelCompetition.setLayout(null);

		

		JLabel lblGestionDesComptitions = new JLabel("Gestion des compétitions");
		lblGestionDesComptitions.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblGestionDesComptitions.setBounds(188, 5, 226, 23);
		panelCompetition.add(lblGestionDesComptitions);
		
		JLabel label_1 = new JLabel("Pour ajouter une compétition :");
		label_1.setFont(new Font("Verdana", Font.BOLD, 12));
		label_1.setBounds(10, 45, 207, 14);
		panelCompetition.add(label_1);
		
		JLabel label_8 = new JLabel("Pour supprimer une compétition");
		label_8.setFont(new Font("Verdana", Font.BOLD, 12));
		label_8.setBounds(9, 159, 225, 14);
		panelCompetition.add(label_8);
		
		JLabel lblPourModifierNom = new JLabel("Pour modifier nom compétition");
		lblPourModifierNom.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourModifierNom.setBounds(9, 228, 225, 14);
		panelCompetition.add(lblPourModifierNom);
		
		JButton btnAjouterCompetition = new JButton("Ajouter");
		btnAjouterCompetition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listeCompet.clear();
				malisteCompetID.clear();
				malisteCompetDate.clear();
				ListCompetID.revalidate();
				ListCompetID.repaint();
				listCompetition.revalidate();
				listCompetition.repaint();
				listCompetitionDate.revalidate();
				listCompetitionDate.repaint();
				final HashMap<String, Integer> listeCompet = database.Connexion.AfficherCompetitions();
				final HashMap<Integer, String> malisteCompetID = database.Connexion.AfficherCompetitionsID();
				final HashMap<String, Integer> malisteCompetDate = database.Connexion.AfficherCompetitionsDate();
				listCompetition.setModel(new AbstractListModel() {
					public int getSize() {
						return listeCompet.size();
					}
					public Object getElementAt(int index) {
						return listeCompet.keySet().toArray()[index];
					}
				});
				ListCompetID.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteCompetID.size();
					}
					public Object getElementAt(int index) {
						return malisteCompetID.keySet().toArray()[index];
					}
				});
				listCompetitionDate.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteCompetDate.size();
					}
					public Object getElementAt(int index) {
						return malisteCompetDate.keySet().toArray()[index];
					}
				});
				listCompetition.revalidate();
				listCompetition.repaint();
				ListCompetID.revalidate();
				ListCompetID.repaint();
				listCompetitionDate.revalidate();
				listCompetitionDate.repaint();
			}
			
		});
		btnAjouterCompetition.setBounds(189, 86, 84, 20);
		panelCompetition.add(btnAjouterCompetition);
		
	
		
		JButton btnModifierCompetition = new JButton("Modifier");
		btnModifierCompetition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listeCompet.clear();
				malisteCompetID.clear();
				malisteCompetDate.clear();
				ListCompetID.revalidate();
				ListCompetID.repaint();
				listCompetition.revalidate();
				listCompetition.repaint();
				listCompetitionDate.revalidate();
				listCompetitionDate.repaint();
				final HashMap<String, Integer> listeCompet = database.Connexion.AfficherCompetitions();
				final HashMap<Integer, String> malisteCompetID = database.Connexion.AfficherCompetitionsID();
				final HashMap<String, Integer> malisteCompetDate = database.Connexion.AfficherCompetitionsDate();
				listCompetition.setModel(new AbstractListModel() {
					public int getSize() {
						return listeCompet.size();
					}
					public Object getElementAt(int index) {
						return listeCompet.keySet().toArray()[index];
					}
				});
				ListCompetID.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteCompetID.size();
					}
					public Object getElementAt(int index) {
						return malisteCompetID.keySet().toArray()[index];
					}
				});
				listCompetitionDate.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteCompetDate.size();
					}
					public Object getElementAt(int index) {
						return malisteCompetDate.keySet().toArray()[index];
					}
				});
				listCompetition.revalidate();
				listCompetition.repaint();
				ListCompetID.revalidate();
				ListCompetID.repaint();
				listCompetitionDate.revalidate();
				listCompetitionDate.repaint();
			}
		});
		btnModifierCompetition.setBounds(189, 256, 84, 20);
		panelCompetition.add(btnModifierCompetition);
		
		txtNomCompetition = new JTextField();
		txtNomCompetition.setText("Nom");
		txtNomCompetition.setColumns(10);
		txtNomCompetition.setBounds(10, 70, 100, 20);
		panelCompetition.add(txtNomCompetition);
		
		
		txtDateCompetition = new JTextField();
		txtDateCompetition.setText("Date(yyyy-mm-dd)");
		txtDateCompetition.setColumns(10);
		txtDateCompetition.setBounds(10, 101, 100, 20);
		panelCompetition.add(txtDateCompetition);
		
		txtNomCompetition2 = new JTextField();
		txtNomCompetition2.setText("Ancien Nom");
		txtNomCompetition2.setColumns(10);
		txtNomCompetition2.setBounds(10, 255, 98, 20);
		panelCompetition.add(txtNomCompetition2);
		
		JButton btnSupprimerCompetition = new JButton("Supprimer");
		btnSupprimerCompetition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listeCompet.clear();
				malisteCompetID.clear();
				malisteCompetDate.clear();
				ListCompetID.revalidate();
				ListCompetID.repaint();
				listCompetition.revalidate();
				listCompetition.repaint();
				listCompetitionDate.revalidate();
				listCompetitionDate.repaint();
				final HashMap<String, Integer> listeCompet = database.Connexion.AfficherCompetitions();
				final HashMap<Integer, String> malisteCompetID = database.Connexion.AfficherCompetitionsID();
				final HashMap<String, Integer> malisteCompetDate = database.Connexion.AfficherCompetitionsDate();
				listCompetition.setModel(new AbstractListModel() {
					public int getSize() {
						return listeCompet.size();
					}
					public Object getElementAt(int index) {
						return listeCompet.keySet().toArray()[index];
					}
				});
				ListCompetID.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteCompetID.size();
					}
					public Object getElementAt(int index) {
						return malisteCompetID.keySet().toArray()[index];
					}
				});
				listCompetitionDate.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteCompetDate.size();
					}
					public Object getElementAt(int index) {
						return malisteCompetDate.keySet().toArray()[index];
					}
				});
				listCompetition.revalidate();
				listCompetition.repaint();
				ListCompetID.revalidate();
				ListCompetID.repaint();
				listCompetitionDate.revalidate();
				listCompetitionDate.repaint();
			}
		});
		btnSupprimerCompetition.setBounds(174, 191, 100, 20);
		panelCompetition.add(btnSupprimerCompetition);
		ListCompetID.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListCompetID.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListCompetID.setBackground(Color.LIGHT_GRAY);
		listCompetitionDate.setFont(new Font("Tahoma", Font.PLAIN, 10));
		listCompetitionDate.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listCompetitionDate.setBackground(Color.LIGHT_GRAY);
		
		listCompetitionDate.setModel(new AbstractListModel() {
			public int getSize() {
				return malisteCompetDate.size();
			}
			public Object getElementAt(int index) {
				return malisteCompetDate.keySet().toArray()[index];
			}
		});
	
		ListCompetID.setModel(new AbstractListModel() {
			public int getSize() {
				return malisteCompetID.size();
			}
			public Object getElementAt(int index) {
				return malisteCompetID.keySet().toArray()[index];
			}
		});
		listCompetition.setFont(new Font("Tahoma", Font.PLAIN, 10));
		listCompetition.setValueIsAdjusting(true);
		listCompetition.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		listCompetition.setModel(new AbstractListModel() {
			public int getSize() {
				return listeCompet.size();
			}
			public Object getElementAt(int index) {
				return listeCompet.keySet().toArray()[index];
			}
		});
		
		
		panelCompetition.add(getlistCompetition());
		
		panelCompetition.add(getchckbxCompetitionEnEquipe());
		
		panelCompetition.add(getNomCompetSuppr());
		
		panelCompetition.add(getListCompetID());
		
		panelCompetition.add(gettxtNouveauNom());
		txtNouveauNom.setColumns(10);
				
		panelCompetition.add(getlblNewLabel_7());
		
		panelCompetition.add(getlblNewLabel_8());
		

		

		lblGestionDesquipes.setBounds(188, 5, 170, 23);
		lblGestionDesquipes.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		panelEquipe.add(lblGestionDesquipes);
		
		panelEquipe.add(getlabel_2());
		
		panelEquipe.add(getlabel_5());
		
		
		
		JButton btnSupprimerEquipe = new JButton("Supprimer");
		btnSupprimerEquipe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listecandidat.clear();
				malisteEquipeID.clear();
				ListEquipeID.revalidate();
				ListEquipeID.repaint();
				list.revalidate();
				list.repaint();
				ListNom2.revalidate();
				ListNom2.repaint();
				ListEquipeID2.revalidate();
				ListEquipeID2.repaint();
				final HashMap<String, Integer> listecandidat = database.Connexion.AfficherLesEquipes();
				final HashMap<Integer, String> malisteEquipeID = database.Connexion.AfficherLesEquipesID();
				list.setModel(new AbstractListModel() {
					public int getSize() {
						return listecandidat.size();
					}
					public Object getElementAt(int index) {
						return listecandidat.keySet().toArray()[index];
					}
				});
				//Affiche liste ID Equipe 
				ListEquipeID.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteEquipeID.size();
					}
					public Object getElementAt(int index) {
						return malisteEquipeID.keySet().toArray()[index];
					}
					
				});
				ListNom2.setModel(new AbstractListModel() {
					public int getSize() {
						return listecandidat.size();
					}
					public Object getElementAt(int index) {
						return listecandidat.keySet().toArray()[index];
					}
				});
				//Affiche liste ID Equipe
				ListEquipeID2.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteEquipeID.size();
					}
					public Object getElementAt(int index) {
						return malisteEquipeID.keySet().toArray()[index];
					}
				});
				ListEquipeID.revalidate();
				ListEquipeID.repaint();
				list.revalidate();
				list.repaint();
				ListNom2.revalidate();
				ListNom2.repaint();
				ListEquipeID2.revalidate();
				ListEquipeID2.repaint();
			}
		});
		btnSupprimerEquipe.setBounds(173, 138, 100, 20);
		panelEquipe.add(btnSupprimerEquipe);
		
		JButton btnAjouterEquipe = new JButton("Ajouter");
		btnAjouterEquipe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listecandidat.clear();
				malisteEquipeID.clear();
				ListEquipeID.revalidate();
				ListEquipeID.repaint();
				list.revalidate();
				list.repaint();
				ListNom2.revalidate();
				ListNom2.repaint();
				ListEquipeID2.revalidate();
				ListEquipeID2.repaint();
				final HashMap<String, Integer> listecandidat = database.Connexion.AfficherLesEquipes();
				final HashMap<Integer, String> malisteEquipeID = database.Connexion.AfficherLesEquipesID();
				list.setModel(new AbstractListModel() {
					public int getSize() {
						return listecandidat.size();
					}
					public Object getElementAt(int index) {
						return listecandidat.keySet().toArray()[index];
					}
				});
				//Affiche liste ID Equipe 
				
				ListEquipeID.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteEquipeID.size();
					}
					public Object getElementAt(int index) {
						return malisteEquipeID.keySet().toArray()[index];
					}
					
				});
				ListNom2.setModel(new AbstractListModel() {
					public int getSize() {
						return listecandidat.size();
					}
					public Object getElementAt(int index) {
						return listecandidat.keySet().toArray()[index];
					}
				});
				//Affiche liste ID Equipe
				ListEquipeID2.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteEquipeID.size();
					}
					public Object getElementAt(int index) {
						return malisteEquipeID.keySet().toArray()[index];
					}
				});
				ListEquipeID.revalidate();
				ListEquipeID.repaint();
				list.revalidate();
				list.repaint();
				ListNom2.revalidate();
				ListNom2.repaint();
				ListEquipeID2.revalidate();
				ListEquipeID2.repaint();
			}
		});
		
		
		btnAjouterEquipe.setBounds(189, 70, 84, 20);
		panelEquipe.add(btnAjouterEquipe);
		
		
		panelEquipe.add(gettxtNomEquipe());
		
		
		panelEquipe.add(getlist());
		
		
		ListEquipeID.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListEquipeID.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListEquipeID.setBackground(Color.LIGHT_GRAY);
		
		
		
		panelEquipe.add(ListEquipeID);
		
		// Affiche Liste Nom Equipe
				list.setModel(new AbstractListModel() {
					public int getSize() {
						return listecandidat.size();
					}
					public Object getElementAt(int index) {
						return listecandidat.keySet().toArray()[index];
					}
				});
				//Affiche liste ID Equipe
				ListEquipeID.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteEquipeID.size();
					}
					public Object getElementAt(int index) {
						return malisteEquipeID.keySet().toArray()[index];
					}
				});
				

				JLabel lblNewLabel_5 = new JLabel("Id");
				lblNewLabel_5.setBounds(291, 30, 46, 14);
				panelEquipe.add(lblNewLabel_5);
				
				JLabel lblNewLabel_6 = new JLabel("Nom");
				lblNewLabel_6.setBounds(332, 30, 46, 14);
				panelEquipe.add(lblNewLabel_6);
				
				
				btnAjouterEquipe.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						listecandidat.clear();
						malisteEquipeID.clear();
						ListEquipeID.revalidate();
						ListEquipeID.repaint();
						list.revalidate();
						list.repaint();
						final HashMap<String, Integer> listecandidat = database.Connexion.AfficherLesEquipes();
						final HashMap<Integer, String> malisteEquipeID = database.Connexion.AfficherLesEquipesID();
						list.setModel(new AbstractListModel() {
							public int getSize() {
								return listecandidat.size();
							}
							public Object getElementAt(int index) {
								return listecandidat.keySet().toArray()[index];
							}
						});
						//Affiche liste ID Equipe
						ListEquipeID.setModel(new AbstractListModel() {
							public int getSize() {
								return malisteEquipeID.size();
							}
							public Object getElementAt(int index) {
								return malisteEquipeID.keySet().toArray()[index];
							}
						});
						ListEquipeID.revalidate();
						ListEquipeID.repaint();
						list.revalidate();
						list.repaint();
					}
				});
				
				
				
				JButton btnModifierNomEquipe = new JButton("Modifier Nom Equipe");
				btnModifierNomEquipe.setFont(new Font("Tahoma", Font.PLAIN, 10));
				btnModifierNomEquipe.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						listecandidat.clear();
						malisteEquipeID.clear();
						ListEquipeID.revalidate();
						ListEquipeID.repaint();
						list.revalidate();
						list.repaint();
						ListNom2.revalidate();
						ListNom2.repaint();
						ListEquipeID2.revalidate();
						ListEquipeID2.repaint();
						final HashMap<String, Integer> listecandidat = database.Connexion.AfficherLesEquipes();
						final HashMap<Integer, String> malisteEquipeID = database.Connexion.AfficherLesEquipesID();
						list.setModel(new AbstractListModel() {
							public int getSize() {
								return listecandidat.size();
							}
							public Object getElementAt(int index) {
								return listecandidat.keySet().toArray()[index];
							}
						});
						
						ListEquipeID.setModel(new AbstractListModel() {
							public int getSize() {
								return malisteEquipeID.size();
							}
							public Object getElementAt(int index) {
								return malisteEquipeID.keySet().toArray()[index];
							}
							
						});
						ListNom2.setModel(new AbstractListModel() {
							public int getSize() {
								return listecandidat.size();
							}
							public Object getElementAt(int index) {
								return listecandidat.keySet().toArray()[index];
							}
						});
						//Affiche liste ID Equipe
						ListEquipeID2.setModel(new AbstractListModel() {
							public int getSize() {
								return malisteEquipeID.size();
							}
							public Object getElementAt(int index) {
								return malisteEquipeID.keySet().toArray()[index];
							}
						});
						ListEquipeID.revalidate();
						ListEquipeID.repaint();
						list.revalidate();
						list.repaint();
						ListNom2.revalidate();
						ListNom2.repaint();
						ListEquipeID2.revalidate();
						ListEquipeID2.repaint();
					}
				});
				btnModifierNomEquipe.setBounds(131, 216, 142, 23);
				panelEquipe.add(btnModifierNomEquipe);
	
				list.setBounds(332, 45, 207, 141);
				panelEquipe.add(list);
				ListEquipeID.setBackground(Color.LIGHT_GRAY);
				
				
				ListEquipeID.setBounds(291, 45, 43, 141);
				panelEquipe.add(ListEquipeID);
				
				// Affiche Liste Nom Equipe
						list.setModel(new AbstractListModel() {
							public int getSize() {
								return listecandidat.size();
							}
							public Object getElementAt(int index) {
								return listecandidat.keySet().toArray()[index];
							}
						});
						//Affiche liste ID Equipe
						ListEquipeID.setModel(new AbstractListModel() {
							public int getSize() {
								return malisteEquipeID.size();
							}
							public Object getElementAt(int index) {
								return malisteEquipeID.keySet().toArray()[index];
							}
						});
						
						
						panelEquipe.add(getlblModifierLeNom());
						
						txtAncienNomEquipe = new JTextField();
						txtAncienNomEquipe.setText("Ancien nom");
						txtAncienNomEquipe.setBounds(10, 205, 86, 20);
						panelEquipe.add(txtAncienNomEquipe);
						txtAncienNomEquipe.setColumns(10);
						
						txtNouveauNomEquipe = new JTextField();
						txtNouveauNomEquipe.setText("Nouveau nom");
						txtNouveauNomEquipe.setBounds(10, 236, 86, 20);
						panelEquipe.add(txtNouveauNomEquipe);
						txtNouveauNomEquipe.setColumns(10);
						
						
						
						NomEquipeSuppr = new JTextField();
						NomEquipeSuppr.setText("Nom");
						NomEquipeSuppr.setBounds(10, 138, 86, 20);
						panelEquipe.add(NomEquipeSuppr);
						NomEquipeSuppr.setColumns(10);
						
	
						panelEquipe.add(getlblEquipeDansUne());
						
					
						panelEquipe.add(getListCandidatIdCandidat());
						
					
						panelEquipe.add(getListCompetIDCompet());
						
						
						panelEquipe.add(getlblIdCompet_2());
						
				
						panelEquipe.add(getlabel_3());
						


		
		

		listCompetitionDate.setBounds(473, 45, 86, 295);
		panelCompetition.add(listCompetitionDate);
		
		panelCompetition.add(getlblNewLabel_9());
		
		JPanel Inscriptions = new JPanel();
		tabbedPane.addTab("Inscrire", null, Inscriptions, null);
		Inscriptions.setLayout(null);
		

		Inscriptions.add(getlblInscription());
		
		txtIdPersonne_1 = new JTextField();
		txtIdPersonne_1.setText("N° personne");
		txtIdPersonne_1.setBounds(10, 73, 112, 20);
		Inscriptions.add(txtIdPersonne_1);
		txtIdPersonne_1.setColumns(10);
		
		Inscriptions.add(getlblInscriptionDaunCandidat());
		
		txtIdEquipe = new JTextField();
		txtIdEquipe.setText("N° équipe");
		txtIdEquipe.setBounds(10, 104, 112, 20);
		Inscriptions.add(txtIdEquipe);
		txtIdEquipe.setColumns(10);
		
		ListCompetID2.setModel(new AbstractListModel() {
			public int getSize() {
				return malisteCompetID.size();
			}
			public Object getElementAt(int index) {
				return malisteCompetID.keySet().toArray()[index];
			}
		});
		listCompetition.setFont(new Font("Tahoma", Font.PLAIN, 10));
		listCompetition.setValueIsAdjusting(true);
		listCompetition.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
	
		
		
		Inscriptions.add(getlblInscriptionDuneEquipe());
		
		Inscriptions.add(getlblPersonneAUne());
		
		txtIdCandidat = new JTextField();
		txtIdCandidat.setText("N° candidat");
		txtIdCandidat.setBounds(10, 222, 112, 20);
		Inscriptions.add(txtIdCandidat);
		txtIdCandidat.setColumns(10);
		
		txtIdCompetition_1 = new JTextField();
		txtIdCompetition_1.setText("N° competition");
		txtIdCompetition_1.setBounds(10, 253, 112, 20);
		Inscriptions.add(txtIdCompetition_1);
		txtIdCompetition_1.setColumns(10);
		
		JButton btnInscriptionPersEquipe = new JButton("INSCRIRE");
		btnInscriptionPersEquipe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				malistePersonneEquipeID.clear();
				malistePersonneEquipe.clear();
				ListPersonneEquipeID.revalidate();
				ListPersonneEquipeID.repaint();
				ListPersonneEquipe.revalidate();
				ListPersonneEquipe.repaint();
				final HashMap<Integer, String> malistePersonneEquipeID = database.Connexion.AfficherPersonnesHasEquipeID();
				final HashMap<Integer, String> malistePersonneEquipe = database.Connexion.AfficherPersonnesEquipe();
				ListPersonneEquipeID.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersonneEquipeID.size();
					}
					public Object getElementAt(int index) {
						return malistePersonneEquipeID.keySet().toArray()[index];
					}
				});
				
				ListPersonneEquipe.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersonneEquipe.size();
					}
					public Object getElementAt(int index) {
						return malistePersonneEquipe.keySet().toArray()[index];
					}
					
				});
				ListPersonneEquipeID.revalidate();
				ListPersonneEquipeID.repaint();
				ListPersonneEquipe.revalidate();
				ListPersonneEquipe.repaint();
				//ici
				
			}
		});
		btnInscriptionPersEquipe.setBounds(132, 83, 89, 23);
		Inscriptions.add(btnInscriptionPersEquipe);
		
	
		Inscriptions.add(getListEquipeID2());
		
		
		Inscriptions.add(getListNom2());
		
		ListNom2.setModel(new AbstractListModel() {
			public int getSize() {
				return listecandidat.size();
			}
			public Object getElementAt(int index) {
				return listecandidat.keySet().toArray()[index];
			}
		});
		//Affiche liste ID Equipe
		ListEquipeID2.setModel(new AbstractListModel() {
			public int getSize() {
				return malisteEquipeID.size();
			}
			public Object getElementAt(int index) {
				return malisteEquipeID.keySet().toArray()[index];
			}
		});
		
		Inscriptions.add(getListPersID());
		
		
		Inscriptions.add(getListPersNom());
		
		
	
		Inscriptions.add(getlblNewLabel_10());
		

		Inscriptions.add(getlblIdquipe());
		

		Inscriptions.add(getlblNomquipe());
		
		
		Inscriptions.add(getlblIdPersonne());
		
		
		Inscriptions.add(getlblNomPersonne());
		
		
		Inscriptions.add(getListCompetID2());

		
		Inscriptions.add(getListCompetName());
		
		
		
		Inscriptions.add(getlblIdCompet());
		
	
		Inscriptions.add(getlblNomComptition());
		
		JButton btnInscriptionCandCompet = new JButton("INSCRIRE");
		btnInscriptionCandCompet.addMouseListener(new MouseAdapter() {
			//oho
			@Override
			public void mouseClicked(MouseEvent e) {
				malistePersonneCompetID.clear();
				malistePersonneCompet.clear();
				malisteEquipeIDID.clear();
				malisteEquipeIDIDID.clear();
				ListPersonneCompetID.revalidate();
				ListPersonneCompetID.repaint();
				ListCandidatIdCandidat.revalidate();
				ListCandidatIdCandidat.repaint();
				ListPersonneCompet.revalidate();
				ListPersonneCompet.repaint();
				ListCompetIDCompet.revalidate();
				ListCompetIDCompet.repaint();
				final HashMap<Integer, String> malistePersonneCompet = database.Connexion.AfficherPersonnesCompet();
				final HashMap<Integer, String> malistePersonneCompetID = database.Connexion.AfficherPersonnesCompetID();
				final HashMap<Integer, String> malisteEquipeIDID = database.Connexion.AfficherEquipeCompetID();
				final HashMap<Integer, String> malisteEquipeIDIDID = database.Connexion.AfficherPersonnesPersonneID();
				ListPersonneCompetID.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersonneCompetID.size();
					}
					public Object getElementAt(int index) {
						return malistePersonneCompetID.keySet().toArray()[index];
					}
				});
				
				ListPersonneCompet.setModel(new AbstractListModel() {
					public int getSize() {
						return malistePersonneCompet.size();
					}
					public Object getElementAt(int index) {
						return malistePersonneCompet.keySet().toArray()[index];
					}
					
				});
				ListCandidatIdCandidat.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteEquipeIDID.size();
					}
					public Object getElementAt(int index) {
						return malisteEquipeIDID.keySet().toArray()[index];
					}
				});
				
				ListCompetIDCompet.setModel(new AbstractListModel() {
					public int getSize() {
						return malisteEquipeIDIDID.size();
					}
					public Object getElementAt(int index) {
						return malisteEquipeIDIDID.keySet().toArray()[index];
					}
					
				});
				ListPersonneCompetID.revalidate();
				ListPersonneCompetID.repaint();
				ListCandidatIdCandidat.revalidate();
				ListCandidatIdCandidat.repaint();
				ListPersonneCompet.revalidate();
				ListPersonneCompet.repaint();
				ListCompetIDCompet.revalidate();
				ListCompetIDCompet.repaint();
				
			}
		});
		btnInscriptionCandCompet.setBounds(132, 234, 89, 23);
		Inscriptions.add(btnInscriptionCandCompet);
		/*btnAfficherEquipes.addActionListener(new afficherEquipes());*/
		btnAjouterCompetition.addActionListener(new ajouterCompet());
		btnInscriptionPersEquipe.addActionListener(new ajouterPersEquipe());
		btnInscriptionCandCompet.addActionListener(new ajouterCandCompet());
		btnAjouterEquipe.addActionListener(new ajouterEquipe());
		btnSupprimerEquipe.addActionListener(new supprimerEquipe());
		btnSupprimerCompetition.addActionListener(new supprimerCompetition());
		btnModifierCompetition.addActionListener(new modifierNomCompetition());
		btnModifierNomEquipe.addActionListener(new modifierNomEquipe());
	}
	
	
	
	
	private Component getlblNomComptition()
	{
		JLabel lblNomComptition = new JLabel("Nom Compétition");
		lblNomComptition.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNomComptition.setBounds(323, 198, 93, 14);
		return lblNomComptition;
	}

	private Component getlblIdCompet()
	{
		JLabel lblIdCompet = new JLabel("Id compétition\r\n");
		lblIdCompet.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblIdCompet.setBounds(242, 198, 89, 14);
		return lblIdCompet;
	}

	private Component getListCompetName()
	{
		
		ListCompetName.setModel(new AbstractListModel() {
			public int getSize() {
				return listeCompet.size();
			}
			public Object getElementAt(int index) {
				return listeCompet.keySet().toArray()[index];
			}
		});
		
		ListCompetName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListCompetName.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListCompetName.setBackground(Color.LIGHT_GRAY);
		ListCompetName.setBounds(297, 211, 146, 135);
		return ListCompetName;
	}

	private Component getListCompetID2()
	{
		ListCompetID2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListCompetID2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListCompetID2.setBackground(Color.LIGHT_GRAY);
		ListCompetID2.setBounds(243, 211, 55, 135);
		return ListCompetID2;
	}

	private Component getlblNomPersonne()
	{
		JLabel lblNomPersonne = new JLabel("Nom personne");
		lblNomPersonne.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNomPersonne.setBounds(308, 21, 89, 14);
		return lblNomPersonne;
	}

	private Component getlblIdPersonne()
	{
		JLabel lblIdPersonne = new JLabel("Id personne");
		lblIdPersonne.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblIdPersonne.setBounds(243, 21, 80, 14);
		return lblIdPersonne;
	}

	private Component getlblNomquipe()
	{
		JLabel lblNomquipe = new JLabel("Nom équipe");
		lblNomquipe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNomquipe.setBounds(453, 21, 72, 14);
		return lblNomquipe;
	}

	private Component getlblIdquipe()
	{
		JLabel lblIdquipe = new JLabel("Id équipe");
		lblIdquipe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblIdquipe.setBounds(394, 21, 73, 14);
		return lblIdquipe;
	}

	private Component getlblNewLabel_10()
	{
		JLabel lblNewLabel_10 = new JLabel(" dans une equipe");
		lblNewLabel_10.setFont(new Font("Verdana", Font.BOLD, 11));
		lblNewLabel_10.setBounds(10, 48, 112, 14);
		return lblNewLabel_10;
	}

	private Component getListPersNom()
	{
		ListPersNom.setModel(new AbstractListModel() {
			public int getSize() {
				return listePers.size();
			}
			public Object getElementAt(int index) {
				return listePers.keySet().toArray()[index];
			}
		});
		
		ListPersNom.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListPersNom.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListPersNom.setBackground(Color.LIGHT_GRAY);
		ListPersNom.setBounds(296, 33, 93, 167);
		return ListPersNom;
	}

	private Component getListPersID()
	{
		ListPersID.setModel(new AbstractListModel() {
			public int getSize() {
				return malistePersID.size();
			}
			public Object getElementAt(int index) {
				return malistePersID.keySet().toArray()[index];
			}
		});
		ListPersID.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListPersID.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListPersID.setBackground(Color.LIGHT_GRAY);	
		ListPersID.setBounds(243, 33, 55, 167);
		return ListPersID;
	}

	private Component getListNom2()
	{
		ListNom2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListNom2.setBackground(Color.LIGHT_GRAY);
		ListNom2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
	
		ListNom2.setBounds(442, 33, 93, 167);
		return ListNom2;
	}

	private Component getListEquipeID2()
	{
		ListEquipeID2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListEquipeID2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListEquipeID2.setBackground(Color.LIGHT_GRAY);
	
		ListEquipeID2.setBounds(388, 33, 55, 167);
		return ListEquipeID2;
	}

	private Component getlblPersonneAUne()
	{
		JLabel lblPersonneAUne = new JLabel("personne à une compétition");
		lblPersonneAUne.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPersonneAUne.setBounds(10, 185, 189, 14);
		return lblPersonneAUne;
	}

	private Component getlblInscriptionDuneEquipe()
	{
		JLabel lblInscriptionDuneEquipe = new JLabel("Inscription d'une equipe ou d'une ");
		lblInscriptionDuneEquipe.setFont(new Font("Verdana", Font.BOLD, 12));
		lblInscriptionDuneEquipe.setBounds(10, 168, 223, 16);
		return lblInscriptionDuneEquipe;
	}

	private Component getlblInscriptionDaunCandidat()
	{
		JLabel lblInscriptionDaunCandidat = new JLabel("Inscription d'une personne");
		lblInscriptionDaunCandidat.setFont(new Font("Verdana", Font.BOLD, 11));
		lblInscriptionDaunCandidat.setBounds(10, 32, 288, 14);
		return lblInscriptionDaunCandidat;
	}

	private Component getlblInscription()
	{
		JLabel lblInscription = new JLabel("INSCRIPTION");
		lblInscription.setBounds(277, 5, 93, 16);
		lblInscription.setFont(new Font("Verdana", Font.BOLD, 12));
		return lblInscription;
	}

	private Component getlblNewLabel_9()
	{
		JLabel lblNewLabel_9 = new JLabel("Date de cloture");
		lblNewLabel_9.setBounds(473, 30, 109, 14);
		return lblNewLabel_9;
	}

	private Component getlabel_3()
	{
		JLabel label_3 = new JLabel("id comp");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_3.setBounds(385, 220, 46, 14);
		return label_3;
	}

	private Component getlblIdCompet_2()
	{
		JLabel lblIdCompet_2 = new JLabel("id équipe");
		lblIdCompet_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIdCompet_2.setBounds(339, 220, 46, 14);
		return lblIdCompet_2;
	}

	private Component getListCompetIDCompet()
	{
		ListCompetIDCompet.setForeground(Color.BLACK);
		ListCompetIDCompet.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListCompetIDCompet.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListCompetIDCompet.setBackground(Color.LIGHT_GRAY);
		ListCompetIDCompet.setBounds(385, 236, 35, 95);
		return ListCompetIDCompet;
	}

	private Component getListCandidatIdCandidat()
	{
		ListCandidatIdCandidat.setForeground(Color.BLACK);
		ListCandidatIdCandidat.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ListCandidatIdCandidat.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ListCandidatIdCandidat.setBackground(Color.LIGHT_GRAY);
		ListCandidatIdCandidat.setBounds(350, 236, 35, 95);
		return ListCandidatIdCandidat;
	}

	private Component getlblEquipeDansUne()
	{
		JLabel lblEquipeDansUne = new JLabel("Equipe inscrite dans une compétition");
		lblEquipeDansUne.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEquipeDansUne.setBounds(278, 197, 261, 14);
		return lblEquipeDansUne;
	}

	private Component getlblModifierLeNom()
	{
		JLabel lblModifierLeNom = new JLabel("Modifier le nom d'une equipe");
		lblModifierLeNom.setFont(new Font("Verdana", Font.BOLD, 12));
		lblModifierLeNom.setBounds(12, 180, 261, 14);
		return lblModifierLeNom;
	}

	private Component gettxtNomEquipe()
	{
		txtNomEquipe = new JTextField();
		txtNomEquipe.setText("Nom");
		txtNomEquipe.setColumns(10);
		txtNomEquipe.setBounds(10, 70, 80, 20);
		return txtNomEquipe;
	}

	private Component getlist()
	{
		list.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBackground(Color.LIGHT_GRAY);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(30);
		return list;
	}

	private Component getlabel_5()
	{
		JLabel label_5 = new JLabel("Pour ajouter une équipe :");
		label_5.setFont(new Font("Verdana", Font.BOLD, 12));
		label_5.setBounds(10, 45, 178, 14);
		return label_5;
	}

	private Component getlabel_2()
	{
		JLabel label_2 = new JLabel("Pour supprimer une équipe :");
		label_2.setFont(new Font("Verdana", Font.BOLD, 12));
		label_2.setBounds(10, 108, 187, 14);
		return label_2;
	}

	private Component getlblNewLabel_8()
	{
		JLabel lblNewLabel_8 = new JLabel("Nom");
		lblNewLabel_8.setBounds(332, 30, 46, 14);
		return lblNewLabel_8;
	}

	private Component getlblNewLabel_7()
	{
		JLabel lblNewLabel_7 = new JLabel("Id");
		lblNewLabel_7.setBounds(291, 30, 46, 14);
		return lblNewLabel_7;
	}

	private Component gettxtNouveauNom()
	{
		txtNouveauNom = new JTextField();
		txtNouveauNom.setText("Nouveau nom");
		txtNouveauNom.setBounds(10, 282, 100, 20);
		return txtNouveauNom;
	}

	private Component getListCompetID()
	{
		ListCompetID.setBounds(290, 45, 43, 295);
		return ListCompetID;
	}

	private Component getNomCompetSuppr()
	{
		NomCompetSuppr = new JTextField();
		NomCompetSuppr.setText("Nom\r\n");
		NomCompetSuppr.setColumns(10);
		NomCompetSuppr.setBounds(10, 190, 86, 20);
		return NomCompetSuppr;
	}

	private Component getchckbxCompetitionEnEquipe()
	{
		chckbxCompetitionEnEquipe = new JCheckBox("compétition en équipe");
		chckbxCompetitionEnEquipe.setBounds(10, 128, 131, 23);
		return chckbxCompetitionEnEquipe;
	}

	private Component getlistCompetition()
	{
		listCompetition.setForeground(Color.BLACK);
		listCompetition.setBackground(Color.LIGHT_GRAY);
		listCompetition.setBounds(332, 45, 141, 295);
		return listCompetition;
	}

	private Component getlblPersonneDansUne_1()
	{
		JLabel lblPersonneDansUne_1 = new JLabel("Personne dans une équipe\r\n");
		lblPersonneDansUne_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPersonneDansUne_1.setBounds(447, 229, 195, 14);
		return lblPersonneDansUne_1;
	}

	private Component getlblPersonneDansUne()
	{
		JLabel lblPersonneDansUne = new JLabel("Personne inscrite dans une compétition");
		lblPersonneDansUne.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPersonneDansUne.setBounds(232, 217, 225, 14);
		return lblPersonneDansUne;
	}

	private Component getlblIdCompet_1()
	{
		JLabel lblIdCompet_1 = new JLabel("id compet");
		lblIdCompet_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIdCompet_1.setBounds(328, 240, 46, 14);
		return lblIdCompet_1;
	}

	private Component getlabel()
	{
		JLabel label = new JLabel("id pers\r\n");
		label.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label.setBounds(489, 240, 46, 14);
		return label;
	}

	private Component getlblNewLabel_11()
	{
		JLabel lblNewLabel_11 = new JLabel("id equipe");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_11.setBounds(525, 241, 46, 14);
		return lblNewLabel_11;
	}

	private Component getlblIdEquipe()
	{
		JLabel lblIdEquipe = new JLabel("id pers\r\n");
		lblIdEquipe.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIdEquipe.setBounds(291, 241, 46, 14);
		return lblIdEquipe;
	}

	private Component getListPersonneEquipeID()
	{
		ListPersonneEquipeID.setBounds(489, 254, 35, 95);
		return ListPersonneEquipeID;
	}

	private Component getListPersonneCompetID()
	{
		ListPersonneCompetID.setBounds(293, 254, 35, 95);
		return ListPersonneCompetID;
	}

	private Component getListPersonneCompet()
	{
		ListPersonneCompet.setBounds(328, 254, 35, 95);
		return ListPersonneCompet;
	}

	private Component getListPersonneEquipe()
	{
		ListPersonneEquipe.setBounds(524, 254, 35, 95);
		return ListPersonneEquipe;
	}

	private Component getlblNewLabel_4()
	{
		JLabel lblNewLabel_4 = new JLabel("Mail");
		lblNewLabel_4.setBounds(437, 30, 46, 14);
		return lblNewLabel_4;
	}

	private Component getlblNewLabel_3()
	{
		JLabel lblNewLabel_3 = new JLabel("Prénom");
		lblNewLabel_3.setBounds(376, 30, 46, 14);
		return lblNewLabel_3;
	}

	private Component getlblNewLabel_2()
	{
		JLabel lblNewLabel_2 = new JLabel("Nom");
		lblNewLabel_2.setBounds(317, 30, 46, 14);
		return lblNewLabel_2;
	}

	private Component getlblNewLabel_1()
	{
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setBounds(291, 30, 46, 14);
		return lblNewLabel_1;
	}

	private Component getListPersonneMail()
	{
		ListPersonneMail.setBounds(437, 45, 122, 168);
		return ListPersonneMail;
	}

	private Component getListPersonnePrenom()
	{
		ListPersonnePrenom.setBounds(376, 45, 62, 168);
		return ListPersonnePrenom;
	}

	private Component gettxtNomPersonne()
	{
		txtNomPersonne = new JTextField();
		txtNomPersonne.setText("Nom");
		txtNomPersonne.setColumns(10);
		txtNomPersonne.setBounds(10, 70, 80, 20);
		return txtNomPersonne;
	}

	private Component gettxtPrenomPersonne()
	{
		txtPrenomPersonne = new JTextField();
		txtPrenomPersonne.setText("Prenom");
		txtPrenomPersonne.setColumns(10);
		txtPrenomPersonne.setBounds(10, 97, 80, 20);
		return txtPrenomPersonne;
	}

	private Component gettxtMailPersonne()
	{
		txtMailPersonne = new JTextField();
		txtMailPersonne.setText("Mail");
		txtMailPersonne.setColumns(10);
		txtMailPersonne.setBounds(10, 122, 80, 20);
		return txtMailPersonne;
	}

	private Component gettxtMailPersonne2()
	{
		txtMailPersonne2 = new JTextField();
		txtMailPersonne2.setText("Nouveau mail");
		txtMailPersonne2.setColumns(10);
		txtMailPersonne2.setBounds(93, 303, 91, 20);
		return txtMailPersonne2;
	}

	private Component gettxtNomPersonne2()
	{
		txtNomPersonne2 = new JTextField();
		txtNomPersonne2.setText("Nouveau nom");
		txtNomPersonne2.setColumns(10);
		txtNomPersonne2.setBounds(93, 241, 91, 20);
		return txtNomPersonne2;
	}

	private Component gettxtPrenomPersonne2()
	{
		txtPrenomPersonne2 = new JTextField();
		txtPrenomPersonne2.setText("Nouveau prénom");
		txtPrenomPersonne2.setBounds(93, 272, 91, 20);
		return txtPrenomPersonne2;
	}

	private Component gettxtAncienMail()
	{
		txtAncienMail = new JTextField();
		txtAncienMail.setText("Ancien mail");
		txtAncienMail.setBounds(10, 303, 80, 20);
		return txtAncienMail;
	}

	private Component gettxtAncienPrenom()
	{
		txtAncienPrenom = new JTextField();
		txtAncienPrenom.setText("Ancien prénom");
		txtAncienPrenom.setBounds(10, 272, 80, 20);
		return txtAncienPrenom;
	}

	private Component gettxtAncienNomPersonne()
	{
		txtAncienNomPersonne = new JTextField();
		txtAncienNomPersonne.setText("Ancien nom");
		txtAncienNomPersonne.setColumns(10);
		txtAncienNomPersonne.setBounds(10, 241, 80, 20);
		return txtAncienNomPersonne;
	}

	private Component getlabel_25()
	{
		JLabel label_25 = new JLabel("Pour ajouter une personne :");
		label_25.setFont(new Font("Verdana", Font.BOLD, 12));
		label_25.setBounds(10, 45, 207, 14);
		return label_25;
	}

	private Component getlabel_22()
	{
		JLabel label_22 = new JLabel("Pour supprimer une personne");
		label_22.setFont(new Font("Verdana", Font.BOLD, 12));
		label_22.setBounds(10, 157, 225, 14);
		return label_22;
	}

	private Component getlabel_19()
	{
		JLabel label_19 = new JLabel("Pour modifier une personne");
		label_19.setFont(new Font("Verdana", Font.BOLD, 12));
		label_19.setBounds(10, 216, 225, 14);
		return label_19;
	}

	private Component getlblGestionDesPersonnes()
	{
		JLabel lblGestionDesPersonnes = new JLabel("Gestion des personnes");
		lblGestionDesPersonnes.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblGestionDesPersonnes.setBounds(188, 5, 200, 23);
		return lblGestionDesPersonnes;
	}

	private Component getlblPersonne_1()
	{
		JLabel lblPersonne_1 = new JLabel("- Personne : ");
		lblPersonne_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPersonne_1.setBounds(30, 246, 100, 14);
		return lblPersonne_1;
	}

	private Component getlblComptition()
	{
		JLabel lblComptition = new JLabel("- Compétition :");
		lblComptition.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComptition.setBounds(30, 276, 100, 14);
		return lblComptition;
	}

	private Component getlblEquipe_1()
	{
		JLabel lblEquipe_1 = new JLabel("- Equipe :");
		lblEquipe_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEquipe_1.setBounds(30, 213, 60, -14);
		return lblEquipe_1;
	}

	private Component getlblPersonne()
	{
		JLabel lblPersonne = new JLabel("Il permettra de gérer les personnes pour les compétitions (Ajout/Modification/Suppression)");
		lblPersonne.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPersonne.setBounds(100, 230, 496, 46);
		return lblPersonne;
	}

	private Component getlblCompetition()
	{
		JLabel lblCompetition = new JLabel("Il permettra de gérer les compétitions (Ajout/Modification/Suppression)");
		lblCompetition.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCompetition.setBounds(120, 268, 470, 30);
		return lblCompetition;
	}

	private Component getlblEquipe()
	{
		JLabel lblEquipe = new JLabel("  Il permettra de gérer les equipes pour les compétitions (Ajout/Modification/Suppression)");
		lblEquipe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEquipe.setBounds(78, 205, 470, 30);
		return lblEquipe;
	}

	private Component getlblDansCetteApplication()
	{
		JLabel lblDansCetteApplication = new JLabel("Dans cette application vous avez accès à 3 onglets :");
		lblDansCetteApplication.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblDansCetteApplication.setBounds(20, 164, 439, 30);
		return lblDansCetteApplication;
	}

	private Component getlblNewLabel()
	{
		JLabel lblNewLabel = new JLabel("Bienvenue dans l'application \"Gestion des Inscriptions Sportives\"");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 95, 480, 30);
		return lblNewLabel;
	}

	private Component getLblGestionDesInscriptions()
	{
		JLabel lblGestionDesInscriptions = new JLabel("Gestion des Inscriptions Sportives");
		lblGestionDesInscriptions.setForeground(Color.DARK_GRAY);
		lblGestionDesInscriptions.setBounds(73, 29, 400, 30);
		lblGestionDesInscriptions.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		return lblGestionDesInscriptions;
	}

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

	
	/////////////////////////////FONCTIONS BOUTONS-AFFICHAGES/////////////////////////////////////
	
	//AFFICHER LES CANDIDATS

	final DefaultListModel<String> model= new DefaultListModel<String>();

	private JTextField NomCompetSuppr;
	private JTextField NomPersSuppr;
	private JTextField txtAncienNomPersonne;
	private JTextField txtAncienPrenom;
	private JTextField txtPrenomPersonne2;
	private JTextField txtAncienMail;
	private JTextField txtNouveauNom;
	private JTextField txtAncienNomEquipe;
	private JTextField txtNouveauNomEquipe;
	
	private JTextField txtNouveauNom_1;
	private JTextField NomEquipeSuppr;
	private JTextField txtIdPersonne_1;
	private JTextField txtIdEquipe;
	private JTextField txtIdCandidat;
	private JTextField txtIdCompetition_1;

	public class afficherCandidats implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//afficher cette Map dans un ï¿½cran "AFFICHER LES CANDIDATS"//
			HashMap<String, Integer> listecandidat = database.Connexion.AfficherLesCandidats();
			System.out.println(listecandidat);
			System.out.println("bonjour!");
			
		}
	}
	
	//AFFICHER LES PERSONNES
	public class afficherPersonnes implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//afficher cette Map dans un ï¿½cran "AFFICHER LES PERSONNES"//
			HashMap<String, Integer> listePersonnes = database.Connexion.AfficherLesEquipes();
			System.out.println(listePersonnes);
			
		}
	}
	
	//AFFICHER LES COMPETITIONS
	public class afficherCompetition implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//afficher cette Map dans un ï¿½cran "AFFICHER LES COMPETITIONS"//
			HashMap<String, Integer> listeCompetition = database.Connexion.AfficherLesEquipes();
			/*System.out.println(listeCompetition);*/
			
		}
	}
	
	
	//AFFICHER LES EQUIPES
	public class afficherEquipe implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//afficher cette Map dans un ï¿½cran "AFFICHER LES EQUIPES"//
			HashMap<String, Integer> listeEquipe = database.Connexion.AfficherLesEquipes();
			System.out.println(listeEquipe);
			
		}
	}
	
	//AJOUTER UNE PERSONNE
	public class ajouterPersonne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nom = txtNomPersonne.getText();
			String prenom = txtPrenomPersonne.getText();
		    String mail = txtMailPersonne.getText();
		    if(nom != null || prenom != null || mail != null)
		    {
		    	
		    	Personne pers = Inscriptions.getInscriptions().createPersonne(nom, prenom, mail);
				personnes.add(pers);
				txtPrenomPersonne.setText("Prenom");
				txtNomPersonne.setText("Nom");
				txtMailPersonne.setText("Mail");
		    }
		    else
		    {
		    	//afficher un message sur l'ecran de gestion des personnes pour confirmer l'action//
		    }

			/*inscriptions.Connexion.AjouterPersonne(txtNomPersonne.getText(), txtMailPersonne.getText());
			txtNomPersonne.setText("Nom");
			txtMailPersonne.setText("Mail");*/

		}
	}
	

	
	//AJOUTER UNE COMPETITION

	public class ajouterCompet implements ActionListener 
	{
		//AbstractButton chckbxCompetitionEnEquipe; 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		public void actionPerformed(ActionEvent e) 
		{
			//choix est censï¿½ etre la valeur de la checkbox
			boolean choix = chckbxCompetitionEnEquipe.isSelected();
			String nom = txtNomCompetition.getText();
			try 
			{	
				
				java.util.Date dateCompet = format.parse(txtDateCompetition.getText());
				java.sql.Date sqlDateCompet = new java.sql.Date(dateCompet.getTime());
				Competition compet = Inscriptions.getInscriptions().createCompetition(nom, null, choix);
				/*inscriptions.Connexion.AjouterCompetition(txtNomCompetition.getText(), dateCompet);*/
				competitions.add(compet);
			} 
			catch (ParseException e1) 
			{
				e1.printStackTrace();
			}
			txtNomCompetition.setText("Nom");
			txtDateCompetition.setText("Date(YYYY-MM-DD)");
		}
	}
	
	//AJOUTER UNE EQUIPE
	public class ajouterEquipe implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nom = txtNomEquipe.getText();
			System.out.println(nom);
			Equipe equipe = Inscriptions.getInscriptions().createEquipe(nom);
			Equipe.add(equipe);
			
			
		}
	}
	
	//SUPPRIMER UNE EQUIPE
	public class supprimerEquipe implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Nom = NomEquipeSuppr.getText();
			
			database.Connexion.SupprimerCandidat(Nom);
		}
	}
	
	//SUPPRIMER UNE PERSONNE
	public class supprimerPersonne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Nom = NomPersSuppr.getText();
			database.Connexion.SupprimerPersonne(Nom);
		}
	}
	
	//SUPPRIMER UNE COMPETITION
	public class supprimerCompetition implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Nom = NomCompetSuppr.getText();
			database.Connexion.SupprimerCompetition(Nom);
		

		}
	}
	
	//AJOUTER CANDIDAT DANS COMPETITION
	public class ajouterCandCompet implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				//RECUPERATION DES ID ECRITS OU SELECTIONNES PAR L'USER 
			int idCand = Integer.parseInt(txtIdCandidat.getText());
			int idCompet = Integer.parseInt(txtIdCompetition_1.getText());
			try
			{
				database.Connexion.InscriptionCandidatCompetition(idCand,idCompet);
					
			} catch (NumberFormatException e1) 
			{
				System.out.println("____L'ajout n'a pas ete pris en compte____");
			}
			txtNomCompetition.setText("Nom");
			txtDateCompetition.setText("Date(YYYY-MM-DD)");
		}
	}
	
		//AJOUTER PERSONNE DANS EQUIPE
	public class ajouterPersEquipe implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//RECUPERATION DES ID ECRITS OU SELECTIONNES PAR L'USER 
			int idPers = Integer.parseInt(txtIdPersonne_1.getText());
			int idEquipe = Integer.parseInt(txtIdEquipe.getText());
			try
			{
				database.Connexion.inscriptionPersonneDansEquipe(idPers,idEquipe);
					
			} catch (NumberFormatException e1) 
			{
				System.out.println("____L'ajout n'a pas ete pris en compte____");
			}
			txtNomCompetition.setText("Nom");
			txtDateCompetition.setText("Date(YYYY-MM-DD)");
		}
	}
		
	//MODIFIER NOM D'UNE PERSONNE
	public class modifierNomPersonne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//RECUPERATION DES ID ECRITS OU SELECTIONNES PAR L'USER 
			String nouveauNom = txtNomPersonne2.getText();
			String ancienNom = txtAncienNomPersonne.getText();
			
			database.Connexion.modifierNomPersonne(ancienNom, nouveauNom);
			txtNomPersonne2.setText("Nom");
			
		}
	}
	
	//MODIFIER PRENOM D'UNE PERSONNE
	public class modifierPrenomPersonne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//RECUPERATION DES ID ECRITS OU SELECTIONNES PAR L'USER 
			String nouveauPrenom = txtPrenomPersonne2.getText();
			String ancienPrenom = txtAncienPrenom.getText();
			
			database.Connexion.modifierPrenomPersonne(ancienPrenom, nouveauPrenom);
			
			
		}
	}
	
	//MODIFIER MAIL D'UNE PERSONNE
		public class modifierMailPersonne implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				//RECUPERATION DES ID ECRITS OU SELECTIONNES PAR L'USER 
				String nouveauMail = txtMailPersonne2.getText();
				String ancienMail = txtAncienMail.getText();
				
				database.Connexion.modifierMailPersonne(ancienMail, nouveauMail);
				
				
			}
		}
		
	//MODIFIER NOM D'UNE COMPETITION old->txtNomCompetition2 new->
		public class modifierNomCompetition implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				//RECUPERATION DES ID ECRITS OU SELECTIONNES PAR L'USER 
				String nouveauNom = txtNouveauNom.getText();
				String ancienNom = txtNomCompetition2.getText();
				
				database.Connexion.modifierNomCompet(ancienNom, nouveauNom);
				
				
			}
		}
		//MODIFIER NOM D'UNE COMPETITION old->txtNomCompetition2 new->
				public class modifierNomEquipe implements ActionListener {
					public void actionPerformed(ActionEvent e) {
						//RECUPERATION DES ID ECRITS OU SELECTIONNES PAR L'USER 
						String nouveauNom = txtNouveauNomEquipe.getText();
						String ancienNom = txtAncienNomEquipe.getText();
						
						database.Connexion.modifierNomEquipe(ancienNom, nouveauNom);
						
						
					}
				}	
}