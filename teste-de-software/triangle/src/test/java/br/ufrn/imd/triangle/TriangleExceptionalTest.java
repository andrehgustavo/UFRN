package br.ufrn.imd.triangle;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
/**
 * 
 * @author André Gustavo
 *
 */
public class TriangleExceptionalTest {
	
	private static Triangle t;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		t = new Triangle();
	}

	
	@Test(expected = NullPointerException.class)
	public void triangleShouldThrowNullPointerException() {
		// Configuration
		final Integer s1 = null;
		final Integer s2 = 10;
		final Integer s3 = 10;

		// action
		t.defineType(s1, s2, s3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void triangleShouldThrowIllegalArgumentException() {
		// Configuration
		final Integer s1 = -10;
		final Integer s2 = 10;
		final Integer s3 = 10;
		
		// action
		t.defineType(s1, s2, s3);
	}

}
