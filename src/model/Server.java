package model;

public class Server{

	//Attributes
	private double cacheMemory;
	private int amountProcessors;
	private double ramMemory;
	private int amountDisks;
	private double diskCapacity;

	//RelationShips
	private Proccesor proccesorType;

	//Constructor method
    /**
      * Description: this is the constructor method to create a server.
      * @param cacheMemory double, it represents the server cache of the server.
      * @param amountProcessors int, it represents the amount of processors of the server.
      * @param ramMemory double, it represents the RAM of the server.  
      * @param amountDisks int , it represents the amount of disks of the server.
      * @param diskCapacity double, it represents the total capacity of all the disks. 
      * @param optionPro int, it represents the number corresponding to a processor brand.
      (optionPro = 1 "AMD"),(optionPro = 2 "Intel")
      */
	public Server(double cacheMemory, int amountProcessors, double ramMemory, int amountDisks,
		double diskCapacity, int optionPro){

		this.cacheMemory = cacheMemory;
		this.amountProcessors = amountProcessors;
		this.ramMemory = ramMemory;
		this.amountDisks= amountDisks;
		this.diskCapacity = diskCapacity;

		if(optionPro == 0){
			proccesorType = Proccesor.AMD;
		}
		else{
			proccesorType = Proccesor.INTEL;
		}
	}

	//GETTERS
	public double getCacheMemory(){
		return cacheMemory;
	}
	public int getAmountProcessors(){
		return amountProcessors;
	}
	public double getRamMemory(){
		return ramMemory;
	}
	public int getAmountDisks(){
		return amountDisks;
	}
	public double getDiskCapacity(){
		return diskCapacity;
	}
	public Proccesor getProccesor(){
		return proccesorType;
	}


	//Name: toString
    //Type: String
    /**
      * Description: this is the method to show the attributes of the server
      * @return out String, it represents all the information of the server
      */
	public String toString(){
		String out = "";
		
		out += "Cache memory: "+cacheMemory+" GB\n";
		out += "Number of processor: "+amountProcessors+"\n";
		out += "RAM: "+ramMemory+" GB\n";
		out += "Number of disks: "+amountDisks+"\n";
		out += "Capacity of the disks: "+diskCapacity+" TB\n";

		return out;
	}
}