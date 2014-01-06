package Model;
import java.util.ArrayList;

import org.iiitb.model.bean.InvalidMemoryUnitException;

import Controller.Controller;

public class FirstFitAlgorithm 
{	
	int jobSize; //input process memory size
	  // Arraylist of type Fragment	
	static int process_count=0;
	Fragment f= new Fragment();
	static ArrayList<Fragment> fragments=null;
	
	//function to imple ment first fit algorithm for each process size
	public boolean firstFit(int jobSize,int process_id, ArrayList<Fragment> fragments) throws InvalidMemoryUnitException
	{
		boolean flag=false;
		for(Fragment unit : fragments) //for loop for arraylist
		{
			if((jobSize <= unit.getMemsize()) && (!unit.getstatus())) //find the first unallocated partition 
			{
				unit.setstatus(); //setting the status for allocation
				unit.setProcess_id(process_id);
				unit.setRemaining_size(jobSize, unit.getMemsize());
				flag=true;
				break;
				 
			}
		}
		return flag;
	}
	


	public ArrayList<Fragment> input_from_Controller_to_Model(ArrayList <process> processes) throws InvalidMemoryUnitException
	{
		boolean flag=false;
		if(process_count==0)
		{
//			System.out.println("inside process_count");
			fragments=f.create_Fragment();
			System.out.println("inside FF "+fragments.size());
			for(Fragment f:fragments)
			{
				System.out.println(f.fragment_id+" "+f.getMemsize());
			}
		}
		for(process p1:processes)
			System.out.println("here1"+p1.process_id);
		FirstFitAlgorithm ob = new FirstFitAlgorithm(); //create the object for parent class
		flag=ob.firstFit(processes.get(process_count).getMem_size(),process_count, fragments);
		processes.get(process_count).setFf_status(flag);
		process_count++;
		
		return fragments;						 

	} 
public void dec(){
	process_count--;
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