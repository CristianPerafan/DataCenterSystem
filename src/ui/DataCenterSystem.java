package ui;
import java.util.Scanner;
import model.ServerBuilding;

public class DataCenterSystem{

    //Relationships
	private ServerBuilding building;
	private Scanner sc;


    //Constructor method
    /**
     * Description: this is the method to create a DataCenterSystem
     */
	public DataCenterSystem(){
		building = new ServerBuilding();
		sc = new Scanner(System.in);
	}
    
    //Name: main method
    //Type: void
	public static void main(String [] args){
		DataCenterSystem pc = new DataCenterSystem();

		System.out.println("Starting the APP....");
		
		int optionMenu = 0;

		do{
			optionMenu = pc.showMenu();
			pc.executeOperation(optionMenu);
		}while(optionMenu != 0);
	}

	//Name: showMenu
    //Type: int
    /**
        * Description: this is the method to show the main menu of the system.
        * @return out int, it represents the menu option that the user wants to use.
        */
	public int showMenu(){
		int optionMenu = 0;

		System.out.println(
			    "***** MAIN MENU *****\n"+
			    "(1) Check available mini rooms\n"+
			    "(2) Find the information of a mini room\n"+
			    "(3) Rent a mini room\n"+
			    "(4) Cancel a rental\n"+
			    "(5) Show a map of the data center\n"+
			    "(6) Simulate turning the rooms ON\n"+
			    "(0) Exit"
			    );
		optionMenu= sc.nextInt();
		sc.nextLine();


		return optionMenu;
	}


	//Name: executeOperation
    //Type: void
    /** 
        * Description: This is the method to execute the option that the system user wants to use.
        * @param optionMenu int, it represents the menu option that the user wants to use.
        */
	public void executeOperation(int optionMenu){
		switch(optionMenu){
		case 0:
		    System.out.println("Bye, see you soon");
		    break;
		case 1:
		    checkAvailableRooms();
		    break;
		case 2:
		    findMiniroomInformation();
		    break;
		case 3:
		    rentAMiniRoom();
		    break;
		case 4: 
		    showMenuCancelARental();
		    break;
		case 5:
		    showMapOfTheDataCenter();
		    break;
		case 6: 
		    showMenuTurnOnAndOff();
		    break;
	    default:
	    	System.out.println("Invalid option!!!");
		}
	}


	//Name: showMenuCancelARental
    //Type: void
    /** 
        * Description: This is the method to show the cancel rental menu
        */
	public void showMenuCancelARental(){

		int optionMenuCancel = 0;

		System.out.println(
			    "***** CANCEL A RENTAL MENU *****\n"+
			    "(1) Cancel the rental for a mini room\n"+
			    "(2) Cancel the rental of all the mini rooms of a company\n"+
			    "(0) Back"
			    );

		optionMenuCancel= sc.nextInt();
		sc.nextLine();

		switch(optionMenuCancel){
		case 0:
		    break;
		case 1:
		    cancelRentalOfAMiniRoom();
		    break;
		case 2:
		    cancelRentalOfCompany();
		    break;
		default:
		    System.out.println("Invalid option!!!");
		}
	}


	//Name: showMenuTurnOnAndOff
    //Type: void
    /** 
        * Description: This is the method to show the simulator menu.
        */
	public void showMenuTurnOnAndOff(){
		String answerTurn;

        System.out.println("Simulating the turning on of all mini rooms.....\n");

        System.out.println("                                   /// MAP OF THE DATA CENTER///");
        System.out.println("O : mini rooms turned ON");
        System.out.println("F : mini rooms turned OFF");


		System.out.println(building.turnOnAllMiniRooms());

		System.out.println(

			"*** SIMULATOR MENU ***\n"+

			"(L) Turn OFF all mini rooms\n"+

			"(Z) Turn OFF the mini rooms of the first "+ 
			"and last corridor together with the mini rooms of the reverse diagonal\n"+

			"(H) Turn OFF mini rooms located in odd corridors\n"+

			"(O) Turn off mini rooms located next to windows\n"+

			"(M) Turn off all mini-rooms in a column\n"+

			"(P) Turn off all mini rooms in a corridor"
		);

		answerTurn = sc.nextLine().toUpperCase();

		if(answerTurn.equals("L")){
			System.out.println("                                   /// MAP OF THE DATA CENTER///");
            System.out.println("O : mini rooms turned ON");
            System.out.println("F : mini rooms turned OFF");
			System.out.println(building.turnOffAllMiniRooms());
		}
		else if(answerTurn.equals("Z")){
			System.out.println("                                   /// MAP OF THE DATA CENTER///");
            System.out.println("O : mini rooms turned ON");
            System.out.println("F : mini rooms turned OFF");
			System.out.println(building.turnOffFirsLastAndReverseCorridor());
		}
		else if(answerTurn.equals("H")){
			System.out.println("                                   /// MAP OF THE DATA CENTER///");
            System.out.println("O : mini rooms turned ON");
            System.out.println("F : mini rooms turned OFF");
			System.out.println(building.turnOffOddCorridors());
		}
		else if(answerTurn.equals("O")){
			System.out.println("                                   /// MAP OF THE DATA CENTER///");
            System.out.println("O : mini rooms turned ON");
            System.out.println("F : mini rooms turned OFF");
            System.out.println(building.turnOffMiniRoomsNextToAWindow());
		}
		else if(answerTurn.equals("M")){
			int column = 1;
			boolean condition = false;

			System.out.println("Please, enter the column number you want to turn off:");

			while(condition == false){
				column = sc.nextInt();
			    sc.nextLine();

			    if(column >= 1 && column<=50){
			    	condition = true;
			    }
			    else{
			    	System.out.println("No valid option,re-enter the column number !!!");
			    }

			}

			column = column-1;

			System.out.println("                                   /// MAP OF THE DATA CENTER///");
            System.out.println("O : mini rooms turned ON");
            System.out.println("F : mini rooms turned OFF");
            System.out.println(building.turnOffColumn(column));

		}
		else if(answerTurn.equals("P")){
			int corridor = 0;
			boolean condition = false;

			System.out.println("Please, enter the corridor number you want to turn off:");

			while(condition == false){
				corridor = sc.nextInt();
			    sc.nextLine();

			    if(corridor >= 1 && corridor<=8){
			    	condition = true;
			    }
			    else{
			    	System.out.println("No valid option,re-enter the corridor number !!!");
			    }

			}

			corridor = corridor-1;

			System.out.println("                                   /// MAP OF THE DATA CENTER///");
            System.out.println("O : mini rooms turned ON");
            System.out.println("F : mini rooms turned OFF");
            System.out.println(building.turnOffCorridor(corridor));



		}
		else{
			System.out.println("No valid option!!!");
		}
	}

	//Name: checkAvailableRooms
    //Type: void
    /** 
        * Description: This is the method to show the available mini rooms
        */
	private void checkAvailableRooms(){
		System.out.println("/// AVAILABLE MINI ROOMS ///");
		System.out.println(building.lookForAvailableMiniRooms());
	}


	//Name: findMiniroomInformation
    //Type: void
    /** 
        * Description: this is the method to consult the information of a mini room.
        */
	private void findMiniroomInformation(){
		int column,corridor;
		System.out.println("/// FIND MINI ROOM INFORMATION ///");
		System.out.println("Please, enter the num of the hall: ");
		corridor = sc.nextInt();
		corridor = corridor-1;
		sc.nextLine();
		System.out.println("Enter the num of column: ");
		column = sc.nextInt();
		column = column-1;
		sc.nextLine();
         
        System.out.println(building.findMiniRoomInformation(corridor,column));
	}


	//Name: rentAMiniRoom
    //Type: void
    /** 
        * Description: this is the method to rent a mini room.
        */
	private void  rentAMiniRoom(){

		
		int corridor,column,day,month,year, numServers;
        String nit,companyName,answer;
        String projectRegistrationNum = "";

	    System.out.println("/// RENT A MINI ROOM ///");
	    System.out.println("Please, enter the mini room corridor number: ");
	    corridor = sc.nextInt();
	    corridor = corridor-1;
	    sc.nextLine();
	    System.out.println("Please, enter the mini room column number: ");
	    column = sc.nextInt();
	    column = column-1;
	    sc.nextLine();

	    if(building.verifyHallAndColumnCorrectly(corridor,column)){
	    	System.out.println("Yes");
	    	if(building.veryfyIfTheMiniRoomIsRented(corridor,column)){
	    		System.out.println("The mini room is not available to be rented");
	    	}
	    	else{
	    		System.out.println("Please, enter the rental date...");
	    		System.out.println("Day: ");
	    		day = sc.nextInt();
	    		sc.nextLine();
	    		System.out.println("Month: ");
	    		month = sc.nextInt();
	    		sc.nextLine();
	    		System.out.println("Year: ");
	    		year = sc.nextInt();
	    		sc.nextLine();
	    		
	    		System.out.println("Do you want to rent a mini room for a investigation project?"+
	    	     " yes or not");
	    		answer = sc.nextLine().toUpperCase();



	    		if(answer.equals("YES")){

	    			companyName = "Universidad Icesi";
	    			nit = "890.316.745-5";

	    			System.out.println("Enter the project registration number:");
	    		    projectRegistrationNum = sc.nextLine();

	    		    System.out.println("/// ADD SERVERS ///");
		            System.out.println("Please, enter the number of servers you want to use: ");
		            numServers = sc.nextInt();
		            sc.nextLine();

		            building.addTheRentalOfAMiniRoomInvestigation(nit,companyName,day,month,year,
	    		    	corridor,column, projectRegistrationNum,numServers);

		            
		            double cacheMemory,ramMemory,diskCapacity;
		            int amountProcessors,amountDisks,optionPro;

		       

		            for(int i = 0;i<numServers;i++){

		            	System.out.println("*** SERVER "+(i+1)+" ***");
		            	System.out.println("Enter the server cache memory (GB): ");
		            	cacheMemory = sc.nextDouble();
		            	sc.nextLine();

		            	System.out.println("Enter the number of processors: ");
		            	amountProcessors = sc.nextInt();
		            	sc.nextLine();

		            	System.out.println("Enter the number corresponding to the processor brand:\n"+
                            "(1) AMD\n"+
                            "(2) INTEL"
		            		);

		            	optionPro = sc.nextInt();
		            	sc.nextLine();

		            	while(optionPro<1 || optionPro>2){
		            		System.out.println("Invalid option, re-enter the corresponding number"+
		            			" to the processor brand");
		            		optionPro = sc.nextInt();
		            	    sc.nextLine();
		            	}

		            	System.out.println("Enter the server RAM(GB): ");
		            	ramMemory = sc.nextDouble();
		            	sc.nextLine();

		            	System.out.println("Enter the number of disks on the server: ");
		            	amountDisks = sc.nextInt();
		            	sc.nextLine();

		            	System.out.println("Enter the capacity of the disks (TB): ");
		            	diskCapacity = sc.nextDouble();
		            	sc.nextLine();

		            	building.AddServerToAMiniRoom(corridor,column,cacheMemory,amountProcessors,
		            		ramMemory,amountDisks, diskCapacity,optionPro);
		            }





	    		    System.out.println("The mini room has been rented succesfully!!!");
	    		}
	    		else if(answer.equals("NOT")){
	    		    System.out.println("Enter the name of the company: ");
	    		    companyName = sc.nextLine();
	    		    System.out.println("Enter the nit of the company: ");
	    		    nit = sc.nextLine();

	    		    System.out.println("/// ADD SERVERS ///");
		            System.out.println("Please, enter the number of servers you want to use;");
		            numServers = sc.nextInt();
		            sc.nextLine();

	    		    building.addTheRentalOfAMiniRoomCompany(nit,companyName,day,
	    		    	month,year,corridor, column, numServers);


	    		    double cacheMemory,ramMemory,diskCapacity;
		            int amountProcessors,amountDisks,optionPro;

		            for(int i = 0;i<numServers;i++){

		            	System.out.println("*** SERVER "+(i+1)+" ***");
		            	System.out.println("Enter the server cache memory (GB): ");
		            	cacheMemory = sc.nextDouble();
		            	sc.nextLine();

		            	System.out.println("Enter the number of processors: ");
		            	amountProcessors = sc.nextInt();
		            	sc.nextLine();

		            	System.out.println("Enter the number corresponding to the processor brand:\n"+
                            "(1) AMD\n"+
                            "(2) INTEL"
		            		);

		            	
		            	optionPro = sc.nextInt();
		            	sc.nextLine();

		            	while(optionPro<1 || optionPro>2){
		            		System.out.println("Invalid option, re-enter the corresponding number"+
		            			" to the processor brand");
		            		optionPro = sc.nextInt();
		            	    sc.nextLine();
		            	}


		            	System.out.println("Enter the server RAM(GB): ");
		            	ramMemory = sc.nextDouble();
		            	sc.nextLine();

		            	System.out.println("Enter the number of disks on the server: ");
		            	amountDisks = sc.nextInt();
		            	sc.nextLine();

		            	System.out.println("Enter the capacity of the disks (TB): ");
		            	diskCapacity = sc.nextDouble();
		            	sc.nextLine();

		            	building.AddServerToAMiniRoom(corridor,column,cacheMemory,amountProcessors,
		            		ramMemory,amountDisks, diskCapacity,optionPro);
		            }



	    		    System.out.println("The mini room has been rented succesfully!!!");
	    		   

	    		}
	    		else{
	    			System.out.println("Invalid option, you must enter (yes or not)!!!");
	    		}
	    	}
	    }
	    else{
	    	System.out.println("Invalid column or corridor number!!!");
	    }
	}

	//Name: cancelRentalOfAMiniRoom
    //Type: void
    /** 
        * Description: this is the method to cancel the rental of a mini room.
        */
	private void cancelRentalOfAMiniRoom(){
		
		int corridor,column;
		String answer;

		System.out.println("/// CANCEL THE RENTA FOR A MINI ROOM ///");
		
		System.out.println("Please, enter the corridor number of the mini room: ");
		corridor = sc.nextInt();
		corridor = corridor-1;
		sc.nextLine();

		System.out.println("Please, enter the column number of the mini room: ");
		column = sc.nextInt();
		column = column-1;
		sc.nextLine();

		if(building.verifyHallAndColumnCorrectly(corridor,column)){
			if(building.veryfyIfTheMiniRoomIsRented(corridor,column)){
				System.out.println(building.capacityInformationOfServers(corridor,column));
				System.out.println("Are you sure you want to cancel the rental? yes or not" );
				answer = sc.nextLine().toUpperCase();

				if(answer.equals("YES")){
					building.cancelARental(corridor,column);
					System.out.println("The rental has been successfully canceled!!!");


				}
				else{
					System.out.println("Ok...");
				}

			}
			else{
			    System.out.println("The mini room is not rented!!!");
			}
			
		}
		else{
			System.out.println("Invalid option, you must enter the row and column number again!!!");
		}
	}

	//Name: cancelRentalOfCompany
    //Type: void
    /** 
        * Description: this is the method to cancel the rental of all the mini rooms of a company.
        */
	private void cancelRentalOfCompany(){
		String companyName,answer;

	    System.out.println("/// CANCEL THE RENTAL OF ALL THE MINI ROOMS OF A COMPANY ///");
	    System.out.println("Please, enter the name of the company: ");
	    companyName = sc.nextLine();

	    if(building.thereIsAtLeastOneMiniRoomOfACompany(companyName)){
	    	System.out.println(building.showTheRentalOfACompany(companyName));
	    	System.out.println("Are you sure you want to cancel all "+companyName+" rentals? yes or not");
	    	answer = sc.nextLine().toUpperCase();

	    	if(answer.equals("YES")){
	    		building.cancelTheRentalOfACompany(companyName);
	    		System.out.println("The company rentals have been canceled");
	    	}
	    	else{
	    		System.out.println("Ok...");

	    	}



	    }
	    else{
	    	System.out.println("The company does not have any rented mini rooms!!!");
	    }
	}

	//Name: showMapOfTheDataCenter
    //Type: void
    /** 
        * Description: this is the method to show the map of the data center,with the 
        mini-rooms on and off
        */

	private void showMapOfTheDataCenter(){
        System.out.println("                                   /// MAP OF THE DATA CENTER///");
        System.out.println("O : mini rooms turned ON");
        System.out.println("F : mini rooms turned OFF");
        System.out.println(building.mapOfTheDataCenterSystem());
	}

}