package Control;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server extends Thread {
	//socket global variables
	private ServerSocket server;
	private Socket socket;
	private InetSocketAddress port;

	//sql connector
	public static Connection connection;
	private final String dbUrl = "jdbc:mysql://localhost:3306/BOOK_STORE";
	private final String dbUsername = "root";
	private final String dbPassword = "rootroot";
	private final int portNumber = 6666;

	public Server() throws SQLException {
		this.connection = DriverManager.getConnection(this.dbUrl, this.dbUsername, this.dbPassword);
		this.connection.setAutoCommit(false);
		this.port = new InetSocketAddress(this.portNumber);
	}

	public void run() {
		System.out.println("Socket is running...");
		try {
			this.server = new ServerSocket();
			this.server.setReuseAddress(true);
			this.server.bind(this.port);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		//Accept Clients
		while (true) {
			try {
				this.socket = this.server.accept();
				Worker client = new Worker(this.socket, this.connection);
				Thread thread = new Thread(client);
				thread.start();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Client Connected!");
		}
	}

	public static void main(String[] args) throws SQLException {
		new Server().start();	
	}
}
