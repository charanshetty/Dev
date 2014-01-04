import java.util.Comparator;


public class Address_Sorter implements Comparator<Free_Info>{

	@Override
	public int compare(Free_Info arg0, Free_Info arg1) {
		// TODO Auto-generated method stub
		if(arg0.address==arg1.address)
			return 0;
		else if(arg0.address<arg1.address)
			return -1;
		else
			return 1;
	}
	 
}
