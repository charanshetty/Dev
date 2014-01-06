package Model;
import java.util.ArrayList;
import java.util.Random;

import org.iiitb.model.bean.InvalidMemoryUnitException;


import Controller.Controller;

public class NextFitAlgorithm 
{	
	int jobSize; //input process memory size
	private static ArrayList<Fragment> fragments = new ArrayList<>();  // Arraylist of type Fragment

	int i=0;
	static int position = 0;
	static int count = 0;
	static int process_count=0;
	Random r = new Random ();
	static Boolean is_next = false;
	Fragment f= new Fragment();
	//function to implement first fit algorithm for each process size
	public boolean nextFit(int jobSize,int process_id, ArrayList<Fragment> fragments)
	{
		boolean flag=false;
		if(!is_next)
	{
	    position =r.nextInt(fragments.size());
	   is_next=true;
	   System.out.println("position:"+position);
	}
		
	int i=position;
	  do{
			if((jobSize <= fragments.get(i).getMemsize()) && (!fragments.get(i).getstatus())) //find the first unallocated partition 
			{				
				fragments.get(i).setstatus(); //setting the status for allocation
				fragments.get(i).setProcess_id(process_id);
				fragments.get(i).setRemaining_size(jobSize, fragments.get(i).getMemsize());
				position=i;
				flag=true;
				break; //exit when the process is allocated
			}
			
			i++;
			if(i==fragments.size())
				i=0;
			
		}while(i!=position);
	 	
	  return flag;
	}
	
	
	public ArrayList<Fragment> input_from_Controller_to_Model(ArrayList <process> processes) throws InvalidMemoryUnitException
	{
		boolean flag=false;
		//create new fragments with partition size , status- false since not allocated 
		//remaining size = partition size
		if(process_count==0)
		{
//			System.out.println("inside process_count");
			fragments=f.create_Fragment();
		}
		
		NextFitAlgorithm  nf = new NextFitAlgorithm (); //create the object for parent class
		flag=nf.nextFit(processes.get(process_count).getMem_size(),process_count, fragments);
		processes.get(process_count).setNf_status(flag);
		process_count++;
		return fragments;						 

	} 

	
	public ArrayList<Fragment> clear_input_from_Controller_to_Model(int p_id){
		process_count--;
		for(int i =0;i<fragments.size();i++)
		{
			if((fragments.get(i).getProcess_id()==p_id)&&(fragments.get(i).getstatus()))
				{fragments.get(i).set_Size(fragments.get(i).getMemsize());
				fragments.get(i).setRemaining_size(0, 0);
				fragments.get(i).resetstatus();
				}
			System.out.println("in fragments"+fragments.get(i).getstatus());
		}
		return fragments;						 

		
	}
}