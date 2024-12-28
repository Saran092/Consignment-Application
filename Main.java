import java.util.*;
class Main{
	public static void main(String args[])
	{
		Scanner Sc = new Scanner(System.in);

		int ch,adCh,cuCh,orChoo,togChoo,shCh,shMch,addCost=0;
		int CustomerID,baserate,totalCost,vehicleId;
		String source="",destination="",typeOfGoods="",assignDestination;
		float weight;
		double distance = 0.0,capacity,shWeight;
		boolean check = false;
		String user,pass,cuUser,cuPass,cuCon;

		Admin admin = new Admin();
		Customer customer = new Customer();
		Order order = new Order();
		Shipment ship = new Shipment();

		List <Admin> admObj = new ArrayList<>();
		admObj.add(new Admin("Admin1","ad123@"));
		admObj.add(new Admin("Admin2","ad321@"));
		List <Customer> conObj = new ArrayList<>();
		List <Order> ordObj = new ArrayList<>();
		List <Shipment> shObj = new ArrayList<>();

		Map<Customer, List<Order>> obj = new HashMap<>();
		Map<Integer,String> vehicle = new HashMap<>();




		do{
			System.out.println("1.Admin Panel\n2.Customer Profiles\n3.Order Placement\n4.Shipment Management\n5.Tracking and Notification System\n6.Review System\n7.Customer Support\n8.Exit");
			System.out.println("Enter Your Choice:");
			ch = Sc.nextInt();
			switch(ch)
			{
				case 1://Admin Panel
					Sc.nextLine();
					System.out.println("Enter Your Admin UserName:");
					user = Sc.nextLine();
					for(Admin ad : admObj){
						if(ad.getUser().equals(user)){
							check = true;
							System.out.println("Enter Your Admin Password:");
							pass = Sc.nextLine();
							if(ad.getPass().equals(pass)){
								do{
									System.out.println("1.Customer Details\n2.Order Details\n3.Vehicles Details\n4.Shipment Details\n5.Exit..");
									adCh =Sc.nextInt();
									switch(adCh){
										case 1:
											System.out.println("Customer Detail:");
											System.out.printf("%-20s%-20s%-20s\n","Name","Mobile NUmber","Customer ID");
											for(Customer cuPr : conObj){
												System.out.println(customer.toString(cuPr));
											}
											break;
										case 2:
											System.out.println("Order Detail:");
											System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n","Name","Customer ID","Mobile No","Source","Destination","TypeOfGoods","Distance","Weight","Total Cost");
											for(Map.Entry<Customer,List<Order>> entry : obj.entrySet())
											{
												Customer cuP = entry.getKey();
												for(Order orP: entry.getValue())
												{
													System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",cuP.getUser(),cuP.getId(),cuP.getCon(),orP.getSource(),orP.getDes(),orP.getTOG(),orP.getDis(),orP.getWeg(),orP.getTotCost());
													break;
												}
											}
											break;
										case 3:
											System.out.println("Vehicles Detail:");
											System.out.printf("%-20s%-20s\n","VehicleId","Destination");
											for(Map.Entry<Integer,String> entry:vehicle.entrySet())
											{
												System.out.printf("%-20s%-20s\n",entry.getKey(),entry.getValue());
											}
											break;
										case 4:
											System.out.println("Shipment Detail:");
											System.out.println("1.Add Shipment\n2.Assign Consignment\n3.View Active Shipment\n4.Exit");
											System.out.println("Enter Your Choice:");
											shCh = Sc.nextInt();
											switch (shCh) 
											{
												case 1:
													System.out.println("Enter Vehicle ID:");
									                vehicleId = Sc.nextInt();
									                Sc.nextLine();
									                System.out.println("Enter Destination:");
									                destination = Sc.nextLine();
									                System.out.println("Enter Vehicle Capacity:");
									                capacity = Sc.nextDouble();
									                ship = new Shipment(vehicleId,destination,capacity);
									                vehicle.put(vehicleId,destination);
									                shObj.add(ship);
												break;	
												case 2:
													Sc.nextLine();
									                System.out.println("Enter Destination:");
									                assignDestination = Sc.nextLine();
									                System.out.println("Enter Consignment Weight:");
									                shWeight = Sc.nextDouble();
									                ship.assignConsignment(assignDestination,shWeight,shObj);
									            break;
									        	case 3:
									        		ship.viewActive(shObj);
									        	break;
									        	case 4:
									        		System.out.println("Exiting...");
									        	break;
									            default:
									            	System.out.println("Invalid Input..\n Try Again...");
									            break;
											}

											break;
										case 5:
											System.out.println("\nExiting...");
											break;
										default:
											System.out.println("\nInvalid Input..\nTry Again....");
											break;
									}
								}while(adCh<5);
							}
							else
								System.out.println("Password MisMatch...");
						}
					}
					if(!check)
						System.out.println("UserName MisMatch");
				break;

				case 2:// Customer Profile
					do{
						System.out.println("1.Create Login\n2.Place a Order\n3.Exit");
						System.out.println("Enter Your Choice:");
						cuCh = Sc.nextInt();
						switch (cuCh) {
							case 1:
								Sc.nextLine();
								System.out.println("Enter Your UserName:");
								cuUser = Sc.nextLine();
								System.out.println("Enter Your Password:");
								cuPass = Sc.nextLine();
								System.out.println("Enter Your Mobile Number:");
								cuCon = Sc.nextLine();
								int len = cuCon.length();
								if(len == 10){
									Random random = new Random();
									CustomerID = random.nextInt(10000);
									System.out.println("\n"+cuUser+" Your CustomerID is : "+CustomerID);
								}
								else{
									System.out.println("Enter The Correct Mobile Number "+ cuCon);
									break;
								}
								customer = new Customer(cuUser,cuPass,cuCon,CustomerID);
								conObj.add(customer);
							break;

							case 2:
								Sc.nextLine();
								System.out.println("Your Are In the Ordering Section....\n Enter Your UserName :");
								cuUser = Sc.nextLine();
								System.out.println("Enter Your Password:");
								cuPass = Sc.nextLine();
								for(Customer cuOdCh: conObj)
								{
									if((cuOdCh.getUser().equals(cuUser) /*|| (cuOdCh.getId() == (Integer.parseInt(cuUser)))*/)&& (cuOdCh.getPass().equals(cuPass)))
									{

										System.out.println("\nMenu for Source and Destination..\n1.Chennai to Coimbatore\n2.Madurai to Trichy\n3.Salem to Erode\n4.Tirunelveli to Kanyakumari\n5.Dindigul to Theni\n6.Ooty to Kodaikanal");
										System.out.println("Enter Your Choice:");
										orChoo = Sc.nextInt();
										switch(orChoo){
											case 1:
												source = "Chennai";
												destination = "Coimbatore";
												distance = 427.18;
											break;
											case 2:
												source = "Madurai";
												destination = "Trichy";
												distance = 115.17;
											break;
											case 3:
												source = "Salem";
												destination = "Erode";
												distance = 58.89;
											break;
											case 4:
												source = "Tirunelveli";
												destination = "Kanyakumari";
												distance = 73.24;
											break;
											case 5:
												source = "Dindigul";
												destination = "Theni";
												distance = 67.91;
											break;
											case 6:
												source = "Ooty";
												destination = "Kodaikanal";
												distance = 155.81;
											break;
											default:
												System.out.println("\nOut of Menu...\n Try Again..");
											break;

										}
										System.out.println("\nType of Goods Menu..\n1.General Goods\n2.Fragile Goods\n3.Heavy Equipment\n4.Documents & Small Parcels\n5.Luxury Items\n6.Medical Supplies");
										System.out.println("Enter Your Choice:");
										togChoo = Sc.nextInt();

										switch (togChoo) {
										case 1:
											typeOfGoods ="General Goods";
											addCost = 0;
										break;
										case 2:
											typeOfGoods ="Fragile Goods";
											addCost = 3;
										break;
										case 3:
											typeOfGoods ="Heavy Equipment";
											addCost = 10;
										break;
										case 4:
											typeOfGoods ="Documents & Small Parcels";
											addCost = 0;
										break;
										case 5:
											typeOfGoods ="Luxury Items";
											addCost = 5;
										break;
										case 6:
											typeOfGoods ="Medical Supplies";
											addCost = 7;
										break;
										default:
											System.out.println("\nInvalid Input..\nTry Again..");
										break;
										}
										System.out.println(cuUser +" is Choose Sourse as "+source+" and Destination as "+ destination+" and Type of Goods is "+ typeOfGoods);
										System.out.println("Enter the Weight of Goods:");
										weight = Sc.nextFloat();
										totalCost = order.findCost(weight,distance,addCost);
										order = new Order(cuUser,source,destination,typeOfGoods,weight,distance,totalCost);
										ordObj.add(order);
										if(!obj.containsKey(cuOdCh))
											obj.put(cuOdCh,new ArrayList<>());
										obj.get(cuOdCh).add(order);
										System.out.println("Total Cost For Your Order is = " + totalCost);
										break;

									}
									else
									{
										System.out.println("Please...Enter Your Correct Detail...\n\nTry Again");
									}
								}
							break;

							case 3:
								System.out.println("\nExiting...");
							break;

							default:
								System.out.println("\nInvalid Input..\nTry Again....");
							break;
						}
					}while(cuCh<3);
				break;
			case 3:
				Sc.nextLine();
				System.out.println("Your Are In the Ordering Section....\n Enter Your UserName or Enter Your Customer ID:");
				cuUser = Sc.nextLine();
				System.out.println("Enter Your Password:");
				cuPass = Sc.nextLine();
				for(Customer cuOdCh: conObj)
				{
					if((cuOdCh.getUser().equals(cuUser) /*|| (cuOdCh.getId() == (Integer.parseInt(cuUser)))*/)&& (cuOdCh.getPass().equals(cuPass)))
					{

						System.out.println("Menu for Source and Destination..\n1.Chennai to Coimbatore\n2.Madurai to Trichy\n3.Salem to Erode\n4.Tirunelveli to Kanyakumari\n5.Dindigul to Theni\n6.Ooty to Kodaikanal");
						System.out.println("Enter Your Choice:");
						orChoo = Sc.nextInt();
						switch(orChoo){
							case 1:
								source = "Chennai";
								destination = "Coimbatore";
								distance = 427.18;
							break;
							case 2:
								source = "Madurai";
								destination = "Trichy";
								distance = 115.17;
							break;
							case 3:
								source = "Salem";
								destination = "Erode";
								distance = 58.89;
							break;
							case 4:
								source = "Tirunelveli";
								destination = "Kanyakumari";
								distance = 73.24;
							break;
							case 5:
								source = "Dindigul";
								destination = "Theni";
								distance = 67.91;
							break;
							case 6:
								source = "Ooty";
								destination = "Kodaikanal";
								distance = 155.81;
							break;
							default:
								System.out.println("\nOut of Menu...\n Try Again..");
							break;

						}

						System.out.println("Type of Goods Menu..\n1.General Goods\n2.Fragile Goods\n3.Heavy Equipment\n4.Documents & Small Parcels\n5.Luxury Items\n6.Medical Supplies");
						System.out.println("Enter Your Choice:");
						togChoo = Sc.nextInt();
						switch (togChoo)
						{
							case 1:
								typeOfGoods ="General Goods";
								addCost = 0;
							break;
							case 2:
								typeOfGoods ="Fragile Goods";
								addCost = 3;
							break;
							case 3:
								typeOfGoods ="Heavy Equipment";
								addCost = 10;
							break;
							case 4:
								typeOfGoods ="Documents & Small Parcels";
								addCost = 0;
							break;
							case 5:
								typeOfGoods ="Luxury Items";
								addCost = 5;
							break;
							case 6:
								typeOfGoods ="Medical Supplies";
								addCost = 7;
							break;
							default:
								System.out.println("\nInvalid Input..\nTry Again..");
							break;
						}
						System.out.println(cuUser +" is Choose Sourse as "+source+" and Destination as "+ destination+" and Type of Goods is "+ typeOfGoods);
						System.out.println("Enter the Weight of Goods:");
						weight = Sc.nextFloat();
						totalCost = order.findCost(weight,distance,addCost);
						order = new Order(cuUser,source,destination,typeOfGoods,weight,distance,totalCost);
						ordObj.add(order);

						if(!obj.containsKey(cuOdCh))
							obj.put(cuOdCh,new ArrayList<>());
						obj.get(cuOdCh).add(order);
						System.out.println("Total Cost For Your Order is = " + totalCost);
						break;
					}
					else
					{
						System.out.println("Please...Enter Your Correct Detail...\n\nTry Again");
					}
				}
			break;

			case 4:
				System.out.println("Shipment Management");
				System.out.print("1.View Active Shipment\n2.Vehicle ID for Customer Destination\n3.Exit\nEnter Your Choice:");
				System.out.println("Enter Your Choice:");
				shMch = Sc.nextInt();
				switch (shMch) 
				{
					case 1:
						ship.viewActive(shObj);
					break;
					case 2:
						Sc.nextLine();
						System.out.println("Enter UserName:");
						user = Sc.nextLine();
						System.out.println("Enter Your Password:");
						pass = Sc.nextLine();
						for(Customer cust:conObj)
						{
							if((cust.getUser().equals(user)) && (cust.getPass().equals(pass)))
							{
								System.out.println("Enter Your Destination:");
								destination = Sc.nextLine();
								for(Map.Entry<Integer,String> entry : vehicle.entrySet())
								{
									if(entry.getValue().equalsIgnoreCase(destination)){
										System.out.println("The Vehicle ID for that Destination is :" +entry.getKey());
										break;
									}
								}
								System.out.println("No suitable vehicle found for the consignment");
							}
						}
					break;
					case 3:
						System.out.println("Exiting..");
					break;
					default:
						System.out.println("Invalid Input\n Try Again..");
					break;
				}

			break;

			}
		}while(ch<4);
	} }


