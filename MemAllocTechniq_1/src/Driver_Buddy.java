//import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Driver_Buddy extends Free_Info{
	  ArrayList<Free_Info> free_buddy=new ArrayList<Free_Info>();
	  static  ArrayList< Allocation_Status> alloc_list=new ArrayList< Allocation_Status>();
	   static ArrayList<Driver_Buddy> free_list;
	private int list_Size;
	//static int count=-1;
	void set_Size(int m)
	{
		list_Size=(int) Math.ceil((Math.log(m)/Math.log(2))) ;
		System.out.println("list size = "+list_Size);// print size of list
	}
	/* create free list*/
	void create_list()
	{
		free_list=new ArrayList<Driver_Buddy>();
		for(int i=0;i<=list_Size;i++)
			{
				free_list.add(new Driver_Buddy());
			}
		
		//System.out.println("list of size"+free_list.size()+"is created");
		Driver_Buddy d=free_list.get(list_Size);
		d.free_buddy.add(0, new Free_Info());
		d.free_buddy.get(0).address=0;
		//System.out.println(free_list.get(list_Size).free_buddy.size());
	}
	boolean  allocate_Buddy(int p_id,int mem_size)
	{
		//count++;//indicates process id 
		//System.out.println("inside allocate"+ request);
		System.out.println("p_id "+p_id+ "mem_size"+ mem_size);
		int index,old_index,i;
		int address=0;//revisit this
		boolean flag=false;
		index=(int) Math.ceil((Math.log(mem_size)/Math.log(2))) ;
		//System.out.println("index="+ index);
		old_index=index;
			if(free_list.get(index).free_buddy.size()!=0)
			{
				//System.out.println("inside if");
				address=free_list.get(index).free_buddy.get(0).address;
				free_list.get(index).free_buddy.remove(0);
				flag=true;
			}
		
			else
			{
				//old_index=index;
				int local_index;
				//System.out.println("inside else"+index);
				for(i=index+1;i<=list_Size;i++)
				{
					if(free_list.get(i).free_buddy.size()!=0)
					{
						address=free_list.get(i).free_buddy.get(0).address;
						free_list.get(i).free_buddy.remove(0);
						//System.out.println("i= "+i);
						for(int j=i-1;j>=old_index;j--)
						{
							//System.out.println("at index"+ j);
							if(free_list.get(j).free_buddy.size()>0)
							{
								local_index=free_list.get(j).free_buddy.size()-1;
							}
							else
							{
								local_index=0;
							}
							free_list.get(j).free_buddy.add(0,new Free_Info());;
							free_list.get(j).free_buddy.get(0).address= (address+(int)Math.pow(2, j));
							//free_list.get(j).free_buddy.
						Collections.sort(free_buddy,new Address_Sorter());
							
						}
						flag=true;
					}
					if(flag)
					{
						break;
					}
						
				}
			}
			if(flag)
			{
				System.out.println("request of memory size " +mem_size+" is fullfilled" );
				add_to_list(p_id,mem_size,address);
			}
			else
			{
				System.out.println("request of memory size " +mem_size+" is not fullfilled" );
			}
			return flag;
			
	}
		void print_freelist()
		{
			int size,count=0;
			System.out.println("Buddy size   No. of Buddies starting_address");
			for(Driver_Buddy db:free_list)
			{
				size=db.free_buddy.size();
				System.out.print((int)Math.pow(2, count)+ "                  "+db.free_buddy.size());
				for(int j=0;j<size;j++)
				System.out.print("       "+db.free_buddy.get(j).address);
				System.out.println();
				count++;
			}
		}
		
	

void add_to_list(int p_id,int mem_size,int address)
{
	int index;
	alloc_list.add(new Allocation_Status());
	index=alloc_list.size();
	alloc_list.get(index-1).address=address;
	alloc_list.get(index-1).p_id=p_id;
	alloc_list.get(index-1).mem_size=mem_size;
}
void print_alloclist()
{
	System.out.println("p_id  address  size");
	for(Allocation_Status as:alloc_list)
	{ 
		System.out.println(as.p_id+"       "+as.address+"       "+as.mem_size);
	}
}

void update_freelist(int block_size,int address)
{
//	System.out.println("inside update_freelist");
	int index;
	int size,flag=0;
	//String s1,s2;
	index=(int) Math.ceil((Math.log(block_size)/Math.log(2))) ;
	//System.out.println("inside update_freelist:"+ index+" "+address);
	for(int i=index;i<=list_Size;i++)
	{
		flag=0;
		//s1=Integer.toBinaryString(address);
		size=free_list.get(i).free_buddy.size();
		//System.out.println("inside update_freelist:"+ i+" "+address+" "+size);
		for(int j=0;j<size;j++)
		{
			//s2=Integer.toBinaryString(free_list.get(i).free_buddy.get(j).address);
			if((address^free_list.get(i).free_buddy.get(j).address)==(int)Math.pow(2, i))
			{
				if(address>free_list.get(i).free_buddy.get(j).address)
					address=free_list.get(i).free_buddy.get(j).address;
				free_list.get(i).free_buddy.remove(j);
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			//System.out.println("inside update_freelist:"+ index+" "+address);
			free_list.get(i).free_buddy.add(new Free_Info());
			size=free_list.get(i).free_buddy.size();
			free_list.get(i).free_buddy.get(size-1).address=address;
			Collections.sort(free_buddy,new Address_Sorter());
			break;
		}
	}
}
boolean  removefrom_list(int p_id)
{
	int block_size=0;
	int address=0;
	boolean flag=false;
	for(Allocation_Status as:alloc_list)
	{
		if(as.p_id==p_id)
		{
			 block_size=as.mem_size;
			 address=as.address;
			alloc_list.remove(as);
			flag=true;
			update_freelist(block_size,address);
			break;
		}
	}
	
	return flag;
}

	
}
		
	

