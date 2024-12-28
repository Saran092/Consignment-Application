class Admin{
	private String UserName,Password;

	Admin(String UserName,String Password)
	{
		this.UserName = UserName;
		this.Password = Password;
	}

	public String getUser()
	{
		return UserName;
	}
	public String getPass()
	{
		return Password;
	}

	Admin(){}
}