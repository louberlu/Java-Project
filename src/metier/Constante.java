/**
 * 
 */
package metier;

import java.util.List;

/**
 * @author NKILI OBELE Karen Fifi
 *
 * {@summary Cette classe crée un objet constante et instantie son comportement}
 */
public class Constante extends Skolem {

	/**
	 * @param nom Chaîne de caractère contenant le nom de la constante
	 * @param nType Chaîne de caractère contenant le type, ici, constante
	 */
	public Constante(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
		this.nType = "Constante";
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
