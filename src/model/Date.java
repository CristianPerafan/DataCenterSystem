package model;

public class Date{

	//Attributes
	private int day;
	private int month;
	private int year;

	//Constructor method
    /**
    * Description: this is the method to create the rental date of a mini room,
    * @param day int, represents the day when the mini room was rented
    * @param month int, represents the month when the mini room was rented
    * @param year int, represents the year when the mini room was rented
    */
	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	//Setters
	public void setDay(int day){
		this.day = day;
	}
	public void setMonth(int month){
		this.month = month;
	}
	public void setYear(int year){
		this.year = year;
	}

	//Name: toString
	//Type: String
    /**
    * Description: this is the method to concatenate the information of the date
    * @return out String, it represents the information of the date.
    */
	public String toString(){
		String out = "";
		out += day+" / "+month+" / "+year;
		return out;
	}
}