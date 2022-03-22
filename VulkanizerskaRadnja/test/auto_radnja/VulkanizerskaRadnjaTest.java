package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

class VulkanizerskaRadnjaTest extends RadnjaTest{
	
	@BeforeEach
	void setUp() throws Exception {
		
		radnja=new VulkanizerskaRadnja();
		testGuma= new AutoGuma();
		testGuma.setMarkaModel("Good Year");
		testGuma.setSirina(215);
		testGuma.setPrecnik(19);
		testGuma.setVisina(45);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		radnja=null;
		testGuma=null;
	}

}
