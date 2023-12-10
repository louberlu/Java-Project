/**
 * 
 */
package application;

import java.util.ArrayList;
import java.util.List;

import metier.*;

/**
 * @author NKILI OBELE Karen Fifi
 * 
 * {@summary Cette classe crée un objet Diff et instantie son comportement (méthode pour le calculer)}
 *
 */
public class Diff {
	/**
	 * @param diff Liste de tableau de 2 termes
	 */
	private List<Terme[]> diff;
	
	public Diff() {
		// TODO Auto-generated constructor stub
		this.diff = new ArrayList<Terme[]>();
	}
	
	private List<Terme[]> pairing(List<Terme> right, List<Terme> left) {
		List<Terme[]> res = new ArrayList<Terme[]>();
		int i = 0;
		
		for(Terme element : right) {
			Terme[] newElement = new Terme[2];
			if(element.isSkolem() && left.get(i).isType("Variable")) {
				newElement[0] = left.get(i);
				newElement[1] = element;
			}else {
				newElement[0] = element;
				newElement[1] = left.get(i);
			}
		    res.add(newElement);
		    i++;
		}
		
		return res;
	}
	
	private boolean isSimple() {
		for(Terme[] duo : this.diff) {
			if(duo[0].isEquals(duo[1])) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Cette méthode le diff de deux prédicats donnés en paramètre
	 */
	public void setDiff(Predicat[] couple) {
		List<Terme[]> liste = new ArrayList<Terme[]>();
		List<Terme[]> res = new ArrayList<Terme[]>();
		liste = this.pairing(couple[0].getPredicatDe(), couple[1].getPredicatDe());
		boolean simple;
		
		do{
			res = new ArrayList<Terme[]>();
			for(Terme[] element : liste) {
				if(element[0].isEquals(element[1]) == false) {
					res.add(element);
				}else if((element[0].isType("Fonction")==true) && (element[1].isType("Fonction")==true)) {
					for(Terme[] litt : this.pairing(((Fonction) element[0]).getFonctionDe(), ((Fonction) element[1]).getFonctionDe())) {
						if(litt[0].isEquals(litt[1]) == false) {
							res.add(litt);
						}
					}
				}
			}
			liste = res;
			diff = liste;
			simple = this.isSimple();
		}while(simple == false);
		diff = liste;
	}
	
	public boolean isAcceptable() {
		boolean res = false;
		
		for(Terme[] element : this.diff) {
			if(element[0].isType("Variable") || element[1].isType("Variable")) {
				res = true;
			}else {
				return false;
			}
		}
		
		return res;
	}
	
	public Terme[] getFirstCouple() {
		return this.diff.get(0);
	}
	
	public void printDiff() {
		String pgcu = "Diff: {";
		int i;
		
		for(Terme[] element : this.diff) {
			pgcu = pgcu + "{";
			pgcu = pgcu + element[0].getNomC();
			pgcu = pgcu + ",";
			pgcu = pgcu + element[1].getNomC();
			pgcu = pgcu + "},";
		}
		
		i = pgcu.length();
		pgcu = pgcu.substring(0, i-1);
		pgcu = pgcu + "}";
		System.out.println(pgcu);
	}
	
	public void printPair(List<Terme[]> AB) {
		String pgcu = "Pairing: {";
		int i;
		
		for(Terme[] element : AB) {
			pgcu = pgcu + "{";
			pgcu = pgcu + element[0].getNomC();
			pgcu = pgcu + ",";
			pgcu = pgcu + element[1].getNomC();
			pgcu = pgcu + "},";
		}
		
		i = pgcu.length();
		pgcu = pgcu.substring(0, i-1);
		pgcu = pgcu + "}";
		System.out.println(pgcu);
	}
}
