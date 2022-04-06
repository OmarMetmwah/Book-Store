package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Control.Pair;

public class Customer extends User {

	private final String signupQuery = "INSERT INTO USER VALUES (?, ?, ?, ?, ?, ?, ?, FALSE)";
	private PreparedStatement signup;

	public Customer(Connection connection) throws SQLException {
		super(connection);
		this.signup = (PreparedStatement) super.connection.prepareStatement(this.signupQuery);
	}
	//returns <boolean defines the validity of signing up according to validity of inputs according to database validators, the error reason to print in warning message or null if every thing goes well>
	@Override
	public Pair<Boolean, String> signUp(Object[] params) {
		try {
			ResultSet set = super.connection.getMetaData().getColumns(null, null, super.USER_TABLE, null);
			for (int i = 0; i < params.length; i++) {
				set.next();
				if (params[i] == null)//if user left a field empty set it to null
					this.signup.setNull(i + 1, set.getInt(super.COLUMN_TYPE));
				else//else set the variable ? in the query to its corresponding value
					this.setQueryParam(i + 1, set, params[i], this.signup);
			}
			this.signup.executeUpdate();//try to execute the query
			this.connection.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return new Pair<>(false, e.getMessage());
		}
		return new Pair<>(true, null);
	}

}
