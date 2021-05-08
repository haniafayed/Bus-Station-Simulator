import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customers extends Validation implements customerActions {
	String username;
	String password;
	ArrayList<String> customerTrips = new ArrayList<String>();
	
	ArrayList<Customers> customers = new ArrayList<Customers>();
	
	public void loadCustomers() throws FileNotFoundException
	{
		File file = new File("Customers.txt");
		Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) 
        {
        	String s;
            String line = scan.nextLine();
            String[] lineArray = line.split(",");
            Customers tempCust = new Customers();
            tempCust.username=lineArray[0];
            tempCust.password=lineArray[1];
            for(int i=2;i<lineArray.length;i++) 
            {
            	s=lineArray[i];
            	tempCust.customerTrips.add(i-2, s);
            }
            customers.add(tempCust);
        }
        scan.close();
	}
	
	public ArrayList<Customers> viewCustomers (){
		return customers;
	}

	public boolean validateCustomer(ArrayList<Customers> customers,String username,String password)
	{
		boolean flag=false;
		for(int i =0;i<customers.size();i++)
		{
			if(customers.get(i).username.equals(username) && customers.get(i).password.equals(password))
				flag=true;
		}
		return flag;
	}
	
	public ArrayList<Trips> viewTrips(ArrayList<Trips> trips,int index,ArrayList<Customers> customers) 
	{
		Customers tempCust = new Customers();
		ArrayList<Trips> tempList = new ArrayList<Trips>();
		tempCust=customers.get(index);
		ArrayList<String> x = new ArrayList<String>();
		x=tempCust.customerTrips;
		for(int i=0;i<x.size();i++)
		{
			for(int j=0;j<trips.size();j++)
			{
				if(trips.get(j).trip.equals(x.get(i)))
					tempList.add(trips.get(j));
			}
		}
		return tempList;
	}
	
	public int searchCustomers (ArrayList<Customers> customers,String y)
	{
		for(int i=0;i<customers.size();i++) 
		{
			if(customers.get(i).username.equals(y))
					return i;
		}
		return -1;
	}
	
	public boolean checkSeats (int index,ArrayList<Trips> trips)
	{
		boolean flag=false;
		String s=trips.get(index).available;
		int num=Integer.parseInt(s);
		if(num>0)
			flag=true;
		return flag;
			
	}
	
	public ArrayList<Trips> reserveTicket(int index,ArrayList<Trips> trips)
	{
		Trips tempTrip= new Trips();
		tempTrip=trips.get(index);
		String s=tempTrip.available;
		int num=Integer.parseInt(s);
		num--;
		s=Integer.toString(num);
		tempTrip.available=s;
		trips.add(index, tempTrip);
		return trips;
	}
	
	public ArrayList<Customers> deleteTrip(int index,String ID,ArrayList<Customers> customers)
	{
		Customers tempCust = new Customers();
		tempCust=customers.get(index);
		for(int i=0;i<tempCust.customerTrips.size();i++)
		{
			if(tempCust.customerTrips.get(i).equals(ID))
			{
					tempCust.customerTrips.remove(i);
			}
		}
		customers.add(index, tempCust);
		return customers;
	}
	
	public ArrayList<Customers> addTrip(int index,String ID,ArrayList<Customers> customers)
	{
		Customers tempCust = new Customers();
		String s=ID;
		tempCust=customers.get(index);
		tempCust.customerTrips.add(s);
		customers.add(tempCust);
		return customers;
	}
}
