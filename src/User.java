public abstract class User 
{
	protected String userID;
	protected String password;
	protected String name;
	protected String actor;
	
	public User (String name, String userID, String password, String actor) 
	{
		this.userID = userID;
		this.password = password;
		this.name = name;
		this.actor = actor;
	}
	
	public abstract String getUserID();

	public abstract void setUserID(String userID);

	public abstract String getPassword();

	public abstract void setPassword(String password);

	public abstract String getName();

	public abstract void setName(String name);
	
	public abstract String getActor();
}
