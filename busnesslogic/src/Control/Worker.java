package Control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;

import Model.Customer;
import Model.User;

class Worker implements Runnable {

	private Socket socket;
	private Connection connection;
	private User user;

	public Worker(Socket socket, Connection connection) throws SQLException {
		this.socket = socket;
		this.connection = connection;
		this.user = new Customer(connection);//for default the user is customer till check his/her privileges
	}

	@Override
	public void run() {
		try {
			//BackServer Flow loop with each Open socket
			while (!this.socket.isClosed()) {
				ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				String methodName = input.readUTF();
				Class<?>[] types = (Class<?>[]) input.readObject();
				Object[] params = (Object[]) input.readObject();
				Object result = this.user.getClass().getMethod(methodName, types).invoke(this.user, params);
				output.writeObject(result);
				if (methodName.equals("signIn")) {//check for privilege of client if signing in
					@SuppressWarnings("unchecked")
					Pair<Pair<Boolean, Boolean>, String> state = (Pair<Pair<Boolean, Boolean>, String>) result;
					Pair<Boolean, Boolean> pair = state.getFirst();
					if (pair.getFirst() && pair.getSecond()) {
						//construct instance of either customer or manager depending on the privilege sent from the database
						String privilege = state.getSecond();
						Constructor<?> cons = Class.forName("Model." + privilege).getConstructor(Connection.class);
						this.user = (User) cons.newInstance(this.connection);
						this.user.setUserName((String)params[0]);
					}
				} else if (methodName.equals("logout")) {
					this.socket.close();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}

	}

}
