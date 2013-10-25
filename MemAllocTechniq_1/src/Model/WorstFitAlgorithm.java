package Model;
import Controller.Controller;
import java.util.ArrayList;

import org.iiitb.model.bean.InvalidMemoryUnitException;
public class WorstFitAlgorithm 
{
	int jobSize;
	private static ArrayList<Fragment> fragments = new ArrayList<>();

	static int not_allocated_memory[] = new int[30];
	int i=0;
	static int count = 0;
	
	public void worstFit(int jobSize,int process_id, ArrayList<Fragment> fragments)
	{
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
				break;
		    }
			else if (fragments.indexOf(unit) + 1 == fragments.size())
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
		Fragment unit5 = new Fragment(1,10, false, 10);
		fragments.add(unit5);
		
		Fragment unit1 = new Fragment(2,20, false, 20);
		fragments.add(unit1);
		
		Fragment unit2 = new Fragment(3,30, false, 30);
		fragments.add(unit2);
		//int Jobs[] = { 50,1,2,3,4 };
		Fragment unit3 = new Fragment(4,40, false, 40);
		fragments.add(unit3);
		
		WorstFitAlgorithm ob = new WorstFitAlgorithm();
		
		int Jobs[] = in;
		
		
		for (int i = 0; i < Jobs.length; i++) 
		{
			ob.worstFit(Jobs[i],i, fragments);
		}
		
	
		
		Controller c = new Controller();
		c.not_allocated(not_allocated_memory,count);
		
	return fragments;

	}

}