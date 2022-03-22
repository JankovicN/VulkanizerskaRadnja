package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma testGuma;
	
	@BeforeEach
	void setUp() throws Exception {
		testGuma=new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		testGuma=null;
	}

	@Test
	void testAutoGuma() {
		testGuma=new AutoGuma();
		
		assertNotNull(testGuma);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		testGuma=new AutoGuma("Good Year", 19, 215, 45);
		
		assertEquals("Good Year", testGuma.getMarkaModel());
		assertEquals(19, testGuma.getPrecnik());
		assertEquals(215, testGuma.getSirina());
		assertEquals(45, testGuma.getVisina());
		assertNotNull(testGuma);
	}

	@Test
	void testSetMarkaModel() {
		testGuma.setMarkaModel("Good Year");
		
		assertEquals("Good Year", testGuma.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class,() ->testGuma.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelManjeOdTri() {
		assertThrows(java.lang.IllegalArgumentException.class,() ->testGuma.setMarkaModel("GY"));
	}

	@ParameterizedTest
	@CsvSource({
		"13", 
		"19",
		"21"
	})
	void testSetPrecnik(int precnik) {
		testGuma.setPrecnik(precnik);
		
		assertEquals(precnik, testGuma.getPrecnik());
	}
	
	@Test
	void testSetPrecnikManjeOd13() {
		assertThrows(java.lang.IllegalArgumentException.class,() ->testGuma.setPrecnik(10));
	}
	
	@Test
	void testSetPrecnikViseOd22() {
		assertThrows(java.lang.IllegalArgumentException.class,() ->testGuma.setPrecnik(25));
	}

	@ParameterizedTest
	@CsvSource({
		"135",
		"200",
		"344"
	})
	void testSetSirina(int sirina) {
		testGuma.setSirina(sirina);
		
		assertEquals(sirina, testGuma.getSirina());
	}
	
	@Test
	void testSetSirinaManjaOd135() {
		assertThrows(java.lang.IllegalArgumentException.class,() ->testGuma.setSirina(100));
	}
	
	@Test
	void testSetSirinaVecaOd355() {
		assertThrows(java.lang.IllegalArgumentException.class,() ->testGuma.setSirina(400));
	}

	@ParameterizedTest
	@CsvSource({
		"25",
		"50",
		"94"
	})
	void testSetVisina(int visina) {
		testGuma.setVisina(visina);
		
		assertEquals(visina, testGuma.getVisina());
	}
	
	@Test
	void testSetVisinaManjaOd25() {
		assertThrows(java.lang.IllegalArgumentException.class,() ->testGuma.setVisina(2));
	}
	
	@Test
	void testSetVisinaVecaOd95() {
		assertThrows(java.lang.IllegalArgumentException.class,() ->testGuma.setVisina(200));
	}

	@Test
	void testToString() {
		testGuma.setMarkaModel("Good Year");
		testGuma.setSirina(215);
		testGuma.setPrecnik(19);
		testGuma.setVisina(45);
		String str=testGuma.toString();
		
		assertTrue(str.contains("Good Year"));
		assertTrue(str.contains("45"));
		assertTrue(str.contains("19"));
		assertTrue(str.contains("45"));
	}

	@ParameterizedTest
	@CsvSource({
		"Good Year, 215, 19, 45, Good Year, 215, 19, 45, true",
		"Good Year, 215, 19, 45, Tigar, 215, 19, 45, false",
		"Good Year, 215, 19, 45, Good Year, 200, 19, 45, false",
		"Good Year, 215, 19, 45, Good Year, 215, 20, 45, false",
		"Good Year, 215, 19, 45, Good Year, 215, 19, 40, false",
		"Good Year, 215, 19, 45, Tigar, 200, 20, 40, false"
	})
	void testEqualsObject(String markaModel1, int sirina1, int precnik1, int visina1,
			String markaModel2, int sirina2, int precnik2, int visina2,boolean equals) {
		
		testGuma.setMarkaModel(markaModel1);
		testGuma.setSirina(sirina1);
		testGuma.setPrecnik(precnik1);
		testGuma.setVisina(visina1);
		
		AutoGuma guma2=new AutoGuma();
		guma2.setMarkaModel(markaModel2);
		guma2.setSirina(sirina2);
		guma2.setPrecnik(precnik2);
		guma2.setVisina(visina2);
		
		assertEquals(equals, testGuma.equals(guma2));
		
	}

}
