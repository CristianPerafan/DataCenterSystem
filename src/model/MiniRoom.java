package model;

public class MiniRoom{
	//Attributes
	private int identifier;
	private double price;
	private int hall;

	//RelationShips
	private Company company; 
	private Window window;
	private Available available;
	private State state;
	

    //Constructor method
    public MiniRoom(int identifier,int hall){
    	this.identifier = identifier;
    	price = 5000000;
    	this.hall = hall;
    }

    //GETTERS
    public int getIdentifier(){
    	return identifier;
    }
    public double getPrice(){
    	return price;
    }
    public int getHall(){
    	return hall;
    }
    public Company getCompany(){
    	return company;
    }

    //SETTERS
    public void SetIdentifier(int identifier){
    	this.identifier = identifier;
    }
    public void SetPrice(double price){
    	this.price = price;
    }
    public void setHall(int hall){
    	this.hall = hall;
    }

    public String toString(){
    	String out = "";

    	out += "Identifier : "+identifier+"\n";
    	out += "Hall : "+ hall+"\n";
    	out += "Price : "+price+"\n";
    	out += "Avalaible : " + available+"\n";
    	out += "Window : "+window+"\n";
    	out += "State : "+state+"\n";
    	 
    	if(company != null){
    		if(company instanceof InvestigationProject){
    			out += ((InvestigationProject)company).toString();
    		}
    		else{
    			out += company.toString();
    		}
    		
    	}

    	


    	return out;
    }

	

	
	
}