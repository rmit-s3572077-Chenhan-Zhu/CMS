import java.util.*;

public class Program {

	private String programName;
	private String code;
	private List<Course> courses =new ArrayList<Course>();

	public Program(String programName, String code) {
		this.programName = programName;
		this.code = code;
	}
	
	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getCode() {
		return code;
	}
	public void setProgramCode(String code) {
		this.code = code;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
