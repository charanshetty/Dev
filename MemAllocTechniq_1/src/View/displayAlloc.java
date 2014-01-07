package View;

import java.util.ArrayList;

import org.iiitb.model.bean.InvalidMemoryUnitException;



import Controller.Controller;

import java.awt.event.*;

import javax.swing.*;

import Model.Fragment;       // Also v can keep a 1 copy of Fragment class in VIEW itself...
import Model.process;


// Did this 1 just for testing code


public  class displayAlloc extends JFrame implements ActionListener{ 
	static boolean flag=false;

	Controller c = new Controller();

	//setTitle("Process entry Portal");
	static int l=0;
	JLabel pnumber;
	JLabel mem_required;
	JButton Next;
	JButton Finish;
	JTextField process_id;
	JTextField RequiredSize;

process p =new process();
static ArrayList<process> processes = new ArrayList<>();
void AddProcess(){
	setLayout(null);

pnumber = new JLabel("Process Number");
pnumber.setBounds(10, 20, 250,20);
process_id = new JTextField();
process_id.setBounds(260,20,100,60);
mem_required = new JLabel("Memory required for the process");
mem_required.setBounds(10, 150, 250,20);
RequiredSize = new JTextField();
RequiredSize.setBounds(260,150,100,60);
add(pnumber);
add(process_id);
add(mem_required);
add(RequiredSize);
Next= new JButton("Add");
Next.addActionListener(this);
add(Next);
Next.setBounds(120,300,100,30);
Finish = new JButton("Finish");
Finish.addActionListener(this);
Finish.setBounds(360,300,100,30);
add(Finish);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("Process entry Portal");
setSize(600,450);
setVisible(true);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	try{
		Object o =arg0.getSource();
		if(o.equals(Next)){
	process p =new process();
	if((Integer.parseInt(process_id.getText())>=0)&&(Integer.parseInt(RequiredSize.getText())>0)){
	//System.out.println(Integer.parseInt(process_id.getText()));
		p.setProcess_id(Integer.parseInt(process_id.getText()));
	p.setMem_size(Integer.parseInt(RequiredSize.getText()));
	processes.add(p);
	c.input_from_View_to_Controller(1,processes);
	}
	else 
	{		JOptionPane.showMessageDialog(this,"Invalid processID or memory size");
	}
	
	process_id.setText(null); 
	RequiredSize.setText(null);
	}
	else if(o.equals(Finish)){
		process p =new process();
		if((Integer.parseInt(process_id.getText())>=0)&&(Integer.parseInt(RequiredSize.getText())>0)){
		p.setProcess_id(Integer.parseInt(process_id.getText()));
		p.setMem_size(Integer.parseInt(RequiredSize.getText()));
		processes.add(p);
		c.input_from_View_to_Controller(1,processes);
		}
		else 
		{		JOptionPane.showMessageDialog(this,"Invalid processID or memory size");
		}
		
		setVisible(false);
		flag=true;
		dispose();}}
	catch(Exception ex)
	{
		JOptionPane.showMessageDialog(this,"Error occurred!!!"+ex);
JOptionPane.showMessageDialog(this,"Error occurred!!!"+ex);
	}
	// TODO Auto-generated method stub
	
	
}
	// This is just a helper function... Youextends FirstFitAlgorithm(Mayur) can modify this function as per requirementssss...
	
	// 
	public void output_from_Controller_to_View(ArrayList <Fragment> fragments, int[] mem_not_all, int count,ArrayList <process> processes)
	{
		System.out.println("print here");
		System.out.println("=========================IN VIEW=================================================");
		System.out.print("AVAILABLE MEMORY BLOCKS ARE : ");
		for (Fragment unit : fragments) 
		{
		//	System.out.print(unit.getMemsize()+" ");
		}

		System.out.println();
		
		for (Fragment unit : fragments)
		{
			if (unit.status == true) 
			{
//				for (int i=0;i<in.length;i++){
//					if(in[i]==(unit.getMemsize()-unit.getRemaini ng_size())){
				System.out.print("Allocated memory block no. "+unit.getFragment_id()+" with size "+unit.getMemsize()+" to process P"+unit.getProcess_id()+" with size "+(unit.getMemsize()-unit.getRemaining_size()));
				
				System.out.println(",,, Remaining fragment Size : "+ unit.getRemaining_size());
//				}}
			}

		}
		//for loop showing 
		System.out.println("count "+count);
		for(int i = 0; i < count; i++) 
		{  				for (int x=0;x<processes.size();x++){
			if(processes.get(x).getMem_size()==mem_not_all[i]){

			System.out.println("This Process P"+processes.get(x).getProcess_id()+" HAS NOT BEEN ALLOCATED MEMORY : "+ mem_not_all[i]);
		} }}
		
		System.out.println("~~~~~~~~~~~~END OF ALGO~~~~~~~~~~~~~~\n\n");

	}

	
	// for a time being i kept main in VIEW but v can shift it in Controller back after completing remaining part
	public static void main(String args[]) throws InvalidMemoryUnitException
	{
		displayAlloc x=new displayAlloc();
		x.AddProcess();		
		
	}
}