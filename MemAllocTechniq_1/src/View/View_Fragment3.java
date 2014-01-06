package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.Fragment;

public class View_Fragment3 extends JPanel {

	 ArrayList<Fragment> f=new ArrayList<Fragment>();
	
	 int mem_size;
	 int size=0;
	 int offset=0;
	 JTextArea textarea;
	public void paintComponent(Graphics g) 
	{

		size=0;
		offset=0;
		g.setColor(Color.gray);
	
		 g.fillRect(100+offset/4, 50,256 , 70);
	
		g.setColor(Color.CYAN);
     
       g.setColor(Color.BLUE);
       for (Fragment unit : f)
		{
       //	System.out.println("segment size:"+unit.getMemsize()+"  remaining size:"+(unit.getMemsize()-unit.getRemaining_size()));
			if (unit.status == true) 
			{
				g.setColor(Color.blue);
                g.fillRect(100+offset/4, 50, (unit.getMemsize()-unit.getRemaining_size())/4, 70); 
                g.setColor(Color.red);
               size=unit.getMemsize()-unit.getRemaining_size();
                g.fillRect(100+(offset+size)/4+1, 50, (unit.getRemaining_size())/4-1, 70-1);
                g.setColor(Color.BLACK);
                g.setFont(new Font("default", Font.PLAIN, 10));
                g.drawString(offset+"", 100+offset/4, 50);
                g.setColor(Color.WHITE);
                g.setFont(new Font("default", Font.BOLD, 10));
                g.drawString("P"+unit.getProcess_id(), 100+offset/4, 90);
				
               // size+=unit.getRemaining_size();
				System.out.print("Allocated memory block no. "+unit.getFragment_id()+" with size "+unit.getMemsize()+" to process P"+unit.getProcess_id()+" with size "+(unit.getMemsize()-unit.getRemaining_size()));
				
				System.out.println(",,, Remaining fragment Size : "+ unit.getRemaining_size());
           // textarea.append("mayur");
			}
			else
			{
				g.setColor(Color.BLACK);
				
				 g.drawRect(100+offset/4, 50, (unit.getMemsize())/4, 70);
				// size+=unit.getRemaining_size();
				 g.setColor(Color.BLACK);
	                g.setFont(new Font("default", Font.PLAIN, 10));
	                g.drawString(offset+"", 100+offset/4, 50);
	                
				
			}
		//	size+=unit.getMemsize();
			offset+=unit.getMemsize();
		      g.setColor(Color.BLACK);
			g.setFont(new Font("default", Font.PLAIN, 10));
            g.drawString(offset+"", 100+offset/4, 50);
			//System.out.println("size: "+size);
		}
      
       
       }      	
		  
	
	public void set_list(ArrayList<Fragment> f,int mem_size)    // It will get next process values from current arraylist object  
	{
		this.f=f;
		this.mem_size=mem_size;
		
	}


}
