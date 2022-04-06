package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.rowset.CachedRowSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Control.Pair;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JToolBar userProfile;
	private JToolBar shoppingToolBar;
	private JToolBar managerToolBar;
	private FlowLayout FL;
	private JButton viewProfile;
	private JButton logout;
	private JPanel mainPanel;
	private JPanel userAccount;
	private JPanel shoppingCartPanel;
	private JPanel managerPanel;
	private JPanel pan;

	private JButton changeUsername;
	private JButton changePassword;
	private JButton changeLname;
	private JButton changeFname;
	private JButton changeAddress;
	private JButton changeEmail;
	private JButton changePhone;
	private JButton back;
	private JButton searchBtn;
	private JButton shoppingCart;
	private JButton removeItem;
	private JButton checkOut;
	private JButton manager;
	private JButton addBook;
	private JButton modifyBook;
	private JButton placeOrder;
	private JButton confirmOrder;
	private JButton promoteCustomer;
	private JButton viewReports;
	private JButton backShoppingCart;
	private JButton backManager;

	private JCheckBox ISBN;
	private JCheckBox title;
	private JCheckBox category;
	private JCheckBox author;
	private JCheckBox publisher;

	private JTextField ISBNText;

	private JCheckBox science;
	private JCheckBox art;
	private JCheckBox religion;
	private JCheckBox history;
	private JCheckBox geography;

	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	private JScrollPane scrollPanel;

	private ArrayList<JButton> buttons;
	private ArrayList<JButton> buttonsOrders;
	private ArrayList<JButton> buttonsCustomers;

	private JLabel username;
	private JLabel password;
	private JLabel fname;
	private JLabel lname;
	private JLabel email;
	private JLabel phoneNo;
	private JLabel address;
	private JLabel welcome2;

	private Map<String, JLabel> labels;

	private CachedRowSet userInfo;
	private String userName;
	private JButton search;
	private JPanel panel;
	private JLabel label_1;

	public UserView(String userName, CachedRowSet userInfo, String privilage) {

		this.userName = userName;
		this.userInfo = userInfo;
		this.setSize(735, 700);
		this.setTitle("Book Store");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.setResizable(false);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(105, 105, 105));
		mainPanel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 105, 605, 565);
		mainPanel.add(scrollPane);

		this.FL = new FlowLayout();
		this.userProfile = new JToolBar();
		userProfile.setBounds(0, 0, 729, 60);
		userProfile.setFloatable(false);
		mainPanel.add(userProfile, BorderLayout.NORTH);
		userProfile.setBackground(new Color(192, 192, 192));
		userProfile.setLayout(FL);
		FL.setAlignment(FlowLayout.LEFT);

		JLabel name = new JLabel(this.userName); // get user name
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Serif", Font.BOLD, 18));
		userProfile.add(name);
		for (int i = 0; i < 30; i++) {
			userProfile.addSeparator();
		}
		viewProfile = new JButton("");
		viewProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		shoppingCart = new JButton("");
		shoppingCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		shoppingCart.setName("Shopping Cart");
		shoppingCart.setIcon(new ImageIcon(UserView.class.getResource("/cart.jpg")));
		shoppingCart.setBackground(Color.white);
		logout = new JButton("");
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewProfile.setBackground(Color.white);
		logout.setBackground(Color.white);
		viewProfile.setIcon(new ImageIcon(UserView.class.getResource("/man.png")));
		logout.setIcon(new ImageIcon(UserView.class.getResource("/lougout.png")));
		
		if (privilage.equals("Manager")) {

			manager = new JButton("");
			manager.setName("manager");
			manager.setIcon(new ImageIcon(UserView.class.getResource("/mang.png")));
			manager.setBackground(Color.white);
			userProfile.add(manager);
		}
		
		userProfile.add(shoppingCart);
		userProfile.add(viewProfile);
		userProfile.add(logout);

		mainPanel.add(userProfile, BorderLayout.NORTH);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		userAccount = new JPanel();
		userAccount.setLayout(null);
		userAccount.setBackground(new Color(255, 255, 255));

		JLabel welcome = new JLabel("WELCOME");
		welcome.setFont(new Font("Serif", Font.PLAIN, 32));
		welcome.setLocation(100, 5);
		welcome.setSize(200, 75);
		welcome.setForeground(new Color(30, 144, 255));
		userAccount.add(welcome);

		welcome2 = new JLabel(this.userName); // username

		welcome2.setFont(new Font("Monospaced", Font.BOLD, 32));
		welcome2.setLocation(400, 5);
		welcome2.setSize(250, 75);
		welcome2.setForeground(new Color(30, 144, 255));
		userAccount.add(welcome2);
		try {
			this.userInfo.next();
			this.username = new JLabel(this.userInfo.getString("USER_NAME"));
			this.password = new JLabel(this.userInfo.getString("PASSWORD"));
			this.fname = new JLabel(this.userInfo.getString("F_NAME"));
			this.lname = new JLabel(this.userInfo.getString("L_NAME"));
			this.email = new JLabel(this.userInfo.getString("EMAIL"));
			this.phoneNo = new JLabel(this.userInfo.getString("TELEPHONE"));
			this.address = new JLabel(this.userInfo.getString("ADDRESS"));

			TitledBorder title1;
			title1 = BorderFactory.createTitledBorder(null, "User Name", TitledBorder.LEFT, TitledBorder.CENTER,
					new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));

			username.setBorder(title1);

			username.setFont(new Font("Serif", Font.BOLD, 24));
			username.setLocation(20, 75);
			username.setSize(600, 75);
			username.setHorizontalAlignment(SwingConstants.CENTER);
			userAccount.add(username);

			TitledBorder title2;
			title2 = BorderFactory.createTitledBorder(null, "Password", TitledBorder.LEFT, TitledBorder.CENTER,
					new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
			password.setBorder(title2);
			password.setFont(new Font("Serif", Font.BOLD, 24));
			password.setLocation(20, 155);
			password.setSize(600, 75);
			password.setHorizontalAlignment(SwingConstants.CENTER);
			userAccount.add(password);

			TitledBorder title3;
			title3 = BorderFactory.createTitledBorder(null, "First Name", TitledBorder.LEFT, TitledBorder.CENTER,
					new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
			fname.setBorder(title3);
			fname.setFont(new Font("Serif", Font.BOLD, 24));
			fname.setLocation(20, 235);
			fname.setSize(600, 75);
			fname.setHorizontalAlignment(SwingConstants.CENTER);
			userAccount.add(fname);

			TitledBorder title4;
			title4 = BorderFactory.createTitledBorder(null, "Last Name", TitledBorder.LEFT, TitledBorder.CENTER,
					new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
			lname.setBorder(title4);

			lname.setFont(new Font("Serif", Font.BOLD, 24));
			lname.setLocation(20, 315);
			lname.setSize(600, 75);
			lname.setHorizontalAlignment(SwingConstants.CENTER);
			userAccount.add(lname);

			TitledBorder title5;
			title5 = BorderFactory.createTitledBorder(null, "E-mail", TitledBorder.LEFT, TitledBorder.CENTER,
					new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
			email.setBorder(title5);

			email.setFont(new Font("Serif", Font.BOLD, 24));
			email.setLocation(20, 395);
			email.setSize(600, 75);
			email.setHorizontalAlignment(SwingConstants.CENTER);
			userAccount.add(email);

			TitledBorder title6;
			title6 = BorderFactory.createTitledBorder(null, "Phone Number", TitledBorder.LEFT, TitledBorder.CENTER,
					new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
			phoneNo.setBorder(title6);

			phoneNo.setFont(new Font("Serif", Font.BOLD, 24));
			phoneNo.setLocation(20, 475);
			phoneNo.setSize(600, 75);
			phoneNo.setHorizontalAlignment(SwingConstants.CENTER);
			userAccount.add(phoneNo);

			TitledBorder title7;
			title7 = BorderFactory.createTitledBorder(null, "Shipping Address", TitledBorder.LEFT, TitledBorder.CENTER,
					new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
			address.setBorder(title7);

			address.setFont(new Font("Serif", Font.BOLD, 24));
			address.setLocation(20, 555);
			address.setSize(600, 75);
			address.setHorizontalAlignment(SwingConstants.CENTER);
			userAccount.add(address);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		changeUsername = new JButton();
		changeUsername.setName("USER_NAME");
		changePassword = new JButton();
		changePassword.setName("PASSWORD");
		changeLname = new JButton();
		changeLname.setName("L_NAME");
		changeFname = new JButton();
		changeFname.setName("F_NAME");
		changeAddress = new JButton();
		changeAddress.setName("ADDRESS");
		changeEmail = new JButton();
		changeEmail.setName("EMAIL");
		changePhone = new JButton();
		changePhone.setName("TELEPHONE");

		changeUsername.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changePassword.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changeLname.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changeFname.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changeAddress.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changeEmail.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changePhone.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));

		changeUsername.setLocation(625, 91);
		changeUsername.setSize(50, 50);
		changeUsername.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userAccount.add(changeUsername);

		changePassword.setLocation(625, 171);
		changePassword.setSize(50, 50);
		changePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userAccount.add(changePassword);

		changeFname.setLocation(625, 251);
		changeFname.setSize(50, 50);
		changeFname.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userAccount.add(changeFname);

		changeLname.setLocation(625, 331);
		changeLname.setSize(50, 50);
		changeLname.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userAccount.add(changeLname);

		changeEmail.setLocation(625, 411);
		changeEmail.setSize(50, 50);
		changeEmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userAccount.add(changeEmail);

		changePhone.setLocation(625, 491);
		changePhone.setSize(50, 50);
		changePhone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userAccount.add(changePhone);

		changeAddress.setLocation(625, 571);
		changeAddress.setSize(50, 50);
		changeAddress.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userAccount.add(changeAddress);

		back = new JButton();
		back.setIcon(new ImageIcon(UserView.class.getResource("/homeicon.png")));
		back.setLocation(20, 10);
		back.setSize(50, 50);
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userAccount.add(back);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		category = new JCheckBox("Category");
		category.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(category.isSelected()) {
					ISBN.setSelected(false);
					author.setSelected(false);
					title.setSelected(false);
					publisher.setSelected(false);
				}
			}
		});
		category.setFont(new Font("Tahoma", Font.BOLD, 14));
		category.setForeground(new Color(255, 255, 255));
		category.setHorizontalAlignment(SwingConstants.LEFT);
		category.setMnemonic(KeyEvent.VK_C);

		JPanel checkPanel = new JPanel();
		checkPanel.setBounds(0, 105, 126, 566);
		checkPanel.setBackground(new Color(128, 128, 128));
		checkPanel.setLayout(null);

		category.setLocation(4, 7);
		category.setSize(90, 30);
		category.setBackground(new Color(128, 128, 128));

		science = new JCheckBox("Science");
		science.setFont(new Font("Tahoma", Font.BOLD, 11));
		science.setForeground(new Color(255, 255, 255));
		science.setHorizontalAlignment(SwingConstants.LEFT);
		science.setLocation(24, 40);
		science.setSize(79, 30);
		science.setBackground(new Color(128, 128, 128));

		art = new JCheckBox("Art");
		art.setFont(new Font("Tahoma", Font.BOLD, 11));
		art.setForeground(new Color(255, 255, 255));
		art.setHorizontalAlignment(SwingConstants.LEFT);
		art.setLocation(24, 73);
		art.setSize(79, 30);
		art.setBackground(new Color(128, 128, 128));

		religion = new JCheckBox("Religion");
		religion.setForeground(new Color(255, 255, 255));
		religion.setFont(new Font("Tahoma", Font.BOLD, 11));
		religion.setLocation(25, 106);
		religion.setSize(79, 30);
		religion.setBackground(new Color(128, 128, 128));

		history = new JCheckBox("History");
		history.setFont(new Font("Tahoma", Font.BOLD, 11));
		history.setForeground(new Color(255, 255, 255));
		history.setLocation(24, 139);
		history.setSize(79, 30);
		history.setBackground(new Color(128, 128, 128));

		geography = new JCheckBox("Geography");
		geography.setFont(new Font("Tahoma", Font.BOLD, 11));
		geography.setForeground(new Color(255, 255, 255));
		geography.setLocation(25, 172);
		geography.setSize(96, 30);
		geography.setBackground(new Color(128, 128, 128));

		searchBtn = new JButton();
		searchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		searchBtn.setLocation(33, 219);
		searchBtn.setSize(50, 30);

		searchBtn.setIcon(new ImageIcon(UserView.class.getResource("/images.jpg")));
		checkPanel.add(category);
		checkPanel.add(science);
		checkPanel.add(art);
		checkPanel.add(religion);
		checkPanel.add(history);
		checkPanel.add(geography);
		checkPanel.add(searchBtn);
		mainPanel.add(checkPanel);

		managerPanel = new JPanel();
		managerPanel.setLayout(null);

		managerToolBar = new JToolBar();
		managerToolBar.setFloatable(false);
		managerToolBar.setBackground(new Color(192, 192, 192));
//		managerToolBar.setLayout(FL);
		managerToolBar.setLocation(0, 0);
		managerToolBar.setSize(900, 50);

		addBook = new JButton("Add Book");
		modifyBook = new JButton("Modify Book");
		placeOrder = new JButton("Place Order");
		confirmOrder = new JButton("Confirm");
		promoteCustomer = new JButton("Promote");
		viewReports = new JButton("Reports");
		backManager = new JButton("Back");
		
		addBook.setBackground(new Color(30, 144, 255));
		addBook.setForeground(new Color(255,255,255));
		addBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modifyBook.setBackground(new Color(30, 144, 255));
		modifyBook.setForeground(new Color(255,255,255));
		modifyBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		placeOrder.setBackground(new Color(30, 144, 255));
		placeOrder.setForeground(new Color(255,255,255));
		placeOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confirmOrder.setBackground(new Color(30, 144, 255));
		confirmOrder.setForeground(new Color(255,255,255));
		confirmOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		promoteCustomer.setBackground(new Color(30, 144, 255));
		promoteCustomer.setForeground(new Color(255,255,255));
		promoteCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewReports.setBackground(new Color(30, 144, 255));
		viewReports.setForeground(new Color(255,255,255));
		viewReports.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backManager.setBackground(new Color(30, 144, 255));
		backManager.setForeground(new Color(255,255,255));
		backManager.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		addBook.setName("Add Book");
		modifyBook.setName("Modify Book");
		placeOrder.setName("Place Order");
		confirmOrder.setName("Confirm Order");
		promoteCustomer.setName("Promote Customer");
		viewReports.setName("View Reports");
		backManager.setName("Back");
		
		for (int i = 0; i < 3; i++) {
			managerToolBar.addSeparator();
		}
		managerToolBar.add(addBook);
		for (int i = 0; i < 3; i++) {
			managerToolBar.addSeparator();
		}
		managerToolBar.add(modifyBook);
		for (int i = 0; i < 3; i++) {
			managerToolBar.addSeparator();
		}
		managerToolBar.add(placeOrder);
		for (int i = 0; i < 3; i++) {
			managerToolBar.addSeparator();
		}
		managerToolBar.add(confirmOrder);
		for (int i = 0; i < 3; i++) {
			managerToolBar.addSeparator();
		}
		managerToolBar.add(promoteCustomer);
		for (int i = 0; i < 3; i++) {
			managerToolBar.addSeparator();
		}
		managerToolBar.add(viewReports);
		for (int i = 0; i < 3; i++) {
			managerToolBar.addSeparator();
		}
		managerToolBar.add(backManager);

		managerPanel.add(managerToolBar);

		scrollPane2 = new JScrollPane();
		scrollPane2.setLocation(0, 50);
		scrollPane2.setSize(735, 600);
		managerPanel.add(scrollPane2);

		this.setContentPane(mainPanel);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(0, 60, 729, 41);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		ISBNText = new JTextField("Enter Search Value");
		ISBNText.setFont(new Font("Tahoma", Font.BOLD, 14));
		ISBNText.setBorder(new LineBorder(new Color(255, 255, 255), 4, true));
		ISBNText.setBounds(328, 2, 345, 33);
		panel.add(ISBNText);
		ISBNText.setHorizontalAlignment(SwingConstants.CENTER);
		
		search = new JButton("");
		search.setBackground(new Color(255, 0, 255));
		search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		search.setIcon(new ImageIcon(UserView.class.getResource("/indexnew.jpg")));
		search.setBounds(680, 2, 39, 33);
		panel.add(search);
		
		ISBN = new JCheckBox("ISBN");
		ISBN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ISBN.isSelected()) {
					title.setSelected(false);
					category.setSelected(false);
					author.setSelected(false);
					publisher.setSelected(false);
					science.setSelected(false);
					art.setSelected(false);
					religion.setSelected(false);
					history.setSelected(false);
					geography.setSelected(false);
				}
				
			}
		});
		ISBN.setBounds(258, 0, 72, 30);
		panel.add(ISBN);
		ISBN.setHorizontalAlignment(SwingConstants.CENTER);
		ISBN.setForeground(new Color(255, 255, 255));
		ISBN.setFont(new Font("Tahoma", Font.BOLD, 12));
		ISBN.setMnemonic(KeyEvent.VK_C);
		ISBN.setBackground(new Color(169, 169, 169));
				
		title = new JCheckBox("Title");
		title.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(title.isSelected()) {
					ISBN.setSelected(false);
					category.setSelected(false);
					author.setSelected(false);
					publisher.setSelected(false);
					science.setSelected(false);
					art.setSelected(false);
					religion.setSelected(false);
					history.setSelected(false);
					geography.setSelected(false);
				}
			}
		});
		title.setBounds(191, 2, 80, 30);
		panel.add(title);
		title.setFont(new Font("Tahoma", Font.BOLD, 14));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(255, 255, 255));
		title.setMnemonic(KeyEvent.VK_C);
		title.setBackground(new Color(169, 169, 169));
						
		author = new JCheckBox("Author");
		author.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(author.isSelected()) {
					ISBN.setSelected(false);
					category.setSelected(false);
					title.setSelected(false);
					publisher.setSelected(false);
					science.setSelected(false);
					art.setSelected(false);
					religion.setSelected(false);
					history.setSelected(false);
					geography.setSelected(false);
				}
			}
		});
		author.setBounds(131, 2, 101, 30);
		panel.add(author);
		author.setFont(new Font("Tahoma", Font.BOLD, 11));
		author.setForeground(new Color(255, 255, 255));
		author.setMnemonic(KeyEvent.VK_C);
		author.setBackground(new Color(169, 169, 169));
								
		publisher = new JCheckBox("Publisher");
		publisher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(publisher.isSelected()) {
					ISBN.setSelected(false);
					category.setSelected(false);
					title.setSelected(false);
					author.setSelected(false);
					science.setSelected(false);
					art.setSelected(false);
					religion.setSelected(false);
					history.setSelected(false);
					geography.setSelected(false);
				}
			}
		});
		publisher.setBounds(6, 2, 123, 30);
		panel.add(publisher);
		publisher.setFont(new Font("Tahoma", Font.BOLD, 14));
		publisher.setForeground(new Color(255, 255, 255));
		publisher.setHorizontalAlignment(SwingConstants.CENTER);
		publisher.setMnemonic(KeyEvent.VK_C);
		publisher.setBackground(new Color(169, 169, 169));
		
		label_1 = new JLabel("New label");
		label_1.setBounds(461, 11, 46, 14);
		panel.add(label_1);
		this.setVisible(true);
		this.repaint();

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void viewShoppingCart(Map<String, Pair<String, Integer>> shoppingCart) {
		System.out.println(shoppingCart.size());
		shoppingToolBar = new JToolBar();
		shoppingToolBar.setFloatable(false);
		shoppingToolBar.setBackground(new Color(192, 192, 192));
		shoppingToolBar.setLayout(FL);
		FL.setAlignment(FlowLayout.CENTER);
		shoppingToolBar.setLocation(0, 0);
		shoppingToolBar.setSize(735, 50);
		removeItem = new JButton("Remove");
		checkOut = new JButton("Check Out");
		backShoppingCart = new JButton("Back");
		backShoppingCart.setName("Back");
		
		removeItem.setBackground(new Color(30, 144, 255));
		removeItem.setForeground(new Color(255,255,255));
		removeItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkOut.setBackground(new Color(30, 144, 255));
		checkOut.setForeground(new Color(255,255,255));
		checkOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backShoppingCart.setBackground(new Color(30, 144, 255));
		backShoppingCart.setForeground(new Color(255,255,255));
		backShoppingCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		shoppingToolBar.add(removeItem);
		shoppingToolBar.add(checkOut);
		for (int i = 0; i < 32; i++) {
			shoppingToolBar.addSeparator();
		}
		shoppingToolBar.add(backShoppingCart);
		scrollPanel = new JScrollPane();
		scrollPanel.setLocation(0, 50);
		scrollPanel.setSize(735, 620);
		shoppingCartPanel = new JPanel();
		shoppingCartPanel.setLayout(null);
		shoppingCartPanel.add(scrollPanel);
		shoppingCartPanel.add(shoppingToolBar);
		pan = new JPanel();
		pan.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		int i = 1;
		labels = new HashMap<String, JLabel>();
		for (Entry<String, Pair<String, Integer>> entry : shoppingCart.entrySet()) {
			System.out.println(entry.getValue().getFirst());
			System.out.println(entry.getValue().getSecond());
			System.out.println(entry.getKey());
			double price = Double.parseDouble(entry.getValue().getFirst().substring(0,entry.getValue().getFirst().indexOf("b")));
			JLabel label = new JLabel(entry.getValue().getSecond()+"    "+entry.getValue().getFirst().substring(entry.getValue().getFirst().indexOf("b")) +"   price: "+ price + "    total price: "+(price*entry.getValue().getSecond()));
			label.setFont(new Font("Serif", Font.BOLD, 23));
			label.setBackground(Color.BLUE);
			labels.put(entry.getValue().getFirst(), label);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.ipady = 40; // make this component tall
			c.weightx = 0.0;
			c.gridwidth = 9;
			c.gridx = 0;
			c.gridy = i++;
			pan.add(label, c);

		}
		scrollPanel.setViewportView(pan);

	}
																	/*still*/
	public ArrayList<JButton> viewOrders(CachedRowSet set) {

		String ISBN = null;
		String quantity = null;
		JPanel pan = new JPanel();
		pan.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		buttonsOrders = new ArrayList<JButton>();
		int i = 1;

		try {
			while (set.next()) {

				ISBN = set.getString("ISBN");
				quantity = set.getString("QUANTITY");
				JButton b = new JButton("          ISBN: " + ISBN + "      Quantity: " + Integer.parseInt(quantity)+ "          ");
				b.setFont(new Font("Serif", Font.BOLD, 23));
				b.setName(set.getString("ORDER_ID") + "," + ISBN);
				buttonsOrders.add(b);
				b.setBackground(new Color(204, 204, 255));
				c.fill = GridBagConstraints.HORIZONTAL;
				c.ipady = 40; // make this component tall
				c.weightx = 0.0;
				c.gridwidth = 9;
				c.gridx = 0;
				c.gridy = i++;
				pan.add(b, c);

			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scrollPane2.setViewportView(pan);
		return buttonsOrders;
	}

	public ArrayList<JButton> viewSearch(ArrayList<String> titles) {

		JPanel pan = new JPanel();
		pan.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		buttons = new ArrayList<JButton>();
		int i = 1;

		for (String title : titles) {
			JButton b = new JButton("                     "+title+"                     ");
			b.setName(title);
			b.setFont(new Font("Serif", Font.BOLD, 23));
			buttons.add(b);
			b.setBackground(new Color(30, 144, 255));
			b.setForeground(new Color(255,255,255));
			b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			c.fill = GridBagConstraints.HORIZONTAL;
			c.ipady = 40; // make this component tall
			c.weightx = 0.0;
			c.gridwidth = 9;
			c.gridx = 0;
			c.gridy = i++;
			pan.add(b, c);
		}

		scrollPane.setViewportView(pan);
		return buttons;

	}
																	/*still*/
	public ArrayList<JButton> viewCustomers(CachedRowSet set) {

		JPanel pan = new JPanel();
		pan.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		buttonsCustomers = new ArrayList<JButton>();
		int i = 1;
		String username;
		try {
			while (set.next()) {
				username = set.getString("USER_NAME");
				JButton b = new JButton("                     "+username+ "                     ");
				
				b.setName(username);
				b.setFont(new Font("Serif", Font.BOLD, 23));
				b.setBackground(new Color(204, 204, 255));
				buttonsCustomers.add(b);
				c.fill = GridBagConstraints.HORIZONTAL;
				c.ipady = 40; // make this component tall
				c.weightx = 0.0;
				c.gridwidth = 9;
				c.gridx = 0;
				c.gridy = i++;
				pan.add(b, c);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scrollPane2.setViewportView(pan);
		return buttonsCustomers;

	}

	public ArrayList<JButton> viewBooks(ArrayList <String> titles) {

		JPanel pan = new JPanel();
		pan.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		buttons = new ArrayList<JButton>();
		int i = 1;
		for (String title : titles) {
			JButton b = new JButton("                     "+title+"                     ");
			b.setName(title);
			b.setFont(new Font("Serif", Font.BOLD, 23));
			buttons.add(b);
			b.setBackground(new Color(30, 144, 255));
			b.setForeground(new Color(255,255,255));
			b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			c.fill = GridBagConstraints.HORIZONTAL;
			c.ipady = 40; // make this component tall
			c.weightx = 0.0;
			c.gridwidth = 9;
			c.gridx = 0;
			c.gridy = i++;
			pan.add(b, c);
		}
		scrollPane2.setViewportView(pan);
		return buttons;
	}

	public JButton getViewProfile() {
		return this.viewProfile;
	}

	public JButton getUsernameChange() {
		return this.changeUsername;
	}

	public JButton getFnameChange() {
		return this.changeFname;
	}

	public JButton getLnameChange() {
		return this.changeLname;
	}

	public JButton getEmailChange() {
		return this.changeEmail;
	}

	public JButton getPhoneChange() {
		return this.changePhone;
	}

	public JButton getAddressChange() {
		return this.changeAddress;
	}

	public JButton getPasswordChange() {
		return this.changePassword;
	}

	public JPanel getProfilePanel() {
		return this.userAccount;
	}

	public JPanel getMainPanel() {
		return this.mainPanel;
	}

	public JPanel getShoppingCartPanel() {

		return this.shoppingCartPanel;
	}

	public JPanel getManagerPanel() {

		return this.managerPanel;
	}

	public JPanel getPan() {
		return pan;
	}

	public JButton getBackButton() {
		return this.back;
	}

	public JButton getSearchButton() {
		return this.searchBtn;
	}
	public JButton getSearchButton1() {
		return this.search;
	}

	public JButton getShoppingCartButton() {
		return this.shoppingCart;
	}

	public JButton getremoveButton() {
		return this.removeItem;
	}

	public JButton getcheckOutButton() {
		return this.checkOut;
	}

	public JButton getManager() {
		return this.manager;
	}

	public JButton getAddBook() {
		return this.addBook;
	}

	public JButton getModifyBook() {
		return this.modifyBook;
	}

	public JButton getPlaceOrder() {
		return this.placeOrder;
	}

	public JButton getConfirmOrder() {
		return this.confirmOrder;
	}

	public JButton getPromoteCustomer() {
		return this.promoteCustomer;
	}

	public JButton getViewReports() {
		return this.viewReports;
	}

	public JButton getBackShoppingCart() {
		return this.backShoppingCart;
	}

	public JButton getBackManager() {
		return this.backManager;
	}

	public JTextField getISBNText() {
		return this.ISBNText;
	}

	public JCheckBox getISBNCheck() {
		return this.ISBN;
	}

	public JCheckBox getTitleCheck() {
		return this.title;
	}

	public JCheckBox getAuthorCheck() {
		return this.author;
	}

	public JCheckBox getPublisherCheck() {
		return this.publisher;
	}

	public JCheckBox getCategoryCheck() {
		return this.category;
	}

	public JCheckBox getScience() {
		return this.science;
	}

	public JCheckBox getArt() {
		return this.art;
	}

	public JCheckBox getGeography() {
		return this.geography;
	}

	public JCheckBox getReligion() {
		return this.religion;
	}

	public JCheckBox getHistory() {
		return this.history;
	}

	public Map<String, JLabel> getLabels() {
		return labels;
	}

	public JLabel getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username.setText(username);
	}

	public void setPassword(String password) {
		this.password.setText(password);
	}

	public void setFname(String fname) {
		this.fname.setText(fname);
	}

	public void setLname(String lname) {
		this.lname.setText(lname);
	}

	public void setEmail(String email) {
		this.email.setText(email);
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo.setText(phoneNo);
	}

	public void setAddress(String address) {
		this.address.setText(address);
	}

	public void setWelcome2(String welcome2) {
		this.welcome2.setText(welcome2);
	}
	
	public JButton getLogout(){
		return this.logout;
	}
}
