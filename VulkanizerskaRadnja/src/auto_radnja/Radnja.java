package auto_radnja;

import java.util.List;
import auto_radnja.gume.AutoGuma;

/**
 * Interfejs predstavlja radnju( prodavnicu guma).
 * Poseduje operacije dodavanja, pretrage i pregleda svih guma. 
 * @author janko
 * @version 1.0
 */

public interface Radnja {

	/**
	 * Metoda koja dodaje gumu u vulkanizersku radnju.
	 * 
	 * Guma se dodaje samo ukoliko guma nije null i ako ne postoji vec u vulkanizerskoj radnji.
	 * 
	 * @param a guma koju treba dodati u vulkanizersku radnju
	 * @throws java.lang.NullPointerException ako je guma null
	 * @throws java.lang.RuntimeException ako guma vec postoji u radnji
	 * 
	 * @see auto_radnja.gume.AutoGuma
	 * 
	 */
	void dodajGumu(AutoGuma a);
	
	
	/**
	 * Metoda koja vraca listu sa svim gumama iz vulkanizerske radnje koji zadovoljavaju uslov pretrage
	 * 
	 * Parametar pretrage je marka modela gume. Pretraga se vrsi samo ukoliko marka modela nije null.
	 * Ova pretraga se vrsi prema punom nazivu marke modela i osetljiva je na velika i mala slova.
	 * 
	 * @param markaModel je naziv marke modela 
	 * @return
	 * <ul>
	 * <li>null - ako je uneta marka modela null</li>
	 * <li>List - ako je uneta marka modela razlicita od null</li>
	 * </ul>	
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	
	
	/**
	 * Vraca sve gume iz vulkanizerske radnje
	 * 
	 * @return Lista sa svim gumama iz vulkanizerske radnje
	 */
	List<AutoGuma> vratiSveGume();
}
