package br.ufrn.imd.triangle;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author André Gustavo
 *
 */
@RunWith(Parameterized.class)
public class TriangleTestExceptionsParameterized {

	private static Triangle t;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 1, 1, null, NullPointerException.class },
				{ 4, 4, -4, IllegalArgumentException.class }, });
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
	public Class<? extends Exception> expectedException;

	@Test
	public void triangleTypeTestTemplate() {
		// configuration
		thrown.expect(expectedException);
		// Action
		t.defineType(s1, s2, s3);

	}

}
