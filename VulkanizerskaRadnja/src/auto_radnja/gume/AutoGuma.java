package auto_radnja.gume;

/**
 * Klasa predstavlja automobilsku gumu.
 * Automobilska guma ima atribute markaModel, precnik, sirina i visina.
 * @author nikola
 * @version 1.0
 * 
 */
public class AutoGuma {
	
	/**
	 * Marka modela gume
	 */
	private String markaModel = null;
	/**
	 * Precnik gume
	 */
	private int precnik = -1;
	/**
	 * Sirina gume
	 */
	private int sirina = -1;
	/**
	 * Visina gume
	 */
	private int visina = -1;

	/**
	 * Konstruktor koji inicijalizuje objekat AutoGuma
	 */
	public AutoGuma() {
	}

	/**
	 * Postavlja marku modela, precnik, sirinu i visinu gume
	 * 
	 * @param markaModel je nova marka modela gume
	 * @param precnik je nov precnik gume
	 * @param sirina je nova sirina gume
	 * @param visina je nova visina gume
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Metoda koja vraca marku modela
	 * 
	 * @return marku modela kao String
	 */
	public String getMarkaModel() {
		return markaModel;
	}
	
	/**
	 * Metoda koja postavalja novu vrednost za atribut markaModel
	 * 
	 * @param markaModel je nova marka modela gume
	 * @throws java.lang.NullPointerException ako je uneta marka modela null
	 * @throws java.lang.IllegalArgumentException ako je uneta marka modela prazan String
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}
	
	/**
	 * Metoda koja vraca precnik gume
	 * 
	 * @return precnik kao int
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Metoda koja postavalja novu vrednost za atribut precnik
	 * 
	 * @param precnik je nov precnik gume
	 * @throws java.lang.IllegalArgumentException ako je uneti precnik izvan datog opsega
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Metoda koja vraca sirinu gume
	 * 
	 * @return sirina kao int
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Metoda koja postavalja novu vrednost za atribut sirina
	 * 
	 * @param sirina je nova sirina gume
	 * @throws java.lang.IllegalArgumentException ako je uneta sirina izvan datog opsega
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Metoda koja vraca visinu gume
	 * 
	 * @return visina kao int
	 */
	public int getVisina() {
		return visina;
	}
	
	/**
	 * Metoda koja postavalja novu vrednost za atribut visina
	 * 
	 * @param visina je nova visina gume
	 * @throws java.lang.IllegalArgumentException ako je uneta visina izvan datog opsega, odnosno manja od 25 ili veca od 95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Vraca String koji sadrzi sve podatke o gumi
	 * 
	 * @return String koji sadrzi sve podatke o gumi
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dve automobiislke gume po modelu, precniku, sirini i visini
	 * 
	 * @return
	 * <ul>
	 * <li>true - ako su i model i precnik i sirina i visina isti kod obe gume</li>
	 * <li>false - ako to nije slucaj</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}