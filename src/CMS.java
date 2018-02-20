import java.util.ArrayList;
import java.util.Scanner;

public class CMS 
{
	public static void main(String args[])																					//Main Calling Function
	{	
		 CMS cms = new CMS();
		 FileIO.read(studentList, lecturerList, PCList, adminList, courses, programs, cms); 
		 FileIO.readResults(studentList, courses, cms);
		
		 cms.getLogin();
		 
		 
		 while(true)
		 {
			 switch (actor)
			 {
				 case "Student":
					 Student s = null;
					 for(Student x: studentList)
					 {
						 if (userID.equals(x.getUserID()))
						 {
						 	 s = x;
							 break;
						 }
					 }
					 s.printStudentMenu(cms, s);
					 break;
					 
				 case "Lecturer":
					 Lecturer l = null;
					 for(Lecturer x: lecturerList)
					 {
						 if (userID.equals(x.getUserID()))
						 {
						 	 l = x;
							 break;
						 }
					 }
					 l.printLecturerMenu(cms, l);
					 break;
					 
				 case "PC":
					 ProgramCoordinator p = null;
					 for(ProgramCoordinator x: PCList)
					 {
						 if (userID.equals(x.getUserID()))
						 {
						 	 p = x;
							 break;
						 }
					 }
					 p.printPCMenu(cms, p);
					 break;
					 
				 case "Admin":
					 Admin a = null;
					 for(Admin x: adminList)
					 {
						 if (userID.equals(x.getUserID()))
						 {
						 	 a = x;
							 break;
						 }
					 }
					 a.printAdminMenu(cms, a);
					 break;
					 
				 default:
					 System.out.println("Error- Please try again!");
					 System.exit(1);
					 break;
			}
	 	} 
	}
	
	private int week = 0;
	
	static ArrayList<Course> courses = new ArrayList<Course>();
	static ArrayList<Program> programs = new ArrayList<Program>();
	static ArrayList<Student> studentList = new ArrayList<Student>();
	static ArrayList<Lecturer> lecturerList = new ArrayList<Lecturer>();
	static ArrayList<ProgramCoordinator> PCList = new ArrayList<ProgramCoordinator>();
	static ArrayList<Admin> adminList = new ArrayList<Admin>();
	
	private static String actor;
	private static String userID;
	
	public static Student searchS(String userID)
	{
		Student s = null;
		for(Student sa: studentList)
		{
			if (userID.equals(sa.getUserID()))
			{
				s = sa;
			}
		}
		return s;
	}
	
	public static Lecturer searchL(String userID)
	{
		Lecturer l = null;
		for(Lecturer la: lecturerList)
		{
			if (userID.equals(la.getUserID()))
			{
				l = la;
			}
		}
		return l;
	}
	
	public static Course searchC(String courseID)
	{
		Course c = null;
		for(Course ca: courses)
		{
			if (courseID.equals(ca.getCourseID()))
			{
				c = ca;
			}
		}
		return c;
	}
	
	public static Program searchP(String code)
	{
		Program p = null;
		for(Program pa: programs)
		{
			if (code.equals(pa.getCode()))
			{
				p = pa;
			}
		}
		return p;
	}
	
	
	
	Scanner kb= new Scanner(System.in);	

	public void getLogin()
	{
		Scanner input= new Scanner(System.in);	
		while (true)
		{
			
			System.out.print("\n***Welcome to the Course Management System || Login***\n");                                   
			System.out.printf("%-26s",  "User ID: ");
			String userID = kb.nextLine();
			System.out.printf("%-26s",  "Password: ");
			String password = kb.nextLine();
		

			
			boolean result = checkLogin(userID, password, studentList, lecturerList, PCList, adminList);
			if(result == true)
				break;
		}
	}

	public boolean checkLogin(String inputID, String password,
			ArrayList<Student> studentList, ArrayList<Lecturer> lecturerList,
			ArrayList<ProgramCoordinator> PCList, ArrayList<Admin> adminList)
	{
		for(Student s: studentList)
		{
			if ((password.equals(s.getPassword())) && (inputID.equals(s.getUserID())))
			{
				System.out.println("\nLogin as STUDENT\n");
				
				actor = "Student";
				userID = s.getUserID();
				return true;
			}
		}
		for(Lecturer l: lecturerList)
		{
			if ((password.equals(l.getPassword())) && (inputID.equals(l.getUserID())))
			{
				System.out.println("\nLogin as LECTURER\n");
				actor = "Lecturer";
				userID = l.getUserID();
				return true;
			}
		}
		for(ProgramCoordinator p: PCList)
		{
			if ((password.equals(p.getPassword())) && (inputID.equals(p.getUserID())))
			{
				System.out.println("\nLogin as PROGRAM COORDINATOR\n");
				actor = "PC";
				userID = p.getUserID();
				return true;
			}
		}
		for(Admin a: adminList)
		{
			if ((password.equals(a.getPassword())) && (inputID.equals(a.getUserID())))
			{
				System.out.println("\nLogin as ADMIN\n");
				actor = "Admin";
				userID = a.getUserID();
				return true;
			}
		}
		System.out.println("\nError - PLEASE TRY AGAIN\n");
		return false;
	}

    void advanceSystem()
    {
    	week++;
    }
    
    int getWeek()
    {
    	return week;
    }

	
}
