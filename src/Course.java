import java.util.*;

public class Course {

	private String name;
    private String courseID;
    private String description;
    private int maxStudents;
    private boolean core;
    private boolean list;
    private Course[] prerequisite = new Course[2];
    private List<Student> students=new ArrayList<Student>();
    private List<Program> programs=new ArrayList<Program>();
    
    
	public Course(String name, String courseID, String description, int maxStudents, boolean core)
    {
        this.name = name;
        this.courseID = courseID;
        this.description = description;
        this.maxStudents = maxStudents;
        this.core = core;
        this.list = false;
    }
	public Course(String name, String courseID, String description, int maxStudents, boolean core, boolean list,
			Course[] prerequisite) {
		super();
		this.name = name;
		this.courseID = courseID;
		this.description = description;
		this.maxStudents = maxStudents;
		this.core = core;
		this.list = list;
		this.prerequisite = prerequisite;
	}
	
    public Course(String courseID)
    {
    	this.courseID=courseID;
    }

    public String getCourseID() 
    {
		return courseID;
	}
    
    public void setCourseID(String courseID)
    {
		this.courseID = courseID;
	}
	
    public String getName()
    {
		return name;
	}
    
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public int getNumOfStudents() 
	{
		return maxStudents;
	}
	
	public void setNumOfStudents(int maxStudents)
	{
		this.maxStudents = maxStudents;
	}
	
	public boolean isCore() 
	{
		return core;
	}
	
	public void setCore(boolean core)
	{
		this.core = core;
	}
	
	public boolean isList() 
	{
		return list;
	}
	
	public void isListing() 
	{
		this.list = true;
	}
	public void notListing()
	{
		this.list = false;
	}
	
	public Course[] getPrerequisite() 
	{
		return prerequisite;
	}
	
	public void setPrerequisite(Course[] prerequisite)
	{
		this.prerequisite = prerequisite;
	}
	
	public int getMaxStudents()
	{
		return maxStudents;
	}
	
	public void setMaxStudents(int maxStudents) 
	{
		this.maxStudents = maxStudents;
	}
	
	public List<Student> getCourseStudents() 
	{
		return students;
	}
	
	public void setCourseStudents(List<Student> students) 
	{
		this.students = students;
	}
	
	public List<Program> getPrograms()
	{
		return programs;
	}
	
	public void setPrograms(List<Program> programs)
	{
		this.programs = programs;
	}
	
	public void enrol() {
	
	}
	
}