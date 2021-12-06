package model;

public class MiniRoom{

	//Base price for renting a mini room
	private final static double BASE_PRICE = 5000000;

	//Attributes
	private int identifier;
	private double price;
	private int corridor;
  private boolean window;
  private int column;

	//RelationShips
	private Company company; 
	private Available available;
	private State state;
  private Rack rack;


  //Constructor method
  /**
    * Description: this is the constructor method to create a mini room.
    * @param identifier int,
    * @param corridor int,
    * @param window boolean,  
    * @param column int , 
    */

  public MiniRoom(int identifier,int corridor, boolean window, int column){

    this.identifier = identifier;
    price = BASE_PRICE;
    this.corridor = corridor;
    this.window = window;
    this.column = column;
    available = Available.AVAILABLE;
    state = State.OFF;

  }

  //GETTERS
  public int getIdentifier(){
    return identifier;
  }
  public double getPrice(){
    return price;
  }
  public int getCorridor(){
    return corridor;
  }
  public boolean getWindow(){
    return window;
  }
  public Company getCompany(){
    return company;
  }
  public Available getAvailable(){
    return available;
  }
  public State getState(){
    return state;
  }
  public int getColumn(){
    return column;
  }

  //SETTERS
  public void setIdentifier(int identifier){
    this.identifier = identifier;
  }
  public void setPrice(double price){
   	this.price = price;
  }
  public void setHall(int corridor){
  	this.corridor = corridor;
  }

  public void turnOn(){
    state = State.ON;
  }
  public void turnOff(){
    state = State.OFF;
  }

  //Name: addCompany
  //Type: void
  /**
    * Description: this is the method to rent a mini room to a Company
    * @param nit String,
    * @param companyName String,
    * @param day int, represents the day when the mini room was rented
    * @param month int, represents the month when the mini room was rented
    * @param year int, represents the year when the mini room was rented
    * @param numServers int, represents the number of servers that the company wants to rent
    */
  public void addCompany(String nit, String companyName, int day, int month, int year,
    int numServers){
      
    company = new Company(nit,companyName,day,month,year);
    available = Available.NOTAVAILABLE;
    state = State.ON;
    rack = new Rack(numServers);
  }


  //Name: addInvestigationProject
  //Type: void
  /**
    * Description: this is the method to rent a mini room to a investigation project
    * @param nit String,
    * @param companyName String,
    * @param day int, represents the day when the mini room was rented
    * @param month int, represents the month when the mini room was rented
    * @param year int, represents the year when the mini room was rented
    * @param projectRegistrationNum String, it represents the project registration number
    * @param numServers int, it represents the number of servers that the company wants to rent
    */
  public void addInvestigationProject(String nit, String companyName, int day, int month, int year,
    String projectRegistrationNum, int numServers){

    company = new InvestigationProject(nit,companyName,projectRegistrationNum,day,month,year);
    available = Available.NOTAVAILABLE;
    state = State.ON;
    rack = new Rack(numServers);
  }


  //Name: addRack
  //Type: void
  /**
    * Description: this is the method to add a rack to a mini room
    * @param cacheMemory double,
    * @param amountProcessors int,
    * @param ramMemory double,
    * @param amountDisks int,
    * @param diskCapacity double, 
    * @param optionPro int, it represents the brand of the processor, if optionPro = 1 , the
    brand of the processor is AMD, if optionPro = 2, th brand of the processor is INTEL.
    */

  public void addRack(double cacheMemory, int amountProcessors, double ramMemory, int amountDisks,
    double diskCapacity, int optionPro){

    rack.addAServer(cacheMemory,amountProcessors,ramMemory,amountDisks,
      diskCapacity,optionPro);

  }


  //Name: calculateDiskCapacityOfServers
  //Type: double
  /**
    * Description: this is the method to calculate the total disk capacity of all servers 
    in a mini room.
    * @return out double, it represents the total disk capacity of all servers 
    in a mini room.(TB)
    */
    public double calculateDiskCapacityOfServers(){
      double out;

      out = rack.calculateDiskCapacity();
        
      return out;
    }


  //Name:  calculateRamCapacityOfServers
  //Type: double
  /**
    * Description: this is the method to calculate the total RAM capacity of all servers 
    in a mini room.
    * @return out double, it represents the total disk capacity of all servers 
    in a mini room. (gb)
    */
  public double calculateRamCapacityOfServers(){
    double out;

        
    out = rack.calculateRamCapacity();
        
        
    return out;
  }


  //Name:  cancelARentalOfAMiniRoom
  //Type: void
  /**
    * Description: This is the method to modify the attributes of the mini 
    room when the user wants to cancel a rental.
    */
  public void cancelARentalOfAMiniRoom(){
    state = State.OFF;
    available = Available.AVAILABLE;
    company = null;
    rack = null;
  }

  //Name: getCompanyName
  //Type: String
  /**
    * Description: this is the method to obtain the name of the company that rents the 
    mini room.
    @return out String, it contains the name of the company that rents the 
    mini room.
    */
  public String getCompanyName(){
    String out = company.getCompanyName();
    return out;
  }


  //Name: calculateServerAmount
  //Type: int
  /**
    * Description: this is the method to calculate the number of servers that the mini
    room has.
    @return out int, it contains the number of servers that the mini
    room has. 
    */
  public int calculateServerAmount(){

    int out = rack.calculateAmountOfServers();
        
    return out;
  }



  //Name: toStringCheck
  //Type: String
  /**
    * Description: this is the method to show the attributes of the miniRoom
    that is needed in the option show list of available mini rooms.
    * @return out String, this the informatión needen int the list of available
    mini rooms
    */
  public String toStringCheck(){
    String out = "";
    out += "Identifier: "+identifier+"\n";
    out += "Corridor: "+corridor+"\n";
    out += "column: "+column+"\n";
    out += "Window: "+window+"\n";  
    out += "Price: "+price+"\n";

    return out;

  }

  //Name: toString
  //Type: String
  /**
    * Description: this is the method to show the attributes of the miniRoom
    * @return out String, it represents all the information of the mini room
    */
  public String toString(){
    String out = "";

    out += "Identifier : "+identifier+"\n";
    out += "Corridor : "+corridor+"\n";
    out += "column : "+(column+1)+"\n";
    out += "Price : "+price+"\n";
    out += "Avalaible : " + available+"\n";

    if(window == true){
      out += "Window : YES\n";
    }
    else{
      out += "Window : NOT\n";
    }
        
    out += "State : "+state+"\n";
    	 
    if(company != null){
    	if(company instanceof InvestigationProject){
    		out += ((InvestigationProject)company).toString()+"\n";
    	}
    	else{
    		out += company.toString()+"\n";
    	}
    }

    if(rack != null){
      out += rack.toString()+"\n";
    }

    return out;
  }
}