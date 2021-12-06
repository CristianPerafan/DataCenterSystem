package model;

public class InvestigationProject extends Company{
	//Attributes
	private String projectRegistrationNum;

	//Constructor method
    /**
    * Description: this is the method to create a investigation projecty, the investigation project 
    is created when it rents a mini room for a investigation project.
    * @param nit String, 
    * @param companyName String,
    * @param projectRegistrationNum String, 
    * @param day int, represents the day when the mini room was rented
    * @param month int, represents the month when the mini room was rented
    * @param year int, represents the year when the mini room was rented
    */

	public InvestigationProject(String nit, String companyName, String projectRegistrationNum, int day,
		int month, int year){
		super(nit,companyName,day,month,year);
		this.projectRegistrationNum = projectRegistrationNum;
	}

	//GETTERS
	public String getProjectRegistrationNu(){
		return projectRegistrationNum;
	}

	//SETTERS
	public void setProjectRegistrationNum(String projectRegistrationNum){
		this.projectRegistrationNum = projectRegistrationNum;
	}

	//Name: toString
	//Type: String
    /**
    * Description: this is the method to concatenate the information of the investigation project.
    * @return out String, it represents the information of the investigation project.
    */
	@Override
	public String toString(){
		String out = "";
		out += "Nit : "+nit+"\n";
		out += "Company name : "+companyName+"\n";
		out += "Rental date: "+rentalDate.toString()+"\n";
		out += "Investigation project number : "+projectRegistrationNum+"\n";
		return out;

		
	}

	
}