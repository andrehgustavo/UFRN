package br.ufrn.imd.triangle;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ufrn.imd.triangle.Triangle.TriangleType;

/**
 * 
 * @author André Gustavo
 *
 */

@RunWith(Parameterized.class)
public class TriangleTestParameterized {

	private static Triangle t;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{ 1, 1, 1, TriangleType.EQUILATERAL }, 
			{ 4, 2, 4, TriangleType.ISOCELES },
			{ 3, 2, 4, TriangleType.SCALENE },
			{ 3, 9, 4, TriangleType.NOT_TRIANGLE }, 
			{ 10, 10, 10, TriangleType.EQUILATERAL },
			{ 25, 25, 15, TriangleType.ISOCELES },
		});
	}

	@BeforeClass
	public static void setUpBeforeClass() {
		t = new Triangle();
	}

	@Parameter(0)
	public Integer s1;
	@Parameter(1)
	public Integer s2;
	@Parameter(2)
	public Integer s3;
	@Parameter(3)
	public TriangleType expectedType;
	
	@Test
	public void triangleTypeTestTemplate() {
		//Action
		final TriangleType actualType = t.defineType(s1, s2, s3);
		
		//verification
		Assert.assertEquals(expectedType, actualType);
	}

}
