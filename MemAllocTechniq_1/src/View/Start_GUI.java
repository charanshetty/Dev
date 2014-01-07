package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.acl.Group;
import java.util.prefs.BackingStoreException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Start_GUI extends JFrame implements ActionListener {
	
	//JFrame frame = new JFrame("MAIN FRAME!!!!");
	
	private JPanel contentPane;  
	
	JLabel wel=new JLabel();
	
	JRadioButton all= new JRadioButton("MEMORY ALLOCATION TECHNIQUES" );
	JRadioButton bud=new JRadioButton("BUDDY SYSTEM");
	ButtonGroup group = new ButtonGroup();
//	JLabel background=new JLabel(new ImageIcon("//home//nauman//Desktop//img.jpg"));
	
	
	JButton go =new JButton("GO!!");
		
	
	

	public Start_GUI() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	
	
	void init()
	{
		
		
	/*	contentPane = new JPanel() {  
			                 public void paintComponent(Graphics g) {  
			                      Image img = Toolkit.getDefaultToolkit().getImage(  
			                                Start_GUI.class.getResource("/home/Desktop/nauman/img.jpg"));  
			                      g.drawImage(img, 0, 0, 800, 800, this);  
			                 }  
			            }; 
			            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
			            contentPane.setLayout(new BorderLayout(0, 0));  
			            setContentPane(contentPane);  
		*/
		
		
		
	//	setLayout(new BorderLayout());
	//	JLabel background=new JLabel(new ImageIcon("/home/nauman/Desktop/img.jpg"));
		
//		background.setSize(800, 800);
		
//		background.setLayout(new FlowLayout());
//		add(background);
		
		setSize(1000,1000);
	   setLocationRelativeTo(null);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		
		wel.setBounds(275, 20,500, 100);
		wel.setForeground(Color.BLUE);
	    wel.setFont(new Font("Calibre", Font.BOLD, 22));
		wel.setText("WELCOME TO THE SIMULATOR!!!");
		add(wel);
		
		
		
		
		group.add(all);
		group.add(bud);
		all.setBounds(100, 300, 1000, 30);
		bud.setBounds(100, 350, 1000, 30);
		this.add(all);
		this.add(bud);
		all.addActionListener(this);
		bud.addActionListener(this);
		
		
		
		go.setBounds(200, 500, 100, 30);
		add(go);
		go.addActionListener(this);
		this.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Object o = arg0.getSource();
		
		if(o.equals(go))
		{
			if(all.isSelected()==true)
			{
				
				//System.exit(0);
				View_FragMain x=new View_FragMain();
			}
			if(bud.isSelected())
			{
				// connect BUDDY SYSTEM here....
			}
		}
		
		
	}
	

}
