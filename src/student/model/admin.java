package student.model;

public class admin {
	private int id;
	private String name;
	private String username;
	private String pwd;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	
	public String getPwd()
	{
		return pwd;
	}
	
	public void setPwd(String pwd)
	{
		this.pwd=pwd;
	}
}