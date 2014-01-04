import java.awt.Color;

import java.awt.Graphics;

import java.util.ArrayList;

import javax.swing.JPanel;


public class Buddy_Animation extends JPanel{
	
	 ArrayList<Process_Detail> p=new ArrayList<Process_Detail>();
	
	 int mem_size;

	public void paintComponent(Graphics g) 
	{
		//System.out.println("inside paint");
		
		//j.setText("hello");
		//g.setColor(Color.BLACK);
       // g.drawLine(100, 0, 100, 800);
       
       // g.drawLine(0, 50, 700, 50);
        //g.drawLine(0, 120, 700, 120);
        g.setColor(Color.BLACK);
     g.drawRect( 100, 50 , mem_size/4, 70);   // tot_mem_size...
      //  g.drawRect(100, 50, mem_size/8, 70);    //  dividing line of memory
       
      // f.setVisible(true); 
        g.setColor(Color.BLUE);
       
        for(Process_Detail p_info:p)
        {
        	//System.out.println("process id:"+p_info.p_id+" p_size:"+p_info.p_size+"starting address"+p_info.start_address);
        
        	if(p_info.p_id!=-1)
        	{
        	//startaddress[i]=startaddress[i]/4+200;
        		g.setColor(Color.BLUE);
                g.fillRect(p_info.start_address/4+100, 50, (p_info.p_size/4), 70); 
                g.setColor(Color.BLACK);
                g.drawRect(p_info.start_address/4+100+1, 50, (p_info.p_size/4)-1, 70-1);
      
        	}
        	else
        	{
        		g.setColor(Color.BLACK);
                g.drawRect(p_info.start_address/4+100, 50, (p_info.p_size/4), 70); 
                g.setColor(Color.BLACK);
                //this.createToolTip().setBounds(p_info.start_address/4+100, 75,  (p_info.p_size/4), 70);
               
                g.drawRect(p_info.start_address/4+100+1, 50, (p_info.p_size/4)-1, 70-1);
      
        		
        	}
        }
	}        	
		  
	
	public void set_list(ArrayList<Process_Detail> p,int mem_size)    // It will get next process values from current arraylist object  
	{
		this.p=p;
		this.mem_size=mem_size;
		
	}



	}

