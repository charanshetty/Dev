package Model;
import java.util.ArrayList;

import org.iiitb.model.bean.InvalidMemoryUnitException;

import Controller.Controller;

public class FirstFitAlgorithm 
{	
	int jobSize; //input process memory size
	  // Arraylist of type Fragment	
	static int not_allocated_memory[] = new int[30];
	int i=0;
	static int count = 0;
	static int process_count=0;
	Fragment f= new Fragment();
	static ArrayList<Fragment> fragments=null;
	
	//function to imple ment first fit algorithm for each process size
	public void firstFit(int jobSize,int process_id, ArrayList<Fragment> fragments) throws InvalidMemoryUnitException
	{
		
		for(Fragment unit : fragments) //for loop for arraylist
		{
			if((jobSize <= unit.getMemsize()) && (!unit.getstatus())) //find the first unallocated partition 
			{
				unit.setstatus(); //setting the status for allocation
				unit.setProcess_id(process_id);
				unit.setRemaining_size(jobSize, unit.getMemsize());
				break; //exit when the process is allocated
			}else if (fragments.indexOf(unit) + 1 == fragments.size()) 
			{
				not_allocated_memory[count]= jobSize;
				//System.out.println("This Process HAS NOT BEEN ALLOCATED MEMORY : "+ jobSize);
				count++;
				i++;
			}
		}
	}
	


	public ArrayList<Fragment> input_from_Controller_to_Model(ArrayList <process> processes) throws InvalidMemoryUnitException
	{
		
		//create new fragments with partition size , status- false since not allocated 
		//remaining size = partition size
		if(process_count==0)
		{
			System.out.println("inside process_count");
			fragments=f.create_Fragment();
		}
		
		FirstFitAlgorithm ob = new FirstFitAlgorithm(); //create the object for parent class
		
		
		//int Jobs[] = in; 
		for (int i = process_count; i < processes.size(); i++) 
		{
			ob.firstFit(processes.get(i).getMem_size(),i, fragments);
			process_count++;
		}
		
	
		
		Controller c = new Controller();
		c.not_allocated(not_allocated_memory,count);
		
		return fragments;						 

	} 

}