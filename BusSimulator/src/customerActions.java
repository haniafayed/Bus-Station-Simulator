import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface customerActions {

		public ArrayList<Customers> addTrip(int index,String ID,ArrayList<Customers> customers);
		
		public ArrayList<Customers> deleteTrip(int index,String ID,ArrayList<Customers> customers);
		
		public ArrayList<Trips> reserveTicket(int index,ArrayList<Trips> trips);
		
		public boolean checkSeats (int index,ArrayList<Trips> trips);
		
		public int searchCustomers (ArrayList<Customers> customers,String y);
		
		public ArrayList<Trips> viewTrips(ArrayList<Trips> trips,int index,ArrayList<Customers> customers);
		
		public ArrayList<Customers> viewCustomers ();
		
		public void loadCustomers() throws FileNotFoundException;

	}

