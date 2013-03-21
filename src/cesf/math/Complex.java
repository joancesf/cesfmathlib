package cesf.math;
/** 
 * Nombres complexos.
 * <p>Classe per disposar de nombres complexos.<br>
 * Els nombres complexos tenen la forma a+bi (ex. 3+4i),
 * on i &eacute;s l'arrel quadrada de -1 i base dels nombres
 * imaginaris.</p>
 * Les parts d'un nombre complex s'anomenen:
 * <ul><li>a = part real</li>
 * <li>b = part imagin&agrave;ria</li></ul>
 * <p>Es poden calcular moltes coses amb nombres complexos
 * i accepten diverses operacions. Aquesta classe 
 * implementa les m&eacute;s destacables i necess&agraveries.</p>
 * @author Joan
 * @see <a href="http://es.wikipedia.org/wiki/N%C3%BAmero_complejo">Wikipedia</a>
 */
public class Complex {
	/**
	 * part real.
	 */
	private final double re;
	/**
	 * part imagin&agraveria.
	 */
	private final double im;
	
	/**
	 * Constructor per defecte.
	 */
	public Complex() { 
		re = 0; 
		im = 0; 
	}
	/**
	 * Constructor amb par&agravemetres.
	 * @param re Part real.
	 * @param im Part imagin&agraveria.
	 */
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
    /**
     * Retorna una representaci&oacute; en cadena de text.
	 * @param re Part real.
	 * @param im Part imagin&agraveria.
     */
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    /**
     * Retorna el m&ogravedul del complex.
     * @return Retorna un double.
     */
    public double abs()   { return Math.hypot(re, im); }
    /**
     * Retorna la fase (angle) del complex.
     * @return Retorna un double.
     */
    public double phase() { return Math.atan2(im, re); }

    /**
     * Suma un segon complex i retorna el resultat.
     * @param b Se li pasa un numero complex.
     * @return Retorna un double.
     */
    public Complex add(Complex b) {
        double real = this.re + b.re;
        double imag = this.im + b.im;
        return new Complex(real, imag);
    }

    /**
     * Resta un segon complex i retorna el resultat.
     * @param b Se li pasa un numero complex.
     * @return Retorna un complex.
     */
    public Complex substract(Complex b) {
        double real = this.re - b.re;
        double imag = this.im - b.im;
        return new Complex(real, imag);
    }

    /**
     * Multiplica per un segon complex i retorna el resultat.
     * @param b Se li pasa un numero complex.
     * @return Retorna un complex.
     */
    public Complex multiply(Complex b) {
        double real = this.re * b.re - this.im * b.im;
        double imag = this.re * b.im + this.im * b.re;
        return new Complex(real, imag);
    }

    /**
     * Multiplica per un real i retorna el resultat.
     * @param x Se li pasa un numero double.
     * @return Retorna un complex.
     */
    public Complex multiply(double x) {
    	double real = x * this.re;
    	double imag = x * this.im;
        return new Complex(real, imag);
    }

    /**
     * Retorna la divisi&oacute; per un segon complex.
     * @param b Se li pasa un numero complex.
     * @return Retorna un complex.
     */
    public Complex divide(Complex b) {
        return this.multiply(b.reciprocal());
    }

    /**
     * Retorna el complex conjugat de l'actual.
     * @return Retorna un complex.
     */
    public Complex conjugate() {
    	return new Complex(this.re, -this.im); 
    }

    /**
     * Retorna el rec&iacute;proc d'aquest complex.
     * @return Retorna un complex.
     */
    public Complex reciprocal() {
        double x = this.re * this.re + this.im * this.im;
        return new Complex(this.re / x, -this.im / x);
    }

    /**
     * Getter, recuperar re.
     * @return Retorna un double.
     */
    public double getReal() { return this.re; }
    
    /**
     * Getter, recuperar imag.
     * @return Retorna un double.
     */
    public double getImag() { return this.im; }

    /**
     * Retorna l'exponenciaci&oacute; del complex.
     * @return Retorna un complex.
     */
    public Complex exp() {
    	double real = Math.exp(this.re) * Math.cos(this.im);
    	double imag = Math.exp(this.re) * Math.sin(this.im);
        return new Complex(real, imag);
    }

    /**
     * Retorna el sinus del complex.
     * @return Retorna un complex.
     */
    public Complex sin() {
    	double real = Math.sin(re) * Math.cosh(im);
    	double imag = Math.cos(re) * Math.sinh(im);
        return new Complex(real, imag);
    }

    /**
     * Retorna el cosinus del complex.
     * @return Retorna un complex.
     */
    public Complex cos() {
    	double real = Math.cos(re) * Math.cosh(im);
    	double imag = -Math.sin(re) * Math.sinh(im);
        return new Complex(real, imag);
    }

    /**
     * Retorna la tangent del complex.
     * @return Retorna un complex.
     */
    public Complex tan() {
        return sin().divide(cos());
    }
    
    /**
     * Versi&oacute; est&agravetica de la funci&oacute; suma.
     * @param a Se li pasa un complex "a".
     * @param b Se li pasa un complex "b".
     * @return Retorna un complex.
     */
    public static Complex add(Complex a, Complex b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }


}
