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
 * {@summary Cette classe crée un objet Teta et instantie son comportement (méthode pour le calculer)}
 *
 */
public class Teta {

	/**
	 * @param A Le prédicat A
	 * @param B Le prédicat B
	 * @param teta Liste de tableau de 2 termes
	 */
	Predicat A;
	Predicat B;
	List<Terme[]> teta;
	
	public Teta(Predicat A, Predicat B) {
		// TODO Auto-generated constructor stub
		this.A = A;
		this.B = B;
		teta = new ArrayList<Terme[]>();
	}
	
	/*
	 * Cette méthode calcul le teta des deux prédicats.
	 */
	void setTeta(Terme[] sigma) {
		Terme var;
		Terme sko;
		List<Terme[]> tetaP = new ArrayList<Terme[]>();
		List<Terme> tampon = new ArrayList<Terme>();
		List<Terme> tampon2 = new ArrayList<Terme>();
		
		if(sigma[0].isSkolem() && !sigma[1].isSkolem()) {
			var = sigma[1];
			sko = sigma[0];
		}else if(!sigma[0].isSkolem() && sigma[1].isSkolem()) {
			var = sigma[0];
			sko = sigma[1];
		}else {
			var = sigma[0];
			sko = sigma[1];
		}
		
		for(Terme[] element : this.teta) {
			if(element[0].isEquals(var)) {
				element[1] = sko;
			}//else if(element[1].isEquals(var)) {
				//element[0] = sko;
			//}
			tetaP.add(element);
		}
		
		this.teta = tetaP;
		this.teta.add(sigma);
		
		for(Terme element : this.A.getLitt()) {
			if(element.isEquals(var)) {
				tampon.add(sko);
			}else if(element.isType("Fonction")){
				for(Terme litt : element.getLitt()) {
					if(litt.isEquals(var)) {
						tampon2.add(sko);
					}else {
						tampon2.add(litt);
					}
				}
				tampon.add(new Fonction(element.getNom(), tampon2));
				tampon2 = new ArrayList<Terme>();
			}else{
				tampon.add(element);
			}
		}
		
		A.setPredicatDe(tampon);
		//System.out.println("teta de A: "+A.getNomC());
		tampon = new ArrayList<Terme>();
		
		for(Terme element : this.B.getLitt()) {
			if(element.isEquals(var)) {
				tampon.add(sko);
			}else if(element.isType("Fonction")){
				for(Terme litt : element.getLitt()) {
					if(litt.isEquals(var)) {
						tampon2.add(sko);
					}else{
						tampon2.add(litt);
					}
				}
				tampon.add(new Fonction(element.getNom(), tampon2));
				tampon2 = new ArrayList<Terme>();
			}else {
				tampon.add(element);
			}
		}
		
		B.setPredicatDe(tampon);
		//System.out.println("teta de B: "+B.getNomC());
	}
	
	public Predicat getTetaA() {
		return this.A;
	}
	
	public Predicat getTetaB() {
		return this.B;
	}
	
	public List<Terme[]> getTeta() {
		return this.teta;
	}
	
	public void printTeta() {
		String pgcu = "Teta: {";
		int i;
		
		for(Terme[] element : this.teta) {
			pgcu = pgcu + "(";
			pgcu = pgcu + element[0].getNomC();
			pgcu = pgcu + ",";
			pgcu = pgcu + element[1].getNomC();
			pgcu = pgcu + "),";
		}
		
		i = pgcu.length();
		pgcu = pgcu.substring(0, i-1);
		pgcu = pgcu + "}";
		System.out.println(pgcu);
	}
}
