
import java.util.ArrayList;

import java.util.Scanner;



public class Student extends User

{

	private Program program;

	private ArrayList<Result> academicHist = new ArrayList<>();

	private int maxCourses;

	private boolean exempted;

	private ArrayList<Course> enrolled = new ArrayList<Course>();

	public int length;

	Scanner keyboard = new Scanner(System.in);

        

	public ArrayList<Course> getEnrolled() {

		return enrolled;

	}





	public void setEnrolled(ArrayList<Course> enrolled) {

		this.enrolled = enrolled;

	}





	public Student(String name, String userID, String password, Program program)

    {

    	super(name, userID, password, "Student");   

    	this.setProgram(program);

    	this.maxCourses = 4;

    	this.exempted = false;

    }

	



    public Student(String studentId){

    	super("default", studentId, "default", "default");
	

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



	public String getPassword() {

		return password;

	}



    public void setMaxCourses(int maxCourses) {

    	this.maxCourses = maxCourses;

	}



	public int getMaxCourses() {

		return maxCourses;

	}



    public void setExempted(boolean exempted) {

    	this.exempted = exempted;

	}



	public boolean getExempted() {

		return exempted;

	}

	

	public Program getProgram() {

		return program;

	}



	public void setProgram(Program program) {

		this.program = program;

	}



	public String getActor() {

		return "Student";

	}

	

	public void addResult(Result r, Student s) 

	{

		s.academicHist.add(r);

	}

	

	public ArrayList<Result> getAcademicHist(){

		return academicHist;

	}

	public void setAcademicHist(ArrayList<Result> academicHist){

		this.academicHist=academicHist;

	}

	

	




	public void printStudentMenu(CMS cms, Student s)

	{


    	System.out.print("\n***Student Menu" + " || Week " 
				+ cms.getWeek() + "***\n");
    	System.out.printf("%-25s %s\n", "View Academic History", "A");
    	System.out.printf("%-25s %s\n", "Enrollment", "B");
    	System.out.printf("%-25s %s\n", "View Enrolled Course", "C");
    	System.out.printf("%-25s %s\n", "Exit Program", "D");
    	System.out.printf("%-25s %s\n", "Logout", "E");
		                                             
		System.out.printf("%-26s", "Enter your choice:" );


		String input = cms.kb.nextLine();
		System.out.println();
		

    	if(input.trim().toUpperCase().equals("A"))
    	{
    		getAcademicHist(s);
    	}
    	else if(input.trim().toUpperCase().equals("B"))
    	{
    		modifyEnrollment(cms, s);
    	}
    	else if(input.trim().toUpperCase().equals("C"))
    	{
    		viewEnrolledCourses(s);
    	}
    	else if(input.trim().toUpperCase().equals("D"))
    	{
    		FileIO.write(CMS.studentList, CMS.lecturerList, CMS.PCList, 

					CMS.adminList, CMS.courses, CMS.programs);

			System.exit(1);
    	}
    	else if(input.trim().toUpperCase().equals("E"))
    	{
    		cms.getLogin();
    	}
    	else
    	{
    		System.out.println("Option " + input.trim().toUpperCase()
			+ " does not exists!");
    	}

	}

	

	void modifyEnrollment(CMS cms, Student s)

	{

		System.out.println("\n***Welcome to the Course Management System || Student***\" "
				+ s.getName().toUpperCase() + " | WEEK "+ cms.getWeek());

		System.out.printf("%-25s %s\n", "Enrol in a course", "1");
    	System.out.printf("%-25s %s\n", "Withdraw from a course", "2");
     	System.out.printf("%-25s %s\n", "Back to Menu", "0");
		int i = cms.kb.nextInt();

		

		switch(i)

		{

		case 0:

			printStudentMenu(cms, s);

			break;

		case 1:

			enrolInCourse(s);

			break;

		case 2: 

			withdrawCourse(s);

			break;

		

		default:

			System.out.println("\n Option does not exists! \n");

			modifyEnrollment(cms, s);

			break;

		}

	}

	

	private void withdrawCourse(Student s) {

		

		System.out.print("\n***Welcome to the Course Management System || " 
		+ s.getUserID().toUpperCase() + "***\n");

	
		System.out.println("Type in course code from list of enrolled courses to withdraw:");

		System.out.println("                                                       ");

		for(Course c: s.getEnrolled()) {

			System.out.println(c.getCourseID()+" "+c.getName());

		}


		String code = keyboard.nextLine();

		if (checkDuplicate(code)) {

			System.out.println("Succesfully frop from course! ");

		}else {

			System.out.println("Invalid Course Code - Please try again! ");

		}

	}

	 void getAcademicHist(Student s)

	{

		System.out.print("\n***Welcome to the Course Management System || "
		+ s.getName().toUpperCase() + " | " + s.getUserID().toUpperCase()+"\n");
	

		

		for(Result r: s.getAcademicHist())

		 {

			System.out.println(r.getCourse().getName() + " | " + r.getMarks() + " | " + r.getGrade());

		 }

		System.out.println();

	}

	

	

	private void enrolInCourse(Student s) {
		int i= 0;
		for(Course c: CMS.courses)
		{
			i++;
			if (c.isList() == false)
			{
				System.out.println(c.getCourseID()+ " "+c.getName());
			}
		}
		System.out.println("   ");
		System.out.println("Type in course code of availaible courses from above to enrol:");
		String code = keyboard.nextLine();
		if (checkDuplicate(code)) {
			
			System.out.println("Successfully enrolled in course! ");
		}else {
			System.out.println("Invalid course code or prerequisites not met ! ");
		}
	}


	

	private void viewEnrolledCourses(Student s) {

		System.out.print("\n***Welcome to the Course Management System" 
		+ s.getName().toUpperCase() + " | " + s.getUserID().toUpperCase() +"***\n");

		System.out.println("List of enrolled Courses:");

		

		for(Course c: s.getEnrolled()) {

			System.out.println(c.getCourseID()+ " " + c.getName());

		}

		

	}

	

	

	

	private boolean checkDuplicate(String courseID) { 

		for (int a = 0; a < CMS.courses.size(); a++) {

			if (CMS.courses.get(a).getCourseID().equals(courseID)) {

				return true;

			}

		}

		return false;

	}





		
	}



