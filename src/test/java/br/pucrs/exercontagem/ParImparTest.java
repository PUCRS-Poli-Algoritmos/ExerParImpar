package br.pucrs.exercontagem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class ParImparTest {
	private ParImpar pi = new ParImpar();

	@BeforeAll
	public void setUp() {
		pi = new ParImpar();
	}
	
	@Test
	void parImparAux1Test() {
		int [] aux1 = {1, 2, 3, 4, 5, 6};
		int [] res = {2, 4, 6, 1, 3, 5};
		assertArrayEquals(res, pi.sepParImparAux1(aux1) );
	}
	
	@Test
	void parImparInPlace1Test() {
		int [] aux1 = {1, 2, 3, 4, 5, 6};
		int [] res = {6, 2, 4, 3, 5, 1};
		
		
		
	}
	
	@Test
	void parImparAux2Test() {
		int [] aux2 = {1, 3, 5, 2, 4, 6};
		int [] res = {2, 4, 6, 1, 3, 5};
		
		
		
	}
	
	@Test
	void parImparInPlace2Test() {
		int [] aux2 = {1, 3, 5, 2, 4, 6};
		int [] res = {6, 4, 2, 5, 3, 1};
		
		
		
	}
}
