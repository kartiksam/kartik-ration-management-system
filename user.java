package projecttttttt;

	import java.awt.*;
	import javax.swing.*;
	import java.awt.event.*;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	public class user extends JFrame{
		JLabel l1;
		JLabel l2;
		JLabel l3;
		JLabel l4;
		JLabel l5;
		JLabel l6;
		
		JTextField t1;
		JTextField t2;
		
		JButton btn1;
		public  JPanel contentPane;	
	
	public user() {
		
		
		 JFrame jfrm=new JFrame("a simple login application"); 
		 jfrm.setSize(275,100);
		 jfrm.setVisible(true);
		 jfrm.setLayout(new FlowLayout());
		 contentPane=new JPanel();

		 jfrm.getContentPane().setBackground(Color.blue);
		
		
		JLabel l1=new JLabel(" enter your ration card number");
	JLabel l2=new JLabel("enter mobile number");
	 
	 JLabel l4=new JLabel("OTP");
	 
	jfrm.add(l1);
	jfrm.add(l2);
	
	jfrm.add(l4);
	
	//adding window liosteer
	

	JButton btn1=new JButton("generate otp");
	
	jfrm.add(btn1);
final JTextField  t1=new JTextField(16);
	final JTextField t2=new JTextField(14);
	jfrm.add(t1);
	jfrm.add(t2);
	
	//adding listener
btn1.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent ae){
			String number=t1.getText();
			String contact=t2.getText();
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/log";
				String un="root";
				String pass="22Sharma@88";
				Connection con=DriverManager.getConnection(url,un,pass);
				
String insert="insert into user values('" +number+"','" +contact + "')";
Statement sta=con.createStatement();
int x=sta.executeUpdate(insert);


				

				}
				catch(Exception e)
				{
				e.printStackTrace();

				}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			OTP o=new OTP();
			
			
			
		}
	});
	
	
	}
	
}
