import java.util.*;


public class Driver extends Validation{
	
	String username;
	String password;
	ArrayList<String> driverTrips= new ArrayList<String>();
	public boolean validateDriver(ArrayList<Driver> drivers,String username,String password)
	{
		boolean flag=false;
		for(int i =0;i<drivers.size();i++)
		{
			if(drivers.get(i).username.equals(username) && drivers.get(i).password.equals(password))
				flag=true;
		}
		return flag;
	}
	
	public ArrayList<Trips> viewTrips(ArrayList<Trips> trips,int index,ArrayList<Driver> drivers) 
	{
		//int num;
		Driver tempDriver = new Driver();
		ArrayList<Trips> tempList = new ArrayList<Trips>();
		tempDriver=drivers.get(index);
		ArrayList<String> x = new ArrayList<String>();
		x=tempDriver.driverTrips;
		for(int i=0;i<x.size();i++)
		{
			for(int j =0;j<trips.size();j++)
			{
				if(trips.get(j).trip.equals(x.get(i)))
					tempList.add(trips.get(j));
			}
		}
		return tempList;
	}
	
	
	public int searchDrivers (ArrayList<Driver> drivers,String y)
	{
		for(int i=0;i<drivers.size();i++) 
		{
			if(drivers.get(i).username.equals(y))
					return i;
		}
		return -1;
	}
	
	public ArrayList<Driver> deleteTrip(int index,String ID,ArrayList<Driver> drivers)
	{
		//ObservableList<Driver> allDrivers;
		Driver tempDriver = new Driver();
		ArrayList<Driver> tempDrivers = new ArrayList<Driver>(drivers);
		tempDriver=drivers.get(index);
		for(int i=0;i<tempDriver.driverTrips.size();i++)
		{
			if(tempDriver.driverTrips.get(i).equals(ID))
			{
					tempDriver.driverTrips.remove(i);
			}
		}
		tempDrivers.add(index, tempDriver);
		//allDrivers = FXCollections.observableArrayList(tempDrivers);
		return tempDrivers;
	}
	
	public ArrayList<Driver> addTrip(int index,String ID,ArrayList<Driver> drivers)
	{
		Driver tempDriver = new Driver();
		//ObservableList<Driver> allDrivers;
		ArrayList<Driver> tempDrivers = new ArrayList<Driver>(drivers);
		String s=ID;
		tempDriver=tempDrivers.get(index);
		tempDriver.driverTrips.add(s);
		tempDrivers.add(tempDriver);
		//allDrivers = FXCollections.observableArrayList(tempDrivers);
		return tempDrivers;
	}
	
	
	public String getUsername() {
		return this.username;
	}
	
}

