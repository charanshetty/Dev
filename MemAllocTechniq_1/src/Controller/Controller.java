package Controller;


import java.util.ArrayList;

import org.iiitb.model.bean.InvalidMemoryUnitException;

import Model.*;
import View.View_FragMain;
import View.displayAlloc;

public class Controller 
{	
	ArrayList<Fragment> fragments = new ArrayList<>();
	
	/*static int[] mem_not_all = new int[30];
	static int x;*/
	
	
	// this function will take input of those process which are not allocated memory
	/*public void not_allocated(int[] not_allocated_memory, int count)
	{
		mem_not_all = not_allocated_memory;
		System.out.println("IN CNTLR : count = "+count);
		x=count;       
	}*/
	
	
	public  ArrayList<Fragment> input_from_View_to_Controller(int algo, ArrayList <process> processes) throws InvalidMemoryUnitException
	{
		//View_FragMain v = new View_FragMain();
		switch(algo)  // 1 for FIRST FIT, 2 FOR BEST , 3 for WORST and 4 for all
		{
		 case 1 : 	FirstFitAlgorithm ob1 = new FirstFitAlgorithm();
		 			
			 		fragments = ob1.input_from_Controller_to_Model(processes);	 
			 		//v.output_from_Controller_to_View(fragments,mem_not_all,x,processes); // a funtion in view
			 		
			 		break;
			 		
		 case 2 : 	BestFitAlgorithm ob2 = new BestFitAlgorithm();
		 			fragments = ob2.input_from_Controller_to_Model(processes);
		 			//v.output_from_Controller_to_View(fragments,mem_not_all,x,processes);
		 			break;
		 			
		 case 4 : 	WorstFitAlgorithm ob3 = new WorstFitAlgorithm();
		 			fragments = ob3.input_from_Controller_to_Model(processes);
		 			//v.output_from_Controller_to_View(fragments,mem_not_all,x,processes);
		 			break;
		 			
		 case 3 : 	NextFitAlgorithm  ob4 = new NextFitAlgorithm() ;
					fragments = ob4.input_from_Controller_to_Model(processes);
			//v.output_from_Controller_to_View(fragments,mem_not_all,x,processes);
					break;
		 case 5: break;			
		 
		 default : System.out.println("ERROR... Pls provide '1' for first fit, '2' for best and '3' for worst fit");
		 
		}
		 
		
		
		return fragments;
		 
	
	}

}
