package Model;
import Controller.Controller;
import java.util.ArrayList;

import org.iiitb.model.bean.InvalidMemoryUnitException;
public class WorstFitAlgorithm 
{
	int jobSize;
	private static ArrayList<Fragment> fragments = new ArrayList<>();
	static int process_count=0;
	Fragment f= new Fragment();
	
	
	public boolean worstFit(int jobSize,int process_id, ArrayList<Fragment> fragments)
	{
		boolean flag=false;
		int max = 0;
		for (Fragment unit : fragments) 
		{
			if ((jobSize <= unit.getMemsize()) && (!unit.getstatus()) && unit.getMemsize()>=max)	
				max=unit.getMemsize();
		}
		
		
		
		for (Fragment unit : fragments)
		{
			if(unit.getMemsize()==max)
			{
				unit.setstatus();
				unit.setRemaining_size(jobSize, unit.getMemsize());
				unit.setProcess_id(process_id);
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
			System.out.println("inside process_count");
			fragments=f.create_Fragment();
		}
		
		WorstFitAlgorithm  wf = new WorstFitAlgorithm (); //create the object for parent class
		
		
		
		
			flag=wf.worstFit(processes.get(process_count).getMem_size(),process_count, fragments);
			processes.get(process_count).setWf_status(flag);
			process_count++;
			return fragments;						 

	} 


}