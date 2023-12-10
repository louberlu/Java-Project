/**
 * 
 */
package metier;
import java.util.List;

/**
 * @author NKILI OBELE Karen Fifi
 * 
 * {@summary Cette crée un objet Litteral et instantie son comportement}
 *
 */
public abstract class Litteral {

	/**
	 * @param nom Chaîne de caractère contenant le nom du litteral, définie dans les sous-classes
	 * @param nType Chaîne de caractère contenant le type du litteral, définie dans les sous-classes
	 */

	protected String nom;
	protected String nType;
	
	public Litteral(String nom) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
	}
	
	public abstract boolean isType(String type);
	
	public abstract String getNom();
	
	public abstract void setNom(String nom);
	
	public abstract boolean isSkolem();
	
	public abstract boolean isEquals(Litteral litt);

	public abstract String getNomC();

	public abstract List<Terme> getLitt();
}