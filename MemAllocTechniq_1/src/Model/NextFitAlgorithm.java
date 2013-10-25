package Model;
import java.util.ArrayList;
import java.util.Random;

import org.iiitb.model.bean.InvalidMemoryUnitException;


import Controller.Controller;

public class NextFitAlgorithm 
{	
	int jobSize; //input process memory size
	private static ArrayList<Fragment> fragments = new ArrayList<>();  // Arraylist of type Fragment
	
	static int not_allocated_memory[] = new int[30];
	int i=0;
	static int count = 0;
	static int position = 0;
	Random r = new Random ();
	static Boolean flag = false;
	//function to implement first fit algorithm for each process size
	public void nextFit(int jobSize,int process_id, ArrayList<Fragment> fragments)
	{
		if(!flag)
	{
	    position =r.nextInt(fragments.size());
	    flag=true;
	}
		
	int i=position;
	  do{
			if((jobSize <= fragments.get(i).getMemsize()) && (!fragments.get(i).getstatus())) //find the first unallocated partition 
			{				
				fragments.get(i).setstatus(); //setting the status for allocation
				fragments.get(i).setProcess_id(process_id);
				fragments.get(i).setRemaining_size(jobSize, fragments.get(i).getMemsize());
				position=i;
		
				break; //exit when the process is allocated
			}
			else if((i+1==position)&&(fragments.get(i).getstatus())) 
				{
					not_allocated_memory[count]= jobSize;
					//System.out.println("This Process HAS NOT BEEN ALLOCATED MEMORY : "+ jobSize);
					count++;
					
					}
			i++;
			if(i==fragments.size())
				i=0;
			
		}while(i!=position);
	 	
	  
	}
	
	public ArrayList<Fragment> input_from_Controller_to_Model(int[] in) throws InvalidMemoryUnitException
	{
		
		//create new fragments with partition size , status- false since not allocated 
		//remaining size = partition size
		Fragment unit5 = new Fragment(100, false, 100);
		fragments.add(unit5);
		
		Fragment unit1 = new Fragment(80, false, 80);
		fragments.add(unit1);
		
		Fragment unit2 = new Fragment(70, false, 70);
		fragments.add(unit2);
		
		Fragment unit3 = new Fragment(68, false, 68);
		fragments.add(unit3);
		
		NextFitAlgorithm ob = new NextFitAlgorithm(); //create the object for parent class
		
		
		int Jobs[] = in; 
		for (int i = 0; i < Jobs.length; i++) 
		{
			ob.nextFit(Jobs[i],i, fragments);
		}
			
		Controller c = new Controller();
		c.not_allocated(not_allocated_memory,count);
		
		return fragments;						 

	} 

}