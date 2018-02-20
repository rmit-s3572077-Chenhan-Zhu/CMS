import java.util.ArrayList;
import java.util.Scanner;

public class ProgramCoordinator extends User {
	Scanner keyboard = new Scanner(System.in);
	private Program program;

	public ProgramCoordinator(String name, String userID, String password, Program pa) {
		super(name, userID, password, "PC");
		this.program = pa;
	}

	public void setProgram(Program pa) {
		this.program = pa;
	}

	public Program getProgram() {
		return this.program;
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

	public String getActor() {
		return "PC";
	}

	public void printPCMenu(CMS cms, ProgramCoordinator p) {
		System.out.print("\n***Program Coordinator Menu" + " || Week " 
				+ cms.getWeek() + "***\n");
		System.out.printf("%-25s %s\n", "Add New Course", "A");
		System.out.printf("%-25s %s\n", "Grant Special Permission", "B");
		System.out.printf("%-25s %s\n", "Grant Exemption", "C");
		System.out.printf("%-25s %s\n", "View Course", "D");
		System.out.printf("%-25s %s\n", "Exit Program", "E");
		System.out.printf("%-25s %s\n", "Logout", "F");

		System.out.printf("%-26s", "Enter your choice:" );
		String input = cms.kb.nextLine();
		System.out.println();

		if(input.trim().toUpperCase().equals("A"))
		{
			addNewCourse(cms);
		}
		else if(input.trim().toUpperCase().equals("B"))
		{
			grantSpecialPermission();
		}
		else if(input.trim().toUpperCase().equals("C"))
		{
			grantExemption();
		}
		else if(input.trim().toUpperCase().equals("D"))
		{
			viewCourses(cms);
		}
		else if(input.trim().toUpperCase().equals("E"))
		{
			FileIO.write(CMS.studentList, CMS.lecturerList, CMS.PCList, CMS.adminList, CMS.courses, CMS.programs);
			System.exit(1);
		}
		else if(input.trim().toUpperCase().equals("E"))
		{
			cms.getLogin();
		}
		else{
			System.out.println("Option " + input.trim().toUpperCase()
					+ " does not exists!");

			printPCMenu(cms, p);
			
		}
	}



	private void addNewCourse(CMS cms) {
		if (cms.getWeek() >= 4){
			System.out.println("Course cannot be added!");
		}else{
		System.out.print("\n***Program Coordinator Menu || Add New Course***\n");
		System.out.printf("\n\n%-50s", 
							"Enter Course ID for new course: ");
		//
		String courseID = keyboard.nextLine();
		
		System.out.printf("\n\n%-50s", 
				"Enter Course Name for new course: ");
		String name = keyboard.nextLine();
		
		System.out.printf("\n\n%-50s", 
				"Enter Course description for new course: ");
		String description = keyboard.nextLine();
		
		System.out.printf("\n\n%-50s", 
				"Enter Course prerequisite for new course: ");
		String prerequisite1 = keyboard.nextLine();
		
		System.out.printf("\n\n%-50s", 
				"Enter Course prerequisite for new course: ");
		String prerequisite2 = keyboard.nextLine();
		
		System.out.printf("\n\n%-50s", 
				"Is the new course a core course? (true/false) ");
		String input = keyboard.nextLine();
		Boolean core;
		if (input == "true")
		{
			core = true;
		}
		else
			core = false;
		if (checkDuplicate(courseID)) {
			System.out.println("Course ID already exist in system . \n" + "Please enter different Code: ");

		} else {
			int numOfStudents = 0;
			Course course = new Course(name, courseID, description, numOfStudents, core);
			CMS.courses.add(course);
			Course[] prerequisite = new Course[2];
			Course c1 = CMS.searchC(prerequisite1);
			Course c2 = CMS.searchC(prerequisite2);
			prerequisite[0] = c1;
			prerequisite[1] = c2;
			course.setPrerequisite(prerequisite);
			course.notListing();
			System.out.println("New course added successfully!");
		}
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

	public void grantExemption() {
		System.out.print("\n***Program Coordinator Menu || Grant Exemption***\n");
		System.out.println("Enter student number: ");
		String studentId = keyboard.nextLine();
		Student a = CMS.searchS(studentId);
		for (int i = 0; i < a.getAcademicHist().size(); i++) {
			if (a.getAcademicHist().get(i) != null) {
				System.out.println(i + 1 + ":" + CMS.searchS(studentId).getAcademicHist().get(i).getCourse().getCourseID()
						+ " " + CMS.searchS(studentId).getAcademicHist().get(i).getMarks() + "\n");
			}
		}
		
		System.out.println("Please enter position: ");
		int p = keyboard.nextInt();
		System.out.println("Please enter marks: ");
		double results = keyboard.nextDouble();
		a.getAcademicHist().get(p - 1).setMarks(results);
		a.setExempted(true);
		System.out.println("Exemption granted!!");
	}

	public void grantSpecialPermission() {
		System.out.println("\n***Program Coordinator Menu || Grant Special Permission ***\n");
		System.out.println("Please enter student number: ");
		String studentId = keyboard.nextLine();
		
		System.out.println("Please enter new maximum course number: ");
		int c = keyboard.nextInt();
		CMS.searchS(studentId).setMaxCourses(c);
		System.out.println("Special permission granted!");
	}
	
	private void viewCourses(CMS cms) {
		System.out.print("\n***Program Coordinator Menu || view Course***\n");

		System.out.println("Course ID: ");
		String courseID = cms.kb.next();

		if (CMS.courses.size() <= 0) {
			System.out.println("No Current Courses.");
		} else {
			for (int i = 0; i < CMS.courses.size(); i++) {
				if (CMS.courses.get(i).getCourseID().equals(courseID)) {
					System.out.printf(
							"\nCourse Name: %s " + "\nCourse Code: %s" + "\nCourse Description: %s"
									+ "\nNumber of Student : %s%n",
							CMS.courses.get(i).getName(), CMS.courses.get(i).getCourseID(), CMS.courses.get(i).getDescription(),
							CMS.courses.get(i).getNumOfStudents());
					System.out.println("If Listed: " + CMS.courses.get(i).isList());
					System.out.println("Is Core: "+CMS.courses.get(i).isCore());
					if (CMS.searchC(courseID).getPrerequisite()[0] != null) {
						System.out.println("Prerequisite: " + CMS.searchC(courseID).getPrerequisite()[0].getName());
					} else {
						System.out.println("this course has no prerequisite course");
					}
					if (CMS.searchC(courseID).getPrerequisite()[1] != null) {
						System.out.println("Prerequisite: " + CMS.searchC(courseID).getPrerequisite()[1].getName());
					} else {
						System.out.println("this course has no prerequisite course");
					}
				}
			}
		}
	}

}
