package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {
	
	protected Radnja radnja;
	protected AutoGuma testGuma;

	@BeforeEach
	void setUp() throws Exception {
		
		testGuma= new AutoGuma();
		testGuma.setMarkaModel("Good Year");
		testGuma.setSirina(215);
		testGuma.setPrecnik(19);
		testGuma.setVisina(45);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		testGuma=null;
	}

	@Test
	void testDodajGumu() {
		
		radnja.dodajGumu(testGuma);
		
		assertEquals(1, radnja.vratiSveGume().size());
		assertEquals(testGuma, radnja.vratiSveGume().get(0));
	}
	
	@Test
	void testDodajGumuViseGuma() {
		
		AutoGuma testGuma2 = new AutoGuma();
		testGuma2.setMarkaModel("Tigar");
		testGuma2.setSirina(214);
		testGuma2.setPrecnik(18);
		testGuma2.setVisina(44);
		
		radnja.dodajGumu(testGuma);
		radnja.dodajGumu(testGuma2);
		
		assertEquals(2, radnja.vratiSveGume().size());
		assertEquals(testGuma2, radnja.vratiSveGume().get(0));
		assertEquals(testGuma, radnja.vratiSveGume().get(1));
	}
	
	@Test
	void testDodajGumuDuplikat() {
		
		AutoGuma testGuma2 = new AutoGuma();
		testGuma2.setMarkaModel("Good Year");
		testGuma2.setSirina(215);
		testGuma2.setPrecnik(19);
		testGuma2.setVisina(45);
		
		radnja.dodajGumu(testGuma);
		
		assertThrows(java.lang.RuntimeException.class,() -> radnja.dodajGumu(testGuma2));
	}
	
	@Test
	void testDodajGumuNull() {
		
		assertThrows(java.lang.NullPointerException.class,() -> radnja.dodajGumu(null));
	}

	@Test
	void testPronadjiGumu() {
		
		AutoGuma testGuma2 = new AutoGuma();
		testGuma2.setMarkaModel("Tigar");
		testGuma2.setSirina(214);
		testGuma2.setPrecnik(18);
		testGuma2.setVisina(44);
		
		radnja.dodajGumu(testGuma);
		radnja.dodajGumu(testGuma2);
		
		List<AutoGuma> listaGuma = radnja.pronadjiGumu("Tigar");
		
		assertEquals(1, listaGuma.size());
		assertTrue(listaGuma.contains(testGuma2));
	}
	
	@Test
	void testPronadjiGumuRazliciteDimenzije() {
		
		AutoGuma testGuma2 = new AutoGuma();
		testGuma2.setMarkaModel("Good Year");
		testGuma2.setSirina(213);
		testGuma2.setPrecnik(18);
		testGuma2.setVisina(43);
		
		radnja.dodajGumu(testGuma);
		radnja.dodajGumu(testGuma2);
		
		List<AutoGuma> listaGuma = radnja.pronadjiGumu("Good Year");
		
		assertEquals(2, listaGuma.size());
		assertTrue(listaGuma.contains(testGuma));
		assertTrue(listaGuma.contains(testGuma2));
	}
	
	@Test
	void testPronadjiGumuNull() {
		
		AutoGuma testGuma2 = new AutoGuma();
		testGuma2.setMarkaModel("Tigar");
		testGuma2.setSirina(214);
		testGuma2.setPrecnik(18);
		testGuma2.setVisina(44);
		
		radnja.dodajGumu(testGuma);
		radnja.dodajGumu(testGuma2);
		
		List<AutoGuma> listaGuma = radnja.pronadjiGumu(null);
		
		assertEquals(null, listaGuma);
	}
	
	@Test
	void testPronadjiGumuKojaNePostoji() {
		
		AutoGuma testGuma2 = new AutoGuma();
		testGuma2.setMarkaModel("Tigar");
		testGuma2.setSirina(214);
		testGuma2.setPrecnik(18);
		testGuma2.setVisina(44);
		
		radnja.dodajGumu(testGuma);
		radnja.dodajGumu(testGuma2);
		
		List<AutoGuma> listaGuma = radnja.pronadjiGumu("Michelin");
		
		assertEquals(0, listaGuma.size());
	}

	@Test
	void testVratiSveGume() {
		
		AutoGuma testGuma2 = new AutoGuma();
		testGuma2.setMarkaModel("Tigar");
		testGuma2.setSirina(214);
		testGuma2.setPrecnik(18);
		testGuma2.setVisina(44);
		
		radnja.dodajGumu(testGuma);
		radnja.dodajGumu(testGuma2);
		
		assertEquals(2, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(testGuma));
		assertTrue(radnja.vratiSveGume().contains(testGuma2));
		
	}

}
