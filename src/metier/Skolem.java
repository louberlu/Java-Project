/**
 * 
 */
package metier;

/**
 * @author NKILI OBELE Karen Fifi
 * 
 * {@summary Cette crée un objet Skolem, de classe mère Terme et instantie son comportement}
 *
 */
public abstract class Skolem extends Terme {

	/**
	 * @param nom Chaîne de caractère contenant le nom du skolem, défine dans les sous-classes
	 */
	public Skolem(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSkolem() {
		// TODO Auto-generated method stub
		return true;
	}


}
