package View;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class RegView {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextPane tabOneUserName;
	private JPasswordField tabOnePassword;
	private JButton logIn;
	private JTextPane firstName;
	private JTextPane lastName;
	private JTextPane tabTwoUserName;
	private JTextPane phone;
	private JTextPane address;
	private JTextPane email;
	private JTextPane tabTwoPassword;
	private JButton submit;
	private JTabbedPane tabbedPane;
	/**
	 * Create the application.
	 */
	public RegView() {
		this.frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.frame.setResizable(false);
		this.frame.setBounds(100, 100, 854, 573);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		 tabbedPane.setBackground(Color.LIGHT_GRAY);
		 tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		this.frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addTab("Sign In", null, this.panel, null);
		this.panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(220, 5, 0, 0);
		this.panel.add(label);
		
		this.tabOneUserName = new JTextPane();
		this.tabOneUserName.setFont(new Font("Dialog", Font.BOLD, 18));
		this.tabOneUserName.setForeground(UIManager.getColor("EditorPane.caretForeground"));
		this.tabOneUserName.setBackground(new Color(255, 255, 255));
		this.tabOneUserName.setToolTipText("Enter your User Name");
		this.tabOneUserName.setBounds(414, 150, 405, 46);
		this.panel.add(this.tabOneUserName);
		
		this.tabOnePassword = new JPasswordField();
		tabOnePassword.setBorder(null);
		this.tabOnePassword.setFont(new Font("Dialog", Font.BOLD, 18));
		this.tabOnePassword.setBackground(new Color(255, 255, 255));
		this.tabOnePassword.setToolTipText("Enter your Password");
		this.tabOnePassword.setBounds(414, 259, 405, 44);
		this.panel.add(this.tabOnePassword);
		
		this.logIn = new JButton("Log In");
		logIn.setFont(new Font("Tahoma", Font.BOLD, 20));
		logIn.setForeground(Color.WHITE);
		this.logIn.setBackground(new Color(30, 144, 255));
		this.logIn.setBounds(397, 412, 422, 63);
		this.panel.add(this.logIn);
		JLabel label10 = new JLabel(new ImageIcon(RegView.class.getResource("/login.png")));
		label10.setBackground(Color.WHITE);
		label10.setBounds(0, 5, 843, 506);
		this.panel.add(label10);
		
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("Sign Up", null, panel1, null);
		panel1.setLayout(null);
		
		JLabel label3 = new JLabel("First Name");
		label3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label3.setForeground(Color.WHITE);
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(10, 11, 181, 30);
		panel1.add(label3);
		
		this.firstName = new JTextPane();
		this.firstName.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		this.firstName.setSelectionColor(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
		this.firstName.setBackground(Color.WHITE);
		this.firstName.setBounds(10, 52, 181, 30);
		panel1.add(this.firstName);
		
		JLabel label4 = new JLabel("Last Name");
		label4.setForeground(Color.WHITE);
		label4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setBounds(626, 11, 207, 38);
		panel1.add(label4);
		
		this.lastName = new JTextPane();
		this.lastName.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		this.lastName.setBackground(Color.WHITE);
		this.lastName.setBounds(626, 52, 207, 30);
		panel1.add(this.lastName);
		
		JLabel label7 = new JLabel("User Name");
		label7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		label7.setForeground(Color.WHITE);
		label7.setBounds(10, 170, 181, 38);
		panel1.add(label7);
		
		this.tabTwoUserName = new JTextPane();
		this.tabTwoUserName.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		this.tabTwoUserName.setBackground(Color.WHITE);
		this.tabTwoUserName.setBounds(10, 204, 274, 30);
		panel1.add(this.tabTwoUserName);
		
		JLabel label5 = new JLabel("Phone");
		label5.setForeground(Color.WHITE);
		label5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setBounds(10, 93, 181, 33);
		panel1.add(label5);
		
		this.phone = new JTextPane();
		this.phone.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		this.phone.setBackground(Color.WHITE);
		this.phone.setBounds(10, 137, 181, 30);
		panel1.add(this.phone);
		
		JLabel label6 = new JLabel("Address");
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label6.setForeground(Color.WHITE);
		label6.setBounds(626, 93, 207, 41);
		panel1.add(label6);
		
		this.address = new JTextPane();
		this.address.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		this.address.setBackground(Color.WHITE);
		this.address.setBounds(626, 137, 207, 30);
		panel1.add(this.address);
		
		JLabel label8 = new JLabel("Email");
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		label8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label8.setForeground(Color.WHITE);
		label8.setBounds(10, 237, 181, 38);
		panel1.add(label8);
		
		this.email = new JTextPane();
		this.email.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		this.email.setBackground(Color.WHITE);
		this.email.setBounds(10, 271, 274, 30);
		panel1.add(this.email);
		
		JLabel label9 = new JLabel("Password");
		label9.setForeground(Color.WHITE);
		label9.setHorizontalAlignment(SwingConstants.CENTER);
		label9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label9.setBounds(10, 309, 181, 30);
		panel1.add(label9);
		
		this.tabTwoPassword = new JTextPane();
		this.tabTwoPassword.setFont(new Font("DejaVu Serif Condensed", Font.BOLD, 15));
		this.tabTwoPassword.setBackground(Color.WHITE);
		this.tabTwoPassword.setBounds(10, 339, 274, 30);
		panel1.add(this.tabTwoPassword);
		
		this.submit = new JButton("Submit");
		submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submit.setForeground(new Color(255, 255, 255));
		submit.setBackground(new Color(255, 0, 0));
		this.submit.setBounds(269, 463, 310, 38);
		panel1.add(this.submit);
		
		JLabel label11 = new JLabel("");
		label11.setIcon(new ImageIcon(RegView.class.getResource("/signup.png")));
		label11.setBounds(0, 0, 843, 510);
		panel1.add(label11);
	}
	public JFrame getMainFrame() {
		return this.frame;
	}
	public JTextPane getTabOneUserName() {
		return this.tabOneUserName;
	}
	public JTextPane getTabTwoUserName() {
		return this.tabTwoUserName;
	}
	public JTextPane getTabTwoPassword() {
		return this.tabTwoPassword;
	}
	public JPasswordField getTabOnePassword() {
		return this.tabOnePassword;
	}
	public JTextPane getPhone() {
		return this.phone;
	}
	public JTextPane getAddress() {
		return this.address;
	}
	public JTextPane getEmail() {
		return this.email;
	}
	public JTextPane getFirstName() {
		return this.firstName;
	}
	public JTextPane getLastName() {
		return this.lastName;
	}
	public JButton getLogIn() {
		return this.logIn;
	}
	public JButton getSubmit() {
		return this.submit;
	}
	
	public JTabbedPane getTappedPane (){
		return this.tabbedPane;
	}
}
