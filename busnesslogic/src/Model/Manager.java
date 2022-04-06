package Model;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Control.Server;

import Control.Pair;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
//import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
//import net.sf.dynamicreports.report.builder.DynamicReports;
//import net.sf.dynamicreports.report.builder.column.Columns;
//import net.sf.dynamicreports.report.builder.component.Components;
//import net.sf.dynamicreports.report.builder.datatype.DataTypes;
//import net.sf.dynamicreports.report.constant.HorizontalAlignment;
//import net.sf.dynamicreports.report.exception.DRException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

@SuppressWarnings("deprecation")
public class Manager extends User {
	//queries
	private final String ORDER_INSERTION = "INSERT INTO `ORDER` (ISBN, QUANTITY) VALUES (? , ?)";
	private final String ORDER_CONFIRMATION = "SELECT * FROM `ORDER` WHERE ISBN = ? AND ORDER_ID = ?";
	private final String ORDER_DELETION = "DELETE FROM `ORDER` WHERE ISBN = ? AND ORDER_ID = ?";
	private final String BOOK_ADDITION = "INSERT INTO BOOK VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String USER_PROMOTION = "UPDATE USER SET PRIVILEGE = TRUE WHERE USER_NAME = ?";
	private final String ALL_BOOKS = "SELECT * FROM BOOK";
	private final String ALL_ORDERS = "SELECT * FROM `ORDER`";
	private final String ALL_CUSTOMERS = "SELECT * FROM USER WHERE PRIVILEGE = FALSE";

	private PreparedStatement bookOrder;
	private PreparedStatement orderConfirmation;
	private PreparedStatement orderDeletion;
	private PreparedStatement userPromotion;
	private PreparedStatement bookAddition;
	private PreparedStatement allBooks;
	private PreparedStatement allOrders;
	private PreparedStatement allCustomers;

	public Manager(Connection connection) throws SQLException {
		super(connection);
		this.bookOrder = (PreparedStatement) connection.prepareStatement(this.ORDER_INSERTION);
		this.orderConfirmation = (PreparedStatement) connection.prepareStatement(this.ORDER_CONFIRMATION);
		this.orderDeletion = (PreparedStatement) connection.prepareStatement(this.ORDER_DELETION);
		this.userPromotion = (PreparedStatement) connection.prepareStatement(this.USER_PROMOTION);
		this.bookAddition = (PreparedStatement) connection.prepareStatement(this.BOOK_ADDITION);
		this.allBooks = (PreparedStatement) connection.prepareStatement(this.ALL_BOOKS);
		this.allOrders = (PreparedStatement) connection.prepareStatement(this.ALL_ORDERS);
		this.allCustomers = (PreparedStatement) connection.prepareStatement(this.ALL_CUSTOMERS);
	}

	@Override
	public Pair<Boolean, String> addBook(Object[] params) {
		try {
			ResultSet set = super.connection.getMetaData().getColumns(null, null, super.BOOK_TABLE, null);
			for (int i = 0; i < params.length; i++) {
				set.next();
				if (params[i] == null)
					this.bookAddition.setNull(i + 1, set.getInt(super.COLUMN_TYPE));
				else
					this.setQueryParam(i + 1, set, params[i], this.bookAddition);
			}
			this.bookAddition.executeUpdate();
			this.connection.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return new Pair<>(false, e.getMessage());
		}
		return new Pair<>(true, null);
	}

	@Override
	public Pair<Boolean, String> orderBook(String ISBN, int quantity) {
		try {
			this.bookOrder.setString(1, ISBN);
			this.bookOrder.setInt(2, quantity);
			this.bookOrder.executeUpdate();
			this.connection.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Pair<>(false, e.getMessage());
		}
		return new Pair<>(true, null);
	}

	@Override
	public boolean modifyBook(String ISBN, int field, Object value) {
		try {
			ResultSet set = super.connection.getMetaData().getColumns(null, null, super.BOOK_TABLE, null);
			for (int i = 0; i < field; i++)
				set.next();
			String query = "UPDATE BOOK SET " + set.getString(super.COLUMN_NAME) + " = ? WHERE ISBN = ?";
			PreparedStatement pstmt = super.connection.prepareStatement(query);
			this.setQueryParam(1, set, value, pstmt);
			pstmt.setString(2, ISBN);
			pstmt.executeUpdate();
			this.connection.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean confirmOrder(String ISBN, int order) {
		try {
			this.orderConfirmation.setString(1, ISBN);
			this.orderConfirmation.setInt(2, order);
			ResultSet set = this.orderConfirmation.executeQuery();
			if (set.next()) {
				this.orderDeletion.setString(1, ISBN);
				this.orderDeletion.setInt(2, order);
				this.orderDeletion.executeUpdate();
				this.connection.commit();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean promoteUser(String userName) {
		try {
			this.userPromotion.setString(1, userName);
			this.userPromotion.executeUpdate();
			this.connection.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public CachedRowSet getBooks() throws SQLException {
		CachedRowSet books = RowSetProvider.newFactory().createCachedRowSet();
		books.populate(this.allBooks.executeQuery());
		return books;
	}

	@Override
	public CachedRowSet getOrders() throws SQLException {
		CachedRowSet orders = RowSetProvider.newFactory().createCachedRowSet();
		orders.populate(this.allOrders.executeQuery());
		return orders;
	}

	@Override
	public CachedRowSet getCustomers() throws SQLException {
		CachedRowSet customers = RowSetProvider.newFactory().createCachedRowSet();
		customers.populate(this.allCustomers.executeQuery());
		return customers;
	}

	@Override
	public void getTotalSales() {
	}

	@Override
	public void getTopFiveUsers() {
	}

	@Override
	public void getTopTenBooks() throws JRException {
		JasperDesign jd= JRXmlLoader.load("Cherry.jrxml");
		JasperReport jr= JasperCompileManager.compileReport(jd);
		JasperPrint jp= JasperFillManager.fillReport(jr, null, Server.connection);
		JasperViewer.viewReport(jp);
	}
}
