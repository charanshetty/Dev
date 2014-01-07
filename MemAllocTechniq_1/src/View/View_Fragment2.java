package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.Fragment;

public class View_Fragment2 extends JPanel{

	 ArrayList<Fragment> f=new ArrayList<Fragment>();
      static int tmp =-1;	
	 int mem_size;
	 int size=0;
	 int offset=0;
	 JTextArea textarea;
	 
	/* public View_Fragment2()
	 {
		this.setLayout(null);
		  textarea= new JTextArea(50,50); //Result is stored in there
		//textarea.setBounds(170,130, 50,50);
			//textarea.setSize(10,10);
	        textarea.setEditable(false);
	        textarea.setLineWrap(true);
	        JScrollPane scroll= new JScrollPane(textarea);
	        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        textarea.setWrapStyleWord(true);
	       // textarea.setBorder(new TitledBorder(new EtchedBorder(), "Result"));
	      scroll.setBounds(170,130, 200,150);
	        this.add(scroll);
	    //s    Point p=textarea.getLocation();
	       // System.out.println(p.x+"  "+p.y);
	 }
	 void update_Textarea()
	 {
		 textarea.setText(null); 
		 for (Fragment unit : f)
			{
	        //	System.out.println("segment size:"+unit.getMemsize()+"  remaining size:"+(unit.getMemsize()-unit.getRemaining_size()));
				if (unit.status == true) 
				{
					
	               size=unit.getMemsize()-unit.getRemaining_size();
	                
	               // size+=unit.getRemaining_size();
					//System.out.print("");
					textarea.append("Process_Id:"+unit.getProcess_id()+" Process_Size:"+size+" Internal_Fragmentation:"+unit.getRemaining_size());
				//	System.out.println(",,, Remaining fragment Size : "+ unit.getRemaining_size());
	            // textarea.append("mayur");
				}
	 }
	 }*/
	public void paintComponent(Graphics g) 
	{
		//textarea.setText("");
		
		size=0;
		offset=0;
		g.setColor(Color.gray);
		
		 g.fillRect(100+offset/4, 50,256 , 70);
		//j.setText("hello");
		g.setColor(Color.CYAN);
      // g.drawLine(100, 0, 100, 120);
      
      // g.drawLine(0, 50, 500, 50);
      // g.drawLine(0, 120, 500, 120);
      
     // g.drawRect( 100, 50 , mem_size/4, 70);   // tot_mem_size...
      // g.drawRect(100, 50, mem_size/8, 70);    //  dividing line of memory
      
     // f.setVisible(true); 
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
                if(unit.getProcess_id()!=tmp){
    				System.out.println("Next Fit:Allocated memory block no. "+unit.getFragment_id()+" with size "+unit.getMemsize()+" to process P"+unit.getProcess_id()+" with size "+(unit.getMemsize()-unit.getRemaining_size()));
    				
    				//System.out.println(",,, Remaining fragment Size : "+ unit.getRemaining_size());
    				tmp=unit.getProcess_id();
                    }
           // textarea.append("mayur");
			}
			else
			{
				g.setColor(Color.WHITE);
				
				 g.drawRect(100+offset/4, 50, (unit.getMemsize())/4, 70);
				 g.setColor(Color.BLACK);
	                g.setFont(new Font("default", Font.PLAIN, 10));
	                g.drawString(offset+"", 100+offset/4, 50);
	                
				// size+=unit.getRemaining_size();
               g.setColor(Color.BLACK);
               //this.createToolTip().setBounds(p_info.start_address/4+100, 75,  (p_info.p_size/4), 70);
              
               //g.drawRect(100+size/4+1, 50, (unit.getMemsize()-unit.getRemaining_size())/4-1, 70-1);
				
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
