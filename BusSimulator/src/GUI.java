import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.BackgroundFill;
//import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class BusApp2 extends Application 
{
	Stage window;
	Scene scene1, scene2,scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10,scene11,
	scene12,scene13,scene14,scene15,scene16,scene17;
	
	Manager manager = new Manager();
	Driver driver = new Driver();
	Customers customer = new Customers();
	
	ArrayList<Trips> temp2;
	ArrayList<Driver> temp1;
	ArrayList<Trips> temp3;
	ArrayList<Trips> temp5;
	ArrayList<Customers> temp4;
	
	ObservableList<Trips> allTrips;
	ObservableList<Driver> allDrivers;
	ObservableList<Trips> driverTrips;
	ObservableList<Trips> customerTrips;
	
	int index;

	public static void main(String[] args)throws FileNotFoundException {
		launch(args);
	}
	
	
	TableView<Trips> table;
	
	
	@Override
	@SuppressWarnings("unchecked")
	public void start(Stage primaryStage) throws Exception
	{
		window=primaryStage;
		window.setTitle("Bus Application");
		
		manager.loadDrivers();
		temp1 = new ArrayList<Driver>(manager.viewDrivers());
		
		manager.loadTrips();
		temp2 = new ArrayList<Trips>(manager.viewTrips());
		
		customer.loadCustomers();
		temp4=customer.viewCustomers();
		
		System.out.println(temp4.get(0).customerTrips.get(0));
		
		Text title = new Text("Please select type of user");
		title.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		title.setUnderline(true);
		RadioButton rb1 = new RadioButton();
		rb1.setText("Passenger");
		RadioButton rb2 = new RadioButton();
		rb2.setText("Driver");
		RadioButton rb3 = new RadioButton();
		rb3.setText("Manager");
		
		GridPane grid1 = new GridPane();
		grid1.add(rb1, 3, 2);
		grid1.add(rb2, 3, 3);
		grid1.add(rb3, 3, 4);
		grid1.add(title, 3, 1);
		grid1.setHgap(30);
		grid1.setVgap(30);
		grid1.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
		
		scene1 = new Scene(grid1,350,350);
		
		Label driverUser = new Label("Enter username: ");
		TextField driverText = new TextField();
		Label driverPass = new Label("Enter password: ");
		PasswordField password = new PasswordField();
		Button confirm1 = new Button("Confirm");
		Button back1 = new Button("Back");
		Label error1 = new Label();
		
		GridPane grid2 = new GridPane();
		grid2.add(driverUser, 1, 1);
		grid2.add(driverText, 2, 1);
		grid2.add(driverPass, 1, 2);
		grid2.add(password, 2, 2);
		grid2.add(confirm1, 2, 3);
		grid2.add(back1, 1, 3);
		grid2.add(error1, 1, 4);
		grid2.setHgap(30);
		grid2.setVgap(30);
		grid2.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
		
		scene2 = new Scene(grid2,600,250);
		
		Label managerUser = new Label("Enter username: ");
		TextField managerText = new TextField();
		Label managerPass = new Label("Enter password: ");
		PasswordField managerP = new PasswordField();
		Button confirm2 = new Button("Confirm");
		Button back2 = new Button("Back");
		Label error2 = new Label();
		
		GridPane grid3 = new GridPane();
		grid3.add(managerUser, 1, 1);
		grid3.add(managerText, 2, 1);
		grid3.add(managerPass, 1, 2);
		grid3.add(managerP, 2, 2);
		grid3.add(confirm2, 2, 3);
		grid3.add(back2, 1, 3);
		grid3.add(error2, 1, 4);
		grid3.setHgap(30);
		grid3.setVgap(30);
		grid3.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
		
		scene3 = new Scene(grid3,600,250);
		
		Label customerUser = new Label("Enter username: ");
		TextField customerText = new TextField();
		Label customerPass = new Label("Enter password: ");
		PasswordField customerP = new PasswordField();
		Button confirm3 = new Button("Confirm");
		Button back3 = new Button("Back");
		Label error3 = new Label();
		
		GridPane grid4 = new GridPane();
		grid4.add(customerUser, 1, 1);
		grid4.add(customerText, 2, 1);
		grid4.add(customerPass, 1, 2);
		grid4.add(customerP, 2, 2);
		grid4.add(confirm3, 2, 3);
		grid4.add(back3, 1, 3);
		grid4.add(error3, 1, 4);
		grid4.setHgap(30);
		grid4.setVgap(30);
		grid4.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
		
		scene4 = new Scene(grid4,600,250);
		
		Text welcomeDriver = new Text();
		welcomeDriver.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		welcomeDriver.setUnderline(true);
		Button viewDTrips = new Button("View Trips");
		Button back4 = new Button("Back");
		
		GridPane grid5 = new GridPane();
		grid5.add(welcomeDriver, 3, 1);
		grid5.add(back4, 1, 4);
		grid5.add(viewDTrips, 5, 4);
		grid5.setHgap(30);
		grid5.setVgap(30);
		grid5.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
		
		scene5 = new Scene(grid5,500,350);
		
		Text welcomeManager= new Text();
		welcomeManager.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		welcomeManager.setUnderline(true);
		Button viewTrips1 = new Button("View All Trips");
		Button viewDrivers = new Button("View All Drivers");
		Button back5 = new Button("Back");
		Button save4 = new Button("Save");
		
		GridPane grid6 = new GridPane();
		grid6.add(welcomeManager, 3, 1);
		grid6.add(back5, 1, 2);
		grid6.add(viewTrips1, 5, 2);
		grid6.add(viewDrivers, 5, 3);
		grid6.add(save4, 1, 3);
		grid6.setHgap(30);
		grid6.setVgap(30);
		grid6.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
		
		scene6 = new Scene(grid6,500,350);
		
		Text welcomeCustomer = new Text();
		welcomeCustomer.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		welcomeCustomer.setUnderline(true);
		Button viewCTrips = new Button("View Trips");
		Button back11 = new Button("Back");
		Button reserve = new Button("Reserve Ticket");
		Button cancel = new Button("Cancel Trip");
		
		GridPane grid9 = new GridPane();
		grid9.add(welcomeCustomer, 3, 1);
		grid9.add(back11, 4, 3);
		grid9.add(viewCTrips, 3, 3);
		grid9.add(reserve, 3, 4);
		grid9.add(cancel, 4, 4);
		grid9.setHgap(30);
		grid9.setVgap(30);
		grid9.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
		
		scene12 = new Scene(grid9,500,350);
		
		TableView<Trips> table1 = new TableView<Trips>();
		allTrips = FXCollections.observableArrayList(temp2);

		
		TableColumn<Trips,String> vehicleColumn = new TableColumn<>("Vehicle Type");
		vehicleColumn.setMinWidth(50);
		vehicleColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("vehicle"));
		
		TableColumn<Trips,String> sourceColumn = new TableColumn<>("Source");
		sourceColumn.setMinWidth(50);
		sourceColumn.setCellValueFactory(new PropertyValueFactory<>("source"));
		
		TableColumn<Trips,String> destColumn = new TableColumn<>("Destination");
		destColumn.setMinWidth(50);
		destColumn.setCellValueFactory(new PropertyValueFactory<>("dest"));
		
		TableColumn<Trips,String> dateColumn = new TableColumn<>("Date");
		dateColumn.setMinWidth(50);
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		TableColumn<Trips,String> timeColumn = new TableColumn<>("Time");
		timeColumn.setMinWidth(50);
		timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
		
		TableColumn<Trips,String> directionColumn = new TableColumn<>("Direction");
		directionColumn.setMinWidth(50);
		directionColumn.setCellValueFactory(new PropertyValueFactory<>("direction"));
		
		TableColumn<Trips,String> noOfStopsColumn = new TableColumn<>("Number of Stops");
		noOfStopsColumn.setMinWidth(50);
		noOfStopsColumn.setCellValueFactory(new PropertyValueFactory<>("stops"));
		
		TableColumn<Trips,String> availableColumn = new TableColumn<>("Available Seats");
		availableColumn.setMinWidth(50);
		availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
		
		TableColumn<Trips,Double> priceColumn = new TableColumn<>("Ticket Price");
		priceColumn.setMinWidth(50);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<Trips,Double> tripColumn = new TableColumn<>("Trip No.");
		tripColumn.setMinWidth(50);
		tripColumn.setCellValueFactory(new PropertyValueFactory<>("trip"));
		
		
		table1.setItems(allTrips);
		table1.getColumns().addAll(tripColumn,vehicleColumn,sourceColumn,destColumn,
				dateColumn,timeColumn,directionColumn,noOfStopsColumn,availableColumn,priceColumn);
		table1.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        Button addNewTrip = new Button("Add Trip");
        Button deleteTrip = new Button("Delete Trip");
        Button editTrip = new Button("Assign Driver");
        Button back6 = new Button("Back");
        Button save2 = new Button("Save");
        VBox v1 = new VBox(10);
        v1.setPadding(new Insets(20, 20, 20, 20));
        GridPane grid14 = new GridPane();
        grid14.add(addNewTrip,1,1);
        grid14.add(deleteTrip,2,1);
        grid14.add(editTrip,3,1);
        grid14.add(back6,1,2);
        grid14.add(save2,3,2);
        grid14.setHgap(15);
		grid14.setVgap(15);
        v1.getChildren().addAll(table1, grid14);
        v1.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
        
        scene7 = new Scene(v1,900,500);
		
		Label tripno = new Label("Enter Trip Number: ");
		TextField tripno1 = new TextField();
		Label vehicle = new Label("Enter Vehicle Type(Bus/Mini Bus/Car): ");
		TextField vehicle1 = new TextField();
		Label type = new Label("Enter Trip Type(External/Internal): ");
		TextField type1 = new TextField();
		Label source = new Label("Enter Source of Trip: ");
		TextField source1 = new TextField();
		Label dest = new Label("Enter Destination of Trip: ");
		TextField dest1 = new TextField();
		Label date = new Label("Enter Date of Trip: ");
		TextField date1 = new TextField();
		Label time = new Label("Enter Time of Trip: ");
		TextField time1 = new TextField();
		Label direction = new Label("Enter Direction of Trip: ");
		TextField direction1 = new TextField();
		Label stops = new Label("Enter Number of Stops: ");
		TextField stops1 = new TextField();
		Label seats = new Label("Enter Number of Seats Available: ");
		TextField seats1 = new TextField();
		Label driver0 = new Label("Enter Name of Driver: ");
		TextField driver1 = new TextField();
		Label price = new Label("Enter Ticket Price: ");
		TextField price1 = new TextField();
		Button confirm4 = new Button("Confirm");
		Button back7 = new Button("Back");
        Button save1 = new Button("Save");
		
		GridPane grid7 = new GridPane();
		grid7.add(tripno, 1, 1);
		grid7.add(vehicle, 1, 2);
		grid7.add(type, 1, 3);
		grid7.add(source, 1, 4);
		grid7.add(dest, 1, 5);
		grid7.add(date, 1, 6);
		grid7.add(time, 1, 7);
		grid7.add(direction, 1, 8);
		grid7.add(stops, 1, 9);
		grid7.add(seats, 1, 10);
		grid7.add(driver0, 1, 11);
		grid7.add(price, 1, 12);
		grid7.add(back7, 1, 13);
		grid7.add(tripno1, 2, 1);
		grid7.add(vehicle1, 2, 2);
		grid7.add(type1, 2, 3);
		grid7.add(source1, 2, 4);
		grid7.add(dest1, 2, 5);
		grid7.add(date1, 2, 6);
		grid7.add(time1, 2, 7);
		grid7.add(direction1, 2, 8);
		grid7.add(stops1, 2, 9);
		grid7.add(seats1, 2, 10);
		grid7.add(driver1, 2, 11);
		grid7.add(price1, 2, 12);
		grid7.add(confirm4, 2, 13);
		grid7.add(save1, 2, 14);
		grid7.setHgap(30);
		grid7.setVgap(30);
		grid7.setHgap(30);
		grid7.setVgap(30);
		grid7.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
		
		scene8 = new Scene(grid7,800,900);
		
		Text deleting = new Text("Deleting Existing Trip");
		deleting.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		deleting.setUnderline(true);
		Label labelx = new Label("Enter Number of Trip: ");
		TextField textx = new TextField();
		Button confirm5 = new Button("Confirm");
		Button back9 = new Button("Back");
		
		GridPane grid8 = new GridPane();
		grid8.add(deleting, 1, 1);
		grid8.add(labelx, 1, 2);
		grid8.add(textx, 2, 2);
		grid8.add(back9, 1, 3);
		grid8.add(confirm5, 2, 3);
		grid8.setHgap(30);
		grid8.setVgap(30);
		grid8.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
		
		scene9 = new Scene(grid8,700,300);
		
		TableView<Driver> table2 = new TableView<Driver>();
		allDrivers = FXCollections.observableArrayList(temp1);
		
		TableColumn<Driver,String> driverColumn = new TableColumn<>("Driver Name");
		driverColumn.setMinWidth(50);
		driverColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("username"));
        
		table2.setItems(allDrivers);
		table2.getColumns().addAll(driverColumn);
		table2.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		Button back8 = new Button("Back");
		VBox v2 = new VBox(10);
        v2.setPadding(new Insets(20, 20, 20, 20));
        v2.getChildren().addAll(table2, back8);
        v2.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
        
        scene10 = new Scene(v2,400,400);
        
        TableView<Trips> table3 = new TableView<Trips>();
		
		TableColumn<Trips,String> vehicleColumn1 = new TableColumn<>("Vehicle Type");
		vehicleColumn1.setMinWidth(50);
		vehicleColumn1.setCellValueFactory(new PropertyValueFactory<Trips,String>("vehicle"));
		
		TableColumn<Trips,String> sourceColumn1 = new TableColumn<>("Source");
		sourceColumn1.setMinWidth(50);
		sourceColumn1.setCellValueFactory(new PropertyValueFactory<>("source"));
		
		TableColumn<Trips,String> destColumn1 = new TableColumn<>("Destination");
		destColumn1.setMinWidth(50);
		destColumn1.setCellValueFactory(new PropertyValueFactory<>("dest"));
		
		TableColumn<Trips,String> dateColumn1 = new TableColumn<>("Date");
		dateColumn1.setMinWidth(50);
		dateColumn1.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		TableColumn<Trips,String> timeColumn1 = new TableColumn<>("Time");
		timeColumn1.setMinWidth(50);
		timeColumn1.setCellValueFactory(new PropertyValueFactory<>("time"));
		
		TableColumn<Trips,String> directionColumn1 = new TableColumn<>("Direction");
		directionColumn1.setMinWidth(50);
		directionColumn1.setCellValueFactory(new PropertyValueFactory<>("direction"));
		
		TableColumn<Trips,String> noOfStopsColumn1 = new TableColumn<>("Number of Stops");
		noOfStopsColumn1.setMinWidth(50);
		noOfStopsColumn1.setCellValueFactory(new PropertyValueFactory<>("stops"));
		
		TableColumn<Trips,String> availableColumn1 = new TableColumn<>("Available Seats");
		availableColumn1.setMinWidth(50);
		availableColumn1.setCellValueFactory(new PropertyValueFactory<>("available"));
		
		TableColumn<Trips,Double> priceColumn1 = new TableColumn<>("Ticket Price");
		priceColumn1.setMinWidth(50);
		priceColumn1.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<Trips,Double> tripColumn1 = new TableColumn<>("Trip No.");
		tripColumn1.setMinWidth(50);
		tripColumn1.setCellValueFactory(new PropertyValueFactory<>("trip"));
		
		table3.setItems(driverTrips);
		table3.getColumns().addAll(tripColumn1,vehicleColumn1,sourceColumn1,destColumn1,dateColumn1,timeColumn1,directionColumn1,noOfStopsColumn1,availableColumn1,priceColumn1);
		table3.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        Button back10 = new Button("Back");
        VBox v3 = new VBox(10);
        v3.setPadding(new Insets(20, 20, 20, 20));
        v3.getChildren().addAll(table3,back10);
        v3.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
        
        scene11 = new Scene(v3,800,400);
        
        TableView<Trips> table4 = new TableView<Trips>();
		
		TableColumn<Trips,String> vehicleColumn2 = new TableColumn<>("Vehicle Type");
		vehicleColumn2.setMinWidth(50);
		vehicleColumn2.setCellValueFactory(new PropertyValueFactory<Trips,String>("vehicle"));
		
		TableColumn<Trips,String> sourceColumn2 = new TableColumn<>("Source");
		sourceColumn2.setMinWidth(50);
		sourceColumn2.setCellValueFactory(new PropertyValueFactory<>("source"));
		
		TableColumn<Trips,String> destColumn2 = new TableColumn<>("Destination");
		destColumn2.setMinWidth(50);
		destColumn2.setCellValueFactory(new PropertyValueFactory<>("dest"));
		
		TableColumn<Trips,String> dateColumn2 = new TableColumn<>("Date");
		dateColumn2.setMinWidth(50);
		dateColumn2.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		TableColumn<Trips,String> timeColumn2 = new TableColumn<>("Time");
		timeColumn2.setMinWidth(50);
		timeColumn2.setCellValueFactory(new PropertyValueFactory<>("time"));
		
		TableColumn<Trips,String> directionColumn2 = new TableColumn<>("Direction");
		directionColumn2.setMinWidth(50);
		directionColumn2.setCellValueFactory(new PropertyValueFactory<>("direction"));
		
		TableColumn<Trips,String> noOfStopsColumn2 = new TableColumn<>("Number of Stops");
		noOfStopsColumn2.setMinWidth(50);
		noOfStopsColumn2.setCellValueFactory(new PropertyValueFactory<>("stops"));
		
		TableColumn<Trips,String> availableColumn2 = new TableColumn<>("Available Seats");
		availableColumn2.setMinWidth(50);
		availableColumn2.setCellValueFactory(new PropertyValueFactory<>("available"));
		
		TableColumn<Trips,Double> priceColumn2 = new TableColumn<>("Ticket Price");
		priceColumn2.setMinWidth(50);
		priceColumn2.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<Trips,Double> tripColumn2 = new TableColumn<>("Trip No.");
		tripColumn2.setMinWidth(50);
		tripColumn2.setCellValueFactory(new PropertyValueFactory<>("trip"));
		
		table4.setItems(customerTrips);
		table4.getColumns().addAll(tripColumn2,vehicleColumn2,sourceColumn2,destColumn2,dateColumn2,timeColumn2,directionColumn2,noOfStopsColumn2,availableColumn2,priceColumn2);
		table4.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        Button back12 = new Button("Back");
        VBox v4 = new VBox(10);
        v4.setPadding(new Insets(20, 20, 20, 20));
        v4.getChildren().addAll(table4,back12);
        v4.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
        
        scene13 = new Scene(v4,500,500);
        
        TableView<Trips> table5 = new TableView<Trips>();
		
		TableColumn<Trips,String> vehicleColumn3 = new TableColumn<>("Vehicle Type");
		vehicleColumn3.setMinWidth(50);
		vehicleColumn3.setCellValueFactory(new PropertyValueFactory<Trips,String>("vehicle"));
		
		TableColumn<Trips,String> sourceColumn3 = new TableColumn<>("Source");
		sourceColumn3.setMinWidth(50);
		sourceColumn3.setCellValueFactory(new PropertyValueFactory<>("source"));
		
		TableColumn<Trips,String> destColumn3 = new TableColumn<>("Destination");
		destColumn3.setMinWidth(50);
		destColumn3.setCellValueFactory(new PropertyValueFactory<>("dest"));
		
		TableColumn<Trips,String> dateColumn3 = new TableColumn<>("Date");
		dateColumn3.setMinWidth(50);
		dateColumn3.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		TableColumn<Trips,String> timeColumn3 = new TableColumn<>("Time");
		timeColumn2.setMinWidth(50);
		timeColumn2.setCellValueFactory(new PropertyValueFactory<>("time"));
		
		TableColumn<Trips,String> directionColumn3 = new TableColumn<>("Direction");
		directionColumn3.setMinWidth(50);
		directionColumn3.setCellValueFactory(new PropertyValueFactory<>("direction"));
		
		TableColumn<Trips,String> noOfStopsColumn3 = new TableColumn<>("Number of Stops");
		noOfStopsColumn3.setMinWidth(50);
		noOfStopsColumn3.setCellValueFactory(new PropertyValueFactory<>("stops"));
		
		TableColumn<Trips,String> availableColumn3 = new TableColumn<>("Available Seats");
		availableColumn3.setMinWidth(50);
		availableColumn3.setCellValueFactory(new PropertyValueFactory<>("available"));
		
		TableColumn<Trips,Double> priceColumn3 = new TableColumn<>("Ticket Price");
		priceColumn3.setMinWidth(50);
		priceColumn3.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<Trips,Double> tripColumn3 = new TableColumn<>("Trip No.");
		tripColumn3.setMinWidth(50);
		tripColumn3.setCellValueFactory(new PropertyValueFactory<>("trip"));
		
		table5.setItems(allTrips);
		table5.getColumns().addAll(tripColumn3,vehicleColumn3,sourceColumn3,destColumn3,dateColumn3,timeColumn3,directionColumn3,noOfStopsColumn3,availableColumn3,priceColumn3);
		table5.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        Button back13 = new Button("Back");
        Label enterTrip = new Label("Enter ID of Trip: ");
        TextField enteredTrip = new TextField();
        Label confirmation = new Label();
        Button confirm6 = new Button("Confirm");
        VBox v5 = new VBox(10);
        v5.setPadding(new Insets(20, 20, 20, 20));
        GridPane grid10 = new GridPane();
        grid10.add(confirm6, 1, 3);
        grid10.add(back13, 1, 4);
        grid10.add(enterTrip, 1, 1);
        grid10.add(enteredTrip, 2, 1);
        grid10.add(confirmation, 2, 3);
        v5.getChildren().addAll(table5,grid10);
        v5.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
        
        scene14 = new Scene(v5,500,500);
        
        Text assign = new Text("Assigning New Driver For Trip");
        assign.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		assign.setUnderline(true);
        Label enterName = new Label("Enter Name of Current Driver: ");
        TextField enteredName = new TextField();
        Label enterName2 = new Label("Enter Name of New Driver: ");
        TextField enteredName2 = new TextField();
        Button back14 = new Button("Back");
        Button confirm7 = new Button("Confirm");
        Label enterNo = new Label("Enter No. of Trip: ");
        TextField enteredNo = new TextField();
        
        GridPane grid16 = new GridPane();
        grid16.add(assign, 1, 1);
        grid16.add(enterName, 1, 3);
        grid16.add(enteredName, 2, 3);
        grid16.add(enterName2, 1, 4);
        grid16.add(enteredName2, 2, 4);
        grid16.add(back14, 1, 5);
        grid16.add(confirm7, 2, 5);
        grid16.add(enterNo, 1, 2);
        grid16.add(enteredNo, 2, 2);
        grid16.setHgap(30);
		grid16.setVgap(30);
        grid16.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,Insets.EMPTY)));
        
        scene16 = new Scene(grid16,650,350);
        
        Text canceltrip = new Text("Cancel Trip");
        Label enterID = new Label("Enter No. of Trip: ");
        TextField enteredID = new TextField();
        Button confirm8 = new Button("Confirm");
        Button back15 = new Button("Back");
        
        GridPane grid17 = new GridPane();
        grid17.add(canceltrip, 1, 1);
        grid17.add(enterID, 1, 2);
        grid17.add(enteredID, 2, 2);
        grid17.add(back15, 1, 3);
        grid17.add(confirm8, 2, 3);
        
        scene17=new Scene(grid17,450,350);
		
		window.setScene(scene1);
		rb1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene4);
			}
		
	});
		
		rb2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene2);
			}
		
	});
		
		rb3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene3);
			}
		
	});
		
		back1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene1);
			}
		
	});

		back2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene1);
			}
		
	});
		back3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene1);
			}
		
	});
		
		confirm1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String s1=driverText.getText();
				String s2=password.getText();
				index=driver.searchDrivers(temp1, s1);
				if(driver.validateDriver(temp1,s1,s2))
					{
						welcomeDriver.setText("Welcome " + s1);
						window.setScene(scene5);
					}
				else
				{
					driverText.setText(null);
					password.setText(null);
					error1.setText("Please re-enter your username and password");
					
				}
					
			}
		
	});
		
		back4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene2);
			}
		
	});
		
		confirm2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String s3=managerText.getText();
				String s4=managerP.getText();
				if(manager.validateUser(s3, s4))
				{	
					welcomeManager.setText("Welcome " + s3);
					window.setScene(scene6);
				}
				else
				{
					error2.setText("Please re-enter your username and pasword");
				}
			}
		
	});
		viewDTrips.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				temp3=driver.viewTrips(temp2, index, temp1);
				driverTrips = FXCollections.observableArrayList(temp3);
				table3.setItems(driverTrips);
				window.setScene(scene11);
			}
		
	});
		
		back5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene3);
			}
		
	});
		
		confirm3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String s1=customerText.getText();
				String s2=customerP.getText();
				index=customer.searchCustomers(temp4, s1);
				if(customer.validateCustomer(temp4, s1, s2))
				{
					welcomeCustomer.setText("Welcome " + s1);
					window.setScene(scene12);
				}
				else {
					error3.setText("Please re-enter your username and password");
				}
					
	            } });

		
		viewTrips1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene7);
			}
		
	});
		back6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene6);
			}
		
	});
		viewDrivers.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene10);
			}
		
	});
		
		addNewTrip.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene8);
			}
		
	});
		
		confirm4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String s1=tripno1.getText();
				String s2=vehicle1.getText();
				String s3=type1.getText();
				String s4=source1.getText();
				String s5=dest1.getText();
				String s6=date1.getText();
				String s7=time1.getText();
				String s8=direction1.getText();
				String s9=stops1.getText();
				String s10=seats1.getText();
				String s11=driver1.getText();
				String s13=price1.getText();
				temp2=manager.addNewTrip(temp2, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s13);
				allTrips=FXCollections.observableArrayList(temp2);
				table1.setItems(allTrips);
				index=driver.searchDrivers(temp1, s11);
				temp1=driver.addTrip(index, s1, temp1);
				allDrivers=FXCollections.observableArrayList(temp1);
				table2.setItems(allDrivers);
				
			}
		
	});
		
		back7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene6);
			}
		
	});
		back8.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene6);
			}
		
	});
		back9.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene6);
			}
		
	});
		
		deleteTrip.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene9);
			}
		
	});
		
		back10.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene5);
			}
			
		});
		back10.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene4);
			}
			
		});
		
		back12.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene12);
			}
		
	});
		
		back13.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene12);
			}
		
	});
		back14.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene6);
			}
		
	});
		
		back15.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene12);
			}
		
	});
		
		viewCTrips.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				temp5=customer.viewTrips(temp2, index, temp4);
				customerTrips = FXCollections.observableArrayList(temp5);
				table4.setItems(customerTrips);
				window.setScene(scene13);
			}
		
	});
		save1.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event){
				try {
					manager.saveTrips(temp2);
					//manager.saveDrivers(temp1);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	});
		save2.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event){
				try {
					manager.saveTrips(temp2);
					//manager.saveDrivers(temp1);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	});
		
		confirm5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String s=textx.getText();
				int num=manager.searchTrips(temp2, s);
				temp2=manager.removeTrip(num, temp2);
				allTrips=FXCollections.observableArrayList(temp2);
				table1.setItems(allTrips);
				int num2=driver.searchDrivers(temp1, temp1.get(num).username);
				temp1=driver.deleteTrip(num2, s, temp1);
				allDrivers=FXCollections.observableArrayList(temp1);
				table2.setItems(allDrivers);
			}
		
	});
		
		reserve.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				allTrips=FXCollections.observableArrayList(temp2);
				table5.setItems(allTrips);
				window.setScene(scene14);
			}
		
	});
		
		save4.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event){
				try {
					manager.saveTrips(temp2);
					//manager.saveDrivers(temp1);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	});
		
		confirm6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String s=enteredTrip.getText();
				int num=manager.searchTrips(temp2, s);
				if(customer.checkSeats(index, temp2))
				{
					temp2=customer.reserveTicket(num, temp2);
					//System.out.println(temp2.get(num));
					temp4=customer.addTrip(index, s, temp4);
					//temp5=customer.viewTrips(temp2, index, temp4);
					//customerTrips = FXCollections.observableArrayList(temp5);
					//table4.setItems(customerTrips);
					allTrips=FXCollections.observableArrayList(temp2);
					//table1.setItems(allTrips);
					//table5.setItems(allTrips);
					confirmation.setText("Trip No."+s+" Confirmed");
				}
				else {
					confirmation.setText("No Seats Available");
				}
			}
		
	});
		
		editTrip.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene16);
			}
		
	});
		

		confirm7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String s=enteredName.getText();
				String s2=enteredName2.getText();
				String s3=enteredNo.getText();
				//int num=manager.searchTrips(temp2, s3);
				int num2=driver.searchDrivers(temp1, s);
				temp1=driver.deleteTrip(num2, s3, temp1);
				allDrivers=FXCollections.observableArrayList(temp1);
				table2.setItems(allDrivers);
				int num3=driver.searchDrivers(temp1, s2);
				temp1=driver.addTrip(num3, s3, temp1);
				allDrivers=FXCollections.observableArrayList(temp1);
				table2.setItems(allDrivers);
			}
		
	});
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene17);
				
			}
		
	});
		
		confirm8.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String s=enteredID.getText();
				temp4=customer.deleteTrip(index, s, temp4);
				
				
			}
		
	});
		
		window.show();

}}
