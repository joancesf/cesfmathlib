package cesf.math;

/**
 * Fraccions enteres.
 * <p>Classe immutable per a representar fraccions enteres.</p>
 * <p>Cont&eacute; funcions per recuperar numerador, recuperar denominador,
 * reduir, etc.</p>
 * @author cesf
 *
 */
public class Fraction {

	private final int num;
	private final int den;
	
	/**
	 * Constructor per defecte.
	 */
	public Fraction() { 
		num=0; 
		den=1;
	}
	/**
	 * Constructor amb par&agravemetres.
	 * @param num
	 * @param den
	 */
	public Fraction(int num, int den) { 
		if (den == 0) 
			throw new IllegalArgumentException("Denominator can not be zero!"); 
		this.num = num;
		this.den = den; 
	}

	/**
	 * Getter, retorna numerador.
	 * @return
	 */
	public int getNum() { return this.num; }
	/**
	 * Getter, retorna denominador.
	 * @return
	 */
	public int getDen() { return this.den; }
	
	/**
	 * Retorna el valor num&egrave;ric de la fracci&oacute;.
	 * @return
	 */
	public double valueOf() {
		double x = (double)(this.num) / this.den; 
		return x;
	}
	
	/**
	 * Retorna el valor num&egraveric d'una fracci&oacute; (versi&oacute; est&agravetica).
	 * @param a
	 * @return
	 */
	public static double valueOf(Fraction a) {
		double x = (double)(a.num) / a.den; 
		return x;		
	}
	
	/**
	 * Retorna una representaci&oacute; en cadena de text.
	 * @return
	 */
	public String toString() {
		return this.num + "/" + this.den;
	}
	
	/**
	 * Simplifica la fracci&oacute; al m&agravexim.
	 * @return
	 */
	public Fraction reduce() {
		int mcd = mcd(this.num, this.den);
		int n = this.num / mcd;
		int d = this.den / mcd;
		if (d < 0) { n = -n; d = -d; }
		return new Fraction(n, d);
	}
	
	/**
	 * Retorna F1 + F2.
	 * @param b
	 * @return
	 */
	public Fraction add(Fraction b) {
		int n = this.num * b.den + this.den * b.num;
		int d = this.den * b.den;
		return new Fraction(n, d).reduce();
	}
	
	/**
	 * Retorna F1 - F2.
	 * @param b
	 * @return
	 */
	public Fraction substract(Fraction b) {
		int n = this.num * b.den - this.den * b.num;
		int d = this.den * b.den;
		return new Fraction(n, d).reduce();
	}
	
	/**
	 * Retorna F1 * F2.
	 * @param b
	 * @return
	 */
	public Fraction multiply(Fraction b) {
		int n = this.num * b.num;
		int d = this.den * b.den;
		return new Fraction(n, d).reduce();
	}
	
	/**
	 * Retorna F1 * x.
	 * @param x
	 * @return
	 */
	public Fraction multiply(int x) {
		int n = this.num * x;
		int d = this.den;
		return new Fraction(n, d).reduce();
	}
	
	/**
	 * Retorna F1 / F2.
	 * @param b
	 * @return
	 */
	public Fraction divide(Fraction b) {
		return this.multiply(b.reciprocal());
	}

	/**
	 * Retorna 1 / F.
	 * @return
	 */
	public Fraction reciprocal() {
		return new Fraction(this.den, this.num).reduce();
	}
	
	/**
	 * Troba el MCD del numerador i denominador.
	 * @param a
	 * @param b
	 * @return
	 */
	protected int mcd(int a, int b) {
		int d; 
		while (b != 0) {
			d = b;
			b = a % b;
			a = d;
		}
		return a;
	}

	/**
	 * Compara dos fraccions.
	 * @param b
	 * @return
	 */
	public boolean equals(Fraction b) {
		Fraction f1 = this.reduce();
		Fraction f2 = b.reduce();
		if (f1.num != f2.num) return false;
		if (f1.den != f2.den) return false; 
		return true;
	}
}
