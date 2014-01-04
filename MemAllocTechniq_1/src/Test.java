import java.util.ArrayList;


public class Test {
	 ArrayList<Process_Detail> p_info=new ArrayList<Process_Detail>();
	Driver_Buddy db =new  Driver_Buddy();
	//Test t=new Test();
	void set_memSize(int mem_size)
	{
		 db.set_Size(mem_size);
		 db.create_list();
	}
	ArrayList<Process_Detail> add_process(int p_id,int mem_size)
	{
		p_info.clear();
		if(db.allocate_Buddy(p_id, mem_size))
		{
			p_info.clear();
			return get_updatedStatus();
		}
		else
		{
			return null;
		}
	}
	ArrayList<Process_Detail>  remove_process(int p_id)
	{
		
		
		if(db.removefrom_list(p_id))
		{
			p_info.clear();
			return get_updatedStatus();
		}
		else
		{
			return null;
		}
		
	}
	ArrayList<Process_Detail> get_updatedStatus()
	{
		int index=0;
		int count=0;
		for(Driver_Buddy db1:db.free_list)
		{
			
			for(int i=0;i<db1.free_buddy.size();i++)
			{
				p_info.add(new Process_Detail());
				p_info.get(index).p_id=-1;
				p_info.get(index).p_size=(int) Math.pow(2, count);
				p_info.get(index).start_address=db1.free_buddy.get(i).address;
				//index++;
				index++;
			}
			count++;
		}
		System.out.println("size of alloc"+db.alloc_list.size()+" "+ p_info.size());
		for(Allocation_Status as:db.alloc_list)
		{
			
				p_info.add(new Process_Detail());
				p_info.get(index).p_id=as.p_id;
				p_info.get(index).p_size=(int)as.mem_size;
				p_info.get(index).start_address=as.address;
				index++;
		}
		return p_info;
	}
	void start()
	{
		
		db.set_Size(1024);
		 db.create_list();
		 
		 this.add_process(0,256);
		/* p_info.clear();
		 this.add_process(1,256);
		 p_info.clear();
		 this.add_process(2,256);
		 p_info.clear();
		 this.add_process(3,256);
		// p_info.clear();
		// this.add_process(0,512);
		// p_info.size();*/
		 for(Process_Detail ps:p_info)
			{
			
				System.out.println("process id:"+ps.p_id+" p_size:"+ps.p_size+"starting address"+ps.start_address);
			}
		 System.out.println("---------------------------------------------------------");
		/*p_info.clear();
		 this.add_process(1,512);
		 for(Process_Detail ps:p_info)
			{
			
				System.out.println("process id:"+ps.p_id+" p_size:"+ps.p_size+"starting address"+ps.start_address);
			}
		*/
	}
	public Test()
	{
		//this.start();
	}

}
