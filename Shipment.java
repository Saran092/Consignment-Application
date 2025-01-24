import java.util.*;
class Shipment 
{
    private String vehicleId;
    private String destination;
    private double capacity;
    private double usedCapacity;

    public Shipment(String vehicleId, String destination, double capacity) {
        this.vehicleId = vehicleId;
        this.destination = destination;
        this.capacity = capacity;
        this.usedCapacity = 0;
    }

    public String getVehicleId() {
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

    public void setUC(double usedCapacity)
    {
        this.usedCapacity = usedCapacity;
    }
    public void setCap(double Capacity)
    {
        capacity = Capacity;
    }

    public List<Order> assignConsignment(List<Shipment> arrayList, List<Order> obj) 
    {
        if (arrayList.isEmpty() || obj.isEmpty()) 
        {
            System.out.println("No shipments or orders to process.");
            return obj;
        }

        for (Shipment shipments : arrayList) 
        {
            Iterator<Order> iter = obj.iterator();
            while (iter.hasNext()) 
            {
                Order ob = iter.next();
                // System.out.println("Checking Order to: " + ob.getDes() + " with weight " + ob.getWeg());
                if (shipments.destination.equalsIgnoreCase(ob.getDes())) 
                {
                    if (addConsignment(ob,shipments)) 
                    {
                        iter.remove();
                        System.out.println("Consignment assigned to Vehicle ID: " + shipments.vehicleId);
                    } 
                    else{
                        System.out.println("Order to " + ob.getDes() + " exceeds weight limit.");
                        System.out.println("Remaining Capacity :"+ shipments.getCapacity());
                    }
                } 
            }
        }

        if (!obj.isEmpty()) 
        {
            System.out.println("Unassigned orders:");
            for (Order unassigned : obj) 
            {
                System.out.println("Order to " + unassigned.getDes() + " with weight " + unassigned.getWeg());
            }
        }  
        else 
            System.out.println("All consignments have been assigned.");

        return obj;
    }

    public boolean addConsignment(Order obj,Shipment obj1) 
    {
        double usedCapacity = obj1.getUsedCapacity();
        double capacity = obj1.getCapacity();
        double weight = obj.getWeg();
        System.out.println("usedCapacity: "+ usedCapacity);
        System.out.println("Capacity: "+ capacity);
        System.out.println("Weight: "+ weight);

        if (weight <= capacity) {
            usedCapacity += weight;
            obj1.setUC(usedCapacity);
            capacity = 100-usedCapacity;
            obj1.setCap(capacity);
            System.out.println("\nConsignment added successfully. Updated used capacity: " +usedCapacity);
            System.out.println("Remaining Capacity :"+ obj1.getCapacity());
            return true;
        }

        System.out.println("Consignment exceeds capacity. Cannot add.");
    return false;
    }


    public void viewActive(List <Shipment> list)
    {
        boolean ch = false;
    	System.out.println("Active Shipment Details:");
    	System.out.printf("%-20s%-20s%-20s%-20s\n", "Vehicle ID", "Destination", "Capacity", "Used Capacity");
    	for(Shipment Arr: list)
    	{
            if(Arr.getUsedCapacity() > 0)
            {
    		  System.out.printf("%-20s%-20s%-20s%-20s\n",Arr.vehicleId,Arr.destination,Arr.capacity,Arr.usedCapacity);
              ch = true;
            }
    	}
        if(!ch)
            System.out.println("No Active Shipment..");
    }
    Shipment(){}
}