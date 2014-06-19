package financialSystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import financialSystem.dao.DaoHelper;


public class DaoHelperImpl implements DaoHelper {
	private static DaoHelperImpl baseDao = new DaoHelperImpl();

	private InitialContext jndiContext = null;
	private Connection connection = null;
	private DataSource datasource = null;

	private DaoHelperImpl() {
		try {
			jndiContext = new InitialContext();
			datasource = (DataSource) jndiContext.lookup("java:comp/env/jdbc/financial_system");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static DaoHelperImpl getBaseDaoInstance() {
		return baseDao;
	}

	@Override
	public Connection getConnection() {
		try {
			connection = datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println("got context");
//		System.out.println("About to get ds");

		return connection;
	}

	@Override
	public void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void closePreparedStatement(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void closeResult(ResultSet result) {
		if (result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<Integer> getLists(String sql, int c_identifier, String value) {
		Connection con = this.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		ArrayList<Integer> lists = new ArrayList<Integer>();
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, c_identifier);
			result = stmt.executeQuery();
			
			while(result.next()){
				lists.add(result.getInt(value));
			}
			
			return lists;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			this.closeConnection(con);
			this.closePreparedStatement(stmt);
			this.closeResult(result);
		}
		
		return null;
	}

}
