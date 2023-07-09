package projecttttttt;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class register extends JFrame{
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	
	JTextField t1;
	JTextField t2;
	JTextField t3;
	JTextField t4;
	JTextField t5;
	JPasswordField t6;
	JButton b1;
	public  JPanel contentPane;	
	 public register(){
		 JFrame jfrm=new JFrame("a simple login application"); 
		 jfrm.setSize(275,100);
		 jfrm.setVisible(true);
		 jfrm.setLayout(new FlowLayout());
		 contentPane=new JPanel();
		 jfrm.getContentPane().setBackground(Color.white);
		 
		 l1=new JLabel("firstname");
		 l2=new JLabel("lastname");
		 l3=new JLabel("email");
		 l4=new JLabel("mobile number");
		 l5=new JLabel("address");
		 l6=new JLabel("password");
		 t1=new JTextField(30);
		 t2=new JTextField(30);
		 t3=new JTextField(30);
		 t4=new JTextField(30);
		 t5=new JTextField(30);
		 t6=new JPasswordField(30);
	b1=new JButton("regsiter");
		 
	jfrm.add(l1);
	jfrm.add(l2);
	jfrm.add(l3);
	jfrm.add(l4);
	jfrm.add(l5);
	jfrm.add(l6);

	jfrm.add(t1);
	jfrm.add(t2);
	jfrm.add(t3);
	jfrm.add(t4);
	jfrm.add(t5);
	jfrm.add(t6);
	jfrm.add(b1);
	
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			String fname=t1.getText();
					String lname=t2.getText();
			
					String email=t3.getText();
					
					String mobile=t4.getText();
					
					String add=t5.getText();
					String passs=t6.getText();
					int len=mobile.length();
					String msg=" "+fname;
					msg+="\n";
					if(len!=10) {
						JOptionPane.showMessageDialog(b1,"enter a valid mobile number");
					}
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/log";
				String un="root";
				String pass="22Sharma@88";
				Connection con=DriverManager.getConnection(url,un,pass);
				
String insert="insert into register values('" +fname +"','" +lname + "','" +email +"','" +mobile +"','" +add +"','" +passs +"')";
Statement sta=con.createStatement();
int x=sta.executeUpdate(insert);
if(x==0) {
	JOptionPane.showMessageDialog(b1,"this is already exist");
}
else {
	JOptionPane.showMessageDialog(b1,"welcome ,"+msg+"your account is succesfully created");
}

				

				}
				catch(Exception e)
				{
				e.printStackTrace();

				}
		}});
	
	
	
	
	 }
			
			
			
			
			
			
		
	
}
	
	
	
		 
		 	 
	
	
	
	
	
	
	

