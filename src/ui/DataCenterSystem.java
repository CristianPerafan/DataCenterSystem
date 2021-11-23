package ui;
import java.util.Scanner;
import model.ServerBuilding;

public class DataCenterSystem{

    //Attributes
	private ServerBuilding building;
	private Scanner sc;

	public DataCenterSystem(){
		sc = new Scanner(System.in);
	}

	public static void main(String [] args){
		DataCenterSystem pc = new DataCenterSystem();

		System.out.println("Starting the APP....");
		
		int optionMenu = 0;

		do{
			optionMenu = pc.showMenu();
			pc.executeOperation(optionMenu);
		}while(optionMenu != 0);
	}

	public int showMenu(){
		int optionMenu = 0;

		System.out.println(
			    "***** MAIN MENU *****\n"+
			    "1) Create a rent\n"+
			    "0) Exit"
			    );
		optionMenu= sc.nextInt();
		sc.nextLine();


		return optionMenu;
	}

	public void executeOperation(int optionMenu){
		switch(optionMenu){
		case 0:
		    System.out.println("Bye, see you soon");
		    break;

		case 1:
		    break;

	    default:
	    	System.out.println("Invalid option!!!");
		}
	}


}