package projecttttttt;
import javax.swing.*;
import java.security.SecureRandom;
import java.math.BigInteger;
import java.awt.*;
import java.awt.event.*;
public class OTP extends JFrame{
	JLabel l1;
	JTextField t1;
	
	public static String gen() {
		int rand=(int) (Math.random()*9000)+1000;
		String otp=String.valueOf(rand);
		
		return otp ;
		
		
		
	}
   public  OTP (){
	   JFrame jfrm=new JFrame(" OTP GENERARTION"); 
		 jfrm.setSize(275,100);
		 jfrm.setVisible(true);
		 jfrm.setLayout(new FlowLayout());
		 jfrm.getContentPane().setBackground(Color.pink);
		 JLabel l1=new JLabel("your otp is");
		 JTextField t1=new JTextField(5);
       jfrm.add(l1);
       jfrm.add(t1);
       String s=gen();
       t1.setText(s);
       
       
    }
   
   
  }
    
    
    
    
    
