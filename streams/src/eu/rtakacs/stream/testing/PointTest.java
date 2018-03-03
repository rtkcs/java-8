package eu.rtakacs.stream.testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void testMoveRightBy() {
		Point p1 = new Point(5,5);
		Point p2 = p1.moveRightBy(10);
		
		assertEquals(15, p2.getX());
		assertEquals(5, p2.getY());
	}
}
