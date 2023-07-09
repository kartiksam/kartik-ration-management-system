package projecttttttt;
import javax.swing.*;


import java.sql.*;
	import java.awt.*;
	import java.awt.event.*;
	public class login extends JFrame{
		JTextField user;
		JPasswordField	pass;
		 JFrame jfrm;

	
	public JPanel contentPane;
	
	 login(){
		 
		 JFrame jfrm=new JFrame("a simple login application"); 
		 jfrm.setSize(275,100);
		 jfrm.setVisible(true);
		 jfrm.setLayout(new FlowLayout());
		 jfrm.getContentPane().setBackground(Color.white);
		 contentPane=new JPanel();

	
		
		user=new JTextField(30);
	user.setBounds(110, 15, 200, 30);
		pass=new JPasswordField(30);
		pass.setBounds(110, 50, 200, 30);
		JLabel l1=new JLabel("rationnid");
		 l1.setBounds(30,15, 100,30);
	JLabel l2=new JLabel("password");
	 l2.setBounds(30,40, 100,30);
	 JLabel l3=new JLabel("don'n have an acocunt");
	 l1.setBounds(30,65, 100,30);
	 JLabel l4=new JLabel("register now");
	 l1.setBounds(30,95, 100,30);
	jfrm.add(l1);
	jfrm.add(l2);
	jfrm.add(l3);
	jfrm.add(l4);
	jfrm.add(user);
	jfrm.add(pass);

	//adding window liosteer
	

	JButton btn1=new JButton("login");
	JButton btn2=new JButton("reset");
	JButton btn3=new JButton("register now");
	jfrm.add(btn1);
	jfrm.add(btn2);
	jfrm.add(btn3);
	
	
	btn1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){

	  String username = user.getText(); //Store username entered by the user in the variable "username"
      String password = pass.getText(); //Store password entered by the user in the variable "password"
       
      if(username.equals("")) //If username is null
      {
          JOptionPane.showMessageDialog(null,"Please enter username"); //Display dialog box with the message
      } 
      else if(password.equals("")) //If password is null
      {
          JOptionPane.showMessageDialog(null,"Please enter password"); //Display dialog box with the message
      }
      else 
    	  
    	  
	try{
	
	//String q="create table logdetail(sno int(5) primary key auto_increment,username varchar(100),password varchar(100))";
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/log";
		String un="root";
		String pass="22Sharma@88";
		Connection con=DriverManager.getConnection(url,un,pass);
		 Statement stmt = con.createStatement();
         stmt.executeUpdate("USE log"); //Use the database with the name "Library"
         String st = ("SELECT * FROM register WHERE First_name='"+username+"' AND country='"+password+"'"); //Retreive username and passwords from users first name is col name 
         ResultSet rs = stmt.executeQuery(st); //Execute query
     //problem only one is ruuning
        
        
             //Move the pointer 
           while(rs.next())
           {
             String admin = rs.getString("First_name"); //user is admin sql tale col no
             //System.out.println(admin);
             String UID = rs.getString("country"); //Get user ID of the user
             if(admin.equals(username)&&UID.equals(password)) { //If boolean value 1
            	 JOptionPane.showMessageDialog(null,"Welcome to user portal"); //Display Message

            	 user u=new user();
            	 //redirect to admin menu
             }
            
         }}
         
	

      
	catch(Exception e)
	{
	e.printStackTrace();

	}



  
	

	}});


	btn2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
	user.setText(null);
	pass.setText(null);
	}});
	
	btn3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
		register r =new register();
		}});
	
	
	
	
	}
	//open a new window 
public 	 login(String str,String str2){
		 
		 JFrame jfrm=new JFrame("a simple login application"); 
		 jfrm.setSize(275,100);
		 jfrm.setLayout(new FlowLayout());
		 jfrm.setVisible(true);
		 jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 contentPane=new JPanel();
	JLabel l3=new JLabel("user name");
	l3.setBounds(20,50,80,20);
	JLabel l4=new JLabel(str);

	JLabel l5=new JLabel("password");
	l3.setBounds(20,50,80,20);
	JLabel l6=new JLabel(str2);
	jfrm.add(l3);
	jfrm.add(l4);
	jfrm.add(l5);
	jfrm.add(l6);
	
	}

	}
	
 
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
