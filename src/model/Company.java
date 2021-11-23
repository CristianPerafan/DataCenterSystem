package model;

public class Company{

	//Attributes
	protected String nit;
	protected String companyName;
	protected Date rentalDate;


    //Constructor method
	public Company(String nit, String companyName, int day, int month, int year){
		this.nit = nit;
		this.companyName = companyName;
		rentalDate = new Date(day,month,year);
	}

	//Getters
	public String getNit(){
		return nit;
	}
	public String getCompanyName(){
		return companyName;
	}
	public Date getRentalDate(){
		return rentalDate;
	}
	//Setters
	public void setNit(String nit){
		this.nit = nit;
	}
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	public void setRentalDate(int day, int month, int year){
		rentalDate.setDay(day);
		rentalDate.setMonth(month);
		rentalDate.setYear(year);
	}

	public String toString(){
		String out = "";
		out += "Nit : "+nit+"\n";
		out += "Company name : "+companyName+"\n";
		out += "Rental date: "+rentalDate.toString()+"\n";

		return out;
	}




}