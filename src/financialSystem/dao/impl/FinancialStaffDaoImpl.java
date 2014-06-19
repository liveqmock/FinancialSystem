package financialSystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import financialSystem.dao.DaoHelper;
import financialSystem.dao.FinancialStaffDao;
import financialSystem.model.InvolvedProject;

public class FinancialStaffDaoImpl implements FinancialStaffDao {
	private DaoHelper daoHelper;
	public DaoHelper getDaoHelper() {
		return daoHelper;
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	@Override
	public ArrayList<InvolvedProject> getProjects() {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<InvolvedProject> involvedProjects = new ArrayList<InvolvedProject>();

		try {
			stmt = con
					.prepareStatement("SELECT * FROM project_involved_users where state = ?");
			stmt.setString(1, "host_agree");
			result = stmt.executeQuery();

			while (result.next()) {
				involvedProjects
						.add(new InvolvedProject(result.getInt("p_id"), result
								.getInt("identifier"), result
								.getString("p_name"),
								result.getDouble("money"), result
										.getDouble("device_ratio"), result
										.getDouble("device_ratio"), result
										.getDouble("others_ratio"), result
										.getDate("start_time"), result
										.getDate("end_time"), result
										.getString("state"), result.getDouble("expense"), result.getString("host_name")));
			}

			return involvedProjects;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}

		return null;
	}

	@Override
	public boolean updateState(int p_id, int c_id, String state) {
		Connection con = daoHelper.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE project_involved_users SET state = ? WHERE identifier = ? and p_id = ?");
			stmt.setString(1, state);
			stmt.setInt(2, c_id);
			stmt.setInt(3, p_id);
			
			if(stmt.executeUpdate() != 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		
		return false;
	}

}
