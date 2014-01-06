
package Model;



import java.util.ArrayList;

import org.iiitb.model.bean.InvalidMemoryUnitException;
import org.iiitb.model.bean.Memory;
import org.iiitb.model.bean.MemoryUnit;

public class Fragment  
{
	static  Memory<MemoryUnit> m ;
	 ArrayList<Fragment> fragments = new ArrayList<>();
	  //ArrayList<Fragment> fragments = new ArrayList<>();
	int process_id=-1;
	int fragment_id;
	/*static int prevloc =0;
	static int memsize;*/
	static int count=0;
 	static int prevloc =0;
	  int memsize;
	public boolean status;
	int remaining_size ;
	public Fragment()
	{
		
	}
	public void set_Size(int mem_size)
	{
		m=new Memory<MemoryUnit>(mem_size);
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
	public boolean resetstatus()
	{
		this.status = false;
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
			if(count>0)
			{
				prevloc=0;
				//fragments.clear();
			}
			Fragment unit5 = new Fragment(1,132, false, 0);
			fragments.add(unit5);
			
			Fragment unit1 = new Fragment(2,258, false, 0);
			fragments.add(unit1);
			
			Fragment unit2 = new Fragment(3,110, false, 0);
			fragments.add(unit2);
			
			Fragment unit3 = new Fragment(4,524, false, 0);
			fragments.add(unit3);
			System.out.println(m);
			count++;
		return fragments;
	}
	boolean  removefrom_list(int p_id)
	{
		int block_size=0;
		int address=0;
		boolean flag=false;
		for(Fragment as:fragments)
		{
//			if(as.process_id == p_id)
//			{
//				 block_size=as.mem_size;
//				 address=as.address;
//				alloc_list.remove(as);
//				flag=true;
//				update_freelist(block_size,address);
//				break;
//			}
		}
		
		return flag;
	}
}
