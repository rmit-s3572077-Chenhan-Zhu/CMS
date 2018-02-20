import java.util.Scanner;

public class Lecturer extends User
{
	private Course course;
	Scanner keyboard=new Scanner(System.in);
	public Lecturer(String name, String userID, String password, Course c)
	{
	   	super(name, userID, password, "Lecturer");   
	   	this.course = c;
	}
	
	public Course getCourse(){
		 return this.course;
	}
	
	public void setCourse(Course c) 
	{
	   	this.course = c;
	}
	 
	public void setName(String name) 
	{
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
		return "Lecturer";
	}

	public void viewStudentAccHistory(){
		for (int i = 0; i < course.getCourseStudents().size(); i++) {
		}
		System.out.println("Please enter student ID: ");
		String sId=keyboard.nextLine();
		Student student=CMS.searchS(sId);
		for (int i = 0; i < student.getAcademicHist().size(); i++) {
			System.out.println("Course: "+student.getAcademicHist().get(i).getCourse().getCourseID()+
					"Mark: "+student.getAcademicHist().get(i).getMarks());
		}
		
		
	}
	
	public void addResult(){
		System.out.println("Please enter student ID: ");
		String sId=keyboard.nextLine();
		Student student=CMS.searchS(sId);
		if(course.getCourseStudents().size()==0){
		    System.out.println("0 student enrolled in this course");
		}
		else{
		    for (int i = 0; i < course.getCourseStudents().size(); i++){
		    	System.out.println("Please enter course ID: ");
				String cId=keyboard.nextLine();
				Course course =CMS.searchC(cId);
	        }
		}
		System.out.println("Please enter course ID: ");
		String cId=keyboard.nextLine();
		Course course =CMS.searchC(cId);
		if(course.getCourseStudents().contains(student)){
		    System.out.println("Please enter result: ");
	        double x=Double.parseDouble(keyboard.nextLine());
	        System.out.println("Result F/N:(Please enter f or n)");
	        String rnf=keyboard.nextLine();
	        Result r=new Result(course, x);
	        if(rnf=="f"){
	            r.RNFFalse();
	        }
	        else{
	            r.RNFTrue();
	        }
	        student.getAcademicHist().add(r);
	        System.out.println("Result update successful!");
		}
		else{
		    System.out.println("Student is not enrolled in this course.");
		}
	}
	
		
	
	public void printLecturerMenu(CMS cms, Lecturer l)
	{
		System.out.print("\n***Welcome to the Course Management System || Lecturer***\n");                                                  
		System.out.printf("%-25s %s\n", "View Result", "A");
		System.out.printf("%-25s %s\n", "Upload Result", "B");
		System.out.printf("%-25s %s\n", "Exit Program", "C");
		System.out.printf("%-25s %s\n", "Logout", "D");                 
		                                            
		String i = cms.kb.nextLine();
		
		if (i.trim().toUpperCase().equals("A")) {
			viewStudentAccHistory();
			
			
		} else if (i.trim().toUpperCase().equals("B")) {

			addResult();
			
		} else if (i.trim().toUpperCase().equals("C")) {
			FileIO.write(CMS.studentList, CMS.lecturerList, CMS.PCList, CMS.adminList, CMS.courses, CMS.programs);
			System.exit(1);
			
		} else if (i.trim().toUpperCase().equals("D")) {
			cms.getLogin();
			
		}
		else
		{
			System.out.println("Option " + i.trim().toUpperCase() + " does not exists!");
			printLecturerMenu(cms, l);
			
		}
	}



	
	

	
}


