import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Admin extends User {


	public  Admin(String name, String userID, String password)
{
	super(name, userID, password, "Admin");
}

public void setName(String name) {
	this.name = name;
}

public String getName() {
	return name;
}

public void setUserID(String userID) {
	this.userID = userID;
}

public String getUserID() {
	return userID;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPassword()
{
	return password;
}

public String getActor() {
	return "Admin";
}

void printAdminMenu(CMS cms, Admin a)
{

	System.out.print("\n***Admin Menu" + " || Week " 
					+ cms.getWeek() + "***\n");
	System.out.printf("%-25s %s\n", "Assign Lecturer", "A");
	System.out.printf("%-25s %s\n", "Add Course Offerings", "B");
	System.out.printf("%-25s %s\n", "View Student Academic History", "C");
	System.out.printf("%-25s %s\n", "Advance System", "D");
	System.out.printf("%-25s %s\n", "Exit Program", "E");
	System.out.printf("%-26s", "Enter your choice:" );
	Scanner kb = null;
	String input = kb.nextLine();
	System.out.println();
	
	if(input.trim().toUpperCase().equals("A"))
	{
		assignLecturer(cms, a);
	}
	else if(input.trim().toUpperCase().equals("B"))
	{
		addCourseOfferings();
	}
	else if(input.trim().toUpperCase().equals("C"))
	{
		viewStudentAcademicHistory();
	}
	else if(input.trim().toUpperCase().equals("D"))
	{
		advanceSystem(cms, a);
	}
	else if(input.trim().toUpperCase().equals("E"))
	{
		kb.close();
		System.out.println("\n\nExit successfullt!");
	}
	else
	{
		System.out.println("Option " + input.trim().toUpperCase()
				+ " does not exists!");
	}
}


private void viewStudentAcademicHistory() {
	// TODO Auto-generated method stub
System.out.println("Enter student ID:")	;
Scanner sc = null;
String sid =sc.nextLine();
Student s = CMS.searchS(sid);
if (s==null){
	System.out.println("User not found");

	viewStudentAcademicHistory();
}
 else {
	viewAcdHis(s);
}

}


private void viewAcdHis(Student s) {
	System.out.println(s.getName().toUpperCase()+"------"+s.getUserID().toUpperCase());
	
	for(Result r: s.getAcademicHist())
	 {
		System.out.println(r.getCourse().getName() + " ---- " + r.getMarks() + " ----- " + r.getGrade());
	 }
	
}

private void advanceSystem(CMS cms, Admin a) {
	// TODO Auto-generated method stub
	System.out.println("Advance week");
	System.out.println("1.Yes");
	System.out.println("2.No");
	Scanner sc = null;
	int q =sc.nextInt();
	
	switch(q){
	case 1:
		
		cms.advanceSystem();
		break;
	case 2:
		printAdminMenu(null, null);
	}
}

private void assignLecturer(CMS cms, Admin a) 
{
	int i = 0;
	Course course = null;
	Lecturer l = null;
	System.out.print("\n***Admin Menu || assign lecturer***\n");
                                                     
	System.out.printf("%-25s %s\n Select the course: ");
	for(Course c: CMS.courses)
	{
		i++;
		System.out.println(i +") "+c.getName() +"\n\n");
	}
	
	
	int j = cms.kb.nextInt();
	
	if( j > i)
	{
		System.out.println("\n INVALID SELECTION. TRY AGAIN \n");
		assignLecturer(cms, a);
	}
	course = CMS.courses.get(j-1);
	System.out.printf("%-25s %s\n ,Enter Lecturer ID: \n");
	
	String id = cms.kb.next();
	l = CMS.searchL(id);
	if(l == null)
	{
		System.out.println("\n INVALID ID. TRY AGAIN \n");
		assignLecturer(cms, a);
	}
	l.setCourse(course);
	System.out.println("ASSIGNMENT SUCCESSFULL. \n\n");
	printAdminMenu(cms, a);
}


private void addCourseOfferings() {
	// TODO Auto-generated method stub
	System.out.println("Select a course:");
	for(Course a: CMS.courses){
		int i=0;
		if(a.isList()==false){
		i++;
	
		System.out.println(i+":"+a.getName());
	}
	Scanner sc = null;
	int s=sc.nextInt();

	System.out.println("Enter the max number:");
		int q=sc.nextInt();
       //Main. courses.getMax().put(s , q);   
        
}}


}