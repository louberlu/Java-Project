/**
 * 
 */
package application;
import metier.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
//import java.io.*;

/**
 * @author NKILI OBELE Karen Fifi
 *
 */
public class Test {

	//private static Scanner scant;

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Variable t = new Variable("t");
		Variable u = new Variable("u");
		
		Constante a = new Constante("a");
		
		List<Terme> f11 = new ArrayList<Terme>();
		
		f11.add(t);
		Fonction f = new Fonction("f", f11);
		
		List<Terme> P1 = new ArrayList<Terme>();
		List<Terme> P2 = new ArrayList<Terme>();
		
		P1.add(x);
		P1.add(x);
		P1.add(f);
		
		P2.add(y);
		P2.add(a);
		P2.add(u);
		
		Predicat A = new Predicat("P", P1);
		Predicat B = new Predicat("P", P2);
		
		
		
		System.out.println(A.getNomC()+", "+B.getNomC());
		
		PGCU pgcu = new PGCU(A, B);
		
		System.out.println(A.getNomC()+", "+B.getNomC());
		
		pgcu.setPGCU();
		System.out.println(pgcu.getPGCU());
		
		// Test numero 2
		Variable v = new Variable("v");
		Variable z = new Variable("z");
		
		Constante b = new Constante("b");
		
		List<Terme> f1 = new ArrayList<Terme>();
		
		f1.add(x);
		f1.add(y);
		Fonction fu = new Fonction("f", f1);
		
		List<Terme> f2 = new ArrayList<Terme>();
		
		f2.add(x);
		f2.add(u);
		Fonction fd = new Fonction("f", f2);
		
		List<Terme> f3 = new ArrayList<Terme>();
		
		f3.add(a);
		f3.add(y);
		Fonction ft = new Fonction("f", f3);
		
		List<Terme> f4 = new ArrayList<Terme>();
		
		f4.add(b);
		f4.add(u);
		Fonction fq = new Fonction("f", f4);
		
		List<Terme> P3 = new ArrayList<Terme>();
		List<Terme> P4 = new ArrayList<Terme>();
		
		P3.add(fu);
		P3.add(z);
		P3.add(fd);
		
		P4.add(ft);
		P4.add(fq);
		P4.add(v);
		
		Predicat Aa = new Predicat("P", P3);
		Predicat Bb = new Predicat("P", P4);
		
		System.out.println(Aa.getNomC()+", "+Bb.getNomC());
		
		PGCU pcu = new PGCU(Aa, Bb);
		
		System.out.println(Aa.getNomC()+", "+Bb.getNomC());
		
		pcu.setPGCU();
		System.out.println(pcu.getPGCU());
		
		/*scant = new Scanner(System.in);
		
		System.out.println(PGCU.instruction());
		
		System.out.println("Donnez le premier prédicat A: ");
		String pa = scant.next();
		
		System.out.println("Donnez le deuxième prédicat B: ");
		String pb = scant.next();
		
		System.out.println("Vous avez donné les prédicat suivant:");
		System.out.println(pa+" et "+pb);
		
		Predicat C = PGCU.stringToPredicat(pa);
		Predicat D = PGCU.stringToPredicat(pb);
		
		System.out.println(C.getNomC()+" et "+D.getNomC());
		
		PGCU pgu = new PGCU(C, D);
		pgu.setPGCU();
		System.out.println(pgu.getPGCU());*/
		
		
	}

}
