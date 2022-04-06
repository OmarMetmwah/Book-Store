package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class BookView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton buyItem;

	public BookView(String title, ArrayList<String> arrayList) {
		this.setSize(880, 459);
		this.setTitle("Book Store");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setLayout(null);

		JLabel welcome2 = new JLabel(title); // username
		welcome2.setHorizontalAlignment(SwingConstants.CENTER);

		welcome2.setFont(new Font("Monospaced", Font.BOLD, 32));
		welcome2.setLocation(310, 0);
		welcome2.setSize(250, 75);
		welcome2.setForeground(new Color(30, 144, 255));
		mainPanel.add(welcome2);

		
		JLabel ISBN = new JLabel(arrayList.get(0));
		ISBN.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel category = new JLabel(arrayList.get(1));
		category.setHorizontalAlignment(SwingConstants.CENTER);
	    JLabel author = new JLabel(arrayList.get(2));
	    author.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel publisher = new JLabel(arrayList.get(3));
		publisher.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel year = new JLabel(arrayList.get(4));
		year.setBackground(new Color(255, 255, 255));
		year.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel price = new JLabel(arrayList.get(5));
		price.setHorizontalAlignment(SwingConstants.CENTER);

		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder(null, "ISBN", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));

		ISBN.setBorder(title1);

		ISBN.setFont(new Font("Serif", Font.BOLD, 24));
		ISBN.setLocation(20, 75);
		ISBN.setSize(375, 75);

		mainPanel.add(ISBN);

		TitledBorder title2;
		title2 = BorderFactory.createTitledBorder(null, "Category", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		category.setBorder(title2);
		category.setFont(new Font("Serif", Font.BOLD, 24));
		category.setLocation(466, 75);
		category.setSize(375, 75);
		mainPanel.add(category);

		TitledBorder title3;
		title3 = BorderFactory.createTitledBorder(null, "Author", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		 author.setBorder(title3);
		 author.setFont(new Font("Serif", Font.BOLD, 24));
		 author.setLocation(20, 161);
		 author.setSize(375, 75);
		 mainPanel.add(author);

		TitledBorder title4;
		title4 = BorderFactory.createTitledBorder(null, "Publisher", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		publisher.setBorder(title4);

		publisher.setFont(new Font("Serif", Font.BOLD, 24));
		publisher.setLocation(466, 161);
		publisher.setSize(375, 75);
		mainPanel.add(publisher);

		TitledBorder title5;
		title5 = BorderFactory.createTitledBorder(null, "Publication year", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		year.setBorder(title5);

		year.setFont(new Font("Serif", Font.BOLD, 24));
		year.setLocation(20, 247);
		year.setSize(375, 75);
		mainPanel.add(year);

		TitledBorder title6;
		title6 = BorderFactory.createTitledBorder(null, "Selling price", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		price.setBorder(title6);

		price.setFont(new Font("Serif", Font.BOLD, 24));
		price.setLocation(466, 247);
		price.setSize(375, 75);
		mainPanel.add(price);

		buyItem = new JButton("Buy");
		buyItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buyItem.setBackground(new Color(30, 144, 255));
		buyItem.setForeground(new Color(255, 255, 255));
		buyItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		buyItem.setLocation(321, 358);
		buyItem.setSize(197, 50);
		mainPanel.add(buyItem);

		this.setContentPane(mainPanel);
		this.repaint();
		this.revalidate();
		this.setVisible(true);
	}

	public JButton getBuyItem() {
		return buyItem;
	}

}
