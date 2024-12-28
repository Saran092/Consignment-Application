import java.util.*;
class Shipment {
    private int vehicleId;
    private String destination;
    private double capacity;
    private double usedCapacity;

    public Shipment(int vehicleId, String destination, double capacity) {
        this.vehicleId = vehicleId;
        this.destination = destination;
        this.capacity = capacity;
        this.usedCapacity = 0;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public String getDestination() {
        return destination;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getUsedCapacity() {
        return usedCapacity;
    }

    public int assignConsignment(String destination,double weight,List <Shipment> ArrayList)
    {
    	for(Shipment shipments : ArrayList)
    	{
    		if(shipments.destination.equalsIgnoreCase(destination))
    			if(addConsignment(weight))
    			{
                    System.out.println("Consignment assigned to Vehicle ID: " + shipments.vehicleId);
                    return shipments.vehicleId;
    			}
    	}
    	System.out.println("No suitable vehicle found for the consignment.");
    	return 0;
    }

    public boolean addConsignment(double weight)
    {
    	if(usedCapacity + weight <= capacity)
    	{
    		usedCapacity+= weight;
    		return true;
    	}
    	return false;
    }

    public void viewActive(List <Shipment> list)
    {
    	System.out.println("Active Shipment Details:");
    	System.out.printf("%-20s%-20s%-20s%-20s\n", "Vehicle ID", "Destination", "Capacity", "Used Capacity");
    	for(Shipment Arr: list)
    	{
    		System.out.printf("%-20s%-20s%-20s%-20s\n",Arr.vehicleId,Arr.destination,Arr.capacity,Arr.usedCapacity);
    	}
    }
    Shipment(){}
}