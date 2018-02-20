import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import org.omg.CORBA.PRIVATE_MEMBER;

public class FileIO{
	public static String userFile="./file/userfile.txt";
	public static String courseFile="./file/coursefile.txt";
	public static String resultFile="./file/results.txt";
	public static String programFile = "./file/programfile.txt";
	
	public static void write(ArrayList<Student> studentList ,ArrayList<Lecturer> lecturerList,
			ArrayList<ProgramCoordinator> pCList,ArrayList<Admin> adminList,ArrayList<Course> courses,
			ArrayList<Program> programs) { 
		String userPath=userFile;
		String resultPath=resultFile;
		String coursePath=courseFile;
		String programPath=programFile;
        String s1 = new String();  
        //user output
        try {  
            File f = new File(userPath);  
            BufferedWriter output = new BufferedWriter(new FileWriter(f,false));    
            if (f.exists()) {  
            } else if (f.createNewFile()) 
            { 
            }
            for (int i = 0; i < studentList.size(); i++) {
            	s1="";
            	s1+=studentList.get(i).getUserID();
            	s1+=":";
            	s1+=studentList.get(i).getPassword();
            	s1+=":";
            	s1+=studentList.get(i).getName();
            	s1+=":0: :";
            	s1+=studentList.get(i).getProgram().getCode();
            	s1+=":"+((Student)studentList.get(i)).getMaxCourses()+":"+
            				((Student)studentList.get(i)).getExempted();
            	s1+="\n";
            	output.write(s1);
            }
            for (int j = 0; j < lecturerList.size(); j++) {
            	s1="";
            	s1+=lecturerList.get(j).getUserID();
            	s1+=":";
            	s1+=lecturerList.get(j).getPassword();
            	s1+=":";
            	s1+=lecturerList.get(j).getName();
            	s1+=":";
            	s1+="1:"+((Lecturer)lecturerList.get(j)).getCourse().getCourseID()+": : : ";
            	s1+="\n";
            	output.write(s1);
			}
            for (int j = 0; j < pCList.size(); j++) {
            	s1="";
            	s1+=pCList.get(j).getUserID();
            	s1+=":";
            	s1+=pCList.get(j).getPassword();
            	s1+=":";
            	s1+=pCList.get(j).getName();
            	s1+=":";
            	s1+="2: :"+pCList.get(j).getProgram().getCode()+": : ";
            	s1+="\n";
            	output.write(s1);
            }
            for (int j = 0; j < adminList.size(); j++) {
            	s1="";
            	s1+=adminList.get(j).getUserID();
            	s1+=":";
            	s1+=adminList.get(j).getPassword();
            	s1+=":";
            	s1+=adminList.get(j).getName();
            	s1+=":";
            	s1+="3: : : : ";
            	s1+="\n";
            	output.write(s1);
			}
            output.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
	
       
        //course output
        try {  
            File f = new File(coursePath);  
            BufferedWriter output = new BufferedWriter(new FileWriter(f,false));    
            if (f.exists()) {  
            } else if (f.createNewFile()) 
            { 
            }
            for (int i = 0; i < courses.size(); i++) {
            	s1="";
            	s1=courses.get(i).getName()+":"+courses.get(i).getCourseID()+":"
            	+courses.get(i).getDescription()+":"+courses.get(i).getNumOfStudents()+":";
            	if(courses.get(i).isCore()==true){
            		s1+="1:";
            	}
            	else{
            		s1+="0:";
            	}
            	
            	if(courses.get(i).isList()==true){
            		s1+="1:";
            	}
            	else{
            		s1+="0:";
            	}
            	
            	if(courses.get(i).getPrerequisite()[0]!=null){
            		s1+=courses.get(i).getPrerequisite()[0].getCourseID()+":";
            	}
            	else{
            		s1+=" :";
            	}
            	
            	s1+="\n";
            	output.write(s1);
			}
           output.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        //program output
       
        try {  
            File f = new File(programPath);  
            BufferedWriter output = new BufferedWriter(new FileWriter(f,false));    
            if (f.exists()) {  
            } else if (f.createNewFile()) 
            { 
            }
            for (int i = 0; i < programs.size(); i++) {
            	s1="";
            	s1+=programs.get(i).getProgramName()+":"+programs.get(i).getCode()+":";
            	String x=s1;
            	s1="";
            	for (int j = 0; j < programs.get(i).getCourses().size(); j++) {
                	s1+=x+programs.get(i).getCourses().get(j).getCourseID()+"\n";
				}
            	output.write(s1);
			}
            output.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
 
        try {  
            File f = new File(resultPath);  
            BufferedWriter output = new BufferedWriter(new FileWriter(f,false));    
            if (f.exists()) {  
            } else if (f.createNewFile()) 
            { 
            }
            for (int i = 0; i < studentList.size(); i++) {
            	for (int j = 0; j < studentList.get(i).getAcademicHist().size(); j++) {
            		s1="";
            		if(studentList.get(i).getAcademicHist().get(j)!=null){
            			s1=studentList.get(i).getUserID()+":"+studentList.get(i).getAcademicHist().get(j).getCourse().getCourseID()+":";
            			s1+=studentList.get(i).getAcademicHist().get(j).getMarks();
            			if(studentList.get(i).getAcademicHist().get(j).isRNF()==true){
            				s1+=":1";
            			}
            			else{
            				s1+=":0";
            			}
            			s1+="\n";
            			output.write(s1);
            		}
				}
            	for (int j = 0; j < studentList.get(i).getEnrolled().size(); j++) {
					s1="";
					if(studentList.get(i).getEnrolled().get(j)!=null){
            			s1=studentList.get(i).getUserID()+":"+studentList.get(i).getEnrolled().get(j).getCourseID()+": :0";
            			s1+="\n";
            			output.write(s1);
            		}
				}
			}

            output.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
	}
 
    
	public static void read(ArrayList<Student> studentList, ArrayList<Lecturer> lecturerList, ArrayList<ProgramCoordinator> PCList, ArrayList<Admin> adminList, ArrayList<Course> courses, ArrayList<Program> programs, CMS cms) 
	{  
	    String s = null;  
       	File f = new File(courseFile);
	    String c=null;
	    if (f.exists()) 
	    {  
	        try 
	        {  
	            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));  
	           	while ((s = br.readLine()) != null) 
	            {
	           		String[] data=s.split(":");
	           		if((data[6].equals(" "))&&!(data[7].equals(" "))){
	           			Course[] p=new Course[2];
	           			p[0]=null;
	           			p[1]=null;
	           			Course course=new Course(data[0], data[1], data[2], Integer.parseInt(data[3]),
		                	Boolean.parseBoolean(data[4]),Boolean.parseBoolean(data[5]),p);
	           			if(data[4]=="1"){
		                	course.setCore(true);
		                }
		                else{
		                	course.setCore(false);
		                }
		                if (data[5]=="1") {
							course.isListing();
						}
		                else{
		                	course.notListing();
		                }
	           			courses.add(course);
	           		}else{
	           			Course c1=CMS.searchC(data[6]);
						Course c2=CMS.searchC(data[7]);
						Course[] p=new Course[2];
						p[0]=c1;
						p[1]=c2;
		                Course course=new Course(data[0], data[1], data[2], Integer.parseInt(data[3]),
		                		Boolean.parseBoolean(data[4]),Boolean.parseBoolean(data[5]),p);
		                if(data[4]=="1"){
		                	course.setCore(true);
		                }
		                else{
		                	course.setCore(false);
		                }
		                if (data[5]=="1") {
							course.isListing();
						}
		                else{
		                	course.notListing();
		                }
		                courses.add(course);
	           		}
	    
            		
	            }
            	br.close();
	        }
	        catch (Exception e) 
	        {  
	            e.printStackTrace();  
	        }  
	    } 
	    else 
	    {  
	        System.out.println("File doesn't exist!");  
	    }

	    f=new File(programFile);
	    String n="";
	    String x="";
	    if (f.exists()) 
	    {  
	        try 
	        {  
	            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
	            while ((s = br.readLine()) != null) 
	            {
	            	String[] data=s.split(":");
	            	if(!(programs.contains(CMS.searchP(data[1])))){
                    	Program program=new Program(data[0], data[1]);
                    	programs.add(program);
                    }
	            }
	            br.close();
	            BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
	           	while ((n = b.readLine()) != null) 
	            {
	           		String[] data=n.split(":");
	           		for (int j = 0; j < programs.size(); j++) {
						if(programs.get(j).getCode().equals(data[1])){
							programs.get(j).getCourses().add(CMS.searchC(data[2]));
						}
					}
	            }
	           	br.close();
	           	BufferedReader a = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
	           	while ((x = a.readLine()) != null) {
	           		String[] data=x.split(":");
	           		for (int i = 0; i < courses.size(); i++) {
	           			for (int j = 0; j < courses.get(i).getPrograms().size(); j++) {
	           				if(courses.get(i).getCourseID().equals(data[2])){
	           					if(!(courses.get(i).getPrograms().
	           							contains(CMS.searchP(data[1])))){
	           						courses.get(i).getPrograms().add(CMS.searchP(data[1]));
	           					}
	           				}
						}
					}
				}
	           	br.close();
	        }
	        catch (Exception e) 
	        {  
	            e.printStackTrace();  
	        }  
	    } 
	    else 
	    {  
	        System.out.println("File doesn't exist!");  
	    }
	    

	    f = new File(userFile);
        
	    if (f.exists()) 
        {  
            try 
            {  
                BufferedReader br =  
                    new BufferedReader(new InputStreamReader(new FileInputStream(f)));  
                while ((s = br.readLine()) != null) 
                {
                    String[] data=s.split(":");
                    switch (data[3]) 
                    {
						case "0":
							Student student=new Student(data[2], data[0], data[1], CMS.searchP(data[5]));
							studentList.add(student);
							break;
						case "1":
							Course course=CMS.searchC(data[4]);
							Lecturer lecturer=new Lecturer(data[2], data[0], data[1], course);
							lecturerList.add(lecturer);
							break;
						case "2":
							Program program=CMS.searchP(data[5]);
							ProgramCoordinator programCoordinator=new ProgramCoordinator(data[2], data[0], data[1], program);
							PCList.add(programCoordinator);
							break;
						case "3":
							Admin admin=new Admin(data[2], data[0], data[1]);
							adminList.add(admin);
							break;
						default:
							break;
					}
                }  
                br.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace(); 
            }  
        } 
        else 
        {  
            System.out.println("File doesn't exist");  
        }
	}

	public static void readResults(ArrayList<Student> studentList, ArrayList<Course> courses, CMS cms) 
	{  
	    String s = null;  
        File f = new File(resultFile);
        
        if (f.exists()) 
        {  
            try 
            {  
                BufferedReader br = 
                		new BufferedReader(new InputStreamReader(new FileInputStream(f)));  
                while ((s = br.readLine()) != null) 
                {
                    String[] data=s.split(":");
                    if (data[2].equals(" ")) 
                    {
                    	Student student = CMS.searchS(data[0]);
                        Course course=CMS.searchC(data[1]);
                        course.getCourseStudents().add(student);
                        student.getEnrolled().add(course);
                    	
					}
                    else{
                        int c=0;
                    	Student student = CMS.searchS(data[0]);
                        Course course=CMS.searchC(data[1]);
                        for (int i = 0; i < student.getAcademicHist().size(); i++) {
                            if(student.getAcademicHist().get(i).getCourse().equals(course)){
                                c++;
                            }
                        }
                        if (c==0) {
                            Result result=new Result(course, Double.parseDouble(data[2]));
                            if(data[3].equals("1")){
                                result.RNFTrue();
                            }
                            else{
                                result.RNFFalse();
                            }
                            student.addResult(result,student);
                        }
                    }
                }  
      
            } 
            catch (Exception e) 
            {
                e.printStackTrace(); 
            }  
        } 
        else 
        {  
            System.out.println("File doesn't exist");  
        }  
	}
	
}





