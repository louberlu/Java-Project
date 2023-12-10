/**
 * 
 */
package gui;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.*;
import application.PGCU;
import metier.Predicat;

/**
 * @author NKILI OBELE Karen Fifi
 *
 * {@summary Cette classe crée une fenetre et l'affiche. Cette fenètre est l'interface graphique de notre programme PGCU.}
 */

public class Fenetre extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param labelMessage Bloc de texte de la fenètre contenant le message
	 * @param champTexteA Le premier champ de texte
	 * @param champTexteB Le deuxième champ de texte
	 * @param boutonCalculer Le bouton "Calculer"
	 * @param labelResultat Element de la denètre contenant le résultat
	 */
	
	//Création d'une zone Message
    private JTextArea labelMessage;
    
    //Création de chzmps de texte
    private JTextField champTexteA;
    private JTextField champTexteB;
    
    //Création d'un bouton Calculer
    private JButton boutonCalculer;
    
    //Création d'une zone Resultat
    private JLabel labelResultat;
    
    //Création de font contenant la police, la taille et autres propriétés
	private Font fontTexte = new Font("Open Sans", Font.PLAIN, 12);
	private Font fontTitre = new Font("Open Sans", Font.BOLD,16);
	private Font fontBouton = new Font("Open Sans", Font.BOLD, 14);
	
	//Création de couleur
	
	private Color couleurBouton = new Color(0x6234CB);
	private Color couleurFenetre = new Color(0xDCD2F4);

    public Fenetre() {
    	
    	//Création de la fenètre
        super("Calcul du PGCU");

        Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(null);
        setSize(320, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation((ecran.width - getSize().width)/2, (ecran.height - getSize().height)/2);
        setBackground(couleurFenetre);
        
        //Création et ajout d'un bloc de texte
        labelMessage = new JTextArea(PGCU.instruction());
        labelMessage.setEditable(false);
        labelMessage.setBounds(10, 10, 280, 70);
        labelMessage.setFont(fontTexte);
        add(labelMessage);

        //Création et ajout des champs de texte
        champTexteA = new JTextField();
        champTexteA.setBounds(100, 100, 180, 20);
        champTexteA.setFont(fontTitre);
        add(champTexteA);

        JLabel labelA = new JLabel("Prédicat A: ");
        labelA.setBounds(10, 100, 100, 20);
        add(labelA);

        champTexteB = new JTextField();
        champTexteB.setBounds(100, 140, 180, 20);
        champTexteB.setFont(fontTitre);
        add(champTexteB);

        JLabel labelB = new JLabel("Prédicat B: ");
        labelB.setBounds(10, 140, 100, 20);
        add(labelB);

        //Création et ajout d'un bouton
        boutonCalculer = new JButton("Calculer");
        boutonCalculer.setBounds(100, 170, 100, 20);
        boutonCalculer.addActionListener(this);
        boutonCalculer.setFont(fontBouton);
        boutonCalculer.setBackground(couleurBouton);
        add(boutonCalculer);

        labelResultat = new JLabel("");
        labelResultat.setBounds(10, 200, 200, 20);
        labelResultat.setFont(fontTexte);
        add(labelResultat);

        //Afficher la fenètre
        setVisible(true);
    }

    /**
     * Cette méthode permet de réagir à chaque fois évènement de la fenètre
     * (Clavier, Souris, ...)
     */
    public void actionPerformed(ActionEvent e) {
    	//Condition pour un clique sur boutonCalculer
        if (e.getSource() == boutonCalculer) {
        	String texteA = champTexteA.getText();
        	String texteB = champTexteB.getText();
        	String texteR;
        	Predicat A = PGCU.stringToPredicat(texteA);
        	Predicat B = PGCU.stringToPredicat(texteB);
        	PGCU pgcu = new PGCU(A, B);
        	pgcu.setPGCU();
        	texteR = pgcu.getPGCU();
            labelResultat.setText(texteR);
        }
    }

    public static void main(String[] args) {
        new Fenetre();
    }
}
