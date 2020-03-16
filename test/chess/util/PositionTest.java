package chess.util;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class PositionTest {

	
	@Test
	void positionDefaultTest() {
		Position pos = new Position();
		assertEquals(pos.getX(), 0);
		assertEquals(pos.getY(), 0);
	}
	
	@Test
	void positionNormalTest() {
		Position pos = new Position(3,6);
		assertEquals(pos.getX(), 3);
		assertEquals(pos.getY(), 6);
	}
	
	@Test
	void positionExceptionTest() {
		try {
			Position pos = new Position(-2,9);
		    fail("Bad position");
		  } catch (IllegalArgumentException exception) {}
	}

	@Test
	void positionAlgebraicErrorLengthTest() {
		try {
			Position pos = new Position("E");
		    fail("La chaine de caractères ne possèdent pas deux caractères");
		  } catch (IllegalArgumentException exception) {}
	}

	@Test
	void positionAlgebraicErrorFirstCharTest() {
		try {
			Position pos = new Position("Z4");
		    fail("Le premier caractère (Z) n'est pas comprit entre A et H");
		  } catch (IllegalArgumentException exception) {}
	}

	@Test
	void positionAlgebraicErrorSecondCharInfTest() {
		try {
			Position pos = new Position("B9");
		    fail("Le deuxième caractère (9) est supérieur à 8");
		  } catch (IllegalArgumentException exception) {}
	}

	@Test
	void positionAlgebraicErrorSecondCharSupTest() {
		try {
			Position pos = new Position("B0");
		    fail("Le deuxième caractère (0) est inférieur à 1");
		  } catch (IllegalArgumentException exception) {}
	}
	
	
	@Test
	void equalsTrueTest() {
		Position pos1 = new Position(4,3);
		Position pos2 = new Position(4,3);
		assertTrue(pos1.equals(pos2));
	}
	
	@Test
	void equalsNullTest() {
		Position pos1 = new Position(0,0);
		assertFalse(pos1.equals(null));
	}
	
	@Test
	void equalsDifferentClassTest() {
		Position pos1 = new Position(0,0);
		assertFalse(pos1.equals(3));
	}
	
	@Test
	void equalsDifferentPosXTest() {
		Position pos1 = new Position(3,3);
		Position pos2 = new Position(0,3);
		assertFalse(pos1.equals(pos2));
	}
	
	@Test
	void equalsDifferentPosYTest() {
		Position pos1 = new Position(3,3);
		Position pos2 = new Position(3,0);
		assertFalse(pos1.equals(pos2));
	}
	
	@Test
	void getManhattanDistanceTest() {
		Position posStart = new Position(0,0);
		Position posEnd = new Position(4,3);
		int dist = posStart.getManhattanDistance(posEnd);
		assertEquals(dist, 7);
	}
	
	@Test
	void getXTest() {
		Position pos = new Position(3,5);
		assertEquals(pos.getX(), 3);
	}
	
	@Test
	void getYTest() {
		Position pos = new Position(3,5);
		assertEquals(pos.getY(), 5);
	}
	
	
}
