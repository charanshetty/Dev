package Model;
import java.util.ArrayList;

import org.iiitb.model.bean.InvalidMemoryUnitException;

import Controller.Controller;

public class FirstFitAlgorithm 
{	
	int jobSize; //input process memory size
	private static ArrayList<Fragment> fragments = new ArrayList<>();  // Arraylist of type Fragment
	
	static int not_allocated_memory[] = new int[30];
	int i=0;
	static int count = 0;
	
	//function to implement first fit algorithm for each process size
	public void firstFit(int jobSize,int process_id, ArrayList<Fragment> fragments)
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
				not_allocated_memory[i]= jobSize;
				//System.out.println("This Process HAS NOT BEEN ALLOCATED MEMORY : "+ jobSize);
				count++;
				i++;
			}
		}
	}
	


	public ArrayList<Fragment> input_from_Controller_to_Model(int[] in) throws InvalidMemoryUnitException
	{
		
		//create new fragments with partition size , status- false since not allocated 
		//remaining size = partition size
		Fragment unit5 = new Fragment(1,100, false, 100);
		fragments.add(unit5);
		
		Fragment unit1 = new Fragment(2,80, false, 80);
		fragments.add(unit1);
		
		Fragment unit2 = new Fragment(3,70, false, 70);
		fragments.add(unit2);
		
		Fragment unit3 = new Fragment(4,68, false, 68);
		fragments.add(unit3);
		
		FirstFitAlgorithm ob = new FirstFitAlgorithm(); //create the object for parent class
		
		
		int Jobs[] = in; 
		for (int i = 0; i < Jobs.length; i++) 
		{
			ob.firstFit(Jobs[i],i, fragments);
		}
		
	
		
		Controller c = new Controller();
		c.not_allocated(not_allocated_memory,count);
		
		return fragments;						 

	} 

}