package chess.util;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import chess.pieces.King;

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
	void equalsDifferentTest() {
		Position pos1 = new Position(3,4);
		Position pos2 = new Position(4,3);
		assertFalse(pos1.equals(pos2));
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
	void getManhattanDistanceOneCaseColumnTest() {
		Position posStart = new Position("A1");
		Position posEnd = new Position("A2");
		int dist = posStart.getManhattanDistance(posEnd);
		assertEquals(dist, 1);
	}
	
	@Test
	void getManhattanDistanceOneCaseDiagonalTest() {
		Position posStart = new Position("A1");
		Position posEnd = new Position("B2");
		int dist = posStart.getManhattanDistance(posEnd);
		assertEquals(dist, 2);
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
	
	@Test
	void positionVerif() {
		Position posAlg = new Position("A8");
		Position posCord = new Position(0,7);
		assertTrue(posCord.equals(posAlg));
	}
	
	@Test
	void isOnSameColumnAsTest() {
		Position posStart = new Position("A1");
		Position posEnd = new Position("A8");
		assertTrue(posStart.isOnSameColumnAs(posEnd));
	}
	
	@Test
	void isNotOnSameColumnAsTest() {
		Position posStart = new Position("A1");
		Position posEnd = new Position("H8");
		assertFalse(posStart.isOnSameColumnAs(posEnd));
	}

	
	@Test
	void isOnSameLineAsTest() {
		Position posStart = new Position("A1");
		Position posEnd = new Position("H8");
		assertFalse(posStart.isOnSameLineAs(posEnd));
	}
	
	@Test
	void isNotOnSameLineAsTest() {
		Position posStart = new Position("A1");
		Position posEnd = new Position("H1");
		assertTrue(posStart.isOnSameLineAs(posEnd));
	}
	
	
	@Test
	void isOnSameDiagonalAsTest() {
		Position posStart = new Position("A1");
		Position posEnd = new Position("H8");
		assertTrue(posStart.isOnSameDiagonalAs(posEnd));
	}
	
	@Test
	void isNotOnSameDiagonalAsTest() {
		Position posStart = new Position("A1");
		Position posEnd = new Position("H5");
		assertFalse(posStart.isOnSameDiagonalAs(posEnd));
	}
	
	@Test
	public void toAlgebraicNotationTest() {
		assertEquals(new Position(0,0).toAlgebraicNotation(),"A1");
		assertEquals(new Position(1,0).toAlgebraicNotation(),"B1");
		assertEquals(new Position(2,0).toAlgebraicNotation(),"C1");
		assertEquals(new Position(3,0).toAlgebraicNotation(),"D1");
		assertEquals(new Position(4,0).toAlgebraicNotation(),"E1");
		assertEquals(new Position(5,0).toAlgebraicNotation(),"F1");
		assertEquals(new Position(6,0).toAlgebraicNotation(),"G1");
		assertEquals(new Position(7,0).toAlgebraicNotation(),"H1");
		
		assertEquals(new Position(0,1).toAlgebraicNotation(),"A2");
		assertEquals(new Position(1,1).toAlgebraicNotation(),"B2");
		assertEquals(new Position(2,1).toAlgebraicNotation(),"C2");
		assertEquals(new Position(3,1).toAlgebraicNotation(),"D2");
		assertEquals(new Position(4,1).toAlgebraicNotation(),"E2");
		assertEquals(new Position(5,1).toAlgebraicNotation(),"F2");
		assertEquals(new Position(6,1).toAlgebraicNotation(),"G2");
		assertEquals(new Position(7,1).toAlgebraicNotation(),"H2");
		
		assertEquals(new Position(0,2).toAlgebraicNotation(),"A3");
		assertEquals(new Position(1,2).toAlgebraicNotation(),"B3");
		assertEquals(new Position(2,2).toAlgebraicNotation(),"C3");
		assertEquals(new Position(3,2).toAlgebraicNotation(),"D3");
		assertEquals(new Position(4,2).toAlgebraicNotation(),"E3");
		assertEquals(new Position(5,2).toAlgebraicNotation(),"F3");
		assertEquals(new Position(6,2).toAlgebraicNotation(),"G3");
		assertEquals(new Position(7,2).toAlgebraicNotation(),"H3");
		
		assertEquals(new Position(0,3).toAlgebraicNotation(),"A4");
		assertEquals(new Position(1,3).toAlgebraicNotation(),"B4");
		assertEquals(new Position(2,3).toAlgebraicNotation(),"C4");
		assertEquals(new Position(3,3).toAlgebraicNotation(),"D4");
		assertEquals(new Position(4,3).toAlgebraicNotation(),"E4");
		assertEquals(new Position(5,3).toAlgebraicNotation(),"F4");
		assertEquals(new Position(6,3).toAlgebraicNotation(),"G4");
		assertEquals(new Position(7,3).toAlgebraicNotation(),"H4");
		
		assertEquals(new Position(0,4).toAlgebraicNotation(),"A5");
		assertEquals(new Position(1,4).toAlgebraicNotation(),"B5");
		assertEquals(new Position(2,4).toAlgebraicNotation(),"C5");
		assertEquals(new Position(3,4).toAlgebraicNotation(),"D5");
		assertEquals(new Position(4,4).toAlgebraicNotation(),"E5");
		assertEquals(new Position(5,4).toAlgebraicNotation(),"F5");
		assertEquals(new Position(6,4).toAlgebraicNotation(),"G5");
		assertEquals(new Position(7,4).toAlgebraicNotation(),"H5");
		
		assertEquals(new Position(0,5).toAlgebraicNotation(),"A6");
		assertEquals(new Position(1,5).toAlgebraicNotation(),"B6");
		assertEquals(new Position(2,5).toAlgebraicNotation(),"C6");
		assertEquals(new Position(3,5).toAlgebraicNotation(),"D6");
		assertEquals(new Position(4,5).toAlgebraicNotation(),"E6");
		assertEquals(new Position(5,5).toAlgebraicNotation(),"F6");
		assertEquals(new Position(6,5).toAlgebraicNotation(),"G6");
		assertEquals(new Position(7,5).toAlgebraicNotation(),"H6");	
		
		assertEquals(new Position(0,6).toAlgebraicNotation(),"A7");
		assertEquals(new Position(1,6).toAlgebraicNotation(),"B7");
		assertEquals(new Position(2,6).toAlgebraicNotation(),"C7");
		assertEquals(new Position(3,6).toAlgebraicNotation(),"D7");
		assertEquals(new Position(4,6).toAlgebraicNotation(),"E7");
		assertEquals(new Position(5,6).toAlgebraicNotation(),"F7");
		assertEquals(new Position(6,6).toAlgebraicNotation(),"G7");
		assertEquals(new Position(7,6).toAlgebraicNotation(),"H7");

		assertEquals(new Position(0,7).toAlgebraicNotation(),"A8");
		assertEquals(new Position(1,7).toAlgebraicNotation(),"B8");
		assertEquals(new Position(2,7).toAlgebraicNotation(),"C8");
		assertEquals(new Position(3,7).toAlgebraicNotation(),"D8");
		assertEquals(new Position(4,7).toAlgebraicNotation(),"E8");
		assertEquals(new Position(5,7).toAlgebraicNotation(),"F8");
		assertEquals(new Position(6,7).toAlgebraicNotation(),"G8");
		assertEquals(new Position(7,7).toAlgebraicNotation(),"H8");
	}
	
}
