package model;

public class Server{

	//Attributes
	private double cacheMemory;
	private int amountProccesors;
	private double ramMemory;
	private int amountDisks;
	private double diskCapacity;

	//RelationShips
	private Proccesor proccesorType;

	//Constructor method
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
	public int getAmountProccesors(){
		return amountProccesors;
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



}