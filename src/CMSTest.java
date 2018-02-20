import static org.junit.Assert.*;

import org.junit.Test;

public class CMSTest {

	

	@Test
	public void testAddNewCourse1() {
		CMS cms = new CMS();
		Course courses = new Course ("SEF", "c111", "java project",11, true);
		String name = "SEF";
		
		assertEqual(courses.getName(),"SEF");
		assertEqual(courses.getCourseID(),"c111");
		assertEqual(courses.getDescription(),"java project");
		
		
	}
	@Test
	public void testAddNewCourse2() {
		CMS cms = new CMS();
		Course courses = new Course ("Programming", "c222", "C program",12, false);
		String name = "SEF";
		
		assertEqual(courses.getName(),"Programming");
		assertEqual(courses.getCourseID(),"c222");
		assertEqual(courses.getDescription(),"C program");
		
		
	}

	private void assertEqual(String name, String string) {
		// TODO Auto-generated method stub
	

	}
}
