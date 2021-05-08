import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Trips {
	String available,price;
	String type, vehicle, source, dest,time, date, direction, max, stops;
	String driver,trip;
	public String getAvailable() {
		return this.available;
	}
	public String getTrip() {
		return this.trip;
	}
	public String getStops() {
		return this.stops;
	}
	public String getType() {
		return this.type;
	}
	public String getSource() {
		return this.source;
	}
	public String getDest() {
		return this.dest;
	}
	public String getTime() {
		return this.time;
	}
	public String getDate() {
		return this.date;
	}
	public String getDirection() {
		return this.direction;
	}
	public String getVehicle() {
		return this.vehicle;
	}	
	public String getDriver() {
		return this.driver;
	}
	
	public String getPrice() {
		return this.price;
	}
	
	static ArrayList<String> triplist=new ArrayList<>();
    public ArrayList<String> loadfileline() throws IOException {
        FileReader in = new FileReader("trips.txt");
        BufferedReader br = new BufferedReader(in);
        String trip=null;
        while (br.readLine()!= null) {
             trip = br.readLine();
           triplist.add(trip);
        }
        in.close();
       return triplist;
    }
	
}
