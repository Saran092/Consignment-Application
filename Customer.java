class Customer{
	private String UserName,Password,Contact;
	private int CustomerID;

	Customer(String UserName,String Password,String Contact,int CustomerID)
	{
		this.UserName = UserName;
		this.Password = Password;
		this.Contact = Contact;
		this.CustomerID =CustomerID;
	}

	public String getUser()
	{
		return UserName;
	}
	public String getPass()
	{
		return Password;
	}
	public String getCon()
	{
		return Contact;
	}
	public int getId()
	{
		return CustomerID;
	}

	public String toString(Customer obj)
	{
		return String.format("%-20s%-20s%-20s\n",obj.UserName,obj.Contact,obj.CustomerID);
	}


	Customer(){}
}