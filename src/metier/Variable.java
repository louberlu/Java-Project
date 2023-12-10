/**
 * 
 */
package metier;

import java.util.List;

/**
 * @author NKILI OBELE Karen Fifi
 * 
 * {@summary Cette crée un objet Variable, de classe mère Terme et instantie son comportement}
 *
 */
public class Variable extends Terme {

	/**
	 * @param nom Chaîne de caractère contenant le nom du terme, définie dans les sous-classes
	 */
	
	
	public Variable(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
		this.nom = nom;
		this.nType = "Variable";
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

	@Override
	public String getNomC() {
		// TODO Auto-generated method stub
		return this.nom;
	}

	@Override
	public List<Terme> getLitt() {
		// TODO Auto-generated method stub
		return null;
	}
}
