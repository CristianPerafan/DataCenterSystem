package model;
import java.util.ArrayList;
import java.util.Iterator;


public class ServerBuilding{
    
  //Discount percentage for having a window in the mini room
  private final static double WINDOW_DISCOUNT = 10;
     
  //Discount percentage for the mini room being located in the 7th hall
  private final static double SEVEN_DISCOUNT = 15;

  //Surcharge percentage for the mini room being located in 2n-6th hall
  private final static double LOCATED_SURCHARGE = 25;

  //Surcharge percentaje for using less than 4 servers
  private final static double SERVER_SURCHARGE = 15;


  //Relationships
	private MiniRoom miniRooms [][];


  //Constructor method
  /**
    * Description: this is the constructor method to create a server building.
    */
  public ServerBuilding(){
    miniRooms = new MiniRoom[8][50];
    initializeMiniRooms();
  }

  //Name: initializeServers
  //Type: void
  /**
    * Description: this is the method to initialize all the servers
    */
  public void initializeMiniRooms(){
    	
    int identifier = 1;
    int corridor = 1;
    int column;
    boolean window = false;

    for(int i = 0; i<miniRooms.length;i++){

    	for(int j = 0; j<miniRooms[0].length;j++){

        if(i == 0){
         window = true;
        }

        if(i == (miniRooms.length-1) ){
          window = true;
        }

        if(j == 0){
          window = true;
        }

        if(j == (miniRooms[0].length-1)){
           window = true;
        }

        column = j;
    		miniRooms[i][j] = new MiniRoom(identifier,corridor,window,column);

    		identifier++;
        window = false;
    	}

    	corridor++;	
    }
  }


  //Name: lookForAvailableMiniRooms
  //Type: String
  /**
    * Description: this is the method to concatenate the information of all the
     available mini rooms
    * @return out String, it represents the information of all the available mini rooms
    */
  public String lookForAvailableMiniRooms(){
    String out = "";
    int contador = 1;

    for(int i = 0; i<miniRooms.length;i++){
    	for(int j = 0; j<miniRooms[0].length;j++){
    		if(miniRooms[i][j].getAvailable() == Available.AVAILABLE){
    			out += "*** AVAILABLE ROOM # "+contador+" ***\n";
    			out += miniRooms[i][j].toStringCheck()+"\n";
    			contador++;
    		}
    	}
    }

    return out;
  }

  
  //Name: verifyHallAndColumnCorrectly
  //Type: boolean
  /**
    * Description: this is the method to verify that the corridor and column number entered
    by the user are correct.
    * @param corridor int, it represents the corridor number of the mini room
    * @param column int, it represents the column number of the mini room
    * @return out boolean, if out = true the corridor and column number entered by the user are 
    correct else the corridor or column are not correct.
    */
  public boolean verifyHallAndColumnCorrectly(int corridor, int column){

    boolean out = true;

    if(corridor > miniRooms.length || corridor < 0 || column>miniRooms[0].length || column<0){
      out = false;  
    }

    return out;
  }


  //Name: veryfyIfTheMiniRoomIsRented
  //Type: boolean
  /**
    * Description: this is the method to verify if a mini room is rented
    * @param corridor int, it represents the corridor number of the mini room
    * @param column int, it represents the column number of the mini room
    * @return out boolean, if out = true the mini room is rented else the 
    mini room is not rented.
    */
  public boolean veryfyIfTheMiniRoomIsRented(int corridor, int column){
    boolean out = false;

    if(miniRooms[corridor][column].getAvailable() == Available.NOTAVAILABLE){
      out = true;
    }

    return out;
  }


  //Name: findMiniRoomInformation
  //Type: String
  /**
    * Description: this is the method to find the infortmation of a mini room
    * @param corridor int, it represents the corridor number of the mini room
    * @param column int, it represents the column number of the mini room
    * @return out String, it represents the information of the mini room or a message
    when the corridor or column number are not correct.
    */
  public String findMiniRoomInformation(int corridor, int column){
    String out = "\n";

    if(corridor > miniRooms.length || corridor < 0 || column>miniRooms[0].length || column<0){
      System.out.println("Invalid option, you must enter the row and column number again!!!");
    }
    else{
      out += "*** MINI ROOM INFORMATION ***\n";
      out += miniRooms[corridor][column].toString();
    }

    return out;
  }


  //Name: addTheRentalOfAMiniRoomCompany
  //Type: void
  /**
    * Description: this is the method to rent a mini room to a Company
    * @param nit String, 
    * @param companyName String,
    * @param day int,it represents the day when the mini room was rented
    * @param month int,it represents the month when the mini room was rented
    * @param year int,it represents the year when the mini room was rented
    * @param corridor int, it represents the corridor number of the mini room
    * @param column int, it represents the column number of the mini room
    * @param numServers int,it represents the number of servers that the company wants to rent
    */
  public void addTheRentalOfAMiniRoomCompany(String nit, String companyName, int day, int month,
    int year, int corridor, int column, int numServers){
    
    miniRooms[corridor][column].addCompany(nit, companyName,day,month,year,numServers); 

    double newPrice = miniRooms[corridor][column].getPrice();
    double windowDiscount =  calculateMiniRoomWindowDiscount(corridor,column);
    double sevenDiscount = calculateMiniRoomSevenHallDiscount(corridor,column);
    double surchargeSecondAndSix = calculateMiniRoomSurcharge(corridor,column);
    double serverSurcharge = calculateSurchargeForServers(corridor,column,numServers);

    newPrice = (((newPrice-windowDiscount)-sevenDiscount)+(surchargeSecondAndSix+serverSurcharge));

    miniRooms[corridor][column].setPrice(newPrice);      
  }


  //Name: addTheRentalOfAMiniRoomInvestigation
  //Type: void
  /**
    * Description: this is the method to rent a mini room to a investigation project
    * @param nit String, 
    * @param companyName String,
    * @param day int,it represents the day when the mini room was rented
    * @param month int,it represents the month when the mini room was rented
    * @param year int,it represents the year when the mini room was rented
    * @param corridor int, it represents the corridor number of the mini room
    * @param column int, it represents the column number of the mini room
    * @param projectRegistrationNum String,it represents the project registration number
    * @param numServers int,it represents the number of servers that the company wants to rent
    */
  public void addTheRentalOfAMiniRoomInvestigation(String nit, String companyName, int day, 
    int month,int year, int corridor, int column, String projectRegistrationNum, int numServers){

    miniRooms[corridor][column].addInvestigationProject(nit, companyName,day,month,year,
      projectRegistrationNum,numServers);

        
    double newPrice = miniRooms[corridor][column].getPrice();
    double windowDiscount =  calculateMiniRoomWindowDiscount(corridor,column);
    double sevenDiscount = calculateMiniRoomSevenHallDiscount(corridor,column);
    double surchargeSecondAndSix = calculateMiniRoomSurcharge(corridor,column);
    double serverSurcharge = calculateSurchargeForServers(corridor,column,numServers);

    newPrice = (((newPrice-windowDiscount)-sevenDiscount)+(surchargeSecondAndSix+serverSurcharge));

    miniRooms[corridor][column].setPrice(newPrice);
  }


  //Name: calculateMiniRoomWindowDiscount
  //Type: double
  /**
    * Description: this is the method to calculate the discount if the 
    server is located next to a window.
    * @param corridor int,
    * @param column int,
    * @return out double it represents the discount if the mini room the 
    mini room is next to a window, else out = 0.
    */
  public double calculateMiniRoomWindowDiscount(int corridor, int column){
       
    double discount;
    double out = 0;

    if(miniRooms[corridor][column].getWindow() == true){
            
      discount = miniRooms[corridor][column].getPrice();

      out = (discount*(WINDOW_DISCOUNT/100));      
    }

    return out;
  }


  //Name: calculateMiniRoomSevenHallDiscount
  //Type: double
   /**
    * Description: this is the method to calculate the discount if the server is 
    located on the seventh corridor.
    * @param corridor int,
    * @param column int,
    * @return out double, it represents the discount if the mini room is located
    on the seventh corridor.
    */  
  public double calculateMiniRoomSevenHallDiscount(int corridor, int column){
    double price;
    double out = 0;

    if(miniRooms[corridor][column]. getCorridor() == 7){
      price= miniRooms[corridor][column].getPrice();

      out = (price*(SEVEN_DISCOUNT/100));
    }

    return out;
  }


  //Name: calculateMiniRoomSurcharge
  //Type: double
  /**
    * Description: this is the method to calculate the surcharge if the mini room
    is located betweeb the second and seventh corridor.
    * @param corridor int,
    * @param column int,
    * @return surcharge int, it represents the surcharge if the mini room is located
    between the second and seventh corridor, esle surcharge = 0
    */
  public double calculateMiniRoomSurcharge(int corridor, int column){
    double price;
    double surcharge = 0;

    if(miniRooms[corridor][column]. getCorridor() >= 2 && 
      miniRooms[corridor][column]. getCorridor() <= 6){
      price = miniRooms[corridor][column].getPrice();
      surcharge = (price*(LOCATED_SURCHARGE/100));
    }
    return surcharge;
  }


  //Name: calculateSurchargeForServers
  //Type: double
    /**
    * Description: this is the method to calculate the surcharge if the company 
    rents less than 4 servers.
    * @param corridor int,
    * @param column int,
    * @param numServers int, it represents the number of servers fo the mini room.
    * @return surcharge int, it represents the surcharge if the company rents less
    than 4 serves, else surcharge = 0.
    */
  public double calculateSurchargeForServers(int corridor, int column, int numServers){
    double surcharge = 0;
    double price;

    if(numServers<4){
      price = miniRooms[corridor][column].getPrice();
      surcharge = (price*(SERVER_SURCHARGE/100));
    }

    return surcharge;
  }


  //Name: AddServerToAMiniRoom
  //Type: void
  /**
    * Description: this is the method to add a server to a mini room.
    * @param corridor int,
    * @param column int,
    * @param cacheMemory double,
    * @param amountProcessors int,
    * @param ramMemory double,
    * @param amountDisks int,
    * @param diskCapacity double,
    * @param optionPro int, it represents the brand of the processor, if optionPro = 1 , the
    brand of the processor is AMD, if optionPro = 2, th brand of the processor is INTEL.
    */
  public void AddServerToAMiniRoom(int corridor,int column,double cacheMemory, int amountProcessors, 
    double ramMemory,int amountDisks, double diskCapacity, int optionPro){
        
    miniRooms[corridor][column].addRack(cacheMemory,amountProcessors,ramMemory,amountDisks,
      diskCapacity,optionPro);    
  }


  //Name: capacityInformationOfServers
  //Type: String
  /**
    * Description: this is the method to calculate the capacity information of the servers
    in a mini room.
    * @param corridor int,
    * @param column int,
    * @return out String, it contains the capacity information of the servers of a mini room.
    */
  public String capacityInformationOfServers(int corridor, int column){
    String out = "";

    out += "*** TOTAL SERVER CAPACITY***\n";
    out += "Disk capacity: "+miniRooms[corridor][column].calculateDiskCapacityOfServers()+" TB\n";
    out += "RAM capacity; "+miniRooms[corridor][column].calculateRamCapacityOfServers()+" GB\n";

    return out;
  }


  //Name: cancelARental
  //Type: void
  /**
    * Description: this is the method to cancel the rental of a mini room.
    * @param corridor int, it represents the corridor number of the mini room of the mini 
    room for which the rent will be canceled.
    * @param column int, it represents the column number of the mini room of the mini room
    for which the rent will be canceled.
    */
  public void cancelARental(int corridor, int column){
    miniRooms[corridor][column].cancelARentalOfAMiniRoom();
  }


  //Name: thereIsAtLeastOneMiniRoomOfACompany
  //Type: boolean
  /**
    * Description: this is the method to verify if the company has at least one mini room 
    rented,
    * @param companyName String,
    * @return out boolean, if out = true the company has at least one mini room rented else
    the company does not have any mini room rented.
    */
  public boolean thereIsAtLeastOneMiniRoomOfACompany(String companyName){
    boolean out = false;

    for(int i = 0; i<miniRooms.length;i++){
      for(int j= 0;j<miniRooms[0].length;j++){
          if(miniRooms[i][j].getCompany() != null){
              if(miniRooms[i][j].getCompanyName().equals(companyName)){
                out = true;
              }
          }
      }
    }

    return out;
  }


  //Name: showTheRentalOfACompany
  //Type: String
  /**
    * Description: this is the method to concatenate the rental information of a company.
    * @param companyName String,
    * @return out String, it contains all the information of the rental of a company
    */
  public String showTheRentalOfACompany(String companyName){
    double diskCapacity = 0;
    double ramCapacity = 0;

    String out = "*** MINI ROOMS RENTED BY THE COMPANY ***\n";
    out += " \n";
    int accountant = 0;

    for(int i = 0;i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){
        if(miniRooms[i][j].getCompany() != null){
          if(miniRooms[i][j].getCompanyName().equals(companyName)){
            accountant ++;
            out += "// Mini room "+accountant+" //\n";
            out += "Number of servers: "+miniRooms[i][j].calculateServerAmount()+"\n";
            out += "Hall: "+(i+1)+"  Column: "+(j+1)+"\n";
            out += " \n";

            diskCapacity += miniRooms[i][j].calculateDiskCapacityOfServers();
            ramCapacity += miniRooms[i][j].calculateRamCapacityOfServers();
          }
        }       
      }
    }

    out += "*** TOTAL SERVER CAPACITY***\n";
    out += "Disk capacity: "+diskCapacity+" TB\n";
    out += "Ram capacity: "+ramCapacity+" GB\n";

    return out;
  }

  //Name:cancelTheRentalOfACompany
  //Type: void
  /**
    * Description: this is the method to cancel the rental of all the mini rooms rented
    by a company.
    * @param companyName String,
    */
  public void cancelTheRentalOfACompany(String companyName){
    for(int i = 0; i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){
        if(miniRooms[i][j].getCompany() != null){
          if(miniRooms[i][j].getCompanyName().equals(companyName)){
            miniRooms[i][j].cancelARentalOfAMiniRoom();
          }
        }
      }
    }
  }


  //Name: mapOfTheDataCenterSystem
  //Type: String
  /**
    * Description: this is the method to create the map of the data center.
    * @return out String, it contains the map of the data center.
    */
  public String mapOfTheDataCenterSystem(){
    String out = "\n";

    for(int i =0;i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){

        if(miniRooms[i][j].getState() == State.ON){
          out += "|"+"O";
        }

        if(miniRooms[i][j].getState() == State.OFF){
          out += "|"+"F";
        }
      }

      out +="|\n";
      out += "                                            CORRIDOR "+(i+1)+"\n";
    }

    return out;
  }


  //Name: turnOnAllMiniRooms
  //Type: String
  /**
    * Description: this is the method to turn on all the mini rooms and create the new
    map of the data center with the changes.
    * @return out String, it contains the new map of the data center.
    */
  public String turnOnAllMiniRooms(){
    String out = "\n";

    for(int i = 0;i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){
        miniRooms[i][j].turnOn();
      }
    }

    for(int i = 0;i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){

        if(miniRooms[i][j].getState() == State.ON){
          out += "|"+"O";
        }

        if(miniRooms[i][j].getState() == State.OFF){
          out += "|"+"F";
        }
      }
      out +="|\n";
      out += "                                            CORRIDOR "+(i+1)+"\n";
    }

    return out;
  }


  //Name: turnOffAllMiniRooms
  //Type: String
  /**
    * Description: this is the method to turn off all the mini rooms and create the new
    map of the data center with the changes.
    * @return out String, it contains the new map of the data center.
    */
  public String turnOffAllMiniRooms(){
    String out = "\n";

    for(int i = 0;i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){
        miniRooms[i][j].turnOff();
      }
    }

    out += showSimulatingChanges();
    fixSimulatingChanges();

    return out;
  }


  //Name: turnOffFirsLastAndReverseCorridor
  //Type: String
  /**
    * Description: this is the method to turn off the mini rooms located int the first and 
    last corridor, also in this method the new map whith the changes will be created.
    * @return out String, it contains the new map of the data center.
    */
  public String turnOffFirsLastAndReverseCorridor(){
    String out = "\n";
    int reverse = 6;
    boolean stopReverse = false;

    for(int i = 0;i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){

        if(i == 0){
          miniRooms[i][j].turnOff();
        }

        if(i == (miniRooms.length-1)){
          miniRooms[i][j].turnOff();
          stopReverse = true;
        }

        if(stopReverse == false){
          miniRooms[i][reverse].turnOff();
        }
      }
      reverse = reverse+6;
    }

    out += showSimulatingChanges();
    fixSimulatingChanges();

    return out;
  }

  //Name: turnOffOddCorridors
  //Type: String
    /**
    * Description: this is the method to turn off the mini rooms located in odd corridors,
    also in this method the new map whith the changes will be created.
    * @return out String, it contains the new map of the data center.
    */
  public String turnOffOddCorridors(){
    String out = "\n";
    for(int i = 0;i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){
        if((i+1)%2 != 0){
           miniRooms[i][j].turnOff();
        }         
      }
    }

    out += showSimulatingChanges();
    fixSimulatingChanges();

    return out;
  }


  //Name: turnOffMiniRoomsNextToAWindow
  //Type: String
    /**
    * Description: this is the method to turn off the mini rooms located next to a window.
    also in this method the new map whith the changes will be created.
    * @return out String, it contains the new map of the data center.
    */
  public String turnOffMiniRoomsNextToAWindow(){
    String out = "\n";

    for(int i = 0;i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){
        if(miniRooms[i][j].getWindow() == true){
          miniRooms[i][j].turnOff();
        }
      }
    }

    out += showSimulatingChanges();
    fixSimulatingChanges();

    return out;
  }


  //Name: turnOffColumn
  //Type: String
  /**
    * Description: this is the method to turn off all the mini rooms in a column,
    also in this method the new map whith the changes will be created.
    * @param column int, it represent the column that the user want to turn off.
    * @return out String, it contains the new map of the data center.
    */
  public String turnOffColumn(int column){
    String out = "\n";

    for(int i = 0;i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){
        if(miniRooms[i][j].getColumn() == column){
          miniRooms[i][j].turnOff();
        }
      }
    }

    out += showSimulatingChanges();
    fixSimulatingChanges();

    return out;
  }


  //Name: turnOffCorridor
  //Type: String
  /**
    * Description: this is the method to turn off all the mini rooms in a corridor,
    also in this method the new map whith the changes will be created. 
    * @param corridor int, it represent the corridor number that the user want to turn off.
    * @return out String, it contains the new map of the data center.
    */
   
  public String turnOffCorridor(int corridor){
    String out = "\n";

    for(int i = 0;i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){
        if(i == corridor){
          miniRooms[i][j].turnOff();
        }
      }
    }

    out += showSimulatingChanges();
    fixSimulatingChanges();

    return out;
  }


  //Name: fixSimulatingChanges
  //Type: void
  /**
    * Description: this is the method to fix the changes made by the simulations
    */
  public void fixSimulatingChanges(){
    for(int i = 0;i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){
        if(miniRooms[i][j].getCompany() != null){
          miniRooms[i][j].turnOn();
        }
        if(miniRooms[i][j].getCompany() == null){
          miniRooms[i][j].turnOff();
        }
      }
    }
  }

  //Name: showSimulatingChanges
  //Type: String
  /**
    * Description: this is the method to concatenate the new information of the simulations.
    @return out String, it represents the new map with the changes of the simulation.
    */

  public String showSimulatingChanges(){

    String out = "\n";

    for(int i = 0;i<miniRooms.length;i++){
      for(int j = 0;j<miniRooms[0].length;j++){

        if(miniRooms[i][j].getState() == State.ON){
          out += "|"+"O";
        }
        if(miniRooms[i][j].getState() == State.OFF){
          out += "|"+"F";
        }
      }

      out +="|\n";
      out += "                                            CORRIDOR "+(i+1)+"\n";
    }

    return out;
  }
}


