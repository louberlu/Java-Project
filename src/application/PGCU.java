/**
 * 
 */
package application;
import metier.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NKILI OBELE Karen Fifi
 * 
 * {@summary Cette classe crée un objet PGCU et instantie son comportement (méthode pour le calculer)}
 *
 */
public class PGCU {

	/**
	 * @param teta De classe Teta
	 * @param diff De classe Diff
	 * @param A Le prédicat A
	 * @param B Le prédicat B
	 * @param sigma Un tableau de 2 termes
	 * @param pgcu Une liste de tableau de 2 termes
	 */
	
	Teta teta;
	Diff diff;
	Predicat A;
	Predicat B;
	Terme[] sigma;
	List<Terme[]> pgcu;
	
	
	public PGCU(Predicat A, Predicat B) {
		// TODO Auto-generated constructor stub
		this.teta = new Teta(A, B);
		this.diff = new Diff();
		this.sigma = new Terme[2];
		this.A = A;
		this.B = B;
	}

	/*
	 * Cette méthode calcule le PGCU de deux prédicats
	 */
	public void setPGCU() {
		Predicat[] AB = new Predicat[2];
		AB[0] = A;
		AB[1] = B;
		
		do {
			diff.setDiff(AB);
			if(diff.isAcceptable()) {
				this.sigma = diff.getFirstCouple();
				this.teta.setTeta(sigma);
				this.A = teta.getTetaA();
				this.B = teta.getTetaB();
			}
			diff.printDiff();
		}while(diff.isAcceptable());
		
		this.pgcu = teta.getTeta();
	}
	
	/*
	 * Cette méthode retourne le PGCU
	 */
	public String getPGCU() {
		String pgcu = "{";
		int i;
		
		for(Terme[] element : this.pgcu) {
			pgcu = pgcu + "(";
			pgcu = pgcu + element[0].getNomC();
			pgcu = pgcu + ",";
			pgcu = pgcu + element[1].getNomC();
			pgcu = pgcu + "),";
		}
		
		i = pgcu.length();
		pgcu = pgcu.substring(0, i-1);
		pgcu = pgcu + "}";
		return pgcu;
	}
	
	/*
	 * Cette méthode passe le paramètre de String à Prédicat
	 */
	public static Predicat stringToPredicat(String pa) {
		Predicat A;
		
		int i;
		int j;
		String p1;
		String t1;
		
		List<Terme> pl = new ArrayList<Terme>();
		
		p1 = String.valueOf(pa.charAt(0));
		t1 = pa.substring(2);
		for(i = 0; i<pa.length()-1; i++) {
			t1 = String.valueOf(pa.charAt(i));
			if(t1.compareTo(",") != 0) {
				switch(t1) {
				case "x": 
					pl.add((Terme)(new Variable(t1)));
					break;
				case "y":
					pl.add((Terme)(new Variable(t1)));
					break;
				case "z":
					pl.add((Terme)(new Variable(t1)));
					break;
				case "u":
					pl.add((Terme)(new Variable(t1)));
					break;
				case "v":
					pl.add((Terme)(new Variable(t1)));
					break;
				case "w":
					pl.add((Terme)(new Variable(t1)));
					break;
				case "t":
					pl.add((Terme)(new Variable(t1)));
					break;
				case "a":
					pl.add((Terme)(new Constante(t1)));
					break;
				case "b":
					pl.add((Terme)(new Constante(t1)));
					break;
				case "c":
					pl.add((Terme)(new Constante(t1)));
					break;
				case "d":
					pl.add((Terme)(new Constante(t1)));
					break;
				case "e":
					pl.add((Terme)(new Constante(t1)));
					break;
				case "f":
					j = indexPar(pa.substring(i+1)) + i;
					pl.add((Terme)(stringToFonction(pa.substring(i, j))));
					i = j;
					break;
				case "h":
					j = indexPar(pa.substring(i+1)) + i;
					pl.add((Terme)(stringToFonction(pa.substring(i, j))));
					i = j;
					break;
				}
			}
		}
		
		A = new Predicat(p1,pl);
		return A;
	}
	
	/*
	 * Cette méthode renvoie l'index de la parenthèse fermante
	 */
	private static int indexPar(String ch) {
		int i = 0;
		Boolean ok = false;
		
		while(!ok) {
			if(ch.charAt(i) == ')') {
				ok = true;
			}
			i++;
		}
		
		return i;
	}
	
	/*
	 * Cette méthode passe le paramètre de String à fonction
	 */
	private static Fonction stringToFonction(String fa) {
		Fonction f;
		int i;
		String f1;
		String t1;
		
		List<Terme> fl = new ArrayList<Terme>();
		
		f1 = String.valueOf(fa.charAt(0));
		t1 = fa.substring(2);
		
		for(i = 0; i<fa.length(); i++) {
			t1 = String.valueOf(fa.charAt(i));
			
			if(t1.compareTo(",") != 0) {
				
				switch(t1) {
					case "x": 
						fl.add((Terme)(new Variable(t1)));
						break;
					case "y":
						fl.add((Terme)(new Variable(t1)));
						break;
					case "z":
						fl.add((Terme)(new Variable(t1)));
						break;
					case "u":
						fl.add((Terme)(new Variable(t1)));
						break;
					case "v":
						fl.add((Terme)(new Variable(t1)));
						break;
					case "w":
						fl.add((Terme)(new Variable(t1)));
						break;
					case "t":
						fl.add((Terme)(new Variable(t1)));
						break;
					case "a":
						fl.add((Terme)(new Constante(t1)));
						break;
					case "b":
						fl.add((Terme)(new Constante(t1)));
						break;
					case "c":
						fl.add((Terme)(new Constante(t1)));
						break;
					case "d":
						fl.add((Terme)(new Constante(t1)));
						break;
					case "e":
						fl.add((Terme)(new Constante(t1)));
						break;
				}
			}
		}
		f = new Fonction(f1, fl);
		
		return f;
	}
	
	/*
	 * Cette méthode renvoie les instructions pour l'utilisateur
	 */
	public static String instruction() {
		String newline = System.getProperty("line.separator");
		return "Nous réalisons le calsul du PGCU. "+newline
				+ "Les variables acceptées sont: t, u, v, w, x, y, z. "+newline
				+ "Les constantes acceptées sont: a, b, c, d, e. "+newline
				+ "Les fonctions acceptées sont: f, h.";
	}
}
