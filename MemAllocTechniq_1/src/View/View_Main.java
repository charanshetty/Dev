package View;

import java.util.ArrayList;

import org.iiitb.model.bean.InvalidMemoryUnitException;

import Controller.Controller;
import Model.Fragment;       // Also v can keep a 1 copy of Fragment class in VIEW itself...


// Did this 1 just for testing code

public class View_Main 
{
	
	// This is just a helper function... You(Mayur) can modify this function as per requirementssss...
	
	// 
	public void output_from_Controller_to_View(ArrayList <Fragment> fragments, int[] mem_not_all, int count,int[] in)
	{
		
		System.out.println("=========================IN VIEW=================================================");
		System.out.print("AVAILABLE MEMORY BLOCKS ARE : ");
		for (Fragment unit : fragments) 
		{
			System.out.print(unit.getMemsize()+" ");
		}

		System.out.println();
		
		for (Fragment unit : fragments)
		{
			if (unit.status == true) 
			{
//				for (int i=0;i<in.length;i++){
//					if(in[i]==(unit.getMemsize()-unit.getRemaining_size())){
				System.out.print("Allocated memory blocks : "+unit.getMemsize()+" to process P"+unit.getProcess_id()+" with size "+(unit.getMemsize()-unit.getRemaining_size()));
				
				System.out.println(",,, Remaining fragment Size : "+ unit.getRemaining_size());
//				}}
			}

		}
		//for loop showing 
		for(int i = 0; i < count ; i++) 
		{  				for (int x=0;x<in.length;x++){
			if(in[x]==mem_not_all[i]){

			System.out.println("This Process P"+x+" HAS NOT BEEN ALLOCATED MEMORY : "+ mem_not_all[i]);
		} }}
		
		System.out.println("~~~~~~~~~~~~END OF ALGO~~~~~~~~~~~~~~\n\n");

	}

	
	// for a time being i kept main in VIEW but v can shift it in Controller back after completing remaining part
	public static void main(String args[]) throws InvalidMemoryUnitException
	{
		int arr[] = { 50,1,2,3,4,5,7};  // a sample input
		
		
		Controller c = new Controller();
		// here u have to provide input from VIEW i.e. 1 for FIRST FIT, 2 for best, 3 for worst and 4 for all
		// input_from_View_to_Controller( which_algo?? , input in form of array)
		c.input_from_View_to_Controller(4,arr);
				
	}
}
