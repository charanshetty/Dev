package View;

import Buddy2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class View_Fragement extends JPanel{
	
	public void paintComponent(Graphics g) 
	{
		
		g.setColor(Color.BLACK);
        g.drawLine(100, 0, 100, 999999);
        g.drawLine(0, 200, 999999, 200);
        g.drawLine(0, 275, 999999, 285);
       
        g.drawRect( 200, 200 , tot_mem_size/4, 70);   // tot_mem_size...
        g.drawRect(200, 200, tot_mem_size/8, 70);    //  dividing line of memory
 
       // f.setVisible(true); 
        g.setColor(Color.YELLOW);
       
        for(int i=0;i<Buddy2.count;i++)
        {
        	
        	//startaddress[i]=startaddress[i]/4+200;
        		g.setColor(Color.YELLOW);
                g.fillRect(startaddress[i]/4+200, 200, (p_size[i]/4), 70); 
                g.setColor(Color.BLACK);
                g.drawRect(startaddress[i]/4+200+1, 200, (p_size[i]/4)-1, 70-1);
              
              	/*jl_pid.setBounds(startaddress[i]/4+200, 200+45, 30, 30);
              	jl_pid.setText("P"+i);
              	add(jl_pid);*/
        	
        }
     
 /*for(int i=1;i<=2;i++)    // for loop will execute for number of processes 2 b shown allocated 
  {   
	  //Graphics g1 = null;
	  
 // allocating memory to process
	  if(i==2)
	  {
		  start_address= 512/4 + offset; //Note:"start_address" has to be divide by 4 here in this function and "psize" in paint
			psize=64;
			pid=2;	
			
	  }
    g.drawRect(start_address, 200, (psize/4), 70);
  //  g.drawRect(500, 500, 200, 80);
	 // g.drawLine(start_address, 200, start_address, 200+70);
	 // g.drawLine(start_address+psize/4+2, 200+70+2, start_address+psize/4, 200+70+2);
	  
    
   // g.fillRect(start_address+1, 200+1, (psize/4)-1, 70-1);       // 

    // labelling process id to the allocated memory  
    //JLabel jl_pid= new JLabel();
  // 	jl_pid.setBounds(start_address+0, 200+45, 30, 30);
	//jl_pid.setText("P"+pid);
	//frame.add(jl_pid);
	//setVisible(true);  
	
					/*try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
					
				//	get_next_process_details();
					
 
		  
	}
	public void get_next_process_details()    // It will get next process values from current arraylist object  
	{
		start_address= 512/4 + offset; //Note:"start_address" has to be divide by 4 here in this function and "psize" in paint
		psize=64;
		pid=2;	
		
		// code to extract new process states... above state is just a sample for testing...
		
		
		
	}
}
