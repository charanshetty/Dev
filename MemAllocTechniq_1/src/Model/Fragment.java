package Model;

public class Fragment extends FirstFitAlgorithm 
{
	int process_id=-1;
	int memsize;
	public boolean status;
	int remaining_size ;

	public Fragment(int size,boolean status,int remaining_size)
	{
		this.remaining_size = remaining_size;
		this.memsize = size;
		this.status = status;
	}

	//getter method for partition size
	public int getMemsize()
	{
		return this.memsize;
	}
	
	//getter method for remaining fragment size
	public int getRemaining_size() 
	{
		return this.remaining_size;
	}
	
	//calculate remaining size after allocation
	public int setRemaining_size(int jobSize,int memory) 
	{
		return this.remaining_size = memory - jobSize ;
	}

	public boolean getstatus() 
	{
		return this.status;
	}
	
	//setter method for status
	public boolean setstatus()
	{
		this.status = true;
		return this.status;	
	}
	public int getProcess_id() {
		return process_id;
	}

	public void setProcess_id(int process_id) {
		this.process_id = process_id;
	}

}
