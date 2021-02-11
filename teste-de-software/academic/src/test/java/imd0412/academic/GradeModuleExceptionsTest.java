package imd0412.academic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;



@RunWith(Parameterized.class)
public class GradeModuleExceptionsTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {			
			{ -5.0f, 8.0f, 9.0f, 100, ApprovalStatus.APR, IllegalArgumentException.class },
			{ 30f, 8.0f, 9.0f, 100, ApprovalStatus.APR, IllegalArgumentException.class },
			{ 8.0f, 8.0f, 9.0f, -10, ApprovalStatus.APR, IllegalArgumentException.class },
			{ 8.0f, 8.0f, 9.0f, 210, ApprovalStatus.APR, IllegalArgumentException.class },
			{ 8.0f, null, 9.0f, 78, ApprovalStatus.APR,  NullPointerException.class }		
		});
	}
	
	@Parameter(0)
	public Float grade1;
	@Parameter(1)
	public Float grade2;
	@Parameter(2)
	public Float grade3;
	@Parameter(3)
	public Integer attendanceFrequency;
	@Parameter(4)
	public ApprovalStatus expectedStatus;
	@Parameter(5)
	public Class<Exception> expectedException;

	@Test
	public void gradeModuleTestTemplateException() {
		// configuration
		thrown.expect(expectedException);
		//Action
		GradeModule.performPartialConsolidation(grade1, grade2, grade3,attendanceFrequency);
				

	}

}
