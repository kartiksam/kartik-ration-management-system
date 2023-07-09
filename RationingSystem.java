import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;
import java.sql.*;

public class RationingSystem 
{
	static JTextArea EArea = new JTextArea(20,20);
	static JTextArea RArea = new JTextArea();
	static DefaultTableModel Table;
        JTextField t; 
	static String[] columns = {"Ration ID","Name","Father Name","Head of Family","Age","Ward","Village","District","Date of Issue","Address"};
	private HashMap<String, String> Ration = new HashMap<>(), Eligible = new HashMap<>();
	{
		List<Object> values = Arrays.asList(Ration.values().toArray());
		List<Object> keys = Arrays.asList(Ration.keySet().toArray());
		for(int i = 0; i < values.size(); i++)
			Eligible.put(values.get(i).toString(), keys.get(i).toString());
	}

	private String info = "This is a simple Java Application for an E-Ration Shop set up"
		+ "manage the rationing. It uses the components of AWT and Swing GUI for its execution.";

	public RationingSystem() 
	{
               
		EArea.setLineWrap(true);
		EArea.setWrapStyleWord(true);
		EArea.setMargin(new Insets(5, 5, 5,5));
		
		JLabel RLabel = new JLabel("Eligible");
		RLabel.setHorizontalAlignment(SwingConstants.CENTER);
		t=new JTextField(30);
		JButton clearEnglishText = new JButton("Clear Text");
		JButton addRecipient = new JButton("Add the Recipient");
		
		JPanel EligiblePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		EligiblePanel.add(clearEnglishText);
		EligiblePanel.add(addRecipient);
		EligiblePanel.add(t);
		
		JPanel englishTextPanel = new JPanel();
		englishTextPanel.setLayout(new BorderLayout());
		englishTextPanel.add(RLabel, BorderLayout.NORTH);
		englishTextPanel.add(new JScrollPane(EArea), BorderLayout.CENTER);
		englishTextPanel.add(EligiblePanel, BorderLayout.SOUTH);
		
		RArea.setLineWrap(true);
		RArea.setWrapStyleWord(true);
		RArea.setLineWrap(true);
		RArea.setMargin(new Insets(5, 5, 5,5));
		RArea.setFont(new Font("", 0, 20));
		
		JLabel ELabel = new JLabel("Receivers");
		ELabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton deleteRecipient = new JButton("Delete the Recipient");
		JButton clearText = new JButton("Clear Text");
		
		JPanel ControlPanel = new JPanel();
		ControlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ControlPanel.add(deleteRecipient);
		ControlPanel.add(clearText);
		
		JPanel TextPanel = new JPanel();
		TextPanel.setLayout(new BorderLayout());
		TextPanel.add(ELabel, BorderLayout.NORTH);
		TextPanel.add(new JScrollPane(RArea), BorderLayout.CENTER);
		TextPanel.add(ControlPanel, BorderLayout.SOUTH);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, englishTextPanel, TextPanel);
		splitPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JTextArea infoTextArea = new JTextArea();
		infoTextArea.setLineWrap(true);
		infoTextArea.setWrapStyleWord(true);
		infoTextArea.setText(info);
		infoTextArea.setBackground(new Color(241,241,241));
		infoTextArea.setEditable(false);
		infoTextArea.setMargin(new Insets(5, 5, 5,5));
		
		JPanel infoPanel = new JPanel(new BorderLayout());
		infoPanel.add(infoTextArea, BorderLayout.CENTER);
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(infoPanel, BorderLayout.NORTH);
		mainPanel.add(splitPane, BorderLayout.CENTER);
		
		addRecipient.addActionListener((e) -> 
		{
			String english = EArea.getText().trim();
			RArea.setText(Test(english));
		});
		
		deleteRecipient.addActionListener((e) -> 
		{
			String morse = RArea.getText().trim();
			EArea.setText(Test2(morse));
		});
		
		EArea.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(Character.isWhitespace(e.getKeyChar()) || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) 
					RArea.setText(Test(EArea.getText()));    
			}
		});

		RArea.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
            if(Character.isWhitespace(e.getKeyChar()) || e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                EArea.setText(Test2(RArea.getText()));
			}
		});

		clearEnglishText.addActionListener((e) -> {
			EArea.setText(null);
		});

		clearText.addActionListener((e) -> {
			RArea.setText(null);
		});

		JFrame frame = new JFrame();
		frame.setTitle("E-RATION SHOP");
	    frame.setLayout(new BorderLayout());
	    frame.add(mainPanel, BorderLayout.CENTER);
	    frame.setSize(new Dimension(800, 650));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
	    frame.setVisible(true);
	
	    splitPane.setDividerLocation(frame.getWidth() / 2);
	    addRecipient.doClick();
	    
		}
		public String Test(String englishWord) {
		    StringBuffer buffer = new StringBuffer();
		    Stream.of(englishWord.split("[ \n]"))
		            .forEach( s -> {
	//	                System.out.println("s = " + s);
		                for(char c: s.toCharArray()) {
	//	                    String v = Ration.containsKey(String.valueOf(c).toUpperCase()) ? Ration.get(String.valueOf(c).toUpperCase()) : " [error] ";
	//	                    System.out.println(c + "  == " + v);
		                    buffer.append(Ration.containsKey(String.valueOf(c).toUpperCase()) ? Ration.get(String.valueOf(c).toUpperCase()) + " " : "?? ");
		                }
		                buffer.append(" / ");
		            });
		    return buffer.toString();
		}
	
	
		public String Test2(String morseWord) {
		    StringBuffer buffer = new StringBuffer();
		    Stream.of(morseWord.split("[\\s\\n]"))
		            .filter((s) -> s != null && !s.isEmpty())
		            .forEach( s -> {
	//	                    System.out.println("s == " + s);
		                    if(s.equalsIgnoreCase("/") || s.equalsIgnoreCase("|")) {
		                        buffer.append(" ");
		                    } else {
	//	                        String v = Eligible.containsKey(s) ? Eligible.get(s) : "?? ";
	//	                        System.out.println(s + " === " + v);
		                        buffer.append((Eligible.containsKey(s) ? Eligible.get(s) : "?? ").toLowerCase());
		                    }
		            });
		    return buffer.toString();
		}
	
		public static void main(String[] args) 
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/k1","root","22Sharma@88");
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 0);
				/*String sql = "INSERT INTO RationSystem VALUES (1214624, 'Ram Kishan', 'Manoj Kishan', 'Nirmal Devi Kishan', 28, 0010, 'Amwa', 'Gorakhpur', '2019-12-02', 'A-2/2, Gorakhpur')";
				stmt.executeUpdate(sql);*/
		        ResultSet R = stmt.executeQuery("SELECT * FROM ration where name=t.getText()");
		        ResultSetMetaData rsmd = R.getMetaData();
		        int col = rsmd.getColumnCount();
		        while (R.next())
		        {
		        	for (int i=1;i<=col;i++)
		        	{
		        		String s = R.getString(col);
		        		EArea.setText(s);
		        	}
		        }
			}
			catch (Exception e) {
				System.out.println(e);
		        e.printStackTrace();
		    }
		
		    SwingUtilities.invokeLater(() -> {
		        new RationingSystem();
		    });
		}
}
