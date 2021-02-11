package imd0412.academic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GradeModuleTests {
	
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
	public String testName;
	
	@Parameters(name = "[{index}]test-({0},{1},{2},{3}) ->{5}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{7.0f,7.0f,7.0f,74,ApprovalStatus.REPF, "testShouldReturnREPF"},
			{7.0f,7.0f,7.0f,73,ApprovalStatus.REPF, "testShouldReturnREPF"},
			{7.0f,7.0f,7.0f,75,ApprovalStatus.APR, "testShouldReturnAPR"},
			{3.0f,3.0f,2.9f,80,ApprovalStatus.REP, "testShouldReturnREP"},
			{3.0f,3.0f,2.8f,80,ApprovalStatus.REP, "testShouldReturnREP"},
			{3.0f,3.0f,3.0f,80,ApprovalStatus.REC, "testShouldReturnREC"},
			{3.0f,3.0f,2.9f,80,ApprovalStatus.REP, "testShouldReturnREP"},
			{3.0f,4.0f,5.0f,75,ApprovalStatus.REC, "testShouldReturnREC"},
			{3.0f,4.0f,5.0f,74,ApprovalStatus.REPF, "testShouldReturnREPF"},
			{3.0f,4.0f,5.0f,76,ApprovalStatus.REC, "testShouldReturnREC"},
			{3.0f,3.0f,3.0f,75,ApprovalStatus.REC, "testShouldReturnREC"},
			{3.0f,3.0f,2.9f,80,ApprovalStatus.REP, "testShouldReturnREP"},
			{3.0f,3.0f,3.1f,75,ApprovalStatus.REC, "testShouldReturnREC"},
			{5.0f,5.0f,4.9f,85,ApprovalStatus.REC, "testShouldReturnREC"},
			{5.0f,5.0f,4.8f,85,ApprovalStatus.REC, "testShouldReturnREC"},
			{5.0f,5.0f,5.0f,85,ApprovalStatus.APRN, "testShouldReturnAPRN"},
			{7.0f,7.0f,7.0f,85,ApprovalStatus.APR, "testShouldReturnAPR"},
			{7.0f,7.0f,6.9f,85,ApprovalStatus.APRN, "testShouldReturnAPRN"},
			{7.0f,7.0f,7.1f,85,ApprovalStatus.APR, "testShouldReturnAPR"},
			{3.0f,5.0f,7.0f,85,ApprovalStatus.APRN, "testShouldReturnAPRN"},
			{3.0f,3.0f,8.9f,85,ApprovalStatus.REC, "testShouldReturnREC"},
			{3.0f,3.0f,9.1f,85,ApprovalStatus.APRN, "testShouldReturnAPRN"},
			{5.0f,5.0f,5.0f,85,ApprovalStatus.APRN, "testShouldReturnAPRN"},
			{5.0f,5.0f,4.9f,85,ApprovalStatus.REC, "testShouldReturnREC"},
			{5.0f,5.0f,5.1f,85,ApprovalStatus.APRN, "testShouldReturnAPRN"},
			{3.0f,3.0f,2.9f,74,ApprovalStatus.REMF, "testShouldReturnREMF"},
			{3.0f,3.0f,2.8f,74,ApprovalStatus.REMF, "testShouldReturnREMF"},
			{3.0f,3.0f,2.9f,73,ApprovalStatus.REMF, "testShouldReturnREMF"},
			{3.0f,3.0f,2.9f,75,ApprovalStatus.REP, "testShouldReturnREP"},
//			{8.0f,8.0f,8.0f,100,ApprovalStatus.APR, "testShouldReturnAPR"},
//			{3.0f,3.0f,3.0f,100,ApprovalStatus.REC, "testShouldReturnREC"}			
		});
	}

	@Test
	public void gradeModuleTestTemplate() {
		//Action
		final ApprovalStatus status = GradeModule.performPartialConsolidation(grade1, grade2, grade3,
				attendanceFrequency);
				
		//verification
		Assert.assertEquals(expectedStatus, status);


	}

}
