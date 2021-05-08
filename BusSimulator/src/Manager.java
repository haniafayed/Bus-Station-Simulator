import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Manager extends Trips implements adminActions
{
	String username="Manager";
	String password="5757";
	ArrayList<Trips> trips2 = new ArrayList<Trips>();
	ArrayList<Driver> drivers=new ArrayList<Driver>();
	
	public boolean validateUser(String x,String y)
	{
		boolean flag=false;
		if(this.username.equals(x) && this.password.equals(y))
			flag=true;
		return flag;
	}
	
	public void loadTrips() throws FileNotFoundException
	{
		File file = new File("Trips2.txt");
		Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) 
        {
            String line = scan.nextLine();
            String[] lineArray = line.split(",");
            Trips tempTrip = new Trips();
            tempTrip.trip=lineArray[0];
            tempTrip.vehicle=lineArray[1];
            tempTrip.type=lineArray[2];
            tempTrip.source=lineArray[3];
            tempTrip.dest=lineArray[4];
            tempTrip.date=lineArray[5];
            tempTrip.time=lineArray[6];
            tempTrip.direction=lineArray[7];
            tempTrip.stops=lineArray[8];
            tempTrip.available=lineArray[9];
            tempTrip.driver=lineArray[10];
            tempTrip.price=lineArray[11];
            trips2.add(tempTrip);
        }
        scan.close();
	}
	
	public ArrayList<Trips> viewTrips (){
		return trips2;
	}
	
	public void loadDrivers() throws FileNotFoundException
	{
		File file = new File("Drivers.txt");
		Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) 
        {
        	String s;
            String line = scan.nextLine();
            String[] lineArray = line.split(",");
            Driver tempDriver = new Driver();
            tempDriver.username=lineArray[0];
            tempDriver.password=lineArray[1];
            for(int i=2;i<lineArray.length;i++) 
            {
            	s=lineArray[i];
            	tempDriver.driverTrips.add(i-2, s);
            }
            drivers.add(tempDriver);
        }
        scan.close();
	}
	
	public ArrayList<Driver> viewDrivers (){
		return drivers;
	}
	
	public int searchTrips (ArrayList<Trips> trips,String ID)
	{
		for(int i=0;i<trips.size();i++) 
		{
			if(trips.get(i).trip.equals(ID))
					return i;
		}
		return -1;
	}
	
	public ArrayList<Trips> addNewTrip(ArrayList<Trips> trips,String ID,String type,String vehicle,String source, String dest,String date,String time,String direction,String stops,String seats,String driver,String price)
	{
		Trips tempTrip = new Trips();
		//ObservableList<Trips> allTrips;
		tempTrip.trip=ID;
        tempTrip.vehicle=vehicle;
        tempTrip.type=type;
        tempTrip.source=source;
        tempTrip.dest=dest;
        tempTrip.date=date;
        tempTrip.time=time;
        tempTrip.direction=direction;
        tempTrip.stops=stops;
        tempTrip.available=seats;
        tempTrip.driver=driver;
        tempTrip.price=price;
        trips.add(tempTrip);
        //allTrips = FXCollections.observableArrayList(trips);
		return trips;
	}
	public ArrayList<Trips> removeTrip(int index,ArrayList<Trips> trips) {
		trips.remove(index);
		return trips;
	}
	
	public void setPrice(int index,String price,ArrayList<Trips> trips)
	{
		Trips tempTrip=new Trips();
		tempTrip=trips.get(index);
		tempTrip.price=price;
		trips.remove(index);
		trips.add(index, tempTrip);
	}
	public void setDriver(String driver,ArrayList<Trips> trips,int index) {
		Trips tempTrip=new Trips();
		tempTrip=trips.get(index);
		tempTrip.driver=driver;
		trips.remove(index);
		trips.add(index, tempTrip);	
	}
	
	public void setSource(String source,ArrayList<Trips> trips,int index) {
		Trips tempTrip=new Trips();
		tempTrip=trips.get(index);
		tempTrip.source=source;
		trips.remove(index);
		trips.add(index, tempTrip);
	}
	public void saveTrips(ArrayList<Trips> trips) throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(new FileOutputStream("Trips2.txt",false));
		int i;
		for(i=0;i<trips.size();i++)
		{
			pw.print(trips.get(i).trip);
			pw.print(",");
			pw.print(trips.get(i).vehicle);
			pw.print(",");
			pw.print(trips.get(i).type);
			pw.print(",");
			pw.print(trips.get(i).source);
			pw.print(",");
			pw.print(trips.get(i).dest);
			pw.print(",");
			pw.print(trips.get(i).date);
			pw.print(",");
			pw.print(trips.get(i).time);
			pw.print(",");
			pw.print(trips.get(i).direction);
			pw.print(",");
			pw.print(trips.get(i).stops);
			pw.print(",");
			pw.print(trips.get(i).available);
			pw.print(",");
			pw.print(trips.get(i).driver);
			pw.print(",");
			pw.print(trips.get(i).price);
			pw.println();
			
		}
		pw.close();
		
	}
	
	public void saveDrivers(ArrayList<Driver> drivers) throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(new FileOutputStream("Drivers.txt",false));
		int i,j;
		for(i=0;i<drivers.size();i++)
		{
			pw.print(drivers.get(i).username);
			pw.print(",");
			pw.print(drivers.get(i).password);
			pw.print(",");
			ArrayList<String> temp = new ArrayList<String>();
			temp=drivers.get(i).driverTrips;
			for(j=2;j<temp.size();j++)
			{
				pw.print(temp.get(j-2)+",");
			}
			pw.println();
			
		}
		pw.close();
		
	}
	
	public void setDate(String date,ArrayList<Trips> trips,int index) {
		Trips tempTrip=new Trips();
		tempTrip=trips.get(index);
		tempTrip.date=date;
		trips.remove(index);
		trips.add(index, tempTrip);
	}
	public void setTime(String time,ArrayList<Trips> trips, int index) {
		Trips tempTrip=new Trips();
		tempTrip=trips.get(index);
		tempTrip.time=time;
		trips.remove(index);
		trips.add(index, tempTrip);
	}
	public void setAvailable(String seats,ArrayList<Trips> trips, int index) {
		Trips tempTrip=new Trips();
		tempTrip=trips.get(index);
		tempTrip.available=available;
		trips.remove(index);
		trips.add(index, tempTrip);
	}
	public void setStops(String numberOfStops,ArrayList<Trips> trips, int index) {
		Trips tempTrip=new Trips();
		tempTrip=trips.get(index);
		tempTrip.stops=numberOfStops;
		trips.remove(index);
		trips.add(index, tempTrip);
	}
	public void setType(String tripType,ArrayList<Trips> trips, int index) {
		Trips tempTrip=new Trips();
		tempTrip=trips.get(index);
		tempTrip.type=tripType;
		trips.remove(index);
		trips.add(index, tempTrip);
	}
	public void setDest(String dest,ArrayList<Trips> trips, int index) {
		Trips tempTrip=new Trips();
		tempTrip=trips.get(index);
		tempTrip.dest=dest;
		trips.remove(index);
		trips.add(index, tempTrip);
	}
	public void setDirection(String direction,ArrayList<Trips> trips, int index) {
		Trips tempTrip=new Trips();
		tempTrip=trips.get(index);
		tempTrip.direction=direction;
		trips.remove(index);
		trips.add(index, tempTrip);
	}
	public void setVehicle(String vehicle,ArrayList<Trips> trips, int index) {
		Trips tempTrip=new Trips();
		tempTrip=trips.get(index);
		tempTrip.vehicle=vehicle;
		trips.remove(index);
		trips.add(index, tempTrip);
	}
	
	public void setTrip(String trip) {
		this.trip=trip;
	}

}
