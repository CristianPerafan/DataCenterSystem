package model;


public class Rack{

	//array of server-type objects
	private Server [] companyServers;

    //Constructor method
    /**
    * Description: this is the method to create a Rack in a mini room.
    * @param numServers int, it represents the number of processors on the server
    */
	public Rack(int numServers){
		companyServers = new Server[numServers];
	}


	//Name: addAServer
	//Type: void
    /**
      * Description: this is the method to add a server.
      * @param cacheMemory double, it represents the server cache of the server.
      * @param amountProcessors int, it represents the amount of processors of the server.
      * @param ramMemory double, it represents the RAM of the server.  
      * @param amountDisks int , it represents the amount of disks of the server.
      * @param diskCapacity double, it represents the total capacity of all the disks. 
      * @param optionPro int, it represents the number corresponding to a processor brand.
      (optionPro = 1 "AMD"),(optionPro = 2 "Intel")
      */
	public void addAServer(double cacheMemory, int amountProcessors, double ramMemory, int amountDisks,
		double diskCapacity, int optionPro){
		int position = findAnEmptyPosition();

		companyServers[position] = new Server(cacheMemory,amountProcessors,
			ramMemory,amountDisks,diskCapacity,optionPro);
	}


	//Name: addAServer
	//Type: void
    /**
      * Description: this is to find an empty position in the array of servers.
      * @return out int, it represents the empty position number in the array of servers.
      */
	public int findAnEmptyPosition(){
		int out = 0;
		boolean flag = false;
		for(int i = 0; i<companyServers.length && !flag;i++){
			if(companyServers[i] == null){
				out = i;
				flag = true;
			}
		}

		return out;
	}

	//Name: toString
	//Type: String
    /**
      * Description: this is the method to concatenate the information of the servers
      * @return out String, it contains the information of the servers.
      */
	public String toString(){
		String out = "";

		for(int i = 0; i<companyServers.length;i++){
			out += "*** SERVER "+(i+1)+" ***\n";
			out +=companyServers[i].toString()+"\n";
		}

		return out;
	}

	//Name: calculateDiskCapacity
	//Type: double
    /**
      * Description: this is the method to calculate the total disk capacity of the servers.
      * @return out double, it represents the total disk capacity of the servers.
      */
	public double calculateDiskCapacity(){
		double out = 0;
		for(int i = 0; i<companyServers.length;i++){
			out += companyServers[i].getDiskCapacity();
		}
		return out;
	}

	//Name: calculateDiskCapacity
	//Type: double
    /**
      * Description: this is the method to calculate the total RAM capacity of the servers in a Rack.
      * @return out double, it represents the total RAM capacity of the servers in a Rack.
      */
	public double calculateRamCapacity(){
		double out = 0;

		for(int i = 0; i<companyServers.length;i++){
			out += companyServers[i].getRamMemory();
		}

		return out;
	}

	//Name: calculateAmountOfServers
	//Type: int
    /**
      * Description: this is the method to calculate the amount of servers in a Rack
      * @return out int, it represents the amount of the servers in a Rack.
      */
	public int calculateAmountOfServers(){
		int out = companyServers.length;
		return out;
	}
	
}
