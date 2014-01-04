
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


// This is page 1 for Buddy System...
public class Buddy1_1 extends JFrame implements ActionListener,MouseMotionListener{
	Test t=new Test();
	 Buddy_Animation ba=new Buddy_Animation();
	 ArrayList<Process_Detail> p_info;
	private static final long serialVersionUID = 1L;
	static public int count=1;
	static int flag=0;
	int mem_size;
	String pid_string, psize_string;
	
	JLabel welcome=new JLabel();
	JLabel prompt= new JLabel();
	JLabel status_label=new JLabel();
	JLabel tot_mem_size_label= new JLabel();
	JLabel pid_label= new JLabel();
	JLabel psize_label= new JLabel();
	JLabel alloc_or_remove_label= new JLabel();
	JLabel alloc_or_remove_label1=new JLabel();
	JLabel alloc_label=new JLabel();
	JLabel remove_label=new JLabel();
	JLabel pid_label_remove=new JLabel();
	JTextField tot_mem_size= new JTextField();
	JTextField pid= new JTextField();
	JTextField psize= new JTextField();
	JTextField pid_remove= new JTextField();
	
//	JButton jb_next=new JButton("NEXT");
	JButton jb_close= new JButton("CLOSE");
	JButton addmore= new JButton("Add More");
	JButton reset= new JButton("Reset");
	JButton remove= new JButton("Remove"); 
	
	
	Buddy1_1(){
		init();	 
	}
	void init(){
		 setTitle("SIMULATION FOR BUDDY SYSTEM...");
	     setSize(2500,2500);
	     setLocationRelativeTo(null);
	     setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setLayout(null);
		 
		 welcome.setBounds(450, 20,1000, 100);
		 welcome.setForeground(Color.BLUE);
	     welcome.setFont(new Font("Calibre", Font.BOLD, 22));
	     welcome.setText("WELCOME TO BUDDY SYSTEM SIMULATOR....");
	     add(welcome);
		 
	     prompt.setBounds(10, 50,1000, 200);
	     prompt.setForeground(Color.RED);
	     prompt.setFont(new Font("Calibre", Font.PLAIN, 18));
	     prompt.setText("Please Enter the below details...");
	     add(prompt);
	     
	     tot_mem_size_label.setBounds(20, 100, 300, 300);
	     tot_mem_size_label.setText("Total size of Main Memory (Bytes): ");
	     add(tot_mem_size_label);
	     tot_mem_size.setBounds(20+250, 100+140, 70, 25);
	     add(tot_mem_size);
	     
	     // ALLOCATE PART..
	     alloc_label.setBounds(30, 120, 500, 500);
	     alloc_label.setForeground(Color.orange);
	     alloc_label.setFont(new Font("Calibre", Font.BOLD, 18));
	     alloc_label.setText("Allocate");
	     add(alloc_label);
	     
	     pid_label.setBounds(20,160,500,500);  
	     pid_label.setText("1. Process ID: ");
	     add(pid_label);
	     pid.setBounds(150, 160+240, 70, 20);
	     add(pid);
	     
	     psize_label.setBounds(20,195,700,500);
	     psize_label.setText("2. Process Size: ");
	     add(psize_label);
	     psize.setBounds(150, 195+240, 70, 20);
	     add(psize);
	     
	     addmore.setBounds(80,520,110,30);
	     addmore.addActionListener(this);
	     add(addmore);
	     
	     reset.setBounds(240, 580, 100, 30);
	     reset.addActionListener(this);
	     add(reset);
	     
	     
	     // GUI for REMOVE part...
	     remove_label.setBounds(320, 120, 500, 500);
	     remove_label.setForeground(Color.orange);
	     remove_label.setFont(new Font("Calibre", Font.BOLD, 18));
	     remove_label.setText("Remove");
	     add(remove_label);
	     
	     pid_label_remove.setBounds(320,160,500,500);  
	     pid_label_remove.setText(" Process ID: ");
	     add(pid_label_remove);
	     pid_remove.setBounds(200+235, 160+240, 70, 20);
	     add(pid_remove);
	     
	     remove.setBounds(180+200, 520, 100, 30);
	     remove.addActionListener(this);
	     add(remove);
	   /*  jb_next.setBounds(600,520,80,30);
		 jb_next.addActionListener(this);
		 add(jb_next);*/
		
		 ba.setBounds(600, 200,100,1000);
		 ba.setSize(800, 800);
		 add(ba);
		 ba.getComponentAt(100, 50);
		// status_label.setBounds(700, 250,50,50);
		 //add(status_label);
		 
		
		 
		//ba.setVisible(true);
		 setVisible(true);
		
	}
	
	/*public void paint(Graphics g){
		super.paint(g);
	 	
	 	g.setColor(Color.BLACK);
        g.drawLine(300, 375, 300, 600);
	}
	*/
	int count_addmore=-1;
	
	
	int lastpid=-1;
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

		/*if(o.equals(jb_next))
		{
			
			//JOptionPane.showMessageDialog(null, "Calling to next step");
			//get_new_arraylist_from_controller();  // NEXT PRESSED SO GET NEW ARRAYLIST FROM CONTROLLER
			
			//this.dispose();
			
		}*/

// /*ADDMORE*/
		
//-------------------------------------------------------------
		
		if(o.equals(addmore))
		{	
			this.tot_mem_size.setEditable(false);
			
			int check=0;
			if(Integer.parseInt(this.pid.getText())== lastpid+1){
				JOptionPane.showMessageDialog(null, "VALID PID  :) ");
				check++;
			}
			else{JOptionPane.showMessageDialog(null, "INVALID!!! PID");}
			
//-------------------------------------------------------------
			int psize_value=-1;
			boolean isNumber;
			try{
				  psize_value = Integer.parseInt(this.psize.getText());
				  isNumber= true;
				  // is an integer!
				} catch (NumberFormatException exp) {
				  isNumber= false;
				}
			
			if(isNumber && psize_value>=0){
				JOptionPane.showMessageDialog(null, "VALID Process Size..");
				check++;
			}else{
				JOptionPane.showMessageDialog(null, "INVALID Process size");
			}
//------------------------------------------------------------------
			int totMemorySize=-1;
			boolean isNum;
			try{
				  totMemorySize = Integer.parseInt(this.tot_mem_size.getText());
				  isNum= true;
				  // is an integer!
				} catch (NumberFormatException exp) {
				  isNum= false;
				}
			if(isNum && totMemorySize>=0 ){
				JOptionPane.showMessageDialog(null, "VALID Memory size... ");
				check++;
			} 
			else{
				
				JOptionPane.showMessageDialog(null, "INVALID MEMORY size... ");
				
				}	
			
		//----------------------------------------------------------------------------
			if(check==3){	
				//lastpid= Integer.parseInt(this.pid.getText());
			
			System.out.println("inside repaint");
			mem_size=Integer.parseInt(tot_mem_size.getText());
			tot_mem_size.disable();
			if(flag==0)
			{
			set_size(mem_size);
			flag++;
			}
			System.out.println("totalmemsize"+mem_size+"p_id"+Integer.parseInt(pid.getText())+"p_size"+Integer.parseInt(psize.getText()));
			sending_to_controller_to_add(Integer.parseInt(pid.getText()), Integer.parseInt(psize.getText()));
			pid.setText("");
			psize.setText("");
			//count++;
			
			
			}
		}
//-------------------------------------------------------------------------------------------------
		
// /*REMOVE*/	
		if(o.equals(remove)){		
			int remove_id=-1;
			boolean isNum_remove;
			try{
				 				
				  remove_id = Integer.parseInt(this.pid_remove.getText());
				  isNum_remove= true;
				  // is an integer!
				} catch (NumberFormatException exp) {
				  isNum_remove= false;
				}
			
			if(isNum_remove && remove_id>=0 ){
				//JOptionPane.showMessageDialog(null, "Is VALID ID Process ID... press ok to continue...");
				sending_to_controller_to_remove(Integer.parseInt(this.pid_remove.getText()));
				this.pid_remove.setText(null);	
				this.repaint();
			} 
			else{
				
				JOptionPane.showMessageDialog(null, "ERROR!! NOT VALID ID! pls enter IDs in incremental fashion as 0 1 2....");
				
				} 
			
			
			
			
		}
		

		
/*RESET*/
		if(o.equals(reset)){
			/*Buddy1 b1=new Buddy1();
			tot_mem_size.setEditable(true);
			tot_mem_size.setText(null);
			
			count_addmore=-1;*/
			Main_Buddy.main(null);
		}
		
	}
	
		
		

	
	public void sending_to_controller_to_add(int p_id, int p_size){
		/* A FUNCTION IN CONTROLLER... */
		System.out.println("p_id"+p_id+"p_size"+p_size);
		
		
		 p_info=t.add_process(p_id,p_size);
		if(p_info==null)
		{
			JOptionPane.showMessageDialog(null, "Not Sufficient Memory For!! PID="+p_id+" PSize="+p_size);
		}
		else
		{
			lastpid= Integer.parseInt(this.pid.getText());
			JOptionPane.showMessageDialog(null, "ADDED!! PID="+p_id+" PSize="+p_size);
			ba.set_list(p_info, mem_size);
			this.repaint();
		}//p_info.clear();
		pid_remove.setText(null);
	}
	
	// after sending_to_controller_to_add CONTROLLER will call this function
	
	public void set_size(int mem_size)
	{
		t.set_memSize(mem_size);
	}
	public void sending_to_controller_to_remove(int p_id){
		/* A FUNCTION IN CONTROLLER... */
		
		 p_info=t.remove_process(p_id);
		if(p_info==null)
		{
			JOptionPane.showMessageDialog(null, "There is no process with!! PID="+p_id);
		}
		else
		{
			
			JOptionPane.showMessageDialog(null, "Successfully Removed!! press ok to continue");
			ba.set_list(p_info, mem_size);
			this.repaint();
		}//p_info.clear();
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		for(Process_Detail p:p_info)
        {
        	
        	if((e.getX()>=p.start_address/4+100 && (e.getX()<=p.start_address/4+100+p.p_size))&&(e.getY()>=50 && e.getY()>=120))
        	{
        	
        		 status_label.setText("p_id:"+p.p_id+"\n"+"p_size:"+p.p_size);
        	}
        	else
        	{
        		System.out.println("hello");
        	}
        }
		
	}
	
	
	
	
	
	

}
