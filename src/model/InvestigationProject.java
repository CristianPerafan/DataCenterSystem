package model;

public class InvestigationProject extends Company{
	private String projectRegistrationNum;

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

	@Override
	public String toString(){
		String out = "";
		out += "Nit : "+nit+"\n";
		out += "Company name : "+companyName+"\n";
		out += "Rental date: "+rentalDate.toString()+"\n";
		out += "Investigation project number : "+projectRegistrationNum;
		return out;

		
	}

	
}