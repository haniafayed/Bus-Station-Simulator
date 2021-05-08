import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface adminActions 
{
	public void loadTrips() throws FileNotFoundException;
	
	public ArrayList<Trips> viewTrips ();
	
	public void loadDrivers() throws FileNotFoundException;
	
	public ArrayList<Driver> viewDrivers ();
	
	public int searchTrips (ArrayList<Trips> trips,String ID);
	
	public ArrayList<Trips> addNewTrip(ArrayList<Trips> trips,String ID,String type,String vehicle,String source, String dest,String date,String time,String direction,String stops,String seats,String driver,String price);
	
	public ArrayList<Trips> removeTrip(int index,ArrayList<Trips> trips);
	
	public void saveTrips(ArrayList<Trips> trips) throws FileNotFoundException;
	
	public void saveDrivers(ArrayList<Driver> drivers) throws FileNotFoundException;
}

