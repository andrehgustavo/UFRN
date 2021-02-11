package br.ufrn.imd.triangle;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufrn.imd.triangle.Triangle.TriangleType;

/**
 * 
 * @author André Gustavo
 *
 */
public class TriangleTest {

	private static Triangle t;

	@BeforeClass
	public static void setUpBeforeClass() {
		t = new Triangle();
	}

	@Test
	public void triangleShouldBeEquilateral() {
		// Configuration
		final Integer s1 = 10;
		final Integer s2 = 10;
		final Integer s3 = 10;

		// action
		final TriangleType actualType = t.defineType(s1, s2, s3);

		// Verification
		Assert.assertEquals(TriangleType.EQUILATERAL, actualType);
	}

	@Test
	public void triangleShouldBeIsoceles() {
		// Configuration
		final Integer s1 = 10;
		final Integer s2 = 10;
		final Integer s3 = 20;

		// action
		final TriangleType actualType = t.defineType(s1, s2, s3);

		// Verification
		Assert.assertEquals(TriangleType.ISOCELES, actualType);
	}

	@Test
	public void triangleShouldBeScalene() {
		// Configuration
		final Integer s1 = 10;
		final Integer s2 = 20;
		final Integer s3 = 30;

		// action
		final TriangleType actualType = t.defineType(s1, s2, s3);

		// Verification
		Assert.assertEquals(TriangleType.SCALENE, actualType);
	}
	
	@Test
	public void notTriangle() {
		// Configuration
		final Integer s1 = 12;
		final Integer s2 = 4;
		final Integer s3 = 3;

		// action
		final TriangleType actualType = t.defineType(s1, s2, s3);

		// Verification
		Assert.assertEquals(TriangleType.NOT_TRIANGLE, actualType);
	}
	

}
