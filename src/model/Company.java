package model;

public class Company{

	//Attributes
	protected String nit;
	protected String companyName;
	protected Date rentalDate;


    //Constructor method
    /**
    * Description: this is the method to create a Company, the company is created 
    when it rents a mini room
    * @param nit String, 
    * @param companyName String, 
    * @param day int, represents the day when the mini room was rented
    * @param month int, represents the month when the mini room was rented
    * @param year int, represents the year when the mini room was rented
    */
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


	//Name: toString
	//Type: String
    /**
    * Description: this is the method to concatenate the information of the company.
    * @return out String, it represents the information of the company.
    */
	public String toString(){
		String out = "";
		out += "Nit : "+nit+"\n";
		out += "Company name : "+companyName+"\n";
		out += "Rental date: "+rentalDate.toString()+"\n";

		return out;
	}




}