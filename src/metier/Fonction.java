/**
 * 
 */
package metier;
import java.util.List;

/**
 * @author NKILI OBELE Karen Fifi
 * 
 * {@summary Cette crée un objet Fonction, de classe mère Skolem et instantie son comportement}
 *
 */
public class Fonction extends Skolem {

	/**
	 * @param nom Chaîne de caractère contenant le nom de la fonction
	 * @param nomC Chaîne de caractère contenant le nom du prédicat et de ses termes contenues dans la fonction
	 * @param fonctionDe Liste de termes contenus dans la fonction
	 */
	
	List<Terme> fonctionDe;
	private String nomC;
	
	public Fonction(String nom, List<Terme> fonction) {
		super(nom);
		// TODO Auto-generated constructor stub
		this.fonctionDe = fonction;
		this.nType = "Fonction";
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

	@Override
	public String getNomC() {
		
		int i;
		nomC = this.nom;
		nomC = nomC + "(";
		
		for(Terme element : this.fonctionDe) {
			nomC = nomC + element.getNomC();
			nomC = nomC + ",";
		}
		i = nomC.length();
		nomC = nomC.substring(0, i-1);
		nomC = nomC + ")";
		return nomC;
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

	public List<Terme> getFonctionDe(){
		return this.fonctionDe;
	}

	@Override
	public List<Terme> getLitt() {
		// TODO Auto-generated method stub
		return this.fonctionDe;
	}
}
