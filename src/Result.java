
public class Result {

	private Course courses;
	private double marks;
	private String grade;
	private boolean RNF;
	
	public Result (Course courses, double marks)
	{
		this.courses = courses;
		this.marks = marks;
		this.grade();
		this.RNF = false;
	}
	
	public Course getCourse()
	{
		return courses;
	}
	
	public void setCourse(Course courses)
	{
		this.courses = courses;
	}
	
	public double getMarks()
	{
		return marks;
	}
	
	public void setMarks(double marks)
	{
		this.marks = marks;
	}
	
	public String getGrade()
	{
		return grade;
	}
	
	public void grade()
	{
		if(this.marks <= 50 && this.marks >=0)
		{
			this.grade = "NN";
		}
		else if(this.marks >= 50)
		{
			this.grade = "Pass";
		}
		else if(this.marks >= 60)
		{
			this.grade = "Credit";
		}
		else if(this.marks >= 70)
		{
			this.grade = "Distinction";
		}
		else
		{
			this.grade = "High Distinction";
		}
	}
	
	public void RNFFalse()
	{
		this.RNF = false;
	}
	
	public void RNFTrue()
	{
		this.RNF = true;
	}
	
	public boolean isRNF()
	{
		return RNF;
	}
	

}
