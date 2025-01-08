import java.time.LocalDate;
class Order{
	private String UserName,Source,Destination,typeOfGoods,OrderId,orderedDate,deliveryDate;
	private float weight;
	private double distance;
	private int totalCost;

	Order(String UserName,String Source,String Destination,String typeOfGoods,float weight,double distance,int totalCost,String OrderId,String orderedDate,String deliveryDate)
	{
		this.UserName =UserName;
		this.Source = Source;
		this.Destination = Destination;
		this.typeOfGoods = typeOfGoods;
		this.weight = weight;
		this.distance = distance;
		this.totalCost = totalCost;
		this.OrderId = OrderId;
		this.orderedDate = orderedDate;
		this.deliveryDate = deliveryDate;
	}

	public int findCost(float weight,double distance,int addCost){
		int baserate = 10,weightCharge=0;
		if(distance >= 400)
			baserate =6;
		else if(distance > 200)
			baserate = 8;

		if(weight >50)
			weightCharge = (int) (weight-50.0)*5;

		return (int)(Math.round((distance*(baserate+addCost))+weightCharge));
	}

	public String getSource()
	{
		return Source;
	}
	public String getDes()
	{
		return Destination;
	}
	public String getTOG()
	{
		return typeOfGoods;
	}
	public Double getDis()
	{
		return distance;
	}
	public Float getWeg()
	{
		return weight;
	}
	public Integer getTotCost()
	{
		return totalCost;
	}
	public String getId()
	{
		return OrderId;
	}
	public String getOrdDate()
	{
		return orderedDate;
	}
	public String getDelDate()
	{
		return deliveryDate;
	}
	Order(){}
}