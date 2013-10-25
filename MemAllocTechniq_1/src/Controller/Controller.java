package Controller;


import java.util.ArrayList;

import org.iiitb.model.bean.InvalidMemoryUnitException;

import Model.*;
import View.View_Main;

public class Controller 
{	
	static ArrayList<Fragment> fragments = new ArrayList<>();
	
	static int[] mem_not_all = new int[30];
	static int x;
	
	
	// this function will take input of those process which are not allocated memory
	public void not_allocated(int[] not_allocated_memory, int count)
	{
		mem_not_all = not_allocated_memory;
		System.out.println("IN CNTLR : count = "+count);
		x=count;       
	}
	
	
	public void input_from_View_to_Controller(int algo, int[] in) throws InvalidMemoryUnitException
	{
		View_Main v = new View_Main();
		switch(algo)  // 1 for FIRST FIT, 2 FOR BEST , 3 for WORST and 4 for all
		{
		 case 1 : 	FirstFitAlgorithm ob1 = new FirstFitAlgorithm();
			 		fragments = ob1.input_from_Controller_to_Model(in);	 
			 		v.output_from_Controller_to_View(fragments,mem_not_all,x,in); // a funtion in view
			 		break;
			 		
		 case 2 : 	BestFitAlgorithm ob2 = new BestFitAlgorithm();
		 			fragments = ob2.input_from_Controller_to_Model(in);
		 			v.output_from_Controller_to_View(fragments,mem_not_all,x,in);
		 			break;
		 			
		 case 3 : 	WorstFitAlgorithm ob3 = new WorstFitAlgorithm();
		 			fragments = ob3.input_from_Controller_to_Model(in);
		 			v.output_from_Controller_to_View(fragments,mem_not_all,x,in);
		 			break;
		 			
		 case 4 :   break;  // for running all algos (comparinsion between algos...)
		 
		 default : System.out.println("ERROR... Pls provide '1' for first fit, '2' for best and '3' for worst fit");
		 
		}
		 
		
		 if(algo==4)
		 {
			 ArrayList<Fragment> fragments1 = new ArrayList<>();
			 ArrayList<Fragment> fragments2 = new ArrayList<>();
			 ArrayList<Fragment> fragments3 = new ArrayList<>();
			 ArrayList<Fragment> fragments4 = new ArrayList<>();
			 
			FirstFitAlgorithm ob1 = new FirstFitAlgorithm();
		 	fragments1 = ob1.input_from_Controller_to_Model(in);	 
		 	v.output_from_Controller_to_View(fragments1,mem_not_all,x,in);
		 		
		 	BestFitAlgorithm ob2 = new BestFitAlgorithm();
	 		fragments2 = ob2.input_from_Controller_to_Model(in);
	 		v.output_from_Controller_to_View(fragments2,mem_not_all,x,in);
	 			
	 		WorstFitAlgorithm ob3 = new WorstFitAlgorithm();
	 		fragments3 = ob3.input_from_Controller_to_Model(in);
	 		v.output_from_Controller_to_View(fragments3,mem_not_all,x,in);

	 		NextFitAlgorithm ob4 = new NextFitAlgorithm();
			fragments4 = ob4.input_from_Controller_to_Model(in);
			v.output_from_Controller_to_View(fragments4,mem_not_all,x,in);
			

		}
		 
	
	}

}
