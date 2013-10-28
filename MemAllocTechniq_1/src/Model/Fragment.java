
package Model;

import java.util.ArrayList;

import org.iiitb.model.bean.InvalidMemoryUnitException;
import org.iiitb.model.bean.Memory;
import org.iiitb.model.bean.MemoryUnit;

public class Fragment  
{
	 static Memory<MemoryUnit> m = new Memory<MemoryUnit>(1024);
	 static ArrayList<Fragment> fragments = new ArrayList<>();
	int process_id=-1;
	int fragment_id;
	static int prevloc =0;
	int memsize;
	public boolean status;
	int remaining_size ;
	public Fragment()
	{
		
	}
	public Fragment(int fragment_id,int size,boolean status,int remaining_size) throws InvalidMemoryUnitException
	{   m.add(new MemoryUnit(prevloc, size));
		this.fragment_id=fragment_id;
		this.remaining_size = remaining_size;
		this.memsize = size;
		this.status = status;
		prevloc=prevloc+size;
		//System.out.println(m);
		
	}

	public int getFragment_id() {
		return fragment_id;
	}

	public void setFragment_id(int fragment_id) {
		this.fragment_id = fragment_id;
	}

	//getter method for partition size
	public int getMemsize()
	{
		return this.memsize;
	}
	
	//getter method for remaining fragment size
	public int getRemaining_size() 
	{
		return this.remaining_size;
	}
	
	//calculate remaining size after allocation
	public int setRemaining_size(int jobSize,int memory) 
	{
		return this.remaining_size = memory - jobSize ;
	}

	public boolean getstatus() 
	{
		return this.status;
	}
	
	//setter method for status
	public boolean setstatus()
	{
		this.status = true;
		return this.status;	
	}
	public int getProcess_id() {
		return process_id;
	}

	public void setProcess_id(int process_id) {
		this.process_id = process_id;
	}
	public ArrayList<Fragment>  create_Fragment() throws InvalidMemoryUnitException
	{
		
			Fragment unit5 = new Fragment(1,100, false, 100);
			fragments.add(unit5);
			
			Fragment unit1 = new Fragment(2,80, false, 80);
			fragments.add(unit1);
			
			Fragment unit2 = new Fragment(3,70, false, 70);
			fragments.add(unit2);
			
			Fragment unit3 = new Fragment(4,68, false, 68);
			fragments.add(unit3);
			System.out.println(m);
		return fragments;
	}
}
