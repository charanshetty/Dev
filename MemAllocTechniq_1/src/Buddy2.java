

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Buddy2 implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	
	JFrame f=new  JFrame ();
	 //Buddy2 b = new Buddy2();	
	// draw rect and fill rect for all process coming in... call repaint in that case....
	static public int count=1;
	
	JLabel jl_head= new JLabel();
	JLabel jl_pid= new JLabel();

	JButton jb_next=new JButton("NEXT");
	JButton jb_close= new JButton("CLOSE");
	
	
	
	public void draw()
	{
		
		// JPanel panel=new JPanel();
	     //getContentPane().add(panel);
	     //setSize(450,450);
		
		//f.add(b);
	     f.setTitle("SIMULATION FOR BUDDY SYSTEM...");
	    
	     //f.setLocationRelativeTo(null);
	     f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		// f.setLayout(null);
	     
	     jl_head.setBounds(450, 20,400, 100);
	     jl_head.setForeground(Color.BLUE);
	     jl_head.setFont(new Font("Calibre", Font.ITALIC, 22));
	     jl_head.setText("BUDDY SYSTEM SIMULATION.");
	     f.getContentPane().add(jl_head);
	     
	 /*    jl_pid.setBounds(100, 100, 50, 50);
		 jl_pid.setText("P "+pid);
		 add(jl_pid);  setVisible(true);   */
		 
		jb_next.setBounds(250,400,80,30);
		jb_next.addActionListener(this);
		f.getContentPane().add(BorderLayout.SOUTH,jb_next);
		Buddy_Animation ba=new Buddy_Animation();
		f.getContentPane().add(BorderLayout.CENTER,ba);
		//ba.repaint();
		jb_close.setBounds(350,400, 80, 30);
		jb_close.addActionListener(this);
		f.getContentPane().add(BorderLayout.SOUTH,jb_close);
		// f.add(new Buddy2());
		 f.setSize(1500,1500);
	     f.setVisible(true);
	   //  f.add(new Buddy2());
		
	//====================================
		
		
	
	}
  
	
	
	//=============================================================================================================

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	
		Object o = e.getSource();
		
		if(o.equals(jb_close))
		{
			JOptionPane.showMessageDialog(null, "Thank you for using this simulator. We hope you got the concept.");
			f.dispose();
		}
		
		if(o.equals(jb_next))
		{
			System.out.println("inside repaint");
			count++;
			f.repaint();
			//JOptionPane.showMessageDialog(null, "Calling to next step");
			//get_new_arraylist_from_controller();  // NEXT PRESSED SO GET NEW ARRAYLIST FROM CONTROLLER
			
			//this.dispose();
			
		}
		
	}
	
	// NEXT PRESSED...   ;)
	public void get_new_arraylist_from_controller()
	{
		
		
		
		//repaint();
	}
	
	
	
	
	

}
