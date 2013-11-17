package Model;
import Controller.Controller;

import java.util.ArrayList;

import org.iiitb.model.bean.InvalidMemoryUnitException;
public class BestFitAlgorithm 
{
	int jobSize;
	private static ArrayList<Fragment> fragments = new ArrayList<>();
	static int process_count=0;
	Fragment f= new Fragment();
	public boolean  bestFit(int jobSize,int process_id, ArrayList<Fragment> fragments)
	{
		boolean flag=false;
		int min = 100000;
		for (Fragment unit : fragments) 
		{
			if ((jobSize <= unit.getMemsize()) && (!unit.getstatus()) && unit.getMemsize()<=min)	
		{
				min=unit.getMemsize();
		}}
		
		
		
		for (Fragment unit : fragments)
		{
			if(unit.getMemsize()==min)
			{
				unit.setProcess_id(process_id);
				unit.setstatus();
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
			System.out.println("inside process_count");
			fragments=f.create_Fragment();
			System.out.println("inside BF "+fragments.size());
			for(Fragment f:fragments)
			{
				System.out.println(f.fragment_id+" "+f.getMemsize());
			}
		}
		
		BestFitAlgorithm ob = new BestFitAlgorithm(); //create the object for parent class
		flag=ob.bestFit(processes.get(process_count).getMem_size(),process_count, fragments);
		//processes.get(process_count).setStatus(flag);
		processes.get(process_count).setBf_status(flag);
		//System.out.println(processes.get(process_count).getStatus());
		process_count++;
		return fragments;						 

	} 

}