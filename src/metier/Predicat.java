/**
 * 
 */
package metier;
import java.util.List;

/**
 * @author NKILI OBELE Karen Fifi
 * 
 * {@summary Cette crée un objet Predicat, de classe mère Litteral et instantie son comportement}
 *
 */
public class Predicat extends Litteral {
	
	/**
	 * @param nom Chaîne de caractère contenant le nom du Predicat
	 * @param nomC Chaîne de caractère contenant le nom du prédicat et de ses termes
	 * @param predicatDe Liste de termes contenus dans le prédicat
	 * 
	 */
	
	private List<Terme> predicatDe;
	private String nomC;
	
	public Predicat(String nom, List<Terme> predicatDe) {
		super(nom);
		// TODO Auto-generated constructor stub
		this.predicatDe = predicatDe;
		this.nType = "Predicat";
	}

	@Override
	public boolean isType(String type) {
		// TODO Auto-generated method stub
		if(this.nType == type) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return this.nom;
	}
	
	public String getNomC() {
		nomC = this.nom.concat("(");
		int i;
		
		for(Terme element : this.predicatDe) {
			nomC = nomC +element.getNomC();
			nomC = nomC + ",";
		}
		i = nomC.length();
		nomC = nomC.substring(0, i-1);
		nomC = nomC + ")";
		return nomC;
	}
	
	@Override
	public boolean isSkolem() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setNom(String nom) {
		// TODO Auto-generated method stub
		this.nom = nom;
	}

	@Override
	public boolean isEquals(Litteral litt) {
		// TODO Auto-generated method stub
		return this.nom.equals(litt.nom);
	}
	
	public List<Terme> getPredicatDe(){
		return this.predicatDe;
	}
	
	public void setPredicatDe(List<Terme> predicat) {
		this.predicatDe = predicat;
	}

	@Override
	public List<Terme> getLitt() {
		// TODO Auto-generated method stub
		return this.predicatDe;
	}
}
