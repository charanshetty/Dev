package View;


import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.iiitb.model.bean.InvalidMemoryUnitException;

import Controller.Controller;
import Model.FirstFitAlgorithm;
import Model.Fragment;
import Model.process;

public class View_FragMain extends JFrame implements ActionListener{
	
   
	ArrayList<process> p_info;
	process t = new process();
	// This is page 1 for Buddy System...
	Fragment f=new Fragment();
	ArrayList<Fragment> fragments = new ArrayList<>();
	Controller c = new Controller();
		View_Fragment vf=new View_Fragment();
		View_Fragment1 vf1=new View_Fragment1();
		View_Fragment2 vf2=new View_Fragment2();
		View_Fragment3 vf3=new View_Fragment3();
		JTextArea result = new JTextArea(15,20);
		JTextArea result1 = new JTextArea(15,20);
		JTextArea result2 = new JTextArea(15,20);
		JTextArea result3 = new JTextArea(15,20);
		FirstFitAlgorithm  ff=new FirstFitAlgorithm ();
		static ArrayList<process> processes = new ArrayList<>();
		private static final long serialVersionUID = 1L;
		static public int count=1;
		static int flag=0;
		int mem_size;
		String pid_string, psize_string;
		JLabel color_code=new JLabel();
		JLabel occupy=new JLabel();
		JLabel empty=new JLabel();
		JLabel empty_frag=new JLabel();
		
		JTextField occupy_color=new JTextField();
		JTextField empty_color=new JTextField();
		JTextField empty_frag_color=new JTextField();
		
		JLabel welcome=new JLabel();
		JLabel prompt= new JLabel();
		JLabel status_label=new JLabel();
		JLabel tot_mem_size_label= new JLabel();
		JLabel pid_label= new JLabel();
		JLabel partitions= new JLabel();
		JLabel partition1= new JLabel();
		JLabel partition2= new JLabel();
		JLabel partition3= new JLabel();
		JLabel partition4= new JLabel();
		JLabel Firstfit= new JLabel();
		JLabel BestFit= new JLabel();
		JLabel NextFit= new JLabel();
		JLabel WorstFit= new JLabel();
		JLabel psize_label= new JLabel();
		JLabel alloc_or_remove_label= new JLabel();
		JLabel alloc_or_remove_label1=new JLabel();
		JLabel alloc_label=new JLabel();
		JTextField tot_mem_size= new JTextField();
		JTextField pid= new JTextField();
		JTextField psize= new JTextField();
		JCheckBox c1=new JCheckBox("FirstFit");
		JCheckBox c2=new JCheckBox("BestFit");
		JCheckBox c3=new JCheckBox("NextFit");
		JCheckBox c4=new JCheckBox("WorstFit");
		JButton jb_next=new JButton("NEXT");
		JButton jb_close= new JButton("CLOSE");
		JButton addmore= new JButton("Add More");
		//---remove  operation
		JLabel remove_label=new JLabel();
		JLabel pid_label_remove=new JLabel();
		JTextField pid_remove= new JTextField();
		JButton remove= new JButton("Remove"); 
		public View_FragMain(){
			init();	 
		}
		void init(){
			 setTitle("SIMULATION FOR CONTIGIOUS MEMORY ALLOCATION...");
		     setSize(2500,2500);
		     setLocationRelativeTo(null);
		     setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLayout(null);
			 
			 welcome.setBounds(450, 20,1000, 100);
			 welcome.setForeground(Color.BLUE);
		     welcome.setFont(new Font("Calibre", Font.BOLD, 22));
		     welcome.setText("WELCOME TO CONTIGIOUS MEMORY SIMULATOR....");
		     add(welcome);
			 
		     prompt.setBounds(10, 50,1000,50);
		   
		     prompt.setForeground(Color.RED);
		     prompt.setFont(new Font("Calibre", Font.PLAIN, 18));
		     prompt.setText("Please Enter the below details...");
		     add(prompt);
		     
		     tot_mem_size_label.setBounds(20, 130, 300, 50);
		     tot_mem_size_label.setText("Total size of Main Memory (Bytes): ");
		     add(tot_mem_size_label);
		     tot_mem_size.setBounds(320, 140, 70, 25);
		     tot_mem_size.setText("1024");
		     tot_mem_size.disable();
		     add(tot_mem_size);
		     
		     c1.setBounds(20,180,100,40);
		     c1.setText("FirstFit");
		     add(c1);
		     color_code.setBounds(200, 180,100,40);
		     color_code.setText("Color_Codes:");
		     add(color_code);
		     c2.setBounds(20,220,100,40);
		     c2.setText("BestFit");
		     add(c2);
		     occupy.setBounds(200, 220,150,40);
		     occupy.setText("Allocated memory:");
		     add(occupy);
		     occupy_color.setBounds(350, 230,20,20);
		     
		     occupy_color.setBackground(Color.BLUE);
		     occupy_color.setVisible(true);
		     add(occupy_color);
		     c3.setBounds(20,260,100,40);
		     c3.setText("NextFit");
		     add(c3);
		     empty.setBounds(200, 260,150,40);
		     empty.setText("Internal Fragmentation:");
		     add(empty);
		    empty_color.setBounds(350, 270,20,20);
		     empty_color.setBackground(Color.RED);
		     add(empty_color);
		     c4.setBounds(20,300,100,40);
		     c4.setText("WorstFit");
		     add(c4);
		     empty_frag.setBounds(200,300,150,40);
		     empty_frag.setText("Unallocated Partition:");
		     add(empty_frag);
		   empty_frag_color.setBounds(350,300,20,20);
		     empty_frag_color.setBackground(Color.GRAY);
		     add(empty_frag_color);
		     // ALLOCATE PART..
		     alloc_label.setBounds(30, 120, 500, 500);
		     alloc_label.setForeground(Color.orange);
		     alloc_label.setFont(new Font("Calibre", Font.BOLD, 18));
		     alloc_label.setText("Allocate");
		     add(alloc_label);
	     
		     pid_label.setBounds(20,160,100,500);  
		     pid_label.setText("1. Process ID: ");
		     add(pid_label);
		     pid.setBounds(150, 160+240, 70, 20);
		     add(pid);
		     
		     psize_label.setBounds(20,195,700,500);
		     psize_label.setText("2. Process Size: ");
		     add(psize_label);
		     psize.setBounds(150, 195+240, 70, 20);
		     add(psize);
		     
		     
		     psize_label.setText("2. Process Size: ");
		     add(psize_label);
		     addmore.setBounds(80,520,110,30);
		     addmore.addActionListener(this);
		     add(addmore);
		     partitions.setBounds(60,540,200,80);  
		     partitions.setText("Available partitions  :  4");
		     add(partitions);
		     partition1.setBounds(60,560,200,80);  
		     partition1.setText("Partition 1 size  :   132");
		     add(partition1);
		     partition2.setVisible(true);
		     partition2.setBounds(60,580,200,80);  
		     partition2.setText("Partition 2 size  :   258");
		     add(partition2);
		     partition3.setVisible(true);
		     partition3.setBounds(60,600,200,80);  
		     partition3.setText("Partition 3 size  :   110");
		     add(partition3);
		     partition4.setVisible(true);
		     partition4.setBounds(60,620,200,80);  
		     partition4.setText("Partition 4 size  :   524");
		     add(partition4);
		     partition1.setVisible(true);
		     
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
		    
		     Firstfit.setBounds(700,90,500,20);  
		     Firstfit.setText("FirstFit ");
		     add(Firstfit);
		     
		
			vf.setBounds(600, 100,400,150);
			JScrollPane scr0 = new JScrollPane(result);
			scr0.setBounds(1010, 130, 220, 80);
			add(scr0, BorderLayout.CENTER);
			scr0.validate();
			scr0.setVisible(true);
		//	vf.setSize(400,400);
			 add(vf);
			 BestFit.setBounds(700,240,500,20);  
		     BestFit.setText("BestFit ");
		     add(BestFit);
			vf1.setBounds(600,250,1000,150);
			//vf1.setSize(800, 800);
			 add(vf1);
				//result.setBounds(1010, 130, 220, 80);
//				scr.setPreferredSize(new Dimension(220, 880)); 
				JScrollPane scr = new JScrollPane(result1);
				scr.setBounds(1010, 300, 220, 80);
				add(scr, BorderLayout.CENTER);
				scr.validate();
				scr.setVisible(true);
						 vf2.setBounds(600,400,1000,150);
				 NextFit.setBounds(700,390,500,20);  
			     NextFit.setText("NextFit ");
			     add(NextFit);
			     JScrollPane scr1 = new JScrollPane(result2);
					scr1.setBounds(1010, 470, 220, 80);
					add(scr1, BorderLayout.CENTER);
					scr1.validate();
					scr1.setVisible(true);
				 add(vf2);
	                
				// scr.add(result);
				// pack();
				 WorstFit.setBounds(700,540,500,20);  
			     WorstFit.setText("WorstFit ");
			     add(WorstFit);
				 vf3.setBounds(600,550,1000,150);
					//vf1.setSize(800, 800);
				 JScrollPane scr2 = new JScrollPane(result3);
					scr2.setBounds(1010, 600, 220, 80);
					add(scr2, BorderLayout.CENTER);
					scr2.validate();
					scr2.setVisible(true);
					 add(vf3);
					 partitions.setVisible(true);
					Firstfit.setVisible(true);
					BestFit.setVisible(true);
					WorstFit.setVisible(true);
					NextFit.setVisible(true);
			vf.setVisible(true);
			vf1.setVisible(true);
			vf2.setVisible(true);
			vf3.setVisible(true);
			 setVisible(true);
			
		}
		
		
		int count_addmore=-1;
		int tmp;
		
		int lastpid=-1;
		
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object o = e.getSource();

		
	// /*ADDMORE*/
			
	//-------------------------------------------------------------
			
			if(o.equals(addmore))
			{	
				
				this.tot_mem_size.setEditable(false);
				int ert =0;
				boolean isx;
				int check=0;
				try{
					ert = Integer.parseInt(this.pid.getText());
					isx=true;
				}
				 catch (NumberFormatException exp) {
					  isx= false;
					}
				if((ert == (lastpid+1))||(isx)){
				//	JOptionPane.showMessageDialo(g(null, "VALID PID  :) ");
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
				//	JOptionPane.showMessageDialog(null, "VALID Process Size..");
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
					//JOptionPane.showMessageDialog(null, "VALID Memory size... ");
					check++;
				} 
				else{
					
					JOptionPane.showMessageDialog(null, "INVALID MEMORY size... ");
					
					}	
				
			//----------------------------------------------------------------------------
				if(check==3){	
					//lastpid= Integer.parseInt(this.pid.getText());
				
				//System.out.println("inside repaint");
				mem_size=Integer.parseInt(tot_mem_size.getText());
				tot_mem_size.disable();
				if(flag==0)
				{
				f.set_Size(mem_size);
				flag++;
				}
				System.out.println("totalmemsize"+mem_size+"p_id"+Integer.parseInt(pid.getText())+"p_size"+Integer.parseInt(psize.getText()));
				process p =new process();
				tmp = Integer.parseInt(pid.getText());
				p.setProcess_id(Integer.parseInt(pid.getText()));
				p.setMem_size(Integer.parseInt(psize.getText()));
				p.setBf_status(false);
				p.setFf_status(false);
				processes.add(p);
				try {
					pid.setText("");
					psize.setText("");
					//count++;
					lastpid++;
					if(c1.isSelected())
					{
						//c1.setD;
					ArrayList <Fragment> f=c.input_from_View_to_Controller(1,processes);
					vf.set_list(f,mem_size);
				
					//result.setText("Allocated fragment "+f.size());
					
					}
	                boolean flag1=processes.get(tmp).isFf_status();				
					insertlog(flag1,result);
					
					System.out.println("-----------------------------------------------------");
				//	vf.update_Textarea();
					vf.updateUI();
					if(c2.isSelected())
					{
					c2.disable();
					ArrayList <Fragment> f1=c.input_from_View_to_Controller(2,processes);
					vf1.set_list(f1,mem_size);
					boolean flag2=processes.get(tmp).isBf_status();				
					insertlog(flag2,result1);
					}
					System.out.println("-----------------------------------------------------");
					//vf1.update_Textarea();
					vf1.updateUI();
					if(c3.isSelected())
					{
					//c2.disable();
					ArrayList <Fragment> f1=c.input_from_View_to_Controller(3,processes);
					vf2.set_list(f1,mem_size);
					boolean flag3=processes.get(tmp).isNf_status();				
					insertlog(flag3,result2);
					}
					vf2.updateUI();
					if(c4.isSelected())
					{
					//c2.disable();
					ArrayList <Fragment> f1=c.input_from_View_to_Controller(4,processes);
					vf3.set_list(f1,mem_size);
					boolean flag4=processes.get(tmp).isWf_status();				
					insertlog(flag4,result3);
					}
					vf3.updateUI();
					//this.repaint();
					//c.input_from_View_to_Controller(1,processes);
					
				} catch (InvalidMemoryUnitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//sending_to_controller_to_add(Integer.parseInt(pid.getText()), Integer.parseInt(psize.getText()));
				
				
				}}

			// /*REMOVE*/	
					if(o.equals(remove)){		
						int remove_id=-1;
						boolean isNum_remove;
						try{
							 				
							  remove_id = Integer.parseInt(this.pid_remove.getText());
							  pid_remove.setText(null);
								JOptionPane.showMessageDialog(null, "Is VALID ID Process ID... press ok to continue...");

							  isNum_remove= true;
							  // is an integer!
							} catch (NumberFormatException exp) {
							  isNum_remove= false;
							  
							}
						
						if(isNum_remove && remove_id>=0 ){
							sending_to_controller_to_remove(remove_id);
							
						} 
						else
							JOptionPane.showMessageDialog(null, "ERROR!! NOT VALID ID! pls enter IDs in incremental fashion as 0 1 2....");
					}
	
		}

void insertlog(boolean flagx,JTextArea resultx){
	if(flagx)
	{
		resultx.append("Added process_id: " +processes.get(tmp).getProcess_id()+"\n");
		//add(result);
		resultx.setVisible(true);
	}
	else if(!flagx)
	{
		
		resultx.append("process_id: "+processes.get(tmp).getProcess_id()+" not allocated with  process_size: "+processes.get(tmp).getMem_size()+"\n");
		//add(result);
		resultx.setVisible(true);
	}

}

		public void sending_to_controller_to_remove(int p_id) {
			/* A FUNCTION IN CONTROLLER... */
			
			for (int i =0;i<processes.size();i++){
//			 System.out.println(processes.get(i).getProcess_id());
			if(p_id==processes.get(i).getProcess_id())
			{
				
				processes.remove(p_id);
				if(c1.isSelected())
				result.append("Removed process_id: "+p_id+"\n");
				if(c2.isSelected())
				result1.append("Removed process_id: "+p_id+"\n");
				if(c3.isSelected())
				result2.append("Removed process_id: "+p_id+"\n");
				if(c4.isSelected())
				result3.append("Removed process_id: "+p_id+"\n");
				//add(result);
				result.setVisible(true);
				
				try {
					ArrayList<Fragment> f = c.clear_input_from_View_to_Controller(1,p_id);
				
				vf.set_list(f,mem_size);
				vf.updateUI();
				ArrayList <Fragment> f1=c.clear_input_from_View_to_Controller(2,p_id);
				vf1.set_list(f1,mem_size);
				vf1.updateUI();
				f1=c.clear_input_from_View_to_Controller(3,p_id);
				vf2.set_list(f1,mem_size);
				vf2.updateUI();
				f1=c.clear_input_from_View_to_Controller(4,p_id);
				vf3.set_list(f1,mem_size);
				vf3.updateUI();
				for( Fragment v :fragments){
					System.out.println("after delete" +v.getProcess_id());
				}
				} catch (InvalidMemoryUnitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Successfully Removed!! press ok to continue");
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "There is no process with!! PID="+p_id);
				
				
			}//p_info.clear();
			
		}	
	
		
		}}

