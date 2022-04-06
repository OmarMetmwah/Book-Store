package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class BookModificationView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel modifyPanel;

	private JButton changeISBN;
	private JButton changeTitle;
	private JButton changeCategory;
	private JButton changePublisher;
	private JButton changeYear;
	private JButton changeAuthor;
	private JButton changeCopies;
	private JButton changePrice;
	private JButton changeThreshold;

	private JLabel ISBN;
	private JLabel title;
	private JLabel category;
	private JLabel publisher;
	private JLabel year;
	private JLabel author;
	private JLabel threshold;
	private JLabel copies;
	private JLabel price;

	private JLabel welcome2;

	public BookModificationView(String bookTitle, ArrayList<String> arrayList) {

		this.setSize(805, 491);
		this.setTitle("Book Store");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);

		modifyPanel = new JPanel();
		modifyPanel.setLayout(null);
		modifyPanel.setBackground(new Color(255, 255, 255));

		welcome2 = new JLabel(bookTitle);
		welcome2.setHorizontalAlignment(SwingConstants.CENTER);
		welcome2.setFont(new Font("Monospaced", Font.BOLD, 32));
		welcome2.setLocation(274, 0);
		welcome2.setSize(250, 75);
		welcome2.setForeground(new Color(0, 38, 153));
		modifyPanel.add(welcome2);

		this.ISBN = new JLabel(arrayList.get(0));
		ISBN.setHorizontalAlignment(SwingConstants.CENTER);
		ISBN.setForeground(new Color(30, 144, 255));
		this.title = new JLabel(arrayList.get(1));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(30, 144, 255));
		this.category = new JLabel(arrayList.get(3));
		category.setHorizontalAlignment(SwingConstants.CENTER);
		category.setForeground(new Color(30, 144, 255));
		this.publisher = new JLabel(arrayList.get(6));
		publisher.setHorizontalAlignment(SwingConstants.CENTER);
		publisher.setForeground(new Color(30, 144, 255));
		this.year = new JLabel(arrayList.get(7));
		year.setHorizontalAlignment(SwingConstants.CENTER);
		year.setForeground(new Color(30, 144, 255));
		this.threshold = new JLabel(arrayList.get(4));
		threshold.setHorizontalAlignment(SwingConstants.CENTER);
		threshold.setForeground(new Color(30, 144, 255));
		this.copies = new JLabel(arrayList.get(5));
		copies.setHorizontalAlignment(SwingConstants.CENTER);
		copies.setForeground(new Color(30, 144, 255));
		this.price = new JLabel(arrayList.get(2));
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setForeground(new Color(30, 144, 255));
		this.author = new JLabel(arrayList.get(8));
		author.setHorizontalAlignment(SwingConstants.CENTER);
		author.setForeground(new Color(30, 144, 255));

		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder(null, "ISBN", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));

		ISBN.setBorder(title1);

		ISBN.setFont(new Font("Serif", Font.BOLD, 24));
		ISBN.setLocation(20, 75);
		ISBN.setSize(291, 60);

		modifyPanel.add(ISBN);

		TitledBorder title2;
		title2 = BorderFactory.createTitledBorder(null, "Title", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		title.setBorder(title2);
		title.setFont(new Font("Serif", Font.BOLD, 24));
		title.setLocation(438, 86);
		title.setSize(291, 60);
		modifyPanel.add(title);

		TitledBorder title3;
		title3 = BorderFactory.createTitledBorder(null, "Category", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		category.setBorder(title3);
		category.setFont(new Font("Serif", Font.BOLD, 24));
		category.setLocation(20, 146);
		category.setSize(291, 60);
		modifyPanel.add(category);

		TitledBorder title4;
		title4 = BorderFactory.createTitledBorder(null, "Publisher", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		publisher.setBorder(title4);
		publisher.setFont(new Font("Serif", Font.BOLD, 24));
		publisher.setLocation(438, 157);
		publisher.setSize(291, 60);
		modifyPanel.add(publisher);

		TitledBorder title5;
		title5 = BorderFactory.createTitledBorder(null, "Publication Year", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		year.setBorder(title5);

		year.setFont(new Font("Serif", Font.BOLD, 24));
		year.setLocation(20, 217);
		year.setSize(291, 60);
		modifyPanel.add(year);

		TitledBorder title6;
		title6 = BorderFactory.createTitledBorder(null, "Author", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		author.setBorder(title6);
		author.setFont(new Font("Serif", Font.BOLD, 24));
		author.setLocation(438, 228);
		author.setSize(291, 60);
		modifyPanel.add(author);

		TitledBorder title7;
		title7 = BorderFactory.createTitledBorder(null, "Threshold", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		threshold.setBorder(title7);
		threshold.setFont(new Font("Serif", Font.BOLD, 24));
		threshold.setLocation(20, 305);
		threshold.setSize(291, 60);
		modifyPanel.add(threshold);

		TitledBorder title8;
		title8 = BorderFactory.createTitledBorder(null, "Copies", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		copies.setBorder(title8);
		copies.setFont(new Font("Serif", Font.BOLD, 24));
		copies.setLocation(438, 305);
		copies.setSize(291, 60);
		modifyPanel.add(copies);

		TitledBorder title9;
		title9 = BorderFactory.createTitledBorder(null, "Price", TitledBorder.LEFT, TitledBorder.CENTER,
				new Font("times new roman", Font.BOLD, 20), new Color(121, 121, 210));
		price.setBorder(title9);
		price.setFont(new Font("Serif", Font.BOLD, 24));
		price.setLocation(184, 375);
		price.setSize(291, 60);
		modifyPanel.add(price);

		changeISBN = new JButton();
		changeISBN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changeISBN.setName("ISBN");
		changeTitle = new JButton();
		changeTitle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changeTitle.setName("TITLE");
		changeCategory = new JButton();
		changeCategory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changeCategory.setName("CATEGORY");
		changePublisher = new JButton();
		changePublisher.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changePublisher.setName("PUBLISHER");
		changeYear = new JButton();
		changeYear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changeYear.setName("PUBLICATION_YEAR");
		changeAuthor = new JButton();
		changeAuthor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changeAuthor.setName("AUTHOR");
		changeCopies = new JButton();
		changeCopies.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changeCopies.setName("COPIES");
		changeThreshold = new JButton();
		changeThreshold.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changeThreshold.setName("THRESHOLD");
		changePrice = new JButton();
		changePrice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changePrice.setName("PRICE");

		changeISBN.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changeTitle.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changeCategory.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changePublisher.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changeYear.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changeAuthor.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changeCopies.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changeThreshold.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));
		changePrice.setIcon(new ImageIcon(UserView.class.getResource("/edit.png")));

		changeISBN.setLocation(321, 85);
		changeISBN.setSize(50, 50);
		modifyPanel.add(changeISBN);

		changeTitle.setLocation(739, 96);
		changeTitle.setSize(50, 50);
		modifyPanel.add(changeTitle);

		changeCategory.setLocation(321, 156);
		changeCategory.setSize(50, 50);
		modifyPanel.add(changeCategory);

		changePublisher.setLocation(739, 167);
		changePublisher.setSize(50, 50);
		modifyPanel.add(changePublisher);

		changeYear.setLocation(321, 227);
		changeYear.setSize(50, 50);
		modifyPanel.add(changeYear);

		changeAuthor.setLocation(739, 238);
		changeAuthor.setSize(50, 50);
		modifyPanel.add(changeAuthor);

		changeThreshold.setLocation(321, 315);
		changeThreshold.setSize(50, 50);
		modifyPanel.add(changeThreshold);

		changeCopies.setLocation(739, 315);
		changeCopies.setSize(50, 50);
		modifyPanel.add(changeCopies);

		changePrice.setLocation(496, 385);
		changePrice.setSize(50, 50);
		modifyPanel.add(changePrice);

		this.setContentPane(modifyPanel);
		this.repaint();
		this.revalidate();
		this.setVisible(true);

	}

	public JButton getChangeISBN() {
		return changeISBN;
	}

	public JButton getChangeTitle() {
		return changeTitle;
	}

	public JButton getChangeCategory() {
		return changeCategory;
	}

	public JButton getChangePublisher() {
		return changePublisher;
	}

	public JButton getChangeYear() {
		return changeYear;
	}

	public JButton getChangeAuthor() {
		return changeAuthor;
	}

	public JButton getChangeCopies() {
		return changeCopies;
	}

	public JButton getChangePrice() {
		return changePrice;
	}

	public JButton getChangeThreshold() {
		return changeThreshold;
	}

	public void setISBN(String iSBN) {
		this.ISBN.setText(iSBN);
	}

	public void setTitle2(String title) {
		this.title.setText(title);
	}

	public void setCategory(String category) {
		this.category.setText(category);
	}

	public void setPublisher(String publisher) {
		this.publisher.setText(publisher);
	}

	public void setAuthor(String author) {
		this.author.setText(author);
	}

	public void setThreshold(String threshold) {
		this.threshold.setText(threshold);
	}

	public void setCopies(String copies) {
		this.copies.setText(copies);
	}

	public void setPrice(String price) {
		this.price.setText(price);
	}

	public void setYear(String year) {
		this.year.setText(year);
	}

	public void setWelcome2(String welcome2) {
		this.welcome2.setText(welcome2);
	}
}